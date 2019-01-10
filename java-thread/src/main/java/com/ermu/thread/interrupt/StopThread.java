package com.ermu.thread.interrupt;

/**
 * @author：xusonglin
 * ===============================
 * Created with IDEA.
 * Date：2019/1/10
 * Time：21:39
 *  stop 线程直接进行停止，导致线程中方法有可能未运行完，导致线程安全问题
 * ================================
 */
public class StopThread extends Thread {
    private int i = 0;
    private int j = 0;
    @Override
    public void run() {
        i++;
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
    }

    public void printf(){
        System.out.println("i:"+i);
        System.out.println("j:"+j);
    }

    public static void main(String[] args) throws InterruptedException {
        StopThread thread = new StopThread();
        thread.start();
        Thread.sleep(100L);
        thread.stop();
        thread.printf();
    }
}
