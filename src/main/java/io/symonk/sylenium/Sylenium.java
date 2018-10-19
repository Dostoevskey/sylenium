package io.symonk.sylenium;

import io.symonk.sylenium.ex.NoSuchLanguageFileException;
import io.symonk.sylenium.ex.NoSuchLocalisedPropertyException;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Sylenium {
  private static Sylenium $y;

  private final Logger log = Logger.getLogger(getClass().getName());
  private final ConcurrentHashMap<String, String> localisationResources = new ConcurrentHashMap<>(128);
  private static final SyleniumConfig config = new io.symonk.sylenium.SyleniumConfig();
  private static final String NO_SUCH_FILE_ERROR = "Localisation file was not found under test/resources/localisation/: " + config.language();
  private String cachedConfig;

  private Sylenium() {}

  public static synchronized Sylenium getInstance() {
    if ($y == null) {
      $y = new Sylenium();
      $y.cachedConfig = config.language();
      $y.buildRuntimeLanguageProperties();
    }
    return $y;
  }


  public String localised(final String key) {
      if(!config.language().equalsIgnoreCase(cachedConfig)) {
          cachedConfig = config.language();
          buildRuntimeLanguageProperties();
      }
      return Optional.ofNullable(localisationResources.get(key)).orElseThrow(() -> new NoSuchLocalisedPropertyException(String.format("The property %s did not exist in %s", key, cachedConfig)));
  }

  private Sylenium buildRuntimeLanguageProperties() {
    final Properties props = new Properties();
    InputStream is = null;
    try {
      is =
          Optional.ofNullable(getClass().getClassLoader().getResourceAsStream(cachedConfig))
              .orElseThrow(() -> new NoSuchLanguageFileException(NO_SUCH_FILE_ERROR));
      props.load(is);
      convertPropertiesToMap(props);
    } catch (final IOException ex) {
      log.info(NO_SUCH_FILE_ERROR + config.language());
    } finally {
      closeQuietly(is);
    }
    return this;
  }

  private Sylenium convertPropertiesToMap(final Properties properties) {
    localisationResources.putAll(
        properties
            .entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    element -> element.getKey().toString(),
                    element -> element.getValue().toString())));
    return this;
  }

  private Sylenium closeQuietly(final Closeable closable) {
    if (closable != null) {
      try {
        closable.close();
      } catch (final IOException ex) {
        // ignored on purpose.
      }
    }
    return this;
  }
}
