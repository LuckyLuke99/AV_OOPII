import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//Classe para testar as interações sem a interface

public class ClassTeste 
{

	public static void main(String[] args) throws IOException 
	{
		Cliente Valorant = new Cliente ();
	
		try (Scanner in = new Scanner(System.in)){
			boolean bMain = true;
			
			do {
				// Menu principal de opções
				System.out.println("\n----------------");
				System.out.println("\nEscolha a opção: ");
				System.out.println("1 - Adicionar");
				System.out.println("2 - Pesquisar");
				System.out.println("3 - Alterar");
				System.out.println("4 - Remover");
				System.out.println("5 - Listar por atributo");
				System.out.println("6 - Sair");
				int Opcao = in.nextInt();
				
				// Menu de adicionar
				if(Opcao == 1)
				{
					int Opcao01;
					do 
					{	
						//Opções do menu
						System.out.println("\n----------------");
						System.out.println("\nEscolha a opção: ");
						System.out.println("1 - Adicionar conta");
						System.out.println("2 - Adicionar item na conta");
						System.out.println("3 - Sair");
						Opcao01 = in.nextInt();
						
						//Adicionar Conta
						if(Opcao01 == 1)
						{
							System.out.println("\n----------------");
							System.out.println("\nDigite o nome da conta: ");
							Valorant.adicionarConta(in.next());
						}
						//Adicionar item na conta
						if(Opcao01 == 2)
						{
							System.out.println("\n----------------");
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
				
				//Menu de pesquisa
				if(Opcao == 2)
				{
					int Opcao02;
					do 
					{
						//Opções do menu
						System.out.println("\n----------------");
						System.out.println("\nEscolha a opção: ");
						System.out.println("1 - Pesquisar conta");
						System.out.println("2 - Pesquisar item em contas");
						System.out.println("3 - Sair");
						Opcao02 = in.nextInt();
						
						//Listar contas
						if(Opcao02 == 1)
						{
							System.out.println("\n----------------");
							System.out.println("Informe o login da conta: ");
							Conta aux_Conta = new Conta(in.next());
							System.out.print(Valorant.pesquisarConta(aux_Conta));
						}
						//Listar items em conta
						if(Opcao02 == 2)
						{
							
							System.out.println("\n----------------");
							System.out.println("Informe o nome do item: ");
							System.out.print(Valorant.pesquisarItem(in.next()));
						}
					}while(Opcao02 != 3); //Saindo do menu
				}
				//Menu de alterar
				if(Opcao == 3)
				{
					int Opcao03;
					do 
					{
						//Opções do menu
						System.out.println("\n----------------");
						System.out.println("\nEscolha a opção: ");
						System.out.println("1 - Alterar saldo da conta");
						System.out.println("2 - Alterar espaco da conta");
						System.out.println("3 - Alterar login da conta");
						System.out.println("4 - Alterar valor de um item");
						System.out.println("5 - Alterar nome de um item");
						System.out.println("6 - Sair");
						Opcao03 = in.nextInt();
						
						//Alterar saldo da conta
						if(Opcao03 == 1)
						{
							System.out.println("\n----------------");
							System.out.println("Qual o nome da conta?");
							Conta aux_Conta = new Conta(in.next());
							System.out.println("Qual o valor?");
							Valorant.setValorConta(aux_Conta, in.nextDouble());
						}
						//Alterar espaco da conta
						if(Opcao03 == 2)
						{
							System.out.println("\n----------------");
							System.out.println("Qual o nome da conta?");
							Conta aux_Conta = new Conta(in.next());
							System.out.println("Qual será seu espaço?");
							Valorant.setEspacoConta(aux_Conta, in.nextInt());
						}
						//Alterar login da conta
						if(Opcao03 == 3)
						{

						}
						//Alterar valor de um item
						if(Opcao03 == 4)
						{
							System.out.println("\n----------------");
							System.out.println("Qual o nome da conta?");
							Conta aux_Conta = new Conta(in.next());
							System.out.println("Qual o nome do item?");
							Item aux_item = new Item(in.next());
							System.out.println("Qual o valor do item?");
							Valorant.setValorItem(aux_Conta, aux_item.getNome(), in.nextDouble());
						}
						//Alterar nome de um item
						if(Opcao03 == 5)
						{
							
						}
					}while(Opcao03 != 6); //Saindo do menu
				}
				
				//Menu de remover
				if(Opcao == 4)
				{
					int Opcao04;
					do 
					{
						//Opções do menu
						System.out.println("\n----------------");
						System.out.println("\nEscolha a opção: ");
						System.out.println("1 - Remover conta");
						System.out.println("2 - Remover item");
						System.out.println("3 - Sair");
						Opcao04 = in.nextInt();
						
						//Remover conta
						if(Opcao04 == 1)
						{
							System.out.println("\n----------------");
							System.out.println("Qual o nome da conta?");
							Conta aux_Conta = new Conta(in.next());
							Valorant.removerConta(aux_Conta);
						}
						//Remover item
						if(Opcao04 == 2)
						{
							
						}
					}while(Opcao04 != 3); //Saindo do menu
				}
				//Listagem por atributo
				if(Opcao == 5)
				{
					int Opcao05;
					do 
					{
						//Opções do menu
						System.out.println("\n----------------");
						System.out.println("\nEscolha a opção: ");
						System.out.println("1 - Listar contas pelo nome");
						System.out.println("2 - Listar contas por valor");
						System.out.println("3 - Listar conta por quantidade de items");
						System.out.println("4 - Listar items de uma conta por nome");
						System.out.println("5 - Listar items de uma conta por valor");
						System.out.println("6 - Sair");
						Opcao05 = in.nextInt();
						
						//Listar contas pelo nome
						if(Opcao05 == 1)
						{
							System.out.println("\n----------------");
							Valorant.listarContas();
						}
						//Listar contas por valor
						if(Opcao05 == 2)
						{
							
						}
						//Listar conta por quantidade de items
						if(Opcao05 == 3)
						{
							
						}
						//Listar items de uma conta por nome
						if(Opcao05 == 4)
						{
							
						}
						//Listar items de uma conta por valor
						if(Opcao05 == 5)
						{
							
						}
					}while(Opcao05 != 6); //Saindo do menu
				}
				//Sair do programa
				if(Opcao == 6)
				{
					System.out.print("\nGravando arquivos...");
					Valorant.gravarCliente();
					bMain = false;
				}
				//Mensagem caso não corresponda a nenhuma opção
				if(Opcao > 6)
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
