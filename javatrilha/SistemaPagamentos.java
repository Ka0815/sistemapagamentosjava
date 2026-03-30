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
                    Pagamentos(entrada);
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

        System.out.println("\nCadastrado com sucesso!");
        Colaborador c = new Colaborador(nomecplt, numeroregistro );
lista.add(c);
    }

    public static void Pagamentos(Scanner entrada) {
        System.out.println("1 - Padrão");
        System.out.println("2 - Comissionado");
        System.out.println("3 - Produção");

        int salariobase = 2000;

        System.out.print("Digite o tipo de funcionário: ");
        String funcio = entrada.nextLine();

        if (funcio.equals("1")) {
            System.out.println("Seu salário é: " + salariobase);

        } else if (funcio.equals("2")) {
            System.out.print("Digite quanto você vendeu: ");
            int vendas = entrada.nextInt();

            System.out.print("Digite o percentual: ");
            double percentual = entrada.nextDouble();
            entrada.nextLine();

            double comissao = (vendas * percentual) / 100;
            double salariototal = salariobase + comissao;

            System.out.println("Seu salário total é: " + salariototal);

        } else if (funcio.equals("3")) {
            System.out.print("Digite o valor por peça: ");
            double valorpeca = entrada.nextDouble();

            System.out.print("Digite a quantidade produzida: ");
            int qtdprod = entrada.nextInt();
            entrada.nextLine(); 

            double bonus = valorpeca * qtdprod;
            double salariotot = salariobase + bonus;

            System.out.println("Seu salário total é: " + salariotot);

        } else {
            System.out.println("Opção inválida, tente novamente!");
        }
    }

    public static void Listacolaboradores(ArrayList<Colaborador> lista) {
        System.out.println("\nLista de colaboradores:");

        if (lista.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
        } else {
            for (Colaborador c : lista) {
               System.out.println("Nome: " + c.nomecplt+ "Registro:"+ c.numeroregistro );
            }
            }
        }
    }
