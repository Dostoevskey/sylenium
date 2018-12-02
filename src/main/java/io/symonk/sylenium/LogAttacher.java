package io.symonk.sylenium;

import io.qameta.allure.Attachment;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class LogAttacher {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LogAttacher.class);
    private final WebDriver driver;

    LogAttacher(final WebDriver driver) {
        this.driver = driver;
    }

    @Attachment(value = "Test Log", type = "application/json")
    public byte[] getJsonLogAsAttachment(String testName) throws IOException {
        File[] files = listFilesMatching(new File("target" + File.separator + "test_logs" + File.separator), testName + "-.*\\.json");
        log.info("Adding log file: " + files[0].getPath());
        return Files.readAllBytes(Paths.get(files[0].getAbsolutePath()));
    }

    private File[] listFilesMatching(@NotNull File root, String regex) {
        if (!root.isDirectory()) {
            throw new IllegalArgumentException(root + " is not a directory.");
        }
        final Pattern p = Pattern.compile(regex);
        return root.listFiles(file -> p.matcher(file.getName()).matches());
    }
}
