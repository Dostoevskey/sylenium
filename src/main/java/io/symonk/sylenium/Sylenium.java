package io.symonk.sylenium;

import io.symonk.sylenium.command.Commands;
import io.symonk.sylenium.impl.PropertyManager;
import io.symonk.sylenium.interfaces.ConfigObserver;
import io.symonk.sylenium.interfaces.SyleniumObject;
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
     COMMANDS.execute("registerWorldObject", new Object[] {WORLD, testData});
     return this;
  }

  @Override
  public <T extends SyleniumObject> Sylenium unregisterWorldObject(final T testData) {
    COMMANDS.execute("unregisterWorldObject", new Object[] {WORLD, testData});
    return this;
  }

  @Override
  public Sylenium cleanUpWorld() {
    COMMANDS.execute("cleanUpWorld", new Object[]{WORLD});
    return this;
  }

  @Override
  public int getWorldItemCount() {
    return COMMANDS.execute("getWorldItemCount", new Object[]{WORLD});
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
    return COMMANDS.execute("exactLinktext", new Object[]{languageKey});
  }

  @Override
  public By localisedPartialLinkTextOf(final String languageKey) {
    return COMMANDS.execute("partialLinkText", new Object[]{languageKey});
  }

  @Override
  public <T extends ConfigObserver> Sylenium addConfigObserver(final T observer) {
    return COMMANDS.execute("addConfigObserver", new Object[]{PROPERTY_MANAGER, observer});
  }

  @Override
  public <T extends ConfigObserver> Sylenium removeConfigObserver(final T observer) {
    return COMMANDS.execute("removeConfigObservers", new Object[]{PROPERTY_MANAGER, observer});
  }

  @Override
  public int getConfigObserverCount() {
    return COMMANDS.execute("getConfigObserverCount", new Object[]{});
  }

  @Override
  public <T> T start(final T pageObjectClass) {
    return COMMANDS.execute("start", new Object[]{pageObjectClass});
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
