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

public class Cliente 
{
	boolean bLogin;
	private LinkedHashSet<Conta> Contas  = new LinkedHashSet<Conta>();
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Cliente () 
	{
		
	}
	
	public void gravarCliente () throws FileNotFoundException {
		FileOutputStream arq = new FileOutputStream("d:\\arquivo.dat");
		DataOutputStream gravarArq = new DataOutputStream(arq);
		
		Contas.forEach(c ->{
			try {
				gravarArq.writeUTF(c.getLogin());
				gravarArq.writeUTF(c.getCriacao().format(formatter));
				gravarArq.writeDouble(c.getDinheiro());
				gravarArq.writeInt(c.getEspaco());
				c.getItems().forEach(i ->{
					try {
						gravarArq.writeUTF(i.getNome());
						gravarArq.writeDouble(i.getValor());
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				arq.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	public LinkedHashSet<Conta> lerGravacao () throws IOException
	{
		LinkedHashSet<Conta> listContas  = new LinkedHashSet<Conta>();
		String login, dataAux;
		LocalDate criacao;
		double dinheiro;
		int espaco;
		try(FileInputStream arq = new FileInputStream("d:\\arquivo.dat");DataInputStream lerArq = new DataInputStream(arq);
){		
			while(true) {
				login = lerArq.readUTF();
				dataAux = lerArq.readUTF();
				criacao = LocalDate.parse(dataAux, formatter);
				dinheiro = lerArq.readDouble();
				espaco = lerArq.readInt();
				listContas.add(new Conta(login, criacao, dinheiro, espaco));
			}
		}catch (EOFException e) {
			System.out.print("Fum do arquivo !\n\n");
		}
		return listContas;
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
					System.out.print("Conta não existe");
					bLogin = false;
				}
			});
	}
		
	public void listarContas ()
	{
		Contas.forEach(c -> System.out.println(c.toString()));
	}
	
	
}
