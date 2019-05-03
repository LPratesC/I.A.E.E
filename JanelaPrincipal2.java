package Programa;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import CRUD_JFRAME.JanelaAlteracao;
import CRUD_JFRAME.JanelaCadastro;
import CRUD_JFRAME.JanelaExcluir;
import CRUD_JFRAME.JanelaMostrar;
import CRUD_JFRAME.JanelaMostrarTudo;

@SuppressWarnings("serial")
public class JanelaPrincipal2 extends JFrame implements ActionListener {
	
	JButton novocadastro,excluircadastro,procurarcadastro,exibirtodos,alterar,fecharpgrm;
	JLabel area;
	
	ImageIcon icon = new ImageIcon(getClass().getResource("logo.jpg"));	
	
	public JanelaPrincipal2() {
		
		super("E.A.I.I");

		area = new JLabel(icon);												
		area.setToolTipText("E.A.I.I");
		
		novocadastro = new JButton("Cadastrar novo Colaborador");
		novocadastro.addActionListener(this);
		novocadastro.setToolTipText("Janela de Cadastro para novos colaboradores");
		
		alterar = new JButton("Alterar Cadastro");
		alterar.addActionListener(this);
		alterar.setToolTipText("Janela para auteração de um Colaborador cadastrado");

		excluircadastro = new JButton("Excluir Colaborador Cadastrado");
		excluircadastro.addActionListener(this);
		excluircadastro.setToolTipText("Janela para exclusão de um Colaboradorcadastrado?");
		
		procurarcadastro = new JButton("Procurar por Colaborador");
		procurarcadastro.addActionListener(this);
		procurarcadastro.setToolTipText("Janela para procura de um usuario cadastrado");
		
		exibirtodos = new JButton("Exibir todos os Registros");
		exibirtodos.addActionListener(this);
		exibirtodos.setToolTipText("Janela para exibição de todos os registros");
		
		fecharpgrm = new JButton("Fechar programa");
		fecharpgrm.addActionListener(this);
		fecharpgrm.setToolTipText("Deseja encerrar o programa ? ");
		

		Container c1 = new JPanel();
		c1.setLayout(new GridLayout(6, 1));		
		c1.add(novocadastro);
		c1.add(alterar);
		c1.add(excluircadastro);		
		c1.add(procurarcadastro);
		c1.add(exibirtodos);
		c1.add(fecharpgrm);	
		
		Container c2 = getContentPane();
		c2.setLayout(new BorderLayout());					
		c2.add(area);
		c2.add(BorderLayout.EAST, c1);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 600, 400);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent acaobotao) {
		
		if(acaobotao.getSource()==novocadastro) {
			new JanelaCadastro();
		}
		
		if(acaobotao.getSource()==alterar) {
			new JanelaAlteracao();
		}
		
		if(acaobotao.getSource()==excluircadastro) {
			new JanelaExcluir();
		}
		
		if(acaobotao.getSource()==procurarcadastro) {
			new JanelaMostrar();
		}
		
		if(acaobotao.getSource()==exibirtodos) {
			new JanelaMostrarTudo();
		}
		
		if(acaobotao.getSource()==fecharpgrm)	{
			
			int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo fechar o programa","Sair",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if (i==0) {
			System.exit(0);
			}
		}
	}
}
