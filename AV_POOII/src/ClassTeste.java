import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClassTeste 
{

	public static void main(String[] args) throws IOException 
	{
		Cliente Valorant = new Cliente ();
	
		try (Scanner in = new Scanner(System.in)){
			boolean bMain = true;
			
			do {
				// Menu principal de opções
				System.out.println("\n****************");
				System.out.println("\nEscolha a opção: ");
				System.out.println("1 - Adicionar");
				System.out.println("2 - Ler");
				System.out.println("3 - Alterar");
				System.out.println("4 - Remover");
				System.out.println("5 - Sair");
				int Opcao = in.nextInt();
				
				// Menu de adicionar
				if(Opcao == 1)
				{
					int Opcao01;
					do 
					{	
						//Opções do menu
						System.out.println("\n****************");
						System.out.println("\nEscolha a opção: ");
						System.out.println("1 - Adicionar conta");
						System.out.println("2 - Adicionar item na conta");
						System.out.println("3 - Sair");
						Opcao01 = in.nextInt();
						
						//Adicionar Conta
						if(Opcao01 == 1)
						{
							System.out.println("\n****************");
							System.out.println("\nDigite o nome da conta: ");
							Valorant.adicionarConta(in.next());
						}
						//Adicionar item na conta
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
					}while(Opcao01 != 3); //Voltando para o menu
				}
				
				//Menu de ler
				if(Opcao == 2)
				{
					int Opcao01;
					do 
					{
						//Opções do menu
						System.out.println("\n****************");
						System.out.println("\nEscolha a opção: ");
						System.out.println("1 - Listar Contas");
						System.out.println("2 - Listar Items de uma conta");
						System.out.println("3 - Sair");
						Opcao01 = in.nextInt();
						
						//Listar contas
						if(Opcao01 == 1)
						{
							System.out.println("\n****************");
							Valorant.listarContas();
						}
						//Listar items em conta
						if(Opcao01 == 2)
						{
							
							System.out.println("\n****************");
							System.out.println("Informe o login da conta: ");
							Conta aux_Conta = new Conta(in.next());
							Valorant.listarItems(aux_Conta);
							
						}
					}while(Opcao01 != 3); //Saindo do menu
				}
				//Menu de alterar
				if(Opcao == 3)
				{
					System.out.println("\n****************");
				}
				//Menu de remover
				if(Opcao == 4)
				{
					
				}
				//Sair do programa
				if(Opcao == 5)
				{
					System.out.print("\nGravando arquivos...");
					Valorant.gravarCliente();
					bMain = false;
				}
				//Mensagem caso não corresponda a nenhuma opção
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
		System.out.println("\nO Programa foi encerrado!");
	}
}
