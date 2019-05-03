package BANCO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class Conexao {
	
	
	public static Connection obterConexao() {
		
		Connection con = null;
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa","root","");
//			JOptionPane.showMessageDialog(null, "Conectado ao banco !" /* MESSAGEM QUE VAI APARECER NO POPUP */);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Não conectado ao banco !" /* MESSAGEM QUE VAI APARECER NO POPUP */);
//			e.printStackTrace();
		}
		return con;
	}	
}