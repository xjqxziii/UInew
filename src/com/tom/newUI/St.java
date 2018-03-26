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
public class St extends Fun{
    int n;
    double f;

    public St(double f,int n) {
        this.f = f;
        this.n = n;
        d = new DrawOneLine(this);
    }
    //时域函数波形
    
    static int[] a = new int[]{1,-1,1,-1,-1,1,-1,1,-1,1,-1,1,-1,1,-1,-1,1,-1,-1,1,-1,1,-1,1,-1,1,-1,1,-1};
    //时域函数二进制序列
    public double fun(double t){
        if (isBoc()) { 
            return a[(int)(t*f/n)]*((Math.floor(t*f)%2==0)?1:-1);
        } else {
            return a[(int)(t*f/n)];
        }
    }
    @Override
    public void setW_val() {
        if (isBoc()) {
            w_val=24/600.0/f;
        }else{
            w_val=24*n/600.0/f;
        }
    }
}
