package dialog;

import COMPONENT_GRAPHER.datasets;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

/*
 *  COMPOSITE-GRAPHER v1.0
 *  
 *  Copyright (C) 2016-2017  Etienne Lord
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class MatrixOptions extends javax.swing.JDialog {

     datasets data=null;                             // The dataset
    Frame frame;                                     //parent frame
    public boolean status_run=false;
     public boolean no_log=true;
    /**
     * Creates new form MatrixOptions
     */
    public MatrixOptions(java.awt.Frame parent, datasets data_) {
        super(parent, true);         
        data=data_;
        this.frame=parent;
        setTitle("Edit maxtrix informations and display options");
        initComponents();
        this.Inverse_jCheckBox.setSelected(!data.inverse_matrix_table);
        this.display_char_numberingjCheckBox.setSelected(data.display_char_numbering);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension d = getSize();
        setLocation((screenSize.width-d.width)/2,
					(screenSize.height-d.height)/2);
        this.setVisible(true); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Inverse_jCheckBox = new javax.swing.JCheckBox();
        display_char_numberingjCheckBox = new javax.swing.JCheckBox();
        EditChar_jButton = new javax.swing.JButton();
        EditMatrix_jButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Matrix options"));

        Inverse_jCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        Inverse_jCheckBox.setText("Inverse display of Rows x Columns");
        Inverse_jCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inverse_jCheckBoxActionPerformed(evt);
            }
        });

        display_char_numberingjCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        display_char_numberingjCheckBox.setText("Display characters numbering (columns)");
        display_char_numberingjCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                display_char_numberingjCheckBoxActionPerformed(evt);
            }
        });

        EditChar_jButton.setText("Edit matrix characters");
        EditChar_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditChar_jButtonActionPerformed(evt);
            }
        });

        EditMatrix_jButton.setText("Edit matrix taxa");
        EditMatrix_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMatrix_jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(EditMatrix_jButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditChar_jButton)
                        .addGap(129, 129, 129))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Inverse_jCheckBox)
                            .addComponent(display_char_numberingjCheckBox))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Inverse_jCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(display_char_numberingjCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditChar_jButton)
                    .addComponent(EditMatrix_jButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void display_char_numberingjCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_display_char_numberingjCheckBoxActionPerformed
      this.data.display_char_numbering=this.display_char_numberingjCheckBox.isSelected();
    }//GEN-LAST:event_display_char_numberingjCheckBoxActionPerformed

    private void Inverse_jCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inverse_jCheckBoxActionPerformed
        this.data.inverse_matrix_table=!this.Inverse_jCheckBox.isSelected();
    }//GEN-LAST:event_Inverse_jCheckBoxActionPerformed

    private void EditChar_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditChar_jButtonActionPerformed
        this.setVisible(false);
        CharEditorJDialog cha=new CharEditorJDialog(frame, data);      
    }//GEN-LAST:event_EditChar_jButtonActionPerformed

    private void EditMatrix_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMatrix_jButtonActionPerformed
       this.setVisible(false);
       TaxaEditorJDialog tax=new TaxaEditorJDialog(frame, data);
     
    }//GEN-LAST:event_EditMatrix_jButtonActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditChar_jButton;
    private javax.swing.JButton EditMatrix_jButton;
    private javax.swing.JCheckBox Inverse_jCheckBox;
    private javax.swing.JCheckBox display_char_numberingjCheckBox;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
