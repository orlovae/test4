package ru.aleksandrorlov.data.entity.mapper;

import java.util.List;

import ru.aleksandrorlov.data.database.YandexPictureDataBase;
import ru.aleksandrorlov.data.entity.YandexPictureEntity;
import ru.aleksandrorlov.data.net.FakeDataNet;

/**
 * Created by alex on 19.03.18.
 */

public class YPMapperToDBFromNet {
    private final YandexPictureDataBase yandexPictureDataBase;

    public YPMapperToDBFromNet(YandexPictureDataBase yandexPictureDataBase) {
        this.yandexPictureDataBase = yandexPictureDataBase;
    }

    public void transform() {
        FakeDataNet fakeDataNet = new FakeDataNet();
        List<YandexPictureEntity> entityList = fakeDataNet.getYandexPictureEntityList();
        for (YandexPictureEntity item:entityList
                ) {
            yandexPictureDataBase.put(item);
        }
    }
}
