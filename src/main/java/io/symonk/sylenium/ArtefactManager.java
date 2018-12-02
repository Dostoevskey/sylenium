package io.symonk.sylenium;

import io.symonk.sylenium.contracts.ArtefactAttachable;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

import java.io.IOException;

public class ArtefactManager implements ArtefactAttachable {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ArtefactManager.class);

    private final WebDriver driver;
    private final ScreenshotAttacher screenshotAttacher;
    private final LogAttacher logAttacher;
    private final PageSourceAttacher pageSourceAttacher;

    public ArtefactManager(final WebDriver driver) {
        this.driver = driver;
        this.screenshotAttacher = new ScreenshotAttacher(driver);
        this.logAttacher = new LogAttacher(driver);
        this.pageSourceAttacher = new PageSourceAttacher(driver);

    }

    @Override
    public void attachPageSourceToReport() {
        pageSourceAttacher.getPageSourceAsAttachment();
    }

    @Override
    public void attachTestLogToReport(final String testname) {
        try {
            logAttacher.getJsonLogAsAttachment(testname);
        } catch(IOException exception) {
            log.error("Unable to find the log file for the associated test {}, does it exist?", testname);
        }
    }

    @Override
    public void attachFailureScreenshot() {
        screenshotAttacher.getScreenshotAsAttachment();
    }
}
