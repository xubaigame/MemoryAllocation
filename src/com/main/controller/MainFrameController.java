package com.main.controller;

import com.main.domain.Memory;
import com.main.domain.MemoryUnit;
import com.main.model.CurMemoryTableModel;
import com.main.model.FreeMemoryTableModel;
import com.main.utils.MyCanvas;
import com.main.view.MainFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;

/**
 * @ Date: 2018/12/3 15:10
 * @ Description:
 */
public class MainFrameController {
    MainFrame mainFrame;
    private JComboBox allocationComBox;
    private JTextField reqMemorySizeJFT;
    private JButton applyBtn;
    private JTextField retMemoryBegJFT;
    private JButton returnBtn;
    private JTextField initMenoryJFT;
    private JButton initMemoryBtn;
    private JTable curMemoryTable;
    private JTable freeMemoryTable;
    private JTextField processNameJFT;
    private JButton resetBtn;
    private JPanel canvas;
    private JRadioButton ffBtn;
    private JRadioButton bfBtn;
    private JRadioButton wfBtn;

    private CurMemoryTableModel curMemoryTableModel;
    private FreeMemoryTableModel freeMemoryTableModel;

    // 记录当前选择的分配算法
    private int currentAlgorith = -1;

    public MainFrameController() {
        initCompoents();
        initListeners();
    }

    public void showMainWindows() {
        mainFrame.setVisible(true);
    }

    private void initCompoents() {
        mainFrame = new MainFrame();
        allocationComBox = mainFrame.getAllocationComBox();
        reqMemorySizeJFT = mainFrame.getReqMemorySizeJFT();
        applyBtn = mainFrame.getApplyBtn();
        retMemoryBegJFT = mainFrame.getRetMemoryBegJFT();
        returnBtn = mainFrame.getReturnBtn();
        initMenoryJFT = mainFrame.getInitMenoryJFT();
        initMemoryBtn = mainFrame.getInitMemoryBtn();
        curMemoryTable = mainFrame.getCurMemoryTable();
        freeMemoryTable = mainFrame.getFreeMemoryTable();
        processNameJFT = mainFrame.getProcessNameJFT();
        resetBtn = mainFrame.getResetBtn();
        canvas = mainFrame.getCanvas();
        ffBtn=mainFrame.getFFBtn();
        bfBtn=mainFrame.getBFBtn();
        wfBtn=mainFrame.getWFBtn();

        allocationComBox.addItem("请选择分配算法");
        allocationComBox.addItem("首次适应算法");
        allocationComBox.addItem("最佳适应算法");
        allocationComBox.addItem("最坏适应算法");

        // 设置model
        curMemoryTableModel = new CurMemoryTableModel();
        curMemoryTable.setModel(curMemoryTableModel);

        freeMemoryTableModel = new FreeMemoryTableModel();
        freeMemoryTable.setModel(freeMemoryTableModel);

        canvas.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }

    private void initListeners() {
        // 初始化内存大小
        initMemoryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取初始化内存大小
                String initMemorySize = initMenoryJFT.getText();
                if (!"".equals(initMemorySize)) {
                    MemoryUnit.setTotalLength(Integer.parseInt(initMemorySize));
                    // 初始化
                    MemoryUnit.init();
                    // 更新table
                    curMemoryTableModel.setMemories(MemoryUnit.getMemories());
                    curMemoryTable.updateUI();
                    freeMemoryTableModel.setMemories(MemoryUnit.getMemories());
                    freeMemoryTable.updateUI();
                    // 更新画板
                    paintCanvas();

                    initMenoryJFT.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "请填写初始化内存大小！");
                }
            }
        });
        ffBtn.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(((JRadioButton)e.getSource()).isSelected()&&currentAlgorith!=3)
                {
                    currentAlgorith = 3;
                }

            }
        });
        bfBtn.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(((JRadioButton)e.getSource()).isSelected()&&currentAlgorith!=1)
                {
                    currentAlgorith = 1;
                }

            }
        });
        wfBtn.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(((JRadioButton)e.getSource()).isSelected()&&currentAlgorith!=2)
                {
                    currentAlgorith = 2;
                }

            }
        });
        allocationComBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    if (e.getItem() == "最佳适应算法") {
                        // 最佳适应算法 1
                        currentAlgorith = 1;
                    } else if (e.getItem() == "最坏适应算法") {
                        // 最坏适应算法 2
                        currentAlgorith = 2;
                    } else if (e.getItem() == "首次适应算法") {
                        // 首次适应算法 3
                        currentAlgorith = 3;
                    } else currentAlgorith = -1;
                }
            }
        });

        // 申请内存
        applyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取申请内存大小
                String reqMemorySize = reqMemorySizeJFT.getText();
                if("".equals(reqMemorySize)){
                    JOptionPane.showMessageDialog(null, "请填写申请内存大小！");
                    return;
                }
                String processName = processNameJFT.getText();
                if("".equals(processName)){
                    JOptionPane.showMessageDialog(null, "请填写进程名！");
                    return;
                }
                if(currentAlgorith == -1){
                    JOptionPane.showMessageDialog(null, "请选择内存分配算法！");
                    return;
                }
                reqMemorySizeJFT.setText("");
                processNameJFT.setText("");
                boolean flag = switchAlgorith(currentAlgorith, Integer.parseInt(reqMemorySize), processName);



                // 分配失败 紧凑
                if(!flag && Integer.parseInt(reqMemorySize)<=MemoryUnit.getUsefulSize()){
                    // 紧凑
                    MemoryUnit.compactMemory(Integer.parseInt(reqMemorySize));
                    // 重新分配内存
                    flag = switchAlgorith(currentAlgorith, Integer.parseInt(reqMemorySize), processName);
                }
                if(!flag) JOptionPane.showMessageDialog(null, "内存不足，分配失败！");
                // 更新table
                curMemoryTableModel.setMemories(MemoryUnit.getMemories());
                curMemoryTable.updateUI();
                freeMemoryTableModel.setMemories(MemoryUnit.getMemories());
                freeMemoryTable.updateUI();
                // 更新画板
                paintCanvas();
            }
        });

        // 归还内存
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取归还内存起始地址
                String retMemoryBeg = retMemoryBegJFT.getText();
                if("".equals(retMemoryBeg)){
                    JOptionPane.showMessageDialog(null, "请填写进程名称！");
                    return;
                }
                retMemoryBegJFT.setText("");
                int a=Integer.MAX_VALUE;
                for(int i=0;i<curMemoryTableModel.getMemories().size();i++)
                {
                    //System.out.println(curMemoryTableModel.getMemories().get(i).getProcessName());
                    if(curMemoryTableModel.getMemories().get(i).getProcessName().equals(retMemoryBeg))
                        a=curMemoryTableModel.getMemories().get(i).getStart();
                }
                if(a==Integer.MAX_VALUE)
                {
                    JOptionPane.showMessageDialog(null, "不存在该进程！");
                    return;
                }
                //System.out.println(a);
                MemoryUnit.delMemory(a);
                // 更新table
                curMemoryTableModel.setMemories(MemoryUnit.getMemories());
                curMemoryTable.updateUI();
                freeMemoryTableModel.setMemories(MemoryUnit.getMemories());
                freeMemoryTable.updateUI();

                // 更新画板
                paintCanvas();
            }
        });

        // 重置按钮
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reqMemorySizeJFT.setText("");
                retMemoryBegJFT.setText("");
                initMenoryJFT.setText("");
                processNameJFT.setText("");

                MemoryUnit.clear();
                // 更新table
                curMemoryTableModel.setMemories(MemoryUnit.getMemories());
                curMemoryTable.updateUI();
                freeMemoryTableModel.setMemories(MemoryUnit.getMemories());
                freeMemoryTable.updateUI();

                canvas.removeAll();
                canvas.revalidate();
            }


        });
    }
    private boolean switchAlgorith(int algorithType, int reqMemorySize, String processName){
        boolean flag = false;
        switch (algorithType) {
            case 1:
                // 最佳适应算法 1
                flag = MemoryUnit.applyMemoryBF(reqMemorySize, processName);
                break;
            case 2:
                // 最坏适应算法 2
                flag = MemoryUnit.applyMemoryWF(reqMemorySize, processName);
                break;
            case 3:
                // 首次适应算法 3
                flag = MemoryUnit.applyMemoryFF(reqMemorySize, processName);
                break;
        }
        return flag;
    }
    private void paintCanvas() {
        // 清空当前画布
        canvas.removeAll();
        for (Memory memory : MemoryUnit.getMemories()) {
            if (memory.isState()) {
                // 空闲
                MyCanvas cache = new MyCanvas(Color.gray, memory.getStart(), memory.getLength(), MemoryUnit.getTotalLength());
                canvas.add(cache);
            } else {
                MyCanvas cache = new MyCanvas(Color.red, memory.getStart(), memory.getLength(), MemoryUnit.getTotalLength());
                canvas.add(cache);
            }
        }
        canvas.revalidate();
    }
}
