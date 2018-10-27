package io.symonk.sylenium.command.browser;


import com.codeborne.selenide.Selenide;
import io.symonk.sylenium.annotation.StartUrl;
import io.symonk.sylenium.interfaces.SyleniumCommand;

public class StartCommand implements SyleniumCommand<Class> {


    @Override
    public Class execute(final Object[] args) {
        final String title = args[0].getClass().getAnnotation(StartUrl.class).url();
        return (Class) Selenide.open(title, args[0].getClass());
    }

}
