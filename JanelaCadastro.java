package CRUD_JFRAME;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BANCO.Conexao;
import MODELO.Funcionarios;


@SuppressWarnings("serial")
public class JanelaCadastro extends JFrame implements ItemListener, ActionListener {
	
	JTextField cnome,ccargo,ccpf,ccep,cncasa,cbairro,ccidade,cnomeend;
	JLabel labelnome,labelcargo,labelcpf,labelcep,labelncasa,labelbairro,labelcidade,labelestado,labellogradouro;
	JComboBox<String> comboestado;
	JButton confirmar,cancelar,consultar,limparcampos;
	String vcnome,vccargo,vccpf,vccep,vcncasa,vcnomeend,vcbairro,vccidade,vcestado;
		
	public JanelaCadastro() {
		super("Cadastro");
		
		confirmar = new JButton("Confirmar");
		confirmar.addActionListener(this);
		confirmar.setToolTipText("Validar o Cadastro");
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		cancelar.setToolTipText("Voltar ao menu anterior");
		consultar = new JButton("Consultar Cadastros");
		consultar.addActionListener(this);
		consultar.setToolTipText("Procurar colaborador ja existente");
		limparcampos = new JButton("Limpar");
		limparcampos.addActionListener(this);
		limparcampos.setToolTipText("Limpa toda a informação já inserida");
		
		labelnome = 		new JLabel("NOME: ");
		labelnome.setToolTipText("Nome e sobrenome. EX: Joao da Silva Oliveira");
		labelcargo = 	new JLabel("Cargo: ");
		labelcargo.setToolTipText("Area na qual ele atuará. EX: Tecnologia da Informação");
		labelcpf = 		new JLabel("CPF:");
		labelcpf.setToolTipText("Numero sem pontos. EX: 12345678901");
		labelcep = 		new JLabel("CEP:");
		labelcep.setToolTipText("Numero sem pontos. EX: 12345678");
		labelncasa = 	new JLabel("Nº: ");
		labelncasa.setToolTipText("Numero sem complementos. EX: 90/10");
		labelbairro = 	new JLabel("Bairro: ");
		labelbairro.setToolTipText("Bairro no qual ele reside. EX: Liberdade/Bela Vista");
		labelcidade = 	new JLabel("Cidade: ");
		labelcidade.setToolTipText("Cidade no qual ele reside. EX: Sao Paulo/Osasco");
		labelestado = 	new JLabel("Estado: ");
		labelestado.setToolTipText("Selecione nas opções a seguir");
		labellogradouro= new JLabel("Rua/Avenida: ");
		labellogradouro.setToolTipText("Logradouro de onde ele reside");
		
		cnome =		new JTextField();
		ccargo =	new JTextField();
		ccpf =		new JTextField();
		ccep =		new JTextField();
		cncasa =	new JTextField();
		cbairro =	new JTextField();
		ccidade =	new JTextField();
		cnomeend =	new JTextField();
		
		comboestado = new JComboBox<String>();
		comboestado.setFont(new Font("Serif", Font.PLAIN, 15));
		comboestado.addItem("SELECIONE O ESTADO");
		comboestado.addItem("AC");
		comboestado.addItem("AL");
		comboestado.addItem("AP");
		comboestado.addItem("AM");
		comboestado.addItem("BA");
		comboestado.addItem("CE");
		comboestado.addItem("DF");
		comboestado.addItem("ES");
		comboestado.addItem("GO");
		comboestado.addItem("MA");
		comboestado.addItem("MT");
		comboestado.addItem("MS");
		comboestado.addItem("MG");
		comboestado.addItem("PA");
		comboestado.addItem("PB");
		comboestado.addItem("PR");
		comboestado.addItem("PE");
		comboestado.addItem("PI");
		comboestado.addItem("RJ");
		comboestado.addItem("RN");
		comboestado.addItem("RS");
		comboestado.addItem("RO");
		comboestado.addItem("RR");
		comboestado.addItem("SC");
		comboestado.addItem("SP");
		comboestado.addItem("SE");
		comboestado.addItem("TO");
		comboestado.addItemListener(this);
		
		Container c1 = new JPanel();
		c1.setLayout(new GridLayout(1, 4));		
		c1.add(limparcampos);
		c1.add(consultar);		
		c1.add(cancelar);		
		c1.add(confirmar);		
		
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(9,2));
		c2.add(labelnome);
		c2.add(cnome);
		c2.add(labelcargo);
		c2.add(ccargo);
		c2.add(labelcpf);
		c2.add(ccpf);
		c2.add(labellogradouro);
		c2.add(cnomeend);
		c2.add(labelncasa);
		c2.add(cncasa);
		c2.add(labelcep);
		c2.add(ccep);
		c2.add(labelbairro);
		c2.add(cbairro);
		c2.add(labelcidade);
		c2.add(ccidade);
		c2.add(labelestado);
		c2.add(comboestado);
		
		Container c3 = new JPanel();
		c3.setLayout(new GridLayout(1,1));
		c3.add(new JLabel("Posicione o mouse em cima do nome para maior informações"));
		
		Container contpri = getContentPane();
		contpri.add(BorderLayout.SOUTH, c1);
		contpri.add(BorderLayout.CENTER, c2);
		contpri.add(BorderLayout.NORTH, c3);
		
		setBounds(400, 150, 500, 300);
		setVisible(true);
		
		
			
		Funcionarios func = new Funcionarios();
		
		func.getNome();
		func.getCargo();
		func.getCpf();
		func.getNomeend();
		func.getNumero();
		func.getBairro();
		func.getCidade();
		func.getEstado();
		func.getCep();
		
	}

		//FUNÇÃO DOS BOTÕES
	public void itemStateChanged(ItemEvent combocombo) {
		
		if(combocombo.getStateChange()==ItemEvent.SELECTED) {
			vcestado = (String) comboestado.getSelectedItem();			
		}		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==confirmar) {
			
			int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo Cadastrar o novo colaborador? ","CADASTRO",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			if(i==0) {									
			
			vcnome = cnome.getText();
			vccargo = ccargo.getText();
			vccpf = ccpf.getText();
			vccep = ccep.getText();
			vcncasa = cncasa.getText();
			vcnomeend = cnomeend.getText();
			vcbairro = cbairro.getText();
			vccidade = ccidade.getText();
			
			Connection con = Conexao.obterConexao();
			
			String sql = "INSERT INTO FUNCIONARIOS (NOME, CARGO ,CPF,NOMEEND, BAIRRO, CIDADE, ESTADO, CEP, NUMERO) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			
				try {
		
						PreparedStatement preparador = con.prepareStatement(sql);
		
						preparador.setString(1, vcnome);
						preparador.setString(2, vccargo);
						preparador.setString(3, vccpf);
						preparador.setString(4, vcnomeend);
						preparador.setString(5, vcbairro);
						preparador.setString(6, vccidade);
						preparador.setString(7, vcestado);
						preparador.setString(8, vccep);
						preparador.setString(9, vcncasa);
		
						preparador.execute();
						preparador.close();
		
						JOptionPane.showMessageDialog(null, "COLABORADOR CADASTRADO !");
		
					}catch (SQLException zorra) {
					JOptionPane.showMessageDialog(null, "COLABORADOR NÃO CADASTRADO ! \n CAMPOS INVALIDOS.");
					}
			
			}else{
					
					cnome.setText("");
					ccargo.setText("");
					ccpf.setText("");
					ccep.setText("");
					cncasa.setText("");
					cbairro.setText("");
					ccidade.setText("");
					cnomeend.setText("");
				
			}
		}
		
		if(e.getSource()==limparcampos) {
			
			cnome.setText("");
			ccargo.setText("");
			ccpf.setText("");
			ccep.setText("");
			cncasa.setText("");
			cbairro.setText("");
			ccidade.setText("");
			cnomeend.setText("");
			
		}
		
		if(e.getSource()==cancelar) {
			JanelaCadastro.this.dispose();				//FECHA A JANELA SEM ENCERRAR O PROGRAMA 
		}
		
		if(e.getSource()==consultar) {
			new JanelaMostrar();
		}
	}			
}

