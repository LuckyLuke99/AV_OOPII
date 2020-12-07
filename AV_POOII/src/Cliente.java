import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.EOFException;
import java.io.File;

public class Cliente 
{
	boolean bLogin;
	private LinkedHashSet<Conta> Contas  = new LinkedHashSet<Conta>();
	private LinkedHashSet<Conta> aux_Contas  = new LinkedHashSet<Conta>();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private File fArquivo = null;
	private String inf_aux, inf_aux2;
	private Item aux_item = new Item();
	private Conta aux_Conta = new Conta(); // Conta auxiliar para o metodo encontrarConta
	private boolean aux_bool;
	int index;
	
	public Cliente () throws IOException 
	{
		fArquivo = new File("d:\\arquivo.bin");
		if(fArquivo.exists()) {
			this.lerGravacao();
		}
	}
	
	public void gravarCliente () throws IOException {
		FileOutputStream arq = new FileOutputStream(fArquivo);
		DataOutputStream gravarArq = new DataOutputStream(arq);
		String login, dataAux;
		LocalDate criacao;
		double dinheiro;
		int espaco;
		Contas.forEach(c ->{
			try {
				gravarArq.writeUTF(c.getLogin());
				gravarArq.writeUTF(c.getCriacao().format(formatter));
				gravarArq.writeDouble(c.getDinheiro());
				gravarArq.writeInt(c.getEspaco());
				gravarArq.writeInt(c.getItemsSize());
				c.getItems().forEach(i ->{
					try {
						gravarArq.writeUTF(i.getNome());
						gravarArq.writeDouble(i.getValor());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	public void lerGravacao () throws IOException
	{
		String login, dataAux, nome;
		LocalDate criacao;
		double dinheiro, valor;
		int espaco, itemsSize;
		try(FileInputStream arq = new FileInputStream(fArquivo);DataInputStream lerArq = new DataInputStream(arq);
){		
			while(true) {
				//Lendo as contas
				login = lerArq.readUTF();
				dataAux = lerArq.readUTF();
				criacao = LocalDate.parse(dataAux, formatter);
				dinheiro = lerArq.readDouble();
				espaco = lerArq.readInt();
				Contas.add(new Conta(login, criacao, dinheiro, espaco));
					
				//Lendos os items
				itemsSize = lerArq.readInt();
				if(itemsSize > 0)
				{
					while(itemsSize > 0)
					{
						Conta aux_Conta = new Conta(login);
						nome = lerArq.readUTF();
						valor = lerArq.readDouble();
						this.adicionarItem(aux_Conta, nome, valor);
						itemsSize -= 1;
					}
				}

			}
		}catch (EOFException e) {
			System.out.print("Leitura de arquivo completa!\n\n");
		}
	}
	
	public void adicionarConta (String aux_login)
	{	
		Contas.add(new Conta(aux_login));
	}
	
	public void adicionarItem (Object obj, String aux_nome, double aux_valor)
	{	
		Contas.forEach(c -> {
				if(c.equals(obj))
				{
					bLogin = true;
					if(c.getItemsSize() < c.getEspaco())
					{
						c.adicionarItem(aux_nome, aux_valor);
					}
					else
					{
						System.out.print("Conta n�o possui espa�o disponivel");
					}
				}
				else
				{
					bLogin = false;
				}
			});
	}
		
	public String[] listarContas ()
	{
		String ListaContas[]= new String[Contas.size()];
		 index = 0;
		
		Contas.forEach(c ->{
			ListaContas[index] = c.toString();
			index = index + 1;
		});
		return ListaContas;
	}
	
//	public String listarItems (Object aux_conta)
//	{
////		inf_aux = "Listar items do ";
////		Contas.forEach(c ->{
////			if(c.equals(aux_conta))
////			{	inf_aux = "Listar items do " + c.getLogin() + ":";
////				if(c.getItemsSize() > 0)
////				{
////					c.getItems().forEach(i -> inf_aux += i.toString());
////				}
////				if(c.getItemsSize() == 0) {
////					inf_aux +=Conta n�o possui items!");
////				}
////			}
////		});
////		return inf_aux;
//	}
	
	public String pesquisarConta (Conta aux_conta)
	{
		inf_aux = "Nenhuma informa��o encontrada!";
		Contas.contains(aux_conta);
		Contas.forEach(c ->{
			if(c.equals(aux_conta))
			{
				inf_aux = c.toString();
			}
		});
		return inf_aux;
	}
	
	public String pesquisarItem (String aux_nome)
	{
		aux_bool = false;
		aux_item.setNome(aux_nome);
		inf_aux = "Nenhuma informa��o encontrada!";
		inf_aux = "";
		Contas.forEach(c ->{
			c.getItems().forEach(i ->{
				if (i.equals(aux_item))
				{
					inf_aux += "\n";
					inf_aux += c.getLogin();
					inf_aux += i.toString();
				}
			});
		});
		if(aux_bool == true) // Retorna uma string com as informa��es encontradas
		{
			return inf_aux2;
		}
		else // Retorna que nenhuma informa��o foi encontrada
		{
		return inf_aux;
		}
	}
	
	public void setValorConta (Conta aux_conta, double aux_valor) {
		Contas.forEach(c ->{
			if(c.equals(aux_conta))
			{
				c.setDinheiro(aux_valor);
			}
		});
	}
	
	public void setEspacoConta (Conta aux_conta, int aux_espaco) {
		Contas.forEach(c ->{
			if(c.equals(aux_conta))
			{
				c.setEspaco(aux_espaco);
			}
		});
	}
	
	public void setValorItem (Conta aux_conta, String aux_nome, double aux_valor){
		aux_item.setNome(aux_nome);
		Contas.forEach(c ->{
			if(c.equals(aux_conta))
			{
				c.getItems().forEach(i ->{
					if(i.equals(aux_nome))
					{
						i.setValor(aux_valor);
					}
				});
			}
		});
	}
	
	public void removerConta (Conta aux_conta) {
		aux_bool = false;
		Contas.forEach(c ->{
			if(c.equals(aux_conta))
			{
				aux_bool = true;
			}
		});
		if(aux_bool) {
			Contas.remove(aux_conta);
			System.out.println("Conta removida com sucesso!");
		}
		else{
			System.out.println("Conta n�o achada!");
		}
	}
	
	public void removerItem(Conta aux_conta, String aux_nome) {
		aux_item.setNome(aux_nome);
		Contas.forEach(c ->{
			if(c.equals(aux_conta))
			{
				c.getItems().forEach(i ->{
					if(i.equals(aux_item)) {
						c.setDinheiro(i.getValor()+c.getDinheiro());
						c.getItems().remove(aux_item);
					}
				});
			}
		});
	}
	
	public LinkedHashSet<Conta> getContas() {
		return Contas;
	}

	public Conta pesquisarConta (String aux_nome) {
		aux_Conta = new Conta(aux_nome);
		Contas.forEach(c ->{
			if(c.equals(aux_Conta)) {
				aux_Conta = c;
			}
		});
		return aux_Conta;
	}
	
	public void listagemPorEspaco() {
		ComparaPorEspaco comparaEspaco = new ComparaPorEspaco();
		ArrayList listaAux = new ArrayList<>(Contas);
		aux_Contas.removeAll(aux_Contas);
		Collections.sort(listaAux, comparaEspaco);
		
		for(int i = 0; i < listaAux.size(); i++) {
			aux_Contas.add((Conta) listaAux.get(i));
			System.out.println(listaAux.get(i));
		}
		Contas = aux_Contas;
	}
	
	public void listagemPorNome() {
		ComparaPorNome comparaNome = new ComparaPorNome();
		ArrayList listaAux = new ArrayList<>(Contas);
		aux_Contas.removeAll(aux_Contas);
		Collections.sort(listaAux, comparaNome);
		
		for(int i = 0; i < listaAux.size(); i++) {
			aux_Contas.add((Conta) listaAux.get(i));
			System.out.println(listaAux.get(i));
		}
		Contas = aux_Contas;
	}
	
	public void listagemPorDinheiro() {
		ComparaPorDinheiro comparaDinheiro = new ComparaPorDinheiro();
		ArrayList listaAux = new ArrayList<>(Contas);
		aux_Contas.removeAll(aux_Contas);
		Collections.sort(listaAux, comparaDinheiro);
		
		for(int i = 0; i < listaAux.size(); i++) {
			aux_Contas.add((Conta) listaAux.get(i));
			System.out.println(listaAux.get(i));
		}
		Contas = aux_Contas;
		
	}
	
	
}