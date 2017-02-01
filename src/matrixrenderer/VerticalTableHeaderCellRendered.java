package matrixrenderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
//import sun.swing.table.DefaultTableCellHeaderRenderer;
//import sun.swing.table.DefaultTableCellHeaderRenderer;

// Original code by:  Darryl Burke

public class VerticalTableHeaderCellRendered extends DefaultTableCellRenderer  {

    ImageIcon icon;
  /**
   * Constructs a <code>VerticalTableHeaderCellRenderer</code>.
   * <P>
   * The horizontal and vertical alignments and text positions are set as
   * appropriate to a vertical table header cell.
   */
  public VerticalTableHeaderCellRendered(boolean clockwise) {
      
      setHorizontalAlignment(LEFT);
    setHorizontalTextPosition(CENTER);
    setVerticalAlignment(CENTER);
    setVerticalTextPosition(TOP);    
    setFont( getFont().deriveFont(Font.BOLD) );
    
    setUI(new VerticalLabelUI(clockwise));   
    //setBorder(BorderFactory.createCompoundBorder(this.getBorder(),BorderFactory.createBevelBorder(1)));
  }
  


    @Override
    public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus,int row, int column) {       
        JLabel lbl = (JLabel) super.getTableCellRendererComponent(table,value, isSelected, hasFocus, row, column);
         lbl.setBorder(BorderFactory.createCompoundBorder(lbl.getBorder(), BorderFactory.createEtchedBorder(1)));       
        return lbl;
    }

    

    

    @Override
    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText(e);
//        java.awt.Point p = e.getPoint();
//        
//        int index = columnModel.getColumnIndexAtX(p.x);
//        int realIndex = columnModel.getColumn(index).getModelIndex();
//        return super.getToolTipText(event); //To change body of generated methods, choose Tools | Templates.
    }


    
//  @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
//      super.getTableCellRendererComponent(table, value, selected, focused, row, column); 
//      System.out.println(row+" "+column);  
//      JTableHeader header = table.getTableHeader();
//      setFont(header.getFont());
//      if (table.isColumnSelected(column)) {
//            setFont( getFont().deriveFont(Font.BOLD) );
//        } 
//          
//        return this;
//    }
}
