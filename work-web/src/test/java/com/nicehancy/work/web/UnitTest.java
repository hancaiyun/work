package com.nicehancy.work.web;

import com.nicehancy.work.common.utils.FileUtil;
import com.nicehancy.work.common.utils.RegularValidatorUtil;
import com.nicehancy.work.web.base.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.xml.soap.Node;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;

/**
 * <p>
 *     单元、自定义测试
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/9 12:10
 **/
@Slf4j
public class UnitTest extends BaseSpringTest {

    static int arr[] = new int[10];

    @Test
    public void test(){
        log.info("{}",arr[1]);
    }

    /**
     * 加密
     */
    @Test
    public void encoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密
        String encode = bCryptPasswordEncoder.encode("123456");
        log.info("密文：{}", encode);
        log.info("数据库存储格式为:{}","{bcrypt}" + encode);
    }

    /**
     * 邮箱验证测试
     */
    @Test
    public void isEmailTest(){
        String str = "nicehancy@yeah.net";
        log.info("验证结果：{}", RegularValidatorUtil.isEmail(str));
    }

    /**
     * 数字字母组成测试
     */
    @Test
    public void isNumAndLetterTest(){
        String str = "231~";
        log.info("验证结果：{}", RegularValidatorUtil.isNumAndLetter(str));
    }

    @Test
    public void fileTest(){

        FileUtil.createFile();
    }

    @Test
    public void hashMapTest(){
        HashMap hashMap = new HashMap();
        hashMap.put("1","A");
        hashMap.put("1","B");
        hashMap.put("1","C");

        hashMap.put("2","D");


        log.info("打印结果 ：{}", hashMap);
    }

    @Test
    public void test1(){
        //Class.forName().get
        String str = "";
        str.hashCode();
    }

    @Test
    public void test2(){

        Integer a = 13;
        Integer b = 13;

        if(a == b){
            log.info("两者相等");
        }else{
            log.info("两者不相等");
        }
    }

    @Test
    public void test3(){

            int i=130000;
            int j=130000;
            if(i==j){
                log.info("{}","两者相等");
            }
    }


    @Test
    public void threadTest(){

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.print("A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(700);
                System.out.print("B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(900);
                System.out.print("C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    @Test
    public void poiTest(){

        //创建workBook
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建一个样式
        HSSFCellStyle cellStyle = wb.createCellStyle();
        //创建一个DataFormat对象
        HSSFDataFormat format = wb.createDataFormat();
        //这样才能真正的控制单元格格式，@就是指文本型，具体格式的定义还是参考上面的原文吧
        cellStyle.setDataFormat(format.getFormat("@"));

        //具体如何创建cell就省略了，最后设置单元格的格式这样写
        //cell.setCellStyle(cellStyle);
    }

    @Test
    public void StringTest(){
//        String a = "abc";
//        String b = "abc";
//        log.info("打印结果:{}", a == b);

            String a = "Programming";

            String b = new String("Programming");

            String e = new String("Programming");

            String c = "Program" + "ming";

            System.out.println(a == b);//false

            System.out.println(a == c);//true

            System.out.println(a.equals(b));//true

            System.out.println(a.equals(c));//true

            System.out.println(a.intern() == b.intern());//true

            System.out.println(b == e);
    }

    @Test
    public void integerTest(){

        Integer integer = 128;//[-128,127]
        Integer integer1 = 128;
        log.info("{}", integer == integer1);
    }

    @Test
    public void intTest(){
        int a = 1000;
        int b = 1000;

        byte b1=13;
        byte b2=13;
        log.info("{}", b1 == b2);
    }

    @Test
    public void listTest(){
        List list = new ArrayList();
        for(int i = 0; i<5; i++){
            list.add(list);
        }
        log.info("list:{}",list);
        List subList = list.subList(0,2);
        log.info("subList:{}", subList);
        subList.remove(0);
        log.info("list:{},subList:{}", list, subList);
    }
}
