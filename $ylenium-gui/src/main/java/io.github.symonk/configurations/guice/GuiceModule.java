package io.github.symonk.configurations.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.evanwong.oss.hipchat.v2.HipChatClient;
import io.github.symonk.common.enumerations.CommunicationChannel;
import io.github.symonk.common.helpers.localisation.LanguageHelper;
import io.github.symonk.common.helpers.localisation.ProvidesLanguageValues;
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

@Slf4j
public class GuiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ProvidesLanguageValues.class).to(LanguageHelper.class).in(Singleton.class);
    bind(OrderProvidable.class).to(PuppyOrderFactory.class).in(Singleton.class);
  }

  @Provides
  @Singleton
  public Communicator communicator() {
    final CommunicationChannel strategy = CommunicationChannel.valueOf(getProperties().communicationStrategy());
    switch (strategy) {
      case SLACK:
        return new Communicator(new SlackStrategy(getSlackClient()));
      case HIPCHAT:
        return new Communicator(new HipChatStrategy(getHipChatClient()));
      default:
        return new Communicator(new NoCommsStrategy());
    }
  }

  @Provides
  @Singleton
  public SlackApi getSlackClient() {
    return new SlackApi(getProperties().communicationWebHook());
  }

  @Provides
  @Singleton
  public HipChatClient getHipChatClient() {
    return new HipChatClient(getProperties().communicationWebHook());
  }

  @Provides
  @Singleton
  public FrameworkProperties getProperties() {
    return ConfigFactory.create(FrameworkProperties.class);
  }
}
