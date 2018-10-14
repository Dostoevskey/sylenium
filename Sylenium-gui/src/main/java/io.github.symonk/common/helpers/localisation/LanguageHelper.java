package io.github.symonk.common.helpers.localisation;

import io.github.symonk.common.enumerations.SupportedLanguage;
import io.github.symonk.configurations.properties.SyleniumProperties;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.util.ResourceBundle;

public class LanguageHelper implements ProvidesLanguageValues {

  private static final String DEFAULT_DIRECTORY = "localisation.";
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LanguageHelper.class);
    private final SupportedLanguage language;

  @Inject
  public LanguageHelper(final SyleniumProperties properties) {
    language = SupportedLanguage.getLanguage(properties.language());
  }

  @Override
  public String getResource(final String key) {
    return ResourceBundle.getBundle(
            DEFAULT_DIRECTORY + language.getResourceFile(), language.getLocale())
        .getString(key);
  }
}
