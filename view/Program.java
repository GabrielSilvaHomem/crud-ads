package view;

import javax.swing.SwingUtilities;

public class Program {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				criarMostrarGUI();
			}
		});
	}

	private static void criarMostrarGUI() {
		AppFrame frame = new AppFrame();

		frame.mostrar();
	}
}
