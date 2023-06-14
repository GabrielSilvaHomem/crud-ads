package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.html.Option;

import model.Cadastro;
import model.CadastroStorage;


public class CadastroFormPanel extends JPanel {
    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);
    
    private Cadastro cadastro;

	private AppFrame frame;

	private GridBagLayout layout;
	private GridBagConstraints constraints;

	private JTextField idTxt;
	private JTextField nomeTxt;
    private JTextField idadeTxt;
    private JTextField emailTxt;
    private JTextField enderecoTxt;
	private JTextField cepTxt;
    private JTextField telefoneTxt;
    private JTextField usuarioTxt;
    private JPasswordField senhaTxt;
    private JComboBox cursoMenu;
	private JTextArea observacaoTxt;
    private JRadioButton ativoRd;
	private JButton salvarBtn;
	private JButton cancelarBtn;

    public CadastroFormPanel(AppFrame appFrame) {
		frame = appFrame;

		cadastro = null;

		layout = new GridBagLayout();
		constraints = new GridBagConstraints();

		setLayout(layout);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if (cadastro == null) {
					idTxt.setText("");
					nomeTxt.setText("");
                    idadeTxt.setText("");
                    emailTxt.setText("");
                    enderecoTxt.setText("");
					cepTxt.setText("");
                    telefoneTxt.setText("");
                    usuarioTxt.setText("");
                    senhaTxt.setText("");
                    observacaoTxt.setText("");
                    ativoRd.setText("");
				} else {
					idTxt.setText(Integer.toString(cadastro.getId()));
					nomeTxt.setText(cadastro.getNome());
                    idadeTxt.setText(cadastro.getIdade());
                    emailTxt.setText(cadastro.getEmail());
                    enderecoTxt.setText(cadastro.getEndereco());
					cepTxt.setText(cadastro.getCep());
                    telefoneTxt.setText(cadastro.getTelefone());
                    usuarioTxt.setText(cadastro.getUsuario());
                    senhaTxt.setText(cadastro.getSenha());
                    cursoMenu.setToolTipText(cadastro.getCurso());
                    observacaoTxt.setText(cadastro.getObservacao());
          
				}
			}
		});

		criarForm();
	}

    public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	private void criarForm() {
		JLabel rotulo;
		// ALTERAR LISTA
		rotulo = new JLabel("Nome");
		adicionarComponente(rotulo, 0, 0);
		nomeTxt = new JTextField(30);
		nomeTxt.setDocument(new MaxCharDocument(50));
		adicionarComponente(nomeTxt, 0, 1);

		rotulo = new JLabel("Idade");
		adicionarComponente(rotulo, 1, 0);
		idadeTxt = new JTextField(5);
		idadeTxt.setDocument(new MaxCharDocument(3));
		adicionarComponente(idadeTxt, 1, 1);

		rotulo = new JLabel("E-mail");
		adicionarComponente(rotulo, 2, 0);
		emailTxt = new JTextField(30);
		emailTxt.setDocument(new MaxCharDocument(50));
		adicionarComponente(emailTxt, 2, 1);

		rotulo = new JLabel("Endereco");
		adicionarComponente(rotulo, 3, 0);
		enderecoTxt = new JTextField(30);
		enderecoTxt.setDocument(new MaxCharDocument(50));
		adicionarComponente(enderecoTxt, 3, 1);

		rotulo = new JLabel("CEP");
		adicionarComponente(rotulo, 4, 0);
		enderecoTxt = new JTextField(30);
		enderecoTxt.setDocument(new MaxCharDocument(50));
		adicionarComponente(enderecoTxt, 4, 1);

		rotulo = new JLabel("Telefone");
		adicionarComponente(rotulo, 5, 0);
		telefoneTxt = new JTextField(30);
		telefoneTxt.setDocument(new MaxCharDocument(9));
		adicionarComponente(telefoneTxt, 5, 1);

		rotulo = new JLabel("Usuario");
		adicionarComponente(rotulo, 6, 0);
		usuarioTxt = new JTextField(30);
		adicionarComponente(usuarioTxt, 6, 1);

		rotulo = new JLabel("Senha");
		adicionarComponente(rotulo, 7, 0);
		senhaTxt = new JPasswordField(30);
		senhaTxt.setDocument(new MaxCharDocument(50));
		adicionarComponente(senhaTxt, 7, 1);

		rotulo = new JLabel("Curso");
		adicionarComponente(rotulo, 8, 0);
		cursoMenu = new JComboBox();
		adicionarComponente(cursoMenu, 8, 1);

		rotulo = new JLabel("Observacao");
		adicionarComponente(rotulo, 9, 0);
		observacaoTxt = new JTextArea(5, 30);
		JScrollPane scrollPane = new JScrollPane(observacaoTxt);
		adicionarComponente(scrollPane, 9, 1, 1, 5);

		rotulo = new JLabel("Ativo");
		adicionarComponente(rotulo, 15, 0);
		ativoRd = new JRadioButton();
		adicionarComponente(ativoRd, 15, 1);
		
		criarBotoes();
	}

    private void criarBotoes() {
		JPanel btnPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		criarSalvarBtn(btnPanel);
		criarCancelarBtn(btnPanel);

		adicionarComponente(btnPanel, 16, 1, 2, 1);
	}

	private void criarSalvarBtn(JPanel panel) {
		salvarBtn = new JButton("Salvar");
		salvarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cadastro == null) {
					cadastro = new Cadastro();
					idadeTxt.setText(cadastro.getIdade());
                    emailTxt.setText(cadastro.getEmail());
                    enderecoTxt.setText(cadastro.getEndereco());
                    telefoneTxt.setText(cadastro.getTelefone());
                    usuarioTxt.setText(cadastro.getUsuario());
                    senhaTxt.setText(cadastro.getSenha());
                    cursoMenu.setToolTipText(cadastro.getCurso());
                    observacaoTxt.setText(cadastro.getObservacao());
					CadastroStorage.inserir(cadastro);
				} else {
					idTxt.setText(Integer.toString(cadastro.getId()));
					nomeTxt.setText(cadastro.getNome());
                    idadeTxt.setText(cadastro.getIdade());
                    emailTxt.setText(cadastro.getEmail());
                    enderecoTxt.setText(cadastro.getEndereco());
                    telefoneTxt.setText(cadastro.getTelefone());
                    usuarioTxt.setText(cadastro.getUsuario());
                    senhaTxt.setText(cadastro.getSenha());
                    cursoMenu.setToolTipText(cadastro.getCurso());
                    observacaoTxt.setText(cadastro.getObservacao());
				    CadastroStorage.atualizar(cadastro);
				}

				JOptionPane.showMessageDialog(CadastroFormPanel.this, "Cadastro realizado com sucesso!", AppFrame.titulo,
						JOptionPane.INFORMATION_MESSAGE);

				frame.mostrarListaCadastros();
			}
		});
		panel.add(salvarBtn);
	}

	private void criarCancelarBtn(JPanel panel) {
		cancelarBtn = new JButton("Cancelar");
		cancelarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarListaCadastros();
			}
		});
		panel.add(cancelarBtn);
	}

	private void adicionarComponente(JComponent componente, int linha, int coluna) {
		adicionarComponente(componente, linha, coluna, 1, 1);
	}

	private void adicionarComponente(JComponent componente, int linha, int coluna, int largura, int altura) {
		constraints.gridx = coluna;
		constraints.gridy = linha;
		constraints.gridwidth = largura;
		constraints.gridheight = altura;

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = FIELD_INSETS;

		layout.setConstraints(componente, constraints);
		add(componente);
	}
	
}