package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Cadastro;
import model.CadastroStorage;


public class CadastroListPanel extends JPanel {
    private AppFrame frame;
	private JButton novoCadastroBtn;
	private JButton alterarCadastroBtn;
	private JButton removerCadastroBtn;
	private JTable tabela;
	private CadastroTableModel tableModel;

    public CadastroListPanel(AppFrame appFrame) {
		frame = appFrame;

		setLayout(new BorderLayout(10, 10));

		criarComandosPanel();
		criarTabelaPanel();
	}

    public void recarregar() {
		tableModel.carregar(CadastroStorage.listar());
	}
    
    private void criarComandosPanel() {
		JPanel panel = new JPanel();
		FlowLayout layout = (FlowLayout) panel.getLayout();
		layout.setAlignment(FlowLayout.RIGHT);

		novoCadastroBtn = new JButton("Novo Cadastro");
		novoCadastroBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarFormCadastros(null);
			}
		});
		panel.add(novoCadastroBtn);

		alterarCadastroBtn = new JButton("Alterar");
		alterarCadastroBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarFormCadastros(tableModel.getCadastro(tabela.getSelectedRow()));
			}
		});
		panel.add(alterarCadastroBtn);

		removerCadastroBtn = new JButton("Remover");
		removerCadastroBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cadastro cadastro = tableModel.getCadastro(tabela.getSelectedRow());
				int resposta = JOptionPane.showConfirmDialog(CadastroListPanel.this, "Deseja realmente remover?",
						AppFrame.titulo, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (resposta == JOptionPane.YES_OPTION) {
					CadastroStorage.remover(cadastro);
					tableModel.remover(cadastro);
				}
			}
		});
		panel.add(removerCadastroBtn);

		add(panel, BorderLayout.NORTH);

		desabilitarBtns();
	} 

	private void criarTabelaPanel() {
		JPanel panel = new JPanel();

		tableModel = new CadastroTableModel(CadastroStorage.listar());
		tabela = new JTable(tableModel);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (tabela.getSelectedRow() >= 0) {
						habilitarBtns();
					} else {
						desabilitarBtns();
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(tabela);
		panel.add(scrollPane);

		add(panel, BorderLayout.CENTER);
	}


    private void habilitarBtns() {
		alterarCadastroBtn.setEnabled(true);
		removerCadastroBtn.setEnabled(true);
	}

	private void desabilitarBtns() {
		alterarCadastroBtn.setEnabled(false);
		removerCadastroBtn.setEnabled(false);
	}
}
