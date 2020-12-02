public class Item 
{
	private String nome;
	private double valor;
	
	public Item ()
	{
		
	}
	
	public Item (String aux_nome)
	{
		nome = aux_nome;
	}
	
	public Item (double aux_valor)
	{
		valor = aux_valor;
	}
	public Item (String aux_nome, double aux_valor)
	{
		nome = aux_nome;
		valor = aux_valor;
	}
	
	// Get and Set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	// Metodos
	
	
	// Override
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Item other = (Item) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [nome=" + nome + ", valor=" + valor + "]";
	}
	
}
