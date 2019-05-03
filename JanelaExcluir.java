package CRUD_JFRAME;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import BANCO.Conexao;
import MODELO.Funcionarios;

@SuppressWarnings("serial")
public class JanelaExcluir extends JFrame {

	String dados;
	int confirmacao;
	public JanelaExcluir() {
			
		Connection conec = Conexao.obterConexao();
		
		ArrayList<Funcionarios> listaFunc = new ArrayList<Funcionarios>();
		
		String num = JOptionPane.showInputDialog("DIGITE O RE DO COLABORADOR");
		
		String sql = "SELECT * FROM FUNCIONARIOS WHERE RE = ?";
		
		try {
			PreparedStatement preparador = conec.prepareStatement(sql);
			
			preparador.setString(1, num);

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
				dados = dadosre + "\n" + dadosnome + "\n" + dadoscargo;
				
				confirmacao =JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir este colaborador?\n" + dados ,"CADASTRO",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					
						if(confirmacao==0) {
						String sql1 = "DELETE FROM FUNCIONARIOS WHERE RE = ?";
							
						try{
							PreparedStatement preparador1 = conec.prepareStatement(sql1);
							preparador1.setString(1, num );
								
							preparador1.execute();
							preparador1.close();
							
							JOptionPane.showMessageDialog(null, "Colaborador excluido", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
							}catch (SQLException e){
							JOptionPane.showMessageDialog(null, "Erro ao excluir o colaborador", "ERRO", JOptionPane.ERROR_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(null, "Colaborador não excluido", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
						}
				
			}else {
				JOptionPane.showMessageDialog(null, "Colaborador não encontrado!");
			}
		}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Colaborador não encontrado!");
		}
	}
}

