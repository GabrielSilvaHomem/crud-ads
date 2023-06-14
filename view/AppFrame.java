package view;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Cadastro;

public class AppFrame extends JFrame {
    public static final String titulo = "CRUD";
	
	private CardLayout layout;
	private JPanel cardsPane;

	private Component inicialPanel;
	private CadastroListPanel cadastroListPanel;
	private CadastroFormPanel cadastroFormPanel;

    public AppFrame() {
		super(titulo);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layout = new CardLayout();

		cardsPane = new JPanel();
		cardsPane.setLayout(layout);
		add(cardsPane);

		criarCards();
	}

    public void mostrar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

    public void mostrarListaCadastros() {
		cadastroListPanel.recarregar();
		layout.show(cardsPane, CadastroListPanel.class.getName());
	} 

    public void mostrarFormCadastros(Cadastro cadastro) {
		cadastroFormPanel.setCadastro(cadastro);
		layout.show(cardsPane, CadastroFormPanel.class.getName());
	} 

    private void criarCards() {
		inicialPanel = new InicialPanel(this);
		cardsPane.add(inicialPanel, InicialPanel.class.getName());

		cadastroListPanel = new CadastroListPanel(this);
		cardsPane.add(cadastroListPanel, CadastroListPanel.class.getName());

		cadastroFormPanel = new CadastroFormPanel(this);
		cardsPane.add(cadastroFormPanel, CadastroFormPanel.class.getName());
	}
}
