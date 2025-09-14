import java.util.Scanner;

public class GerenciadorClinica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilaDeAtendimento fila = new FilaDeAtendimento();
        PilhaHistoricoAtendimentos historico = new PilhaHistoricoAtendimentos();

        boolean rodando = true;

        while (rodando) {
            System.out.println("\n==============================");
            System.out.println("1. Adicionar novo paciente à fila");
            System.out.println("2. Atender próximo paciente");
            System.out.println("3. Exibir fila de atendimento");
            System.out.println("4. Exibir histórico de atendimentos");
            System.out.println("5. Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            // Validação de número SEM try-catch
            if (!sc.hasNextInt()) {
                System.out.println("Opção inválida! Digite um número de 1 a 5.");
                sc.nextLine(); // descartar entrada inválida
                continue;
            }
            int opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            if (opcao == 1) {
                // Adicionar novo paciente
                System.out.print("Nome do paciente: ");
                String nome = sc.nextLine();

                int idade;
                while (true) {
                    System.out.print("Idade do paciente: ");
                    if (sc.hasNextInt()) {
                        idade = sc.nextInt();
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println("Por favor, digite uma idade válida!");
                        sc.nextLine();
                    }
                }

                System.out.print("Sintoma do paciente: ");
                String sintoma = sc.nextLine();

                Paciente p = new Paciente(nome, idade, sintoma);
                fila.adicionarPaciente(p);
                System.out.println("Paciente adicionado à fila com sucesso!");

            } else if (opcao == 2) {
                // Atender próximo paciente
                if (fila.estaVazia()) {
                    System.out.println("Nenhum paciente na fila.");
                } else {
                    Paciente atendido = fila.atenderPaciente();
                    historico.adicionarAoHistorico(atendido);
                    System.out.println("Paciente atendido: " + atendido.exibirInfo());
                }

            } else if (opcao == 3) {
                fila.mostrarFila();

            } else if (opcao == 4) {
                historico.mostrarHistorico();

            } else if (opcao == 5) {
                rodando = false;
                System.out.println("Encerrando o sistema...");

            } else {
                System.out.println("Opção inválida. Digite entre 1 e 5.");
            }
        }
        sc.close();
    }
}
