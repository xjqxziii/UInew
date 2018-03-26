/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tom.newUI;


/**
 *
 * @author tom
 */
public abstract class Fun {
    //函数接口
    public Draw d;
    public abstract double fun(double f);
    public double w_val;
    private boolean boc;

    
    public void draw(){
        String type;
        if (boc) 
        {
            type = "BOC";
        }else{
            type = "BPSK";
        }
        String title=type + "频域波形";
        String xlable="f";
        String ylable="G(f)";
        this.d.draw(title, xlable, ylable,w_val);
    }


    public boolean isBoc() {
        return boc;
    }

    public void setBoc(boolean boc) {
        this.boc = boc;
        setW_val();
    }
    public abstract void setW_val();
}
