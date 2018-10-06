package io.github.symonk.integrations.proxy;

import java.lang.reflect.Proxy;

public interface Proxyable {

    Proxy getProxy();
    String getProxyName();

}
