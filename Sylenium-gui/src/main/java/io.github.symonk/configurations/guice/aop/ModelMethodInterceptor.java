package io.github.symonk.configurations.guice.aop;


import io.github.symonk.integrations.allure2.AllureFileAttacher;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.inject.Inject;

public class ModelMethodInterceptor implements MethodInterceptor {

    private final AllureFileAttacher allureFileAttacher;

    @Inject
    public ModelMethodInterceptor(final AllureFileAttacher allureFileAttacher) {
        this.allureFileAttacher = allureFileAttacher;
    }

    @Override
    public Object invoke(final MethodInvocation methodInvocation) throws Throwable {
        methodInvocation.proceed();
        allureFileAttacher.attachModelUsingDefaultName(methodInvocation.getThis());
        return methodInvocation.proceed();
    }
}
