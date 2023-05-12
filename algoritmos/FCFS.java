package algoritmos;

import helpers.Processo;
import helpers.Processos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FCFS extends BaseAlgoritmo {

    Processos processos;

    public FCFS(Processos processos) {
        this.processos = processos;
    }

    public void teste() {
        Processos processos1 = processos.getClone();
        for (int tempo = 0, processoIndice = 0; processoIndice < processos1.getProcessos().length; processoIndice++) {
            Processo processo = processos1.getProcessoPorIndice(processoIndice);
            processo.setTempoEspera(tempo);
            for (int restante = processo.getTempoRestante(); restante > 0; restante--, ++tempo) {
                System.out.printf(
                        "tempo[%d]: processo[%d] restante=%d\n",
                        tempo,
                        processoIndice,
                        restante - 1
                );
            }
        }
        processos1.imprimeEstatisticas();
    }

}
