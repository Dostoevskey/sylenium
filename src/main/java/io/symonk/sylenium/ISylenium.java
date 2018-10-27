package io.symonk.sylenium;


import io.symonk.sylenium.command.GetRandomFullName;

public interface ISylenium {

    /**
     * Retrieves a randomised full name
     * @see GetRandomFullName
     */
    String data_name();

    /**
     * Retrieves a randomised last name
     * @see GetRandomFullName
     */
    String data_lastname();

    /**
     * Retrieves a randomised first name
     * @see GetRandomFullName
     */
    String data_firstName();



}
