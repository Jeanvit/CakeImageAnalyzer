package cake.screens;

import cake.components.ImageViewer;
import cake.components.SimplePanel;
import cake.utils.ImageUtils;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Jean Vitor de Paulo Class to manipulate the main screen and its
 * behaviours
 */
public class MainScreen extends javax.swing.JFrame implements PropertyChangeListener {

    BufferedImage blueImage;
    BufferedImage greenImage;
    BufferedImage redImage;
    BufferedImage image;
    panelStatus statusGreen = panelStatus.NOTCHANGED;
    panelStatus statusRed = panelStatus.NOTCHANGED;
    panelStatus statusBlue = panelStatus.NOTCHANGED;
    panelStatus statusAlpha = panelStatus.NOTCHANGED;
    public final int maxValue = 256;
    private Rectangle currentRect;
    File file;
    private boolean isInitalized = false;

    public MainScreen() {
        initComponents();
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/cake.png"));
        setIconImage(image);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
     * @param mainPanel
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        lblFileName = new javax.swing.JLabel();
        lbl8bit = new javax.swing.JLabel();
        lblRed = new javax.swing.JLabel();
        lblGreen = new javax.swing.JLabel();
        lblBlue = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlMain = new javax.swing.JPanel();
        pnlRed = new javax.swing.JPanel();
        pnlGreen = new javax.swing.JPanel();
        pnlBlue = new javax.swing.JPanel();
        lblChannels = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        menGeneral = new javax.swing.JMenuBar();
        menOpen = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menExit = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 151, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 129, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cake Image Analyzer");
        setName("mainFrame"); // NOI18N

        lblFileName.setText("File: None");

        lbl8bit.setText("Original Image:");

        lblRed.setText("Red Channel:");

        lblGreen.setText("Green Channel:");

        lblBlue.setText("Blue Channel:");

        pnlMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMainMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlRed.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlRed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRedMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlRedLayout = new javax.swing.GroupLayout(pnlRed);
        pnlRed.setLayout(pnlRedLayout);
        pnlRedLayout.setHorizontalGroup(
            pnlRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlRedLayout.setVerticalGroup(
            pnlRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );

        pnlGreen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlGreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlGreenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlGreenLayout = new javax.swing.GroupLayout(pnlGreen);
        pnlGreen.setLayout(pnlGreenLayout);
        pnlGreenLayout.setHorizontalGroup(
            pnlGreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );
        pnlGreenLayout.setVerticalGroup(
            pnlGreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        pnlBlue.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlBlue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBlueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBlueLayout = new javax.swing.GroupLayout(pnlBlue);
        pnlBlue.setLayout(pnlBlueLayout);
        pnlBlueLayout.setHorizontalGroup(
            pnlBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlBlueLayout.setVerticalGroup(
            pnlBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );

        lblChannels.setText("RGB Channels");

        lblTitle.setText("Entropy values");

        menOpen.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, 0));
        jMenuItem1.setText("Open Image");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menOpen.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, 0));
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menOpen.add(jMenuItem3);

        menGeneral.add(menOpen);

        menExit.setText("About");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, 0));
        jMenuItem2.setText("About Cake Image Analyzer");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menExit.add(jMenuItem2);

        menGeneral.add(menExit);

        setJMenuBar(menGeneral);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pnlGreen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnlBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnlRed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblChannels)
                                .addGap(84, 84, 84))))))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(lbl8bit)
                .addGap(116, 116, 116)
                .addComponent(lblRed)
                .addGap(126, 126, 126)
                .addComponent(lblGreen)
                .addGap(112, 112, 112)
                .addComponent(lblBlue)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(457, 457, 457))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblChannels, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitle)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGreen)
                    .addComponent(lblRed)
                    .addComponent(lbl8bit)
                    .addComponent(lblBlue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(lblFileName))
        );

        lblFileName.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            try {
                loadImages();
                updatePanels(image, blueImage, redImage, greenImage);
                this.isInitalized = true;
                //lblAlpha.setText("Alpha Channel: " + df.format(ImageUtils.getEntropy(alphaImage, maxValue)));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error!", JOptionPane.ERROR_MESSAGE);

            }
        }
        //addcomponent function
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        String infoMessage = "       Developed by Jean Vitor de Paulo\n"
                + "                www.jeanvitor.com       \n"
                + "             Version 1.1, 25/02/2022   \n\n\n"
                + "              Support this project on: \n"
                + "     www.buymeacoffee.com/jeanvitor\n";
        JOptionPane.showMessageDialog(null, infoMessage, "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    private void pnlRedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRedMouseClicked
        if (!this.isInitalized) {
            return;
        }
        try {
            if (statusGreen == panelStatus.NOTCHANGED) {
                updatePanels(greenImage, blueImage, redImage, image);
                statusGreen = panelStatus.CHANGED;
            } else {
                updatePanels(image, blueImage, redImage, greenImage);
                statusGreen = panelStatus.NOTCHANGED;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pnlRedMouseClicked
    private void pnlGreenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGreenMouseClicked
        if (!this.isInitalized) {
            return;
        }
        try {
            if (statusBlue == panelStatus.NOTCHANGED) {
                updatePanels(blueImage, image, redImage, greenImage);
                statusBlue = panelStatus.CHANGED;
            } else {
                updatePanels(image, blueImage, redImage, greenImage);
                statusBlue = panelStatus.NOTCHANGED;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pnlGreenMouseClicked
    private void pnlBlueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBlueMouseClicked
        if (!this.isInitalized) {
            return;
        }
        try {
            if (statusRed == panelStatus.NOTCHANGED) {
                updatePanels(redImage, blueImage, image, greenImage);
                statusRed = panelStatus.CHANGED;
            } else {
                updatePanels(image, blueImage, redImage, greenImage);
                statusRed = panelStatus.NOTCHANGED;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pnlBlueMouseClicked

    /**
     * Called when a mouse action happens on the main panel Do nothing if an
     * image is on loaded, open the file selection otherwise
     *
     * @param evt the mouse event
     */
    private void pnlMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseClicked
        if (this.isInitalized) {
            return;
        }
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            try {
                loadImages();
                updatePanels(image, blueImage, redImage, greenImage);
                this.isInitalized = true;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_pnlMainMouseClicked

    /**
     * Loads the main image, and do the operations to find the other ones
     * (RED,GREEN,BLUE)
     *
     * @throws IOException
     */
    private void loadImages() throws IOException {
        try {
            image = ImageIO.read(file);
            blueImage = ImageUtils.getBlue(image);
            //alphaImage=ImageUtils.getAlpha(image);
            redImage = ImageUtils.getRed(image);
            greenImage = ImageUtils.getGreen(image);
            currentRect = new Rectangle(0, 0, image.getWidth(), image.getHeight());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File not supported!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Update the main screen JPanels. This method is used to change the Images
     * between the JPanels
     *
     * @param BufferedImage "swap*" - The image that will be added to its
     * JPanel, accordingly to the color
     */
    private void updatePanels(BufferedImage swapOriginal, BufferedImage swapBlue, BufferedImage swapRed, BufferedImage swapGreen) throws IOException {
        JPanel mainPanel, greenPanel, redPanel, bluePanel;//, alphaPanel;
        pnlMain.removeAll();
        pnlRed.removeAll();
        pnlBlue.removeAll();
        pnlGreen.removeAll();
        //pnlAlpha.removeAll();
        mainPanel = new ImageViewer(swapOriginal, pnlMain);
        mainPanel.addPropertyChangeListener(this);
        bluePanel = new SimplePanel(swapBlue, pnlGreen);
        greenPanel = new SimplePanel(swapGreen, pnlRed);
        redPanel = new SimplePanel(swapRed, pnlBlue);
        //alphaPanel = new SimplePanel(swapAlpha,pnlAlpha);
        this.getContentPane().add(mainPanel);
        mainPanel.setBounds(1, 1, super.getWidth(), super.getHeight());
        redPanel.setBounds(1, 1, super.getWidth(), super.getHeight());
        greenPanel.setBounds(1, 1, super.getWidth(), super.getHeight());
        bluePanel.setBounds(1, 1, super.getWidth(), super.getHeight());
        //alphaPanel.setBounds(1, 1, super.getWidth(), super.getHeight());
        pnlMain.add(mainPanel);
        pnlRed.add(greenPanel);
        pnlBlue.add(redPanel);
        pnlGreen.add(bluePanel);
        //pnlAlpha.add(alphaPanel);

        this.revalidate();
        this.repaint();

        lblFileName.setText("File: " + file.getAbsolutePath());
        this.setLabelText();
        lblTitle.setText("Entropy values");
    }

    /**
     * Set the text that indicates the entropy values The value computation is
     * also done here, based on the selected region Case nothing is selected,
     * the entire image is considered
     */
    private void setLabelText() {
        lbl8bit.setText(this.getEntropyForLabel("Original Image: ", image.getSubimage(currentRect.x, currentRect.y, currentRect.width, currentRect.height)));
        lblRed.setText(this.getEntropyForLabel("Red Channel: ", redImage.getSubimage(currentRect.x, currentRect.y, currentRect.width, currentRect.height)));
        lblGreen.setText(this.getEntropyForLabel("Green Channel: ", greenImage.getSubimage(currentRect.x, currentRect.y, currentRect.width, currentRect.height)));
        lblBlue.setText(this.getEntropyForLabel("Blue Channel: ", blueImage.getSubimage(currentRect.x, currentRect.y, currentRect.width, currentRect.height)));
    }

    /**
     * Return the label text that indicates the entropy value of a given image
     *
     * @param text The text to show on the labelk
     * @param image The image to calculate the entropy
     * @return
     */
    private String getEntropyForLabel(String text, BufferedImage image) {
        DecimalFormat df = new DecimalFormat("0.000");
        return text + df.format(ImageUtils.getEntropy(image, maxValue));
    }

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    /**
     * Manage the events received via PropertyChangeListener
     *
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "cancelSelection":
                lblTitle.setText("Entropy values");
                currentRect = new Rectangle(0, 0, image.getWidth(), image.getHeight());
                break;
            case "selected":
                Rectangle rect = (Rectangle) evt.getNewValue();
                currentRect = new Rectangle(0, 0, rect.width, rect.height);
                lblTitle.setText("Entropy values (Selected Region)");
                break;
        }
        this.setLabelText();
    }

    //Panel status to manage the image changed state
    public enum panelStatus {
        CHANGED, NOTCHANGED;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl8bit;
    private javax.swing.JLabel lblBlue;
    private javax.swing.JLabel lblChannels;
    private javax.swing.JLabel lblFileName;
    private javax.swing.JLabel lblGreen;
    private javax.swing.JLabel lblRed;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenu menExit;
    private javax.swing.JMenuBar menGeneral;
    private javax.swing.JMenu menOpen;
    private javax.swing.JPanel pnlBlue;
    private javax.swing.JPanel pnlGreen;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlRed;
    // End of variables declaration//GEN-END:variables

}
