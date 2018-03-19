package ru.aleksandrorlov.domain.interactor;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.aleksandrorlov.domain.executor.PostExecutionThread;
import ru.aleksandrorlov.domain.executor.ThreadExecutor;
import ru.aleksandrorlov.domain.repository.YandexPictureRepository;
import ru.aleksandrorlov.domain.util.Preconditions;

/**
 * Created by alex on 19.03.18.
 */

public class DeleteYandexPicturefromDB extends UseCase<Boolean, DeleteYandexPicturefromDB.Params> {
    private final YandexPictureRepository repository;

    @Inject
    DeleteYandexPicturefromDB(YandexPictureRepository yandexPictureRepository,
                              ThreadExecutor threadExecutor,
                              PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = yandexPictureRepository;
    }

    @Override
    Observable<Boolean> buildUseCaseObservable(Params params) {
        Preconditions.checkNotNull(params);
        return this.repository.deleteYandexPicture(params.yandexPictureId);
    }

    public static final class Params {

        private final long yandexPictureId;

        private Params(long yandexPictureId) {
            this.yandexPictureId = yandexPictureId;
        }

        public static DeleteYandexPicturefromDB.Params forDeleteYandexPicture(long yandexPictureId) {
            return new DeleteYandexPicturefromDB.Params(yandexPictureId);
        }
    }
}
