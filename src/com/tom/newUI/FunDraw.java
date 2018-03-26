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
public class FunDraw {
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
    
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    public double getBr() {
        return br;
    }

    public void setBr(double br) {
        this.br = br;
    }
    
    int flag = -1;
    int a,b;
    double br;
    static final double ff = 1023000.0;
    private boolean boc;
    
    public void paint() {
        //绘图函数
        Fun fun = null;
        switch(flag)
        {  
        case 0:
            fun = (boc)?new St(ff,(2*a/b)):new St(ff,b);
        break;
        case 1:
            fun = new Gf(a,b,true);
            
        break;
        case 2:
            fun = new Rt(new Gf(a,b,false),br);
        break;
        case 3:
            fun = new ManyWaysErr((int)a,(int)b);
        break;
        }
        fun.setBoc(boc);
        fun.draw();
    }

    public boolean isBoc() {
        return boc;
    }

    public void setBoc(boolean boc) {
        this.boc = boc;
    }
}
    
