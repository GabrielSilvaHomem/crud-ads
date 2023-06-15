package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Cadastro;

public class CadastroTableModel extends AbstractTableModel {
    private List<Cadastro> cadastros = new ArrayList<Cadastro>();
	private String[] colunas = new String[] { "id", "Nome", "Idade", "E-mail", "Endereço", "CEP", "Telefone", "Curso", "Observacoes", "Ativo" };

    public CadastroTableModel(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}

    @Override
	public int getRowCount() {
		return cadastros.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String columnName = null;

		if (columnIndex >= 0 && columnIndex < colunas.length) {
			columnName = colunas[columnIndex];
		}
		return columnName;
	}

    @Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String value = null;
        
		if (rowIndex >= 0 && rowIndex < cadastros.size()) {
			Cadastro cadastro = cadastros.get(rowIndex);
			// ALTERAR ESSE MÉTODO PARA O ESCOPO DO PROJETO
		
			switch (columnIndex) {
			case 0:
				value = Integer.toString(cadastro.getId());
				break;
			case 1:
				value = cadastro.getNome();
				break;
			case 2:
				value = cadastro.getIdade();
				break;
			case 3:
				value = cadastro.getEmail();
				break;
			case 4:
				value = cadastro.getEndereco();
				break;
			case 5:
				value = cadastro.getCep();
				break;
			case 6:
				value = cadastro.getTelefone();
				break;
            case 7:
                value = cadastro.getCurso();
                break;
            case 8:
                value = cadastro.getObservacao();
                break;
			case 9:
				value = cadastro.getAtivo();   
                break;
            default:
				System.err.printf("[ERRO] Índice de coluna inválido: %d\n", columnIndex);
			} 
		}

		return value;
	 }

	public Cadastro getCadastro(int rowIndex) {
		Cadastro cadastro = null;

		if (rowIndex >= 0 && rowIndex < cadastros.size()) {
			cadastro = cadastros.get(rowIndex);
		}

		return cadastro;
	}

	public void carregar(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
		fireTableDataChanged();
	}

	public void remover(Cadastro cadastro) {
		cadastros.remove(cadastro);
		fireTableDataChanged();
	}

    

}

