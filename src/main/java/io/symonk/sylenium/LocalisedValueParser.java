package io.symonk.sylenium;

import io.symonk.sylenium.ex.NoSuchLanguageFileException;
import io.symonk.sylenium.ex.NoSuchLocalisedPropertyException;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class LocalisedValueParser {
  private final Logger log = Logger.getLogger(getClass().getName());

  private String localisationFile;
  private Map<String, String> resources = new HashMap<>();
  private static final String NO_SUCH_FILE_ERROR = "Localisation file was not found under test/resources/localisation/: ";


  public LocalisedValueParser(final String localisationFile) {
    this.localisationFile = localisationFile;
    buildRuntimeLanguageProperties();
  }

  public String localised(final String key) {
    return Optional.ofNullable(resources.get(key)).orElseThrow(() -> new NoSuchLocalisedPropertyException(String.format("The property %s did not exist in %s", key, localisationFile)));
  }

  private void buildRuntimeLanguageProperties() {
    final Properties props = new Properties();
    InputStream is = null;
    try {
      is =
              Optional.ofNullable(getClass().getClassLoader().getResourceAsStream(localisationFile))
                      .orElseThrow(() -> new NoSuchLanguageFileException(NO_SUCH_FILE_ERROR));
      props.load(is);
      convertPropertiesToMap(props);
    } catch (final IOException ex) {
      log.info(NO_SUCH_FILE_ERROR +localisationFile);
    } finally {
      closeQuietly(is);
    }
  }

  public LocalisedValueParser setLocalisationFile(final String localisationFile) {
    this.localisationFile = localisationFile;
    buildRuntimeLanguageProperties();
    return this;
  }

  private void convertPropertiesToMap(final Properties properties) {
    resources.putAll(
            properties
                    .entrySet()
                    .stream()
                    .collect(
                            Collectors.toMap(
                                    element -> element.getKey().toString(),
                                    element -> element.getValue().toString())));
  }

  private void closeQuietly(final Closeable closable) {
    if (closable != null) {
      try {
        closable.close();
      } catch (final IOException ex) {
        // ignored on purpose.
      }
    }
  }
}