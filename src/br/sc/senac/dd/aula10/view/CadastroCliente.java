package br.sc.senac.dd.aula10.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroCliente extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public CadastroCliente() {
		setLayout(null);
		
		JLabel lblCadastroDeCliente = new JLabel("Cadastro de Cliente");
		lblCadastroDeCliente.setBounds(135, 25, 123, 41);
		add(lblCadastroDeCliente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(91, 111, 56, 16);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(91, 140, 56, 16);
		add(lblCpf);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(91, 169, 56, 16);
		add(lblCep);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(12, 201, 123, 16);
		add(lblDataDeNascimento);
		
		textField = new JTextField();
		textField.setBounds(135, 108, 140, 22);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(135, 140, 140, 22);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(135, 169, 140, 22);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(135, 198, 140, 22);
		add(textField_3);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(145, 233, 97, 25);
		add(btnSalvar);

	}
}
