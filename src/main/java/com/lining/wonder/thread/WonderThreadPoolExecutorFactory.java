package com.lining.wonder.thread;

import java.util.concurrent.*;

/**
 * @author liningwonder
 */
public class WonderThreadPoolExecutorFactory {

    public static ThreadPoolExecutor createThreadPool(String name, int corePoolSize, int maximumPoolSize, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 1, TimeUnit.SECONDS, workQueue, new WonderThreadFactory(name));
    }

    public static ScheduledThreadPoolExecutor createScheduledThreadPool(String name, int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize, new WonderThreadFactory(name));
    }


}
