package br.sc.senac.dd.aula04.exercicio.model.vo;

public class CarroceriaVO {
	
	private double capacidadeCargaQuilos;

	public CarroceriaVO(double capacidadeCargaQuilos) {
		super();
		this.capacidadeCargaQuilos = capacidadeCargaQuilos;
	}
	
	public CarroceriaVO() {
		super();
	}

	public double getCapacidadeCargaQuilos() {
		return capacidadeCargaQuilos;
	}

	public void setCapacidadeCargaQuilos(double capacidadeCargaQuilos) {
		this.capacidadeCargaQuilos = capacidadeCargaQuilos;
	}

	
}
