/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tom.newUI;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
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
public class ManyWaysErr{
    int a;
    int b;
    private boolean boc;
    private double T;
    private double max;
    
    public ManyWaysErr(int a,int b) {
        this.a = a;
        this.b = b;
    }
    public double[] fun(double d){
        Gf gf = new Gf(a, b,false);
        gf.setBoc(boc);
        double det = 40/1000000000.0;
        double br = 24000000.0;
        Double tempSinCos=0.0;
        Double tempSin=0.0;
        Double tempSin2=0.0;
        double tc = 2/(b*DrawFun.ff);
        Callable<Double> td0 = new Callable<Double>(){
                public Double call() throws Exception{
                double br = 24000000.0;
                double temp=0;
                gf.setLog(false);
                for(double f=-(br/2-1);f<br/2;f=f+br/10000){
                    temp=temp+gf.fun(f)*Math.sin(Math.PI*f*tc*det)*Math.sin(2*Math.PI*f*d)*br/10000;
                }
                return temp;
            }
        };
        Callable<Double> td1 = new Callable<Double>(){
                public Double call() throws Exception{
                double br = 24000000.0;
                double temp=0;
                gf.setLog(false);
                for(double f=-(br/2-1);f<br/2;f=f+br/10000){
                    temp=temp+f*gf.fun(f)*Math.sin(Math.PI*f*tc*det)*br/10000;
                }
                return temp;
            }
        };
        Callable<Double> td2 = new Callable<Double>(){
                public Double call() throws Exception{
                double br = 24000000.0;
                double temp=0;
                gf.setLog(false);
                for(double f=-(br/2-1);f<br/2;f=f+br/10000){
                    temp=temp+f*gf.fun(f)*Math.sin(Math.PI*f*tc*det)*Math.cos(2*Math.PI*f*d)*br/10000;
                }
                return temp;
            }
        };
        FutureTask<Double> future0 = new FutureTask<>(td0);
        FutureTask<Double> future1 = new FutureTask<>(td1);
        FutureTask<Double> future2 = new FutureTask<>(td2);
        new Thread(future0).start();
        new Thread(future1).start();
        new Thread(future2).start();
        try {
		tempSin2 = future0.get();
		tempSin = future1.get();
		tempSinCos = future2.get();
	} catch (Exception e) {
		e.printStackTrace();
	}
//        System.err.println(tempSin);
//        System.err.println(tempSinCos);
//        System.err.println(tempSin2);
        double x = Math.pow(10, -6);
//        double x = 6;
        double[] tNELP = new double[2];
        tNELP[0] = x*tempSin2/2/Math.PI/(tempSin+x*tempSinCos);
        x = -x;
        tNELP[1] = x*tempSin2/2/Math.PI/(tempSin+x*tempSinCos);
        tNELP[0] = tNELP[0] *300000000;
        tNELP[1] = tNELP[1] *300000000;
        return tNELP;
    }
    
    public XYSeriesCollection[] draw(){
        double x1,y1,y2;
        double w_val;
        w_val=300/1000000000.0/600.0;
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1;
        XYSeries series2;
        series1 = new XYSeries("+");
        series2 = new XYSeries("-");
        for(double i =0;i<600;i++){
            x1=i*w_val;
            y1=this.fun(x1)[0];
            y2=this.fun(x1)[1];
            series1.add(x1*1000000000.0,y1);
            series2.add(x1*1000000000.0,y2);
        }
	dataset.addSeries(series1);
	dataset.addSeries(series2);
        
        XYSeriesCollection[] datasets;
        datasets = new XYSeriesCollection[]{dataset};
        return datasets;
    }
    
    public static void main(String args[]) {
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                System.out.println(df.format(new Date()));

                ManyWaysErr x = new ManyWaysErr(10,5);
                x.setBoc(true);
                System.out.println(df.format(new Date()));
                
                JFreeChart chart = ChartFactory.createXYLineChart(
		"w", // chart title
		"w", // x axis label
		"w", // y axis label
		x.draw()[0], // data
		PlotOrientation.VERTICAL,
		false, // include legend
		false, // tooltips
		false // urls
		);

	ChartFrame frame = new ChartFrame("函数波形", chart);

	frame.pack();
	frame.setVisible(true);
                System.out.println(df.format(new Date()));
    }          

    public boolean isBoc() {
        return boc;
    }

    public void setBoc(boolean boc) {
        this.boc = boc;
    }
}
