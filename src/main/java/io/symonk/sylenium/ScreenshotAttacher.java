package io.symonk.sylenium;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

public class ScreenshotAttacher {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ScreenshotAttacher.class);
    private final WebDriver driver;

    ScreenshotAttacher(final WebDriver driver) {
        this.driver = driver;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] getScreenshotAsAttachment() {
        log.info(("Adding screenshot: Failure screenshot"));
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
