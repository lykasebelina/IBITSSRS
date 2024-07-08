
package ibitssrs;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class ViewRecords {
    private JFrame viewRecordsFrame;
    private JPanel viewRecordsPanel, vrBGPanel, searchPanel;
    private ImageIcon vrBG, vrBckgrnd, ibitsLogo, logoIBITS, logoutIcon, iconLogout;
    private JLabel vrBGLabel, logoLabel, lblTitle1, lblTitle2;
    private Image viewrecBG, logoSize, outIcon, resizedLogout;
    private JTable table;
    private JTableHeader tableHeader;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private Color tableBorderColor;
    private JTextField searchBar;
    private JButton searchButton, logoutButton;
    
    
    ViewRecords(){
        viewRecordsFrame = new JFrame();
        viewRecordsFrame.setTitle("IBITS-SRS View Records");
        viewRecordsFrame.setSize(1200, 720);
        viewRecordsFrame.setLayout(null);
        viewRecordsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        viewRecordsPanel= new JPanel();
        viewRecordsPanel.setBounds(0,0,1200,720);
        viewRecordsPanel.setLayout(null); 
        
        
        logoutIcon = new ImageIcon("ImageFolder/logout.jpg");
        outIcon = logoutIcon.getImage();
        resizedLogout = outIcon.getScaledInstance(42, 42, Image.SCALE_SMOOTH); // Resize to 100x100 pixels
        iconLogout = new ImageIcon(resizedLogout );
        
        
        
        logoutButton = new JButton(iconLogout);
        logoutButton.setBorder(null);
        logoutButton.setBounds(1100, 30, 40, 40);
       // searchButton.addActionListener(this);
        viewRecordsPanel.add(logoutButton);
        
        
        ibitsLogo = new ImageIcon("ImageFolder/logoIBITS.png");
        logoSize = ibitsLogo.getImage().getScaledInstance(125,125 , Image.SCALE_SMOOTH);
        logoIBITS = new ImageIcon(logoSize);
        logoLabel = new JLabel(logoIBITS);
        logoLabel.setBounds(-10, -10, 125, 125);
        
        viewRecordsPanel.add(logoLabel);   
        
        
        lblTitle1 = new JLabel("IBITS");
        lblTitle1.setBounds(105, 30, 200, 30);
        lblTitle1.setForeground(Color.WHITE);
        lblTitle1.setFont(new Font("Serif", Font.BOLD, 30));
        viewRecordsPanel.add(lblTitle1);

        lblTitle2 = new JLabel("STUDENT RECORD SYSTEM");
        lblTitle2.setBounds(105, 50, 500, 40);
        lblTitle2.setForeground(Color.WHITE);
        lblTitle2.setFont(new Font("Serif", Font.BOLD, 20));
        viewRecordsPanel.add(lblTitle2);     
        
        
        
                model = new DefaultTableModel(new Object[]{"Student ID", "Last Name", "First Name", "Middle Name", "Birthday", "Address", "Contact #", "Course", "Year", "Position", "Organization"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true; 
            }
        };
                
        
        table = new JTable(model);
        table.setOpaque(false);
        table.setBackground(new Color(245, 245, 220));

        tableHeader = table.getTableHeader();
        tableHeader.setBackground(new Color(0, 74, 173));
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setFont(new Font("Arial", Font.BOLD, 12));

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 160, 1200, 532);

        tableBorderColor = new Color(0, 74, 173);
        scrollPane.setBorder(new LineBorder(tableBorderColor, 8));
        viewRecordsPanel.add(scrollPane);
        
        
        
        searchBar = new JTextField(20);
        searchBar.setBounds(50,120,300,30);
        searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBackground(new Color(0, 74, 173));
        searchPanel.add(searchBar);
        searchPanel.setBounds(800, 120, 250, 30);
        viewRecordsPanel.add(searchPanel);
        
        searchButton = new JButton("SEARCH");
        searchButton.setFont(new Font("Arial", Font.BOLD, 13));
        searchButton.setForeground(Color.WHITE);
        searchButton.setBackground(new Color(0, 74, 173));
        searchButton.setOpaque(true);
        searchButton.setBorder(null);
        searchButton.setBounds(1070, 120, 95, 30);
       // searchButton.addActionListener(this);
        viewRecordsPanel.add(searchButton);
        
        
        
        
        
        
        
        vrBG = new ImageIcon("ImageFolder/viewrecBG.png");
        viewrecBG = vrBG.getImage().getScaledInstance(1200,700 , Image.SCALE_SMOOTH);
        vrBckgrnd = new ImageIcon(viewrecBG); 
        vrBGLabel = new JLabel(vrBckgrnd);
        vrBGPanel= new JPanel();
        vrBGPanel.setBounds(0, -5, 1200, 700);  
        vrBGPanel.add(vrBGLabel);
        viewRecordsPanel.add(vrBGPanel);
        
        
        
        
        
        viewRecordsFrame.add(viewRecordsPanel);
        viewRecordsFrame.setVisible(true);
        
    }
    
      public static void main (String []args){
        
            ViewRecords login = new ViewRecords();       
        }
}
