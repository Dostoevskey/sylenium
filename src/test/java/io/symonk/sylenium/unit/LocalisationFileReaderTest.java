package io.symonk.sylenium.unit;

import io.symonk.sylenium.ex.NoSuchLanguageFileException;
import io.symonk.sylenium.impl.LocalisationFileReader;
import io.symonk.sylenium.interfaces.SyleniumConfig;
import org.mockito.Mock;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocalisationFileReaderTest {

  private LocalisationFileReader fileReader = new LocalisationFileReader();
  @Mock private SyleniumConfig config = mock(SyleniumConfig.class);

  @Test(expectedExceptions = NoSuchLanguageFileException.class)
  public void missingLanguageFileThrowsNoSuchLanguageFileException() {
    when(config.localisationFile()).thenReturn("missing.properties");
    fileReader.update(config);
  }

  @Test
  public void canReadResourceFile() {
    when(config.localisationFile()).thenReturn("english.properties");
    fileReader.update(config);
    assertThat(fileReader.getLanguageValue("two")).isEqualTo("2");
  }
}
