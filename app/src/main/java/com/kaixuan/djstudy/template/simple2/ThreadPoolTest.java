package com.kaixuan.djstudy.template.simple2;

import android.support.annotation.NonNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Comment:模板模式
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2018/3/6
 */
public class ThreadPoolTest {


    private static ThreadPoolExecutor threadPoolExecutor;

    // Queue 的参数
    // BlockingQueue : 先进先出FIFO,先进去先执行(rxjava)
    // SynchronousQueue : 线程安全的队列,里面没有固定的缓存队列(okhttp)
    // PriorityBlockingQueue : 无序的,可以根据优先级进行排序,执行的对象要实现Comparable 作比较

    private static final BlockingQueue<Runnable> sPoolWorkQueue=
            new LinkedBlockingQueue<>(128);// 4的话hui报错

    //RejectedExecutionException  报错的原因也是As要能沉Task 存在的一些隐患,比如有300个Runnable就一定会报错
    //线程队列是4    核心线程数也是4   最大线程数是10
    //目前加入的线程有20个 ,20个都要放入到队列中,但是队列只能放入4个还有剩下的16个是没法放置的
    //这个时候最大线程数就是10   非核心线程数是6
    //那么会拿6个出来执行,这个时候就重新创建6个线程,目前线程池就到达10个线程,但是剩下的10个Runnable没办法执行就会抛异常

    static {


        //会有20个Runnable 加入到线程队列(缓存队列),会先去取4个Runnable去执行,等这个四个运行完毕,就又回去取4个Runnable交给线程池来执行
        threadPoolExecutor = new ThreadPoolExecutor(
                4,//核心线程数,就是线程池里面的核心线程数量
                10,//最大线程数,线程池中的最大线程数量
                60,//线程的存活时间,空闲存活时间,超过这个时间就会被销毁
                TimeUnit.SECONDS,//线程存活时间的单位
                sPoolWorkQueue,//线程队列

                new ThreadFactory(){//线程创建工厂,如果线程池需要创建线程就会调用 newThread来创建
                    @Override
                    public Thread newThread(@NonNull Runnable runnable) {

                        Thread thread=   new Thread(runnable,"自己的线程名字");
                        thread.setDaemon(false);//不是守护线程
                        return thread;
                    }
                });

    }

   void newRunnable(){
        for (int i = 0; i <20 ; i++) {
//           Runnable runnable =new Runnable() {
//               @Override
//               public void run() {
//                       try {
//                           Thread.sleep(1000);
//                       } catch (InterruptedException e) {
//                           e.printStackTrace();
//                       }
//                       System.out.print("下载图片等耗时操作 完毕"+Thread.currentThread().getName());
//               }
//           };
       Request request =new Request();
           //加入线程队列,寻找合适的实际去执行(不会立刻执行)
            threadPoolExecutor.execute(request);

       }

    }


}
