package com.ermu.thread.lock;


import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author：xusonglin
 * ===============================
 * Created with IDEA.
 * Date：2019/1/15
 * Time：22:11
 * ================================
 */
public class ReentrantLockDemo {



    private int i = 0;

    private void add(){
        i++;
    }

    public static void main(String[] args) {
        ReentrantLock noFairLock = new ReentrantLock();
        ReentrantLock fairLock = new ReentrantLock(true);
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                try {
                    noFairLock.lock();
                    reentrantLockDemo.add();
                }finally {
                    noFairLock.unlock();
                }


            }).start();
        }



    }

//    abstract static class Sync extends AbstractQueuedSynchronizer {
//        private static final long serialVersionUID = -5179523762034025860L;
//
//        /**
//         * Performs non-fair tryLock.  tryAcquire is implemented in
//         * subclasses, but both need nonfair try for trylock method.
//         */
//        final boolean nonfairTryAcquire(int acquires) {
//            // 当前线程
//            final Thread current = Thread.currentThread();
//            // 获取AQS状态值
//            int c = getState();
//            if (c == 0) {
//                // 没锁，cas ，直接获取锁
//                if (compareAndSetState(0, acquires)) {
//                    // 将当前线程设置为锁的拥有线程
//                    setExclusiveOwnerThread(current);
//                    return true;
//                }
//            }
//            else if (current == getExclusiveOwnerThread()) {
//                // 当前线程就是拥有锁的线程 （重入） 记录重入次数 ++
//                int nextc = c + acquires;
//                if (nextc < 0)
//                    // overflow
//                    throw new Error("Maximum lock count exceeded");
//                // 更新状态值
//                setState(nextc);
//                return true;
//            }
//            return false;
//        }
//
//        @Override
//        protected final boolean tryRelease(int releases) {
//            int c = getState() - releases;
//            if (Thread.currentThread() != getExclusiveOwnerThread())
//                throw new IllegalMonitorStateException();
//            boolean free = false;
//            if (c == 0) {
//                free = true;
//                setExclusiveOwnerThread(null);
//            }
//            setState(c);
//            return free;
//        }
//
//        @Override
//        protected final boolean isHeldExclusively() {
//            // While we must in general read state before owner,
//            // we don't need to do so to check if current thread is owner
//            return getExclusiveOwnerThread() == Thread.currentThread();
//        }
//
//        final ConditionObject newCondition() {
//            return new ConditionObject();
//        }
//
//        // Methods relayed from outer class
//
//        final Thread getOwner() {
//            return getState() == 0 ? null : getExclusiveOwnerThread();
//        }
//
//        final int getHoldCount() {
//            return isHeldExclusively() ? getState() : 0;
//        }
//
//        final boolean isLocked() {
//            return getState() != 0;
//        }
//
//        /**
//         * Reconstitutes the instance from a stream (that is, deserializes it).
//         */
//        private void readObject(java.io.ObjectInputStream s)
//                throws java.io.IOException, ClassNotFoundException {
//            s.defaultReadObject();
//            setState(0); // reset to unlocked state
//        }
//    }



}
