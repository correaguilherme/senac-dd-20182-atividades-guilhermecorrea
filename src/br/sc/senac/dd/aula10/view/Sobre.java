package br.sc.senac.dd.aula10.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Sobre extends JPanel {

	/**
	 * Create the panel.
	 */
	public Sobre() {
		setLayout(null);
		
		JLabel lblSobre = new JLabel("Sobre");
		lblSobre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSobre.setBounds(197, 43, 44, 16);
		add(lblSobre);
		
		JLabel lblSoftwareDesenvolvidoPor = new JLabel("Software desenvolvido por Guilherme Corr\u00EAa");
		lblSoftwareDesenvolvidoPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoftwareDesenvolvidoPor.setBounds(92, 109, 264, 16);
		add(lblSoftwareDesenvolvidoPor);

	}

}
