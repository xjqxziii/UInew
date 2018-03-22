/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tom.newUI;

import static com.tom.newUI.DrawFun.ff;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author tom
 */
public class St implements Fun{
    int n;
    double f;
    private boolean boc;

    public boolean isBoc() {
        return boc;
    }

    public void setBoc(boolean boc) {
        this.boc = boc;
    }

    public St(double f,int n) {
        this.f = f;
        this.n = n;
    }
    //时域函数波形
    
    static int[] a = new int[]{1,-1,1,-1,-1,1,-1,1,-1,1,-1,1,-1,1,-1,-1,1,-1,-1,1,-1,1,-1,1,-1,1,-1,1,-1};
    //时域函数二进制序列
    public double fun(double t){
        if (boc) { 
            return a[(int)(t*f/n)]*((Math.floor(t*f)%2==0)?1:-1);
        } else {
            return a[(int)(t*f/n)];
        }
    }
    
    public XYSeriesCollection[] draw(){
        
        double x1,y1;
        double w_val;
        String title,xlable,ylable;
        XYSeries series;
        series = new XYSeries("cc");
        if(boc){
            w_val=24/600.0/f;
        }else{
            w_val=24*n/600.0/f;
        }
        for(double i =0;i+1<600;i++){
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
}
