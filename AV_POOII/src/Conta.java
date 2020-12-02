import java.util.LinkedHashSet;

public class Conta 
{
	private String login = null;
	private double dinheiro = 0.0;
	private int espaco = 10;
	private LinkedHashSet<Item> Items  = new LinkedHashSet<Item>();
	
	public Conta (String aux_nome)
	{
		login = aux_nome;
	}
	
	// Get and Set
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public double getDinheiro() {
		return dinheiro;
	}
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}
	public int getEspaco() {
		return espaco;
	}
	public void setEspaco(int espaco) {
		this.espaco = espaco;
	}
	public LinkedHashSet<Item> getItems() {
		return Items;
	}
	public void setItems(LinkedHashSet<Item> items) {
		Items = items;
	}
	
	// Metodos
	public void adicionarItem (String aux_nome, double aux_valor)
	{
		Items.add(new Item(aux_nome, aux_valor));
	}
	
	//Override
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Conta [login=" + login + ", dinheiro=" + dinheiro + ", espaco=" + espaco + ", Items=" + Items + "]";
	}
					
}
