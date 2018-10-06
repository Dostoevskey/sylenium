package io.github.symonk.configurations.guice.aop;

import io.github.symonk.common.annotations.Notify;
import io.github.symonk.integrations.communication.Communicator;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.inject.Inject;

@Slf4j
public class NotifyInterceptor implements MethodInterceptor {

    private final Communicator communicator;

    @Inject
    public NotifyInterceptor(final Communicator communicator) {
        this.communicator = communicator;
    }

    @Override
    public Object invoke(final MethodInvocation methodInvocation) throws Throwable {
        methodInvocation.proceed();
        final String annoValue = methodInvocation.getMethod().getAnnotation(Notify.class).message();
        if(annoValue.isEmpty()) return methodInvocation.proceed();

        communicator.notify(annoValue);
        return methodInvocation.proceed();
    }
}
