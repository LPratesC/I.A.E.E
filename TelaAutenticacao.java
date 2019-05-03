package Programa;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TelaAutenticacao extends JFrame implements ActionListener {
	
	JTextField login;											//COLOCADO NO CONSTRUTOR O QUE IREI USAR MAIS EMBAIXO (NECESSARIO!)
	JPasswordField senha;										//COLOCADO NO CONSTRUTOR O QUE IREI USAR MAIS EMBAIXO (NECESSARIO!)
	JButton logar, cancel;										//COLOCADO NO CONSTRUTOR O QUE IREI USAR MAIS EMBAIXO (NECESSARIO!)
	
	public TelaAutenticacao() {
		super ("Autentica��o...");
		
		logar = new JButton("Logar");							//CRIANDO O BOT�O COM A��O
		logar.addActionListener(this);							//INFORMANDO QUAL A��O IR� REALIZAR (ONDE 'THIS' DIZ QUE � A A��O LA EM BAIXO)
		
		cancel = new JButton("Cancelar");						//CRIANDO O BOT�O COM A��O
		cancel.addActionListener(this);							//INFORMANDO QUAL A��O IR� REALIZAR (ONDE 'THIS' DIZ QUE � A A��O LA EM BAIXO)
		
		login = new JTextField();								//CRIANDO O TEXTBOX ONDE PODE SER INSIRIDO O TEXTO
				
		senha = new JPasswordField();							//CRIANDO O CAMPO DE SENHA (UTIL POIS ESCONDE O QUE � DIGITADO)
		
		this.setLocationRelativeTo(null);						//COMANDO PARA A JFRAME INICIAR NO MEIO DA TELA
		
		Container c1 = getContentPane();
		c1.setLayout(new GridLayout(3,2));						//GRID POIS � UM LAYOUTE DE TABELA (LINHAxCOLUNA)
		c1.add(new JLabel("Usuario:"));							//LABEL � O TEXTE QUE APARECE
		c1.add(login);											//COLOCANDO O BOT�O QUE CRIEI NA LINHA 19
		c1.add(new JLabel("Senha:"));							//LABEL � O TEXTE QUE APARECE
		c1.add(senha);											//COLOCANDO O BOT�O QUE CRIEI NA LINHA 19
		c1.add(logar);											//COLOCANDO O TEXTBOX QUE CRIEI NA LINHA 17
		c1.add(cancel);											//COLOCANDO O PASSWORDBOX QUE CRIEI NA LINHA 18
		
//		setAlwaysOnTop(true);									//ERA PRA DEIXAR NO MEIO, MAS N�O FUNCIONOU COMO EU PENSEI
//      toFront();												//IDEM A LINHA DE CIMA
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//FECHA A JANELA = FECHA O PROGRAMA
//		setSize(300,120);										//TAMANHO DA JANELA
		setBounds(500, 300, 300, 120);
		setVisible(true);										//SE A JANELA � VISIVEL
		
		
	}
	
	public boolean Autenticar() {
		
		return true;
		
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent acaobotao) {
		
//		USADO PARA DEFINIR A A��O DO BOT�O / QUANDO COLOCADO e.getSource() ele pega o bot�o que foi clicado (lembrado que o <acaobotao>
//		eu defini na linha de cima quando coloquei o (ActionEvente <acaobotao>)... ent�o se tiver no getSource() == (igual) ao <nome do bot�o>
//		ele executa o if... 

		if(acaobotao.getSource()==logar) {
			if(login.getText().equals("login")&&senha.getText().equals("senha")) {	
			new JanelaPrincipal2();
			TelaAutenticacao.this.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Senha Incorreta","erro", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(acaobotao.getSource()==cancel) {
			JOptionPane.showMessageDialog(null, "AUTENTICACAO NECESSARIA", "ERRO", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
}
