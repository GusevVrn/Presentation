package game;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Game {

	public static void main(String[] args) throws IOException {
		int s = Integer.parseInt(JOptionPane.showInputDialog("Введите сложность игры"));
		if(s >= 1 && s <= 7) {
			new Okno(s);
		}
		else {
			JOptionPane.showMessageDialog(null, "Вы ввели некорректно сложность игры!");
		}

	}

}
