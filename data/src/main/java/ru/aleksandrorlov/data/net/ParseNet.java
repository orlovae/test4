package ru.aleksandrorlov.data.net;

import java.util.List;

import io.reactivex.Observable;
import ru.aleksandrorlov.data.entity.YandexPictureEntity;

/**
 * Created by alex on 17.03.18.
 */

public interface ParseNet {
    Observable<List<YandexPictureEntity>> yandexPictureEntityList();

    Observable<YandexPictureEntity> yandexPictureEntity(final long yandexPictureId);
}
