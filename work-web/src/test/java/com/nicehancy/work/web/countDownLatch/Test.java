package com.nicehancy.work.web.countDownLatch;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/5/13 11:26
 **/
public class Test {

    @Autowired
    private ThreadDealListUtil threadDealListUtil;

    static class HandleThread extends Thread {
        private String threadName;
        private List<String> list;
        private int startIndex;
        private int endIndex;

        public HandleThread(String threadName, List<String> list, int startIndex, int endIndex) {
            this.threadName = threadName;
            this.list = list;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public void run() {
            List<String> subList = list.subList(startIndex, endIndex);
            System.out.println(threadName+"处理了"+subList.size()+"条！startIndex:"+startIndex+"|endIndex:"+endIndex);
        }

    }

    public static void main(String[] args) {
        Test test = new Test();
        List<String> tmpList = new ArrayList<String>();
        for (int i = 0; i < 30025; i++) {
            tmpList.add("test" + i);
        }
        int length = tmpList.size();
        int num = 100; //初始线程数
        //启动多线程
        if(num > length){
            num = length;
        }
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
            HandleThread thread = new HandleThread("线程[" + (i + 1) + "] ",  tmpList,start , end);
            thread.start();
        }
    }

    @org.junit.Test
    public void DoWorkTest(){

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30025; i++) {
            list.add("A" + i);
        }
        threadDealListUtil.doSynchronousWork(list);
    }
}