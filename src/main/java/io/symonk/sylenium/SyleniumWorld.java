package io.symonk.sylenium;

import java.util.ArrayList;
import java.util.List;

public class SyleniumWorld<T extends SyleniumObject> {

  private List<T> testObjects = new ArrayList<>();

  public void registerObject(T t) {
    testObjects.add(t);
  }

  public void cleanUpWorld() {
    testObjects.forEach(SyleniumObject::cleanUp);
  }
}
