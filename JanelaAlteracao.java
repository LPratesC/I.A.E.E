package CRUD_JFRAME;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BANCO.Conexao;

@SuppressWarnings("serial")
public class JanelaAlteracao extends JFrame implements ActionListener {
	
	JButton bnome,bcargo,bcpf,bcep,bncasa,bbairro,bcidade,bnomeend,bestado,botaovoltar,botaoprocurar;
	JButton btnVoltar;
	String re;
	
	public JanelaAlteracao() {
		super("Alterar dados colaborador...");
		
		re = JOptionPane.showInputDialog("Digite o RE do Colaborador:");
		
		if (re==null) {
			JOptionPane.showMessageDialog(null, "É necessario digitar o RE do colaborador.");
		}else {
		
		bnome = new JButton("Nome");
		bnome.addActionListener(this);
		bcargo = new JButton("Cargo");
		bcargo.addActionListener(this);
		bcpf = new JButton("CPF");
		bcpf.addActionListener(this);
		bcep = new JButton("cep");
		bcep.addActionListener(this);
		bncasa = new JButton("Casa");
		bncasa.addActionListener(this);
		bbairro = new JButton("Bairro");
		bbairro.addActionListener(this);
		bcidade = new JButton("Cidade");
		bcidade.addActionListener(this);
		bnomeend = new JButton("Nome rua/avenida");
		bnomeend.addActionListener(this);
		bestado = new JButton("Estado");
		bestado.addActionListener(this);
		
		btnVoltar = new JButton("Voltar ao menu anterior");
		btnVoltar.addActionListener(this);
		
		Container c1 = new Container();
		c1.setLayout(new FlowLayout());
		c1.add(bnome);
		c1.add(bcargo);
		c1.add(bcpf);
		c1.add(bnomeend);
		c1.add(bcep);
		c1.add(bncasa);
		c1.add(bbairro);
		c1.add(bcidade);
		c1.add(bestado);
		
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(1,1));
		c2.add(btnVoltar);
		
		Container c3 = new JPanel();
		c3.setLayout(new GridLayout(1,1));
		c3.add(new JLabel("Qual campo deseja alterar?"));
		
		Container contpri = getContentPane();
		contpri.add(BorderLayout.CENTER, c1);
		contpri.add(BorderLayout.NORTH, c3);
		contpri.add(BorderLayout.SOUTH, c2);
		
		
		setBounds(400, 150, 750, 180);									
		setVisible(true);
		}
	}
	public void actionPerformed(ActionEvent acaobotao) {
		
		if(acaobotao.getSource()==btnVoltar) {
			JanelaAlteracao.this.dispose();
		}
			
		if(acaobotao.getSource()==bnome) {
			
			String sql = "UPDATE FUNCIONARIOS SET NOME = ?  WHERE RE = ?";
			try {
				Connection conn = Conexao.obterConexao();
				PreparedStatement preparador = conn.prepareStatement(sql);
				
				String name = JOptionPane.showInputDialog(null, "Nome a ser alterado:", "Alteração", JOptionPane.QUESTION_MESSAGE);
				preparador.setString(1, name);
				preparador.setString(2,re);
				preparador.execute();
				preparador.close();
				
				JOptionPane.showMessageDialog(null, "Campo alterado com sucesso !", "Alteração", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar o campo", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
}
		
		if(acaobotao.getSource()==bcargo) {
					
					String sql = "UPDATE FUNCIONARIOS SET CARGO = ?  WHERE RE = ?";
					PreparedStatement preparador;
					try {
						Connection conn = Conexao.obterConexao();
						preparador = conn.prepareStatement(sql);
						
						String cargo = JOptionPane.showInputDialog(null, "Cargo a ser alterado:", "Alteração", JOptionPane.QUESTION_MESSAGE);
						preparador.setString(1, cargo);
						preparador.setString(2,re);
						preparador.execute();
						preparador.close();
						
						JOptionPane.showMessageDialog(null, "Campo alterado com sucesso !", "Alteração", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Erro ao atualizar o campo", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
}
		
		if(acaobotao.getSource()==bcpf) {
			
			String sql = "UPDATE FUNCIONARIOS SET CPF = ?  WHERE RE = ?";
			PreparedStatement preparador;
			try {
				Connection conn = Conexao.obterConexao();
				preparador = conn.prepareStatement(sql);
				
				String cpf = JOptionPane.showInputDialog(null, "CPF a ser alterado:", "Alteração", JOptionPane.QUESTION_MESSAGE);
				preparador.setString(1, cpf);
				preparador.setString(2,re);
				preparador.execute();
				preparador.close();
				
				JOptionPane.showMessageDialog(null, "Campo alterado com sucesso !", "Alteração", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar o campo", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
}
		
		if(acaobotao.getSource()==bcep) {
					
					String sql = "UPDATE FUNCIONARIOS SET CEP = ?  WHERE RE = ?";
					PreparedStatement preparador;
					try {
						Connection conn = Conexao.obterConexao();
						preparador = conn.prepareStatement(sql);
						
						String cep = JOptionPane.showInputDialog(null, "CEP a ser alterado:", "Alteração", JOptionPane.QUESTION_MESSAGE);
						preparador.setString(1, cep);
						preparador.setString(2,re);
						preparador.execute();
						preparador.close();
						
						JOptionPane.showMessageDialog(null, "Campo alterado com sucesso !", "Alteração", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Erro ao atualizar o campo", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
}
		if(acaobotao.getSource()==bncasa) {
			
			String sql = "UPDATE FUNCIONARIOS SET NUMERO = ?  WHERE RE = ?";
			PreparedStatement preparador;
			try {
				Connection conn = Conexao.obterConexao();
				preparador = conn.prepareStatement(sql);
				
				String numero = JOptionPane.showInputDialog(null, "Numero a ser alterado:", "Alteração", JOptionPane.QUESTION_MESSAGE);
				preparador.setString(1, numero);
				preparador.setString(2,re);
				preparador.execute();
				preparador.close();
				
				JOptionPane.showMessageDialog(null, "Campo alterado com sucesso !", "Alteração", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar o campo", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
}
		if(acaobotao.getSource()==bbairro) {
			
			String sql = "UPDATE FUNCIONARIOS SET BAIRRO = ?  WHERE RE = ?";
			PreparedStatement preparador;
			try {
				Connection conn = Conexao.obterConexao();
				preparador = conn.prepareStatement(sql);
				
				String bairro = JOptionPane.showInputDialog(null, "Bairro a ser alterado:", "Alteração", JOptionPane.QUESTION_MESSAGE);
				preparador.setString(1, bairro);
				preparador.setString(2,re);
				preparador.execute();
				preparador.close();
				
				JOptionPane.showMessageDialog(null, "Campo alterado com sucesso !", "Alteração", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar o campo", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
}
		if(acaobotao.getSource()==bcidade) {
			
			String sql = "UPDATE FUNCIONARIOS SET CIDADE = ?  WHERE RE = ?";
			PreparedStatement preparador;
			try {
				Connection conn = Conexao.obterConexao();
				preparador = conn.prepareStatement(sql);
				
				String cidade = JOptionPane.showInputDialog(null, "Cidade a ser alterado:", "Alteração", JOptionPane.QUESTION_MESSAGE);
				preparador.setString(1, cidade);
				preparador.setString(2,re);
				preparador.execute();
				preparador.close();
				
				JOptionPane.showMessageDialog(null, "Campo alterado com sucesso !", "Alteração", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar o campo", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
}
		if(acaobotao.getSource()==bnomeend) {
			
			String sql = "UPDATE FUNCIONARIOS SET NOMEEND = ?  WHERE RE = ?";
			PreparedStatement preparador;
			try {
				Connection conn = Conexao.obterConexao();
				preparador = conn.prepareStatement(sql);
				
				String nomeend = JOptionPane.showInputDialog(null, "Nome da rua a ser alterado:", "Alteração", JOptionPane.QUESTION_MESSAGE);
				preparador.setString(1, nomeend);
				preparador.setString(2,re);
				preparador.execute();
				preparador.close();
				
				JOptionPane.showMessageDialog(null, "Campo alterado com sucesso !", "Alteração", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar o campo", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
}
		
		if(acaobotao.getSource()==bestado) {
			
			String sql = "UPDATE FUNCIONARIOS SET ESTADO = ?  WHERE RE = ?";
			PreparedStatement preparador;
			try {
				Connection conn = Conexao.obterConexao();
				preparador = conn.prepareStatement(sql);
				
				String estado = JOptionPane.showInputDialog(null, "Estado a ser alterado:", "Alteração", JOptionPane.QUESTION_MESSAGE);
				preparador.setString(1, estado);
				preparador.setString(2,re);
				preparador.execute();
				preparador.close();
				
				JOptionPane.showMessageDialog(null, "Campo alterado com sucesso !", "Alteração", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar o campo", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}