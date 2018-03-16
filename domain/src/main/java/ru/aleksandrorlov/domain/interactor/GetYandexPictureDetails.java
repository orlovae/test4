package ru.aleksandrorlov.domain.interactor;

import io.reactivex.Observable;
import ru.aleksandrorlov.domain.YandexPicture;
import ru.aleksandrorlov.domain.executor.PostExecutionThread;
import ru.aleksandrorlov.domain.executor.ThreadExecutor;
import ru.aleksandrorlov.domain.repository.YandexPictureRepository;
import ru.aleksandrorlov.domain.util.Preconditions;

/**
 * Created by alex on 16.03.18.
 */

public class GetYandexPictureDetails extends UseCase<YandexPicture, GetYandexPictureDetails.Params> {

    private final YandexPictureRepository repository;

    @Inject
    GetYandexPictureDetails(YandexPictureRepository repository, ThreadExecutor threadExecutor,
                   PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    Observable<YandexPicture> buildUseCaseObservable(Params params) {
        Preconditions.checkNotNull(params);
        return this.repository.yandexPicture(params.yandexPictureId);
    }

    public static final class Params {

        private final int yandexPictureId;

        private Params(int yandexPictureId) {
            this.yandexPictureId = yandexPictureId;
        }

        public static Params forYandexPicture(int yandexPictureId) {
            return new Params(yandexPictureId);
        }
    }
}
