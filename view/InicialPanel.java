package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InicialPanel extends JPanel{
    private AppFrame frame;
	private JButton cadastrosBtn;

	public InicialPanel(AppFrame appFrame) {
		frame = appFrame;

		cadastrosBtn = new JButton("Cadastro");
		cadastrosBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarListaCadastros();
			}
		});
		add(cadastrosBtn);
	}
}
