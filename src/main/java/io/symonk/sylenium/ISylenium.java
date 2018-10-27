package io.symonk.sylenium;


import io.symonk.sylenium.interfaces.SyleniumObject;

public interface ISylenium {

    /**
     * Launches the browser, and returns your login page object
     * Login Page should contain a @Url annotation to guide the browser when using this command
     * @param pageObjectClass -> PageObject class
     * @return the page object instance post navigation
     */
    <pageObjectClass> pageObjectClass start(final pageObjectClass pageObjectClass);

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
     * @return the string representation of the given key
     */
    String localisedValueOf(final String key);


    /**
     * Registers an implementation of SyleniumObject to the Sylenium Test World
     * @see io.symonk.sylenium.command.sylenium.RegisterWorldObjectCommand
     * @param testData - The Test Data Object Sylenium should keep track of
     * @param <T> - An Object which implements SyleniumObject
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
     * Clears out the sylenium world of all test data objects
     * @see io.symonk.sylenium.command.sylenium.CleanUpWorldCommand
     * //todo implement strategy pattern to offer a per test / method / class / suite clear up policy?
     */
    Sylenium cleanUpWorld();


    /**
     * Returns the current size of the test world
     * @return an int dictating the size of the test world objects list
     */
    int getWorldSize();



}
