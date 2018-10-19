package io.github.symonk.selenide.custom_listeners;

import com.codeborne.selenide.logevents.SelenideLogger;
import org.slf4j.Logger;

public class CustomSelenideLogger extends SelenideLogger {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CustomSelenideLogger.class);

    public static void setListenerLogFile(final String testName) {
    final CustomListener listener = (CustomListener) listeners.get().get("CustomListener");
    listener.setCurrentLog(testName);
    CustomSelenideLogger.addListener("CustomListener", listener);
  }
}
