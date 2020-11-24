package Test.Study;

import java.util.concurrent.locks.ReentrantLock;

public class A20201123 {
    public int sharedState;
    ReentrantLock reentrantLock = new ReentrantLock(true);

    /**
     *   非安全操作:
     *      后++ 是先使用，再++ ，因此 former正常会比 latter 少 1
     */
    public void nonSafeAction() {
        while (sharedState < 100000) {
            int former = sharedState++;
            int latter = sharedState;
            if (former != latter - 1) {
                System.out.printf("Observed data race, former is " + former + ", " + "latter is " + latter);
            }
        }
    }
    /**
     *   安全操作:
     *      synchronized (this) 来锁住赋值过程
     */
    public void SafeAction() {
        while (sharedState < 100000) {
            synchronized (this){
                int former = sharedState++;
                int latter = sharedState;
            if (former != latter - 1) {
                System.out.printf("Observed data race, former is " + former + ", " + "latter is " + latter);
            }
         }
        }
    }

    /**
     *   安全操作:
     *      ReentrantLock
     */
    public void SafeActionByReentrantLock() {
        while (sharedState < 100000) {
            try{
                reentrantLock.lock();  //可重入的测试
                reentrantLock.lock();
                int former = sharedState++;
                int latter = sharedState;
                if (former != latter - 1) {
                    System.out.printf("Observed data race, former is " + former + ", " + "latter is " + latter);
                }
            }finally {
                reentrantLock.unlock();
                reentrantLock.unlock();
            }
        }
    }
    public static void main (String[]args) throws InterruptedException {
        final A20201123 sample = new A20201123();
        Thread threadA = new Thread(){
            @Override
            public void run(){
                sample.SafeActionByReentrantLock();
            }
        };
        Thread threadB = new Thread(){
            @Override
            public void run() {
                sample.SafeActionByReentrantLock();
            }
        };
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join(); }
}


