import java.util.LinkedHashSet;

public class Cliente 
{
	private LinkedHashSet<Conta> Contas  = new LinkedHashSet<Conta>();
	
	public Cliente ()
	{
		
	}
	
	public void adicionarConta (String aux_login)
	{	
		Contas.add(new Conta(aux_login));
	}
	
	public void listarContas ()
	{
		Contas.forEach(c -> System.out.println(c.toString()));
	}
}
