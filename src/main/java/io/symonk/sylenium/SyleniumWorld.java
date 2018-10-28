package io.symonk.sylenium;

import io.symonk.sylenium.contracts.SyleniumObject;

import java.util.ArrayList;
import java.util.List;

public class SyleniumWorld<T extends SyleniumObject> {

  private List<T> testObjects = new ArrayList<>();

  public void registerObject(T t) {
    testObjects.add(t);
  }

  public void unregisterObject(T t) {
    testObjects.removeIf(e -> testObjects.contains(t));
  }

  public int getWorldSize() {
    return testObjects.size();
  }

  public void cleanUpWorld() {
    testObjects.forEach(SyleniumObject::cleanUp);
    testObjects.clear();
  }
}
