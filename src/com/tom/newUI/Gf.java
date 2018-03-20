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
public class Gf extends Fun{
    int a;
    int b;
        private boolean log;
        
    public Gf(int a,int b,boolean log){
        this.b = b;
        this.a = a;
        this.setLog(log);
        d = new DrawOneLine(this);
    }
    //BOC或BPSK频谱函数
    
    public double fun(double f){
        double fc = b * DrawFun.ff;
        double gf;
        if (isBoc()) {
            double fs = a * DrawFun.ff;
            if((2*a/b)%2==0){
                gf = fc*Math.pow((Math.tan(Math.PI*f/2/fs)*Math.sin(Math.PI*f/fc)/Math.PI/f),2);
            }else{
                gf = fc*Math.pow((Math.tan(Math.PI*f/2/fs)*Math.cos(Math.PI*f/fc)/Math.PI/f),2);
            }
        } else {
            double fh = Math.PI*f/fc/2;
            gf = Math.pow(Math.sin(fh)/fh, 2)/fc/4;
        }
        
        if (log) {
            //是否对函数结果取对数
            double loggf=10*Math.log10(gf);
            if (loggf<-100){
                loggf=-100;
            }
            return loggf;
        }
        return gf;
    }
    
    public boolean isLog() {
        return log;
    }

    public void setLog(boolean log) {
        this.log = log;
    }
    
    @Override
    public void setW_val() {
        if (isBoc()) {
            w_val=50000;
        } else {
            w_val=20000*b;
        }
    }
}
