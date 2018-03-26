/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tom.newUI;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
<<<<<<< HEAD
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
=======
>>>>>>> 68ab6c0309870334b9878156b4089b7ca09a3420

/**
 *
 * @author tom
 */
<<<<<<< HEAD
public class ManyWaysErr implements Fun{
=======
public class ManyWaysErr extends Fun{
>>>>>>> 68ab6c0309870334b9878156b4089b7ca09a3420
    int a;
    int b;
    private boolean boc;
    private double T;
    private double max;
    private int p;
    
    public ManyWaysErr(int a,int b) {
        this.a = a;
        this.b = b;
        d = new DrawTwoLines(this);
    }
    //多径码误差函数
    @Override
    public double fun(double d){
        Gf gf = new Gf(a, b,false);
        gf.setBoc(boc);
        double det = 40/1000000000.0;
        double br = 24000000.0;
        Double tempSinCos=0.0;
        Double tempSin=0.0;
        Double tempSin2=0.0;
        double tc = 2/(b*DrawFun.ff);
        Callable<Double> td0 = () -> {
            double br1 = 24000000.0;
            double temp=0;
            gf.setLog(false);
            for (double f = -(br1 / 2 - 1); f < br1 / 2; f = f + br1 / 10000) {
                temp = temp + gf.fun(f)*Math.sin(Math.PI*f*tc*det)*Math.sin(2*Math.PI*f*d) * br1 / 10000;
            }
            return temp;
        };
        Callable<Double> td1 = () -> {
            double br1 = 24000000.0;
            double temp=0;
            gf.setLog(false);
            for (double f = -(br1 / 2 - 1); f < br1 / 2; f = f + br1 / 10000) {
                temp = temp + f*gf.fun(f)*Math.sin(Math.PI*f*tc*det) * br1 / 10000;
            }
            return temp;
        };
        Callable<Double> td2 = () -> {
            double br1 = 24000000.0;
            double temp=0;
            gf.setLog(false);
            for (double f = -(br1 / 2 - 1); f < br1 / 2; f = f + br1 / 10000) {
                temp = temp + f*gf.fun(f)*Math.sin(Math.PI*f*tc*det)*Math.cos(2*Math.PI*f*d) * br1 / 10000;
            }
            return temp;
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
	} catch (InterruptedException | ExecutionException e) {
	}
        //获得三个积分值
        double x = Math.pow(10, -6);
        double[] tNELP = new double[2];
        tNELP[0] = x*tempSin2/2/Math.PI/(tempSin+x*tempSinCos);
        x = -x;
        tNELP[1] = x*tempSin2/2/Math.PI/(tempSin+x*tempSinCos);
        tNELP[0] = tNELP[0] *300000000;
        tNELP[1] = tNELP[1] *300000000;
        //返回两个不同的曲线
        return tNELP[p];
    }
<<<<<<< HEAD
    
    @Override
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
            p=0;
            y1=this.fun(x1);
            p=1;
            y2=this.fun(x1);
            //获得两根曲线
            series1.add(x1*1000000000.0,y1);
            series2.add(x1*1000000000.0,y2);
        }
	dataset.addSeries(series1);
	dataset.addSeries(series2);
        
        XYSeriesCollection[] datasets;
        datasets = new XYSeriesCollection[]{dataset};
        return datasets;
    }      
=======
     
>>>>>>> 68ab6c0309870334b9878156b4089b7ca09a3420

    @Override
    public boolean isBoc() {
        return boc;
    }

    @Override
    public void setBoc(boolean boc) {
        this.boc = boc;
    }

    @Override
    public void setW_val() {
        w_val=300/1000000000.0/600.0;
    }
}
