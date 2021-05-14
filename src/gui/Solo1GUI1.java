
package gui;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * Simulates a solo1 gui
 * @author Kwnstantinos Perrakis
 * @author Sokratis Athanasiadis
 * @version 1.1
 * Simulates a solo1 gui
 */
public class Solo1GUI1 extends javax.swing.JFrame {

    /**
     * Creates new form Solo1GUI1
     */
    public Solo1GUI1() {
        TileStack stack=new TileStack();
        stack.shuffledStuck();
        game=new Solo1(stack);
        transparent=new Color(0,0,0,0); 
        initComponents();
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension d=t.getScreenSize();
        this.setExtendedState(this.MAXIMIZED_BOTH); 
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        int x=((d.width/2-this.getWidth()/2));
        int y=((d.height/2-this.getHeight()/2));
        this.setLocation(x,y);
        setCursor();
        this.setVisible(true);
        updatePlayerTiles();
    }
    /**
     * Updates users stack of tile in the gui enviroment
     */
    public void updatePlayerTiles(){
        PlayerTiles1=new ArrayList<>();
        PlayerTiles2=new ArrayList<>();
        PlayerTiles3=new ArrayList<>();
        PlayerTiles4=new ArrayList<>();
        jPanel3.removeAll();
        jPanel4.removeAll();
        jPanel5.removeAll();
        jPanel6.removeAll();
        for (int i=0;i<(game.getRows().size());i++){
            for(int j=0;j<(game.getRows().get(i).size());j++){
                javax.swing.JLabel jLabel12;
            jLabel12 = new javax.swing.JLabel();
            jLabel12.setSize(new Dimension(30,55));
            jLabel12.setOpaque(false);
            jLabel12.setBackground(transparent);
            jLabel12.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
                String file=game.getRows().get(i).get(j).get_side1()+"-"+game.getRows().get(i).get(j).get_side2()+".png";
                ImageIcon icon=new ImageIcon(file);
                jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/"+icon))); // NOI18N
                
                if(i==0){
                    PlayerTiles1.add(jLabel12);
                    jPanel3.add(PlayerTiles1.get(j));
                }
                else if(i==1){
                    PlayerTiles2.add(jLabel12);
                    jPanel4.add(PlayerTiles2.get(j));
                }
                else if(i==2){
                    PlayerTiles3.add(jLabel12);
                    jPanel5.add(PlayerTiles3.get(j));
                }
                else if(i==3){
                    PlayerTiles4.add(jLabel12);
                    jPanel6.add(PlayerTiles4.get(j));
                }
            }
            jPanel3.revalidate();
            jPanel3.repaint();
            jPanel4.revalidate();
            jPanel4.repaint();
            jPanel5.revalidate();
            jPanel5.repaint();
            jPanel6.revalidate();
            jPanel6.repaint();
            
            
            javax.swing.JButton jButton1;
            jButton1 = new javax.swing.JButton();
            jButton1.setSize(new Dimension(30,55));
            jButton1.setOpaque(false);
            jButton1.setBackground(transparent);
            jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }
    /**
     * Update table tiles in the gui enviroment when a move is performed
     */
    public void updateTableTiles(){
        int size=game.getPlayArea().size();
    TableTiles=new ArrayList<>();
    jPanel2.removeAll();
        for (int i=0;i<size;i++){
            javax.swing.JLabel jLabel1;
            jLabel1 = new javax.swing.JLabel();
            String file;
            if(game.getPlayArea().get(i).get_side1()<=game.getPlayArea().get(i).get_side2()){
             file=game.getPlayArea().get(i).get_side1()+"-"+game.getPlayArea().get(i).get_side2()+".png";
            }
            else{
             file=game.getPlayArea().get(i).get_side1()+"-"+game.getPlayArea().get(i).get_side2()+".png";
            }
            ImageIcon icon=new ImageIcon(file);
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/"+icon))); // NOI18N
            jLabel1.setSize(new Dimension(30,55));
            TableTiles.add(jLabel1);
            jPanel2.add(TableTiles.get(i));
        }
        jPanel2.revalidate();
        jPanel2.repaint();
    }
    /**
     * Simulates all moves that a player is made, by calling the right functions and methods
     * @param Row is the row/pannel that player performs a click
     */
    public void playerPlay(int Row){
        row=Row;
        ArrayList<Integer> position=new ArrayList<>();
        int round=2;
        if(game.getPlayArea().isEmpty()){
           round=1;
           position.add(row);
           position.add(0);
           position.add(0);
            game.moves(position, round);
            updateTableTiles();
            updatePlayerTiles();
            if(game.checkAvailableMoves(game.checkEmptyLines())==false){
                playSound("The Price is Right Losing Horn - Gaming Sound Effect (HD).wav");
                JOptionPane.showMessageDialog(this,"You lost...");
            }
        }
        else{
             
            position.add(row);
            
                if(game.getRows().get(row).get(game.getRows().get(row).size()-1).get_side1()==game.getPlayArea().get(0).get_side1()){
                    position.add(1);
                    position.add(0);
                }
                else if(game.getRows().get(row).get(game.getRows().get(row).size()-1).get_side2()==game.getPlayArea().get(0).get_side1()){
                    position.add(0);
                    position.add(0);
                }
                else if(game.getRows().get(row).get(game.getRows().get(row).size()-1).get_side1()==game.getPlayArea().get(game.getPlayArea().size()-1).get_side2()){
                    position.add(0);
                    position.add(1);
                }
                else if(game.getRows().get(row).get(game.getRows().get(row).size()-1).get_side2()==game.getPlayArea().get(game.getPlayArea().size()-1).get_side2()){
                    position.add(1);
                    position.add(1);
                }
                else{
                    return;
                }
            
            game.moves(position, round);
            int count=game.checkEmptyLines();
            
            
            updateTableTiles();
            updatePlayerTiles();
            if(count==0){
                playSound("Short_triumphal_fanfare-John_Stracke-815794903.wav");
                JOptionPane.showMessageDialog(this,"You won!!!");
                this.dispose();
            }
           if(game.checkAvailableMoves(count)==false){
                playSound("The Price is Right Losing Horn - Gaming Sound Effect (HD).wav");
                JOptionPane.showMessageDialog(this,"You lost...");
                this.dispose();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Solo1");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Player's", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 153, 255))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setOpaque(false);
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setOpaque(false);
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setOpaque(false);
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 153, 204))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 63, 1370, 480);

        jButton1.setBackground(transparent);
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/home button.png"))); // NOI18N
        jButton1.setOpaque(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 0, 51, 53);

        jButton2.setBackground(transparent);
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/restart.png"))); // NOI18N
        jButton2.setOpaque(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(99, 0, 51, 53);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/table.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1530, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * Plays a sound effect when player clicks in the panel, and gets the number of the panel 0-3 for the right tile to be played
 * @param evt mouse clicked
 */
    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
       if (!game.getRows().get(0).isEmpty()){
        playSound("Click2-Sebastian-759472264.wav");
        row=0;
        playerPlay(row);
       }
    }//GEN-LAST:event_jPanel3MouseClicked
/**
 * Plays a sound effect when player clicks in the panel, and gets the number of the panel 0-3 for the right tile to be played
 * @param evt mouse clicked
 */
    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
       if (!game.getRows().get(1).isEmpty()){
        playSound("Click2-Sebastian-759472264.wav");
        row=1;
        playerPlay(row);   
       }
    }//GEN-LAST:event_jPanel4MouseClicked
/**
 * Plays a sound effect when player clicks in the panel, and gets the number of the panel 0-3 for the right tile to be played
 * @param evt mouse clicked
 */
    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        if (!game.getRows().get(2).isEmpty()){
        playSound("Click2-Sebastian-759472264.wav");
        row=2;
        playerPlay(row);
        }                
    }//GEN-LAST:event_jPanel5MouseClicked
/**
 * Plays a sound effect when player clicks in the panel, and gets the number of the panel 0-3 for the right tile to be played
 * @param evt mouse clicked
 */
    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        if (!game.getRows().get(3).isEmpty()){
        playSound("Click2-Sebastian-759472264.wav");
        row=3;
        playerPlay(row);   
        }
    }//GEN-LAST:event_jPanel6MouseClicked
/**
 * plays a sound effect, and returns to menu gui
 * @param evt mouse lcicked
 */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        playSound("Game Menu Click SOUND Effect.wav"); 
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked
/**
 * restarts solo1 mode, and plays a sound effect
 * @param evt mouse clicked
 */
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        playSound("Game Menu Click SOUND Effect.wav"); 
        TileStack gameStack=new TileStack();
        gameStack.shuffledStuck();
        game.restart(gameStack);
        updateTableTiles();
        updatePlayerTiles();
        
    }//GEN-LAST:event_jButton2MouseClicked
/**
 * Appear a joptionpanel with info of what the button does
 * @param evt mouse entered button area
 */
    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setToolTipText("restart game");
    }//GEN-LAST:event_jButton2MouseEntered
/**
 * Appear a joptionpanel with info of what the button does
 * @param evt mouse entered button area
 */
    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setToolTipText("return to menu");
    }//GEN-LAST:event_jButton1MouseEntered
/**
 * This method closes the program and opens menu
 * @param evt the command
 */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GUi menu= new GUi();
        menu.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    
    private int row;
    private Color transparent;
    private Solo1 game;
    private ArrayList<JLabel> PlayerTiles1;
    private ArrayList<JLabel> PlayerTiles2;
    private ArrayList<JLabel> PlayerTiles3;
    private ArrayList<JLabel> PlayerTiles4;
    private ArrayList<JLabel> TableTiles;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
    /**
     * Changes the cursor from a simple mouse cursor, to a hand cursor
     */
    private void setCursor() {
      jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
      jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
     /**
     * This function starts all the sound effects of this menu.
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

}
