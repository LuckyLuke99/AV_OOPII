import java.time.LocalDate;

public class Loja 
{
	private LocalDate rotacao, proximaRotacao;
	private Item[] itemsParaComprar;
	
	public LocalDate getRotacao() 
	{
		return rotacao;
	}
	public void setRotacao(LocalDate rotacao) 
	{
		this.rotacao = rotacao;
	}
	public LocalDate getProximaRotacao() 
	{
		return proximaRotacao;
	}
	public void setProximaRotacao(LocalDate proximaRotacao) 
	{
		this.proximaRotacao = proximaRotacao;
	}
	public Item[] getItemsParaComprar() 
	{
		return itemsParaComprar;
	}
	public void setItemsParaComprar(Item[] itemsParaComprar) 
	{
		this.itemsParaComprar = itemsParaComprar;
	}
	
}
