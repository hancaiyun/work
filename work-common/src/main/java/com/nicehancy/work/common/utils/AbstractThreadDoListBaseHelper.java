package com.nicehancy.work.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *     开启线程同步处理业务公共处理类
 *     将字符串数组均匀分布到指定线程中
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/5/13 14:39
 **/
@Slf4j
public abstract class AbstractThreadDoListBaseHelper {

    /**
     * 线程数大小
     */
    public static final int THREAD_SIZE_OF_FEE_SHARE = 100;

    /**
     * 创建数组型缓冲等待队列
     */
    private static BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(100);

    /**
     * ThreadPoolExecutor:创建自定义线程池，池中保存的线程数为8，允许最大的线程数为16
     */
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16,
            500, TimeUnit.MILLISECONDS, blockingQueue);

    class HandleThread extends Thread {
        private String threadName;
        private List<String> list;
        private int startIndex;
        private int endIndex;

        HandleThread(String threadName, List<String> list, int startIndex, int endIndex) {
            this.threadName = threadName;
            this.list = list;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        /**
         * 业务方法
         */
        public void run() {

            //根据数组坐标截取数组
            List<String> subList = list.subList(startIndex, endIndex);

            //具体处理
            WorkDetail(subList);

            //log.info(threadName+"处理了"+subList.size()+"条！startIndex:"+startIndex+"|endIndex:"+endIndex);
        }
    }

    /**
     * 入口方法
     * 将数组均匀的分布到队列中
     * @param list               待处理全部列表
     */
    public void DoSynchronousWork(List<String> list) {

        //空集合校验
        if(CollectionUtils.isEmpty(list)){
            return;
        }
        //待处理列表长度
        int length = list.size();
        //初始线程数
        int num = THREAD_SIZE_OF_FEE_SHARE;
        //当待处理列表小于初始化线程数时，设置开启的线程数为待处理列表数
        if(num > length){
            num = length;
        }
        //计算数组坐标
        int baseNum = length / num;
        int remainderNum = length % num;
        int end  = 0;
        for (int i = 0; i < num; i++) {
            int start = end ;
            end = start + baseNum;
            if(i == (num-1)){
                end = length;
            }else if( i < remainderNum){
                end = end + 1;
            }

            //创建线程
            HandleThread handleThread = new HandleThread("线程[" + (i + 1) + "]", list, start, end);
            threadPoolExecutor.execute(handleThread);
        }

        //测试用，方便日志打印，主线程休眠5秒
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    /**
     * 业务具体处理，抽象方法
     * @param list                 每个队列待处理列表
     */
    public abstract void WorkDetail(List<String> list);
}
