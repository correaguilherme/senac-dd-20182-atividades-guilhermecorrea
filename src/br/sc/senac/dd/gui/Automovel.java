package br.sc.senac.dd.gui;

public class Automovel {
	
	private String modelo;
	private int peso;
	private String cor;
	private int rodas;
	private int ano;
	private int cilindradas;
	
	public Automovel() {
		super();
	}
	
	public Automovel(String modelo, int peso, String cor, int rodas, int ano, int cilindradas) {
		super();
		this.modelo = modelo;
		this.peso = peso;
		this.cor = cor;
		this.rodas = rodas;
		this.ano = ano;
		this.cilindradas = cilindradas;
		this.modelo = modelo;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getRodas() {
		return rodas;
	}
	public void setRodas(byte rodas) {
		this.rodas = rodas;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(short ano) {
		this.ano = ano;
	}
	public int getCilindradas() {
		return cilindradas;
	}
	public void setCilindradas(short cilindradas) {
		this.cilindradas = cilindradas;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
		

}
