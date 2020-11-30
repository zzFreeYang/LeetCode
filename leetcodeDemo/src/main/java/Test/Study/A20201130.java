package Test.Study;

/**
 *  简单的嵌套死锁检测代码:  两个线程相互持有各自的lock，却无法拿到另一个
 *  Thread2 obtained: lockB
 *  Thread1 obtained: lockA
 */


public class A20201130 extends Thread {

    private String first;
    private String second;
    public A20201130(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    @Override
    public void run(){
        synchronized (first) {
            System.out.println(this.getName() + " obtained: " + first);
            try {
                Thread.sleep(1000L);
                synchronized (second){
                    System.out.println(this.getName() + " obtained: " + second);
                }
            } catch (InterruptedException e) {
                //do nothins
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "lockB";
        A20201130 t1 = new A20201130("Thread1",lockA,lockB);
        A20201130 t2 = new A20201130("Thread2",lockB,lockA);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
