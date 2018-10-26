package io.symonk.sylenium.impl;

import io.symonk.sylenium.ex.NoSuchLanguageFileException;
import io.symonk.sylenium.ex.NoSuchLocalisedPropertyException;
import io.symonk.sylenium.interfaces.ConfigObserver;
import io.symonk.sylenium.interfaces.SyleniumConfig;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

public class LocalisationFileReader implements ConfigObserver {

  private SyleniumConfig config;
  private Map<String, String> languageResources = new HashMap<>();

  @Override
  public void update(final SyleniumConfig config) {
    this.config = config;
    readLanguageResourcesFromFile();
  }

  public String getLanguageValue(final String key) {
    return Optional.ofNullable(languageResources.get(key))
        .orElseThrow(
            () -> new NoSuchLocalisedPropertyException("No such language property exists: " + key));
  }

  private void readLanguageResourcesFromFile() {
    final Properties temp = new Properties();
    languageResources.putAll(
        safelyFindFile(temp)
            .entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    element -> element.getKey().toString(),
                    element -> element.getValue().toString())));
  }

  private Properties safelyFindFile(final Properties props) {
    final String noSuchValue =
        String.format(
            "Language file %s does not exist in test/resources/localisation/",
            config.localisationFile());
    InputStream is = null;
    try {
      is = getClass().getClassLoader().getResourceAsStream(config.localisationFile());
      props.load(is);
      return props;
    } catch (final NullPointerException | IOException exception) {
      throw new NoSuchLanguageFileException(noSuchValue);
    } finally {
      closeQuietly(is);
    }
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
