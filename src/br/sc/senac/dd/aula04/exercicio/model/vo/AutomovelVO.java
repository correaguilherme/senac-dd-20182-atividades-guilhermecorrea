package br.sc.senac.dd.aula04.exercicio.model.vo;

public abstract class AutomovelVO {
	
	//Constantes
	public static final int NUMERO_RODAS_MOTO_PADRAO = 2;
	public static final int NUMERO_RODAS_MOTO_TRICICLO = 3;
	public static final int NUMERO_RODAS_CARRO = 4;
	public static final int NUMERO_RODAS_CAMINHAO_PEQUENO = 6;
	public static final int NUMERO_RODAS_CAMINHAO_MEDIO = 10;
	public static final int NUMERO_RODAS_CAMINHAO_GRANDE = 18;
	
	private int id;
	private String marca;
	private String modelo;
	private String anoFabricacao;
	private String chassi;
	private int quantidadeRodas;
	
	public AutomovelVO(int id, String marca, String modelo, String anoFabricacao, String chassi, int quantidadeRodas) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.chassi = chassi;
		this.quantidadeRodas = quantidadeRodas;
	}
	
	public AutomovelVO(int id, String marca, String modelo, String anoFabricacao, String chassi) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.chassi = chassi;
		this.quantidadeRodas = quantidadeRodas;
	}
	
	public AutomovelVO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public int getQuantidadeRodas() {
		return quantidadeRodas;
	}
	public void setQuantidadeRodas(int quantidadeRodas) {
		this.quantidadeRodas = quantidadeRodas;
	}
}