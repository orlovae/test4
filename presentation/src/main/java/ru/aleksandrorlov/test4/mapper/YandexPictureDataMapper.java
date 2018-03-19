package ru.aleksandrorlov.test4.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import ru.aleksandrorlov.domain.YandexPicture;
import ru.aleksandrorlov.test4.model.YandexPictureModel;

import static ru.aleksandrorlov.test4.Constant.EXCEPTION_NULL_VALUE;

/**
 * Created by alex on 17.03.18.
 */

public class YandexPictureDataMapper {

    @Inject
    public YandexPictureDataMapper() {}

    public YandexPictureModel transform(YandexPicture yandexPicture) {
        if (yandexPicture == null) {
            throw new IllegalArgumentException(EXCEPTION_NULL_VALUE);
        }
        final YandexPictureModel yandexPictureModel = new YandexPictureModel();
        yandexPictureModel.setUrl(yandexPicture.getUrl());
        yandexPictureModel.setRequest(yandexPicture.getRequest());
        return yandexPictureModel;
    }

    public Collection<YandexPictureModel> transform(Collection<YandexPicture> yandexPictureCollection) {
        Collection<YandexPictureModel> yandexPictureModelCollection;

        if(yandexPictureCollection != null && !yandexPictureCollection.isEmpty()) {
            yandexPictureModelCollection = new ArrayList<>();
            for (YandexPicture yandexPicture : yandexPictureCollection
                 ) {
                yandexPictureModelCollection.add(transform(yandexPicture));
            }
        } else {
            yandexPictureModelCollection = Collections.emptyList();
        }
        return yandexPictureModelCollection;
    }
}
