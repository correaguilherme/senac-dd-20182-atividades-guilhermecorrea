package br.sc.senac.dd.aula04.exercicio.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.sc.senac.dd.aula04.exercicio.controller.ControladoraCarro;
import br.sc.senac.dd.aula04.exercicio.controller.ControladoraMoto;
import br.sc.senac.dd.aula04.exercicio.model.vo.CaminhaoVO;
import br.sc.senac.dd.aula04.exercicio.model.vo.CarroVO;
import br.sc.senac.dd.aula04.exercicio.model.vo.MotoVO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Menu {

	private static final int OPCAO_CADASTRAR_CARRO = 1;
	private static final int OPCAO_CADASTRAR_CAMINHAO = 2;
	private static final int OPCAO_CADASTRAR_MOTO = 3;
	private static final int OPCAO_LISTAR_CARRO_OU_CAMINHAO = 4;
	private static final int OPCAO_LISTAR_MOTOS = 5;
	private static final int OPCAO_SAIR = 6;

	private static List<CarroVO> carros = new ArrayList<CarroVO>();
	private static List<MotoVO> motos = new ArrayList<MotoVO>();
	private static List<CaminhaoVO> caminhoes = new ArrayList<CaminhaoVO>();
	
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
                                case OPCAO_SAIR:
					mostrarMensagemSaida();
					break;
				default:
					mostrarMensagemOpcaoInvalida();
					apresentarMenu();
					break;
				}
			}
		}catch(NumberFormatException ex){
			//TODO tratar
		}
	}

	private void mostrarMensagemOpcaoInvalida() {
		JOptionPane.showMessageDialog(null, "Op��o Invalida!");
		
	}

	private void mostrarMensagemSaida() {
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Fechar sistema", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else if (resposta == JOptionPane.NO_OPTION) {
                apresentarMenu();
                }
	}

	private void mostrarMotos() {
		ControladoraMoto controladoraMoto = new ControladoraMoto();
            try {
                List<MotoVO> motos = controladoraMoto.consultarTodasMotosController();
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
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
		CaminhaoVO caminhaoComChassiBuscado = null;
		for(CaminhaoVO c: caminhoes){
			if(c.getChassi().equals(chassiInformado)){
				caminhaoComChassiBuscado = c;
				break;
			}
		}
		
		return caminhaoComChassiBuscado;
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
			MotoVO novaMoto = new MotoVO(id, marca, modelo, anoFabricacao, chassi);

			if(listaMotosNaoContem(id)){
				motos.add(novaMoto);
			}else{
				JOptionPane.showMessageDialog(null, "Moto j� cadastrada",
						"Aten��o", JOptionPane.ERROR_MESSAGE, null);
			}
		}
	}
	
	private boolean listaMotosNaoContem(int idNovaMoto) {
		boolean naoContem = true;

		for(MotoVO m: motos){
			if(m.getId() == idNovaMoto){
				naoContem = false;
				break;
			}
		}

		return naoContem;
	}

	private void cadastrarCaminhao() {
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
			CaminhaoVO novoCaminhao = new CaminhaoVO(id, marca, modelo, anoFabricacao, chassi);

			if(listaCaminhaoNaoContem(id)){
				caminhoes.add(novoCaminhao);
			}else{
				JOptionPane.showMessageDialog(null, "Caminhao j� cadastrado",
						"Aten��o", JOptionPane.ERROR_MESSAGE, null);
			}
		}
	}
	
	private boolean listaCaminhaoNaoContem(int idNovoCaminhao) {
		boolean naoContem = true;

		for(CaminhaoVO c: caminhoes){
			if(c.getId() == idNovoCaminhao){
				naoContem = false;
				break;
			}
		}

		return naoContem;
	}

	private void cadastrarCarro(){
		
		CarroVO carro = new CarroVO();
		
		carro.setModelo(JOptionPane.showInputDialog("Digite o modelo do carro"));
		
		carro.setChassi(JOptionPane.showInputDialog("Digite o chassi do carro"));
		
		carro.setAnoFabricacao(JOptionPane.showInputDialog("Digite o ano de fabrica��o do carro"));
		
		carro.setMarca(JOptionPane.showInputDialog("Digite a marca do carro"));
				
		ControladoraCarro controladoraCarro = new ControladoraCarro();
		try {
			controladoraCarro.cadastrarCarroController(carro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
		/* int id = -1;
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
	} */

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
		mensagem += "\n 2 - Cadastrar caminh�o";
		mensagem += "\n 3 - Cadastrar moto";
		mensagem += "\n 4 - Exibir caminh�o e carro por chassi";
		mensagem += "\n 5 - Exibir todas as motos";
		mensagem += "\n 6 - Sair";
		mensagem +="\n Digite a Op��o: ";

		return mensagem;
	}

    private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
