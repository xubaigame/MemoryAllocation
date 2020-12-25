package com.main.utils;

import java.awt.*;

/**
 * @ Date: 2018/12/5 20:25
 * @ Description:
 */
public class MyCanvas extends Canvas {
    private Graphics pen;
    private Color color;
    private int wide;
    private int lenth;
    private int start;

    public MyCanvas(Color color, int start, int wide, int totalLength) {

        this.lenth = (int) (600 * (wide * 1.0 / totalLength)) - 1;
        this.wide = wide;
        setSize(280, this.lenth);
        this.color = color;
        this.start = start;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        pen = g;
        pen.setColor(color);
        pen.fillRect(0, 0, 280, lenth);

        pen.setColor(Color.black);
        pen.drawLine(0, 0, 280, 0);

        pen.setFont(new Font("宋体",Font.BOLD,13));
        pen.setColor(Color.blue);
        pen.drawString(String.valueOf(start) , 2, 20);
        pen.drawString(String.valueOf(start + wide - 1) , 2, lenth - 10);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

}