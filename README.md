![](/.github/.images/sylenium.png)

[![Build Status](https://api.travis-ci.org/symonk/sylenium.svg?branch=master)](https://travis-ci.org/symonk/sylenium)
[![License MIT](https://img.shields.io/badge/License-MIT-brightgreen.svg)](https://github.com/symonk/selenide-testng-allure2-test-automation-framework/blob/master/LICENSE)
[![Sonar Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=io.symonk.sylenium%3Asylenium&metric=alert_status)](https://sonarcloud.io/dashboard?id=io.symonk.sylenium%3Asylenium)
[![Sonar Code Coverage](https://sonarcloud.io/api/project_badges/measure?project=io.symonk.sylenium%3Asylenium&metric=coverage)](https://sonarcloud.io/component_measures?id=io.symonk.sylenium%3Asylenium&metric=coverage)
[![Sonar Maintainability](https://sonarcloud.io/api/project_badges/measure?project=io.symonk.sylenium%3Asylenium&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=io.symonk.sylenium%3Asylenium)
[![Find_Me LinkedIn](https://img.shields.io/badge/Find_Me-LinkedIn-brightgreen.svg)](https://www.linkedin.com/in/simonk09/)
[![Find_Me Slack](https://img.shields.io/badge/Find_Me-Slack-brightgreen.svg)](https://testersio.slack.com)

## What is Sylenium? :flags: 

Sylenium is a test automation harness for web applications written in java.  Why spend time fussing around
boilerplate code and instability in your end to end tests, Sylenium takes care of it.

### :earth_africa: Getting started

1. Create a new project using our maven archetype
2. Implement your application specific code (leave the mundane stuff to us)
3. Incorporate your tests into a pipeline or run locally with ease!
4. Deliver results, effectively.

--- 

## Features of Sylenium :flags:

--- 

### :earth_africa: Managed Logging capabilities on a per test basis
Sylenium takes care of log management by providing custom annotations for tests and sensible assumed defaults.

- By default sylenium stores one log per test execution
- By default sylenium only stores logs which pass
- By default sylenium uses the testNG method name as the logger name

Below is an example of how you can configure your tests on a test by test basis to override such values.  Sylenium is
smart enough to handle invocationCount usage of testNG by using the iteration as part of the log file name.

```java
  @Test
  @ConfigureLog(name = "custom-name", splitLogFiles = false, keepFailures = true)
  public void canUpdateAndGetProperties() {
    sy.updateProperty("sy.enable.localisation", "true");
    assertThat(sy.getProperty("sy.enable.localisation")).isEqualTo("true");
  }
  ```

---

##  :star: Backers of the project who provide us with free tools:

[![Intellij IDEA](https://cloud.google.com/tools/images/icon_IntelliJIDEA.png)](http://www.jetbrains.com/idea)
[![BrowserStack](https://www.browserstack.com/images/mail/browserstack-logo-footer.png)](https://www.browserstack.com)

---

### Attributions! :star:

Here are all the great freebie / open-source things I have used as part of building $ylenium.  A massive thanks to the following:

- Nothing... (yet!)

