package view;

import controller.ImageFinder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import model.GameData;

public class InventoryPanel extends JPanel
{
//    private final JPanel lifePanel, ammoPanel, keyPanel;
//    private final JLabel ammoImage, amountOfAmmo, amountOfKeys;
    private JLabel lblChipsLeft, lblLevel, lblTime, lblBoots, lblKeys;
    private JTextField txtChipsLeft;
    private JTextField txtLevel;
    private JTextField txtTime;
    private JPanel bootPanel;
    private JLabel lblIceBoot;
    private JLabel lblFireBoot;
    private JLabel lblSuctionBoot;
    private JLabel lblFlipperBoot;
    private JPanel keyPanel;
    private JLabel lblBlueKey;
    private JLabel lblRedKey;
    private JLabel lblYellowKey;
    private JLabel lblGreenKey;
    
    public static int pwidth, pheight;
    
    public InventoryPanel(int pwidth, int pheight)
    {
        InventoryPanel.pwidth = pwidth;
        InventoryPanel.pheight = pheight;
        
        initComponents();
    }
    
    public void updateInventoryPanel()
    {
        this.txtTime.setText(String.valueOf(GameData.time));
        this.txtLevel.setText(String.valueOf(GameData.level));
        this.txtChipsLeft.setText(String.valueOf(GameData.chipsLeft));
    }
    
    private void initComponents(){
        setPreferredSize(new Dimension(InventoryPanel.pwidth, InventoryPanel.pheight));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 20));
        
        // Level label and text field
        lblLevel = new JLabel("LEVEL");
        lblLevel.setFont(new Font("Tahoma", 0, 36)); // NOI18N
        lblLevel.setForeground(new Color(255, 0, 0));
        
        txtLevel = new JTextField(String.valueOf(GameData.level));
        txtLevel.setFont(new Font("Tahoma", 0, 36));
        txtLevel.setHorizontalAlignment(JTextField.CENTER);
        txtLevel.setEditable(false);
        
        // Time label and text field
        lblTime = new JLabel("TIME (s)");
        lblTime.setFont(new Font("Tahoma", 0, 36)); // NOI18N
        lblTime.setForeground(new Color(255, 0, 0));
        lblTime.setText("TIME (s)");
        
        txtTime = new JTextField(String.valueOf(GameData.time));
        txtTime.setFont(new Font("Tahoma", 0, 36));
        txtTime.setHorizontalAlignment(JTextField.CENTER);
        txtTime.setEditable(false);

        
        lblChipsLeft = new JLabel("CHIPS LEFT");
        lblChipsLeft.setFont(new Font("Tahoma", 0, 36)); // NOI18N
        lblChipsLeft.setForeground(new Color(255, 0, 0));
        
        txtChipsLeft = new JTextField(String.valueOf(GameData.chipsLeft));
        txtChipsLeft.setText(String.valueOf(GameData.chipsLeft));
        txtChipsLeft.setFont(new Font("Tahoma", 0, 36));
        txtChipsLeft.setHorizontalAlignment(JTextField.CENTER);
        txtChipsLeft.setEditable(false);

        // Boots label
        lblBoots = new JLabel("BOOTS");
        lblBoots.setFont(new Font("Tahoma", 0, 36));
        lblBoots.setForeground(new Color(255, 0, 0));
        
        //Boot panel
        bootPanel = new JPanel(new GridLayout(1, 4));
        
        lblIceBoot = new JLabel();
        lblIceBoot.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        lblFireBoot = new JLabel();
        lblFireBoot.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        lblSuctionBoot = new JLabel();
        lblSuctionBoot.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        lblFlipperBoot = new JLabel();
        lblFlipperBoot.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        bootPanel.add(lblIceBoot);
        bootPanel.add(lblFireBoot);
        bootPanel.add(lblSuctionBoot);
        bootPanel.add(lblFlipperBoot);
        
        // Keys label
        lblKeys = new JLabel("KEYS");
        lblKeys.setFont(new Font("Tahoma", 0, 36));
        lblKeys.setForeground(new Color(255, 0, 0));
        
        //Key panel
        keyPanel = new JPanel(new GridLayout(1, 4));
        
        lblBlueKey = new JLabel(new ImageIcon());
        lblBlueKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        lblRedKey = new JLabel(new ImageIcon());
        lblRedKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        lblYellowKey = new JLabel(new ImageIcon());
        lblYellowKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        lblGreenKey = new JLabel(new ImageIcon());
        lblGreenKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        keyPanel.add(lblBlueKey);
        keyPanel.add(lblRedKey);
        keyPanel.add(lblYellowKey);
        keyPanel.add(lblGreenKey);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblTime, GroupLayout.Alignment.LEADING)
                            .addComponent(txtTime, GroupLayout.Alignment.LEADING)
                            .addComponent(lblLevel, GroupLayout.Alignment.LEADING)
                            .addComponent(txtLevel, GroupLayout.Alignment.LEADING)
                            .addComponent(lblChipsLeft, GroupLayout.Alignment.LEADING)
                            .addComponent(txtChipsLeft, GroupLayout.Alignment.LEADING)
                            .addComponent(lblBoots, GroupLayout.Alignment.LEADING)
                            .addComponent(bootPanel, GroupLayout.Alignment.LEADING)
                            .addComponent(lblKeys, GroupLayout.Alignment.LEADING)
                            .addComponent(keyPanel, GroupLayout.Alignment.LEADING))))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblLevel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLevel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTime)
                .addComponent(txtTime, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChipsLeft)
                .addComponent(txtChipsLeft, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblBoots)
                .addComponent(bootPanel)
                .addComponent(lblKeys)
                .addComponent(keyPanel)
                .addContainerGap(166, Short.MAX_VALUE))
        );
    }
    
//    @Override
//    public void paintComponent(Graphics g)
//    {
//        super.paintComponent(g);
//        Graphics2D graphics = (Graphics2D)g;
//        
//        this.paintComponents(graphics);
//        this.repaint();
//    }

    private String ImageFinder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
