package bean;

import annotation.Length;
import annotation.MyAnnotation;
import annotation.NotNull;

public class Bean {

	@MyAnnotation
	@Length(min=3, max=5)
	private String nome;
	
	@NotNull
	@MyAnnotation
	private int idade;
	
	public Bean(String nome, int idade, String sexo) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	public Bean(){}

	@NotNull
	private String sexo;

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
	
}
