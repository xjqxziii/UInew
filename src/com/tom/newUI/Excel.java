/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tom.newUI;

/**
 *
 * @author Tom
 */

//生成Excel的类
import java.io.File;

import jxl.Workbook;
import jxl.Cell;
import jxl.Sheet;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Excel
{
    //excel文件操作类
    private Workbook    rworkbook;
    private Sheet       rsheet;
    private WritableWorkbook wbook;
    private WritableSheet   wsheet;
    public String       FileName;
    Excel(String name){
        this.FileName   = name;
    }
    //创建excel文件或者
    public void CreateExcel(String Excelname,String Sheetname) 
    {
        try {
            File file = new File(Excelname);

            // 只获得文件名，无路径
            String fileName = file.getName();

            // 获取文件名和路径
            String fileFront = Excelname.substring(0, Excelname.lastIndexOf("."));

            // 获取文件后缀
            fileName = fileName.substring(fileName.lastIndexOf(".") + 1);

            if (!fileName.equals("xls")) {
                System.out.println("后缀名错误，一定要xls，不是" + fileName);
                return;
            }

            if (!file.exists()) {
                // 创建文件
                wbook = Workbook.createWorkbook(new File(Excelname));
            } else {
                rworkbook = Workbook.getWorkbook(new File(Excelname));
                wbook     = Workbook.createWorkbook(new File(fileFront + "_modified.xls"),rworkbook);
            }

            // 0表示第一个sheet,需首先创建sheet名字
            wsheet = wbook.createSheet(Sheetname, 0);
            // this.rsheet = rworkbook.getSheet(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //修改当前sheet名字
    public void SetSheetName(String Name)
    {
        wsheet.setName(Name);
    }

    public void CreateNewSheet(String SheetName, int index) {
        try {
            wbook.createSheet(SheetName, index);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 关闭excel
    public void CloseExcel() {
        try {
            // write函数必须要调用
            wbook.write();
            wbook.close();
            rworkbook.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 在任意一行添加数据
    void AddCell(int row, int column, String content) {
        try {
            Label label = new Label(row, column, content);
            wsheet.addCell(label);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 在新的一行添加数据
    void AddDataToColumnLast(int row, String Data) {
        try {
            int column = wsheet.getRows();
            wsheet.addCell(new Label(row, column, Data));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 在新的一列添加数据
    void AddDataToRowLast(int column, String Data) {
        try {
            int row = wsheet.getColumns();
            wsheet.addCell(new Label(row, column, Data));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void CorrectProperty() {
        try {
            // wbook.removeSheet(2); // 移除多余的标签页
            // wbook.removeSheet(3);
            //
            // wsheet.mergeCells(0, 0, 4, 0); // 合并单元格
            wsheet.setRowView(1, 600); // 设置行的高度
            wsheet.setColumnView(0, 30); // 设置列的宽度
            wsheet.setColumnView(1, 100); // 设置列的宽度
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void ReadExcel() {
        try {
            wbook.close();
            rworkbook.close();
            // 选取指定的excel
            rworkbook = Workbook.getWorkbook(new File(this.FileName));
            // 选取制定的sheet
            Sheet sheet = rworkbook.getSheet(0);
            // 选取指定的cell
            // 遍历循环得到所要的cell值
            for (int j = 0; j < sheet.getRows(); j++)
                for (int i = 0; i < sheet.getColumns(); i++) {
                    Cell cell = sheet.getCell(i, j);
                    // 获取该cell的值
                    String var1 = cell.getContents();
                    // 打印输出该值
                    System.out.println(var1);
                }
            rworkbook.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
