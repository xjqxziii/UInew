/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tom.newUI;

import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author tom
 */
public interface Fun {
    public double fun(double f);
    public XYSeriesCollection[] draw();
    public boolean isBoc();
    public void setBoc(boolean boc);
}
