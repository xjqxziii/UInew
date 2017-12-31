/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tom.newUI;

import java.util.concurrent.Callable;

/**
 *
 * @author tom
 */
public class TdRt implements Callable<Double[]>{
    Gf gf = null;
    double x=0;
    double br;
    int no;
    double t;
    public TdRt(Gf gf,double t,double br,int no){
        this.gf=gf;
        this.no=no;
        this.br = br;
        this.t = t;
    }
    public Double[] call() throws Exception{
        double f;
        double tempRe=0,tempIm=0;
        Double[] temp = new Double[2];
        for(f=-(br/2-1)+br*no/MainFrame.Td_no;f<-(br/2-1)+br*(no+1)/MainFrame.Td_no;f=f+br/10000){
            tempRe=tempRe+gf.fun(f)*Math.cos(2*Math.PI*f*t);
            tempIm=tempIm+gf.fun(f)*Math.sin(2*Math.PI*f*t);
        }
        temp[0] = tempRe;
        temp[1] = tempIm;
        return temp;
    }
    
}
