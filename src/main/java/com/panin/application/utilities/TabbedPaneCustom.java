/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.application.utilities;

/**
 *
 * @author USUARIO
 */
import com.formdev.flatlaf.FlatClientProperties;
import com.panin.application.Application;
import com.panin.menu.Menu;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
 *
 * @author RAVEN
 */
public class TabbedPaneCustom extends JTabbedPane {

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
        repaint();
    }

    public Color getUnselectedColor() {
        return unselectedColor;
    }

    public void setUnselectedColor(Color unselectedColor) {
        this.unselectedColor = unselectedColor;
        repaint();
    }

    private Color selectedColor;
    private Color unselectedColor;

    public TabbedPaneCustom() {
        setBackground(getBackground());
        this.putClientProperty(FlatClientProperties.STYLE, ""
                //                + "dropLineShortColor:$Menu.background;"
                + "selectedBackground: $Login.background;"
                + "hoverColor: $Login.background;"
                //                + "tabSeparatorColor: $Menu.background;"
                + "selectedForeground: $Table.foreground;"
//                + "unselectedBackground: $background"
                + "foreground:$Table.foreground;"
                + "background: $background;"
        );

//        unselectedColor = UIManager.getColor("$Menu.background");
//        selectedColor = UIManager.getColor("$Menu.background");
//        unselectedColor = getBackground();
//        setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
    }
}
