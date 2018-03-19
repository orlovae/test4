package ru.aleksandrorlov.test4.model;

/**
 * Created by alex on 17.03.18.
 */

public class YandexPictureModel {

    public YandexPictureModel() {

    }

    private long yandexPictureId;
    private String url;
    private String request;

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
        return "YandexPictureModel{" +
                "yandexPictureId=" + yandexPictureId +
                ", url='" + url + '\'' +
                ", request='" + request + '\'' +
                '}';
    }
}
