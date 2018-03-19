package ru.aleksandrorlov.test4.view;

import java.util.Collection;

import ru.aleksandrorlov.test4.model.YandexPictureModel;

/**
 * Created by alex on 18.03.18.
 */

public interface YandexPictureListView extends LoadDataView {
    void showDeleteYandexPicture();
    void renderYandexPictureList(Collection<YandexPictureModel> yandexPictureModelCollection);
}
