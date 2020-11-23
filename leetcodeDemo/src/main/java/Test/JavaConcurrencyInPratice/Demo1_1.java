package Test.JavaConcurrencyInPratice;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Demo1_1  {
//    private final AtomicLong count = new AtomicLong(0);
        private long count = 0;
    public Long getCount() {
//        return count.get();
        return  count;
    }
    public void service()  {
        ++count;
    }

}
