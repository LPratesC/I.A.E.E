package CRUD_JFRAME;

import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BANCO.Conexao;
import MODELO.Funcionarios;


public class JanelaMostrarTudo extends JFrame {
	
	JButton btnVoltar;
	JScrollPane barraRolagem = null;	
	Connection conec;
	String [] colunas = {"RE", "Nome", "Cargo"};
		
	public JanelaMostrarTudo() {
		super("Todos os registros");
		Container container = getContentPane();
		
		conec = Conexao.obterConexao();
		ArrayList<Funcionarios> listaFunc = new ArrayList<Funcionarios>();
		DefaultTableModel model = 	new DefaultTableModel(colunas, 0) {
			  @Override
			    public boolean isCellEditable(int row, int column) {
			       return false;
			    }
		 };
		
		String sql = "SELECT * FROM FUNCIONARIOS";
		
		try {
			PreparedStatement preparador = conec.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			while(resultado.next()) {
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
				
				model.addRow(new Object[]{
						func.getRe(),
						func.getNome(),
		        		func.getCargo()});
		     
				
			}	
		}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Colaborador não encontrado!");
		}
		JTable tabela = new JTable(model);
		tabela.setRowHeight(200);
	    barraRolagem = new JScrollPane(tabela);

		container.add(barraRolagem);
		setSize(500,500);
		setVisible(true);
	}
}

