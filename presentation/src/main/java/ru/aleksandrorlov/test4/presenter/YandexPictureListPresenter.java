package ru.aleksandrorlov.test4.presenter;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import ru.aleksandrorlov.domain.YandexPicture;
import ru.aleksandrorlov.domain.exception.DefaultErrorBundle;
import ru.aleksandrorlov.domain.exception.ErrorBundle;
import ru.aleksandrorlov.domain.interactor.DefaultObserver;
import ru.aleksandrorlov.domain.interactor.GetYandexPictureList;
import ru.aleksandrorlov.test4.contarct.MainActivityContract;
import ru.aleksandrorlov.test4.exeption.ErrorMessageFactory;
import ru.aleksandrorlov.test4.mapper.YandexPictureDataMapper;
import ru.aleksandrorlov.test4.model.YandexPictureModel;

/**
 * Created by alex on 17.03.18.
 */

public class MainActivityPresenter extends PresenterBase<MainActivityContract.View>
    implements MainActivityContract.Presenter{

    private final GetYandexPictureList getYandexPictureList;
    private final YandexPictureDataMapper yandexPictureDataMapper;


    @Inject
    public MainActivityPresenter(GetYandexPictureList getYandexPictureList,
                                 YandexPictureDataMapper yandexPictureDataMapper) {
        this.getYandexPictureList = getYandexPictureList;
        this.yandexPictureDataMapper = yandexPictureDataMapper;
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.viewListView.context(),
                errorBundle.getException());
        this.viewListView.showError(errorMessage);
    }

    private void showYandexPictureCollectionInView(Collection<YandexPicture> yandexPictureCollection) {
        final Collection<YandexPictureModel> yandexPictureModelCollection =
                this.yandexPictureDataMapper.transform(yandexPictureCollection);
        this.viewListView.renderUserList(yandexPictureModelCollection);
    }

    private final class YandexPictureListObserver extends DefaultObserver<List<YandexPicture>> {
        @Override
        public void onNext(List<YandexPicture> yandexPictureList) {
            MainActivityPresenter.this.showYandexPictureCollectionInView(yandexPictureList);
        }

        @Override
        public void onError(Throwable exception) {
            MainActivityPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) exception));
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }
    }
}
