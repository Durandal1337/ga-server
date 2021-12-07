package ua.nure.gaserver.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorManager {

    private static final ExecutorService executor = Executors.newFixedThreadPool(getCPUs());

    public static <T> Collection<T> executeSync(Collection<? extends Callable<T>> tasks) throws Exception {
        List<Future<T>> futures = executor.invokeAll(tasks, 10, TimeUnit.MINUTES);
        List<T> results = new ArrayList<>(tasks.size());
        for (Future<T> future : futures) {
            results.add(future.get());
        }
        return results;
    }

    private static int getCPUs() {
        int cpus = Runtime.getRuntime().availableProcessors();
        return cpus > 10 ? cpus - 2 : cpus-1;
    }

    private ExecutorManager() {
    }
}
