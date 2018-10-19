package io.github.symonk.common.enumerations;

import org.slf4j.Logger;

import java.util.Locale;

/**
 * Supported framework languages, used for decoupling visual text assertions and locators from
 * hardcoded test data
 */
public enum SupportedLanguage {
  ENGLISH("english", "en"),
  FRENCH("french", "fr");

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SupportedLanguage.class);
    private final String resourceFile;
  private final Locale locale;

  SupportedLanguage(final String resourceFile, final String locale) {
    this.resourceFile = resourceFile;
    this.locale = new Locale(locale);
  }

  public static SupportedLanguage getLanguage(final String language) {
    switch (language) {
      case "english":
        return ENGLISH;
      case "french":
        return FRENCH;
      default:
        return ENGLISH;
    }
  }

  public String getResourceFile() {
    return resourceFile;
  }

  public Locale getLocale() {
    return this.locale;
  }
}
