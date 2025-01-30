/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobportalproject.accountSetup;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.YearMonth;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class accountSetup extends JFrame implements ActionListener {
    private JPanel cards, panelAccountSetup, panelNext, panelLastPage;
    private CardLayout cardLayout;
    private JTextField txtCity, txtPostalCode, txtFirstName, txtLastName, txtMiddlename, txtSuffix, txtContactNum, txtEmail, txtCitizenship, txtDesiredJobs;
    private JPopupMenu cityPopup;
    private PhilippineCitySearch citySearch;
    private JLabel hdrBasics, lblInfo, lblCity, lblPostalCode, lblRequired, lblCopy, lblPage, lblHeaderPage2, lblInfoPage2, lblFirstName;
    private JLabel lblLastName, lblMiddleName, lblSuffix, lblContact, lblRequiredPage2, lblPlusContact, lblEmail, lblGender, lblBirthDate;
    private JLabel lblCitizenship, lblStatus, lblPage2, lblHeaderPage3, lblInfoPage3, lblDesiredJobs, lblPlaceHolderDesiredJobs, lblRequiredPage3;
    private JButton btnContinue, btnBack, btnBackPage2, btnContinuePage2, btnSubmit;
    private String[] genders = {"Choose your gender", "Male", "Female", "Others", "Prefer not to say"};
    private Integer[] birthYear = {0, 2025, 2024, 2023, 2022, 2021, 2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008,
                                2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990,
                                1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982, 1981, 1980, 1979, 1978, 1977, 1976, 1975, 1974, 1973, 1972,
                                1971, 1970, 1969, 1968, 1967, 1966, 1965, 1964, 1963, 1962, 1961, 1960, 1959, 1958, 1957, 1956, 1955, 1954,
                                1953, 1952, 1951, 1950, 1949, 1948, 1947, 1946, 1945, 1944, 1943, 1942, 1941, 1940, 1939, 1938, 1937, 1936,
                                1935, 1934, 1933, 1932, 1931, 1930, 1929, 1928, 1927, 1926, 1925, 1924, 1923, 1922, 1921, 1920, 1919, 1918,
                                1917, 1916, 1915, 1914, 1913, 1912, 1911, 1910, 1909, 1908, 1907, 1906, 1905, 1904, 1903, 1902, 1901, 1900};
    private String[] birthMonth = {"Months", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private String[] status = {"Choose your Status", "Single", "Married", "Widowed", "Separated", "Divorced", "Prefer not to disclose"};
    private JComboBox<String> jcbGender, jcbBirthMonth, jcbStatus;
    private JComboBox<Integer> jcbBirthYear, jcbBirthDay;
    
    
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
        citySearch = new PhilippineCitySearch();

        // Create Panels
        panelAccountSetup = createAccountSetupPanel();
        panelNext = createNextPanel();
        panelLastPage = createLastPanel();
        

        // Add Panels to CardLayout
        cards.add(panelAccountSetup, "AccountSetup");
        cards.add(panelNext, "Next");
        cards.add(panelLastPage, "Last");

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
        lblInfo.setBounds(385, 120, 350, 20);
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
        
        lblRequired = new JLabel("*Required field");
        lblRequired.setFont(new Font("Arial", Font.BOLD, 12));
        lblRequired.setBounds(400, 265, 120, 15);
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
        
        // Next page panel
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
        lblInfoPage2.setBounds(495, 90, 350, 20);
        lblInfoPage2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblInfoPage2);
        
        lblRequiredPage2 = new JLabel("*Required fields");
        lblRequiredPage2.setBounds(325, 115, 120, 35);
        lblRequiredPage2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblRequiredPage2);
        
        JPanel pnlPage2SetUp = new JPanel();
        pnlPage2SetUp.setBounds(340, 190, 830, 500);
        //pnlPage2SetUp.setBorder(new LineBorder(Color.GRAY, 1));
        pnlPage2SetUp.setLayout(null);
        panel.add(pnlPage2SetUp);
        
        lblLastName = new JLabel("Last Name*");
        lblLastName.setFont(new Font("Arial", Font.PLAIN, 15));
        lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
        lblLastName.setBounds(5, 10, 90, 10);
        pnlPage2SetUp.add(lblLastName);
        
        txtLastName = new JTextField();
        txtLastName.setBounds(10, 40, 200, 35);
        txtLastName.setFont(new Font("Arial", Font.PLAIN, 15));
        txtLastName.setBorder(BorderFactory.createCompoundBorder(
                txtLastName.getBorder(),
                new EmptyBorder(13, 5, 2, 5)
        ));
        pnlPage2SetUp.add(txtLastName);
        
        lblFirstName = new JLabel("First Name*");
        lblFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
        lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
        lblFirstName.setBounds(240, 10, 90, 10);
        pnlPage2SetUp.add(lblFirstName);
        
        txtFirstName = new JTextField();
        txtFirstName.setBounds(240, 40, 200, 35);
        txtFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
        txtFirstName.setBorder(BorderFactory.createCompoundBorder(
                txtFirstName.getBorder(),
                new EmptyBorder(13, 5, 2, 5)
        ));
        pnlPage2SetUp.add(txtFirstName);
        
        lblMiddleName = new JLabel("Middle Name (Optional)");
        lblMiddleName.setFont(new Font("Arial", Font.PLAIN, 15));
        lblMiddleName.setHorizontalAlignment(SwingConstants.CENTER);
        lblMiddleName.setBounds(475, 5, 170, 20);
        pnlPage2SetUp.add(lblMiddleName);
        
        txtMiddlename = new JTextField();
        txtMiddlename.setBounds(470, 40, 200, 35);
        txtMiddlename.setFont(new Font("Arial", Font.PLAIN, 15));
        txtMiddlename.setBorder(BorderFactory.createCompoundBorder(
                txtMiddlename.getBorder(),
                new EmptyBorder(13, 5, 2, 5)
        ));
        pnlPage2SetUp.add(txtMiddlename);
        
        lblSuffix = new JLabel("Suffix (e.g., jr., III)");
        lblSuffix.setFont(new Font("Arial", Font.PLAIN, 15));
        lblSuffix.setHorizontalAlignment(SwingConstants.CENTER);
        lblSuffix.setBounds(655, 5, 190, 20);
        pnlPage2SetUp.add(lblSuffix);
        
        txtSuffix = new JTextField();
        txtSuffix.setBounds(720, 40, 80, 35);
        txtSuffix.setFont(new Font("Arial", Font.PLAIN, 15));
        txtSuffix.setBorder(BorderFactory.createCompoundBorder(
                txtSuffix.getBorder(),
                new EmptyBorder(13, 5, 2, 5)
        ));
        pnlPage2SetUp.add(txtSuffix);
        
        lblContact = new JLabel("Contact No.*");
        lblContact.setFont(new Font("Arial", Font.PLAIN, 15));
        //lblContact.setHorizontalAlignment(SwingConstants.CENTER);
        lblContact.setBounds(12, 115, 180, 20);
        pnlPage2SetUp.add(lblContact);
        
        lblPlusContact = new JLabel("(+63)");
        lblPlusContact.setFont(new Font("Arial", Font.PLAIN, 15));
        //lblPlusContact.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlusContact.setBounds(12, 161, 50, 20);
        pnlPage2SetUp.add(lblPlusContact);
        
        txtContactNum = new JTextField();
        txtContactNum.setBounds(52, 150, 160, 35);
        txtContactNum.setFont(new Font("Arial", Font.PLAIN, 15));
        txtContactNum.setBorder(BorderFactory.createCompoundBorder(
                txtContactNum.getBorder(),
                new EmptyBorder(10, 3, 2, 5)
        ));
        
        
        txtContactNum.addKeyListener(new KeyAdapter() {
            public void keyReleased (KeyEvent e) {
                String input  = txtContactNum.getText();
                
                if (!input.isEmpty()){
                    String formatted = accountSetup.formatPhoneNumber(input);
                    
                    if (!input.equals(formatted)){
                        txtContactNum.setText(formatted);
                        
                        txtContactNum.setCaretPosition(formatted.length());
                    }
                }
            }
        });
        
        pnlPage2SetUp.add(txtContactNum);
        
        lblEmail = new JLabel("Email Address*");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 15));
        lblEmail.setBounds(265, 115, 160, 20);
        pnlPage2SetUp.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 13));
        txtEmail.setBounds(260, 150, 320, 35);
        txtEmail.setBorder(BorderFactory.createCompoundBorder(
                txtEmail.getBorder(),
                new EmptyBorder(13, 2, 2, 9)
        ));
        pnlPage2SetUp.add(txtEmail);
        
        lblGender = new JLabel("Gender*");
        lblGender.setFont(new Font("Arial", Font.PLAIN, 15));
        lblGender.setBounds(630, 115, 70, 20);
        pnlPage2SetUp.add(lblGender);
        
        jcbGender = new JComboBox<>(genders);
        jcbGender.setBounds(630, 148, 148, 35);
        pnlPage2SetUp.add(jcbGender);
        
        
        lblBirthDate = new JLabel("Date of Birth*");
        lblBirthDate.setFont(new Font("Arial", Font.PLAIN, 15));
        lblBirthDate.setBounds(12, 230, 140, 35);
        pnlPage2SetUp.add(lblBirthDate);
        
        jcbBirthMonth = new JComboBox<>(birthMonth);
        jcbBirthMonth.setBounds(12, 275, 90, 30);
        pnlPage2SetUp.add(jcbBirthMonth);
        
        jcbBirthDay= new JComboBox<>();
        jcbBirthDay.addItem(0);
        jcbBirthDay.setBounds(120, 275, 45, 30);
        pnlPage2SetUp.add(jcbBirthDay);
        
        jcbBirthYear = new JComboBox<>(birthYear);
        jcbBirthYear.setBounds(180, 275, 60, 30);
        pnlPage2SetUp.add(jcbBirthYear);
        
        lblCitizenship = new JLabel("Citizenship*");
        lblCitizenship.setBounds(335, 230, 140, 35);
        lblCitizenship.setFont(new Font("Arial", Font.PLAIN, 15));
        pnlPage2SetUp.add(lblCitizenship);
        
        txtCitizenship = new JTextField();
        txtCitizenship.setFont(new Font("Arial", Font.PLAIN, 15));
        txtCitizenship.setBounds(330, 270, 160, 35);
        txtCitizenship.setBorder(BorderFactory.createCompoundBorder(
                txtCitizenship.getBorder(),
                new EmptyBorder(10, 3, 2, 5)
        ));
        pnlPage2SetUp.add(txtCitizenship);
        
        lblStatus = new JLabel("Status*");
        lblStatus.setFont(new Font("Arial", Font.PLAIN, 15));
        lblStatus.setBounds(580, 230, 100, 35);
        pnlPage2SetUp.add(lblStatus);
        
        jcbStatus = new JComboBox<>(status);
        jcbStatus.setBounds(580, 270, 150, 35);
        pnlPage2SetUp.add(jcbStatus);
        
        btnBackPage2 = new JButton("Back");
        btnBackPage2.setBackground(Color.WHITE);
        btnBackPage2.setForeground(new Color(0, 119, 212));
        btnBackPage2.setFont(new Font("Arial", Font.BOLD, 12));
        btnBackPage2.setBounds(15, 400, 80, 30);
        btnBackPage2.setFocusPainted(false);
        pnlPage2SetUp.add(btnBackPage2);
               
        lblPage2 = new JLabel("page 2 of 3 ");
        lblPage2.setFont(new Font("Arial", Font.PLAIN, 12));
        lblPage2.setBounds(320, 430, 90, 15);
        lblPage2.setHorizontalAlignment(SwingConstants.CENTER);
        pnlPage2SetUp.add(lblPage2);
        
        btnContinuePage2 = new JButton("Continue ");
        btnContinuePage2.setBorder(new LineBorder(new Color(0, 119, 212), 2, true));
        btnContinuePage2.setBackground(new Color(0, 119, 212));
        btnContinuePage2.setForeground(Color.white);
        btnContinuePage2.setFont(new Font("Arial", Font.BOLD, 16));
        btnContinuePage2.setBounds(670, 380, 100, 50);
        btnContinuePage2.setBorderPainted(false);
        btnContinuePage2.setFocusPainted(false);
        btnContinuePage2.setOpaque(true);
        pnlPage2SetUp.add(btnContinuePage2);
        
        jcbBirthMonth.addActionListener(e -> updateDays());
        jcbBirthYear.addActionListener(e -> updateDays());
        
        
        btnBackPage2.addActionListener(this);
        btnContinuePage2.addActionListener(this);
        
        
        return panel;
    }
    
    private JPanel createLastPanel(){
        JPanel panel = new JPanel(null);
        
        lblHeaderPage3 = new JLabel("What job are you looking for?");
        lblHeaderPage3.setFont(new Font("Arial", Font.PLAIN, 30));
        lblHeaderPage3.setBounds(460, 50, 475, 35);
        lblHeaderPage3.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblHeaderPage3);
        
        lblInfoPage3 = new JLabel("You can always change this later.");
        lblInfoPage3.setFont(new Font("Arial", Font.PLAIN, 17));
        lblInfoPage3.setForeground(Color.GRAY);
        lblInfoPage3.setBounds(455, 90, 350, 20);
        lblInfoPage3.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblInfoPage3);
        
        lblDesiredJobs = new JLabel("Desired job titles* ");
        lblDesiredJobs.setFont(new Font("Arial", Font.BOLD, 15));
        //lblDesiredJobs.setForeground(Color.GRAY);
        lblDesiredJobs.setBounds(505, 190, 350, 20);
        //lblDesiredJobs.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblDesiredJobs);
        
        lblPlaceHolderDesiredJobs = new JLabel("e.g. Cashier, Nurse, Driver");
        lblPlaceHolderDesiredJobs.setFont(new Font("Arial", Font.PLAIN, 18));
        lblPlaceHolderDesiredJobs.setForeground(Color.GRAY);
        lblPlaceHolderDesiredJobs.setBounds(510, 235, 250, 33); // Adjusted Y position
        panel.add(lblPlaceHolderDesiredJobs);

        txtDesiredJobs = new JTextField();
        txtDesiredJobs.setBounds(505, 225, 420, 55); // Move text field slightly lower
        txtDesiredJobs.setFont(new Font("Arial", Font.PLAIN, 16));
        txtDesiredJobs.setBorder(BorderFactory.createCompoundBorder(txtDesiredJobs.getBorder(), new EmptyBorder(10, 5, 2, 5)));
        panel.add(txtDesiredJobs);

        // Add Focus and Document Listener
        txtDesiredJobs.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
        lblPlaceHolderDesiredJobs.setFont(new Font("Arial", Font.PLAIN, 13));
        lblPlaceHolderDesiredJobs.setBounds(510, 223, 250, 25); // Adjusted position for better alignment
    }

        @Override
        public void focusLost(FocusEvent e) {
        if (txtDesiredJobs.getText().trim().isEmpty()) {
            lblPlaceHolderDesiredJobs.setFont(new Font("Arial", Font.PLAIN, 18));
            lblPlaceHolderDesiredJobs.setBounds(510, 235, 250, 33); // Adjusted to avoid overlapping
            }
        }
    });

        // Hide placeholder when user types
        txtDesiredJobs.getDocument().addDocumentListener(new DocumentListener() {
        private void updatePlaceholder() {
        lblPlaceHolderDesiredJobs.setVisible(txtDesiredJobs.getText().trim().isEmpty());
    }

        @Override
        public void insertUpdate(DocumentEvent e) { updatePlaceholder(); }

        @Override
        public void removeUpdate(DocumentEvent e) { updatePlaceholder(); }

        @Override
        public void changedUpdate(DocumentEvent e) { updatePlaceholder(); }
        
});
        
        lblRequiredPage3 = new JLabel("Required*");
        lblRequiredPage3.setBounds(200, 300, 120, 35);
        lblRequiredPage3.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblRequiredPage3);
        
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBorder(new LineBorder(new Color(0, 119, 212), 2, true));
        btnSubmit.setBackground(new Color(0, 119, 212));
        btnSubmit.setForeground(Color.white);
        btnSubmit.setFont(new Font("Arial", Font.BOLD, 16));
        btnSubmit.setBounds(670, 380, 100, 50);
        btnSubmit.setBorderPainted(false);
        btnSubmit.setFocusPainted(false);
        btnSubmit.setOpaque(true);
        panel.add(btnSubmit);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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
            int maxDisplayCount = 6; // Limit to 6 items
            JPanel suggestionPanel = new JPanel();
            suggestionPanel.setLayout(new BoxLayout(suggestionPanel, BoxLayout.Y_AXIS));
            suggestionPanel.setBackground(Color.WHITE);

            for (int i = 0; i < Math.min(suggestions.size(), maxDisplayCount); i++) {
                String city = suggestions.get(i);

                JMenuItem item = new JMenuItem(city);
                item.setFont(new Font("Arial", Font.PLAIN, 14));
                item.setBackground(Color.WHITE);

                item.addActionListener(e -> {
                    txtCity.setText(city);
                    cityPopup.setVisible(false);
                    cityPopup.removeAll(); // Clear popup immediately after selection
                    txtCity.requestFocusInWindow(); // Maintain focus on text field
                    SwingUtilities.invokeLater(() -> {
                        cityPopup.setVisible(false);
                        cityPopup.removeAll();
                    });
                });

                suggestionPanel.add(item);
            }

            // Adjust height dynamically based on the number of items
            int suggestionHeight = Math.min(suggestions.size(), maxDisplayCount) * 25; // Assume each item is ~25px tall
            JScrollPane scrollPane = new JScrollPane(suggestionPanel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setVerticalScrollBarPolicy(
                suggestions.size() > maxDisplayCount ? JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED : JScrollPane.VERTICAL_SCROLLBAR_NEVER
            );
            scrollPane.setPreferredSize(new Dimension(txtCity.getWidth(), suggestionHeight));

            cityPopup.add(scrollPane);

            if (txtCity.isShowing()) {
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


    
    private void updateDays(){
        int monthIndex = jcbBirthMonth.getSelectedIndex(); // get Selected month index
        int year = (Integer) jcbBirthYear.getSelectedItem();
        
        if (monthIndex == 0 || year == 0){
            jcbBirthDay.removeAllItems();
            jcbBirthDay.addItem(0);
            
            return;
        }
        
        // Calculate the number of days in the selected month and year
        YearMonth yearMonth = YearMonth.of(year, monthIndex);
        int daysInMonth = yearMonth.lengthOfMonth();
        
        // Update day JComboBox
        jcbBirthDay.removeAllItems();
        jcbBirthDay.addItem(0);
        for (int day = 1; day <= daysInMonth; day++){
            jcbBirthDay.addItem(day);
        }
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnContinue) {
            
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
        else if (e.getSource() == btnBackPage2){
            cardLayout.show(cards, "AccountSetup");
        }
        
        else if (e.getSource() == btnContinuePage2){
            String inputLname = txtLastName.getText().trim();
            String inputFname = txtFirstName.getText().trim();
            String inputMname = txtMiddlename.getText().trim();
            String inputSuffix = txtSuffix.getText().trim();
            String inputContact = txtContactNum.getText().trim();
            String inputEmail = txtEmail.getText().trim();
            String inputCitizenship = txtCitizenship.getText().trim();

            String jcbGenValue = (String) jcbGender.getSelectedItem();
            String jcbMonthValue = (String) jcbBirthMonth.getSelectedItem();
            int jcbDayValue = jcbBirthDay.getSelectedIndex();
            int jcbYearValue = (int) jcbBirthYear.getSelectedItem();
            String jcbStatusValue = (String) jcbStatus.getSelectedItem();

            String errorMessage = "Please fill out the following fields to continue: \n";
            if (inputLname.isEmpty()) errorMessage += "- Last Name\n";
            if (inputFname.isEmpty()) errorMessage += "- First Name\n";
            if (inputContact.isEmpty()) errorMessage += "- Contact No.\n";
            if (inputEmail.isEmpty()) errorMessage += "- Email Address\n";
            if (jcbGenValue.equals("Choose your gender")) errorMessage += "- Gender\n";
            if (jcbMonthValue.equals("Months")) errorMessage += "- Birth Month\n";
            if (jcbDayValue == 0) errorMessage += "- Birth Day\n";
            if (jcbYearValue == 0) errorMessage += "- Birth Year\n";
            if (inputCitizenship.isEmpty()) errorMessage += "- Citizenship\n";
            if (jcbStatusValue.equals("Choose your Status")) errorMessage += "- Status\n";

            if (!errorMessage.equals("Please fill out the following fields to continue: \n")){
                JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                return; // Prevent proceeding
            }

            // Validate email
                if (!inputEmail.matches("^[\\w-.]+@[\\w-]+\\.[a-z]{2,3}$")){
                    JOptionPane.showMessageDialog(this, "Invalid Email Address", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Prevent proceeding
            }

                if (!inputContact.replaceAll("\\s+", "").matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(this, "Contact No. must be 10 digits!", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Prevent proceeding
            }
            
            // Validate the birth year is selected
                if (jcbYearValue == 0){
                    JOptionPane.showMessageDialog(this, "Please select your birth year", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Prevent proceeding
            }

            // Validate age
            int currentYear = java.time.Year.now().getValue();
            int age = currentYear - jcbYearValue;
            int LEGAL_AGE = 18;

                if (age < LEGAL_AGE){
                    JOptionPane.showMessageDialog(this, "You must be at least " + LEGAL_AGE + " years old first to apply", "Error", JOptionPane.WARNING_MESSAGE);
                        return; // Prevent proceeding
            }

                cardLayout.show(cards, "Last");
            }
        
    }

    
        // Cities in the Philippines
        private class PhilippineCitySearch {
        private List<String> cities;

        public PhilippineCitySearch() {
            cities = new ArrayList<>();
            initializeCities();
        }

        private void initializeCities() {
            cities.addAll(Arrays.asList(
                "Alaminos, Pangasinan", "Angeles City, Pampanga", "Antipolo, Rizal", "Bacolod City, Negros Occidental", "Bacoor, Cavite",
                "Bago, Negros Occidental", "Baguio City, Benguet", "Bais, Negros Oriental", "Balanga, Bataan", "Baliwag, Bulacan",   
                "Batac, Ilocos Norte", "Batangas City, Batangas", "Bayawan, Negros Oriental", "Baybay, Leyte", "Bayugan, Agusan del Sur",               
                "Biñan City, Laguna", "Bislig, Surigao del Sur", "Bogo, Cebu", "Borongan, Eastern Samar", "Butuan, Agusan del Norte",
                "Cabadbaran, Agusan del Norte", "Cabanatuan, Nueva Ecija", "Cabuyao, Laguna", "Cadiz Negros Occidental",
                "Cagayan de Oro, Misamis Oriental", "Calaca, Batangas", "Calamba City, Laguna", "Calapan, Oriental Mindoro", "Calbayog, Samar",
                "Caloocan, Metro Manila", "Candon, Ilocos Sur", "Canlaon, Negros Oriental", "Carcar, Cebu", "Carmona, Cavite",  
                "Catbalogan, Samar", "Cauayan, Isabela", "Cavite City, Cavite", "Cebu City, Cebu", "Cotabato City, Maguindanao del Norte",
                "Dagupan City, Pangasinan", "Danao, Cebu", "Dapitan, Zamboanga del Norte", "Dasmariñas, Cavite", "Davao City, Davao del Sur",
                "Digos, Davao del Sur", "Dipolog, Zamboanga del Norte", "Dumaguete Negros Oriental", "El Salvador, Misamis Oriental", 
                "Escalante, Negros Occidental", "Gapan, Nueva Ecija", "General Santos City, South Cotabato", "General Trias, Cavite",   
                "Gingoog, Misamis Oriental", "Guihulngan, Negros Oriental", "Himamaylan, Negros Occidental",  "Ilagan, Isabela", "Iligan, Lanao del Norte", 
                "Iloilo City, Iloilo", "Imus, Cavite", "Iriga, Camarinues Sur", "Isabela, Basilan", "Kabankalan, Negros Occidental",
                "Kidapawan, Cotabato", "Koronadal, South Cotabato", "La Carlota, Negros Occidental", "Lamitan, Basilan", "Laoag, Ilocos Norte",
                "Lapu-Lapu City, Cebu", "Las Piñas, Metro Manila", "Legazpi City, Albay", "Ligao, Albay", "Lipa City, Batangas", "Lucena, Quezon",
                "Maasin, Southern Leyte", "Mabalacat, Pampanga", "Makati, Metro Manila", "Malabon, Metro Manila", "Malaybalay, Bukidnon",
                "Malolos, Bulacan", "Mandaluyong, Metro Manila", "Mandaue City, Cebu", "Manila, Metro Manila", "Marawi, Lanao del Sur",
                "Marikina, Metro Manila", "Masbate City, Masbate", "Mati, Davao Oriental", "Meycauayan, Bulacan", "Muñoz, Nueva Ecija",
                "Muntinlupa, Metro Manila", "Naga, Camarines Sur", "Naga, Cebu", "Navotas, Metro Manila", "Olongapo, Zambales", "Ormoc, Leyte",
                "Oroquieta, Misamis Occidental", "Pagadian, Zamboanga del Sur", "Palayan, Nueva Ecija", "Panabo, Davao del Norte", "Parañaque, Metro Manila",
                "Pasay, Metro Manila", "Passi, Iloilo", "Puerto Princesa, Palawan", "Quezon City, Metro Manila", "Roxas, Capiz", "Saqay, Negros Occidental",
                "Samal, Davao del Norte", "San carlos, Negros Occidental", "San Carlos, Pangasinan", "San Fernando, La Union", "San Fernando, Pampanga",
                "San Jose, Nueva Ecija", "San Jose del Monte, Bulacan", "San Juan, Metro Manila", "San Pablo, Laguna", "San Pedro, Laguna",
                "Santa Rosa, Laguna", "Santo Tomas, Batangas", "Santiago, Isabela", "Silay, Negros Occidental", "Sipalay, Negros Occidental",
                "Sorsogon City, Sorsogon", "Surigao City, Surigao del Norte", "Tabaco, Albay", "Tabuc, Kalinga", "Tacloban, Leyte", "Tacurong, Sultan Kudarat",
                "Tagaytay, Cavite", "Tagbilaran, Bohol", "Taguig, Metro Manila", "Tagum, Davao del Norte", "Talisay, Cebu", "Talisay, Negros Occidental",
                "Tanauan, Batangas", "Tandag, Surigao del Sur", "Tangub, Misamis Occidental", "Tanjay, Negros Oriental", "Tarlac City, Tarlac",
                "Tayabas, Quezon", "Toledo, Cebu", "Trece Martires, Cavite", "Tuguegarao, Cagayan", "Urdaneta, Pangasinan", "Valencia, Bukidnon",
                "Valenzuela, Metro Manila", "Victorias, Negros Occidental", "Vigan, Ilocos Sur", "Zamboanga City, Zamboanga del Sur"
               
            ));

                
        }

        public List<String> searchCities(String prefix) {
            final String searchPrefix = prefix.toLowerCase();  // Create a final variable
            
            return cities.stream()
            .filter(city -> city.toLowerCase().startsWith(searchPrefix))  // Use the final variable
            .collect(Collectors.toList());
        
        }

    }

    
        
        
     public static String formatPhoneNumber(String input) {
        // Only remove spaces and non-digits
        String cleaned = input.replaceAll("[^0-9]", "");
        
        // Don't format if less than 3 digits
        if (cleaned.length() < 3) return cleaned;
        
        StringBuilder formatted = new StringBuilder();
        
        // Format the number in parts
        if (cleaned.length() >= 3) {
            formatted.append(cleaned.substring(0, 3));
        }
        
        if (cleaned.length() >= 4) {
            formatted.append(" ");
            formatted.append(cleaned.substring(3, Math.min(6, cleaned.length())));
        }
        
        if (cleaned.length() >= 7) {
            formatted.append(" ");
            formatted.append(cleaned.substring(6, Math.min(10, cleaned.length())));
        }
        
        return formatted.toString();
    }
     
     
      
}

