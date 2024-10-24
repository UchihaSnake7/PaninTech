package com.panin.application.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.util.UIScale;

import com.panin.application.Application;
import com.panin.application.form.insumos.FormCrearInsumo;
import com.panin.application.form.insumos.FormVerInsumos;
import com.panin.application.form.insumos.crear.FormCrearInsumoN;
import com.panin.application.form.insumos.crear.FormCrearMarcaInsumoN;
import com.panin.application.form.insumos.reportecompra.FormReporteComprasInsumos;
import com.panin.application.form.insumos.reportecompra.FormReporteMarcasInsumo;
import com.panin.application.form.other.FormDashboard;
import com.panin.application.form.other.FormIngresarInsumoold;
import com.panin.application.form.other.FormRead;
import com.panin.application.form.productos.FormAgregarNuevoProducto;
import com.panin.application.form.productos.FormMostrarProductos;
import com.panin.application.form.other.formprueba;
import com.panin.application.form.other.FormCambio;
import com.panin.application.form.FormCrearUsuario;
import com.panin.menu.Menu;
import com.panin.menu.MenuAction;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.panin.application.form.other.FormIngresarInsumo;
import com.panin.application.form.other.formConfiguracion;
import com.panin.application.form.productos.FormCompraProductos;
import com.panin.application.form.productos.FormMostrarProductos;
import com.panin.application.form.productos.FormReporteComprasProductosC;
import com.panin.application.form.productos.FormVerProductos;
import com.panin.application.form.productos.PanelNuevoProducto;
import com.panin.application.form.productos.panelCalcularPrecioProducto;
import com.panin.application.ventas.PanelRegistrarVenta;
import com.panin.application.ventas.PanelVerDatos;
import com.panin.application.ventas.panelCrearDatos;

/**
 *
 * @author Raven
 */
public class MainForm extends JLayeredPane {

    public MainForm() {
        init();
    }

    private void init() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new MainFormLayout());
        menu = new Menu();
        panelBody = new JPanel(new BorderLayout());
        initMenuArrowIcon();
        menuButton.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Menu.button.background;"
                + "arc:999;"
                + "focusWidth:0;"
                + "borderWidth:0");
        menuButton.addActionListener((ActionEvent e) -> {
            setMenuFull(!menu.isMenuFull());
        });
        initMenuEvent();
        setLayer(menuButton, JLayeredPane.POPUP_LAYER);
        add(menuButton);
        add(menu);
        add(panelBody);
    }

    @Override
    public void applyComponentOrientation(ComponentOrientation o) {
        super.applyComponentOrientation(o);
        initMenuArrowIcon();
    }

    private void initMenuArrowIcon() {
        if (menuButton == null) {
            menuButton = new JButton();
        }
        String icon = (getComponentOrientation().isLeftToRight()) ? "menu_left.svg" : "menu_right.svg";
        menuButton.setIcon(new FlatSVGIcon("raven/icon/svg/" + icon, 0.8f));
    }

    private void initMenuEvent() {
        menu.addMenuEvent((var index, var subIndex, var action) -> {
            // Application.mainForm.showForm(new DefaultForm("Form : " + index + " " + subIndex));
            if (index == 0) {
                Application.showForm(new FormDashboard());
            } else if (index == 1) { //Insumos
                switch (subIndex) {
                    case 1:
                        Application.showForm(new FormVerInsumos());
                        break;
                    case 2:
                        Application.showForm(new FormIngresarInsumo());
                        break;
                    case 3:
                        Application.showForm(new FormReporteComprasInsumos());
                        break;
                    case 4:
                        Application.showForm(new FormReporteMarcasInsumo());
                        break;
                    case 5:
                        Application.showForm(new FormCrearInsumoN());
                        break;
                    case 6:
                        Application.showForm(new FormCrearMarcaInsumoN());
                        break;
                    default:
                        Application.showForm(new FormIngresarInsumo());
                }

            } else if (index == 2) {

                /*
                Productos
                 */
                switch (subIndex) {
                    case 1: {
                        Application.showForm(new FormVerProductos());
                        break;
                    }
                    case 2: {
                        Application.showForm(new FormMostrarProductos());
                        break;
                    }
                    case 3: {
                        Application.showForm(new panelCalcularPrecioProducto());
                        break;
                    }
                    case 4: {
                        Application.showForm(new FormCompraProductos());
                        break;
                    }
                    case 5: {
                        Application.showForm(new FormReporteComprasProductosC());
                        break;
                    }
                    case 6: {
                        Application.showForm(new PanelNuevoProducto());
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Valor no esperado: " + subIndex);
                }
            } else if (index == 3) {

                /*
                Ventas -Datos Maestros
                 */
                switch (subIndex) {
                    case 1: {
                        Application.showForm(new panelCrearDatos());
                        break;
                    }
                    case 2: {
                        Application.showForm(new PanelVerDatos());
                        break;
                    }

                    default:
                        throw new IllegalArgumentException("Valor no esperado: " + subIndex);
                }
                
            }else if (index == 4) {
                
                /*
                Ventas - Facturacion
                */
                
                  switch (subIndex) {
                    case 1: {
                        Application.showForm(new PanelRegistrarVenta());
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Valor no esperado: " + subIndex);
                }
                
            } else if (index == 5) {  //Tasas
                if (subIndex == 1) {
                    Application.showForm(new formprueba());
                } else if (subIndex == 2) {
                    Application.showForm(new FormCambio());
                } else if (subIndex == 3) {
                    Application.showForm(new FormCrearInsumo());

                }

            } else if (index == 6) { //Configuracion
                if (subIndex == 1) {
                    Application.showForm(new FormCrearUsuario());
                }
                else if (subIndex == 3) {
                    Application.showForm(new formConfiguracion());
                }
            } else if (index == 9) {
                Application.logout();
            } else {
                action.cancel();
            }

        }
        );
    }

    private void setMenuFull(boolean full) {
        String icon;
        if (getComponentOrientation().isLeftToRight()) {
            icon = (full) ? "menu_left.svg" : "menu_right.svg";
        } else {
            icon = (full) ? "menu_right.svg" : "menu_left.svg";
        }
        menuButton.setIcon(new FlatSVGIcon("raven/icon/svg/" + icon, 0.8f));
        menu.setMenuFull(full);
        revalidate();
    }

    public void hideMenu() {
        menu.hideMenuItem();
    }

    public void showForm(Component component) {
        panelBody.removeAll();
        panelBody.add(component);
        panelBody.repaint();
        panelBody.revalidate();
    }

    public void setSelectedMenu(int index, int subIndex) {
        menu.setSelectedMenu(index, subIndex);
    }

    private Menu menu;
    private JPanel panelBody;
    private JButton menuButton;

    private class MainFormLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(5, 5);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                boolean ltr = parent.getComponentOrientation().isLeftToRight();
                Insets insets = UIScale.scale(parent.getInsets());
                int x = insets.left;
                int y = insets.top;
                int width = parent.getWidth() - (insets.left + insets.right);
                int height = parent.getHeight() - (insets.top + insets.bottom);
                int menuWidth = UIScale.scale(menu.isMenuFull() ? menu.getMenuMaxWidth() : menu.getMenuMinWidth());
                int menuX = ltr ? x : x + width - menuWidth;
                menu.setBounds(menuX, y, menuWidth, height);
                int menuButtonWidth = menuButton.getPreferredSize().width;
                int menuButtonHeight = menuButton.getPreferredSize().height;
                int menubX;
                if (ltr) {
                    menubX = (int) (x + menuWidth - (menuButtonWidth * (menu.isMenuFull() ? 0.5f : 0.3f)));
                } else {
                    menubX = (int) (menuX - (menuButtonWidth * (menu.isMenuFull() ? 0.5f : 0.7f)));
                }
                menuButton.setBounds(menubX, UIScale.scale(30), menuButtonWidth, menuButtonHeight);
                int gap = UIScale.scale(5);
                int bodyWidth = width - menuWidth - gap;
                int bodyHeight = height;
                int bodyx = ltr ? (x + menuWidth + gap) : x;
                int bodyy = y;
                panelBody.setBounds(bodyx, bodyy, bodyWidth, bodyHeight);
            }
        }
    }
}
