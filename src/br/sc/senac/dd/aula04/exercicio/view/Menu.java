package br.sc.senac.dd.aula04.exercicio.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.sc.senac.dd.aula04.exercicio.model.vo.CaminhaoVO;
import br.sc.senac.dd.aula04.exercicio.model.vo.CarroVO;

public class Menu {

	private static final int OPCAO_CADASTRAR_CARRO = 1;
	private static final int OPCAO_CADASTRAR_CAMINHAO = 2;
	private static final int OPCAO_CADASTRAR_MOTO = 3;
	private static final int OPCAO_LISTAR_CARRO_OU_CAMINHAO = 4;
	private static final int OPCAO_LISTAR_MOTOS = 5;
	private static final int OPCAO_SAIR = 6;

	private static List<CarroVO> carros = new ArrayList<CarroVO>();

	public void apresentarMenu(){
		try{
			int opcaoMenu = -1;
			
			while(opcaoMenu != OPCAO_SAIR){
				String mensagemMenu = construirMenu();
				String opcao = JOptionPane.showInputDialog(null, mensagemMenu, "T�tulo", JOptionPane.INFORMATION_MESSAGE);
				opcaoMenu = Integer.parseInt(opcao);
				
				switch (opcaoMenu) {
				case OPCAO_CADASTRAR_CARRO:
					cadastrarCarro();
					apresentarMenu();
					break;
				case OPCAO_CADASTRAR_CAMINHAO:
					cadastrarCaminhao();
					apresentarMenu();
					break;
				case OPCAO_CADASTRAR_MOTO:
					cadastrarMoto();
					apresentarMenu();
					break;	
				case OPCAO_LISTAR_CARRO_OU_CAMINHAO:
					mostrarCarroOuCaminhao();
					apresentarMenu();
					break;
				case OPCAO_LISTAR_MOTOS:
					mostrarMotos();
					apresentarMenu();
					break;
				default:
					mostrarMensagemOpcaoInvalida();
					apresentarMenu();
					break;
				}
			}
			mostrarMensagemSaida();
		}catch(NumberFormatException ex){
			//TODO tratar
		}
	}

	private void mostrarMensagemOpcaoInvalida() {
		// TODO Auto-generated method stub
		
	}

	private void mostrarMensagemSaida() {
		// TODO Auto-generated method stub

	}

	private void mostrarMotos() {
		// TODO Auto-generated method stub

	}

	private void mostrarCarroOuCaminhao() {
		String chassiInformado = JOptionPane.showInputDialog("Informe o chassi");
		
		CarroVO carro = obterCarroPorChassi(chassiInformado);
		CaminhaoVO caminhao = obterCaminhaoPorChassi(chassiInformado);
		
		String mensagem = "";
		
		if(carro != null){
			mensagem = carro.toString();
		}else if (caminhao != null){
			mensagem = caminhao.toString();
		}else{
			mensagem = "Ve�culo n�o encontrado";
		}
		
		JOptionPane.showMessageDialog(null, mensagem);
	}

	private CaminhaoVO obterCaminhaoPorChassi(String chassiInformado) {
		// TODO Auto-generated method stub
		return null;
	}

	private CarroVO obterCarroPorChassi(String chassiInformado) {
		
		CarroVO carroComChassiBuscado = null;
		for(CarroVO c: carros){
			if(c.getChassi().equals(chassiInformado)){
				carroComChassiBuscado = c;
				break;
			}
		}
		
		return carroComChassiBuscado;
	}

	private void cadastrarMoto() {
		// TODO Auto-generated method stub

	}

	private void cadastrarCaminhao() {
		// TODO Auto-generated method stub

	}

	private void cadastrarCarro(){
		int id = -1;
		try{
			id = Integer.parseInt(JOptionPane.showInputDialog("Informe o identificador:"));
		}catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Chassi deve ser um n�mero inteiro",
					"Aten��o", JOptionPane.ERROR_MESSAGE, null);
		}
		String modelo = JOptionPane.showInputDialog("Informe o modelo:");
		String chassi = JOptionPane.showInputDialog("Informe o chassi:");
		String anoFabricacao = JOptionPane.showInputDialog("Informe o ano:");
		String marca = JOptionPane.showInputDialog("Informe o marca:");

		if(id == -1 || modelo == null || chassi == null
				|| anoFabricacao == null || marca == null){
			//Cancelar no JOptionPane retorna uma string nula
			apresentarMenu();
		}else{
			CarroVO novoCarro = new CarroVO(id, marca, modelo, anoFabricacao, chassi);

			if(listaCarrosNaoContem(id)){
				carros.add(novoCarro);
			}else{
				JOptionPane.showMessageDialog(null, "Carro j� cadastrado",
						"Aten��o", JOptionPane.ERROR_MESSAGE, null);
			}
		}
	}

	private boolean listaCarrosNaoContem(int idNovoCarro) {
		boolean naoContem = true;

		for(CarroVO c: carros){
			if(c.getId() == idNovoCarro){
				naoContem = false;
				break;
			}
		}

		return naoContem;
	}

	private String construirMenu() {
		String mensagem = "Exerc�cio 4";
		mensagem += "\n Op��es:";
		mensagem += "\n 1 - Cadastrar carro";
		mensagem += "\n 2 - Cadastrar moto";
		mensagem += "\n 3 - Cadastrar caminh�o";
		mensagem += "\n 4 - Exibir caminh�o e carro por chassi";
		mensagem += "\n 5 - Exibir todas as motos";
		mensagem += "\n 6 - Sair";
		mensagem +="\n Digite a Op��o: ";

		return mensagem;
	}
}
