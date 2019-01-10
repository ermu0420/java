package com.ermu.thread.state;

import java.io.IOException;

/**
 * @author：xusonglin
 * ===============================
 * Created with IDEA.
 * Date：2019/1/10
 * Time：20:24
 * ================================
 */
public class ThreadStateDemo {

    public static void main(String[] args) throws InterruptedException {
        // RUNNABLE 等待
        Thread thread = new Thread(() ->{
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread.start();

        // BLOCKED
        Object object = new Object();
        Thread thread1 = new Thread(() ->{
           synchronized (object){
               try {
                   Thread.sleep(10000000000L);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        thread1.start();

        Thread.sleep(200L);

        Thread thread2 = new Thread(() ->{
            synchronized (object){
                System.out.println("好久我才能运行");
            }
        });

        thread2.start();


        // wait
        Object object2 = new Object();
        Thread thread3 = new Thread(() ->{
            synchronized (object2){
                try {
                    object2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();


    }
}
