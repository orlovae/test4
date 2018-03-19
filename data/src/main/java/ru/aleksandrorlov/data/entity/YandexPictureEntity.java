package ru.aleksandrorlov.data.entity;

import com.orm.SugarRecord;

/**
 * Created by alex on 16.03.18.
 */

public class YandexPictureEntity extends SugarRecord<YandexPictureEntity> {
    private long yandexPictureId;
    private String url;
    private String request;

    public YandexPictureEntity() {}

    public YandexPictureEntity(String url, String request) {
        this.url = url;
        this.request = request;
    }

    public long getYandexPictureId() {
        return yandexPictureId;
    }

    public void setYandexPictureId(long yandexPictureId) {
        this.yandexPictureId = yandexPictureId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "YandexPictureEntity{" +
                "yandexPictureId=" + yandexPictureId +
                ", url='" + url + '\'' +
                ", request='" + request + '\'' +
                ", id=" + id +
                '}';
    }
}
