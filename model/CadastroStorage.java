package model;

import java.util.ArrayList;
import java.util.List;
public class CadastroStorage {
    private static int incremento = 0;
	private static List<Cadastro> cadastros = new ArrayList<>();

	public static void inserir(Cadastro cadastro) {
		cadastro.setId(++incremento);
		cadastros.add(cadastro);
	}

    public static void atualizar(Cadastro cadastro) {
		int i = cadastros.indexOf(cadastro);
		if (i >= 0) {
			cadastros.set(i, cadastro);
		}
	}

    public static void remover(Cadastro cadastro) {
		cadastros.remove(cadastro);
	}

    public static List<Cadastro> listar() {
		return cadastros;
	}
}
