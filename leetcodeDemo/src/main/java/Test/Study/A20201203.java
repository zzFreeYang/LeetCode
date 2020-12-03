package Test.Study;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class A20201203 {

    private int times; //打印次数
    private int state; //当前状态
    private static  Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    public A20201203(int times){
        this.times = times;
    }

    private void printLetter(String name,int targetState,Condition current,Condition next){
        for(int i = 0 ; i < times;){
            lock.lock();  //Condition 是需要与"互斥锁"/"共享锁"捆绑使用的。
                try {
                    while(state % 3 != targetState) {
                        current.await();
                    }
                    state++;
                    i++;
                    System.out.println(name);
                    next.signal();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }

    public static void main(String[] args) {
        A20201203 a20201203 = new A20201203(2);  //循环次数

        new Thread( ()->{a20201203.printLetter("A",0,c1,c2);},"A").start();
        new Thread( ()->{a20201203.printLetter("B",1,c2,c3);},"B").start();
        new Thread( ()->{a20201203.printLetter("C",2,c3,c1);},"C").start();
    }

}
