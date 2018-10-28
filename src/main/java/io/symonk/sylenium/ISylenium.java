package io.symonk.sylenium;


import io.symonk.sylenium.interfaces.ConfigObserver;
import io.symonk.sylenium.interfaces.SyleniumObject;
import org.openqa.selenium.By;

public interface ISylenium {

    /**
     * Launches the browser, and returns your login page object
     * Login Page should contain a @Url annotation to guide the browser when using this command
     * @return the page object instance post navigation
     */
    <T> T  start(final Class<T> pageObjectClassClass);

    /**
     * Retrieves a randomised full name
     * @see io.symonk.sylenium.command.data.GetRandomFullNameCommand
     */
    String getName();

    /**
     * Retrieves a randomised last name
     * @see io.symonk.sylenium.command.data.GetRandomLastNameCommand
     */
    String getLastName();

    /**
     * Retrieves a randomised first name
     * @see io.symonk.sylenium.command.data.GetRandomFirstNameCommand
     */
    String getFirstName();


    /**
     * Retrieves a localised property from the specified language file
     * @see io.symonk.sylenium.command.sylenium.LocalisedValueOfCommand
     * @return The string representation of the given key
     */
    String localisedValueOf(final String key);


    /**
     * Registers an implementation of SyleniumObject to the Sylenium Test World
     * @see io.symonk.sylenium.command.sylenium.RegisterWorldObjectCommand
     * @param testData - The Test Data Object Sylenium should keep track of
     * @param <T> - An Object which implements SyleniumObject
     * @return The sy instance
     * @see io.symonk.sylenium.interfaces.SyleniumObject
     */
    <T extends SyleniumObject> Sylenium registerWorldObject(final T testData);


    /**
     * Unregisteres an implementation of SyleniumObject to the Sylenium Test World
     * @see io.symonk.sylenium.command.sylenium.UnregisterWorldObjectCommand
     * @param testData - The Test Data Object that should be removed
     * @param <T> - An Object which implements SyleniumObject
     * @see io.symonk.sylenium.interfaces.SyleniumObject
     */
    <T extends SyleniumObject> Sylenium unregisterWorldObject(final T testData);

    /**
     * Clears out the sy world of all test data objects
     * @see io.symonk.sylenium.command.sylenium.CleanUpWorldCommand
     * //todo implement strategy pattern to offer a per test / method / class / suite clear up policy?
     */
    Sylenium cleanUpWorld();


    /**
     * Returns the current size of the test world
     * @return an int dictating the size of the test world objects list
     */
    int getWorldItemCount();

    /**
     * Retrieve the value of any runtime properties specified in the sy config file
     * @param propertyKey The key to use as a lookup to return the value
     * @return The property value
     * @see io.symonk.sylenium.command.sylenium.GetPropertyCommand
     */
    String getProperty(final String propertyKey);

    /**
     * Set a sy property value programmatically at runtime
     * @param propertyKey The key to use as a lookup to set the value
     * @param newValue The new value for this property
     * @return The sy instance
     * @see io.symonk.sylenium.command.sylenium.UpdatePropertyCommand
     */
    Sylenium updateProperty(final String propertyKey, final String newValue);


    By localisedLinkTextOf(final String languageKey);

    By localisedPartialLinkTextOf(final String languageKey);

    <T extends ConfigObserver> Sylenium addConfigObserver(final T observer);

    <T extends ConfigObserver> Sylenium removeConfigObserver(final T observer);

    int getConfigObserverCount();

}
