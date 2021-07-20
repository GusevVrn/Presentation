package Interface.AutoHT;

import Interface.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Класс для выбора автомобилей и передачи этих значений на следующую форму
 */

public class AutoFrameOne extends JFrame {
    JLabel label1 = new JLabel("Выберите марку автомобиля");
    JLabel label2 = new JLabel("Выберите модель автомобиля");

    String marki[] = {"Audi", "BMW", "Nissan", "Toyota", "Mitsubishi"};
    JComboBox<String> markiList = new JComboBox<>(marki); //Выпадающий список для марок

    DefaultListModel listModel = new DefaultListModel();
    JList modelList = new JList(listModel); // Обычный лист для моделей


    JButton okButton = new JButton("Compare");
    JButton backButton = new JButton("Back to menu");

    public AutoFrameOne() {
        super("Выбор автомобилей ");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));
        JPanel panel1 = new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(1, 1));
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(label1);
        panel.add(label2);
        panel1.add(markiList);
        panel1.add(modelList);
        panel2.add(okButton);
        panel2.add(backButton);
        flow.add(panel2);

        Container c = getContentPane();
        c.add(panel, BorderLayout.NORTH);
        c.add(panel1, BorderLayout.CENTER);
        c.add(flow, BorderLayout.SOUTH);

        //???
        ArrayList<String> audi = new ArrayList<>();
        audi.add("A3, Дизель, 116 л.с., 2.0 л");
        audi.add("A4, Бензин, 150 л.с., 2.0 л");
        audi.add("A5, Бензин, 249 л.с., 2.0 л");

        ArrayList<String> bmw = new ArrayList<>();
        bmw.add("X3, Бензин, 184 л.с., 2.0 л");
        bmw.add("X4, Бензин, 249 л.с., 2.0 л");
        bmw.add("X5, Дизель, 249 л.с., 3.0 л");

        ArrayList<String> nissan = new ArrayList<>();
        nissan.add("Murano, Бензин, 249 л.с., 3.5 л");
        nissan.add("Qashqai, Бензин, 159 л.с., 1.3 л");

        ArrayList<String> toyota = new ArrayList<>();
        toyota.add("Alphard, Бензин, 300 л.с., 3.0 л");
        toyota.add("Altezza, Бензин, 200л.с, 2.0 л");
        toyota.add("Chaser, Бензин, 200л.с., 2.5 л");

        ArrayList<String> mitsubishi = new ArrayList<>();
        mitsubishi.add("Airtec, Бензин, 139 л.с., 2.4 л");
        mitsubishi.add("Lanser, Бензин, 168 л.с., 2.4 л");

        markiList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = markiList.getSelectedIndex();
                if (index == 0) {
                    listModel.clear();
                    listModel.addAll(audi);
                } else if (index == 1) {
                    listModel.clear();
                    listModel.addAll(bmw);
                } else if (index == 2) {
                    listModel.clear();
                    listModel.addAll(nissan);
                } else if (index == 3) {
                    listModel.clear();
                    listModel.addAll(toyota);
                } else if (index == 4) {
                    listModel.clear();
                    listModel.addAll(mitsubishi);
                }
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ArrayList<String> list = new ArrayList<>();
                int indexes[] = modelList.getSelectedIndices(); // получили индексы нажатых
                for (int i = 0; i < indexes.length; i++) {  //заполнили лист с марками и описанием
                    list.add(listModel.getElementAt(i).toString());
                }
                new AutoFrameTwo(list).setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu().setVisible(true);
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
