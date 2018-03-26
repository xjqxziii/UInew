/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tom.newUI;

<<<<<<< HEAD
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

=======
>>>>>>> 68ab6c0309870334b9878156b4089b7ca09a3420
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
    private boolean boc;
    
    public void paint() {
        //绘图函数
<<<<<<< HEAD
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
=======
        Fun fun = null;
>>>>>>> 68ab6c0309870334b9878156b4089b7ca09a3420
        switch(flag)
        {  
        case 0:
            fun = (boc)?new St(ff,(2*a/b)):new St(ff,b);
<<<<<<< HEAD
            fun.setBoc(boc);
            title=type + "时域波形";
            xlable="t";
            ylable="S(t)";
            dataset = fun.draw()[0];
=======
>>>>>>> 68ab6c0309870334b9878156b4089b7ca09a3420
        break;
        case 1:
            fun = new Gf(a,b,true);
            
        break;
        case 2:
            fun = new Rt(new Gf(a,b,false),br);
        break;
        case 3:
            fun = new ManyWaysErr((int)a,(int)b);
        break;
        case 4:
            fun = new ManyWaysErr((int)a,(int)b);
            fun.setBoc(boc);
            title=type + "多径码跟踪误差";
            xlable="delta";
            ylable="码跟踪误差方差*c";
            dataset = fun.draw()[0];
        break;
        }
<<<<<<< HEAD
        
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
        //画图窗口创建
        JButton saveImgBn;
        saveImgBn = new JButton();
        saveImgBn.setText("保存图片");
        saveImgBn.addActionListener((java.awt.event.ActionEvent evt) -> {
            //绑定按键按下事件
            saveImg(chart);
            JOptionPane.showMessageDialog(frame, "保存在程序目录下的文件夹中");
            
        });
        //添加保存图片按钮

        frame.setLayout(null);
        saveImgBn.setBounds(4, 4, 80, 20);
        frame.add(saveImgBn);
        
	frame.pack();
	frame.setVisible(true);
        //设置画图窗口显示
        
=======
        fun.setBoc(boc);
        fun.draw();
>>>>>>> 68ab6c0309870334b9878156b4089b7ca09a3420
    }

    public boolean isBoc() {
        return boc;
    }

    public void setBoc(boolean boc) {
        this.boc = boc;
    }
<<<<<<< HEAD

    
    public void saveImg(JFreeChart chart){
        //保存图像函数
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
=======
>>>>>>> 68ab6c0309870334b9878156b4089b7ca09a3420
}
    
