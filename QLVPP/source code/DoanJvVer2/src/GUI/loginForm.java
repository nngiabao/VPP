package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BUS.PhanQuyenBUS;
import BUS.UserBUS;
import BUS.nhanvienBUS;
import DTO.PhanQuyenDTO;
import DTO.UserDTO;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author MY PC
 */

public class loginForm extends javax.swing.JFrame {
    public static String currentUser = null;
    public static String currentPass = null;
    /**
     * Creates new form loginForm
     */
    public loginForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBoxShowPass = new javax.swing.JCheckBox();
        jButtonLogin = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelClose = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-account-30.png"))); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-password-30.png"))); // NOI18N
        jLabel2.setText("Password");

        jTextFieldUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyPressed(evt);
            }
        });

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        jCheckBoxShowPass.setForeground(new java.awt.Color(51, 0, 255));
        jCheckBoxShowPass.setText("Show pass");
        jCheckBoxShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxShowPassActionPerformed(evt);
            }
        });

        jButtonLogin.setBackground(new java.awt.Color(51, 51, 255));
        jButtonLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(0, 0, 102));
        jButtonLogin.setText("Login");
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxShowPass, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxShowPass)
                .addGap(30, 30, 30)
                .addComponent(jButtonLogin)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(46, 204, 113));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-close-window-50.png"))); // NOI18N
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-minimize-window-50.png"))); // NOI18N
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("LoginForm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(104, 104, 104)
                .addComponent(jLabelMin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelClose))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabelClose, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jLabelMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked
        this.setState(JFrame.ICONIFIED);        
       // TODO add your handling code here:
       
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jCheckBoxShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxShowPassActionPerformed
        if(jCheckBoxShowPass.isSelected())
        {
            jPasswordField1.setEchoChar((char)0);
        }
        else
        {
            jPasswordField1.setEchoChar('*');
        }// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxShowPassActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // here
        UserBUS bus = new UserBUS();
        
        bus.docUserInfo();
//        try
//        {
            
            boolean kiemtra = false;
        for(UserDTO dto : UserBUS.dsuser)
        {   
            
            if(jTextFieldUsername.getText().equals(dto.getUsername())// so sanh username
                    && String.valueOf(jPasswordField1.getPassword()).equals(dto.getPass()))//so sanh pass
            {
                currentUser = dto.getUsername();//layuser dang nhap
                currentPass = dto.getPass();
                
                
                PhanQuyenBUS phanquyenBus = new PhanQuyenBUS();
                phanquyenBus.docChitiet(currentUser);//truyen xuong de doc phan quyen theo ten user
                
                kiemtra = true;
                break;
            } 
        }
            System.out.println(kiemtra);
        if (kiemtra == true)//neu nhap dung user name vs pass thi hien frame tong quat len
        {   
            OverallFrame j = new OverallFrame();
            j.setVisible(true);//hien frame tong
            this.dispose();//dong frame hientai
            //System.out.println(currentUser+" "+currentQuyen);
            } else if (!String.valueOf(jPasswordField1.getPassword()).equals("")
                    || !jTextFieldUsername.getText().equals("")) {
                if (kiemtra == false) {
                    //chua nhap username
                    if (jTextFieldUsername.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Chưa nhập Username", "Login Fail", JOptionPane.ERROR_MESSAGE);
                        jTextFieldUsername.requestFocus();
                    } //chua nhap password
                    else if (String.valueOf(jPasswordField1.getPassword()).equals("")) {
                        JOptionPane.showMessageDialog(null, "Chưa nhập Password", "Login Fail", JOptionPane.ERROR_MESSAGE);
                        jPasswordField1.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu", "Login Fail", JOptionPane.ERROR_MESSAGE);
                        jTextFieldUsername.requestFocus();
                    }
                }
            }
        //kiem tra textfield
            //chua nhap pass va user
        else if(String.valueOf(jPasswordField1.getPassword()).equals("")
                    && jTextFieldUsername.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Chưa nhập Username và Password", "Login Fail", JOptionPane.ERROR_MESSAGE);
                jTextFieldUsername.requestFocus();//dua con tro vao o text
                    
            }
//        }catch(Exception e)
//        {
//            System.out.println(e);
//            System.out.println("Sai cho login");
//        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    // tao nut enter cho cac text field
    private void jTextFieldUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsernameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
                //System.out.println("blbla");
            if(jTextFieldUsername.getText().equals(""))//neu username rong thi goi nut login
            {
                jButtonLogin.doClick();
            }else jPasswordField1.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldUsernameKeyPressed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
                //System.out.println("blbla");
            jButtonLogin.requestFocus();
            jButtonLogin.doClick();
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new loginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JCheckBox jCheckBoxShowPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}