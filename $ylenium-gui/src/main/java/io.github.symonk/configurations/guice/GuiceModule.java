package io.github.symonk.configurations.guice;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.HipChat;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.github.symonk.common.enumerations.CommunicationChannel;
import io.github.symonk.common.exceptions.$yCommunicationException;
import io.github.symonk.common.helpers.localisation.LanguageHelper;
import io.github.symonk.common.helpers.localisation.ProvidesLanguageValues;
import io.github.symonk.integrations.allure2.ReportHelper;
import io.github.symonk.integrations.allure2.ReportInteractable;
import io.github.symonk.configurations.properties.FrameworkProperties;
import io.github.symonk.data.OrderProvidable;
import io.github.symonk.data.PuppyOrderFactory;
import io.github.symonk.integrations.communication.Communicator;
import io.github.symonk.integrations.communication.HipChatStrategy;
import io.github.symonk.integrations.communication.NoCommsStrategy;
import io.github.symonk.integrations.communication.SlackStrategy;
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
  }

  @Provides
  @Singleton
  public Communicator communicator() {

    final CommunicationChannel strategy = CommunicationChannel.valueOf(properties().communicationStrategy());
    if (strategy == CommunicationChannel.SLACK && new UrlValidator().isValid(properties().slackUrl())) {
      log.info("Slack communication strategy selected.  url is valid");
      return new Communicator(new SlackStrategy(getSlackClient()));
    }

    if (strategy == CommunicationChannel.HIPCHAT && !properties().hipchatAccessCode().isEmpty()) {
      log.info("Hipchat communication strategy selected. access token is not empty");
      log.info("Will output to channel: {}", properties().hipchatChannel());
      return new Communicator(new HipChatStrategy(getHipChatClient(), properties().hipchatChannel()));
    }

    log.info("No communication strategy configured, no notifications will be triggered");
    return new Communicator(new NoCommsStrategy());
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
      throw new $yCommunicationException(exception);
    }
    return chat;
  }

  @Provides
  @Singleton
  public FrameworkProperties properties() {
    return ConfigFactory.create(FrameworkProperties.class);
  }
}
