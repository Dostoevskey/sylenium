package io.github.symonk;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.symonk.common.annotations.Attachable;
import io.qameta.allure.Allure;

public class Sylenium {

  private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> void attachModel(final T object) {
        if(object.getClass().isAnnotationPresent(Attachable.class)) {
            Allure.addAttachment(object.getClass().getAnnotation(Attachable.class).name(), "application/json", gson.toJson(object));
        }
    }


}
