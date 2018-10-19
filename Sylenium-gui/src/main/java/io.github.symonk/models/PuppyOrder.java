package io.github.symonk.models;

import io.github.symonk.Sylenium;
import io.github.symonk.common.annotations.Attachable;
import io.github.symonk.common.enumerations.OrderOptions;
import io.github.symonk.common.enumerations.Puppy;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Attachable(name = "PuppyOrder.json")
public class PuppyOrder {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PuppyOrder.class);
    private final String adopterName;
  private final String adopterAddress;
  private final String adopterEmail;
  private final Puppy dog;
  private final List<OrderOptions> listOfOrderItems;

  private PuppyOrder(final PuppyOrderBuilder builder) {
    this.dog = builder.dog;
    this.adopterName = builder.adopterName;
    this.adopterAddress = builder.adopterAddress;
    this.adopterEmail = builder.adopterEmail;
    this.listOfOrderItems = builder.listOfOrderItems;
    Sylenium.attachModel(this);
  }

    public String getAdopterName() {
        return this.adopterName;
    }

    public String getAdopterAddress() {
        return this.adopterAddress;
    }

    public String getAdopterEmail() {
        return this.adopterEmail;
    }

    public Puppy getDog() {
        return this.dog;
    }

    public List<OrderOptions> getListOfOrderItems() {
        return this.listOfOrderItems;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PuppyOrder)) return false;
        final PuppyOrder other = (PuppyOrder) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$adopterName = this.getAdopterName();
        final Object other$adopterName = other.getAdopterName();
        if (this$adopterName == null ? other$adopterName != null : !this$adopterName.equals(other$adopterName))
            return false;
        final Object this$adopterAddress = this.getAdopterAddress();
        final Object other$adopterAddress = other.getAdopterAddress();
        if (this$adopterAddress == null ? other$adopterAddress != null : !this$adopterAddress.equals(other$adopterAddress))
            return false;
        final Object this$adopterEmail = this.getAdopterEmail();
        final Object other$adopterEmail = other.getAdopterEmail();
        if (this$adopterEmail == null ? other$adopterEmail != null : !this$adopterEmail.equals(other$adopterEmail))
            return false;
        final Object this$dog = this.getDog();
        final Object other$dog = other.getDog();
        if (this$dog == null ? other$dog != null : !this$dog.equals(other$dog)) return false;
        final Object this$listOfOrderItems = this.getListOfOrderItems();
        final Object other$listOfOrderItems = other.getListOfOrderItems();
        if (this$listOfOrderItems == null ? other$listOfOrderItems != null : !this$listOfOrderItems.equals(other$listOfOrderItems))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $adopterName = this.getAdopterName();
        result = result * PRIME + ($adopterName == null ? 43 : $adopterName.hashCode());
        final Object $adopterAddress = this.getAdopterAddress();
        result = result * PRIME + ($adopterAddress == null ? 43 : $adopterAddress.hashCode());
        final Object $adopterEmail = this.getAdopterEmail();
        result = result * PRIME + ($adopterEmail == null ? 43 : $adopterEmail.hashCode());
        final Object $dog = this.getDog();
        result = result * PRIME + ($dog == null ? 43 : $dog.hashCode());
        final Object $listOfOrderItems = this.getListOfOrderItems();
        result = result * PRIME + ($listOfOrderItems == null ? 43 : $listOfOrderItems.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PuppyOrder;
    }

    public String toString() {
        return "PuppyOrder(adopterName=" + this.getAdopterName() + ", adopterAddress=" + this.getAdopterAddress() + ", adopterEmail=" + this.getAdopterEmail() + ", dog=" + this.getDog() + ", listOfOrderItems=" + this.getListOfOrderItems() + ")";
    }

    public static class PuppyOrderBuilder {
    private final String adopterName;
    private final String adopterAddress;
    private final String adopterEmail;
    private final Puppy dog;
    private final List<OrderOptions> listOfOrderItems = new ArrayList<>();

    public PuppyOrderBuilder(
        final String adopterName,
        final String adopterAddress,
        final String adopterEmail,
        final Puppy dog) {
      this.adopterName = adopterName;
      this.adopterAddress = adopterAddress;
      this.adopterEmail = adopterEmail;
      this.dog = dog;
    }

    public PuppyOrderBuilder addOptions(final OrderOptions... options) {
      Collections.addAll(listOfOrderItems, options);
      return this;
    }

    public PuppyOrder build() {
      return new PuppyOrder(this);
    }
  }
}
