package com.nicehancy.work.common.utils;

import com.itextpdf.text.Font;
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
import java.util.UUID;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

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

    /**
     * iText生成PDF文件
     * @param path      生成文件路径
     */
    public static void createPDF(String path){

        // 1.1新建document对象
        Document document = new Document();
        //生成一个唯一的临时文件名
        String fileName = UUID.randomUUID().toString();
        // 1.2.建立一个书写器(Writer)与document对象关联
        try {
            // 创建 PdfWriter 对象
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path + fileName
                    + ".pdf"));

            // 1.3.打开文档
            document.open();

            //中文字体,解决中文不能显示问题
            BaseFont chinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.
                    NOT_EMBEDDED);

            //中文字体,7号，正常
            Font font = new Font(chinese, 7, Font.NORMAL);

            //创建10列的表
            PdfPTable table = new PdfPTable(10);
            List<PdfPRow> listRow = table.getRows();

            //头
            PdfPCell[] cells = new PdfPCell[10];
            PdfPRow rowHead = new PdfPRow(cells);
            //单元格
            cells[0] = new PdfPCell(new Paragraph("批次号", font));
            cells[0].setBorderColor(BaseColor.LIGHT_GRAY);
            cells[0].setHorizontalAlignment(Element.ALIGN_CENTER);
            cells[0].setBackgroundColor(BaseColor.ORANGE);

            cells[1] = new PdfPCell(new Paragraph("批次类型", font));
            cells[1].setBorderColor(BaseColor.LIGHT_GRAY);
            cells[1].setHorizontalAlignment(Element.ALIGN_CENTER);
            cells[1].setBackgroundColor(BaseColor.ORANGE);

            cells[2] = new PdfPCell(new Paragraph("省份", font));
            cells[2].setBorderColor(BaseColor.LIGHT_GRAY);
            cells[2].setHorizontalAlignment(Element.ALIGN_CENTER);
            cells[2].setBackgroundColor(BaseColor.ORANGE);

            cells[3] = new PdfPCell(new Paragraph("地市", font));
            cells[3].setBorderColor(BaseColor.LIGHT_GRAY);
            cells[3].setHorizontalAlignment(Element.ALIGN_CENTER);
            cells[3].setBackgroundColor(BaseColor.ORANGE);

            cells[4] = new PdfPCell(new Paragraph("工单总数", font));
            cells[4].setBorderColor(BaseColor.LIGHT_GRAY);
            cells[4].setHorizontalAlignment(Element.ALIGN_CENTER);
            cells[4].setBackgroundColor(BaseColor.ORANGE);

            cells[5] = new PdfPCell(new Paragraph("已认领数", font));
            cells[5].setBorderColor(BaseColor.LIGHT_GRAY);
            cells[5].setHorizontalAlignment(Element.ALIGN_CENTER);
            cells[5].setBackgroundColor(BaseColor.ORANGE);

            cells[6] = new PdfPCell(new Paragraph("工单提交数", font));
            cells[6].setBorderColor(BaseColor.LIGHT_GRAY);
            cells[6].setHorizontalAlignment(Element.ALIGN_CENTER);
            cells[6].setBackgroundColor(BaseColor.ORANGE);

            cells[7] = new PdfPCell(new Paragraph("审核通过数", font));
            cells[7].setBorderColor(BaseColor.LIGHT_GRAY);
            cells[7].setHorizontalAlignment(Element.ALIGN_CENTER);
            cells[7].setBackgroundColor(BaseColor.ORANGE);

            cells[8] = new PdfPCell(new Paragraph("审核失败数", font));
            cells[8].setBorderColor(BaseColor.LIGHT_GRAY);
            cells[8].setHorizontalAlignment(Element.ALIGN_CENTER);
            cells[8].setBackgroundColor(BaseColor.ORANGE);

            cells[9] = new PdfPCell(new Paragraph("成本消耗值", font));
            cells[9].setBorderColor(BaseColor.LIGHT_GRAY);
            cells[9].setHorizontalAlignment(Element.ALIGN_CENTER);
            cells[9].setBackgroundColor(BaseColor.ORANGE);
            //把第一行添加到集合
            listRow.add(rowHead);
            //写入数据
            //for (InspectionProgressResBO inspectionProgressResBO : list) {
            PdfPCell[] cellsData = new PdfPCell[10];
            PdfPRow row = new PdfPRow(cellsData);
            cellsData[0] = new PdfPCell(new Paragraph("", font));
            cellsData[0].setBorderColor(BaseColor.LIGHT_GRAY);
            cellsData[0].setHorizontalAlignment(Element.ALIGN_CENTER);
            //返回固定值 -巡检
            cellsData[1] = new PdfPCell(new Paragraph("巡检", font));
            cellsData[1].setBorderColor(BaseColor.LIGHT_GRAY);
            cellsData[1].setHorizontalAlignment(Element.ALIGN_CENTER);
            cellsData[2] = new PdfPCell(new Paragraph("", font));
            cellsData[2].setBorderColor(BaseColor.LIGHT_GRAY);
            cellsData[2].setHorizontalAlignment(Element.ALIGN_CENTER);
            cellsData[3] = new PdfPCell(new Paragraph("", font));
            cellsData[3].setBorderColor(BaseColor.LIGHT_GRAY);
            cellsData[3].setHorizontalAlignment(Element.ALIGN_CENTER);
            cellsData[4] = new PdfPCell(new Paragraph("", font));
            cellsData[4].setBorderColor(BaseColor.LIGHT_GRAY);
            cellsData[4].setHorizontalAlignment(Element.ALIGN_CENTER);
            cellsData[5] = new PdfPCell(new Paragraph("", font));
            cellsData[5].setBorderColor(BaseColor.LIGHT_GRAY);
            cellsData[5].setHorizontalAlignment(Element.ALIGN_CENTER);
            cellsData[6] = new PdfPCell(new Paragraph("", font));
            cellsData[6].setBorderColor(BaseColor.LIGHT_GRAY);
            cellsData[6].setHorizontalAlignment(Element.ALIGN_CENTER);
            cellsData[7] = new PdfPCell(new Paragraph("", font));
            cellsData[7].setBorderColor(BaseColor.LIGHT_GRAY);
            cellsData[7].setHorizontalAlignment(Element.ALIGN_CENTER);
            cellsData[8] = new PdfPCell(new Paragraph("", font));
            cellsData[8].setBorderColor(BaseColor.LIGHT_GRAY);
            cellsData[8].setHorizontalAlignment(Element.ALIGN_CENTER);
            cellsData[9] = new PdfPCell(new Paragraph("", font));
            cellsData[9].setBorderColor(BaseColor.LIGHT_GRAY);
            cellsData[9].setHorizontalAlignment(Element.ALIGN_CENTER);

            listRow.add(row);
            //}

            //把表格添加到文件中
            document.add(table);

            // 1.5.关闭文档
            document.close();
            // 1.6.关闭流
            writer.close();
        }catch (IOException e){
            log.error("文件流读取失败");
        }catch (DocumentException e){
            log.error("文件操作异常");
        }
    }
}