package io.github.symonk.common.annotations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.qameta.allure.Allure;

public interface Modelable {

  Gson gson = new GsonBuilder().setPrettyPrinting().create();

  default <T extends Modelable> void model(final T object) {
    String annoVal = "Default.json";
    if (object.getClass().isAnnotationPresent(Attachable.class)) {
      annoVal = object.getClass().getAnnotation(Attachable.class).name();
    }
    Allure.addAttachment(annoVal, "application/json", gson.toJson(object));
  }
}
