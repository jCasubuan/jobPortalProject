/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobportalproject.accountSetup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import jobportalproject.accountInterface.adminPage;
import jobportalproject.accountInterface.clientInterface;


/**
 *
 * @author jcasu
 */
public class signInPage extends JFrame implements ActionListener, MouseListener, FocusListener{
private JLabel hdrLabel, lblSignUp, lblUpdate, lblPlaceholderUsername, lblPlaceholderPassword, lblForgotPass, lblKeeplog, lblAgreement1, lblAgreement2, lblNew;
private JPanel pnlSignIn;
private JTextField txtUserEmail;
private JPasswordField pfPassword;
private JButton btnLogin;
private JCheckBox boxLogged;


    signInPage() {
        setTitle("JobVista");
        setSize(500, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        hdrLabel = new JLabel("Sign in");
        hdrLabel.setBounds(25, 20, 150, 35);
        hdrLabel.setFont(new Font("Arial", Font.PLAIN, 33));
        add(hdrLabel);
        
        lblUpdate = new JLabel("Stay updated on your professional world.");
        lblUpdate.setBounds(25, 58, 220, 25);
        lblUpdate.setFont(new Font("Arial", Font.PLAIN, 12));
        add(lblUpdate);
        
        pnlSignIn = new JPanel();
        pnlSignIn.setBounds(25, 85, 437, 465);
        //pnlSignIn.setOpaque(true);
        //pnlSignIn.setBackground(new Color(80, 133,200,150));
        pnlSignIn.setLayout(null);
        add(pnlSignIn);
        
        lblPlaceholderUsername = new JLabel("Email or phone");
        lblPlaceholderUsername.setFont(new Font("Arial", Font.PLAIN, 15));
        lblPlaceholderUsername.setForeground(Color.GRAY);
        lblPlaceholderUsername.setBounds(15, 30, 200, 33);
        pnlSignIn.add(lblPlaceholderUsername);
        
        txtUserEmail = new JTextField();
        txtUserEmail.setBounds(0, 15, 420, 55);
        txtUserEmail .setFont(new Font("Arial", Font.PLAIN, 16));
        txtUserEmail.setBorder(BorderFactory.createCompoundBorder(txtUserEmail.getBorder(), new EmptyBorder(10, 5, 2, 5)));
        pnlSignIn.add(txtUserEmail);
        
        txtUserEmail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                lblPlaceholderUsername.setFont(new Font("Arial", Font.PLAIN, 12));
                lblPlaceholderUsername.setBounds(15, 15, 200, 20); //move upwards
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtUserEmail.getText().isEmpty()){
                    lblPlaceholderUsername.setFont(new Font("Arial", Font.PLAIN, 15));
                    lblPlaceholderUsername.setBounds(15, 30, 200, 20);
                }
            }
        });
                
        lblPlaceholderPassword = new JLabel("Password");
        lblPlaceholderPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        lblPlaceholderPassword.setForeground(Color.GRAY);
        lblPlaceholderPassword.setBounds(15, 105, 110, 20); //initial position
        pnlSignIn.add(lblPlaceholderPassword);
        
        pfPassword = new JPasswordField();
        pfPassword.setEchoChar('*');
        pfPassword.setBounds(0, 90, 420, 55);
        pfPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        pfPassword.setBorder(BorderFactory.createCompoundBorder(pfPassword.getBorder(), new EmptyBorder(10, 5, 2, 5)));
        pnlSignIn.add(pfPassword);
        
        pfPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                lblPlaceholderPassword.setFont(new Font("Arial", Font.PLAIN, 12));
                lblPlaceholderPassword.setBounds(15, 93, 110, 20);
        }
            @Override
            public void focusLost(FocusEvent e) {
                if (pfPassword.getPassword().length == 0){
                    lblPlaceholderPassword.setFont(new Font("Arial", Font.PLAIN, 15));
                    lblPlaceholderPassword.setBounds(15, 105, 110, 20);
                }
            }
        });
        
        lblForgotPass = new JLabel("Forgot password?");
        lblForgotPass.setBounds(0, 160, 210, 20);
        lblForgotPass.setFont(new Font("Arial", Font.PLAIN, 16));
        lblForgotPass.setForeground(new Color(0, 119, 212));
        pnlSignIn.add(lblForgotPass);
        
        boxLogged = new JCheckBox();
        boxLogged.setBounds(0, 195, 20, 20);
        pnlSignIn.add(boxLogged);
        
        lblKeeplog = new JLabel("Keep me logged in");
        lblKeeplog.setBounds(28, 190, 175, 30);
        pnlSignIn.add(lblKeeplog);
        
        btnLogin = new JButton("Sign in");
        btnLogin.setBorder(new LineBorder(new Color(0, 119, 212), 2, true));
        btnLogin.setBackground(new Color(0, 119, 212));
        btnLogin.setForeground(Color.white);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
        btnLogin.setBounds(20, 250, 380, 50);
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        btnLogin.setOpaque(true);
        pnlSignIn.add(btnLogin);
        
        lblAgreement1 = new JLabel("By clicking Agree & Join or Continue, you agree to the JobVista");
        lblAgreement1.setBounds(45, 320, 380,25);
        lblAgreement1.setFont(new Font("Arial", Font.PLAIN, 12));
        
        lblAgreement2 = new JLabel("User Agreement, Privacy Policy, and Cookie Policy.");
        lblAgreement2.setBounds(75, 340, 380,25);
        lblAgreement2.setFont(new Font("Arial", Font.PLAIN, 12));
        pnlSignIn.add(lblAgreement1);
        pnlSignIn.add(lblAgreement2);
        
        lblNew = new JLabel("New to JobVista? ");
        lblNew.setBounds(115, 390, 200, 30);
        lblNew.setFont(new Font("Arial", Font.PLAIN, 15));
        pnlSignIn.add(lblNew);
        
        lblSignUp = new JLabel("Sign Up");
        lblSignUp.setBounds(240, 390, 95, 30);
        lblSignUp.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        lblSignUp.setForeground(new Color(0, 119, 212));
        pnlSignIn.add(lblSignUp);
        

        
        JPanel lblmainBg = new JPanel();
        lblmainBg.setBounds(0,0,500,600);
        lblmainBg.setLayout(null);
        add(lblmainBg);
        
        btnLogin.addActionListener(this);
        lblSignUp.addMouseListener(this);
        
        
    }

@Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == lblSignUp){
            new signUp().setVisible(true);
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
        
        if (e.getSource() == btnLogin){
            String inputUsername = txtUserEmail.getText();
            char[] inputPasswordArray = pfPassword.getPassword();
            String inputPassword = new String(inputPasswordArray);
            
            if (inputUsername.isEmpty() || inputPassword.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please fill in all fields to continue", "Error", JOptionPane.ERROR_MESSAGE);    
            }
            else if (inputUsername.equals("user") &&  inputPassword.equals("user123")){
                new clientInterface();
                dispose();
            }
            else if (inputUsername.equals("admin") && inputPassword.equals("admin123")){
                new adminPage();
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid Account!\nPlease try again.", "Error", JOptionPane.ERROR_MESSAGE);   
            }
            java.util.Arrays.fill(inputPasswordArray, '\0');
        }
        
    }

    @Override
    public void focusGained(FocusEvent e) {
    }
    @Override
    public void focusLost(FocusEvent e) {
    }

   
}
