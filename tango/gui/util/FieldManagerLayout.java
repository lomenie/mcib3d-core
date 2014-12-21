
package tango.gui.util;

import tango.gui.FieldManager;
import tango.helper.HelpManager;
import tango.helper.ID;
import tango.helper.RetrieveHelp;

/**
 *
 **
 * /**
 * Copyright (C) 2012 Jean Ollion
 *
 *
 *
 * This file is part of tango
 *
 * tango is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * @author Jean Ollion
 */
public class FieldManagerLayout extends javax.swing.JPanel {
    protected FieldManager fieldManager;
    public FieldManagerLayout(FieldManager fieldManager) {
        this.fieldManager=fieldManager;
        initComponents();  
    }
    
    public void registerComponents(HelpManager hm) {
        hm.objectIDs.put(this.selectAll, new ID(RetrieveHelp.fieldPage, "Select_All"));
        hm.objectIDs.put(this.selectNone, new ID(RetrieveHelp.fieldPage, "Select_None"));
        hm.objectIDs.put(this.deleteFields, new ID(RetrieveHelp.fieldPage, "Delete_Fields"));
        hm.objectIDs.put(this.deleteInputImages, new ID(RetrieveHelp.fieldPage, "Delete_Input_Images"));
        hm.objectIDs.put(this.viewOverlay, new ID(RetrieveHelp.fieldPage, "Overlay"));
        hm.objectIDs.put(this.viewInputImages, new ID(RetrieveHelp.fieldPage, "Input_Images"));
        hm.objectIDs.put(this.viewCells, new ID(RetrieveHelp.fieldPage, "Cells"));
        hm.objectIDs.put(this.processNuc, new ID(RetrieveHelp.fieldPage, "Process_Nuclei"));
        hm.objectIDs.put(this.test, new ID(RetrieveHelp.fieldPage, "Test"));
        hm.objectIDs.put(this.cropCells, new ID(RetrieveHelp.fieldPage, "Crop_Cells"));
        hm.objectIDs.put(this.processStructures, new ID(RetrieveHelp.fieldPage, "Process_Structures"));
        hm.objectIDs.put(this.measurement, new ID(RetrieveHelp.fieldPage, "Quantifications"));
        hm.objectIDs.put(this.override, new ID(RetrieveHelp.fieldPage, "Override_Quantifications"));
        hm.objectIDs.put(this.run, new ID(RetrieveHelp.fieldPage, "Run"));
        hm.objectIDs.put(this.manualSeg, new ID(RetrieveHelp.fieldPage, "Manual_Segmentation"));
        hm.objectIDs.put(this.exportQuantifications, new ID(RetrieveHelp.fieldPage, "Export_Quantifications"));
        //hm.objectIDs.put(this.deleteSlices, new ID(RetrieveHelp.fieldPage, "Delete_Slices"));
    }
    
    public void toggleIsRunning(boolean isRunning) {
        this.selectAll.setEnabled(!isRunning);
        this.selectNone.setEnabled(!isRunning);
        this.deleteFields.setEnabled(!isRunning);
        this.deleteInputImages.setEnabled(!isRunning);
        this.list.setEnabled(!isRunning);
        this.manualSeg.setEnabled(!isRunning);
        this.run.setEnabled(!isRunning);
        this.test.setEnabled(!isRunning);
        this.viewCells.setEnabled(!isRunning);
        this.viewInputImages.setEnabled(!isRunning);
        this.viewOverlay.setEnabled(!isRunning);
        this.exportQuantifications.setEnabled(!isRunning);
        this.viewSelections.setEnabled(!isRunning);
        //this.deleteSlices.setEnabled(!isRunning);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listScrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        selectPanel = new javax.swing.JPanel();
        selectAll = new javax.swing.JButton();
        selectNone = new javax.swing.JButton();
        deleteFields = new javax.swing.JButton();
        deleteInputImages = new javax.swing.JButton();
        viewPanel = new javax.swing.JPanel();
        viewOverlay = new javax.swing.JButton();
        viewInputImages = new javax.swing.JButton();
        viewCells = new javax.swing.JToggleButton();
        viewSelections = new javax.swing.JToggleButton();
        processPanel = new javax.swing.JPanel();
        processNuc = new javax.swing.JCheckBox();
        cropCells = new javax.swing.JCheckBox();
        processStructures = new javax.swing.JCheckBox();
        measurement = new javax.swing.JCheckBox();
        override = new javax.swing.JCheckBox();
        test = new javax.swing.JButton();
        run = new javax.swing.JButton();
        manualSeg = new javax.swing.JToggleButton();
        exportQuantifications = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Fields"));
        setMinimumSize(new java.awt.Dimension(490, 670));
        setPreferredSize(new java.awt.Dimension(490, 670));

        listScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        listScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        listScrollPane.setViewportView(list);

        selectPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Selection"));

        selectAll.setText("Select All");
        selectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllActionPerformed(evt);
            }
        });

        selectNone.setText("Select None");
        selectNone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectNoneActionPerformed(evt);
            }
        });

        deleteFields.setText("Delete Fields");
        deleteFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFieldsActionPerformed(evt);
            }
        });

        deleteInputImages.setText("Delete Input Images");
        deleteInputImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInputImagesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectPanelLayout = new javax.swing.GroupLayout(selectPanel);
        selectPanel.setLayout(selectPanelLayout);
        selectPanelLayout.setHorizontalGroup(
            selectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(selectNone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteInputImages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        selectPanelLayout.setVerticalGroup(
            selectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectPanelLayout.createSequentialGroup()
                .addComponent(selectAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectNone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteFields)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteInputImages))
        );

        viewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("View"));

        viewOverlay.setText("Overlay");
        viewOverlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOverlayActionPerformed(evt);
            }
        });

        viewInputImages.setText("Input Images");
        viewInputImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewInputImagesActionPerformed(evt);
            }
        });

        viewCells.setText(">Cells>");
        viewCells.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCellsActionPerformed(evt);
            }
        });

        viewSelections.setText(">Selections>");
        viewSelections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSelectionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewOverlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewInputImages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewCells, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewSelections, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addComponent(viewOverlay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewInputImages)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewSelections)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewCells)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        processPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Process"));

        processNuc.setText("Process Nuclei");

        cropCells.setText("Crop Cells");

        processStructures.setText("Process Structures");

        measurement.setText("Measurements");

        override.setText("Override Meas.");

        test.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tango/icons/test.png"))); // NOI18N
        test.setToolTipText("Test");
        test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testActionPerformed(evt);
            }
        });

        run.setText("Run");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        manualSeg.setText(">Manual Segmentation>");
        manualSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualSegActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout processPanelLayout = new javax.swing.GroupLayout(processPanel);
        processPanel.setLayout(processPanelLayout);
        processPanelLayout.setHorizontalGroup(
            processPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processPanelLayout.createSequentialGroup()
                .addGroup(processPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(processPanelLayout.createSequentialGroup()
                        .addComponent(processNuc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(test))
                    .addComponent(cropCells)
                    .addComponent(processStructures)
                    .addComponent(measurement)
                    .addComponent(override))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(run, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(manualSeg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        processPanelLayout.setVerticalGroup(
            processPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processPanelLayout.createSequentialGroup()
                .addGroup(processPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processNuc)
                    .addComponent(test))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cropCells)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(processStructures)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(measurement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(override)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(run)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manualSeg))
        );

        exportQuantifications.setText("Export Measurements");
        exportQuantifications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportQuantificationsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(processPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exportQuantifications, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(selectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(processPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportQuantifications)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllActionPerformed
        fieldManager.selectAll();
    }//GEN-LAST:event_selectAllActionPerformed

    private void selectNoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectNoneActionPerformed
        fieldManager.selectNone();
    }//GEN-LAST:event_selectNoneActionPerformed

    private void deleteFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFieldsActionPerformed
        fieldManager.deleteFields();
    }//GEN-LAST:event_deleteFieldsActionPerformed

    private void deleteInputImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInputImagesActionPerformed
        fieldManager.deleteInputImages();
    }//GEN-LAST:event_deleteInputImagesActionPerformed

    private void manualSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualSegActionPerformed
        fieldManager.toggleShowManualSeg();
    }//GEN-LAST:event_manualSegActionPerformed

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed
        fieldManager.run(this.processNuc.isSelected(), this.cropCells.isSelected(), this.processStructures.isSelected(), this.measurement.isSelected(), this.override.isSelected());
    }//GEN-LAST:event_runActionPerformed

    private void testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testActionPerformed
        fieldManager.test();
    }//GEN-LAST:event_testActionPerformed

    private void viewCellsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCellsActionPerformed
        fieldManager.toggleShowCells();
    }//GEN-LAST:event_viewCellsActionPerformed

    private void viewInputImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewInputImagesActionPerformed
        fieldManager.viewInputImages();
    }//GEN-LAST:event_viewInputImagesActionPerformed

    private void viewOverlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOverlayActionPerformed
        fieldManager.viewOverlay();
    }//GEN-LAST:event_viewOverlayActionPerformed

    private void exportQuantificationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportQuantificationsActionPerformed
        fieldManager.extractData();
    }//GEN-LAST:event_exportQuantificationsActionPerformed

    private void viewSelectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSelectionsActionPerformed
        fieldManager.toggleShowSelections();
    }//GEN-LAST:event_viewSelectionsActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cropCells;
    private javax.swing.JButton deleteFields;
    private javax.swing.JButton deleteInputImages;
    private javax.swing.JButton exportQuantifications;
    public javax.swing.JList list;
    private javax.swing.JScrollPane listScrollPane;
    public javax.swing.JToggleButton manualSeg;
    private javax.swing.JCheckBox measurement;
    private javax.swing.JCheckBox override;
    private javax.swing.JCheckBox processNuc;
    private javax.swing.JPanel processPanel;
    private javax.swing.JCheckBox processStructures;
    private javax.swing.JButton run;
    private javax.swing.JButton selectAll;
    private javax.swing.JButton selectNone;
    private javax.swing.JPanel selectPanel;
    private javax.swing.JButton test;
    public javax.swing.JToggleButton viewCells;
    private javax.swing.JButton viewInputImages;
    private javax.swing.JButton viewOverlay;
    private javax.swing.JPanel viewPanel;
    public javax.swing.JToggleButton viewSelections;
    // End of variables declaration//GEN-END:variables


    
}
