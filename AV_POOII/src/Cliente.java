import java.util.LinkedHashSet;

public class Cliente 
{
	boolean bLogin;
	private LinkedHashSet<Conta> Contas  = new LinkedHashSet<Conta>();
	
	public Cliente ()
	{
		
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
					c.adicionarItem(aux_nome, aux_valor);
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
}
