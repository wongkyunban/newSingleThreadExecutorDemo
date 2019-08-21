package com.wong.newsinglethreadexecutordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    // 1、创建三个线程任务，分别用来输出A！、B！、C！
    // 2、创建单线程池

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Thread(new TaskA()));
        executor.execute(new Thread(new TaskB()));
        executor.execute(new Thread(new TaskC()));
        // 3.测试结果,保证按入队顺序执行
        // 2019-08-21 17:31:42.119 8586-8722/com.wong.newsinglethreadexecutordemo D/TaskA: A!
        // 2019-08-21 17:31:42.120 8699-8699/? I/m.xiaomi.marke: The ClassLoaderContext is a special shared library.
        // 2019-08-21 17:31:42.120 8586-8722/com.wong.newsinglethreadexecutordemo D/TaskB: B!
        // 2019-08-21 17:31:42.123 8586-8722/com.wong.newsinglethreadexecutordemo D/TaskC: C!

    }

    public static class TaskA implements Runnable{

        @Override
        public void run() {
            Log.d("TaskA","A!");
        }
    }
    public static class TaskB implements Runnable{

        @Override
        public void run() {
            Log.d("TaskB","B!");
        }
    }
    public static class TaskC implements Runnable{

        @Override
        public void run() {
            Log.d("TaskC","C!");
        }
    }
}
