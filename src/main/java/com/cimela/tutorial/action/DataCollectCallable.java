package com.cimela.tutorial.action;

import java.util.concurrent.Callable;

public class DataCollectCallable implements Callable<Object> {

    private Object data;
    private Object lock = new Object();
    
    public DataCollectCallable() {
        super();
    }

    @Override
    public Object call() throws Exception {
        synchronized (lock) {
            lock.wait();
            return data;
        }
    }
    
    public void unfreeze() {
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public void setData(Object data) {
        this.data = data;
    }

}
