package io.github.symonk.integrations.proxy;

import org.slf4j.Logger;

import javax.inject.Inject;
import java.lang.reflect.Proxy;

public class SyleniumProxy {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SyleniumProxy.class);
    private final Proxyable proxy;
  private final boolean isProxyEnabled;

  @Inject
  public SyleniumProxy(final Proxyable proxy, final boolean isProxyEnabled) {
    this.proxy = proxy;
    this.isProxyEnabled = isProxyEnabled;
  }

  public Proxy getProxy() {
    log.info("Returning proxy for {}, ", proxy.getProxyName());
    return proxy.getProxy();
  }

    public boolean isProxyEnabled() {
        return this.isProxyEnabled;
    }
}
