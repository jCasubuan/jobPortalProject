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
public class firstTimeInterface extends JFrame implements ActionListener{
private JLabel hdrlogo, hdrJobVista, lblHome, lblNew, logoNotif, profileLogo, mailLogo, hdrWelcome, lblFirstStep, lbltools, lblCopyright, lblPrivacyCenter, lblTerms;
private ImageIcon logoIC, finalLogoIC, notifIC, finalNotifIC, profileIC, finalProfileIC, mailIC, finalMailIC;            
private JPanel hdrPanel, panelWelcome;      
private JButton btnJobSeeker, btnEmployer;
            
            
    firstTimeInterface() {
        setSize(1500, 780);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
                
        hdrPanel = new JPanel();
        hdrPanel.setBorder(new LineBorder(Color.GRAY, 1));
        hdrPanel.setBounds(0, 0, 1500, 76);
        //hdrPanel.setOpaque(true);
        //hdrPanel.setBackground(new Color(80, 133,200,150));
        hdrPanel.setLayout(null);
        add(hdrPanel);
        
        logoIC = new ImageIcon("mainIcon.png");
        finalLogoIC = new ImageIcon(logoIC.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
            
        hdrlogo = new JLabel(finalLogoIC);
        hdrlogo.setBounds(15, 15, 40, 40);
        hdrPanel.add(hdrlogo);
        
        hdrJobVista = new JLabel("JobVista");
        hdrJobVista.setBounds(50, 20, 125, 35);
        hdrJobVista.setFont(new Font("Arial", Font.CENTER_BASELINE, 25));
        hdrJobVista.setHorizontalAlignment(SwingConstants.CENTER);
        hdrPanel.add(hdrJobVista);
        
        lblHome = new JLabel("Home");
        lblHome.setBounds(190, 33, 50, 15);
        lblHome.setFont(new Font("Arial", Font.PLAIN, 15));
        lblHome.setHorizontalAlignment(SwingConstants.CENTER);
        hdrPanel.add(lblHome);
        
        lblNew = new JLabel("What's new?");
        lblNew.setBounds(255, 33, 90, 15);
        lblNew.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNew.setHorizontalAlignment(SwingConstants.CENTER);
        hdrPanel.add(lblNew);
        
        mailIC = new ImageIcon("mailIcon.png");
        finalMailIC = new ImageIcon(mailIC.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        
        mailLogo = new JLabel(finalMailIC);
        mailLogo.setBounds(1250, 28, 25, 25);
        hdrPanel.add(mailLogo);
        
        notifIC = new ImageIcon("notifIcon.png");
        finalNotifIC = new ImageIcon(notifIC.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        
        logoNotif = new JLabel(finalNotifIC);
        logoNotif.setBounds(1330, 30, 20, 20);
        hdrPanel.add(logoNotif);
        
        profileIC = new ImageIcon("profileIcon.png");
        finalProfileIC = new ImageIcon(profileIC.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        
        profileLogo = new JLabel(finalProfileIC);
        profileLogo.setBounds(1400, 29, 20, 20);
        hdrPanel.add(profileLogo);

        panelWelcome = new JPanel();
        panelWelcome.setBorder(new LineBorder(Color.GRAY, 1));
        panelWelcome.setBounds(440, 190, 600, 400);
        panelWelcome.setLayout(null);
        add(panelWelcome);
        
        hdrWelcome = new JLabel("Welcome!");
        hdrWelcome.setFont(new Font("Arial", Font.BOLD, 30));
        hdrWelcome.setBounds(230, 65, 150, 35);
        panelWelcome.add(hdrWelcome);
        
        lblFirstStep = new JLabel("Ready for the next step?");
        lblFirstStep.setFont(new Font("Arial", Font.PLAIN, 15));
        lblFirstStep.setBounds(220, 110, 250, 25);
        panelWelcome.add(lblFirstStep);
        
        lbltools = new JLabel("Create an account for tools to helps you");
        lbltools.setForeground(Color.GRAY);
        lbltools.setFont(new Font("Arial", Font.PLAIN, 15));
        lbltools.setBounds(180, 180, 275, 25);
        panelWelcome.add(lbltools);
        
        btnJobSeeker = new JButton("I'm a Job Seeker");
        btnJobSeeker.setBackground(Color.WHITE);
        btnJobSeeker.setForeground(new Color(0, 119, 212));
        btnJobSeeker.setFont(new Font("Arial", Font.BOLD, 16));
        btnJobSeeker.setBounds(80, 230, 450, 50);
        btnJobSeeker.setFocusPainted(false);
        //btnJobSeeker.setOpaque(true);
        panelWelcome.add(btnJobSeeker);
        
        btnEmployer = new JButton("I'm an Employer");
        btnEmployer.setBackground(Color.WHITE);
        btnEmployer.setForeground(new Color(0, 119, 212));
        btnEmployer.setFont(new Font("Arial", Font.BOLD, 16));
        btnEmployer.setBounds(80, 300, 450, 50);
        btnEmployer.setFocusPainted(false);
        //btnJobSeeker.setOpaque(true);
        panelWelcome.add(btnEmployer);
        
        lblCopyright = new JLabel("© 2025 JobVista");
        lblCopyright.setFont(new Font("Arial", Font.PLAIN, 12));
        lblCopyright.setBounds(30, 700, 120, 12);
        add(lblCopyright);
        
        lblPrivacyCenter = new JLabel("Privacy Policy");
        lblPrivacyCenter.setFont(new Font("Arial", Font.PLAIN, 12));
        lblPrivacyCenter.setBounds(140, 700, 120, 12);
        add(lblPrivacyCenter);
        
        lblTerms = new JLabel("Terms");
        lblTerms.setFont(new Font("Arial", Font.PLAIN, 12));
        lblTerms.setBounds(245, 700, 120, 12);
        add(lblTerms);
        
        btnJobSeeker.addActionListener(this);
        btnEmployer.addActionListener(this);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnJobSeeker){
            new accountSetup().setVisible(true);
            dispose();
        }
        else if (e.getSource() == btnEmployer){
            new employerSetup();
            dispose();
        }
    }
    
}
