/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tom.newUI;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Tom
 */
public class DataFrame extends javax.swing.JFrame {

    int a; 
    int b;
    double br;
    boolean bocOrBPSK;
    public DataFrame(int a,int b,double br,boolean bocOrBPSK) {
        initComponents();
        this.a=a;
        this.b=b;
        this.br=br;
        this.bocOrBPSK=bocOrBPSK;
    }
    
    public boolean cal(){
        
        Gf funGf = new Gf((int)a,(int)b,true);
        funGf.setBoc(bocOrBPSK);
        
        double f;
        
        double lamuda=0.0;
        for(f=-(br/2-1);f<br/2;f=f+br/10000.0){
            lamuda=lamuda+Math.pow(10,funGf.fun(f)/10)*br/10000.0;
        }
        
        double beta_rms=0.0;
        for(f=-(br/2-1);f<br/2;f=f+br/10000.0){
            beta_rms=beta_rms+f*f*Math.pow(10,funGf.fun(f)/10)*br/10000.0/lamuda;
        }
        beta_rms = Math.sqrt(beta_rms);
        
        double kls1=0.0;
        for(f=-(br/2-1);f<br/2;f=f+br/10000.0){
            kls1=kls1+Math.pow(10,funGf.fun(f)/10)*Math.pow(10,funGf.fun(f)/10)*br/10000.0/lamuda;
        }
        
        double lamuda2=0.0;
        double kls2=0.0;
        Gf funBOC = new Gf(10,5,true);
        funBOC.setBoc(true);
        for(f=-(br/2-1);f<br/2;f=f+br/10000.0){
            lamuda2=lamuda2+Math.pow(10,funBOC.fun(f)/10)*br/10000.0;
        }
        
        for(f=-(br/2-1);f<br/2;f=f+br/10000.0){
            kls2=kls2+Math.pow(10,funBOC.fun(f)/10)*Math.pow(10,funGf.fun(f)/10)*br/10000.0/lamuda2;
        }
        
        double lamuda3=0.0;
        double kls3=0.0;
        Gf funBPSK = new Gf(1,1,true);
        funBPSK.setBoc(false);
        for(f=-(br/2-1);f<br/2;f=f+br/10000.0){
            lamuda3=lamuda3+Math.pow(10,funBPSK.fun(f)/10)*br/10000.0;
        }
        for(f=-(br/2-1);f<br/2;f=f+br/10000.0){
            kls3=kls3+Math.pow(10,funBPSK.fun(f)/10)*Math.pow(10,funGf.fun(f)/10)*br/10000.0/lamuda3;
        }
        
        double beta_rect = 0.0;
        double max = -101;
        double fmax = 0.0;
        for(f=-(br/2-1);f<br/2;f=f+10){
            if (funGf.fun(f)>max) {
                max = funGf.fun(f);
                fmax = f;
            }
        }
        
        max = Math.pow(10,max/10);
        beta_rect = lamuda/max;
            
        kls1 = 10*Math.log10(kls1);
        kls2 = 10*Math.log10(kls2);
        kls3 = 10*Math.log10(kls3);

        fmax = ((fmax>0)?fmax:-fmax);
        
        max = 10*Math.log10(max);

        fmax = fmax/1000000;
        beta_rms = beta_rms/1000000;
        beta_rect = beta_rect/1000000;
        
        DecimalFormat    df   = new DecimalFormat("######0.0");  
        
        lb1.setText(df.format(fmax));
        lb2.setText(df.format(lamuda));
        lb3.setText(df.format(beta_rms));
        lb4.setText(df.format(beta_rect));
        lb5.setText(df.format(kls1));
        lb6.setText(df.format(kls3));
        lb7.setText(df.format(kls2));
        return true;
    }
    
    
    
    
    
    
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("特性参数");

        jButton1.setFont(new java.awt.Font("微软雅黑", 0, 30)); // NOI18N
        jButton1.setText("保存excel文件");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel1.setText("频偏");

        jLabel2.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel2.setText("λ");

        jLabel3.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel3.setText("RMS带宽");

        jLabel4.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel4.setText("等效矩形带宽");

        jLabel5.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel5.setText("与自身的频谱隔离系数");

        jLabel6.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel6.setText("与1.023的频谱隔离系数");

        jLabel7.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel7.setText("与（10,5）的频谱隔离系数");

        lb1.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        lb1.setText("0");

        lb2.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        lb2.setText("0");

        lb3.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        lb3.setText("0");

        lb4.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        lb4.setText("0");

        lb5.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        lb5.setText("0");

        lb6.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        lb6.setText("0");

        lb7.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        lb7.setText("0");

        jLabel15.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel15.setText("MHz");

        jLabel16.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel16.setText("dBW/Hz");

        jLabel17.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel17.setText("MHz");

        jLabel18.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel18.setText("MHz");

        jLabel19.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel19.setText("dB/Hz");

        jLabel20.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel20.setText("dB/Hz");

        jLabel21.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel21.setText("dB/Hz");

        jLabel8.setFont(new java.awt.Font("微软雅黑", 0, 34)); // NOI18N
        jLabel8.setText("特性参数");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(516, 516, 516)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lb1)
                                    .addComponent(lb2)
                                    .addComponent(lb3)
                                    .addComponent(lb4)
                                    .addComponent(lb5)
                                    .addComponent(lb6)
                                    .addComponent(lb7)))
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(274, 274, 274)
                                .addComponent(jButton1)))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jLabel8)))
                .addGap(0, 170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel8)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb1)
                    .addComponent(jLabel15))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb2)
                    .addComponent(jLabel16))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb3)
                    .addComponent(jLabel17))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lb4)
                    .addComponent(jLabel18))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lb5)
                    .addComponent(jLabel19))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lb6)
                    .addComponent(jLabel20))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel7)
                    .addComponent(lb7))
                .addGap(44, 44, 44)
                .addComponent(jButton1)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(Savexls.save(new String[]{lb1.getText(),lb2.getText(),lb3.getText(),lb4.getText(),lb5.getText(),lb6.getText(),lb7.getText()})){
            JOptionPane.showMessageDialog(this, "保存在程序目录下的data.xls文件中");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    // End of variables declaration//GEN-END:variables

}
