package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.Format;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
    private JComboBox ativoCb;
	private JButton salvarBtn;
	private JButton cancelarBtn;

	public CadastroFormPanel() {
	}
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
					cursoMenu.setSelectedIndex(0);
                    observacaoTxt.setText("");
				} else {
					idTxt.setText(Integer.toString(cadastro.getId()));
					nomeTxt.setText(cadastro.getNome());
                    idadeTxt.setText(Integer.toString(cadastro.getIdade()));
                    emailTxt.setText(cadastro.getEmail());
                    enderecoTxt.setText(cadastro.getEndereco());
					cepTxt.setText(cadastro.getCep());
                    telefoneTxt.setText(cadastro.getTelefone());
                    usuarioTxt.setText(cadastro.getUsuario());
                    senhaTxt.setText(cadastro.getSenha());
                    cursoMenu.setSelectedItem(cadastro.getCurso());
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

		rotulo = new JLabel("Id");
		adicionarComponente(rotulo, 0, 0);
		idTxt = new JTextField(30);
		idTxt.setEditable(false);
		idTxt.setDocument(new MaxCharDocument(50));
		adicionarComponente(idTxt, 0, 1);

		rotulo = new JLabel("Nome");
		adicionarComponente(rotulo, 1, 0);
		nomeTxt = new JTextField(30);
		nomeTxt.setDocument(new MaxCharDocument(50));
		adicionarComponente(nomeTxt, 1, 1);

		rotulo = new JLabel("Idade");
		adicionarComponente(rotulo, 2, 0);
		idadeTxt = new JTextField(5);
		idadeTxt.setDocument(new MaxCharDocument(3));
		adicionarComponente(idadeTxt, 2, 1);

		rotulo = new JLabel("E-mail");
		adicionarComponente(rotulo, 3, 0);
		emailTxt = new JTextField(30);
		emailTxt.setDocument(new MaxCharDocument(30));
		adicionarComponente(emailTxt, 3, 1);

		rotulo = new JLabel("Endereco");
		adicionarComponente(rotulo, 4, 0);
		enderecoTxt = new JTextField(30);
		enderecoTxt.setDocument(new MaxCharDocument(50));
		adicionarComponente(enderecoTxt, 4, 1);

		rotulo = new JLabel("CEP");
		adicionarComponente(rotulo, 5, 0);
		cepTxt = new JTextField(30);
		cepTxt.setDocument(new MaxCharDocument(8));
		adicionarComponente(cepTxt, 5, 1);

		rotulo = new JLabel("Telefone");
		adicionarComponente(rotulo, 6, 0);
		telefoneTxt = new JTextField(30);
		telefoneTxt.setDocument(new MaxCharDocument(11));
		adicionarComponente(telefoneTxt, 6, 1);

		rotulo = new JLabel("Usuario");
		adicionarComponente(rotulo, 7, 0);
		usuarioTxt = new JTextField(30);
		adicionarComponente(usuarioTxt, 7, 1);

		rotulo = new JLabel("Senha");
		adicionarComponente(rotulo, 8, 0);
		senhaTxt = new JPasswordField(30);
		senhaTxt.setDocument(new MaxCharDocument(30));
		adicionarComponente(senhaTxt, 8, 1);

		String[] itens = {"Selecione seu curso", "Ciencia da computacao", "Sistemas de Informacao", "Educacao Fisica", "Filosofia", "Matematica"};
		rotulo = new JLabel("Curso");
		adicionarComponente(rotulo, 9, 0);
		cursoMenu = new JComboBox<String>(itens);
		adicionarComponente(cursoMenu, 9, 1);

		rotulo = new JLabel("Observacao");
		adicionarComponente(rotulo, 10, 0);
		observacaoTxt = new JTextArea(5, 30);
		JScrollPane scrollPane = new JScrollPane(observacaoTxt);
		adicionarComponente(scrollPane, 10, 1, 1, 5);

		String[] ativo = {"Ativo", "Inativo"};
		rotulo = new JLabel("Ativo");
		adicionarComponente(rotulo, 16, 0);
		ativoCb = new JComboBox<String>(ativo);
		adicionarComponente(ativoCb, 16, 1);

		criarBotoes();
	}

    private void criarBotoes() {
		JPanel btnPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		criarSalvarBtn(btnPanel);
		criarCancelarBtn(btnPanel);

		adicionarComponente(btnPanel, 17, 1, 2, 1);
	}

	private void criarSalvarBtn(JPanel panel) {
		salvarBtn = new JButton("Salvar");
		salvarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cadastro == null || cadastro.getId() == 0) {
					cadastro = new Cadastro();
					if (verificarCampos(nomeTxt.getText(), "nome")) {
						return;
					}
					
					cadastro.setNome(nomeTxt.getText());
					try {
						cadastro.setIdade(Integer.parseInt(idadeTxt.getText()));
					} catch (Exception a) {
						JOptionPane.showMessageDialog(null, "Digite um número inteiro!");
						return;
					}	
					if (idadeTxt.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Digite um Número inteiro!");
						return;
					}
                    cadastro.setEmail(emailTxt.getText());
					if (verificarCampos(emailTxt.getText(), "email")) {
						return;
					}
                    cadastro.setEndereco(enderecoTxt.getText());
					if (verificarCampos(enderecoTxt.getText(), "endereço")) {
						return;
					}


					cadastro.setCep(cepTxt.getText());
                    cadastro.setTelefone(telefoneTxt.getText());


                    cadastro.setUsuario(usuarioTxt.getText());
					if (verificarCampos(usuarioTxt.getText(), "Usuário")) {
						return;
					}
					cadastro.setSenha(new String(senhaTxt.getPassword()));
					if (verificarCampos(new String(senhaTxt.getPassword()), "Senha")) {
						return;
					}
                    cadastro.setCurso(cursoMenu.getSelectedItem().toString());
					if (cursoMenu.getSelectedItem().toString() == "Selecione seu curso") {
						JOptionPane.showMessageDialog(null, "Digite um curso válido!");
						return;
					}

                    cadastro.setObservacao(observacaoTxt.getText());

					cadastro.setAtivo(ativoCb.getSelectedItem().toString());
					CadastroStorage.inserir(cadastro);

				} else {
					cadastro.setId(Integer.parseInt(idTxt.getText()));
					cadastro.setNome(nomeTxt.getText());
					if (verificarCampos(nomeTxt.getText(), "nome")) {
						return;
					}
					try {
						cadastro.setIdade(Integer.parseInt(idadeTxt.getText()));
					} catch (Exception a) {
						JOptionPane.showMessageDialog(null, "Digite um número inteiro!");
						return;
					}	
					if (idadeTxt.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Digite um Número inteiro!");
						return;
					}
                    cadastro.setEmail(emailTxt.getText());
					if (verificarCampos(emailTxt.getText(), "email")) {
						return;
					}
                    cadastro.setEndereco(enderecoTxt.getText());
					if (verificarCampos(enderecoTxt.getText(), "endereço")) {
						return;
					}


					cadastro.setCep(cepTxt.getText());
                    cadastro.setTelefone(telefoneTxt.getText());


                    cadastro.setUsuario(usuarioTxt.getText());
					if (verificarCampos(usuarioTxt.getText(), "Usuário")) {
						return;
					}
					cadastro.setSenha(new String(senhaTxt.getPassword()));
					if (verificarCampos(new String(senhaTxt.getPassword()), "Senha")) {
						return;
					}
                    cadastro.setCurso(cursoMenu.getSelectedItem().toString());
					if (cursoMenu.getSelectedItem().toString() == "Selecione seu curso") {
						JOptionPane.showMessageDialog(null, "Digite um curso válido!");
						return;
					}

                    cadastro.setObservacao(observacaoTxt.getText());

					cadastro.setAtivo(ativoCb.getSelectedItem().toString());
					
					CadastroStorage.atualizar(cadastro);

					

				}
				if (cadastro == null || cadastro.getId() == 0) {
					JOptionPane.showMessageDialog(CadastroFormPanel.this, "Cadastro realizado com sucesso!", AppFrame.titulo,
				JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(CadastroFormPanel.this, "Cadastro atualizado com sucesso!", AppFrame.titulo,
				JOptionPane.INFORMATION_MESSAGE);
				}

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

	private boolean verificarCampos (String campo,String nome){
		CadastroFormPanel cadastroFormPanel = new CadastroFormPanel();
		String mensagem = String.format("Digite corretamente o %s!",nome);
		campo = campo.trim();
		if (campo.isEmpty()) {
			JOptionPane.showMessageDialog(cadastroFormPanel,mensagem);
			return true;
		}
		return false;
	}
	
}