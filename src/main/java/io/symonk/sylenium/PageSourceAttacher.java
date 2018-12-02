package io.symonk.sylenium;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

public class PageSourceAttacher {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PageSourceAttacher.class);

    private final WebDriver driver;

    PageSourceAttacher(final WebDriver driver) {
        this.driver = driver;
    }

    @Attachment(value = "Page Source", type = "text/plain")
    public String getPageSourceAsAttachment() {
        log.info(("Adding pagesource: Failed page source"));
        return driver.getPageSource();
    }


}
