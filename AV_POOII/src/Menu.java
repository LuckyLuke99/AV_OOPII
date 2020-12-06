import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Menu extends JFrame {
	JMenuBar barra = new JMenuBar();
	JList<String> lista;
	
	JMenu adicionar = new JMenu("Adicionar");
	JMenu alterar = new JMenu("Alterar");
	JMenu remover = new JMenu("Remover");
	JMenu pesquisar = new JMenu("Pesquisar");
	JMenu listagem = new JMenu("Listagem");
	JMenuItem sair = new JMenu("Sair");
	
	//items menu adicionar
	JMenuItem conta = new JMenuItem("Conta");
	JMenuItem item = new JMenuItem("Item");
	
	//items menu alterar
	JMenuItem saldo = new JMenuItem("Saldo");
	JMenuItem espaco = new JMenuItem("Espaço");
	
	//items menu remover
	JMenuItem conta02 = new JMenuItem("Conta");
	JMenuItem item02 = new JMenuItem("Item em conta");
	JMenuItem item03 = new JMenuItem("Item em todas as contas");
	
	//Items menu pesquisar
	JMenuItem conta03 = new JMenuItem("Conta");
	JMenuItem item04 = new JMenuItem("Item");
	
	//Items menu listagem
	JMenuItem menu01 = new JMenuItem("Por nome");
	JMenuItem menu02 = new JMenuItem("Por saldo");
	
	//Items menu listagem
	JMenuItem sair01 = new JMenuItem("Sair sem gravar");
	JMenuItem sair02 = new JMenuItem("Sair e gravar");
		
	public Menu() {
		setJMenuBar(barra);
		
		//Adicionando menus
		barra.add(adicionar);
		adicionar.add(conta);
		adicionar.add(item);
		
		barra.add(alterar);
		alterar.add(saldo);
		alterar.add(espaco);
		
		barra.add(remover);
		remover.add(conta02);
		remover.add(item02);
		remover.add(item03);
		
		barra.add(pesquisar);
		pesquisar.add(conta03);
		pesquisar.add(item04);
		
		barra.add(listagem);
		listagem.add(menu01);
		listagem.add(menu02);
		
		barra.add(sair);
		sair.add(sair01);
		sair.add(sair02);
		
		//Configuracao do Menu
		setTitle("Controle de contas");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		//Adicionando ActionListener
		for(int i = 0; i < barra.getMenuCount(); i++) {
			for(int index = 0; index < ((JMenu) barra.getMenu(i)).getItemCount(); index++) {
				((JMenu) barra.getMenu(i)).getItem(index).addActionListener(evento -> respondeAoEvento(evento));
			}
		}
	}
	
	private void respondeAoEvento(ActionEvent evento) {
		if(evento.getSource() == sair01) {
			System.exit(0);
		}
	}
	
	public static void main(String[]args) throws IOException {
		new Menu();
		Cliente Valorant = new Cliente ();
		
	}
}
