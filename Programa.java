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
        Scanner teclado = new Scanner (System.in);
        AtomicBoolean emExecucao = new AtomicBoolean(true);

        processos.popularProcessos();
        processos.imprimeProcessos();

        while (emExecucao.get()) {
            System.out.print("Escolha o argoritmo?: \n[1=FCFS 2=SJF Preemptivo 3=SJF Não Preemptivo  4=Prioridade Preemptivo 5=Prioridade Não Preemptivo  6=Round_Robin  7=Imprime lista de processos 8=Popular processos novamente 9=Sair]: \n");
            algoritmoUsado =  teclado.nextInt();

            switch (algoritmoUsado) {
                case 1:
                    System.out.println("Usando FCFS:");
                    new FCFS(processos).teste();
                    System.out.println("Finalizado!");
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
