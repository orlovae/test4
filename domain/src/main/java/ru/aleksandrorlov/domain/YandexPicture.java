package ru.aleksandrorlov.domain;

/**
 * Created by alex on 15.03.18.
 */

public class YandexPicture {
    private final long yandexPictureId;

    public YandexPicture(long yandexPictureId) {
        this.yandexPictureId = yandexPictureId;
    }

    private String url;
    private String request;

    public long getYandexPictureId() {
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
