package Test.Study;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class A20201202 {

    /**
     *  三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串
     */
        private int times; //打印次数
        private int state; //当前状态
        private Lock lock = new ReentrantLock();

        public A20201202(int times){
            this.times = times;
        }
        //方法1: 使用Lock
//        private void printLetter(String name,int targetNum){  //1%3=1 2%3=2 3%3=0
//            for(int i = 0 ; i < times ; ){
//             lock.lock();
//             if(state % 3 == targetNum){
//                 state++;
//                 i++;
//                 System.out.println(name);
//             }
//                lock.unlock();
//            }
//        }

        //方法2：使用wait
        private static final Object LOCK = new Object();
        private void printLetter(String name,int targetNum){
            for(int i = 0 ; i < times ; i++) {
                synchronized (LOCK){
                    while( state % 3 != targetNum){
                        try {
                            System.out.println("此时是线程"+name + "此时的state是"+state);
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    state++;
                    System.out.println(name);
                    LOCK.notifyAll();
                }
            }
        }



            public static void main(String[] args) {
        A20201202 a20201202 = new A20201202(2);  //循环次数

        new Thread( ()->{a20201202.printLetter("B",1);},"B").start();

        new Thread( ()->{a20201202.printLetter("A",0);},"A").start();

        new Thread( ()->{a20201202.printLetter("C",2);},"C").start();
    }
}
