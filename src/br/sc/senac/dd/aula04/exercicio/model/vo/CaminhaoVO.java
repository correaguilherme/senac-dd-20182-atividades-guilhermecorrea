package br.sc.senac.dd.aula04.exercicio.model.vo;

public class CaminhaoVO extends AutomovelVO {

	private static final double CAPACIDADE_DEZ_TONELADAS = 0;
	private CarroceriaVO carroceria;
	private int numeroEixos;
	
	public CaminhaoVO(int id, String marca, String modelo, 
			String anoFabricacao, String chassi) {
		super(id, marca, modelo, anoFabricacao, chassi);

		this.carroceria = carroceria;
		
		if(this.getCarroceria().getCapacidadeCargaQuilos() > CAPACIDADE_DEZ_TONELADAS){
			this.numeroEixos = 4;
			this.setQuantidadeRodas(AutomovelVO.NUMERO_RODAS_CAMINHAO_GRANDE);
		}else{
			this.numeroEixos = 3;
			this.setQuantidadeRodas(AutomovelVO.NUMERO_RODAS_CAMINHAO_MEDIO);
		}
		
	}

	public CaminhaoVO() {
		super();
	}

	public CarroceriaVO getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(CarroceriaVO carroceria) {
		this.carroceria = carroceria;
	}

	public int getNumeroEixos() {
		return numeroEixos;
	}

	public void setNumeroEixos(int numeroEixos) {
		this.numeroEixos = numeroEixos;
	}

}
