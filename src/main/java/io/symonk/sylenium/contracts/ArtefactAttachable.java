package io.symonk.sylenium.contracts;

public interface ArtefactAttachable {

    void attachPageSourceToReport();
    void attachTestLogToReport(final String testname);
    void attachFailureScreenshot();

}
