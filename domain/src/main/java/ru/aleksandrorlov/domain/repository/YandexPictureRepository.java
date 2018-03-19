package ru.aleksandrorlov.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import ru.aleksandrorlov.domain.YandexPicture;

/**
 * Created by alex on 15.03.18.
 */

public interface YandexPictureRepository {
    Observable<List<YandexPicture>> yandexPictures();

    Observable<YandexPicture> yandexPicture(final long yandexPictureId);

    Observable<Boolean> deleteYandexPicture(final long yandexPictureId);
}
