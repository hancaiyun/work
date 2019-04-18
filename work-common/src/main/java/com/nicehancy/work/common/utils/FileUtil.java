package com.nicehancy.work.common.utils;

import com.nicehancy.work.common.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *     文件工具类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/18 10:04
 **/
@Slf4j
public class FileUtil {

    /**
     * 无参构造函数
     */
    private FileUtil() {
    }

    /**
     * Excel文件解析
     *
     * @param model       解析模版
     * @param inputStream 文件流
     * @return 解析结果
     */
    public static List<T> analysisExcel(T model, InputStream inputStream) {

        Workbook workbook = null;
        List<T> tList = new ArrayList<>();
        try {
            workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = 0;
            int rows = sheet.getPhysicalNumberOfRows();
            for (Row row : sheet) {
                rowCount++;
                // 表头跳过，默认跳过一行，多行表头修改对应数字
                if (rowCount <= 1) {
                    continue;
                }

                //第一个元素
                Cell cell = row.getCell(0);
                String str;
                //为NULL跳过
                if (cell != null) {
                    // model= cell.toString().trim();
                }

                // 第二个元素
                cell = row.getCell(1);
                //为NULL跳过
                if (cell != null) {

                }

                // 第三个元素
                cell = row.getCell(2);
                //为NULL跳过
                if (cell != null) {

                }

                //加入请求集合
                tList.add(model);
            }

        } catch (IOException e) {
            log.error("文件解析失败");
        } catch (InvalidFormatException e) {
            log.error("文件格式错误");
        }

        return tList;
    }


    /**
     * 生成本地Excel文件
     */
    public static void createFile() {

        //1、生成Excel文件
        //创建Excel文件
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //创建sheet对象
        HSSFSheet sheet = hssfWorkbook.createSheet("Sheet1");
        //创建Excel文件标题
        String[] tableHeader = CommonConstant.FILE_HEADER_DEMO;

        HSSFRow row;
        HSSFCell cell;
        int rowIndex = 1;
        row = sheet.createRow(0);
        int i = 0;
        for (String string : tableHeader) {
            if (i == 0 || i == 3) {
                sheet.setColumnWidth(i, 20 * 100);
            } else {
                sheet.setColumnWidth(i, 20 * 240);
            }
            cell = row.createCell(i);
            cell.setCellValue(string);
            i++;
        }

        // 添加单元格注释
        // 创建HSSFPatriarch对象-注释容器.
        HSSFPatriarch patr = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置
        HSSFComment comment = patr
                .createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 3, 3, (short) 6, 3));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("开启：1  关闭：2  删除：3"));
        //设置作者
        comment.setAuthor("nicehancy");
        //追加到单元格
        sheet.getRow(0).getCell(3).setCellComment(comment);

        //设置数据
        row = sheet.createRow(rowIndex);
        cell = row.createCell(0);
        cell.setCellValue("1");

        cell = row.createCell(1);
        cell.setCellValue("19921577717");

        cell = row.createCell(2);
        cell.setCellValue("nicehancy");

        cell = row.createCell(3);
        cell.setCellValue("超级管理员");

        cell = row.createCell(4);
        cell.setCellValue("1");

        cell = row.createCell(5);
        cell.setCellValue("无");

        //2、生成本地文件
        File file=new File(CommonConstant.LOCAL_FILE_LOCATION);
        Date date = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
            OutputStream stream = new FileOutputStream(new File(file, "客户信息表_" + sdf.format(date) + ".xls"));
            //document.write(stream);
            hssfWorkbook.write(stream);
        } catch (FileNotFoundException e) {
            log.error("文件不存在");
        } catch (IOException e) {
            log.error("写文件失败");
        }finally {
            try {
                hssfWorkbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据文件名删除本地文件
     *
     * @param fileName 文件名
     */
    public static void deleteLocalFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists()) {
            if (file.delete()) {
                log.error("删除本地文件" + fileName + "成功！");
            } else {
                log.error("删除本地文件" + fileName + "失败！");
            }
        } else {
            log.error("删除本地文件失败：" + fileName + "不存在！");
        }
    }
}