package ru.aleksandrorlov.test4.view;

import android.content.Context;

/**
 * Created by alex on 18.03.18.
 */

public interface LoadDataView {
    void showDeleteYandexPicture();
    void showError(String message);
    Context context();
}
