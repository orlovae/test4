package ru.aleksandrorlov.data.exeption;

/**
 * Created by alex on 16.03.18.
 */

public class NetworkConnectionException extends Exception {

    public NetworkConnectionException() {
        super();
    }

    public NetworkConnectionException(final Throwable cause) {
        super(cause);
    }
}
