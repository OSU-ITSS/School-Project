package cz.osu;

import javax.swing.*;
import java.awt.event.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainWindow {
    private JPanel panel1;
    private JButton btnLogin;
    private JButton btnShop;
    private JButton btnLibrary;
    private JButton btnCommunity;
    private JButton btnProfile;
    private JLabel lblHeader;

    public MainWindow() {
        Localizer localizer = new Localizer();
        ArrayList<JButton> buttons = new ArrayList();
        buttons.add(btnLogin);
        buttons.add(btnProfile);
        buttons.add(btnCommunity);
        buttons.add(btnLibrary);
        buttons.add(btnShop);
        for(JButton button : buttons){
            button.setText(localizer.get(button.getName()));
        }

        /*
        for(Field field : MainWindow.class.getFields()){
            if(field.getType() == JButton.class){
                try {
                    System.out.println(field.getName());
                    ((JButton)field.get(this)).setText(localizer.get(field.getName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        */

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnLogin.getText().equals(localizer.get(btnLogin.getName()))){
                    btnLogin.setText(localizer.get("btnLogout"));
                    btnProfile.setText(localizer.get("Meg.71"));
                }
                else{
                    btnLogin.setText(localizer.get(btnLogin.getName()));
                    btnProfile.setText(localizer.get(btnProfile.getName()));
                }

            }
        });
        btnLibrary.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnLibrary.setVisible(false);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnLibrary.setVisible(true);
            }
        });
        panel1.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                lblHeader.setText("Steam (" + e.getX()+","+e.getY()+")");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Steam");
        frame.setContentPane(new MainWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
