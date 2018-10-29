package io.symonk.sylenium;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class SyleniumAsciiParser {

    public static void parseAscii() {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(Objects.requireNonNull(SyleniumAsciiParser.class.getClassLoader().getResource("ascii.txt")).getFile())))) {
            String line;
            System.out.println("\n*******************************************************");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("******************************************************** \n");
        } catch (IOException e) {
            System.out.println("Ascii file cannot be found, continuing without it");
        }
    }

}
