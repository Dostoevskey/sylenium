package io.github.symonk.integrations.proxy;

import java.lang.reflect.Proxy;

public class ZapProxyStrategy implements Proxyable {

  @Override
  public Proxy getProxy() {
    return null;
  }

  @Override
  public String getProxyName() {
    return "Owasp Zap Proxy";
  }
}
