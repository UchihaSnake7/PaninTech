/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.application.utilities;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author USUARIO
 */
public class TableActionCellRender extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSelected, boolean bln1, int i, int i1){
        Component com = super.getTableCellRendererComponent(jtable, o, isSelected, bln1, i, i1);
        PanelAction action = new PanelAction();
        
//        if (isSelected==false){
//             
//        }
        action.setBackground(com.getBackground());
        return action;
    }
}
