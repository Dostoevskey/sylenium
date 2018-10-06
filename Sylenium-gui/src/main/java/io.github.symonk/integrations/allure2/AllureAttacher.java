package io.github.symonk.integrations.allure2;

import com.google.gson.Gson;
import io.github.symonk.common.annotations.Attachable;
import io.github.symonk.common.interfaces.Modelable;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@Slf4j
public class AllureAttacher {

  private final Gson gson;
  private static final String DEFAULT = "default.json";
  private static final String JSON = "application/json";

  @Inject
  public AllureAttacher(final Gson gson) {
    this.gson = gson;
  }

  public <T extends Object> void attachModelUsingCustomName(final T modelObject, final String name) {
    Allure.addAttachment(name, JSON, gson.toJson(modelObject));
  }

  public <T extends Object> void attachModelUsingDefaultName(final T modelObject) {
    Allure.addAttachment(prepareAttachment(modelObject), JSON, gson.toJson(modelObject));
  }

  private <T extends Object> String prepareAttachment(final T modelObject) {
    if (modelObject.getClass().isAnnotationPresent(Attachable.class)) {
      String annotationValue = modelObject.getClass().getAnnotation(Attachable.class).name();
      return annotationValue.endsWith(".json") ? annotationValue : annotationValue + ".json";
    }
    return DEFAULT;
  }
}
