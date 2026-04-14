import java.util.ArrayList;
import java.util.Scanner;

public class SistemaPagamentos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Colaborador> colaboradores = new ArrayList<>();
        String dado;

        do {
            System.out.println("\nBem vindo ao Sistema de pagamentos!");
            System.out.println("1 - Cadastrar, 2 - Pagamento, 3 - Listar colaboradores, 4 - Sair");

            System.out.print("Digite a opção: ");
            dado = entrada.nextLine();

            switch (dado) {
                case "1":
                    Cadastrocola(entrada, colaboradores);
                    break;

                case "2":
                    Pagamentos(colaboradores);                    
                    break;

                case "3":
                    Listacolaboradores(colaboradores); 
                    break;

                case "4":
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (!dado.equals("4"));

        entrada.close();
    }

    public static void Cadastrocola(Scanner entrada, ArrayList<Colaborador> lista) {
        System.out.println("Tipo:");
        System.out.println("1 - Padrão");
        System.out.println("2 - Comissionado");
        System.out.println("3 - Produção");

        System.out.print("Digite seu nome completo: ");
        String nomecplt = entrada.nextLine();

        System.out.print("Digite seu número de registro: ");
        int numeroregistro = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Digite o seu tipo de colaborador: ");
        String tipo = entrada.nextLine();
        entrada.nextLine();

        Colaborador c = new Colaborador(nomecplt, numeroregistro, tipo);

        if(tipo.equals("2")){
            System.out.print("Digite o valor das vendas: ");
            c.vendas = entrada.nextDouble();

            System.out.print("Digite o percentual: ");
            c.percentual = entrada.nextDouble();
            entrada.nextLine();
        } else if(tipo.equals("3")){
            System.out.print("Digite a quantidade produzida: ");
            c.quantidade = entrada.nextInt();

            System.out.print("Digite o valor por peça: ");
            c.valorPeca = entrada.nextDouble();
            entrada.nextLine();
        }
lista.add(c);
   System.out.println("\nCadastrado com sucesso!"); 
   
}

    public static void Pagamentos(ArrayList<Colaborador> lista) {
        
        int salariobase = 2000;

        if(lista.isEmpty()){
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }
        System.out.println("\nPagamentos dos colaboradores:");
        for(Colaborador c : lista){
            double pagamento = 0;

            switch(c.tipo){
                case "1":
                    pagamento = salariobase;
                    break;

                case "2":
                    pagamento = salariobase + (c.vendas * (c.percentual / 100));
                    break;

                case "3":
                    pagamento = salariobase + (c.quantidade * c.valorPeca);
                    break;
            default:
                System.out.println("Colaborador não encontrado");
                continue;
            }
           
            System.out.println("Nome: " + c.nomecplt + " - Pagamento: R$ " + String.format("%.2f", pagamento));
        }

        
    }

    public static void Listacolaboradores(ArrayList<Colaborador> lista) {
        System.out.println("\nLista de colaboradores:");

        if (lista.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
        } else {
            for (Colaborador c : lista) {
               System.out.println("Nome: " + c.nomecplt+ "\nRegistro: " + c.numeroregistro+ "\nTipo: " + c.tipo);
            }
            }
        }
    }
