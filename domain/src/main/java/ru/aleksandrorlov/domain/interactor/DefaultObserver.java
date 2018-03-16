package ru.aleksandrorlov.domain.interactor;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by alex on 16.03.18.
 */

public class DefaultObserver<T> extends DisposableObserver<T> {

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable exception) {

    }

    @Override
    public void onComplete() {

    }
}
