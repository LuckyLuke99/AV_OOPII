public class Item 
{
	private String nome = null, categoria = null;
	private Skin[] skins = null;
	
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getCategoria() 
	{
		return categoria;
	}
	public void setCategoria(String categoria) 
	{
		
		this.categoria = categoria;
	}
	public Skin[] getSkins() 
	{
		return skins;
	}
	public void setSkins(Skin[] skins) 
	{
		this.skins = skins;
	}
}
