package com.ermu.thread.wait;

/**
 * @author：xusonglin
 * ===============================
 * Created with IDEA.
 * Date：2019/1/10
 * Time：22:05
 * ================================
 * thread.resume() 方法本身并无问题，但是不能独立于suspend()方法存在
 * 当resume执行了，但是suspend还没执行就会陷入死锁，导致没释放
 */
public class SuspendThread implements Runnable {
    private  static  Object object = new Object();
    @Override
    public void run() {
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"获取到了资源");
            Thread.currentThread().suspend();
        }
        System.out.println(Thread.currentThread().getName()+"释放了资源");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new SuspendThread(),"thread-1");
//        Thread thread2 = new Thread(new SuspendThread(),"thread-2");

        thread1.start();
//        thread2.start();
        Thread.sleep(1000L);
        thread1.resume();
//        thread2.resume();
    }

}
