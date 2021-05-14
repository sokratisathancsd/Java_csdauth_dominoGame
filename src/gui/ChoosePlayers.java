/**
 * Choose numbers of players gui for hungarian mode and all7
 */
package gui;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
 * This class is the choosePlayers menu for hunarian and all7 mode
 */

/**
 * This class is the choosePlayers menu for hunarian and all7 mode
 * @author Kwnstantinos Perrakis   
 * @author Sokratis Athanasiadis
 * @version 1.1
 * Choose Players GUI for hungarian mode and all7
 */
public class ChoosePlayers extends javax.swing.JFrame {

    /**
     * Creates new form ChoosePlayers
     * @param game if it is an all7 or a hungarian mode game
     */
    
    public ChoosePlayers(int game) {
        this.game=game;
        transparent=new Color(0,0,0,0);
         Toolkit t=Toolkit.getDefaultToolkit();
        Dimension d=t.getScreenSize();
        initComponents();
        int x=((d.width/2-this.getWidth()/2));
        int y=((d.height/2-this.getHeight()/2));
        this.setLocation(x,y);
        setCursor();
    }
    /**
     * It changes the default mouse cursor to a hand cursor for the buttons written in function
     */
     public void setCursor(){
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(transparent);
        jButton1.setFont(new java.awt.Font("Linux Biolinum G", 0, 36)); // NOI18N
        jButton1.setText("Menu");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 150, 50));

        jButton3.setBackground(transparent);
        jButton3.setFont(new java.awt.Font("Linux Biolinum G", 0, 36)); // NOI18N
        jButton3.setText("2 Players");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 210, 50));

        jButton2.setBackground(transparent);
        jButton2.setFont(new java.awt.Font("Linux Biolinum G", 0, 36)); // NOI18N
        jButton2.setText("3 Players");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 210, 50));

        jButton4.setBackground(transparent);
        jButton4.setFont(new java.awt.Font("Linux Biolinum G", 0, 36)); // NOI18N
        jButton4.setText("4 Players");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 210, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/24550212_890657441102492_2110400526_n.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * It performs a normal drag and drop of the window when user wants to
 * @param evt mouse dragged
 */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-x1,y-y1);
    }//GEN-LAST:event_formMouseDragged
/**
 * It takes parameter of mouse, for a new position
 * @param evt mouse pressed
 */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
         x1=evt.getX();
         y1=evt.getY();
    }//GEN-LAST:event_formMousePressed
/**
 * Plays a sound effect and starts the right mode of the game
 * @param evt mouse is clicked
 */
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        playSound("Game Menu Click SOUND Effect.wav");
        if(game==0){
            Hungarian hung=new Hungarian(2);
        }
        else{
            try {
                All7Gui all=new All7Gui(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(ChoosePlayers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked
/**
 * Plays a sound effect and starts the right mode of the game
 * @param evt mouse is clicked
 */
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        playSound("Game Menu Click SOUND Effect.wav");
        if(game==0){
            Hungarian hung=new Hungarian(3);
        }
        else{
            try {
                All7Gui all=new All7Gui(3);
            } catch (InterruptedException ex) {
                Logger.getLogger(ChoosePlayers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked
/**
 * Plays a sound effect and starts the right mode of the game
 * @param evt mouse is clicked
 */
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
       playSound("Game Menu Click SOUND Effect.wav");
        if(game==0){
            Hungarian hung=new Hungarian(4);
        }
        else{
            try {
                All7Gui all=new All7Gui(4);
            } catch (InterruptedException ex) {
                Logger.getLogger(ChoosePlayers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButton4MouseClicked
/**
 * Plays a sound effect and starts a new menu gui
 * @param evt mouse clicked
 */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        playSound("Game Menu Click SOUND Effect.wav");
        GUi G = new GUi();
        G.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked
/**
 * Changes the font when mouse enters the button
 * @param evt mouse enters the button
 */
    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setFont(Font.decode("Linux Biolinum G-bold-36"));
    }//GEN-LAST:event_jButton3MouseEntered
/**
 * Changes the font when mouse enters the button
 * @param evt mouse enters the button
 */
    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setFont(Font.decode("Linux Biolinum G-bold-36"));
    }//GEN-LAST:event_jButton2MouseEntered
/**
 * Changes the font when mouse enters the button
 * @param evt mouse enters the button
 */
    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        jButton4.setFont(Font.decode("Linux Biolinum G-bold-36"));
    }//GEN-LAST:event_jButton4MouseEntered
/**
 * Changes the font when mouse enters the button
 * @param evt mouse enters the button
 */
    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setFont(Font.decode("Linux Biolinum G-bold-36"));
    }//GEN-LAST:event_jButton1MouseEntered
/**
 * Changes the font when mouse exits the button
 * @param evt mouse enters the button
 */
    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
        jButton3.setFont(Font.decode("Linux Biolinum G-plain-36"));
    }//GEN-LAST:event_jButton3MouseExited
/**
 * Changes the font when mouse exits the button
 * @param evt mouse enters the button
 */
    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setFont(Font.decode("Linux Biolinum G-plain-36"));
    }//GEN-LAST:event_jButton2MouseExited
/**
 * Changes the font when mouse exits the button
 * @param evt mouse enters the button
 */
    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        // TODO add your handling code here:
        jButton4.setFont(Font.decode("Linux Biolinum G-plain-36"));
    }//GEN-LAST:event_jButton4MouseExited
/**
 * Changes the font when mouse exits the button
 * @param evt mouse enters the button
 */
    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setFont(Font.decode("Linux Biolinum G-plain-36"));
    }//GEN-LAST:event_jButton1MouseExited

    /**
     * This function starts all the sound effects of this menu
     * @param soundName the file that contains the sound that we want to play
     */
    public void playSound(String soundName)
 {
   try 
   {
   AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
   Clip clip = AudioSystem.getClip( );
   clip.open(audioInputStream);
   clip.start( );
   }
   catch(Exception ex)
   {
     System.out.println("Error with playing sound.");
     ex.printStackTrace( );
   }
 }
 int game;   
private Color transparent;
private int x1,y1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}