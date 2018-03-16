package ru.aleksandrorlov.domain.exception;

import static ru.aleksandrorlov.domain.Constant.DEFAULT_ERROR_MSG;

/**
 * Created by alex on 16.03.18.
 */

public class DefaultErrorBundle implements ErrorBundle {
    private final Exception exception;

    public DefaultErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        return (exception != null) ? this.exception.getMessage() : DEFAULT_ERROR_MSG;
    }
}
