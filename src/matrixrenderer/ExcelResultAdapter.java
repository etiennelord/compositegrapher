package matrixrenderer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.datatransfer.*;
import java.util.*;
/**
 * Original code by: By Ashok Banerjee and Jignesh Mehta
 * Site: http://www.javaworld.com/article/2077579/learn-java/java-tip-77--enable-copy-and-paste-functionality-between-swing-s-jtables-and-excel.html
 * ExcelAdapter enables Copy-Paste Clipboard functionality on JTables.
 * The clipboard data format used by the adapter is compatible with
 * the clipboard format used by Excel. This provides for clipboard
 * interoperability between enabled JTables and Excel.
 */
public class ExcelResultAdapter implements ActionListener
   {
   private String rowstring,value;
   private Clipboard system;
   private StringSelection stsel;
   private JTable jTable1 ;
   /**
    * The Excel Adapter is constructed with a
    * JTable on which it enables Copy-Paste and acts
    * as a Clipboard listener.
    */
public ExcelResultAdapter(JTable myJTable)
   {
       jTable1 = myJTable;
     
      KeyStroke copy = KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK,false);      
      KeyStroke copy2 = KeyStroke.getKeyStroke(KeyEvent.VK_INSERT,ActionEvent.CTRL_MASK,false);      
      KeyStroke paste = KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK,false);
      KeyStroke paste2 = KeyStroke.getKeyStroke(KeyEvent.VK_INSERT,ActionEvent.SHIFT_MASK,false);
      
      KeyStroke delete = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);
      
    jTable1.registerKeyboardAction(this,"Copy",copy,JComponent.WHEN_FOCUSED);
    jTable1.registerKeyboardAction(this,"Copy",copy2,JComponent.WHEN_FOCUSED);
    jTable1.registerKeyboardAction(this,"Paste",paste,JComponent.WHEN_FOCUSED);
    jTable1.registerKeyboardAction(this,"Paste",paste2,JComponent.WHEN_FOCUSED);
    jTable1.registerKeyboardAction(this,"Delete",delete,JComponent.WHEN_FOCUSED);
    
      system = Toolkit.getDefaultToolkit().getSystemClipboard();
   }
   /**
    * Public Accessor methods for the Table on which this adapter acts.
    */
public JTable getJTable() {return jTable1;}
public void setJTable(JTable jTable1) {this.jTable1=jTable1;}


/**
    * This method is activated on the Keystrokes we are listening to
    * in this implementation. Here it listens for Copy and Paste ActionCommands.
    * Selections comprising non-adjacent cells result in invalid selection and
    * then copy action cannot be performed.
    * Paste is done by aligning the upper left corner of the selection with the
    * 1st element in the current selection of the JTable.
    */
public void actionPerformed(ActionEvent e)
   {
      
       
        if (e.getActionCommand().compareTo("Delete")==0)
      {
         StringBuffer sbf=new StringBuffer();
         // Check to ensure we have selected only a contiguous block of
         // cells
         int numcols=jTable1.getSelectedColumnCount();
         int numrows=jTable1.getSelectedRowCount();
         int[] rowsselected=jTable1.getSelectedRows();
         int[] colsselected=jTable1.getSelectedColumns();
         if (!((numrows-1==rowsselected[rowsselected.length-1]-rowsselected[0] &&
                numrows==rowsselected.length) && (numcols-1==colsselected[colsselected.length-1]-colsselected[0] && numcols==colsselected.length))) {
            JOptionPane.showMessageDialog(null, "Invalid delete Selection", "Invalid delete Selection", JOptionPane.ERROR_MESSAGE);
            return;
         }
         for (int i=0;i<numrows;i++) {
            for (int j=0;j<numcols;j++) {
              jTable1.setValueAt("",rowsselected[i],colsselected[j]);                 
            }            
         } 
         this.jTable1.repaint();
      }
       
       if (e.getActionCommand().compareTo("Copy")==0)
      {
         StringBuffer sbf=new StringBuffer();
         // Check to ensure we have selected only a contiguous block of
         // cells
         int numcols=jTable1.getSelectedColumnCount();
         int numrows=jTable1.getSelectedRowCount(); //--Copy also the row header
         int[] rowsselected=jTable1.getSelectedRows();
         int[] colsselected=jTable1.getSelectedColumns();
           //--System.out.println("Copy" +numcols+" "+numrows);
         if (!((numrows-1==rowsselected[rowsselected.length-1]-rowsselected[0] &&
                numrows==rowsselected.length) &&
(numcols-1==colsselected[colsselected.length-1]-colsselected[0] &&
                numcols==colsselected.length)))
         {
//            JOptionPane.showMessageDialog(null, "Invalid Copy Selection",
//                                          "Invalid Copy Selection",
//                                          JOptionPane.ERROR_MESSAGE);
//            return;
             numcols=jTable1.getColumnCount();
             numrows=jTable1.getRowCount();
             colsselected=new int[numcols];
             rowsselected=new int[numrows];
            for (int i=0; i<numcols;i++) colsselected[i]=i;
             for (int i=0; i<numrows;i++) rowsselected[i]=i;
             
         } 
            
               for (int j=0;j<numcols;j++)
                {
                String name=jTable1.getColumnName(colsselected[j]);
                //--String html tag
                    name=name.replaceAll("\\<[^>]*>","");
                    name=name.replaceAll("&nbsp;","");
                    sbf.append(name);
                 if (j<numcols-1) sbf.append("\t");
                }
              sbf.append("\n");
             for (int i=0;i<numrows;i++)
             {
                for (int j=0;j<numcols;j++)
                {
                    sbf.append(jTable1.getValueAt(rowsselected[i],colsselected[j]));
                   if (j<numcols-1) sbf.append("\t");
                }
                sbf.append("\n");
             }
         
          
         stsel  = new StringSelection(sbf.toString());
         system = Toolkit.getDefaultToolkit().getSystemClipboard();
         system.setContents(stsel,stsel);
      }
       
       if (e.getActionCommand().compareTo("CopyAll")==0)
      {
         StringBuffer sbf=new StringBuffer();
         // Check to ensure we have selected only a contiguous block of
         // cells
         int numcols=jTable1.getColumnCount();
         int numrows=jTable1.getRowCount();
          
           for (int j=0;j<numcols;j++)
            {
           String name=jTable1.getColumnName(j);
                //--String html tag
                    name=name.replaceAll("\\<[^>]*>","");
                    name=name.replaceAll("&nbsp;","");
                    sbf.append(name);
             if (j<numcols-1) sbf.append("\t");
            }
          sbf.append("\n");
         for (int i=0;i<numrows;i++)
         {
            for (int j=0;j<numcols;j++)
            {
            sbf.append(jTable1.getValueAt(i,j));
               if (j<numcols-1) sbf.append("\t");
            }
            sbf.append("\n");
         }
         
         stsel  = new StringSelection(sbf.toString());
         system = Toolkit.getDefaultToolkit().getSystemClipboard();
         system.setContents(stsel,stsel);
      } 
       
      if (e.getActionCommand().compareTo("Paste")==0)
      {
          //--System.out.println("Trying to Paste");
          int startRow=(jTable1.getSelectedRows())[0];
          int startCol=(jTable1.getSelectedColumns())[0];
          try
          {
             String trstring= (String)(system.getContents(this).getTransferData(DataFlavor.stringFlavor));
             //-- System.out.println("String is:"+trstring);
             StringTokenizer st1=new StringTokenizer(trstring,"\n");
             for(int i=0;st1.hasMoreTokens();i++)
             {
                rowstring=st1.nextToken();
                StringTokenizer st2=new StringTokenizer(rowstring,"\t");
                for(int j=0;st2.hasMoreTokens();j++)
                {
                   value=(String)st2.nextToken();
                   if (startRow+i< jTable1.getRowCount()  &&
                       startCol+j< jTable1.getColumnCount())
                      jTable1.setValueAt(value,startRow+i,startCol+j);
                   //--debug System.out.println("Putting "+ value+"at row="+startRow+i+"column="+startCol+j);                   
               }
            }
             
            this.jTable1.repaint();
         }
         catch(Exception ex){ex.printStackTrace();}
      }
   }
}