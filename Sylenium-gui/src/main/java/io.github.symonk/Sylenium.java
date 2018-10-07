package io.github.symonk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.symonk.common.annotations.Attachable;
import io.qameta.allure.Allure;

public class Sylenium {

  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

  public static void attachModel(final Object object) {
    if (isAnnotationPresent(object, Attachable.class)) {
      Allure.addAttachment(object.getClass().getAnnotation(Attachable.class).name(), "application/json", GSON.toJson(object));
    }
  }

  public static void attachModel(final Object object, final String name) {
    if (isAnnotationPresent(object, Attachable.class)) {
      Allure.addAttachment(name, "application/json", GSON.toJson(object));
    }
  }

  private static boolean isAnnotationPresent(final Object obj, final Class annotationClass) {
    return obj.getClass().isAnnotationPresent(annotationClass);
  }
}
