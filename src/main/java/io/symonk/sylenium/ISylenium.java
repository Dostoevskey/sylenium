package io.symonk.sylenium;


import io.symonk.sylenium.interfaces.SyleniumObject;

public interface ISylenium {

    /**
     * Retrieves a randomised full name
     * @see io.symonk.sylenium.command.fakedata.GetRandomFullNameCommand
     */
    String getName();

    /**
     * Retrieves a randomised last name
     * @see io.symonk.sylenium.command.fakedata.GetRandomLastNameCommand
     */
    String getLastName();

    /**
     * Retrieves a randomised first name
     * @see io.symonk.sylenium.command.fakedata.GetRandomFirstNameCommand
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
    <T extends SyleniumObject> void registerWorldObject(final T testData);


    /**
     * Clears out the sylenium world of all test data objects
     * @see io.symonk.sylenium.command.sylenium.CleanUpWorldCommand
     * //todo implement strategy pattern to offer a per test / method / class / suite clear up policy?
     */
    void cleanUpWorld();

}
