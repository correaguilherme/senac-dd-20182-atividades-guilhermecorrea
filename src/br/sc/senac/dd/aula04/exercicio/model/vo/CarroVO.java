package br.sc.senac.dd.aula04.exercicio.model.vo;

public class CarroVO extends AutomovelVO {

		private String categoria;
		private String numeroPortas;
		
		public CarroVO(int id, String marca, String modelo, String anoFabricacao, String chassi) {
			super(id, marca, modelo, anoFabricacao, chassi, AutomovelVO.NUMERO_RODAS_CARRO);
		}

		public CarroVO() {
			super();
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public String getNumeroPortas() {
			return numeroPortas;
		}

		public void setNumeroPortas(String numeroPortas) {
			this.numeroPortas = numeroPortas;
		}
		
		@Override
		public String toString(){
			//TODO fazer mais completo
			return "Carro ("+ this.getId() + "," + this.getMarca() + " - " + this.getModelo() + ")"; 
		}
	}