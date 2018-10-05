package io.github.symonk.common.interfaces;

import io.github.symonk.integrations.allure2.AllureAttacher;

public interface Modelable {

  AllureAttacher allureAttacher = null;

  default <T extends Modelable> void model(final T object, final String jsonValue) {}

  default <T extends Modelable> void model(final T object) {}
}
