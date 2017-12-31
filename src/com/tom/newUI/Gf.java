/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tom.newUI;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 *
 * @author tom
 */
public class Gf implements Fun{
    int a;
    int b;
    private boolean boc;
    private boolean log;
    
    public Gf(int a,int b,boolean log){
        this.b = b;
        this.a = a;
        this.log = log;
    }
    
    public double fun(double f){
        double fc = b * DrawFun.ff;
        double gf;
        if (boc) {
            double fs = a * DrawFun.ff;
            if((2*a/b)%2==0){
                if (f==0) {
                    gf = fc*Math.pow((Math.tan(Math.PI*f/2/fs)*Math.sin(Math.PI*f/fc)/Math.PI/f),2);
                }else{
                    gf = fc*Math.pow((Math.tan(Math.PI*f/2/fs)*Math.sin(Math.PI*f/fc)/Math.PI/f),2);
                }
            }
            else{
                gf = fc*Math.pow((Math.tan(Math.PI*f/2/fs)*Math.cos(Math.PI*f/fc)/Math.PI/f),2);
            }
        } else {
            double fh = Math.PI*f/fc/2;
            gf = Math.pow(Math.sin(fh)/fh, 2)/fc/4;
        }
        
        if (log) {
            double loggf=10*Math.log10(gf);
            if (loggf<-100){
                loggf=-100;
            }
            return loggf;
        }
        return gf;
    }
    
    public XYSeriesCollection[] draw(){
        
        double x1,y1;
        double w_val;
        XYSeries series;
        series = new XYSeries("cc");
        this.log = true;
        if (boc) {
            w_val=50000;
        } else {
            w_val=20000*b;
        }
        for(double i =-300;i+1<300;i++){
            x1=i*w_val;    
            y1=this.fun(x1);
            series.add(x1,y1);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
	dataset.addSeries(series);
        XYSeriesCollection[] datasets;
        datasets = new XYSeriesCollection[]{dataset};
        return datasets;
    }

    public boolean isLog() {
        return log;
    }

    public void setLog(boolean log) {
        this.log = log;
    }

    public boolean isBoc() {
        return boc;
    }

    public void setBoc(boolean boc) {
        this.boc = boc;
    }
}
