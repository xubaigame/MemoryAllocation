/*
 * Created by JFormDesigner on Mon Dec 03 14:37:25 CST 2018
 */

package com.main.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

/**
 * @author jframe
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("采用动态分区存储器管理方案的模拟系统");
    }


    private void FFBtnStateChanged(ChangeEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane3 = new JScrollPane();
        freeMemoryTable = new JTable();
        panel3 = new JPanel();
        allocationComBox = new JComboBox();
        label9 = new JLabel();
        label11 = new JLabel();
        retMemoryBegJFT = new JTextField();
        returnBtn = new JButton();
        label3 = new JLabel();
        initMenoryJFT = new JTextField();
        initMemoryBtn = new JButton();
        panel2 = new JPanel();
        label10 = new JLabel();
        label5 = new JLabel();
        processNameJFT = new JTextField();
        reqMemorySizeJFT = new JTextField();
        applyBtn = new JButton();
        resetBtn = new JButton();
        FFBtn = new JRadioButton();
        BFBtn = new JRadioButton();
        WFBtn = new JRadioButton();
        scrollPane4 = new JScrollPane();
        curMemoryTable = new JTable();
        label4 = new JLabel();
        canvas = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u5df2\u5206\u914d\u5206\u533a\u8868");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label1);
            label1.setBounds(285, 300, 255, 40);

            //---- label2 ----
            label2.setText("\u7a7a\u95f2\u5206\u533a\u8868");
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label2);
            label2.setBounds(285, 0, 255, 37);

            //======== scrollPane3 ========
            {
                scrollPane3.setViewportView(freeMemoryTable);
            }
            panel1.add(scrollPane3);
            scrollPane3.setBounds(285, 40, 255, 260);

            //======== panel3 ========
            {
                panel3.setBorder(new EtchedBorder());
                panel3.setLayout(null);

                //---- allocationComBox ----
                allocationComBox.setVisible(false);
                panel3.add(allocationComBox);
                allocationComBox.setBounds(120, 5, 130, allocationComBox.getPreferredSize().height);

                //---- label9 ----
                label9.setText("\u5206\u914d\u7b97\u6cd5\uff1a");
                label9.setHorizontalAlignment(SwingConstants.CENTER);
                label9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
                panel3.add(label9);
                label9.setBounds(5, 5, 120, 35);

                //---- label11 ----
                label11.setText("\u91ca\u653e\u8fdb\u7a0b\u540d\u79f0\uff1a");
                label11.setHorizontalAlignment(SwingConstants.RIGHT);
                label11.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                panel3.add(label11);
                label11.setBounds(5, 395, 140, 45);

                //---- retMemoryBegJFT ----
                retMemoryBegJFT.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                panel3.add(retMemoryBegJFT);
                retMemoryBegJFT.setBounds(145, 395, 84, 45);

                //---- returnBtn ----
                returnBtn.setText("\u8fd4\u8fd8");
                panel3.add(returnBtn);
                returnBtn.setBounds(245, 395, 70, 45);

                //---- label3 ----
                label3.setText("\u521d\u59cb\u5185\u5b58\uff1a");
                label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
                label3.setHorizontalAlignment(SwingConstants.RIGHT);
                panel3.add(label3);
                label3.setBounds(5, 85, 120, 55);

                //---- initMenoryJFT ----
                initMenoryJFT.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
                panel3.add(initMenoryJFT);
                initMenoryJFT.setBounds(135, 85, 95, 55);

                //---- initMemoryBtn ----
                initMemoryBtn.setText("\u521d\u59cb\u5316");
                panel3.add(initMemoryBtn);
                initMemoryBtn.setBounds(235, 85, 80, 55);

                //======== panel2 ========
                {
                    panel2.setBorder(new EtchedBorder());
                    panel2.setLayout(null);

                    //---- label10 ----
                    label10.setText("\u7533\u8bf7\u5185\u5b58:");
                    label10.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
                    label10.setHorizontalAlignment(SwingConstants.RIGHT);
                    panel2.add(label10);
                    label10.setBounds(15, 90, 135, 65);

                    //---- label5 ----
                    label5.setText("\u8fdb\u7a0b\u540d:");
                    label5.setHorizontalAlignment(SwingConstants.RIGHT);
                    label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
                    panel2.add(label5);
                    label5.setBounds(15, 10, 135, 65);

                    //---- processNameJFT ----
                    processNameJFT.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
                    panel2.add(processNameJFT);
                    processNameJFT.setBounds(165, 10, 100, 55);

                    //---- reqMemorySizeJFT ----
                    reqMemorySizeJFT.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
                    panel2.add(reqMemorySizeJFT);
                    reqMemorySizeJFT.setBounds(165, 100, 100, 55);

                    //---- applyBtn ----
                    applyBtn.setText("\u7533\u8bf7");
                    applyBtn.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
                    panel2.add(applyBtn);
                    applyBtn.setBounds(65, 175, 175, 50);

                    { // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel2.getComponentCount(); i++) {
                            Rectangle bounds = panel2.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel2.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel2.setMinimumSize(preferredSize);
                        panel2.setPreferredSize(preferredSize);
                    }
                }
                panel3.add(panel2);
                panel2.setBounds(10, 155, 305, 230);

                //---- resetBtn ----
                resetBtn.setText("\u91cd\u7f6e");
                resetBtn.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
                panel3.add(resetBtn);
                resetBtn.setBounds(90, 490, 140, 50);

                //---- FFBtn ----
                FFBtn.setText("\u9996\u6b21\u9002\u5e94");
                FFBtn.setHorizontalAlignment(SwingConstants.CENTER);
                FFBtn.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                panel3.add(FFBtn);
                FFBtn.setBounds(5, 35, 100, 50);

                //---- BFBtn ----
                BFBtn.setText("\u6700\u4f73\u9002\u5e94");
                BFBtn.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                BFBtn.setHorizontalAlignment(SwingConstants.CENTER);
                panel3.add(BFBtn);
                BFBtn.setBounds(115, 35, 100, 50);

                //---- WFBtn ----
                WFBtn.setText("\u6700\u574f\u9002\u5e94");
                WFBtn.setHorizontalAlignment(SwingConstants.CENTER);
                WFBtn.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                panel3.add(WFBtn);
                WFBtn.setBounds(225, 35, 100, 50);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel3.getComponentCount(); i++) {
                        Rectangle bounds = panel3.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel3.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel3.setMinimumSize(preferredSize);
                    panel3.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel3);
            panel3.setBounds(550, 40, 328, 555);

            //======== scrollPane4 ========
            {
                scrollPane4.setViewportView(curMemoryTable);
            }
            panel1.add(scrollPane4);
            scrollPane4.setBounds(285, 340, 255, 260);

            //---- label4 ----
            label4.setText("\u64cd\u4f5c\u9762\u677f");
            label4.setHorizontalAlignment(SwingConstants.CENTER);
            label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label4);
            label4.setBounds(545, 0, 330, 42);

            //======== canvas ========
            {
                canvas.setForeground(Color.white);
                canvas.setBackground(Color.white);
                canvas.setBorder(LineBorder.createBlackLineBorder());
                canvas.setLayout(null);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < canvas.getComponentCount(); i++) {
                        Rectangle bounds = canvas.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = canvas.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    canvas.setMinimumSize(preferredSize);
                    canvas.setPreferredSize(preferredSize);
                }
            }
            panel1.add(canvas);
            canvas.setBounds(0, 0, 280, 600);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(15, 15, 885, 600);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(FFBtn);
        buttonGroup1.add(BFBtn);
        buttonGroup1.add(WFBtn);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane3;
    private JTable freeMemoryTable;
    private JPanel panel3;
    private JComboBox allocationComBox;
    private JLabel label9;
    private JLabel label11;
    private JTextField retMemoryBegJFT;
    private JButton returnBtn;
    private JLabel label3;
    private JTextField initMenoryJFT;
    private JButton initMemoryBtn;
    private JPanel panel2;
    private JLabel label10;
    private JLabel label5;
    private JTextField processNameJFT;
    private JTextField reqMemorySizeJFT;
    private JButton applyBtn;
    private JButton resetBtn;
    private JRadioButton FFBtn;
    private JRadioButton BFBtn;
    private JRadioButton WFBtn;
    private JScrollPane scrollPane4;
    private JTable curMemoryTable;
    private JLabel label4;
    private JPanel canvas;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public JComboBox getAllocationComBox() {
        return allocationComBox;
    }

    public JButton getApplyBtn() {
        return applyBtn;
    }

    public JButton getReturnBtn() {
        return returnBtn;
    }

    public JTextField getReqMemorySizeJFT() {
        return reqMemorySizeJFT;
    }

    public JTextField getRetMemoryBegJFT() {
        return retMemoryBegJFT;
    }

    public JTextField getInitMenoryJFT() {
        return initMenoryJFT;
    }

    public JButton getInitMemoryBtn() {
        return initMemoryBtn;
    }

    public JTable getCurMemoryTable() {
        return curMemoryTable;
    }

    public JTable getFreeMemoryTable() {
        return freeMemoryTable;
    }

    public JTextField getProcessNameJFT() {
        return processNameJFT;
    }

    public JButton getResetBtn() {
        return resetBtn;
    }

    public JPanel getCanvas() {
        return canvas;
    }

    public JRadioButton getBFBtn() {
        return BFBtn;
    }

    public JRadioButton getFFBtn() {
        return FFBtn;
    }

    public JRadioButton getWFBtn() {
        return WFBtn;
    }
}
