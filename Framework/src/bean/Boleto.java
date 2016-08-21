package bean;

import java.util.Calendar;
import java.util.Date;

import annotation.Length;
import annotation.NotNull;
import annotation.PeriodFromCurrentTime;
import annotation.Regex;

public class Boleto {
	
	public Boleto(){}
	
	public Boleto(String nome, String banco, double valor, Date vencimento, Calendar vencimentoAsCalendar, String vencimentoAsString) {
		super();
		this.nome = nome;
		this.banco = banco;
		this.valor = valor;
		this.vencimento = vencimento;
		this.vencimentoAsCalendar = vencimentoAsCalendar;
		this.vencimentoAsString = vencimentoAsString;
	}

	@NotNull
	@Length(min=3, max=20)
	private String nome;
	
	@NotNull
	@Length(min=3, max=20)
	private String banco;
	
	private double valor;
	
	@NotNull
	@PeriodFromCurrentTime(numberOfDays=1)
	private Date vencimento;
	
	@NotNull
	@PeriodFromCurrentTime(numberOfDays=3)
	private Calendar vencimentoAsCalendar;
	
//	@CheckDays(numberOfDays=4)
//	@Length(min=3, max=20)
//	@IntRange(min=0, max=150)
	private String teste;
	
	@Regex(regex="\\d{2}/\\d{2}/\\d{4}")
	private String vencimentoAsString;

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

	public String getVencimentoAsString() {
		return vencimentoAsString;
	}

	public void setVencimentoAsString(String vencimentoAsString) {
		this.vencimentoAsString = vencimentoAsString;
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}
	
	
}
