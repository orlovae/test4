package ru.aleksandrorlov.test4.exeption;

import android.content.Context;

import ru.aleksandrorlov.data.exeption.NetworkConnectionException;
import ru.aleksandrorlov.data.exeption.YandexPictureNotFoundException;
import ru.aleksandrorlov.test4.R;

/**
 * Created by alex on 18.03.18.
 */

public class ErrorMessageFactory {

    public ErrorMessageFactory() {
    }

    public static String create(Context context, Exception exception) {
        String message = context.getString(R.string.exception_message_generic);

        if (exception instanceof NetworkConnectionException) {
            message = context.getString(R.string.exception_message_no_connection);
        } else if (exception instanceof YandexPictureNotFoundException) {
            message = context.getString(R.string.exception_message_yandex_picture_not_found);
        }

        return message;
    }
}
