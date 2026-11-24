package Hotel;


import java.util.Scanner;

public class SistemaHotel {

    static Scanner scanner = new Scanner(System.in);

    static Reserva[] reservas = new Reserva[10];

    static int quantidade = 0;

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE RESERVAS DO HOTEL =====");
            System.out.println("1 - Nova reserva");
            System.out.println("2 - Listar reservas");
            System.out.println("3 - Buscar reserva por nome");
            System.out.println("4 - Ordenar reservas por dias");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    novaReserva();
                    break;

                case 2:
                    listarReservas();
                    break;

                case 3:
                    buscarReserva();
                    break;

                case 4:
                    ordenarReservas();
                    break;

                case 5:
                    System.out.println("Sistema encerrado. Obrigado!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 5);

        scanner.close();
    }

    public static void novaReserva() {

        if (quantidade >= reservas.length) {
            System.out.println("Limite de reservas atingido!");
            return;
        }

        try {
            System.out.print("Nome do hóspede: ");
            String nome = scanner.nextLine();

            System.out.print("Tipo do quarto: ");
            String quarto = scanner.nextLine();

            System.out.print("Número de dias: ");
            int dias = scanner.nextInt();

            System.out.print("Valor da diária: ");
            double diaria = scanner.nextDouble();
            scanner.nextLine();

            Reserva nova = new Reserva(nome, quarto, dias, diaria);

            reservas[quantidade] = nova;
            quantidade++;

            System.out.println("Reserva cadastrada com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Erro: digite números válidos para dias e diária.");
            scanner.nextLine();
        }
    }

    public static void listarReservas() {

        if (quantidade == 0) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        System.out.println("\n LISTA DE RESERVAS ");

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nReserva " + (i + 1));
            System.out.println(reservas[i].toString());
            System.out.println("----------------------------");
        }
    }

    public static void buscarReserva() {

        if (quantidade == 0) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        System.out.print("Digite o nome do hóspede para buscar: ");
        String nomeBusca = scanner.nextLine();

        boolean encontrou = false;

        for (int i = 0; i < quantidade; i++) {

            if (reservas[i].getNomeHospede()
                    .toLowerCase()
                    .contains(nomeBusca.toLowerCase())) {

                System.out.println("\nReserva encontrada:");
                System.out.println(reservas[i].toString());

                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma reserva encontrada com esse nome.");
        }
    }

    public static void ordenarReservas() {

        if (quantidade == 0) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        for (int i = 0; i < quantidade - 1; i++) {

            for (int j = 0; j < quantidade - 1 - i; j++) {

                if (reservas[j].getNumeroDias()
                        < reservas[j + 1].getNumeroDias()) {

                    Reserva auxiliar = reservas[j];

                    reservas[j] = reservas[j + 1];

                    reservas[j + 1] = auxiliar;
                }
            }
        }

        System.out.println("Reservas ordenadas com sucesso!");
        listarReservas();
    }
}