package Test.Study;

public class A20201123 {
    public int sharedState;

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
    public static void main (String[]args) throws InterruptedException {
        final A20201123 sample = new A20201123();
        Thread threadA = new Thread(){
            @Override
            public void run(){
                sample.SafeAction();
            }
        };
        Thread threadB = new Thread(){
            @Override
            public void run() {
                sample.SafeAction();
            }
        };
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join(); }

}


