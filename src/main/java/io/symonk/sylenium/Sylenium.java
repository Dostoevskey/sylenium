package io.symonk.sylenium;

import com.codeborne.selenide.Selenide;
import io.symonk.sylenium.annotation.StartUrl;
import io.symonk.sylenium.command.Commands;
import io.symonk.sylenium.contracts.ConfigObserver;
import io.symonk.sylenium.contracts.SyleniumObject;
import io.symonk.sylenium.impl.PropertyManager;
import org.openqa.selenium.By;

public enum Sylenium implements ISylenium {

  INSTANCE;

  private static final PropertyManager PROPERTY_MANAGER = new PropertyManager();
  private static final ResourceReader LOCAL_VALUE_READER = new ResourceReader(PROPERTY_MANAGER);
  private static final ThreadLocal<SyleniumWorld> WORLD = ThreadLocal.withInitial(SyleniumWorld::new);
  private static final Commands COMMANDS = Commands.INSTANCE;

  @Override
  public String localisedValueOf(final String key) {
    return COMMANDS.execute("localisedValueOf", new Object[]{LOCAL_VALUE_READER, key});
  }

  @Override
  public <T extends SyleniumObject> Sylenium registerWorldObject(final T testData) {
     COMMANDS.execute("registerWorldObject", new Object[] {WORLD.get(), testData});
     return this;
  }

  @Override
  public <T extends SyleniumObject> Sylenium unregisterWorldObject(final T testData) {
    COMMANDS.execute("unregisterWorldObject", new Object[] {WORLD.get(), testData});
    return this;
  }

  @Override
  public Sylenium cleanUpWorld() {
    COMMANDS.execute("cleanUpWorld", new Object[]{WORLD.get()});
    return this;
  }

  @Override
  public int getWorldItemCount() {
    return COMMANDS.execute("getWorldItemCount", new Object[]{WORLD.get()});
  }

  @Override
  public String getProperty(final String propertyKey) {
    return COMMANDS.execute("getProperty", new Object[]{PROPERTY_MANAGER, propertyKey});
  }

  @Override
  public Sylenium updateProperty(final String propertyKey, final String newValue) {
    COMMANDS.execute("updateProperty", new Object[]{PROPERTY_MANAGER, propertyKey, newValue});
    return this;
  }

  @Override
  public By localisedLinkTextOf(final String languageKey) {
    return COMMANDS.execute("exactLinkText", new Object[]{LOCAL_VALUE_READER, languageKey});
  }

  @Override
  public By localisedPartialLinkTextOf(final String languageKey) {
    return COMMANDS.execute("partialLinkText", new Object[]{LOCAL_VALUE_READER, languageKey});
  }

  @Override
  public <T extends ConfigObserver> Sylenium addConfigObserver(final T observer) {
    return COMMANDS.execute("addConfigObserver", new Object[]{PROPERTY_MANAGER, observer});
  }

  @Override
  public <T extends ConfigObserver> Sylenium removeConfigObserver(final T observer) {
    return COMMANDS.execute("removeConfigObserver", new Object[]{PROPERTY_MANAGER, observer});
  }

  @Override
  public int getConfigObserverCount() {
    return COMMANDS.execute("getConfigObserverCount", new Object[]{PROPERTY_MANAGER});
  }

  @Override
  public <T> T start(final Class<T> pageObjectClassClass) {
    final String title = pageObjectClassClass.getAnnotation(StartUrl.class).url();
    return Selenide.open(title, pageObjectClassClass);
  }

  @Override
  public String getName() {
    return COMMANDS.execute("getName", new Object[]{});
  }

  @Override
  public String getLastName() {
    return COMMANDS.execute("getLastName", new Object[]{});
  }

  @Override
  public String getFirstName() {
    return COMMANDS.execute("getFirstName", new Object[]{});
  }





}
