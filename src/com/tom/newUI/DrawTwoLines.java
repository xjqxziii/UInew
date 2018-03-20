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
public class DrawTwoLines implements Draw{
    Fun gf;
    
    public DrawTwoLines(Fun gf){
        this.gf = gf;
    }
    
    @Override
    public void draw(String title,String xlable,String ylable,double w_val){
        double x1,y1,y2;
        
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1;
        XYSeries series2;
        series1 = new XYSeries("+");
        series2 = new XYSeries("-");
        for(double i =0;i<600;i++){
            x1=i*w_val;
            y1=this.gf.fun(x1);
            y2=this.gf.fun(x1);
            //获得两根曲线
            series1.add(x1*1000000000.0,y1);
            series2.add(x1*1000000000.0,y2);
        }
	dataset.addSeries(series1);
	dataset.addSeries(series2);
        
        XYSeriesCollection[] datasets;
        datasets = new XYSeriesCollection[]{dataset};
	
	dataset.addSeries(series1);
	dataset.addSeries(series2);
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
