import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Menu extends JFrame{
	JMenuBar barra = new JMenuBar();
	Cliente Valorant;
	Container tela;
	FlowLayout layout;
	
	//Lista
	JList<String> lista = new JList();
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
	JMenuItem menu03 = new JMenuItem("Por espaço");
	
	//Items menu listagem
	JMenuItem sair01 = new JMenuItem("Sair sem gravar");
	JMenuItem sair02 = new JMenuItem("Sair e gravar");
	
	//Atributos auxiliares
	int index;
	boolean aux_boolean;
	String aux_list[] = null;
	
	//Teste
	
	public Menu() throws IOException {
		super();
		
		setJMenuBar(barra);
		Valorant = new Cliente();
		this.atualizarLista();
		
		//Teste lista
		tela = getContentPane();
		layout = new FlowLayout();
		tela.setLayout(layout);
		
		lista.setVisibleRowCount(10); // Define quantas linhas serão exibidas
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		JScrollPane painelRolagem = new JScrollPane(lista); // Cria um Painel de Rolagem com o JList
		tela.add(painelRolagem);
		
		//Configuracao dos campos
		campo = new JTextField(5);
		campo.setEditable(false);
		campo02 = new JTextField(5);
		campo02.setEditable(false);
		campo03 = new JTextField(2);
		campo03.setEditable(false);
		campo04 = new JTextField(2);
		campo04.setEditable(false);
		campo05 = new JTextField(5);
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
		listagem.add(menu03);
		
		barra.add(sair);
		sair.add(sair01);
		sair.add(sair02);
		
		//Configuracao do Menu
		setTitle("Controle de contas");
		setSize(600,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//Adicionando ActionListener
		for(int i = 0; i < barra.getMenuCount(); i++) {
			for(int index = 0; index < ((JMenu) barra.getMenu(i)).getItemCount(); index++) {
				((JMenu) barra.getMenu(i)).getItem(index).addActionListener(evento -> respondeAoEvento(evento));
			}
		}
		
		//Teste
}
	
	public void atualizarLista() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		list = new String[Valorant.getContas().size()];
		index = 0;
		DefaultListModel dlm = new DefaultListModel();
		Valorant.getContas().forEach(c ->{
			dlm.addElement(c.getLogin());
			list[index] = c.getLogin();
			index++;
		});
		
		lista.setModel(dlm);;
		
		// Usando Classe Interna Anônima
		lista.addListSelectionListener( new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e){
				campo.setText(lista.getSelectedValue().toString());
			}
		});
		lista.addListSelectionListener( new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e){
				
				campo02.setText(Double.toString(Valorant.pesquisarConta(lista.getSelectedValue().toString()).getDinheiro()));
			}
		});
		lista.addListSelectionListener( new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e){
				campo03.setText(Integer.toString(Valorant.pesquisarConta(lista.getSelectedValue().toString()).getEspaco()));
			}
		});
		lista.addListSelectionListener( new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e){
				campo04.setText(Integer.toString(Valorant.pesquisarConta(lista.getSelectedValue().toString()).getItemsSize()));
			}
		});
		lista.addListSelectionListener( new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e){
				campo05.setText(Valorant.pesquisarConta(lista.getSelectedValue().toString()).getCriacao().format(formatter));
			}
		});
	}
	
	private void respondeAoEvento(ActionEvent evento){
		try {
		//Listar contas por nome
		if(evento.getSource() == menu01) {
			Valorant.listagemPorNome();
			}
		//Listar contas por saldo
		if(evento.getSource() == menu02) {
			Valorant.listagemPorDinheiro();
		}
		//Listar contas por espaço
		if(evento.getSource() == menu03) {
			Valorant.listagemPorEspaco();
		}
		
		//Alterar espaco de uma conta
			if(evento.getSource() == espaco) {
				String resp01 = JOptionPane.showInputDialog(null,"Qual o login?", "Alterando o espaço", JOptionPane.QUESTION_MESSAGE);
				int resp02 = Integer.parseInt((JOptionPane.showInputDialog(null,"Qual o espaço?", "Alterando o espaço", JOptionPane.QUESTION_MESSAGE)));
				
				Conta aux_conta = new Conta(resp01);
				if((Valorant.getContas().contains(aux_conta))) {
					Valorant.setEspacoConta(aux_conta, resp02);
					JOptionPane.showMessageDialog(null, "Espaço alterado com o sucesso!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Não foi possível alterar o espaço!");
				}
			}
		//Alterar Salado Conta
			if(evento.getSource() == saldo) {
				String resp01=JOptionPane.showInputDialog(null,"Qual o login?", "Removendo conta", JOptionPane.QUESTION_MESSAGE);
				double resp02=Double.parseDouble(JOptionPane.showInputDialog(null,"Qual o saldo?", "Removendo conta", JOptionPane.QUESTION_MESSAGE));
				
				Conta aux_conta = new Conta(resp01);
				if((Valorant.getContas().contains(aux_conta))) {
					Valorant.setValorConta(aux_conta, resp02);
					JOptionPane.showMessageDialog(null, "Saldo alterado com sucesso!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Não foi possível alterar saldo da conta!");
				}
			}
		//Pesquisar Cota
		if(evento.getSource() == conta03) {
			String resp01=JOptionPane.showInputDialog(null,"Qual o login?", "Pesquisando conta", JOptionPane.QUESTION_MESSAGE);
			Conta aux_conta = new Conta(resp01);
			if(Valorant.getContas().contains(aux_conta)) {
				JOptionPane.showMessageDialog(null, "Conta pesquisada: " + "\n" + Valorant.pesquisarConta(aux_conta));
			}
			else {
				JOptionPane.showMessageDialog(null, "Não foi possível encontrar conta!");
			}
		}
		//Pesquisar item
		if(evento.getSource() == item04) {
			String resp01=JOptionPane.showInputDialog(null,"Qual o item", "Pesquisando item", JOptionPane.QUESTION_MESSAGE);
			Item aux_item = new Item(resp01);
			aux_boolean = false;	
			Valorant.getContas().forEach(c->{
				if(c.getItems().contains(aux_item))
					aux_boolean = true;
			});
			if(aux_boolean) {
				JOptionPane.showMessageDialog(null, "Contas com o item: " + "\n" + Valorant.pesquisarItem(resp01));
			}
			else {
				JOptionPane.showMessageDialog(null, "Não foi possível encontrar nenhum item!");
			}
		}
		//Adicionando item
		if(evento.getSource() == item) {
			String resp01 = JOptionPane.showInputDialog(null,"Qual o login?", "Adicionando item", JOptionPane.QUESTION_MESSAGE);
			String resp02 = JOptionPane.showInputDialog(null,"Qual o item", "Adicionando item", JOptionPane.QUESTION_MESSAGE);
			double resp03 = Double.parseDouble(JOptionPane.showInputDialog(null,"Qual o valor do item","Adicionando item", JOptionPane.QUESTION_MESSAGE));
			
			Conta aux_conta = new Conta(resp01);
			Item aux_item = new Item(resp02);
			aux_boolean = false;
			
			if (((Conta)Valorant.pesquisarConta(aux_conta.getLogin())).getItems().contains(aux_item)){
				aux_boolean = true;
			}
			if(Valorant.getContas().contains(aux_conta) && !aux_boolean) {
				Valorant.adicionarItem(aux_conta, resp02, resp03);
				JOptionPane.showMessageDialog(null, "Item adicionado com sucesso!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Não foi possível adicionar o item!!");
			}
		}
		//Removendo item da conta
		if(evento.getSource() == item02) {
			String resp01 = JOptionPane.showInputDialog(null,"Qual o login?", "Adicionando item", JOptionPane.QUESTION_MESSAGE);
			String resp02 = JOptionPane.showInputDialog(null,"Qual o item", "Adicionando item", JOptionPane.QUESTION_MESSAGE);
			
			Conta aux_conta = new Conta(resp01);
			Item aux_item = new Item(resp02);
			aux_boolean = false;
			if (((Conta)Valorant.pesquisarConta(aux_conta.getLogin())).getItems().contains(aux_item)){
				aux_boolean = true;
			}
			if(Valorant.getContas().contains(aux_conta) && aux_boolean) {
				Valorant.removerItem(aux_conta, resp02);
				JOptionPane.showMessageDialog(null, "Item removido com sucesso!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Não foi possível remover o item!!");
			}
		}
		//Removendo items das contas
			if(evento.getSource() == item03) {
				String resp01 = JOptionPane.showInputDialog(null,"Qual o nome do item?", "Removendo item em todas as contas", JOptionPane.QUESTION_MESSAGE);
						
				Item aux_item = new Item(resp01);
				Valorant.getContas().forEach(c->{
				if(c.getItems().contains(aux_item)) {
						c.getItems().remove(aux_item);
					}
				});
				}
		//Adicionando Conta
		if(evento.getSource() == conta) {
			String resp01=JOptionPane.showInputDialog(null,"Qual o login?", "Adicionando conta", JOptionPane.QUESTION_MESSAGE);
			Conta aux_conta = new Conta(resp01);
			if(!(resp01==null || resp01.equals("") || Valorant.getContas().contains(aux_conta))) {
				Valorant.adicionarConta(resp01);
				JOptionPane.showMessageDialog(null, "Conta adicionada com sucesso!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Não foi possível adicionar a conta!!");
			}
		}
		//Removendo Conta
		if(evento.getSource() == conta02) {
			String resp01=JOptionPane.showInputDialog(null,"Qual o login?", "Removendo conta", JOptionPane.QUESTION_MESSAGE);
			Conta aux_conta = new Conta(resp01);
			if(!(resp01==null || resp01.equals("") || !(Valorant.getContas().contains(aux_conta)))) {
				Valorant.removerConta(aux_conta);
				JOptionPane.showMessageDialog(null, "Conta removida com sucesso!!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Não foi possível remover a conta!!");
			}
		}
		//Sair sem gravar
		if(evento.getSource() == sair01) {
			System.exit(0);
		}
		//Sair e gravar
		if(evento.getSource() == sair02) {
			System.out.print("\nGravando arquivos...");
			try {
				Valorant.gravarCliente();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}	
	}catch (NumberFormatException e) {
		System.out.println("Número inválido!");
		JOptionPane.showMessageDialog(null, "Número inválido!");
	}
		catch (Exception e) {
			System.out.println("Digite algum valor");
			JOptionPane.showMessageDialog(null, "Digite algum valor");
		}
	atualizarLista();
	}
	
}
