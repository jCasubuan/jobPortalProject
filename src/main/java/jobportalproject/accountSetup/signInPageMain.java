/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobportalproject.accountSetup;

import javax.swing.SwingUtilities;





/**
 *
 * @author jcasu
 */
public class signInPageMain {
    public static void main(String[] args) {
        
        signInPage login = new signInPage();
        login.setVisible(true);
        SwingUtilities.invokeLater(signInPage::new);
        
        
    }
}
