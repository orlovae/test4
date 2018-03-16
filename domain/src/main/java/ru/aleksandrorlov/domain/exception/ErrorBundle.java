package ru.aleksandrorlov.domain.exception;

/**
 * Created by alex on 16.03.18.
 */

public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
