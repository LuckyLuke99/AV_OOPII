
public class Conta 
{
	private String login = null;
	private double dinheiro = 0.0;
	private Colecao ColecaoItems = null;
	
	public Conta (String aux_login)
	{
		login = aux_login;
	}
	
	public String getLogin ()
	{
		return login;
	}
	
	public double getDinheiro() 
	{
		return dinheiro;
	}
	
	public void setDinheiro(double dinheiro)
	{
		this.dinheiro = dinheiro;
	}
	
	public Colecao getColecaoItems() 
	{
		return ColecaoItems;
	}
	
	public void setColecaoItems(Colecao colecaoItems) 
	{
		ColecaoItems = colecaoItems;
	}

	@Override
	public String toString() {
		return "Conta [login=" + login + ", dinheiro=" + dinheiro + ", ColecaoItems=" + ColecaoItems + "]";
	}

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
	
}
