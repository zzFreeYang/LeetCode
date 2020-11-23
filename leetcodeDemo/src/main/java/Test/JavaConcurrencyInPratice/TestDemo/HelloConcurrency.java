package Test.JavaConcurrencyInPratice.TestDemo;

import Test.JavaConcurrencyInPratice.Demo1_1;


public class HelloConcurrency {

    public static void main(String[] args) {

        Demo1_1 demo1_1_a = new Demo1_1();
        Demo1_1 demo1_1_b = new Demo1_1();

        for(int i = 0 ;i < 100 ; i++){
            demo1_1_a.service();
            demo1_1_b.service();
        }
        System.out.println(demo1_1_a.getCount());
        System.out.println(demo1_1_b.getCount());

    }
}
