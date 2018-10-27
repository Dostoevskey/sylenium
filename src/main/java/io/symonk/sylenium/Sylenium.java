package io.symonk.sylenium;

import io.symonk.sylenium.command.Commands;
import io.symonk.sylenium.impl.ConfigManager;
import io.symonk.sylenium.interfaces.SyleniumObject;

public enum Sylenium implements ISylenium {

  INSTANCE;

  private static final ConfigManager configManager = new ConfigManager();
  private static final ResourceReader localisationValueReader = new ResourceReader(configManager);
  private static final SyleniumWorld world = new SyleniumWorld();
  private static final Commands commands = Commands.INSTANCE;

  @Override
  public String localisedValueOf(final String key) {
    return commands.execute("localisedValueOf", new Object[]{localisationValueReader, key});
  }

  @Override
  public <T extends SyleniumObject> void registerWorldObject(final T testData) {
     commands.execute("registerWorldObject", new Object[] {world, testData});
  }

  @Override
  public void cleanUpWorld() {
    commands.execute("cleanUpWorld", new Object[]{world});
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
