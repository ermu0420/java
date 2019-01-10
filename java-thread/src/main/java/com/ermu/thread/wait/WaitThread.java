package com.ermu.thread.wait;

/**
 * @author：xusonglin
 * ===============================
 * Created with IDEA.
 * Date：2019/1/10
 * Time：22:13
 * ================================
 * wait 会释放对资源的锁
 * notify 会随机唤醒一个等待锁的线程
 * notifyAll 唤醒所有在等待锁的线程，自行抢占cpu资源
 */
public class WaitThread implements Runnable {
    private  static  Object object = new Object();
    @Override
    public void run() {
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"获取到了资源");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"释放了资源");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new WaitThread(),"thread-1");
        Thread thread2 = new Thread(new WaitThread(),"thread-2");

        thread1.start();
        thread2.start();
        Thread.sleep(2000L);
        synchronized (object){
//            object.notify();
            //thread-1获取到了资源
            //thread-2获取到了资源
            //thread-1释放了资源
            object.notifyAll();
//            thread-1获取到了资源
//thread-2获取到了资源
//thread-1释放了资源
//thread-2释放了资源
        }

    }
}
