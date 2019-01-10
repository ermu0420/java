package com.ermu.thread.interrupt;

/**
 * @author：xusonglin
 * ===============================
 * Created with IDEA.
 * Date：2019/1/10
 * Time：21:40
 * ================================
 * Thread.interrupt方法
 * 	自行定义一个标志，用来判断是否继续执行
 */
public class InterruptThread extends Thread{
    private int i = 0;
    private int j = 0;
    @Override
    public void run() {
        if(!Thread.currentThread().isInterrupted()){
            i++;
            j++;
        }
    }
    public void printf(){
        System.out.println("i:"+i);
        System.out.println("j:"+j);
    }
    public static void main(String[] args) throws InterruptedException {
        InterruptThread thread = new InterruptThread();
        thread.start();
        thread.interrupt();
        Thread.sleep(1000L);
        thread.printf();
    }
}
