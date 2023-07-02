package com.backbase.api.exc;

import java.util.HashMap;
import java.util.Map;

public abstract class BackbaseException extends Exception {

    private final Map<String, Object> properties = new HashMap<>();

    public BackbaseException(IBackbaseErrorMessage errorMessage, Object... arguments) {
        super(errorMessage.getMessage(arguments));
    }

    public BackbaseException(Throwable cause) {
        super(cause);
    }

    public BackbaseException(Throwable cause, IBackbaseErrorMessage errorMessage, Object... arguments) {
        super(errorMessage.getMessage(arguments), cause);
    }

    public BackbaseException set(String key, Object value) {
        properties.put(key, value);
        return this;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + propertiesToString();
    }

    private String propertiesToString() {
        return properties.isEmpty() ? "" : String.format(" [Additional Information : %s]", properties);
    }

    public String getUserMessage() {
        return super.getMessage();
    }
}