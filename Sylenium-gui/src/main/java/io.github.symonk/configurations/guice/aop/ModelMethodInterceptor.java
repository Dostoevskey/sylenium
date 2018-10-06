package io.github.symonk.configurations.guice.aop;


import io.github.symonk.integrations.allure2.AllureAttacher;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.inject.Inject;

public class ModelMethodInterceptor implements MethodInterceptor {

    private final AllureAttacher allureAttacher;

    @Inject
    public ModelMethodInterceptor(final AllureAttacher allureAttacher) {
        this.allureAttacher = allureAttacher;
    }

    @Override
    public Object invoke(final MethodInvocation methodInvocation) throws Throwable {
        methodInvocation.proceed();
        allureAttacher.attachModelUsingDefaultName(methodInvocation.getThis());
        return methodInvocation.proceed();
    }
}
