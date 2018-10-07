package io.github.symonk.configurations.guice;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.HipChat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Named;
import io.github.symonk.common.annotations.Notify;
import io.github.symonk.common.enumerations.CommunicationChannel;
import io.github.symonk.common.exceptions.SyleniumCommunicationException;
import io.github.symonk.common.helpers.localisation.LanguageHelper;
import io.github.symonk.common.helpers.localisation.ProvidesLanguageValues;
import io.github.symonk.configurations.guice.aop.NotifyInterceptor;
import io.github.symonk.integrations.allure2.ReportHelper;
import io.github.symonk.common.interfaces.ReportInteractable;
import io.github.symonk.configurations.properties.SyleniumProperties;
import io.github.symonk.common.interfaces.OrderProvidable;
import io.github.symonk.data.PuppyOrderFactory;
import io.github.symonk.integrations.communication.Communicator;
import io.github.symonk.integrations.communication.HipChatStrategy;
import io.github.symonk.integrations.communication.NoChatStrategy;
import io.github.symonk.integrations.communication.SlackChatStrategy;
import lombok.extern.slf4j.Slf4j;
import net.gpedro.integrations.slack.SlackApi;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.validator.routines.UrlValidator;

@Slf4j
public class GuiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ProvidesLanguageValues.class).to(LanguageHelper.class).in(Singleton.class);
    bind(OrderProvidable.class).to(PuppyOrderFactory.class).in(Singleton.class);
    bind(ReportInteractable.class).to(ReportHelper.class).in(Singleton.class);
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(Notify.class), new NotifyInterceptor(communicator()));
  }

  @Provides
  @Singleton
  public Communicator communicator() {

    final CommunicationChannel strategy = CommunicationChannel.valueOf(properties().communicationStrategy());
    if (strategy == CommunicationChannel.SLACK && new UrlValidator().isValid(properties().slackUrl())) {
      log.info("Slack communication strategy selected.  url is valid");
      return new Communicator(new SlackChatStrategy(getSlackClient()));
    }

    if (strategy == CommunicationChannel.HIPCHAT && !properties().hipchatAccessCode().isEmpty()) {
      log.info("Hipchat communication strategy selected. access token is not empty");
      log.info("Will output to channel: {}", properties().hipchatChannel());
      return new Communicator(new HipChatStrategy(getHipChatClient(), properties().hipchatChannel()));
    }

    log.info("No communication strategy configured, no aop will be triggered");
    return new Communicator(new NoChatStrategy());
  }

  @Provides
  @Singleton
  public SlackApi getSlackClient() {
    return new SlackApi(properties().slackUrl());
  }

  @Provides
  @Singleton
  public HipChat getHipChatClient() {
    final HipChat chat;
    try {
      chat = new HipChat(properties().hipchatAccessCode());
    } catch (final FoxHttpException exception) {
      throw new SyleniumCommunicationException(exception);
    }
    return chat;
  }

  @Provides
  @Singleton
  public SyleniumProperties properties() {
    return ConfigFactory.create(SyleniumProperties.class);
  }
}
