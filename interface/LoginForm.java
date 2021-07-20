package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginForm extends JFrame {
    JTextField login = new JTextField("Login", 15);
    JPasswordField pass = new JPasswordField("Pass", 15);
    JButton butOk = new JButton("Login");
    JButton butCan = new JButton("Cancel");
    static HashMap<String, String> logMap = new HashMap();

    public LoginForm() {
        logMap.put("user", "user");
        logMap.put("admin", "admin");
        JFrame logForm = new JFrame("Форма авторизации");
        setSize(250, 90);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        JPanel panel = new JPanel(new GridLayout(1, 2, 5, 0));
        panel.add(butOk);
        panel.add(butCan);
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(panel);

        Container cont = getContentPane();
        cont.add(flow, BorderLayout.SOUTH);

        JPanel panel1 = new JPanel();
        panel1.add(login);
        panel1.add(pass);
        cont.add(panel1);
        butCan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        butOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkAuth(login.getText(), new String(pass.getPassword()))) {
                    dispose();
                    new Menu(login.getText()).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Введен неверный логин/пароль ");
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    static boolean checkAuth(String login, String pass) {
        if (pass.equals(logMap.get(login))) {
            return true;
        }
        return false;
    }
}
