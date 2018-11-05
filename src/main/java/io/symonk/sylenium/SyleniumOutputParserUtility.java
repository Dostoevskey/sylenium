package io.symonk.sylenium;

import io.symonk.sylenium.model.TestContainer;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;

@Slf4j
public class SyleniumOutputParserUtility {

    public static void parseAscii() {
        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(
                                     new File(
                                             Objects.requireNonNull(
                                                     SyleniumOutputParserUtility.class
                                                             .getClassLoader()
                                                             .getResource("ascii.txt"))
                                                     .getFile())))) {
            String line;
            log.info("*******************************************************");
            while ((line = br.readLine()) != null) {
                log.info(line);
            }
            log.info("********************************************************");
        } catch (IOException e) {
            log.info("Ascii file cannot be found, continuing without it");
        }
    }

    public static void parseResults(Set<TestContainer> results) {
        log.info("*******************************************************");
        log.info("Total number of tests: {}", results.size());
        log.info("Total number of passes: {}", results.stream().filter(entry -> entry.getStatus() == 1).count());
        log.info("Total number of failures: {}", results.stream().filter(entry -> entry.getStatus() == 2).count());
        log.info("Total number of skipped tests: {}", results.stream().filter(entry -> entry.getStatus() == 3).count());
        log.info("********************************************************");
    }
}
