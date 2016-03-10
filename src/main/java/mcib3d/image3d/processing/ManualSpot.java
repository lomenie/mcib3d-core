/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mcib3d.image3d.processing;

import ij.IJ;
import ij.ImagePlus;
import ij.WindowManager;
import ij.gui.Roi;
import ij.gui.Toolbar;
import ij.plugin.frame.RoiManager;
import ij.process.ImageProcessor;
import mcib3d.utils.ArrayUtil;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import mcib3d.geom.Object3D;
import mcib3d.geom.Object3DVoxels;
import mcib3d.geom.Objects3DPopulation;
import mcib3d.geom.Voxel3D;
import mcib3d.image3d.*;

/**
 *
 * @author thomas
 */
public class ManualSpot extends javax.swing.JFrame {

    int threshold_method = 0;
    int spot_method = 0;
    // constant
    int threshold_constant = 10000;
    // gauss
    int rad_gauss = 10;
    double sd_gauss = 1.0;
    // local_mean
    int r0 = 2;
    int r1 = 4;
    int r2 = 6;
    double weight = 0.5;
    // Images
    ImagePlus plusorig = null;
    ImageHandler spot3DImage = null;
    Objects3DPopulation popOrig;
    ImageInt labelImage = null;
    ImagePlus plusres = null;
    Object3D[] objs = null;
    int col = 1;

    /**
     * Creates new form ManualSpot
     */
    public ManualSpot() {
        initComponents();

        // initialisation
        jComboBoxMethod.setSelectedIndex(spot_method);
        jComboBoxThreshold.setSelectedIndex(threshold_method);

        if (plusorig == null) {
            plusorig = IJ.getImage();
        }

        if (spot3DImage == null) {
            spot3DImage = ImageHandler.wrap(plusorig);
            labelImage = new ImageShort("SegmentedSpots", spot3DImage.sizeX, spot3DImage.sizeY, spot3DImage.sizeZ);
            labelImage.show();
            popOrig = new Objects3DPopulation();
            popOrig.addImage(plusorig);
            col = popOrig.getNbObjects();
        }
        initInterface();
    }

    public ManualSpot(ImagePlus raw, ImagePlus seg, int firstLabel) {
        initComponents();
        col = firstLabel;
        // initialisation
        jComboBoxMethod.setSelectedIndex(spot_method);
        jComboBoxThreshold.setSelectedIndex(threshold_method);

        plusorig = raw;
        spot3DImage = ImageHandler.wrap(plusorig);

        plusres = seg;
        labelImage = ImageInt.wrap(plusres);
        popOrig = new Objects3DPopulation();
        popOrig.addImage(plusres);

        initInterface();
    }

    public ManualSpot(ImagePlus raw, ImagePlus seg) {
        initComponents();
        // initialisation
        jComboBoxMethod.setSelectedIndex(spot_method);
        jComboBoxThreshold.setSelectedIndex(threshold_method);

        plusorig = raw;
        spot3DImage = ImageInt.wrap(plusorig);

        plusres = seg;
        labelImage = ImageInt.wrap(plusres);
        col = (int) labelImage.getMax() + 1;
        popOrig = new Objects3DPopulation();
        popOrig.addImage(plusres);

        initInterface();
    }

    private void initInterface() {
        // adjust slider threshold
        jSliderConstant.setMaximum((int) spot3DImage.getMax());
        jSliderConstant.setMinimum(0);
        ArrayUtil hist = new ArrayUtil(spot3DImage.getHistogram(new BlankMask(spot3DImage)));
        int pcHigh = hist.indexOfSumPercent(0.999);
        jSliderConstant.setValue(pcHigh);
        // set tool point and open RoiManager
        IJ.setTool(Toolbar.POINT);
        RoiManager manager = RoiManager.getInstance();
        if (manager == null) {
            manager = new RoiManager();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxThreshold = new javax.swing.JComboBox();
        jComboBoxMethod = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanelConstant = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSliderConstant = new javax.swing.JSlider();
        jTextFieldConstant = new javax.swing.JTextField();
        jPanelGauss = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldRadGauss = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSliderSDGauss = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldSdGauss = new javax.swing.JTextField();
        jPanelLocalMean = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldR0 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldR1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldR2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldWeight = new javax.swing.JTextField();
        jButtonTest = new javax.swing.JButton();
        jButtonOK = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextFieldLog = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jComboBoxThreshold.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Constant", "Local mean", "Gauss fitting" }));
        jComboBoxThreshold.setSelectedIndex(threshold_method);
        jComboBoxThreshold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxThresholdActionPerformed(evt);
            }
        });

        jComboBoxMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Classical", "Maximum", "block" }));
        jComboBoxMethod.setSelectedIndex(spot_method);
        jComboBoxMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMethodActionPerformed(evt);
            }
        });

        jLabel1.setText("Threshold :");

        jLabel2.setText("Method :");

        jPanelConstant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Constant :");

        jSliderConstant.setMaximum(10000);
        jSliderConstant.setValue(threshold_constant);
        jSliderConstant.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderConstantStateChanged(evt);
            }
        });

        jTextFieldConstant.setText("  "+threshold_constant+"  ");
        jTextFieldConstant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldConstantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConstantLayout = new javax.swing.GroupLayout(jPanelConstant);
        jPanelConstant.setLayout(jPanelConstantLayout);
        jPanelConstantLayout.setHorizontalGroup(
            jPanelConstantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConstantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConstantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConstantLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSliderConstant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConstantLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextFieldConstant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))))
        );
        jPanelConstantLayout.setVerticalGroup(
            jPanelConstantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConstantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConstantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSliderConstant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldConstant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelGauss.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Gauss : ");

        jTextFieldRadGauss.setText(""+rad_gauss);

        jLabel5.setText("Rad :");

        jSliderSDGauss.setMaximum(50);
        jSliderSDGauss.setValue(10);
        jSliderSDGauss.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderSDGaussStateChanged(evt);
            }
        });

        jLabel6.setText("SD :");

        jTextFieldSdGauss.setText(""+sd_gauss);
        jTextFieldSdGauss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSdGaussActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGaussLayout = new javax.swing.GroupLayout(jPanelGauss);
        jPanelGauss.setLayout(jPanelGaussLayout);
        jPanelGaussLayout.setHorizontalGroup(
            jPanelGaussLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGaussLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGaussLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGaussLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldRadGauss, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGaussLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldSdGauss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSliderSDGauss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanelGaussLayout.setVerticalGroup(
            jPanelGaussLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGaussLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGaussLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRadGauss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGaussLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSliderSDGauss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelGaussLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jTextFieldSdGauss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanelLocalMean.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Local mean :");

        jLabel8.setText("R0");

        jTextFieldR0.setText("  "+r0+" ");
        jTextFieldR0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldR0ActionPerformed(evt);
            }
        });

        jLabel9.setText("R1");

        jTextFieldR1.setText("  "+r1+" ");
        jTextFieldR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldR1ActionPerformed(evt);
            }
        });

        jLabel10.setText("R2");

        jTextFieldR2.setText("  "+r2+" ");
        jTextFieldR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldR2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Weight");

        jTextFieldWeight.setText("  "+weight+" ");
        jTextFieldWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldWeightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLocalMeanLayout = new javax.swing.GroupLayout(jPanelLocalMean);
        jPanelLocalMean.setLayout(jPanelLocalMeanLayout);
        jPanelLocalMeanLayout.setHorizontalGroup(
            jPanelLocalMeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLocalMeanLayout.createSequentialGroup()
                .addGroup(jPanelLocalMeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelLocalMeanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLocalMeanLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldWeight))
                    .addGroup(jPanelLocalMeanLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(jPanelLocalMeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanelLocalMeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldR2)
                            .addComponent(jTextFieldR1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldR0, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLocalMeanLayout.setVerticalGroup(
            jPanelLocalMeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLocalMeanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLocalMeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldR0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLocalMeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLocalMeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLocalMeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonTest.setText("Test");
        jButtonTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTestActionPerformed(evt);
            }
        });

        jButtonOK.setText("Confirm");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonClose.setText("Quit");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jTextFieldLog.setColumns(20);
        jTextFieldLog.setRows(5);
        jScrollPane1.setViewportView(jTextFieldLog);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("1- Choose the method of segmentation.\n2- Click on seeds position and add them\n    to the RoiManager ([t]). \n3- Test the results of segmentation.\n4- Confirm to draw the results in the label\n     Image.");
        jTextArea1.setToolTipText("Instructions");
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonOK, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanelGauss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanelConstant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanelLocalMean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelConstant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelGauss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelLocalMean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOK)
                        .addGap(53, 53, 53)
                        .addComponent(jButtonClose)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxThresholdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxThresholdActionPerformed
        threshold_method = jComboBoxThreshold.getSelectedIndex();
        System.out.println("threshold " + threshold_method);
        if (threshold_method == 0) {
            jPanelConstant.setBackground(Color.white);
            jPanelGauss.setBackground(Color.red);
            jPanelLocalMean.setBackground(Color.red);
        } else if (threshold_method == 1) {
            jPanelConstant.setBackground(Color.red);
            jPanelGauss.setBackground(Color.red);
            jPanelLocalMean.setBackground(Color.white);
        } else if (threshold_method == 2) {
            jPanelConstant.setBackground(Color.red);
            jPanelGauss.setBackground(Color.white);
            jPanelLocalMean.setBackground(Color.red);
        }
    }//GEN-LAST:event_jComboBoxThresholdActionPerformed

    private void jComboBoxMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMethodActionPerformed
        spot_method = jComboBoxMethod.getSelectedIndex();
    }//GEN-LAST:event_jComboBoxMethodActionPerformed

    private void jTextFieldR0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldR0ActionPerformed
        r0 = Integer.parseInt(jTextFieldR0.getText().trim());
    }//GEN-LAST:event_jTextFieldR0ActionPerformed

    private void jTextFieldWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldWeightActionPerformed
        weight = Double.parseDouble(jTextFieldWeight.getText().trim());
    }//GEN-LAST:event_jTextFieldWeightActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        updateLabelImage();
        objs = null;
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jTextFieldConstantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldConstantActionPerformed
        threshold_constant = Integer.parseInt(jTextFieldConstant.getText().trim());
        jSliderConstant.setValue(threshold_constant);
    }//GEN-LAST:event_jTextFieldConstantActionPerformed

    private void jTextFieldR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldR1ActionPerformed
        r1 = Integer.parseInt(jTextFieldR1.getText().trim());
    }//GEN-LAST:event_jTextFieldR1ActionPerformed

    private void jTextFieldR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldR2ActionPerformed
        r2 = Integer.parseInt(jTextFieldR2.getText().trim());
    }//GEN-LAST:event_jTextFieldR2ActionPerformed

    private void jSliderConstantStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderConstantStateChanged
        threshold_constant = jSliderConstant.getValue();
        jTextFieldConstant.setText("" + threshold_constant);
        plusorig.getProcessor().setThreshold(threshold_constant, 100000, ImageProcessor.RED_LUT);
        plusorig.updateAndDraw();
    }//GEN-LAST:event_jSliderConstantStateChanged

    private void jSliderSDGaussStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderSDGaussStateChanged
        sd_gauss = jSliderSDGauss.getValue();
        jTextFieldSdGauss.setText("" + sd_gauss / 10);
    }//GEN-LAST:event_jSliderSDGaussStateChanged

    private void jButtonTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTestActionPerformed
        segmentSpots();
    }//GEN-LAST:event_jButtonTestActionPerformed

    private void jTextFieldSdGaussActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSdGaussActionPerformed
        sd_gauss = Double.parseDouble(jTextFieldSdGauss.getText().trim());
        jSliderSDGauss.setValue((int) (sd_gauss * 10));
    }//GEN-LAST:event_jTextFieldSdGaussActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        close();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    public void close() {
        dispose();
        WindowManager.removeWindow(this);
//        if (plusorig != null) {
//            plusorig.close();
//        }
//        if (plusres != null) {
//            plusres.close();
//        }
    }

    public void windowClosing(WindowEvent e) {
        if (e.getSource() == this) {
            close();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManualSpot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManualSpot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManualSpot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManualSpot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ManualSpot().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonClose;
    public javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonTest;
    private javax.swing.JComboBox jComboBoxMethod;
    private javax.swing.JComboBox jComboBoxThreshold;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelConstant;
    private javax.swing.JPanel jPanelGauss;
    private javax.swing.JPanel jPanelLocalMean;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSliderConstant;
    private javax.swing.JSlider jSliderSDGauss;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldConstant;
    private javax.swing.JTextArea jTextFieldLog;
    private javax.swing.JTextField jTextFieldR0;
    private javax.swing.JTextField jTextFieldR1;
    private javax.swing.JTextField jTextFieldR2;
    private javax.swing.JTextField jTextFieldRadGauss;
    private javax.swing.JTextField jTextFieldSdGauss;
    private javax.swing.JTextField jTextFieldWeight;
    // End of variables declaration//GEN-END:variables

    private void segmentSpots() {
        Roi roi;
        RoiManager manager = RoiManager.getInstance();
        Roi[] rois = manager.getRoisAsArray();
        if ((manager == null) || (rois.length == 0)) {
            IJ.showMessage("Put rois in the RoiManager");
            return;
        }
        if (objs == null) {
            objs = new Object3D[rois.length];
        }
        String text = "";
        for (int r = 0; r < rois.length; r++) {
            roi = rois[r];
            Rectangle rect = roi.getBounds();
            int x = rect.x;
            int y = rect.y;
            int z = manager.getSliceNumber(manager.getName(r));
            text = text.concat("\nx=" + x + " " + y + " " + z);
            jTextFieldLog.setText(text);

            Segment3DSpots segSpots = new Segment3DSpots(spot3DImage, null);
            segSpots.setLabelImage(labelImage);
            segSpots.show = true;
            // find local maximum     
            Voxel3D v = segSpots.getLocalMaximum(x, y, z, 2, 2, 2);
            if (v != null) {
                text = text.concat("\nMax local " + v.getX() + " " + v.getY() + " " + v.getZ() + " " + v.getValue());
                jTextFieldLog.setText(text);
                x = v.getRoundX();
                y = v.getRoundY();
                z = v.getRoundZ();
            }
            // set parameter
            if (threshold_method == 0) {
                segSpots.setMethodLocal(Segment3DSpots.LOCAL_CONSTANT);
            } else if (threshold_method == 1) {
                segSpots.setMethodLocal(Segment3DSpots.LOCAL_MEAN);
            } else {
                segSpots.setMethodLocal(Segment3DSpots.LOCAL_GAUSS);
            }
            if (spot_method == 0) {
                segSpots.setMethodSeg(Segment3DSpots.SEG_CLASSICAL);
            } else if (spot_method == 0) {
                segSpots.setMethodSeg(Segment3DSpots.SEG_MAX);
            } else {
                segSpots.setMethodSeg(Segment3DSpots.SEG_BLOCK);
            }
            segSpots.setLocalThreshold(threshold_constant);
            segSpots.setGaussMaxr(rad_gauss);
            segSpots.setGaussPc(sd_gauss / 10.0);
            segSpots.setRadiusLocalMean(r0, r1, r2, weight);
            segSpots.setWatershed(false);

            // reset labelimage
            if (objs[r] != null) {
                objs[r].draw(labelImage, 0);
                //IJ.log("deleting old spot " + r);
            }
            // redraw population (in case spot has erased objects)
            popOrig.draw(labelImage);
            segSpots.setLabelImage(labelImage);

            ArrayList<Voxel3D> spot = segSpots.segmentOneSpot(x, y, z, col);
            //IJ.log("spot " + r + " at " + x + " " + y + " " + z + " : " + spot);
            if (spot != null) {
                //jTextFieldLog.setText(jTextFieldLog.getText() + "\nspot found, size " + spot.size());
                //IJ.log("spot found, size " + spot.size());
                if (spot.size() > 0) {
                    objs[r] = new Object3DVoxels(spot);
                    objs[r].draw(labelImage, col);
                }
                if (plusres == null) {
                    plusres = labelImage.getImagePlus();
                    plusres.show();
                    IJ.run(plusres, "3-3-2 RGB", "");
                }
                IJ.setMinAndMax(plusres, 0, col);
                plusres.setSlice((int) objs[r].getCenterZ() + 1);
                plusres.updateAndDraw();
            } else {
                jTextFieldLog.setText(jTextFieldLog.getText() + "\nno spot found !");
            }
        }
        labelImage.updateDisplay();
    }

    public Object3D[] getObjects() {
        return objs;
    }

    protected void updateLabelImage() {
        for (Object3D o : objs) {
            o.draw(labelImage.getImageStack(), col);
            IJ.log("Manual segmenter paint object:" + col);
            col++;
        }
        labelImage.updateDisplay();
    }
}
