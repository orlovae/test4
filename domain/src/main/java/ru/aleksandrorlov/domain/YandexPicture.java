package ru.aleksandrorlov.domain;

/**
 * Created by alex on 15.03.18.
 */

public class YandexPicture {
    private final int yandexPictureId;

    public YandexPicture(int yandexPictureId) {
        this.yandexPictureId = yandexPictureId;
    }

    private String url;
    private String request;

    public int getYandexPictureId() {
        return yandexPictureId;
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
