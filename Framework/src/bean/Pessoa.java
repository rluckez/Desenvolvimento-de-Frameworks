package bean;

import annotation.IntRange;
import annotation.Length;
import annotation.NotNull;

public class Pessoa {
	
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
	
	public Pessoa(String nome, int idade, String sexo) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	public Pessoa(){}

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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
}
