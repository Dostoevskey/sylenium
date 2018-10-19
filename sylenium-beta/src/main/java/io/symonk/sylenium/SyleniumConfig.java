package io.symonk.sylenium;


public class SyleniumConfig implements Config {

    private String languageFile = System.getProperty("sylenium.language.file", "english.properties");

    @Override
    public String language() {
        return languageFile;
    }

    public SyleniumConfig language(final String languageFile) {
        this.languageFile = languageFile;
        return this;
    }
}
