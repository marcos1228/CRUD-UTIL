package ENTIDADES;

import java.io.Serializable;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = -1481628775029010516L;

	private Long id;
	private String nome;
	private String bairro;
	private String cpf;
	private String endereco;
	private String pessoa;
	private String sexo;
	public Pessoa() {
		super();
	}

	public Pessoa(Long id, String nome, String bairro, String cpf, String endereco, String pessoa, String sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.bairro = bairro;
		this.cpf = cpf;
		this.endereco = endereco;
		this.pessoa = pessoa;
		this.sexo = sexo;
	}
	
	

	public Pessoa(String nome, String bairro, String cpf, String endereco, String sexo) {
		super();
		this.nome = nome;
		this.bairro = bairro;
		this.cpf = cpf;
		this.endereco = endereco;
		this.sexo = sexo;
	}

	public Pessoa(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}
	
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String object) {
		this.sexo = object;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", bairro=");
		builder.append(bairro);
		builder.append(", rua=");
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", pessoa=");
		builder.append(pessoa);
		builder.append("]");
		return builder.toString();
	}

	

}
