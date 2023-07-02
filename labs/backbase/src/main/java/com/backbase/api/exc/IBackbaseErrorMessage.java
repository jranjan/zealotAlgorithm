package com.backbase.api.exc;

public interface IBackbaseErrorMessage {

    /**
     * This method is responsible to return a message format defined in an enum. Message format is a
     * string which captures the primary message about any error, along with some format specifiers
     * (like '%s') against which argument(s) can be provided to capture as much useful information as
     * possible for an error scenario. However, the number of arguments provided should match the
     * number of format specifiers in the message format for obvious reasons.
     *
     * @return The message format string which is described in the above description
     */
    String getMessageFormat();

    /**
     * This method will return the enriched error message corresponding to an enum constant. Since an
     * enum constant can contain format specifier(s), the corresponding arguments are provided while
     * throwing the exception as a constructor argument as they can not be part of enum constant
     * itself as they are not a constant. This method will then be used to form the enriched error
     * message by combining the message format and the optional arguments, which in turn is provided
     * as a message argument to the super constructor {@link Exception#Exception(String)} from {@link
     * BackbaseException}'s constructors. Please refer to these constructors to see how it is being done.
     *
     * @param arguments The optional arguments which will be provided corresponding to the format
     *     specifiers mentioned in the message format string
     * @return The enriched error message formed by combining the error message format and the
     *     optional arguments
     */
    default String getMessage(Object... arguments) {
        return String.format(this.getMessageFormat(), arguments);
    }
}