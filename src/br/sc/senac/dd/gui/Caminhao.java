package br.sc.senac.dd.gui;

public class Caminhao extends Automovel {

	public Caminhao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Caminhao(String modelo, int peso, String cor, int rodas, int ano, int cilindradas) {
		super(modelo, peso, cor, rodas, ano, cilindradas);
		// TODO Auto-generated constructor stub
	}

	private Carroceria carroceria;

	public Carroceria getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(Carroceria carroceria) {
		this.carroceria = carroceria;
	}
	
	
	
}
