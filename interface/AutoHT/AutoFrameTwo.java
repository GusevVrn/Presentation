package Interface.AutoHT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Класс для отображения выбранных элементов с предыдущей формы
 */

public class AutoFrameTwo extends JFrame {
    JButton backBut = new JButton("Back To Select");

    public AutoFrameTwo(ArrayList<String> auto) {
        super("Форма сравнения");
        setSize(470, 150);
        setLocationRelativeTo(null);
        setResizable(false);
        Container c = getContentPane();

        String header[] = {"Название", "Тип двигателя", "Мощность", "Объем"}; //Заголовки таблицы
        String[][] data = new String[auto.size()][header.length]; //Элементы таблицы
        for (int i = 0; i < data.length; i++) {
            data[i] = auto.get(i).split(","); // Заполнение массива из предыдущей формы
        }
        JTable table = new JTable(data, header); // Табличный вывод значений полученных с предыдущей формы
        JScrollPane spTable = new JScrollPane(table);
        table.setAlignmentX(CENTER_ALIGNMENT);
        JPanel panel = new JPanel();
        panel.add(spTable);
        c.add(panel, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.add(backBut);
        c.add(bottom, BorderLayout.SOUTH);

        backBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AutoFrameOne().setVisible(true);
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
