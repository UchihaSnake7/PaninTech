
package com.panin.application.utilities;

import com.panin.entidades.Producto;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxEditor;

/**
 *
 * @author ricke
 */
public class AutoCompleteComboBox extends JComboBox {
   public int caretPos = 0;
   public JTextField tfield = new JTextField();
   public AutoCompleteComboBox(final Object countries[]) {
      super(countries);
      setEditor(new BasicComboBoxEditor());
      setEditable(true);
   }
   
   public AutoCompleteComboBox(){
       
   }
   public void setSelectedIndex(int index) {
      super.setSelectedIndex(index);
      Producto p = new Producto();
      p = (Producto) getItemAt(index);
      System.out.print("\nProducto: " + p.getDescripcion());
      tfield.setText(p.getDescripcion());
//      tfield.setText(getItemAt(index).toString());
      tfield.setSelectionEnd(caretPos + tfield.getText().length());
      tfield.moveCaretPosition(caretPos);
   }
   public void setEditor(ComboBoxEditor editor) {
      super.setEditor(editor);
      if(editor.getEditorComponent() instanceof JTextField) {
         tfield = (JTextField) editor.getEditorComponent();
         tfield.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
               char key = ke.getKeyChar();
               if (!(Character.isLetterOrDigit(key) || Character.isSpaceChar(key) )) return;
               caretPos = tfield.getCaretPosition();
               System.out.print("\nCaretPos: " + caretPos);
               String text="";
               try {
                  text = tfield.getText(0, caretPos);
                  System.out.print("\nTexto: " + text);

               } catch (javax.swing.text.BadLocationException e) {
                  e.printStackTrace();
               }
               for (int i=0; i < getItemCount(); i++) {
                   Producto p = new Producto();
                    p = (Producto) getItemAt(i);
                    System.out.print("\nProducto: " + p.getDescripcion());

//                  String element = (String) getItemAt(i);
                  String element = p.getDescripcion();
                  if (element.startsWith(text)) {
                     setSelectedIndex(i);
                     return;
                  }
               }
            }
         });
      }
   }    
}
