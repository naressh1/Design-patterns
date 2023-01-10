package com.ns.creational;

public class SingletonThreadSafe {
    private static volatile SingletonThreadSafe singletonThreadSafe = null;
    private SingletonThreadSafe() {
        // Avoid creating object using reflection by throwing runtime exception
        if (null != singletonThreadSafe) {
            throw new RuntimeException("Use getInstance() method to create object of SingletonThreadSafe");
        }
    }

    // This has performance issue as total method is synchronized
    /*public static synchronized SingletonThreadSafe getInstance() {
        if (null == singletonThreadSafe) {
            singletonThreadSafe = new SingletonThreadSafe();
        }
        return singletonThreadSafe;
    }*/

    // Double Check Locking
    public static SingletonThreadSafe getInstance() {
        if (null == singletonThreadSafe) {
            synchronized (SingletonThreadSafe.class) {
                if (null == singletonThreadSafe) {
                    singletonThreadSafe = new SingletonThreadSafe();
                }
            }
        }
        return singletonThreadSafe;

    }
}
