package ru.aleksandrorlov.data.repository;

import java.util.List;

import io.reactivex.Observable;
import ru.aleksandrorlov.data.entity.mapper.YandexPictureEntityDataMapper;
import ru.aleksandrorlov.data.repository.datasource.YandexPictureDataStore;
import ru.aleksandrorlov.data.repository.datasource.YandexPictureDataStoreFactory;
import ru.aleksandrorlov.domain.YandexPicture;
import ru.aleksandrorlov.domain.repository.YandexPictureRepository;

/**
 * Created by alex on 16.03.18.
 */

@Singleton
public class YandexPictureDataRepository implements YandexPictureRepository {
    private final YandexPictureDataStoreFactory factory;
    private final YandexPictureEntityDataMapper mapper;

    @Inject
    public YandexPictureDataRepository(YandexPictureDataStoreFactory factory,
                                       YandexPictureEntityDataMapper mapper) {
        this.factory = factory;
        this.mapper = mapper;
    }

    @Override
    public Observable<List<YandexPicture>> yandexPictures() {
        final YandexPictureDataStore dataStore = this.factory.createCloudYandexPictureDataStore();
        return dataStore.yandexPictureEntityList().map(this.mapper::transform);
    }

    @Override
    public Observable<YandexPicture> yandexPicture(long yandexPictureId) {
        final YandexPictureDataStore dataStore = this.factory.create(yandexPictureId);
        return dataStore.yandexPictureEntity(yandexPictureId).map(this.mapper::transform);
    }
}
