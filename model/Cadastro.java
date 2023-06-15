package model;
public class Cadastro {
    private int id;
    private String nome; 
    private String idade;
    private String email;
    private String endereco;
    private String cep;
    private String telefone;
    private String usuario;
    private String senha;
    private String curso;
    private String observacao;
    private String ativo;

    public String getAtivo() {
        return ativo;
    }
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    @Override
    public String toString() {
        return String.format("%d: %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %b", 
        id, nome, idade, email, endereco, cep, telefone, usuario, senha, curso, observacao, ativo);
    }
    @Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		Cadastro cadastro = (Cadastro) obj;
		return id == cadastro.id;
	}
}