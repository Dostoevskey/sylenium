package io.github.symonk.common.interfaces;

import io.github.symonk.common.annotations.Attachable;

public interface Modelable {

  @Attachable(name  = "")
  default <T extends Modelable> void model(final T object, final String jsonValue) {}

  @Attachable(name  = "")
  default <T extends Modelable> void model(final T object) {}
}
