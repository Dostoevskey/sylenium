package io.symonk.sylenium;

import io.symonk.sylenium.interfaces.SyleniumObject;

import java.util.ArrayList;
import java.util.List;

public class SyleniumWorld<T extends SyleniumObject> {

  private List<T> testObjects = new ArrayList<>();
  private int numberOfObjects;

  public void registerObject(T t) {
    testObjects.add(t);
  }

  public int getWorldSize() {
    return testObjects.size();
  }

  public void cleanUpWorld() {
    testObjects.forEach(SyleniumObject::cleanUp);
    testObjects = new ArrayList<>();
  }
}
