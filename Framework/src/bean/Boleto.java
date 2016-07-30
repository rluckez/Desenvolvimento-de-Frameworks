package bean;

import java.util.Calendar;
import java.util.Date;

import annotation.CheckDays;
import annotation.Length;
import annotation.NotNull;

public class Boleto {
	
	public Boleto(){}
	
	public Boleto(String nome, String banco, double valor, Date vencimento, Calendar vencimentoAsCalendar) {
		super();
		this.nome = nome;
		this.banco = banco;
		this.valor = valor;
		this.vencimento = vencimento;
		this.vencimentoAsCalendar = vencimentoAsCalendar;
	}


	@NotNull
	@Length(min=3, max=20)
	private String nome;
	
	@NotNull
	@Length(min=3, max=20)
	private String banco;
	
	private double valor;
	
	@NotNull
	@CheckDays(numberOfDays=1)
	private Date vencimento;
	
	@NotNull
	@CheckDays(numberOfDays=3)
	private Calendar vencimentoAsCalendar;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Calendar getVencimentoAsCalendar() {
		return vencimentoAsCalendar;
	}

	public void setVencimentoAsCalendar(Calendar vencimentoAsCalendar) {
		this.vencimentoAsCalendar = vencimentoAsCalendar;
	}
	
	
}
