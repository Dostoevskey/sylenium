![](/.github/.images/sylenium2.png)

[![Build Status](https://api.travis-ci.org/symonk/sylenium.svg?branch=master)](https://travis-ci.org/symonk/sylenium)
[![License MIT](https://img.shields.io/badge/License-MIT-brightgreen.svg)](https://github.com/symonk/selenide-testng-allure2-test-automation-framework/blob/master/LICENSE)
[![Sonar Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=io.symonk.sylenium%3Asylenium&metric=alert_status)](https://sonarcloud.io/dashboard?id=io.symonk.sylenium%3Asylenium)
[![Sonar Code Coverage](https://sonarcloud.io/api/project_badges/measure?project=io.symonk.sylenium%3Asylenium&metric=coverage)](https://sonarcloud.io/component_measures?id=io.symonk.sylenium%3Asylenium&metric=coverage)
[![Sonar Maintainability](https://sonarcloud.io/api/project_badges/measure?project=io.symonk.sylenium%3Asylenium&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=io.symonk.sylenium%3Asylenium)
[![Find_Me LinkedIn](https://img.shields.io/badge/Find_Me-LinkedIn-brightgreen.svg)](https://www.linkedin.com/in/simonk09/)
[![Find_Me Slack](https://img.shields.io/badge/Find_Me-Slack-brightgreen.svg)](https://testersio.slack.com)

## Sylenium-framework :flags: :star:

Are you looking for the old sylenium project? it is now hosted here at a sister organisation -> https://github.com/Sylenium/sylenium

**note:** Sylenium is still under heavy development and is not remotely close to feature complete, nor does the documentation match up fully with implemented functionality.

The aim of Sylenium is simple, one dependency to rule them all.  Using our maven arche command to start a project off you will be able to get up to speed extremely fast.  All you
need is 3 things, web app specific things.

1. Create a project with our archetype
2. Define your own PageObjects for your app (we can't do that for you sorry!)
3. Define your own Business logic for tests (we can't do that for you either sorry!!)
4. Run the tests

No hassle, no fuss, no messing around with boilerplate code, no messing around with pulling dependencies together and wiring them all up.  Sylenium has you covered.

*Sorry folks, Test automation is in general plagued with bad practice.  If you do one thing from visiting this page, please read the guidelines below.*

---

### :crossed_flags: Writing pointless short tests :crossed_flags:

This framework should be used to test end to end flows of your application under no isolation of the stack.  Writing tests for simple ui
functionality such as buttons being clickable, dropdown having values etc should be done by component tests.  Modern frameworks make this a piece of cake (angular, react etc).

---

### :crossed_flags: Only automating at the ui layer :crossed_flags:

Using this test automation harness as your only automated tests.  Focus on unit and integration tests as a primary method of coverage.

---

### :crossed_flags: Writing garbage locators :crossed_flags:

Using google chrome `copy-as-xpath` and using it directly etc.  Favour adding unique identifiers to your frontend to aid with automation.  `data-` attributes etc can be extremely useful.
Using complex xpaths will end in hassle later, and please account for the page state being different later with parallel tests running.  Your useless xpath locator finding row 3 in a table won't 
work later when 10 parallel tests have flooded the table data!

---

### :crossed_flags: Overcomplicating page objects :crossed_flags:

The beauty of this framework is we have **NO** driver or page factory code in our page objects, its all handled behind the scenes using custom reflection and java dynamic proxies, coupled with smart webdriver management.
Keep your page objects simple, exposing a fluent interface for the tests to consume.  Always remember a page object is **NOT** equal to a page `!=`.  A page object can encapsulate a simple
dropdown on a page, which can be injected or reused as part of another page object.  `KISS`.

---

### :crossed_flags: Managing test data poorly :crossed_flags:

Managing test data using this harness itself through the ui for example, terrible practice.  Hopefully you have or can get access to some cool restful services to help you manage the data.  Managing test data
is most certainly not easy and becomes a behemoth over time.  The debate of randomising data is a long going one.  Please dont use your browsers for prepping and tearing down test data.  I don't even like direct database manipulation either,
from experience you will spend too long doing maintenance.

---

### :crossed_flags: Running sequential tests :crossed_flags:

Write your tests with parallelisation in mind.  Independent tests aren't enough, consider cross contamination (`system wide settings`) contaminating your tests at runtime.  For example if test A modifies
a system wide setting it can impact other tests, even though they are not remotely reliant on each other.  Multi tenancy applications can really help with this, otherwise run a `@NotThreadSafe` run at the end of your run.
If you are running one test at a time.

---

### :crossed_flags: Pointless noise in page objects :crossed_flags:

Page objects should encapsulate user actions grouped together, not individual actions that interact on a per element basis.  Writing a `Login();` method is better than writing 3 methods to do the steps of logging in.

---

### :crossed_flags: Using field injection :crossed_flags:

Using field injection with any sort of DI mechanism. Yes its easier, but it sucks.  Its gimmicky magic, decreases class testability, masks design errors with large classes.  When you inject into the field often you will 
not see beefy constructors that can prompt you to do some refactoring.

---

### :crossed_flags: Not using CI :crossed_flags:

Running tests locally is easy, get your tests into a scalable distributed execution mechanism within a CI pipeline. **note:** running locally is very useful, we can guard our feature branches that way. CI can help guard master PRs and production

---

### Please contribute!

Now that we have that out of the way, I would also like that you create atleast 1 pull request to the selenide project when using this framework.  You can find the repository here:

https://github.com/codeborne/selenide

and ofcourse, open PRs here

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

# :earth_africa: Getting started?

In order to get started you should clone this repository and remove all test(s) around the Puppy adoption webpage, we use this just to demonstrate the testing capabilities.
Alternatively you can fork this repo and work from there.

```
install git bash
install jdk8+
install maven 3.5.2+
type -> git clone https://github.com/symonk/selenide-testng-allure2-test-automation-framework.git
run ui_regression_parallel_chrome.bat to see the tests running in parallel! or alternatively:
import the project into intellij
install lombok intellij plugin and enable annotation-processing in intellij (important)
install the allure command line tool for reporting capabilities (important)

Allure can be installed on mac using homebrew -> brew install allure or via downloading on windows and adding the /bin directory to your PATH variables

```

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

### :earth_africa: Localised link text lookup
Looking up linkText by a static value is really bad practice, if your application is multilingual links may change their text.  Sylenium
provides you a method of using the runtime language of Sylenium to automagically retrieve the localised value.  All you need to do is specify your
language to the sylenium.properties file and then define your localisation file(s).  After those are defined, just simple pass the *Key* value for the lookup
into the localisedLinkText method.
```java
    @Test
    public void canElementByLocalisedText() {
        sylenium.launch("http://toolsqa.com/automation-practice-form/", MyPageObject.class);
        sylenium.localisedLinkText("partial.link.text").shouldBe(visible);
    }
    
```

```
    <-- Localisation example file -->
    one=1
    two=2
    three=3
    partial.link.text=Partial Link Test
```

---

### :earth_africa: Managing your own models/test data objects in the report
Attach any object in pretty json format easily with Sylenium! simply tell Sylenium to add your attachment and pass in your object instance! :) 

```java
@Attachable(name = PuppyModel.json)
public class MyModel {

    private final String mySomething;
    
    public myModel(final String something) {
        mySomething = something;
        Sylenium.addAttachment(this);
    }
}
```
**Want a dynamic model name at runtime?**
```java
@Attachable(name = PuppyModel.json) //<-- overridden by overloaded addAttachment method
public class MyModel {

    private final String mySomething;
    
    public myModel(final String something) {
        mySomething = something;
        Sylenium.addAttachment(this, "someDynamicName");
    }
}
```

---

### :earth_africa: How can I configure a communication strategy?
Sylenium supports both `@Test` level notifications or Class level, both are configured using the `@Notify` annotation (see more below).
The supported levels for communication strategy are `NONE, SLACK, HIPCHAT` respectfully.
You should always use these with caution, especially on free slack instances with message caps and hipchat rate limiting is in place.
 
### :star: Slack configuration

- Go to your_team.slack.com/services/new
- Search for incoming webHook and click in Add
- Choose strategy to post and press add incoming webhooks integration
- Set the slack url framework property
- Set the communication strategy property to `SLACK`
- Both of these properties are required, they can be set at runtime using standard maven -Dcommunication.strategy=SLACK etc

### :star: Hipchat configuration

- Navigate to your rooms tokens page `/rooms/tokens/1234` <-- 1234 being a room number
- Create a new token for `Send Notifications` only and provide a label name
- Set the framework.properties file strategy to `HIPCHAT` and provide both channel and token in the appropriate fields

Once you have configured either or (or both!) then you can simply enable any tests with @Notify for test information to be notified to the communication strategy.  This is managed by Syleniums TeamCommunicator object.  note: it is possible that it can output to both channels.  I would also be cautious of spam caused by this.

**note:** Sylenium does some checking based on configuration properties and if anything is not correct it will default to no strategy for communications.
for example, a non valid URL for the slack url or an empty access token for hipchat will default immediately to a `NONE` communication strategy.

There are a few different methods of configuration notifications. 
`@Notify` is supported at the method level.  pass in any value you wish and the desired message will be sent to your communications channel.


```java
public class NotifyMyTest {

    @Test
    @Notify(message = "Some cool message for the communications channel!")
    public void notifyTest() {
        //hello world
    }  
}
```
---

### :star: Zephyr Jira Integration (Jira Cloud only)

Sylenium supports zephyr integration right out of the box, all you need to do is configure a few framework properties in your respective module.
Using `@TmsLink` annotations on the test cases makes it super easy, these should be a mapping to zephyr test case ids.
Enable zephyr configurations in the properties and configure example tests like so:

**note:** Jira cloud does not support zephyr tests for modern agile projects.  Old style kanban etc works perfectly.

```java
  @Test(description = "Hannah can be adopted")
  @Story("As a customer, I can adopt Hannah without any options")
  @Issue("ISS-001")
  @TmsLink("1") // <-- like so :)
  @Severity(SeverityLevel.CRITICAL)
  public void adoptingHannahWithoutAnyOptions() {
         open("http://puppies.herokuapp.com/", PuppyAdoptionHomePage.class)
        .viewHannahDetails()
        .adoptPuppy()
        .completeTheAdoption()
        .fillInOrderDetails(orderProvider.createRandomOrder())
        .messageIsDisplayed("successful.adoption.message"));
  }

```

---

### :star: Localisation In Your Tests

We all know that using LinkText explicitly or using hard coded strings for ui tests that may change under a difference language are flaky and known to break.  Any time you need a localised value in your tests
Sylenium comes straight to the rescue.  Marking a test with @RequiresLocalisation will provide you with a simple way in your tests to get localised values.
These are determined by your framework properties at runtime for language(s).  For example:

```java
  @Test(description = "Hannah can be adopted")
  @Story("As a customer, I can adopt Hannah without any options")
  @Issue("ISS-001")
  @TmsLink("1")
  @Severity(SeverityLevel.CRITICAL)
  @RequiresLocalisation
  public void adoptingHannahWithoutAnyOptions() {
         open("http://puppies.herokuapp.com/", PuppyAdoptionHomePage.class)
        .viewHannahDetails()
        .adoptPuppy()
        .completeTheAdoption()
        .fillInOrderDetails(orderProvider.createRandomOrder())
        .messageIsDisplayed(languageHelper.getResource("successful.adoption.message"));
  }
 ```

---

### :star: Unix SSH command support

Sylenium now boasts the ability to connect via ssh and issue unix commands on a remote system, returning you the value.  We support a variant of commands
out of the box, but its easy to make your own.  Simply implement Command and using AOP we will put all the commands into the system for use!

```java
    @Slf4j
    public class Ls implements Command<String[]> {

        private final SyUnix syUnix;

        @Inject
        public Ls(final SyUnix syUnix) {
            this.syUnix = syUnix;
        }

        @Override
        public String[] execute(SyUnix syUnix) throws IOException {
            return this.execute(syUnix);
        }
    }
```

---

### Open source supporters of the project (Many thanks for these free tools to aid in making open source better)

[![Intellij IDEA](https://cloud.google.com/tools/images/icon_IntelliJIDEA.png)](http://www.jetbrains.com/idea)
[![BrowserStack](https://www.browserstack.com/images/mail/browserstack-logo-footer.png)](https://www.browserstack.com)

---

### Attributions! :star:

Here are all the great freebie / open-source things I have used as part of building $ylenium.  A massive thanks to the following:

- https://www.designevo.com (cool logos creator)

