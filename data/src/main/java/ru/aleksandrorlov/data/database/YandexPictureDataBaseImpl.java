package ru.aleksandrorlov.data.database;

import android.util.Log;

import com.orm.SugarRecord;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.aleksandrorlov.data.entity.YandexPictureEntity;
import ru.aleksandrorlov.data.exeption.NetworkConnectionException;
import ru.aleksandrorlov.data.net.FakeDataNet;

/**
 * Created by alex on 16.03.18.
 */

public class YandexPictureDataBaseImpl implements YandexPictureDataBase {
    private final String TAG = this.getClass().getSimpleName();

    @Inject
    public YandexPictureDataBaseImpl() {
    }

    @Override
    public void put(YandexPictureEntity yandexPictureEntity) {
        yandexPictureEntity.save();
    }

    @Override
    public void putAll(Collection<YandexPictureEntity> yandexPictureEntityList) {
        SugarRecord.saveInTx(yandexPictureEntityList);
    }

    @Override
    public void update(long yandexPictureId, YandexPictureEntity newEntity) {
        YandexPictureEntity oldEntity =
                YandexPictureEntity.findById(YandexPictureEntity.class, yandexPictureId);
        oldEntity.setUrl(newEntity.getUrl());
        oldEntity.setRequest(newEntity.getRequest());
        oldEntity.save();
    }

    @Override
    public Observable<Boolean> delete(long yandexPictureId) {
        Log.d(TAG, "delete: contains - " + contains(yandexPictureId));
        return Observable.create(emitter -> {
            if (contains(yandexPictureId)){
                YandexPictureEntity yandexPictureEntity =
                        YandexPictureEntity.findById(YandexPictureEntity.class, yandexPictureId);
                yandexPictureEntity.delete();
                emitter.onNext(true);
                emitter.onComplete();
            } else {
                emitter.onNext(false);
                emitter.onComplete();
            }
        });
    }

    @Override
    public boolean contains(long yandexPictureId) {
        return getYandexPicture(yandexPictureId) != null ? true : false;
    }

    @Override
    public YandexPictureEntity getYandexPicture(long yandexPictureId) {
        Log.d(TAG, "getYandexPicture: yandexPictureId = " + yandexPictureId);
        return YandexPictureEntity.findById(YandexPictureEntity.class, yandexPictureId);
    }

    @Override
    public List<YandexPictureEntity> getYandexPictureListAll() {
        return YandexPictureEntity.listAll(YandexPictureEntity.class);
    }
}
