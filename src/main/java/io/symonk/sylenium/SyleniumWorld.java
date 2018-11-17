package io.symonk.sylenium;

import com.google.common.collect.Lists;
import io.symonk.sylenium.contracts.SyleniumObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Sylenium World is a place for test data to live and to be persisted cross-suite if necessary.
 * It is a generic implementation and can keep track of anything you need, cleaning it up based on a clean up strategy
 * @param <T> A piece of Testdata that implements the SyleniumObject interface
 */
public class SyleniumWorld<T extends SyleniumObject> {

  private List<T> testObjects = new ArrayList<>();

  public T registerObject(T t) {
    testObjects.add(t);
    return t;
  }

  public void unregisterObject(T t) {
    testObjects.removeIf(e -> testObjects.contains(t));
  }

  public int getWorldSize() {
    return testObjects.size();
  }

  /**
   * Clean up the items in reverse order, a child instance can exist before its parent so it makes logical sense
   * to flush out the world in reverse order to avoid issues where a parent cannot be deleted because it has children.
   */
  public void cleanUpWorld() {
    Lists.reverse(testObjects).forEach(SyleniumObject::cleanUp);
    testObjects.clear();
  }
}
