import java.time.LocalDate;
import java.util.LinkedHashSet;

public class Conta 
{
	private String login = null;
	private LocalDate criacao = null;
	private double dinheiro = 0.0;
	private int espaco = 2;
	private LinkedHashSet<Item> Items  = new LinkedHashSet<Item>();
	
	public Conta (String aux_nome)
	{
		login = aux_nome;
		criacao = LocalDate.now();
	}
	public Conta (String aux_nome, LocalDate aux_criacao, double aux_dinheiro, int aux_espaco)
	{
		login = aux_nome;
		criacao = aux_criacao;
		dinheiro = aux_dinheiro;
		espaco = aux_espaco;
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
	public LocalDate getCriacao() {
		return criacao;
	}
	public void setCriacao(LocalDate criacao) {
		this.criacao = criacao;
	}
	// Metodos
	public void adicionarItem (String aux_nome, double aux_valor)
	{
		Items.add(new Item(aux_nome, aux_valor));
	}
	public int getItemsSize() {
		return Items.size();
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
