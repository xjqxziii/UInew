
package com.tom.newUI;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author tom
 */
public class MainFrame extends javax.swing.JFrame {
    double temp;
    String str;
    boolean ab = true;
    FunDraw drawFun = null;
    public MainFrame() {
        initComponents();
        //显示主界面
        jTextField3.setVisible(false);
        jLabel3.setVisible(false);
    }
    //主函数
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pl1 = new javax.swing.JPanel();
        cb = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        beginDraw = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cb2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GPS M码的BOC调制");
        setBackground(new java.awt.Color(255, 255, 255));

        pl1.setBackground(new java.awt.Color(204, 204, 204));
        pl1.setToolTipText("");

        cb.setFont(new java.awt.Font("微软雅黑", 0, 30)); // NOI18N
        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOC", "BPSK" }));
        cb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbItemStateChanged(evt);
            }
        });
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel1.setText("输入Alpha");

        jLabel2.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel2.setText("输入Beta");

        jLabel3.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jLabel3.setText("输入Beta_r");

        jTextField1.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N

        jTextField2.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N

        jTextField3.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N

        beginDraw.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        beginDraw.setText("绘图");
        beginDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginDrawActionPerformed(evt);
            }
        });

        exit.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        exit.setText("退出");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("宋体", 0, 30)); // NOI18N
        jButton1.setText("特性参数");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cb2.setFont(new java.awt.Font("微软雅黑", 0, 30)); // NOI18N
        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "时域波形", "频域波形", "自相关函数", "多径误差" }));
        cb2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pl1Layout = new javax.swing.GroupLayout(pl1);
        pl1.setLayout(pl1Layout);
        pl1Layout.setHorizontalGroup(
            pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl1Layout.createSequentialGroup()
                .addGroup(pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(beginDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pl1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(97, 97, 97)
                        .addGroup(pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pl1Layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        pl1Layout.setVerticalGroup(
            pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(248, 248, 248)
                .addGroup(pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beginDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private double getDoubleFromTextField(JTextField tf){
        //判断输入数据是否合法
        
        str =tf.getText().trim();
        temp=1;
        if(tf.isVisible()){
            if(ab){
                if(str != null && str.length() != 0)
                {
                    if(str.matches("^[0-9]+$")){
                        temp = new Double(tf.getText());
                    }else{
                        JOptionPane.showMessageDialog(this, "请输入正确的数值 !");
                        ab = false;
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "请输入数值 !");
                    ab = false;
                }
            }
        }
        return temp;
    }

    private void beginDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginDrawActionPerformed
        //绘图按钮点击事件
        drawFun = new FunDraw();
        int a = (int)getDoubleFromTextField(jTextField1);
        int b = (int)getDoubleFromTextField(jTextField2);
        if(a>b||cb.getSelectedIndex() == 1){
            drawFun.setA(a);
            drawFun.setB(b);
            if (cb2.getSelectedIndex()==2) {
                drawFun.setBr(getDoubleFromTextField(jTextField3));
                //获得b_r
            }
            if (ab) {
                drawFun.setBoc(cb.getSelectedIndex() == 0);
                //获得要绘图函数类型
                drawFun.setFlag(cb2.getSelectedIndex());
                //获得函数是BOC还是BPSK
                drawFun.paint();
            }
            ab = true;
        }else{
            JOptionPane.showMessageDialog(this, "输入数值不合法 !");
        }
    }//GEN-LAST:event_beginDrawActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
        //退出按钮
    }//GEN-LAST:event_exitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int a;
        int b;
        a = (cb.getSelectedIndex()==0)?(int)getDoubleFromTextField(jTextField1):0;
        b = (int)getDoubleFromTextField(jTextField2);
        if (ab) {
            DataFrame dataFrame = new DataFrame(a,b,24000000.0,cb.getSelectedIndex()==0);
            dataFrame.setVisible(dataFrame.cal());
        }
        ab = true;
        //计算数据按钮事件
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb2ItemStateChanged
        jTextField3.setVisible(cb2.getSelectedIndex()==2);
        jLabel3.setVisible(cb2.getSelectedIndex()==2);
    }//GEN-LAST:event_cb2ItemStateChanged

    private void cbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbItemStateChanged
        jTextField1.setVisible(cb.getSelectedIndex()==0);
        jLabel1.setVisible(cb.getSelectedIndex()==0);
    }//GEN-LAST:event_cbItemStateChanged

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beginDraw;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JButton exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel pl1;
    // End of variables declaration//GEN-END:variables
}
