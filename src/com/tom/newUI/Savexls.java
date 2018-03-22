package com.tom.newUI;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tom
 */
public class Savexls {
    
    public static boolean save(String[] ff){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        // new Date()为获取当前系统时间
        String fileName = df.format(new Date())+".jpg";
        fileName="./"+fileName;
        Excel excel = new Excel(fileName); 
        //excel文件保存位置为程序目录下的data.xls
        try {
            excel.CreateExcel(fileName, "Data");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        excel.AddCell(0,0, "频偏");
        excel.AddCell(1,0,ff[0]+"MHz");
        excel.AddCell(0,1,"λ");
        excel.AddCell(1,1,ff[1]+"dBW/Hz");
        excel.AddCell(0,2,"RMS带宽");
        excel.AddCell(1,2,ff[2]+"MHz");
        excel.AddCell(0,3,"等效矩形带宽");
        excel.AddCell(1,3,ff[3]+"MHz");
        excel.AddCell(0,4,"与自身的频谱隔离系数");
        excel.AddCell(1,4,ff[4]+"dB/Hz");
        excel.AddCell(0,5,"与1.023的频谱隔离系数");
        excel.AddCell(1,5,ff[5]+"dB/Hz");
        excel.AddCell(0,6,"与（10,5）的频谱隔离系数");
        excel.AddCell(1,6,ff[6]+"dB/Hz");
        //添加数据
        excel.CloseExcel();
        //关闭文件流
        
        return true;
    }
}
