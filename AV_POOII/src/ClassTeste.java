import java.util.InputMismatchException;
import java.util.Scanner;

public class ClassTeste 
{

	public static void main(String[] args) 
	{
		Cliente Valorant = new Cliente ();
		
		System.out.println("Fim");
		try (Scanner in = new Scanner(System.in)){
			boolean bMain = true;
			
			do {
				System.out.println("\n****************");
				System.out.println("\nEscolha a opção: ");
				System.out.println("1 - Adicionar");
				System.out.println("2 - Ler");
				System.out.println("3 - Alterar");
				System.out.println("4 - Remover");
				System.out.println("5 - Sair");
				int Opcao = in.nextInt();
				
				if(Opcao == 1)
				{
					int Opcao01;
					do 
					{
					System.out.println("\n****************");
					System.out.println("\nEscolha a opção: ");
					System.out.println("1 - Adicionar Conta");
					System.out.println("2 - Adicionar Item");
					System.out.println("3 - Sair");
					Opcao01 = in.nextInt();
					
					if(Opcao01 == 1)
					{
						System.out.println("\n****************");
						System.out.println("\nDigite o nome da conta: ");
						Valorant.adicionarConta(in.next());
					}
					if(Opcao01 == 2)
					{
						System.out.println("\n****************");
						System.out.println("\nDigite a conta que irá adicionar: ");
						Conta aux_Conta = new Conta(in.next());
						System.out.println("\nDigite o nome do item: ");
						Item aux_item = new Item(in.next());
						System.out.println("\nDigite o valor do item: ");
						aux_item.setValor(in.nextDouble());
				
						Valorant.adicionarItem(aux_Conta, aux_item.getNome(), aux_item.getValor());
					}
					}while(Opcao01 != 3);
				}
				
				if(Opcao == 2)
				{
					System.out.println("\n****************");
					Valorant.listarContas();
				}
				if(Opcao == 3)
				{
					System.out.println("\n****************");
				}
				
				if(Opcao == 4)
				{
					
				}
				
				if(Opcao > 5)
				{
					System.out.println("\nO Programa foi encerrado!");
				}
				
				if(Opcao > 5)
				{
					System.out.println("\nDigite um valor que corresponda a uma opcao");
				}
				Opcao = 0;
			}while(bMain);
			
		}
		catch(InputMismatchException e) {	
			System.out.println("Erro na entrada de dados!!!");
		}
	}
}
