/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tom.newUI;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author tom
 */
public class DrawOneLine implements Draw{
    Fun gf;
    
    public DrawOneLine(Fun gf){
        this.gf = gf;
    }
    
    @Override
    public void draw(String title,String xlable,String ylable,double w_val){
        double x1,y1;
        XYSeries series;
        series = new XYSeries("cc");
        for(double i =-300;i+1<300;i++){
            x1=i*w_val;    
            y1=this.gf.fun(x1);
            series.add(x1,y1);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
	dataset.addSeries(series);
        XYSeriesCollection[] datasets;
        datasets = new XYSeriesCollection[]{dataset};
        
        
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
            SaveFile.saveImg(chart);
            JOptionPane.showMessageDialog(frame, "保存在程序目录下的文件夹中");
            
        });
        //添加保存图片按钮

        frame.setLayout(null);
        saveImgBn.setBounds(4, 4, 80, 20);
        frame.add(saveImgBn);
        
	frame.pack();
	frame.setVisible(true);
        //设置画图窗口显示
    }

}
