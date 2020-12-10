package Test.Study.Base;

public class A20201125 {
    /**
     * 线程实现的两个基本方法: 1. 扩展 Thread类 2 .实现 Runnable
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            System.out.println("Hello World!");
        };
        Thread myThread = new Thread(task);
        myThread.start();
        myThread.join();  //由于 myThread.join了，所以end一定在hello world后面
        System.out.println("end");
    }
}
