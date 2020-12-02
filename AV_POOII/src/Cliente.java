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
	LinkedHashSet<Conta> Contas2;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private File fArquivo = null;
	
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
			System.out.print(c);
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
					System.out.print("\n" + "\n" + i.toString());
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
						System.out.print("Conta não possui espaço disponivel");
					}
				}
				else
				{
					bLogin = false;
				}
			});
	}
		
	public void listarContas ()
	{
		Contas.forEach(c -> System.out.println(c.toString()));
	}
	
	public void listarItems (Conta aux_conta)
	{
		System.out.print("Lista de items do " + aux_conta.getLogin());
		aux_conta.getItems().forEach(i -> i.toString());
	}
}
