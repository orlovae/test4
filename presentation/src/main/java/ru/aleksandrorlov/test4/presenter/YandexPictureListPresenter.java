package ru.aleksandrorlov.test4.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import ru.aleksandrorlov.domain.YandexPicture;
import ru.aleksandrorlov.domain.exception.DefaultErrorBundle;
import ru.aleksandrorlov.domain.exception.ErrorBundle;
import ru.aleksandrorlov.domain.interactor.DefaultObserver;
import ru.aleksandrorlov.domain.interactor.GetYandexPictureList;
import ru.aleksandrorlov.test4.exeption.ErrorMessageFactory;
import ru.aleksandrorlov.test4.mapper.YandexPictureDataMapper;
import ru.aleksandrorlov.test4.model.YandexPictureModel;
import ru.aleksandrorlov.test4.view.YandexPictureListView;

/**
 * Created by alex on 17.03.18.
 */

public class YandexPictureListPresenter implements Presenter {
    private final String TAG = this.getClass().getSimpleName();

    private YandexPictureListView yandexPictureListView;

    private final GetYandexPictureList getYandexPictureList;
    private final YandexPictureDataMapper yandexPictureDataMapper;


    @Inject
    public YandexPictureListPresenter(GetYandexPictureList getYandexPictureList,
                                      YandexPictureDataMapper yandexPictureDataMapper) {
        this.getYandexPictureList = getYandexPictureList;
        this.yandexPictureDataMapper = yandexPictureDataMapper;
    }

    public void setView(@NonNull YandexPictureListView view) {
        this.yandexPictureListView = view;
    }

    @Override public void resume() {}

    @Override public void pause() {}

    @Override public void destroy() {
        this.getYandexPictureList.dispose();
        this.yandexPictureListView = null;
    }

    public void initialize() {
        this.loadYandexPictureList();
    }

    private void loadYandexPictureList() {
        this.getYandexPictureList();
    }

    private void getYandexPictureList() {
        this.getYandexPictureList.execute(new YandexPictureListObserver(), null);
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.yandexPictureListView.context(),
                errorBundle.getException());
        this.yandexPictureListView.showError(errorMessage);
    }

    private void showYandexPictureCollectionInView(Collection<YandexPicture> yandexPictureCollection) {
        final Collection<YandexPictureModel> yandexPictureModelCollection =
                this.yandexPictureDataMapper.transform(yandexPictureCollection);
        this.yandexPictureListView.renderYandexPictureList(yandexPictureModelCollection);
    }

    public void onLongPress(long yandexPictureId) {
        Log.d(TAG, "onLongPress: itemPosition = " + yandexPictureId);
        //TODO удалять из базы данных по itemPosition
    }

    private final class YandexPictureListObserver extends DefaultObserver<List<YandexPicture>> {
        @Override
        public void onNext(List<YandexPicture> yandexPictureList) {
            YandexPictureListPresenter.this.showYandexPictureCollectionInView(yandexPictureList);
        }

        @Override
        public void onError(Throwable exception) {
            YandexPictureListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) exception));
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }
    }
}
