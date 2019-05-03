package BANCO;

import java.sql.Connection;

public class TestarConexao {

	public static void main(String[] args ) {
		
		@SuppressWarnings("unused")
		Connection con = Conexao.obterConexao();
	}
	
}
