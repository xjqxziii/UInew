/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tom.newUI;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author tom
 */
public class DrawFun {
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
    
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    public double getBr() {
        return br;
    }

    public void setBr(double br) {
        this.br = br;
    }
    
    int flag = -1;
    int a,b;
    double br;
    static final double ff = 1023000.0;
    
//    绘图函数
    public void paint() {
        Fun fun;
        String title=null,xlable=null,ylable=null;
        XYSeriesCollection dataset = new XYSeriesCollection();
        String type;
        if (boc) 
        {
            type = "BOC";
        }else{
            type = "BPSK";
        }
        switch(flag)
        {  
        case 0:
            fun = new St(ff,(2*a/b));
            fun.setBoc(boc);
            title=type + "时域波形";
            xlable="t";
            ylable="S(t)";
            dataset = fun.draw()[0];
        break;
        case 1:
            fun = new Gf(a,b,true);
            fun.setBoc(boc);
            title=type + "频域波形";
            xlable="f";
            ylable="G(f)";
            dataset = fun.draw()[0];
        break;
        case 2:
            fun = new Rt(new Gf(a,b,false),br);
            fun.setBoc(boc);
            title=type + "自相关波形";
            xlable="t";
            ylable="R(t)";
            dataset = fun.draw()[0];
        break;
        case 3:
            fun = new Err((int)a,(int)b);
            fun.setBoc(boc);
            title=type + "码跟踪误差";
            xlable="delta";
            ylable="码跟踪误差方差*c";
            dataset = fun.draw()[0];
        break;
        }
        
	JFreeChart chart = ChartFactory.createXYLineChart(
		title, // chart title
		xlable, // x axis label
		ylable, // y axis label
		dataset, // data
		PlotOrientation.VERTICAL,
		false, // include legend
		false, // tooltips
		false // urls
		);

	ChartFrame frame = new ChartFrame("函数波形", chart);
        JButton saveImgBn;
        saveImgBn = new JButton();
        saveImgBn.setText("保存图片");
        saveImgBn.addActionListener((java.awt.event.ActionEvent evt) -> {
            saveImg(chart);
        });

        frame.setLayout(null);
        saveImgBn.setBounds(4, 4, 80, 20);
        frame.add(saveImgBn);
        
	frame.pack();
	frame.setVisible(true);
        
    }
    private boolean boc;

    public boolean isBoc() {
        return boc;
    }

    public void setBoc(boolean boc) {
        this.boc = boc;
    }

    
    public void saveImg(JFreeChart chart){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        // new Date()为获取当前系统时间
        String fileName = df.format(new Date())+".jpg";
        fileName="./"+fileName;
        int width = 800; /* Width of the image */          
        int height = 600; /* Height of the image */                          
        File pieChart = new File(fileName);                        
        try {
            ChartUtilities.saveChartAsJPEG( pieChart, chart, width, height); 
        } 
        catch (IOException e) {
            System.out.println(e);
        }

    }
}
    
