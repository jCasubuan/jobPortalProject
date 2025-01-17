/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobportalproject.accountSetup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author jcasu
 */

public class signUp extends JFrame implements ActionListener,MouseListener{
private JLabel hdrSignUp, lblEmail, lblPassword, lblRetypePass, lblKeepSign, lblUserAgreement1, lblUserAgreement2, lblJobVista, lblSignIn;
private JPanel  pnlSignUp, lblPanel;   
private JTextField txtEmail;
private JPasswordField pfPassword1, pfPassword2;
private JCheckBox boxLogin;
private JButton btnJoin;
    
    
    
    public signUp() {
        setTitle("Sign Up");
        setSize(500, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        hdrSignUp = new JLabel("Sign Up");
        hdrSignUp.setBounds(25, 20, 150, 35);
        hdrSignUp.setFont(new Font("Arial", Font.PLAIN, 33));
        add(hdrSignUp);
        
        pnlSignUp = new JPanel();
        pnlSignUp.setBounds(25, 70, 437, 465);
        pnlSignUp.setOpaque(true);
        //pnlSignUp.setBackground(new Color(80, 133,200,150));
        pnlSignUp.setLayout(null);
        add(pnlSignUp);
        
        lblEmail = new JLabel("Email or phone number ");
        lblEmail.setBounds(15,0,170,30);
        pnlSignUp.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(15,30,400,35);
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        txtEmail.setBorder(BorderFactory.createCompoundBorder(txtEmail.getBorder(), new EmptyBorder(10, 5, 2, 5)));
        pnlSignUp.add(txtEmail);
        
        lblPassword = new JLabel("Password (6+ characters)");
        lblPassword.setBounds(15, 77, 170, 30);
        pnlSignUp.add(lblPassword);
        
        pfPassword1 = new JPasswordField();
        pfPassword1.setEchoChar('*');
        pfPassword1.setBounds(15,108,400,35);
        pfPassword1.setFont(new Font("Arial", Font.PLAIN, 16));
        pfPassword1.setBorder(BorderFactory.createCompoundBorder(pfPassword1.getBorder(), new EmptyBorder(10, 5, 2, 5)));
        pnlSignUp.add(pfPassword1);
        
        lblRetypePass = new JLabel("Retype Password");
        lblRetypePass.setBounds(15, 155, 170, 30);
        pnlSignUp.add(lblRetypePass);
        
        pfPassword2 = new JPasswordField();
        pfPassword2.setEchoChar('*');
        pfPassword2.setBounds(15, 185, 400, 35);
        pfPassword2.setFont(new Font("Arial", Font.PLAIN, 16));
        pfPassword2.setBorder(BorderFactory.createCompoundBorder(pfPassword2.getBorder(), new EmptyBorder(10, 5, 2, 5)));
        pnlSignUp.add(pfPassword2);
        
        boxLogin = new JCheckBox();
        boxLogin.setBounds(15, 250, 20, 20);
        pnlSignUp.add(boxLogin);
        
        lblKeepSign = new JLabel("Keep me logged in");
        lblKeepSign.setBounds(40, 245, 170, 30);
        pnlSignUp.add(lblKeepSign);
        
        lblUserAgreement1 = new JLabel("By clicking Agree & Join or Continue, you agree to the JobVista");
        lblUserAgreement1.setBounds(45, 290, 380,25);
        lblUserAgreement1.setFont(new Font("Arial", Font.PLAIN, 12));
        
        lblUserAgreement2 = new JLabel("User Agreement, Privacy Policy, and Cookie Policy.");
        lblUserAgreement2.setBounds(75, 310, 380,25);
        lblUserAgreement2.setFont(new Font("Arial", Font.PLAIN, 12));
        pnlSignUp.add(lblUserAgreement1);
        pnlSignUp.add(lblUserAgreement2);
        
        btnJoin = new JButton("Agree & Join");
        btnJoin.setBorder(new LineBorder(new Color(0, 119, 212), 2, true));
        btnJoin.setBackground(new Color(0, 119, 212));
        btnJoin.setForeground(Color.white);
        btnJoin.setFont(new Font("Arial", Font.BOLD, 16));
        btnJoin.setBounds(25, 350, 380, 50);
        btnJoin.setBorderPainted(false);
        btnJoin.setFocusPainted(false);
        btnJoin.setOpaque(true);
        pnlSignUp.add(btnJoin);
        
        lblJobVista = new JLabel("Already on JobVista? ");
        lblJobVista.setBounds(100, 425, 170, 30);
        lblJobVista.setFont(new Font("Arial", Font.PLAIN, 15));
        pnlSignUp.add(lblJobVista);
        
        lblSignIn = new JLabel("Sign in");
        lblSignIn.setBounds(248, 425, 70, 30);
        lblSignIn.setFont(new Font("Arial", Font.CENTER_BASELINE,15));
        lblSignIn.setForeground(new Color(0, 119, 212));
        pnlSignUp.add(lblSignIn);
        
        JPanel lblmainBg = new JPanel();
        lblmainBg.setBounds(0,0,500,600);
        lblmainBg.setLayout(null);
        add(lblmainBg);
        
        btnJoin.addActionListener(this);
        lblSignIn.addMouseListener(this);
        
        
             
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == lblSignIn){
            new signInPage().setVisible(true);
            dispose();
        }
        
        
        
    }
    @Override
    public void mousePressed(MouseEvent e) {   
    }
    @Override
    public void mouseReleased(MouseEvent e) {        
    }
    @Override
    public void mouseEntered(MouseEvent e) {        
    }
    @Override
    public void mouseExited(MouseEvent e) {       
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnJoin){
            String inputEmail = txtEmail.getText();
            char[] inputPassword1 = pfPassword1.getPassword();
            char[] inputPassword2 = pfPassword2.getPassword();
                        
            if (inputEmail.isEmpty() || inputPassword1.length == 0 || inputPassword2.length == 0){
                JOptionPane.showMessageDialog(this, "Please fill in all fields to continue", "Error", JOptionPane.ERROR_MESSAGE);               
            }
            else if (!inputEmail.contains("@gmail.com")){
                JOptionPane.showMessageDialog(this, "Invalid Email Address! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!Arrays.equals(inputPassword1, inputPassword2)){
                JOptionPane.showMessageDialog(this, "Password does not match!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (inputEmail.equals("user@gmail.com") 
                    && Arrays.equals(inputPassword1, "user123".toCharArray()) 
                    && Arrays.equals(inputPassword2, "user123".toCharArray())){
                JOptionPane.showMessageDialog(this, "Sign up Successful", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                new firstTimeInterface().setVisible(true);
                dispose();
            }
             else {
            JOptionPane.showMessageDialog(this, "Invalid Account", "Error", JOptionPane.ERROR_MESSAGE);
        }
            //Clear the password arrays after validation for security
            Arrays.fill(inputPassword1, '\0');
            Arrays.fill(inputPassword2, '\0');
        }
       
        
    }
       
    
}
