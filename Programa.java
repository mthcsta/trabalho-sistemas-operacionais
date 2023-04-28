import algoritmos.FCFS;
import algoritmos.PRIORIDADE;
import algoritmos.RoundRobin;
import algoritmos.SJF;
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

        while (emExecucao.get()) {
            System.out.print("Escolha o argoritmo?: [1=FCFS 2=SJF Preemptivo 3=SJF Não Preemptivo  4=Prioridade Preemptivo 5=Prioridade Não Preemptivo  6=Round_Robin  7=Imprime lista de processos 8=Popular processos novamente 9=Sair]: ");
            algoritmoUsado =  teclado.nextInt();

            switch (algoritmoUsado) {
                case 1:
                    FCFS::test(processos);
                    break;
                case 2:
                    SJF::test(true, processos);
                    break;
                case 3:
                    SJF::test(false, processos);
                    break;
                case 4:
                    PRIORIDADE::test(true, processos);
                    break;
                case 5:
                    PRIORIDADE::test(false, processos);
                    break;
                case 6:
                    RoundRobin::test(processos);
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
