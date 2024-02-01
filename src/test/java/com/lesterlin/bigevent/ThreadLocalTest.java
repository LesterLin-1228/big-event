package com.lesterlin.bigevent;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    public void testThreadLocalSetAndGet(){
        // 提供一個ThreadLocal對象
        ThreadLocal tl = new ThreadLocal();
        // 開啟兩個線程
        new Thread(()->{
            tl.set("Lester");
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
        },"藍色").start();

        new Thread(()->{
            tl.set("Mona");
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
        },"綠色").start();
    }
}
