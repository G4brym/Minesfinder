package pt.technic.apps.minesfinder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Massadas
 */
public class MinesFinder extends javax.swing.JFrame {

    private RecordTable recordEasy;
    private RecordTable recordMedium;
    private RecordTable recordHard;

    /**
     * Creates new form MinesFinder
     */
    public MinesFinder() {
        initComponents();
        recordEasy = new RecordTable();
        recordMedium = new RecordTable();
        recordHard = new RecordTable();

        readGameRecords();

        labelEasyName.setText(recordEasy.getName());
        labelEasyPoints.setText(Long.toString(recordEasy.getScore()/1000));
        labelMediumName.setText(recordMedium.getName());
        labelMediumPoints.setText(Long.toString(recordMedium.getScore()/1000));
        labelHardName.setText(recordHard.getName());
        labelHardPoints.setText(Long.toString(recordHard.getScore()/1000));

        recordEasy.addRecordTableListener(new RecordTableListener() {
            @Override
            public void recordUpdated(RecordTable record) {
                recordEasyUpdated(record);
            }
        });

        recordMedium.addRecordTableListener(new RecordTableListener() {
            @Override
            public void recordUpdated(RecordTable record) {
                recordMediumUpdated(record);
            }
        });

        recordHard.addRecordTableListener(new RecordTableListener() {
            @Override
            public void recordUpdated(RecordTable record) {
                recordHardUpdated(record);
            }
        });
    }

    private void recordEasyUpdated(RecordTable record) {
        labelEasyName.setText(record.getName());
        labelEasyPoints.setText(Long.toString(record.getScore()/1000));
        saveGameRecords();
    }

    private void recordMediumUpdated(RecordTable record) {
        labelMediumName.setText(record.getName());
        labelMediumPoints.setText(Long.toString(record.getScore()/1000));
        saveGameRecords();
    }

    private void recordHardUpdated(RecordTable record) {
        labelHardName.setText(record.getName());
        labelHardPoints.setText(Long.toString(record.getScore()/1000));
        saveGameRecords();
    }

    private void saveGameRecords() {
        ObjectOutputStream oos = null;
        try {
            File f = new File(System.getProperty("user.home") + File.separator + ".minesfinder.records");
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(recordEasy);
            oos.writeObject(recordMedium);
            oos.writeObject(recordHard);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    private void readGameRecords() {
        ObjectInputStream ois = null;
        File f = new File(System.getProperty("user.home") + File.separator + ".minesfinder.records");
        if (f.canRead()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(f));
                recordEasy = (RecordTable) ois.readObject();
                recordMedium = (RecordTable) ois.readObject();
                recordHard = (RecordTable) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
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

        panelTitle = new javax.swing.JLabel();
        panelRecords = new javax.swing.JPanel();
        Records = new javax.swing.JLabel();
        labelEasy = new javax.swing.JLabel();
        labelEasyName = new javax.swing.JLabel();
        labelEasyPoints = new javax.swing.JLabel();
        labelMedium = new javax.swing.JLabel();
        labelMediumName = new javax.swing.JLabel();
        labelMediumPoints = new javax.swing.JLabel();
        labelHard = new javax.swing.JLabel();
        labelHardName = new javax.swing.JLabel();
        labelHardPoints = new javax.swing.JLabel();
        panelBtns = new javax.swing.JPanel();
        btnEasy = new javax.swing.JButton();
        btnMedium = new javax.swing.JButton();
        btnHard = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MinesFinder");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(600, 450));
        setResizable(false);

        panelTitle.setBackground(new java.awt.Color(136, 135, 217));
        panelTitle.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        panelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelTitle.setText("Minesfinder");
        panelTitle.setOpaque(true);
        getContentPane().add(panelTitle, java.awt.BorderLayout.PAGE_START);

        panelRecords.setBackground(new java.awt.Color(118, 206, 108));

        Records.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        Records.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Records.setText("Records");

        labelEasy.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        labelEasy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEasy.setText("Easy");

        labelEasyName.setText("Player");

        labelEasyPoints.setText("9999");

        labelMedium.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        labelMedium.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMedium.setText("Medium");

        labelMediumName.setText("Player");

        labelMediumPoints.setText("9999");

        labelHard.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        labelHard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHard.setText("Hard");

        labelHardName.setText("Player");

        labelHardPoints.setText("9999");

        javax.swing.GroupLayout panelRecordsLayout = new javax.swing.GroupLayout(panelRecords);
        panelRecords.setLayout(panelRecordsLayout);
        panelRecordsLayout.setHorizontalGroup(
            panelRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelEasy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Records, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRecordsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRecordsLayout.createSequentialGroup()
                        .addComponent(labelEasyName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelEasyPoints))
                    .addComponent(labelMedium, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRecordsLayout.createSequentialGroup()
                        .addComponent(labelMediumName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelMediumPoints))
                    .addComponent(labelHard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRecordsLayout.createSequentialGroup()
                        .addComponent(labelHardName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelHardPoints)))
                .addContainerGap())
        );
        panelRecordsLayout.setVerticalGroup(
            panelRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRecordsLayout.createSequentialGroup()
                .addComponent(Records)
                .addGap(18, 18, 18)
                .addComponent(labelEasy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEasyPoints)
                    .addComponent(labelEasyName))
                .addGap(18, 18, 18)
                .addComponent(labelMedium)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMediumPoints)
                    .addComponent(labelMediumName))
                .addGap(18, 18, 18)
                .addComponent(labelHard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelHardPoints)
                    .addComponent(labelHardName))
                .addGap(0, 169, Short.MAX_VALUE))
        );

        getContentPane().add(panelRecords, java.awt.BorderLayout.LINE_START);

        panelBtns.setLayout(new java.awt.GridLayout(2, 0));

        btnEasy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/technic/apps/minesfinder/resources/easy.png"))); // NOI18N
        btnEasy.setText("Easy");
        btnEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEasyActionPerformed(evt);
            }
        });
        panelBtns.add(btnEasy);

        btnMedium.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/technic/apps/minesfinder/resources/medium.png"))); // NOI18N
        btnMedium.setText("Medium");
        btnMedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMediumActionPerformed(evt);
            }
        });
        panelBtns.add(btnMedium);

        btnHard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/technic/apps/minesfinder/resources/hard.png"))); // NOI18N
        btnHard.setText("Hard");
        btnHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHardActionPerformed(evt);
            }
        });
        panelBtns.add(btnHard);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        panelBtns.add(btnExit);

        getContentPane().add(panelBtns, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEasyActionPerformed
        GameWindow gameWindow = new GameWindow(new Minefield(9, 9, 10), recordEasy);
        gameWindow.setVisible(true);
    }//GEN-LAST:event_btnEasyActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnMediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMediumActionPerformed
        GameWindow gameWindow = new GameWindow(new Minefield(16, 16, 40), recordMedium);
        gameWindow.setVisible(true);
    }//GEN-LAST:event_btnMediumActionPerformed

    private void btnHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHardActionPerformed
        GameWindow gameWindow = new GameWindow(new Minefield(16, 30, 90), recordHard);
        gameWindow.setVisible(true);
    }//GEN-LAST:event_btnHardActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MinesFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinesFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinesFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinesFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MinesFinder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Records;
    private javax.swing.JButton btnEasy;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHard;
    private javax.swing.JButton btnMedium;
    private javax.swing.JLabel labelEasy;
    private javax.swing.JLabel labelEasyName;
    private javax.swing.JLabel labelEasyPoints;
    private javax.swing.JLabel labelHard;
    private javax.swing.JLabel labelHardName;
    private javax.swing.JLabel labelHardPoints;
    private javax.swing.JLabel labelMedium;
    private javax.swing.JLabel labelMediumName;
    private javax.swing.JLabel labelMediumPoints;
    private javax.swing.JPanel panelBtns;
    private javax.swing.JPanel panelRecords;
    private javax.swing.JLabel panelTitle;
    // End of variables declaration//GEN-END:variables
}
