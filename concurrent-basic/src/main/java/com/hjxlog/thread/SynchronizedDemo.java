package com.hjxlog.thread;

/**
 * @author Huang JX
 * @date 2022/4/1
 */
public class SynchronizedDemo {
    public void method() {

        /**
         *   0: aload_0
         *   1: dup
         *   2: astore_1
         *   3: monitorenter
         *   4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         *   7: ldc           #3                  // String synchronized demo
         *   9: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         *   2: aload_1
         *   3: monitorexit
         */
        synchronized (this) {
            System.out.println("synchronized demo");
        }
    }
}


