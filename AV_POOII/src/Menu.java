import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Menu extends JFrame {
	JMenuBar barra = new JMenuBar();
	Cliente Valorant;
	Container tela;
	FlowLayout layout;
	
	//Lista
	JList<String> lista;
	JTextField campo;
	JTextField campo02;
	JTextField campo03;
	JTextField campo04;
	JTextField campo05;
	String list[];
	
	//Menus
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
	
	//Atributos auxiliares
	int index;
	
	public Menu() throws IOException {
		setJMenuBar(barra);
		Valorant = new Cliente();
		this.atualizarLista();
		
		//Teste lista
		tela = getContentPane();
		layout = new FlowLayout();
		tela.setLayout(layout);
		
		lista.setVisibleRowCount(5); // Define quantas linhas serão exibidas
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		JScrollPane painelRolagem = new JScrollPane(lista); // Cria um Painel de Rolagem com o JList
		tela.add(painelRolagem);
		
		//Configuracao dos campos
		campo = new JTextField(10);
		campo.setEditable(false);
		campo02 = new JTextField(10);
		campo02.setEditable(false);
		campo03 = new JTextField(10);
		campo03.setEditable(false);
		campo04 = new JTextField(10);
		campo04.setEditable(false);
		campo05 = new JTextField(10);
		campo05.setEditable(false);
		
		//Adicionando os campos
		tela.add(new JLabel("Login:"));
		tela.add(campo);
		tela.add(new JLabel("Dinheiro"));
		tela.add(campo02);
		tela.add(new JLabel("Espaco"));
		tela.add(campo03);
		tela.add(new JLabel("Items"));
		tela.add(campo04);
		tela.add(new JLabel("Criação"));
		tela.add(campo05);
		
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
	
	public void atualizarLista() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//list = Valorant.listarContas();
		list = new String[Valorant.getContas().size()];
		index = 0;
		Valorant.getContas().forEach(c ->{
			list[index] = c.getLogin();
			index++;
		});
		lista = new JList<>(list);
		
		// Usando Classe Interna Anônima
		lista.addListSelectionListener( new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e){
				campo.setText(lista.getSelectedValue().toString());
			}
		});
		lista.addListSelectionListener( new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e){
				
				campo02.setText(String.format("%1$,.2f", Valorant.pesquisarConta(lista.getSelectedValue().toString()).getDinheiro()));
			}
		});
		lista.addListSelectionListener( new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e){
				campo03.setText(String.format("%4.3f", Valorant.pesquisarConta(lista.getSelectedValue().toString()).getEspaco()));
			}
		});
		lista.addListSelectionListener( new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e){
				campo04.setText(String.format("%4.3f", Valorant.pesquisarConta(lista.getSelectedValue().toString()).getItemsSize()));
			}
		});
		lista.addListSelectionListener( new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e){
				campo05.setText(Valorant.pesquisarConta(lista.getSelectedValue().toString()).getCriacao().format(formatter));
			}
		});
	}
	
	private void respondeAoEvento(ActionEvent evento) {
		if(evento.getSource() == conta) {
			System.out.print("Oii");
		}
		
		if(evento.getSource() == sair01) {
			System.exit(0);
		}
	}
	
}
