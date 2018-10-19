package io.symonk.sylenium;


public class SyleniumConfig implements Config {

    private String languageFile;

    @Override
    public String language() {
        languageFile = System.getProperty("sylenium.language.file", "english.properties");
        return languageFile;
    }

    public SyleniumConfig language(final String languageFile) {
        this.languageFile = languageFile;
        return this;
    }

}
