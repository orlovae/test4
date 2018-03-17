package ru.aleksandrorlov.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.aleksandrorlov.domain.YandexPicture;
import ru.aleksandrorlov.domain.executor.PostExecutionThread;
import ru.aleksandrorlov.domain.executor.ThreadExecutor;
import ru.aleksandrorlov.domain.repository.YandexPictureRepository;

/**
 * Created by alex on 16.03.18.
 */

public class GetYandexPictureList extends UseCase<List<YandexPicture>, Void> {

    private final YandexPictureRepository repository;

    @Inject
    GetYandexPictureList(YandexPictureRepository yandexPictureRepository,
                         ThreadExecutor threadExecutor,
                PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = yandexPictureRepository;
    }

    @Override Observable<List<YandexPicture>> buildUseCaseObservable(Void unused) {
        return this.repository.yandexPictures();
    }
}
