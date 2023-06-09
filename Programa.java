import algoritmos.FCFS;
import algoritmos.PRIORIDADENaoPreemptivo;
import algoritmos.PRIORIDADEPreemptivo;
import algoritmos.SJFPreemptivo;
import algoritmos.SJFNaoPreemptivo;
import algoritmos.ROUNDROBIN;
import helpers.Processos;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Programa {
    public static void main(String[] args) {
        int algoritmoUsado;
        int numeroDeProcessos = 3;
        Processos processos = new Processos(numeroDeProcessos);
        Scanner teclado = new Scanner(System.in);
        AtomicBoolean emExecucao = new AtomicBoolean(true);

        processos.popularProcessos();
        processos.imprimeProcessos();

        while (emExecucao.get()) {
            System.out.print(
                    "MENU DE OPÇÕES\n" +
                    "1=FCFS\n" +
                    "2=SJF Preemptivo\n" +
                    "3=SJF Não Preemptivo\n" +
                    "4=Prioridade Preemptivo\n" +
                    "5=Prioridade Não Preemptivo\n" +
                    "6=Round_Robin\n" +
                    "7=Imprime lista de processos\n" +
                    "8=Popular processos novamente\n" +
                    "9=Sair]\n" +
                    "Escolha uma opção: "
            );
            algoritmoUsado =  teclado.nextInt();

            switch (algoritmoUsado) {
                case 1:
                    new FCFS(processos).teste();
                    break;
                case 2:
                    new SJFPreemptivo(processos).teste();
                    break;
                case 3:
                    new SJFNaoPreemptivo(processos).teste();
                    break;
                case 4:
                    new PRIORIDADEPreemptivo(processos).teste();
                    break;
                case 5:
                    new PRIORIDADENaoPreemptivo(processos).teste();
                    break;
                case 6:
                    new ROUNDROBIN(processos).teste();
                    break;
                case 7:
                    processos.imprimeProcessos();
                    break;
                case 8:
                    processos.popularProcessos();
                    processos.imprimeProcessos();
                    break;
                case 9:
                    emExecucao.set(false);
            }
        }

    }
}
