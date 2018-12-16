package com.main.model;

import com.main.domain.Memory;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;

/**
 * @Auther: Administrator
 * @Date: 2018/11/2 22:44
 * @Description:
 */
public class CurMemoryTableModel extends AbstractTableModel {
    private String[] columnNames = {"编号", "进程", "始址", "大小"};
    private LinkedList<Memory> memories = new LinkedList<>();

    public void setMemories(LinkedList<Memory> memories) {
        this.memories.clear();
        for(final Memory m : memories){
            if(!m.isState())
                this.memories.add(m);
        }
    }

    public LinkedList<Memory> getMemories() {
        return memories;
    }

    @Override
    public int getRowCount() {
        return memories.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Memory memory = memories.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return memory.getProcessName();
            case 2:
                return memory.getStart();
            case 3:
                return memory.getLength();
        }
        return null;
    }
}
