package io.github.symonk.integrations.proxy;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.lang.reflect.Proxy;

@Slf4j
public class SyleniumProxy {

  private final Proxyable proxy;
  @Getter @Setter private final boolean isProxyEnabled;

  @Inject
  public SyleniumProxy(final Proxyable proxy, final boolean isProxyEnabled) {
    this.proxy = proxy;
    this.isProxyEnabled = isProxyEnabled;
  }

  public Proxy getProxy() {
    log.info("Returning proxy for {}, ", proxy.getProxyName());
    return proxy.getProxy();
  }
}
