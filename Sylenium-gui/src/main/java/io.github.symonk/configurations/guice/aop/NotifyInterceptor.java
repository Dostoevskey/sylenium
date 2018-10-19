package io.github.symonk.configurations.guice.aop;

import io.github.symonk.common.annotations.Notify;
import io.github.symonk.integrations.communication.Communicator;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;

import javax.inject.Inject;

public class NotifyInterceptor implements MethodInterceptor {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(NotifyInterceptor.class);
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
