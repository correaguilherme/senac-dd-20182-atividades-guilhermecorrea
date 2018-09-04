package br.sc.senac.dd.aula04.exercicio.model.vo;

public class MotoVO extends AutomovelVO {

	public MotoVO(int id, String marca, String modelo, String anoFabricacao, String chassi) {
		super(id, marca, modelo, anoFabricacao, chassi, AutomovelVO.NUMERO_RODAS_MOTO_PADRAO);
	}

	public MotoVO() {
		super();
	}
}