package ru.aleksandrorlov.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;

import io.reactivex.Observable;
import ru.aleksandrorlov.data.entity.YandexPictureEntity;
import ru.aleksandrorlov.data.exeption.NetworkConnectionException;

/**
 * Created by alex on 17.03.18.
 */

public class ParseNetImpl implements ParseNet {
    private final Context context;

    public ParseNetImpl(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context;
    }

    @Override
    public Observable<List<YandexPictureEntity>> yandexPictureEntityList() {
        return null;
    }

    @Override
    public Observable<YandexPictureEntity> yandexPictureEntity(long yandexPictureId) {
        return Observable.create(emitter -> {
            if (isThereInternetConnection()){
                try {
                    FakeDataNet fakeDataNet = new FakeDataNet();
                    YandexPictureEntity entity = fakeDataNet.getYandexPictureEntity();
                    if (entity != null) {
                        emitter.onNext(entity);
                        emitter.onComplete();
                    } else {
                        emitter.onError(new NetworkConnectionException());
                    }
                } catch (Exception e) {
                    emitter.onError(new NetworkConnectionException(e.getCause()));
                }
            } else {
                emitter.onError(new NetworkConnectionException());
            }
                }
        );
    }

    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
