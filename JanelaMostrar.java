package CRUD_JFRAME;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BANCO.Conexao;
import MODELO.Funcionarios;

@SuppressWarnings("serial")
public class JanelaMostrar extends JFrame {
	
	JButton btnVoltar;
	JLabel label;
	Connection conec;
	
	public JanelaMostrar() {
		super("Janela Pesquisar");
		
		
		conec = Conexao.obterConexao();
		ArrayList<Funcionarios> listaFunc = new ArrayList<Funcionarios>();
		
		String re = JOptionPane.showInputDialog("DIGITE O RE DO COLABORADOR");
		
		String sql = "SELECT * FROM FUNCIONARIOS WHERE RE = ?";
		
		try {
			PreparedStatement preparador = conec.prepareStatement(sql);
			
			preparador.setString(1, re);

			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				Funcionarios func = new Funcionarios();
				func.setRe(resultado.getInt("RE"));
				func.setNome(resultado.getString("NOME"));
				func.setCargo(resultado.getString("Cargo"));
				func.setCpf(resultado.getString("CPF"));
				func.setNomeend(resultado.getString("Nomeend"));
				func.setBairro(resultado.getString("Bairro"));
				func.setCidade(resultado.getString("Cidade"));
				func.setEstado(resultado.getString("Estado"));
				func.setCep(resultado.getInt("CEP"));
				func.setNumero(resultado.getInt("Numero"));
				
				listaFunc.add(func);
				
				String dadosre = "RE: " + func.getRe();
				String dadosnome = "Nome: " + func.getNome();
				String dadoscargo = "Cargo: " + func.getCargo();
				String dadoscpf = "CPF: " + func.getCpf();
				String dadosnomeend = "Endereço: " + func.getNomeend();
				String dadosbairro = "Bairro: " + func.getBairro();
				String dadoscidade = "Cidade: " + func.getCidade();
				String dadosestado = "Estado: " + func.getEstado();
				String dadoscep = "CEP: " + func.getCep();
				String dadosnumero = "Numero: " + func.getNumero();
				
				
				String dados = dadosre + "\n" + dadosnome + "\n" + dadoscargo + "\n" + dadoscpf + "\n" + dadosnomeend + "\n" + dadosnumero + "\n" + dadosbairro 
						+ "\n" + dadoscidade + "\n" + dadosestado + "\n" + dadoscep;
				JOptionPane.showMessageDialog(null, dados);
			}else {
				JOptionPane.showMessageDialog(null, "Colaborador não encontrado!");
			}
		}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Colaborador não encontrado!");
		}
		
	}
}