/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tom.newUI;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Tom
 */
public class Err extends Fun{

    int a;
    int b;
    private boolean boc;
    private double T;
    private double max;
    
    public Err(int a,int b) {
        this.a = a;
        this.b = b;
    }
    public double fun(double d){
        Gf gf = new Gf(a, b,false);
        gf.setBoc(boc);
        double tNELP;
        double CN0 = 30.0;
        double BL = 1.0;
        double br = 24000000.0;
        Double tempCos=0.0;
        Double tempCos2=0.0;
        Double tempSin=0.0;
        Double tempSin2=0.0;
        Callable<Double> td0 = new Callable<Double>(){
                public Double call() throws Exception{
                double temp=0;
                gf.setLog(false);
                for(double f=-(br/2-1);f<br/2;f=f+br/10000){
                    temp=temp+gf.fun(f)*Math.pow(2,Math.sin(Math.PI*f*d))*br/10000;
                }
                return temp;
            }
        };
        Callable<Double> td1 = new Callable<Double>(){
                public Double call() throws Exception{
                double temp=0;
                gf.setLog(false);
                for(double f=-(br/2-1);f<br/2;f=f+br/10000){
                    temp=temp+f*gf.fun(f)*Math.sin(Math.PI*f*d)*br/10000.0;
                }
                return temp;
            }
        };
        Callable<Double> td2 = new Callable<Double>(){
                public Double call() throws Exception{
                double temp=0;
                gf.setLog(false);
                for(double f=-(br/2-1);f<br/2;f=f+br/10000){
                    temp=temp+gf.fun(f)*Math.pow(2,Math.cos(Math.PI*f*d))*br/10000;
                }
                return temp;
            }
        };
        Callable<Double> td3 = new Callable<Double>(){
                public Double call() throws Exception{
                double temp=0;
                gf.setLog(false);
                for(double f=-(br/2-1);f<br/2;f=f+br/10000){
                    temp=temp+gf.fun(f)*Math.cos(Math.PI*f*d)*br/10000;
                }
                return temp;
            }
        };
        FutureTask<Double> future0 = new FutureTask<>(td0);
        FutureTask<Double> future1 = new FutureTask<>(td1);
        FutureTask<Double> future2 = new FutureTask<>(td2);
        FutureTask<Double> future3 = new FutureTask<>(td3);
        new Thread(future0).start();
        new Thread(future1).start();
        new Thread(future2).start();
        new Thread(future3).start();
        try {
		tempSin2 = future0.get();
		tempCos2 = future2.get();
		tempSin = future1.get();
		tempCos = future3.get();
	} catch (Exception e) {
		e.printStackTrace();
	}
        double temp1;
        double temp2;
        double temp3;
        temp1 = BL*(1-0.25*BL*T)*tempSin2;
        temp3 = CN0*Math.pow(2*Math.PI*tempSin,2);
        temp2 = tempCos2/T/CN0/Math.pow(tempCos,2);
        tNELP = temp1*(1+temp2)/temp3;
        tNELP = tNELP *300000000;
        tNELP = (tNELP>0.7)?0.7:tNELP;
        return tNELP;
    }
    
    public void draw(){
        double x1,y1;
        double w_val;
        XYSeries series;
        w_val=40/1000000000.0/600.0;
        
        series = new XYSeries("NELP,50bps");
        for(double i =300;i<900;i++){
            x1=i*w_val;
            T = 20/1000000.0;
            y1=this.fun(x1);
            series.add(x1*1000000000.0,y1);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
	dataset.addSeries(series);
        
        series = new XYSeries("NELP,200bps");
        for(double i =300;i<900;i++){
            x1=i*w_val;
            T = 5/1000000.0;
            y1=this.fun(x1);
            series.add(x1*1000000000.0,y1);
        }
	dataset.addSeries(series);
        XYSeriesCollection[] datasets;
        datasets = new XYSeriesCollection[]{dataset};
//        return datasets;
    }
    public void setW_val() {
        w_val=40/1000000000.0/600.0;
    }
}
