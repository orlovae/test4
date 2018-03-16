package ru.aleksandrorlov.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by alex on 16.03.18.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
