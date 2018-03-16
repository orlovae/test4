package ru.aleksandrorlov.data.exeption;

import ru.aleksandrorlov.domain.exception.ErrorBundle;

/**
 * Created by alex on 16.03.18.
 */

public class RepositoryErrorBundle implements ErrorBundle {

    private final Exception exception;

    RepositoryErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        String message = "";
        if (this.exception != null) {
            message = this.exception.getMessage();
        }
        return message;
    }
}
