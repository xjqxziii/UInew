/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tom.newUI;

import java.util.concurrent.FutureTask;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 *
 * @author tom
 */
public class Rt implements Fun{
    Gf gf = null;
    double br;

    private boolean boc;

    public boolean isBoc() {
        return boc;
    }

    public void setBoc(boolean boc) {
        this.boc = boc;
    }

    public Rt(Gf gf,double br){
        this.gf=gf;
        this.br = br;
    }
    
    public double fun(double t){
        double tempRe=0,tempIm=0;
        double temp = 0;

        Double[][] tempcomp = new Double[2][MainFrame.Td_no];
        FutureTask<Double[]>[] future = new FutureTask[MainFrame.Td_no];
        for(int i = 0;i<MainFrame.Td_no;i++){
            TdRt td0 = new TdRt(gf, t, 24000000.0, i);
            future[i] = new FutureTask<>(td0);
            new Thread(future[i]).start();
        }
        for(int i = 0;i<MainFrame.Td_no;i++){
            try {
                tempcomp[0][i] = future[i].get()[0];
                tempcomp[1][i] = future[i].get()[1];
            } catch (Exception e) {
                e.printStackTrace();
            }
            tempRe += tempcomp[0][i];
            tempIm += tempcomp[1][i];
        }
        
        temp=Math.sqrt(tempIm*tempIm+tempRe*tempRe);
        
        return temp;
    }
    
    public XYSeriesCollection[] draw(){
        this.gf.setBoc(boc);
        double x1,y1;
        double w_val;
        XYSeries series;
        series = new XYSeries("cc");
        double r1 ;
        r1 = this.fun(0);
        if (gf.isBoc()) {
            w_val=1/300.0/800000/gf.b;
        } else {
            w_val=1/300.0/500000/gf.b;
        }
        for(double i =-300;i+1<300;i++){
            x1=i*w_val;    
            y1=this.fun(x1);
            series.add(x1,y1/r1);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
	dataset.addSeries(series);
        XYSeriesCollection[] datasets;
        datasets = new XYSeriesCollection[]{dataset};
        return datasets;
    }
}
