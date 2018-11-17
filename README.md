![](/.github/.images/sylenium.png)

[![Build Status](https://api.travis-ci.org/symonk/sylenium.svg?branch=master)](https://travis-ci.org/symonk/sylenium)
[![License MIT](https://img.shields.io/badge/License-MIT-brightgreen.svg)](https://github.com/symonk/selenide-testng-allure2-test-automation-framework/blob/master/LICENSE)
[![Sonar Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=io.symonk.sylenium%3Asylenium&metric=alert_status)](https://sonarcloud.io/dashboard?id=io.symonk.sylenium%3Asylenium)
[![Sonar Code Coverage](https://sonarcloud.io/api/project_badges/measure?project=io.symonk.sylenium%3Asylenium&metric=coverage)](https://sonarcloud.io/component_measures?id=io.symonk.sylenium%3Asylenium&metric=coverage)
[![Sonar Maintainability](https://sonarcloud.io/api/project_badges/measure?project=io.symonk.sylenium%3Asylenium&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=io.symonk.sylenium%3Asylenium)
[![Find_Me LinkedIn](https://img.shields.io/badge/Find_Me-LinkedIn-brightgreen.svg)](https://www.linkedin.com/in/simonk09/)
[![Find_Me Slack](https://img.shields.io/badge/Find_Me-Slack-brightgreen.svg)](https://testersio.slack.com)

## Sylenium-framework :flags: :star:

Sylenium, one framework to rule them all.  The goal of sylenium is simple, if you have a test automation project to do in java for a web application then Sylenium will get you off the ground in less than 5 minutes.
All you need is a few simple things, things that we can't do for you unfortunately.

1. Create a project with our archetype
2. Define your own PageObjects for your app
3. Define your own Business logic for tests
4. Run the tests

No hassle, no fuss, no messing around with boilerplate code, no messing around with pulling dependencies together and wiring them all up.  Sylenium has you covered.

*Sorry folks, Test automation is in general plagued with bad practice.  If you do one thing from visiting this page, please read the guidelines below.*

---

# :earth_africa: Framework stack

| Technology | Description | Link
| ------------- | ------------- | -------------
| **Java**  | Programming language)  | [@Java](https://java.com/en/download/)
| **TestNG**  | Test framework for test ecosystem  | [@TestNG](http://testng.org/doc/)
| **Selenium WebDriver**  | Browser manipulation  | [@Selenium](https://www.seleniumhq.org/)
| **Rest Assured**  | Restful API DSL  | [@Rest Assured](http://rest-assured.io/)
| **AssertJ**  | Powerful assertsions library  | [@AssertJ](http://joel-costigliola.github.io/assertj/)
| **Maven**  | Build compilation, Dependency mgmt & test execution  | [@Maven](https://maven.apache.org/)
| **JFaker** | Data Generator (when applicable) | [@JFaker](https://github.com/sgianelli/JFaker)
| **Logback** | Logging framework | [@Logback](https://logback.qos.ch/)
| **Bespoke Reporting** | Dashboard of test results and debug data | [@Allure Reporting](https://github.com/allure-framework/allure2)
| **Guice** | Dependency injection | [@Guice](https://github.com/google/guice)
| **Automation Assistant** | Framework assistance by me | [Automation Assistant](https://github.com/symonk/Automation-Assistant)
| **Selenium Grid** | Distributed testing | [@Selenium Grid](https://www.seleniumhq.org/docs/07_selenium_grid.jsp)
| **Lombok** | Removal of boilerplate code | [@Lombok](https://projectlombok.org/download)
| **Owner** | Properties management | [@Owner](http://owner.aeonbits.org/)
| **Selenide** | Selenium wrapper | [@Selenide](http://http://selenide.org)

---

# :earth_africa: Framework functionality?
This framework provides a serious amount of functionality right out of the box.

```
-> Driver and Page Factory free page objects.
-> Localisation support for multi lingual applications, simply use the localisation helper to read your values from .properties files.
-> Powerful DSL powered by selenide to manage driver manipulation and powerful assertions.
-> Robust test automation properties out of the box.
-> Bespoke, beautiful reporting powered by Allure2, simply add @Step annotations in your page objects and thats it! or @Step anywhere for that matter.
-> Robust mechanisms for webdriver management, we handle all downloading, setup and execution at the switch of a property.
-> Run locally or distributed on selenium grid with the flip of a switch.
-> Customised test-ng listeners to capture and manage test flow out of the box.
-> Comes complete with jenkins example scripts.
-> Multi threaded logging per test.
-> 100% easily configurable settings for allure, properties, logging, webdriver management.
-> Dependency injection capabilities powered by google Guice.
-> Wealth of helpers, exceptions, annotations and interfaces.
-> Jira (cloud) integration to automatically manage test awareness (@wip).
-> Slack integration to automatically manage notifications.
-> Hipchat integration to automatically manage notifications.
-> Customised test failure data (stacktrace, screenshot, pagesource, logs) automatically in the report.
-> Capturing .har performance data using a proxy (BrowserMob) available at the flip of a switch.
-> Selenide custom conditions and listeners.
-> Example tests and page objects to give you an example of how to get started.
-> Easy out of the box element containers (Custom page objects like tables etc) powered by Selenide.
-> Wired together for you, using maven.
-> Supports 2 languages out of the box, with easy capabilities to add more.
-> Simple .bat files to run locally straight away. (Windows)
-> Simple .sh files to run locally straight away. (Linux)
-> Maven module for performance testing powered by Maven Jmeter.
-> Maven module for api-testing, includes some example tests.
-> Easy serialization of test data into the report.
```
---

###  :star: Backers of the project who provide us with free tools:

[![Intellij IDEA](https://cloud.google.com/tools/images/icon_IntelliJIDEA.png)](http://www.jetbrains.com/idea)
[![BrowserStack](https://www.browserstack.com/images/mail/browserstack-logo-footer.png)](https://www.browserstack.com)

---

### Attributions! :star:

Here are all the great freebie / open-source things I have used as part of building $ylenium.  A massive thanks to the following:

- https://www.designevo.com (cool logos creator)

