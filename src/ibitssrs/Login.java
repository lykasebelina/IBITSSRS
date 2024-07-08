package ibitssrs;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.*;



public class Login implements ActionListener{
    
    private JFrame loginFrame;
    private ImageIcon loginBG, pupBG, ibitsLogo, logoIBITS;
    private Image profileIconSize, background, schoolBG, logoSize, hdrBGSize;
    private ImageIcon profileIcon, logoProfileIcon, loginBckgrnd, pupBckgrnd, headerBG, hdrBG;
    private JLabel profileIconLabel, hrdBGLbl, loginBGLabel, pupBGLabel, logoLabel, lblTitle1, lblTitle2, welcomeLbl, loginLbl, idLabel, nameLabel, pwordLabel, registerLabel, registrationLink;
    private JPanel loginPanel, schoolBGPanel, logoPanel;
    private JTextField idField, nameField;
    private JPasswordField pwordField;
    private LineBorder fieldBorder;
    private JCheckBox showPword;
    private JButton loginButton;

    
    Connection conn;
    String dbUrl = "jdbc:mysql://localhost:3306/db_cite";
    String dbUser = "root";
    String dbPassword ="";
    
    Login(){
        loginFrame = new JFrame();
        loginFrame.setTitle("IBITS-SRS Login Page");
        loginFrame.setSize(1200, 720);
        loginFrame.setLayout(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        loginPanel= new JPanel();
        loginPanel.setBounds(0,0,1200,720);
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setLayout(null); 
        
        ibitsLogo = new ImageIcon("ImageFolder/logoIBITS.png");
        logoSize = ibitsLogo.getImage().getScaledInstance(180,180 , Image.SCALE_SMOOTH);
        logoIBITS = new ImageIcon(logoSize);
        logoLabel = new JLabel(logoIBITS);
        logoLabel.setBounds(-10, -10, 180, 180);
        
        loginPanel.add(logoLabel);
        
        profileIcon = new ImageIcon("ImageFolder/profileIcon.jpg");
        profileIconSize =profileIcon.getImage().getScaledInstance(90,80 , Image.SCALE_SMOOTH);
        logoProfileIcon = new ImageIcon(profileIconSize);
        profileIconLabel = new JLabel(logoProfileIcon);
        profileIconLabel.setBounds(225, 260, 90, 80);
        
        loginPanel.add(profileIconLabel);
       
        
        
        
        
        
        
        lblTitle1 = new JLabel("IBITS");
        lblTitle1.setBounds(145, 30, 200, 30);
        lblTitle1.setForeground(Color.WHITE);
        lblTitle1.setFont(new Font("Arial", Font.BOLD, 30));
        loginPanel.add(lblTitle1);

        lblTitle2 = new JLabel("STUDENT RECORD SYSTEM");
        lblTitle2.setBounds(153, 50, 500, 40);
        lblTitle2.setForeground(Color.WHITE);
        lblTitle2.setFont(new Font("Arial", Font.BOLD, 20));
        loginPanel.add(lblTitle2);
        
        
        
        
        
        welcomeLbl = new JLabel("WELCOME KA-IBITS!");
        welcomeLbl.setBounds(140, 190, 600, 30);
        welcomeLbl.setForeground(new Color(0, 74, 173));
        welcomeLbl.setFont(new Font("Arial", Font.BOLD, 25));
        loginPanel.add(welcomeLbl);
        
        loginLbl = new JLabel("Login To Your Account");
        loginLbl.setBounds(185, 220, 500, 30);
        loginLbl.setForeground(new Color(0, 74, 173));
        loginLbl.setFont(new Font("Arial", Font.PLAIN, 17));
        loginPanel.add(loginLbl);
        
        fieldBorder = new LineBorder((new Color(0, 74, 173)), 2);
        
        

        
        nameLabel = new JLabel("  Student ID  ");
        nameLabel.setOpaque(true); 
        nameLabel.setBackground(Color.WHITE); 
        nameLabel.setForeground(new Color(0, 74, 173)); 
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15)); 
        nameLabel.setBounds(110, 345, 85, 25);
        loginPanel.add(nameLabel);    
        
        nameField = new JTextField();
        nameField.setBorder(fieldBorder);
        nameField.setOpaque(false); 
        nameField.setForeground(new Color(0, 74, 173)); 
        nameField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        nameField.setBounds(95, 360, 350, 40);
        loginPanel.add(nameField);
        
        
        pwordLabel = new JLabel("  Password  ");
        pwordLabel.setOpaque(true); 
        pwordLabel.setBackground(Color.WHITE); 
        pwordLabel.setForeground(new Color(0, 74, 173)); 
        pwordLabel.setFont(new Font("Arial", Font.PLAIN, 15)); 
        pwordLabel.setBounds(110, 410, 85, 25);
        loginPanel.add(pwordLabel);  
        
        pwordField = new JPasswordField();
        pwordField.setBorder(fieldBorder);
        pwordField.setOpaque(false); 
        pwordField.setForeground(new Color(0, 74, 173)); 
        pwordField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        pwordField.setBounds(95, 425, 350, 40);
        loginPanel.add(pwordField);
        
        
        showPword = new JCheckBox("show password");     
        showPword.setFont(new Font("Arial", Font.PLAIN, 14));
        showPword.setForeground(new Color(0, 74, 173));
        showPword.setBounds(95,473,190,30);
        showPword.addActionListener(this);
        loginPanel.add(showPword);
        
        
        
        
        
        
        loginButton = new JButton("LOGIN"){
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

        
        loginButton.setFocusPainted(false); 
        loginButton.setFont(new Font("Arial", Font.BOLD, 15)); 
        loginButton.setBounds(145, 520, 250, 40); 
        loginButton.setBorderPainted(false); 
        loginButton.setOpaque(false);
        loginButton.addActionListener(this);
        
        loginPanel.add(loginButton);

        
        
        
        
        
        registerLabel = new JLabel("Don't have account?");
        registerLabel.setBounds(155, 565, 300, 25);
        registerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        registerLabel.setForeground(new Color(0, 74, 173));
        loginPanel.add(registerLabel);
        
        registrationLink = new JLabel("Register Here");
        registrationLink.setBounds(290, 565, 300, 25);
        registrationLink.setFont(new Font("Arial", Font.BOLD, 14));
        registrationLink.setForeground(new Color(0, 74, 173));
        registrationLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registrationLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                registrationLink.setForeground(new Color(255, 200, 0));   
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registrationLink.setForeground(new Color(0, 74, 173)); 
                
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                openRegistrationForm(); 
            }
        });
        
        loginPanel.add(registrationLink);
        
          
        
        
        
      
        
      
        pupBG = new ImageIcon("ImageFolder/loginBG.jpeg");
        schoolBG = pupBG.getImage().getScaledInstance(1200,700 , Image.SCALE_SMOOTH);
        pupBckgrnd = new ImageIcon(schoolBG); 
        pupBGLabel = new JLabel(pupBckgrnd);
        schoolBGPanel= new JPanel();
        schoolBGPanel.setBounds(0, -5, 1200, 700);  
        schoolBGPanel.add(pupBGLabel);
        
        loginPanel.add(schoolBGPanel);
        
        loginFrame.add(loginPanel);

        
        loginFrame.setVisible(true);
        
        
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Connected to the database");
        } catch (SQLException ex) {
            System.out.println("Failed to connect to the database");
            ex.printStackTrace();
        }
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == showPword){
            if(showPword.isSelected()) {
            pwordField.setEchoChar((char)0);
        }
            else{
            pwordField.setEchoChar('•');
                    }
        }  
        
        
           else if (e.getSource() == loginButton) {
            String name = nameField.getText();
            String password = new String(pwordField.getPassword());

            if (name.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(loginFrame, "Please enter your both Email and Password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String dbUrl = "jdbc:mysql://localhost:3306/db_cite";
                String dbUser = "root";
                String dbPassword = "";

                try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
                    String query = "SELECT * FROM tbl_cite WHERE last_name = ? AND student_id = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, password);
                    
                    ResultSet result = preparedStatement.executeQuery();
                    
                    if(result.next()){  
                        JOptionPane.showMessageDialog(loginFrame, "Login successful!", "Login", JOptionPane.INFORMATION_MESSAGE);
                        loginFrame.dispose();
                        Registration reg = new Registration();         
                        
                    } else{
                        
                        JOptionPane.showMessageDialog(loginFrame, "Invalid Email or Password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }


                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(loginFrame, "Database connection error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                }
         
        
    
            }
           }
    }
         private void openRegistrationForm() {
           loginFrame.dispose();
           Registration register = new Registration();
          // register.setVisible(true);
      
    }
      
}
    

        
      