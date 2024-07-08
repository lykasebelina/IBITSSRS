package ibitssrs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;



public class Registration implements ActionListener{
    
    private JFrame registrationFrame;
    private ImageIcon regBG,ibitsBckgrnd, formBG, regBckgrnd;
    private Image ibitsBG, regFormBG;
    private JLabel profileIconLabel, ibitsBGLabel, regLbl, loginLbl, regBGLabel, loginLink, firstnameLabel,midnameLabel, 
            lastnameLabel, bdayLabel,addressLabel,contactLabel, studIDLabel, courseLabel, yearrLvlLabel, positionLabel,
            orgLabel, pwordLabel;
    private JPanel registrationPanel, logoPanel,ibitsBGPanel, regBGPanel;
    private JTextField firstnameField,midnameField, lastnameField,bdayField,addressField, contactField, studIDField, courseField,
            yearrLvlField, positionField, orgField, pwordField;
    
    private JComboBox<String> yearlvlComboBox;
  //  private JPasswordField ;
    private LineBorder fieldBorder;
  //  private JCheckBox ;
    private JButton regButton;

    
    Registration(){
        registrationFrame = new JFrame();
        registrationFrame.setTitle("IBITS-SRS Registration Form");
        registrationFrame.setSize(1200, 720);
        registrationFrame.setLayout(null);
        registrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  
        
        registrationPanel= new JPanel();
        registrationPanel.setBounds(0,0,1200,720);
        registrationPanel.setBackground(Color.WHITE);
        registrationPanel.setLayout(null); 
        
        
        
        
         
        regLbl = new JLabel("REGISTRATION");
        regLbl.setBounds(730, 45, 600, 30);
        regLbl.setForeground(new Color(0, 74, 173));
        regLbl.setFont(new Font("Arial", Font.BOLD, 35));
        registrationPanel.add(regLbl);
        
        
        
        loginLbl = new JLabel("Already Registered?");
        loginLbl.setBounds(755, 80, 500, 30);
        loginLbl.setFont(new Font("Arial", Font.PLAIN, 14));
        loginLbl.setForeground(new Color(0, 74, 173));
        registrationPanel.add(loginLbl);  
        
        loginLink = new JLabel("Login Here");
        loginLink.setBounds(888, 80, 500, 30);
        loginLink.setFont(new Font("Arial", Font.BOLD, 14));
        loginLink.setForeground(new Color(0, 74, 173));
        loginLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginLink.setForeground(new Color(255, 200, 0));   
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginLink.setForeground(new Color(0, 74, 173)); 
                
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                openLoginPage(); 
            }
        });
        
        registrationPanel.add(loginLink);
        
        
        
        fieldBorder = new LineBorder(new Color(0, 74, 173), 1);
        
       // fieldBorder = new LineBorder((new Color(173, 216, 230)), 1);
   //     
        firstnameLabel = new JLabel("  First Name  ");
        firstnameLabel.setForeground(new Color(0, 74, 173)); 
        firstnameLabel.setFont(new Font("Arial", Font.PLAIN, 12)); 
        firstnameLabel.setBounds(580, 155, 100, 25);
        registrationPanel.add(firstnameLabel);    
        
        firstnameField = new JTextField();
        firstnameField.setBorder(fieldBorder);
        firstnameField.setBackground(Color.WHITE); 
        firstnameField.setOpaque(true); 
        firstnameField.setForeground(new Color(0, 74, 173)); 
        firstnameField.setFont(new Font("Arial", Font.PLAIN, 12)); 
        firstnameField.setBounds(585, 180, 260, 35);
        registrationPanel.add(firstnameField);
        
        //     
        midnameLabel = new JLabel("  Middle Name  ");
        midnameLabel.setForeground(new Color(0, 74, 173)); 
        midnameLabel.setFont(new Font("Arial", Font.PLAIN, 12)); 
        midnameLabel.setBounds(580, 225, 100, 25);
        registrationPanel.add(midnameLabel);    
        
        midnameField = new JTextField();
        midnameField.setBorder(fieldBorder);
        midnameField.setBackground(Color.WHITE); 
        midnameField.setOpaque(true); 
        midnameField.setForeground(new Color(0, 74, 173)); 
        midnameField.setFont(new Font("Arial", Font.PLAIN, 12)); 
        midnameField.setBounds(585, 250, 260, 35);
        registrationPanel.add(midnameField);  
        
        
   //     
        lastnameLabel = new JLabel("  Last Name  ");
        lastnameLabel.setForeground(new Color(0, 74, 173)); 
        lastnameLabel.setFont(new Font("Arial", Font.PLAIN, 12)); 
        lastnameLabel.setBounds(580, 295, 100, 25);
        registrationPanel.add(lastnameLabel);    
        
        lastnameField = new JTextField();
        lastnameField.setBorder(fieldBorder);
        lastnameField.setBackground(Color.WHITE); 
        lastnameField.setOpaque(true); 
        lastnameField.setForeground(new Color(0, 74, 173)); 
        lastnameField.setFont(new Font("Arial", Font.PLAIN, 12)); 
        lastnameField.setBounds(585, 320, 260, 35);
        registrationPanel.add(lastnameField);  
        
//     
        bdayLabel = new JLabel("  Birthday  ");
        bdayLabel.setForeground(new Color(0, 74, 173)); 
        bdayLabel.setFont(new Font("Arial", Font.PLAIN, 12)); 
        bdayLabel.setBounds(580, 365, 100, 25);
        registrationPanel.add(bdayLabel);    
        
        bdayField = new JTextField("YYYY-MM-DD");
        bdayField.setBorder(fieldBorder);
        bdayField.setBackground(Color.WHITE); 
        bdayField.setOpaque(true); 
        bdayField.setForeground(new Color(191, 191, 191)); 
        bdayField.setFont(new Font("Arial", Font.PLAIN, 12)); 
        bdayField.setBounds(585, 390, 260, 35);
        
         bdayField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (bdayField.getText().equals("YYYY-MM-DD")) {
                    bdayField.setText("");
                    bdayField.setForeground(new Color(0, 74, 173));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (bdayField.getText().isEmpty()) {
                    bdayField.setText("YYYY-MM-DD");
                    bdayField.setForeground(new Color(191, 191, 191));
                }
            }
        });
        
        registrationPanel.add(bdayField);  
        
        
     //     
        addressLabel = new JLabel("  Address  ");
        addressLabel.setForeground(new Color(0, 74, 173)); 
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 12)); 
        addressLabel.setBounds(580, 435, 150, 25);
        registrationPanel.add(addressLabel);    
        
        addressField = new JTextField();
        addressField.setBorder(fieldBorder);
        addressField.setBackground(Color.WHITE); 
        addressField.setOpaque(true); 
        addressField.setForeground(new Color(0, 74, 173)); 
        addressField.setFont(new Font("Arial", Font.PLAIN, 12)); 
        addressField.setBounds(585, 460, 260, 35);
        registrationPanel.add(addressField);   
        
     //     
        contactLabel = new JLabel("  Contact Number  ");
        contactLabel.setForeground(new Color(0, 74, 173)); 
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 12)); 
        contactLabel.setBounds(580, 505, 150, 25);
        registrationPanel.add(contactLabel);    
        
        contactField = new JTextField();
        contactField.setBorder(fieldBorder);
        contactField.setBackground(Color.WHITE); 
        contactField.setOpaque(true); 
        contactField.setForeground(new Color(0, 74, 173)); 
        contactField.setFont(new Font("Arial", Font.PLAIN, 12)); 
        contactField.setBounds(585, 530, 260, 35);
        registrationPanel.add(contactField);     
        
        
        
  // //     
        studIDLabel = new JLabel("  Student ID  ");
        studIDLabel.setForeground(new Color(0, 74, 173)); 
        studIDLabel.setFont(new Font("Arial", Font.PLAIN, 12)); 
        studIDLabel.setBounds(885, 155, 150, 25);
        registrationPanel.add(studIDLabel);    
        
        studIDField = new JTextField();
        studIDField.setBorder(fieldBorder);
        studIDField.setBackground(Color.WHITE); 
        studIDField.setOpaque(true); 
        studIDField.setForeground(new Color(0, 74, 173)); 
        studIDField.setFont(new Font("Arial", Font.PLAIN, 12)); 
        studIDField.setBounds(890, 180, 260, 35);
        registrationPanel.add(studIDField);
        
        
  // //     
        courseLabel = new JLabel("  Course  ");
        courseLabel.setForeground(new Color(0, 74, 173)); 
        courseLabel.setFont(new Font("Arial", Font.PLAIN, 12)); 
        courseLabel.setBounds(885, 225, 150, 25);
        registrationPanel.add(courseLabel);    
        
        courseField = new JTextField();
        courseField.setBorder(fieldBorder);
        courseField.setBackground(Color.WHITE); 
        courseField.setOpaque(true); 
        courseField.setForeground(new Color(0, 74, 173)); 
        courseField.setFont(new Font("Arial", Font.PLAIN, 12)); 
        courseField.setBounds(890, 250, 260, 35);
        registrationPanel.add(courseField);    
      
  // //     
        yearrLvlLabel = new JLabel("  Year Level  ");
        yearrLvlLabel.setForeground(new Color(0, 74, 173)); 
        yearrLvlLabel.setFont(new Font("Arial", Font.PLAIN, 12)); 
        yearrLvlLabel.setBounds(885, 295, 150, 25);
        registrationPanel.add(yearrLvlLabel);    
        
       
        
        yearrLvlField = new JTextField();
        yearrLvlField.setBorder(fieldBorder);
        yearrLvlField.setBackground(Color.WHITE); 
        yearrLvlField.setOpaque(true); 
        yearrLvlField.setForeground(new Color(0, 74, 173)); 
        yearrLvlField.setFont(new Font("Arial", Font.PLAIN, 12)); 
        yearrLvlField.setBounds(890, 320, 260, 35);
        registrationPanel.add(yearrLvlField); 
       
   

                
        
   // //     
        positionLabel = new JLabel("  Position ");
        positionLabel.setForeground(new Color(0, 74, 173)); 
        positionLabel.setFont(new Font("Arial", Font.PLAIN, 12)); 
        positionLabel.setBounds(885, 365, 150, 25);
        registrationPanel.add(positionLabel);    
        
        positionField = new JTextField();
        positionField.setBorder(fieldBorder);
        positionField.setBackground(Color.WHITE); 
        positionField.setOpaque(true); 
        positionField.setForeground(new Color(0, 74, 173)); 
        positionField.setFont(new Font("Arial", Font.PLAIN, 12)); 
        positionField.setBounds(890, 390, 260, 35);
        registrationPanel.add(positionField);         
     
// //     
        orgLabel = new JLabel("  Organization ");
        orgLabel.setForeground(new Color(0, 74, 173)); 
        orgLabel.setFont(new Font("Arial", Font.PLAIN, 12)); 
        orgLabel.setBounds(885, 435, 150, 25);
        registrationPanel.add(orgLabel);    
        
        orgField = new JTextField();
        orgField.setBorder(fieldBorder);
        orgField.setBackground(Color.WHITE); 
        orgField.setOpaque(true); 
        orgField.setForeground(new Color(0, 74, 173)); 
        orgField.setFont(new Font("Arial", Font.PLAIN, 12)); 
        orgField.setBounds(890, 460, 260, 35);
        registrationPanel.add(orgField);     
        
        
        
// //     
        pwordLabel = new JLabel("  Create Password ");
        pwordLabel.setForeground(new Color(0, 74, 173)); 
        pwordLabel.setFont(new Font("Arial", Font.PLAIN, 12)); 
        pwordLabel.setBounds(885, 505, 150, 25);
        registrationPanel.add(pwordLabel);    
        
        pwordField = new JTextField();
        pwordField.setBorder(fieldBorder);
        pwordField.setBackground(Color.WHITE); 
        pwordField.setOpaque(true); 
        pwordField.setForeground(new Color(0, 74, 173)); 
        pwordField.setFont(new Font("Arial", Font.PLAIN, 12)); 
        pwordField.setBounds(890, 530, 260, 35);
        registrationPanel.add(pwordField);        
        
        
        
        
        
        
        regButton = new JButton("REGISTER"){
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(new Color(255, 200, 0)); 
                    setForeground(new Color(0, 74, 173));
                } else {
                    g.setColor(new Color(0, 74, 173));
                    setForeground(Color.WHITE);
                }
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10); 
                super.paintComponent(g);
            }
            
        };

        regButton.setFocusPainted(false); 
        regButton.setFont(new Font("Arial", Font.BOLD, 15)); 
        regButton.setBounds(948, 603, 200, 40); 
        regButton.setBorderPainted(false); 
        regButton.setOpaque(false);
      //  regButton.addActionListener(this);
        
        registrationPanel.add(regButton);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        formBG = new ImageIcon("ImageFolder/regBG.jpg");
        regFormBG = formBG.getImage().getScaledInstance(670,700 , Image.SCALE_SMOOTH);
        regBckgrnd = new ImageIcon(regFormBG); 
        regBGLabel = new JLabel(regBckgrnd);
        
        regBGPanel= new JPanel();
        regBGPanel.setBounds(535, -5, 670, 700);  
        regBGPanel.add(regBGLabel);
        registrationPanel.add(regBGPanel);
        
        
        

      
        regBG = new ImageIcon("ImageFolder/registrationBG.png");
        ibitsBG = regBG.getImage().getScaledInstance(1200,700 , Image.SCALE_SMOOTH);
        ibitsBckgrnd = new ImageIcon(ibitsBG); 
        ibitsBGLabel = new JLabel(ibitsBckgrnd);
        
        ibitsBGPanel= new JPanel();
        ibitsBGPanel.setBounds(0, -5, 1200, 700);  
        ibitsBGPanel.add(ibitsBGLabel);
        registrationPanel.add(ibitsBGPanel);
        
        registrationFrame.add(registrationPanel);
        registrationFrame.setVisible(true);
  
    }

       public static void main (String []args){
        
            Registration login = new Registration();       
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
         private void openLoginPage() {
           registrationFrame.dispose();
           Login login = new Login();
          // register.setVisible(true);
      
    }
}
    

        
      