/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobportalproject.accountSetup;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author jcasu
 */
public class welcomePage extends JFrame implements ActionListener{
    private JLabel hdrWelcome, lblLogo, lblJobVista, lblTagline;
    private JButton btnSignIn, btnSignUp;
    private ImageIcon mainIcon, finalMainIcon;
    
    public welcomePage() {
        setTitle("JobVista");
        setSize(500, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        // Welcome Text
        /*hdrWelcome = new JLabel("Welcome", SwingConstants.LEFT);
        hdrWelcome.setVerticalAlignment(SwingConstants.TOP);
        hdrWelcome.setBounds(175, 30, 400, 50);
        hdrWelcome.setFont(new Font("Arial", Font.PLAIN, 33));
        add(hdrWelcome);*/
      
        ImageIcon icon = new ImageIcon("mainIcon.png");
        finalMainIcon = new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        lblLogo = new JLabel(finalMainIcon);
        lblLogo.setBounds(190, 80, 100, 100);
        add(lblLogo);
        
        lblJobVista = new JLabel("JobVista");
        lblJobVista.setFont(new Font("Arial", Font.CENTER_BASELINE, 45));
        lblJobVista.setBounds(147, 200, 500, 40);
        add(lblJobVista);

        // Tagline
        lblTagline = new JLabel("\"Your gateway to Career Opportunities\"", SwingConstants.CENTER);
        lblTagline.setFont(new Font("Arial", Font.ITALIC, 16));
        lblTagline.setForeground(Color.DARK_GRAY);  // Subtle color for tagline
        lblTagline.setBounds(50, 250, 400, 30);  // Just below the welcome text
        add(lblTagline);
        
        btnSignIn = new JButton("Sign In");
        btnSignIn.setBorder(new LineBorder(new Color(0, 119, 212), 2, true));
        btnSignIn.setBackground(new Color(0, 119, 212));
        btnSignIn.setForeground(Color.white);
        btnSignIn.setFont(new Font("Arial", Font.BOLD, 16));
        btnSignIn.setBounds(150, 350, 200, 40);  // Centered horizontally
        btnSignIn.setBorderPainted(false);
        btnSignIn.setFocusPainted(false);
        btnSignIn.setOpaque(true);
        add(btnSignIn);
        
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBorder(new LineBorder(new Color(0, 119, 212), 2, true));
        btnSignUp.setBackground(new Color(0, 119, 212));
        btnSignUp.setForeground(Color.white);
        btnSignUp.setFont(new Font("Arial", Font.BOLD, 16));
        btnSignUp.setBounds(150, 410, 200, 40);  // Slightly below Sign In button
        btnSignUp.setBorderPainted(false);
        btnSignUp.setFocusPainted(false);
        btnSignUp.setOpaque(true);
        add(btnSignUp);
        
        btnSignIn.addActionListener(this);
        btnSignUp.addActionListener(this);
        
   
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignIn){
            new signInPage().setVisible(true);
            dispose();
        }
        else if (e.getSource()  == btnSignUp){
            new signUp().setVisible(true);
            dispose();
        }
        
    }

   
    
}
