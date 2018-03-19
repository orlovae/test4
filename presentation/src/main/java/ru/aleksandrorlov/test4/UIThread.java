package ru.aleksandrorlov.test4;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.aleksandrorlov.domain.executor.PostExecutionThread;

/**
 * Created by alex on 18.03.18.
 */

@Singleton
public class UIThread implements PostExecutionThread {

    @Inject
    UIThread() {}

    @Override public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
