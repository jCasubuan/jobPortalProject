/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobportalproject.accountSetup;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class accountSetup extends JFrame implements ActionListener {
    private JPanel cards, panelAccountSetup, panelNext;
    private CardLayout cardLayout;
    private JTextField txtCity, txtPostalCode, txtFirstName, txtLastName;
    private JPopupMenu cityPopup;
    private LagunaSearch citySearch;
    private JLabel hdrBasics, lblInfo, lblCity, lblPostalCode, lblRequired, lblCopy, lblPage, lblHeaderPage2, lblInfoPage2, lblFirstName, lblLastName;
    private JButton btnContinue, btnBack;

    public accountSetup() {
        setTitle("Account Setup");
        setSize(1500, 780);
        //setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        cityPopup = new JPopupMenu();
        cityPopup.setFocusable(false); // Prevent popup from taking focus
        cityPopup.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
            // Add window focus listener to the frame
    addWindowFocusListener(new WindowAdapter() {
        @Override
        public void windowLostFocus(WindowEvent e) {
            cityPopup.setVisible(false);
        }
    });
    
          // Add a click listener to hide popup when clicking outside
    addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (cityPopup.isVisible()) {
                cityPopup.setVisible(false);
            }
        }
    });
        
        // Initialize CardLayout
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // Initialize City Search
        citySearch = new LagunaSearch();

        // Create Panels
        panelAccountSetup = createAccountSetupPanel();
        panelNext = createNextPanel();

        // Add Panels to CardLayout
        cards.add(panelAccountSetup, "AccountSetup");
        cards.add(panelNext, "Next");

        // Add Cards to JFrame
        add(cards);
        setVisible(true);
    }

    private JPanel createAccountSetupPanel() {
        JPanel panel = new JPanel(null);

        // Header
        hdrBasics = new JLabel("Let's start with the basics. Where are you located?");
        hdrBasics.setFont(new Font("Arial", Font.PLAIN, 28));
        hdrBasics.setBounds(380, 75, 650, 35);
        hdrBasics.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(hdrBasics);
        
        lblInfo = new JLabel("We use this to match you with jobs nearby.");
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 17));
        lblInfo.setForeground(Color.GRAY);
        lblInfo.setBounds(390, 120, 350, 20);
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblInfo);

        // City Input
        lblCity = new JLabel("City, State*");
        lblCity.setFont(new Font("Arial", Font.BOLD, 18));
        lblCity.setBounds(390, 170, 125, 20);
        lblCity.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblCity);

        txtCity = new JTextField();
        txtCity.setBounds(400, 200, 310, 55);
        txtCity.setFont(new Font("Arial", Font.PLAIN, 16));
        txtCity.setBorder(BorderFactory.createCompoundBorder(
                txtCity.getBorder(),
                new EmptyBorder(13, 5, 2, 5)
        ));
        panel.add(txtCity);
        
        lblRequired = new JLabel("*Required");
        lblRequired.setFont(new Font("Arial", Font.PLAIN, 12));
        lblRequired.setBounds(400, 265, 60, 15);
        panel.add(lblRequired);
        
        
        
        // Add Popup Menu for City Suggestions
        cityPopup = new JPopupMenu();
        cityPopup.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        txtCity.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> updateCitySuggestions());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> updateCitySuggestions());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> updateCitySuggestions());
            }
        });
        
            cityPopup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtCity.requestFocusInWindow();
            }
        });
        
            txtCity.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                Timer timer = new Timer(150, evt -> {
            cityPopup.setVisible(false);
            cityPopup.removeAll();
        });
        timer.setRepeats(false);
        timer.start();
    }
});
                
        txtCity.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            if (cityPopup.isVisible()) {
            cityPopup.setVisible(false);
            cityPopup.removeAll();
        }
    }
});

        panel.add(txtCity);    
        
 
        // Postal Code Input
        lblPostalCode = new JLabel("Postal Code");
        lblPostalCode.setFont(new Font("Arial", Font.BOLD, 18));
        lblPostalCode.setBounds(730, 170, 125, 20);
        lblPostalCode.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblPostalCode);

        txtPostalCode = new JTextField();
        txtPostalCode.setBounds(740, 200, 230, 55);
        txtPostalCode.setFont(new Font("Arial", Font.PLAIN, 16));
        txtPostalCode.setBorder(BorderFactory.createCompoundBorder(
                txtPostalCode.getBorder(),
                new EmptyBorder(13, 5, 2, 5)
        ));
        panel.add(txtPostalCode);

        // Buttons
        btnContinue = new JButton("Continue");
        btnContinue.setBorder(new LineBorder(new Color(0, 119, 212), 2, true));
        btnContinue.setBackground(new Color(0, 119, 212));
        btnContinue.setForeground(Color.white);
        btnContinue.setFont(new Font("Arial", Font.BOLD, 16));
        btnContinue.setBounds(900, 350, 100, 50);
        btnContinue.setBorderPainted(false);
        btnContinue.setFocusPainted(false);
        btnContinue.setOpaque(true);
        panel.add(btnContinue);

        btnBack = new JButton("Back");
        btnBack.setBackground(Color.WHITE);
        btnBack.setForeground(new Color(0, 119, 212));
        btnBack.setFont(new Font("Arial", Font.BOLD, 12));
        btnBack.setBounds(400, 370, 80, 30);
        btnBack.setFocusPainted(false);
        panel.add(btnBack);
        
        lblPage = new JLabel("page 1 of 3");
        lblPage.setFont(new Font("Arial", Font.PLAIN, 12));
        lblPage.setBounds(630, 380, 90, 15);
        lblPage.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblPage);
        
        lblCopy = new JLabel("©2025 JobVista - Cookies, Privacy and Terms");
        lblCopy.setFont(new Font("Arial", Font.PLAIN, 12));
        lblCopy.setBounds(580, 500, 260, 12);
        panel.add(lblCopy);
        
        btnContinue.addActionListener(this);
        btnBack.addActionListener(this);
        
        return panel;
    }

    private JPanel createNextPanel() {
        JPanel panel = new JPanel(null);
        
        lblHeaderPage2 = new JLabel("Next step, you need to setup your Profile.");
        lblHeaderPage2.setFont(new Font("Arial", Font.PLAIN, 25));
        lblHeaderPage2.setBounds(490, 50, 470, 35);
        lblHeaderPage2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblHeaderPage2);
        
        lblInfoPage2 = new JLabel("We use these information to know you more.");
        lblInfoPage2.setFont(new Font("Arial", Font.PLAIN, 17));
        lblInfoPage2.setForeground(Color.GRAY);
        lblInfoPage2.setBounds(500, 90, 350, 20);
        lblInfoPage2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblInfoPage2);
        
        JPanel pnlPage2SetUp = new JPanel();
        pnlPage2SetUp.setBounds(120, 150, 1260, 550);
        pnlPage2SetUp.setBorder(new LineBorder(Color.GRAY, 1));
        pnlPage2SetUp.setLayout(null);
        panel.add(pnlPage2SetUp);
        
        lblLastName = new JLabel("Last Name*");
        lblLastName.setFont(new Font("Arial", Font.PLAIN, 15));
        lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
        lblLastName.setBounds(30, 10, 90, 10);
        pnlPage2SetUp.add(lblLastName);
        
        txtLastName = new JTextField();
        txtLastName.setBounds(35, 30, 200, 35);
        txtLastName.setFont(new Font("Arial", Font.PLAIN, 15));
        txtLastName.setBorder(BorderFactory.createCompoundBorder(
                txtLastName.getBorder(),
                new EmptyBorder(13, 5, 2, 5)
        ));
        pnlPage2SetUp.add(txtLastName);
        
        lblFirstName = new JLabel("First Name*");
        lblFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
        lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
        lblFirstName.setBounds(280, 10, 90, 10);
        pnlPage2SetUp.add(lblFirstName);
        
        txtFirstName = new JTextField();
        txtFirstName.setBounds(280, 30, 200, 35);
        txtFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
        txtFirstName.setBorder(BorderFactory.createCompoundBorder(
                txtFirstName.getBorder(),
                new EmptyBorder(13, 5, 2, 5)
        ));
        pnlPage2SetUp.add(txtFirstName);
        
        

        return panel;
    }

    private void updateCitySuggestions() {
    try {
        String input = txtCity.getText().trim().toLowerCase();

        if (input.isEmpty()) {
            cityPopup.setVisible(false);
            cityPopup.removeAll(); // Ensure popup is cleared
            return;
        }

        List<String> suggestions = citySearch.searchCities(input);
        cityPopup.removeAll(); // Clear existing items

        if (!suggestions.isEmpty()) {
            for (String city : suggestions) {
                if (city.toLowerCase().startsWith(input)) {
                    JMenuItem item = new JMenuItem(city);
                    item.setFont(new Font("Arial", Font.PLAIN, 14));
                    item.setBackground(Color.WHITE);

                    item.addActionListener(e -> {
                        txtCity.setText(city);
                        cityPopup.setVisible(false);
                        cityPopup.removeAll(); // Clear popup immediately after selection
                        txtCity.requestFocusInWindow(); // Maintain focus on text field
                        // Force popup to dispose
                        SwingUtilities.invokeLater(() -> {
                            cityPopup.setVisible(false);
                            cityPopup.removeAll();
                        });
                    });

                    cityPopup.add(item);
                }
            }

            if (cityPopup.getComponentCount() > 0 && txtCity.isShowing()) {
                Point p = txtCity.getLocationOnScreen();
                cityPopup.pack();
                cityPopup.setLocation(p.x, p.y + txtCity.getHeight());
                if (!txtCity.getText().isEmpty()) {
                    cityPopup.setVisible(true);
                }
            } else {
                cityPopup.setVisible(false);
                cityPopup.removeAll();
            }
        } else {
            cityPopup.setVisible(false);
            cityPopup.removeAll();
        }
    } catch (IllegalComponentStateException ex) {
        cityPopup.setVisible(false);
        cityPopup.removeAll();
    }
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Continue")) {
            
            String city = txtCity.getText().trim();
            if (city.isEmpty()){
                JOptionPane.showMessageDialog(this, "City, State is required!", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(!citySearch.searchCities(city).contains(city)){
                JOptionPane.showMessageDialog(
                        this, 
                        "\"" +city+ "\" cannot be found!\n Please try again.", 
                        "Error", 
                        JOptionPane.WARNING_MESSAGE);
            }
            else {
                cardLayout.show(cards, "Next");  
            }
            
        } 
        else if (e.getSource() == btnBack){
            new firstTimeInterface().setVisible(true);
            dispose();
        }
        
    }

    // Laguna City Search Implementation
    class LagunaSearch {
        private List<String> cities;

        public LagunaSearch() {
            cities = new ArrayList<>();
            initializeLagunaCities();
        }

        private void initializeLagunaCities() {
            cities.addAll(Arrays.asList(
                "Alaminos", "Bay", "Biñan City", "Cabuyao City", "Calamba City", 
                "Calauan", "Cavinti", "Famy", "Kalayaan", "Liliw",
                "Los Baños", "Luisiana", "Lumban", "Mabitac", "Magdalena", 
                "Majayjay", "Nagcarlan", "Paete", "Pagsanjan", "Pakil", 
                "Pangil", "Pila", "Rizal", "San Pablo City", "San Pedro City", 
                "Santa Rosa City", "Siniloan", "Victoria"
            ));
        }

        public List<String> searchCities(String prefix) {
            final String searchPrefix = prefix.toLowerCase();  // Create a final variable
            
            return cities.stream()
            .filter(city -> city.toLowerCase().startsWith(searchPrefix))  // Use the final variable
            .collect(Collectors.toList());
        
        }

    }
}


/*
Alaminos
bay
binan
cabuyao
calamba
calauan
Cavinti
Famy
Kalayaan 
Liliw
Los Banos
Luisiana
Lumban
Mabitac
Magdalena
Majayjay
nagcarlan
paete
pagsanjan
pakil
pangil
pila
rizal
san pablo
san pedro
santa cruz
santa maria
santa rosa
siniloan 
victoria

*/
