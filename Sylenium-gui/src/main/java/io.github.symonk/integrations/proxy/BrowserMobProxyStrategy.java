package io.github.symonk.integrations.proxy;


import java.lang.reflect.Proxy;

public class BrowserMobProxyStrategy implements Proxyable {


    @Override
    public Proxy getProxy() {
        return null;
    }

    @Override
    public String getProxyName() {
        return "Browser Mob Proxy";
    }
}
