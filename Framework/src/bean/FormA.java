package bean;

import java.util.Date;

import annotation.IntRange;
import annotation.Length;
import annotation.NotNull;

public class FormA {
	
	@NotNull
	@Length(min=3, max=20)
	private String nome;
	
	@NotNull
	@IntRange(min=0, max=150)
	private int idade;
	
//	@NotNull
	private String rg;
	
//	@NotNull
	private String sexo;
	
//	@NotNull
	private Date dataNascimento;
	
	public FormA(String nome, int idade, String sexo) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	public FormA(){}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
}
