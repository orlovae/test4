package ru.aleksandrorlov.data.entity.mapper;

import com.orm.SugarRecord;

/**
 * Created by alex on 16.03.18.
 */

public class YandexPictureDBModel extends SugarRecord<YandexPictureDBModel> {
    String url;
    String request;

    public YandexPictureDBModel() {
    }

    public YandexPictureDBModel(String url, String request) {
        this.url = url;
        this.request = request;
    }
}
