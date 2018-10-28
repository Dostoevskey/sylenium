package io.symonk.sylenium;

import io.symonk.sylenium.command.Commands;
import io.symonk.sylenium.impl.PropertyManager;
import io.symonk.sylenium.interfaces.SyleniumObject;

public enum Sylenium implements ISylenium {

  INSTANCE;

  private static final PropertyManager PROPERTY_MANAGER = new PropertyManager();
  private static final ResourceReader localisationValueReader = new ResourceReader(PROPERTY_MANAGER);
  private static final ThreadLocal<SyleniumWorld> world = ThreadLocal.withInitial(SyleniumWorld::new);
  private static final Commands commands = Commands.INSTANCE;

  @Override
  public String localisedValueOf(final String key) {
    return commands.execute("localisedValueOf", new Object[]{localisationValueReader, key});
  }

  @Override
  public <T extends SyleniumObject> Sylenium registerWorldObject(final T testData) {
     commands.execute("registerWorldObject", new Object[] {world, testData});
     return this;
  }

  @Override
  public <T extends SyleniumObject> Sylenium unregisterWorldObject(final T testData) {
    commands.execute("unregisterWorldObject", new Object[] {world, testData});
    return this;
  }

  @Override
  public Sylenium cleanUpWorld() {
    commands.execute("cleanUpWorld", new Object[]{world});
    return this;
  }

  @Override
  public int getWorldSize() {
    return commands.execute("getWorldSize", new Object[]{world});
  }

  @Override
  public String getProperty(final String propertyKey) {
    return commands.execute("getProperty", new Object[]{PROPERTY_MANAGER, propertyKey});
  }

  @Override
  public Sylenium updateProperty(final String propertyKey, final String newValue) {
    commands.execute("updateProperty", new Object[]{PROPERTY_MANAGER, propertyKey, newValue});
    return this;
  }

  @Override
  public <T> T start(final T pageObjectClass) {
    return commands.execute("start", new Object[]{pageObjectClass});
  }

  @Override
  public String getName() {
    return commands.execute("getName", new Object[]{});
  }

  @Override
  public String getLastName() {
    return commands.execute("getLastName", new Object[]{});
  }

  @Override
  public String getFirstName() {
    return commands.execute("getFirstName", new Object[]{});
  }





}
