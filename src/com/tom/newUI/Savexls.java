package com.tom.newUI;

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
        Excel excel = new Excel("./data.xls");       
        try {
            excel.CreateExcel("./data.xls", "Data");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        excel.AddCell(0,0, "频偏");
        excel.AddCell(1,0,ff[0]+"MHz");
        excel.AddCell(0,1,"最大功率谱密度");
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
        excel.CloseExcel();
        
        return true;
    }
}
