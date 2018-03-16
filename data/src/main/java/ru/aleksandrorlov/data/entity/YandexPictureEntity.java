package ru.aleksandrorlov.data.entity;

/**
 * Created by alex on 16.03.18.
 */

public class YandexPictureEntity {
    private int yandexPictureId;
    private String url;
    private String request;

    public YandexPictureEntity() {

    }

    public int getYandexPictureId() {
        return yandexPictureId;
    }

    public void setYandexPictureId(int yandexPictureId) {
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
}
