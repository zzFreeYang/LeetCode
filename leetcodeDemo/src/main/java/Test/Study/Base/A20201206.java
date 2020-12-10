package Test.Study.Base;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.*;

public class A20201206 {
    public static void main(String[] args) {
        ExecutorService executorService1 = newSingleThreadExecutor();
        ExecutorService executorService2 = newFixedThreadPool(4);
        ExecutorService executorService3 = newCachedThreadPool();
    }
}
