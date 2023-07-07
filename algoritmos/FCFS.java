package algoritmos;

import helpers.Processo;
import helpers.Processos;

public class FCFS extends BaseAlgoritmo {

    public FCFS(Processos processos) {
        this.processos = processos;
    }

    @Override
    public int getProximoProcessoIndice(Processos processos, int tempo) {
        int proximoProcessoIndice = -1;
        for (int indice = 0; indice < processos.getProcessos().length; indice++) {
            if (processos.getProcessoPorIndice(indice).getTempoRestante() > 0) {
                proximoProcessoIndice = indice;
                break;
            }
        }
        if (proximoProcessoIndice != -1) {
            Processo proximoProcesso = processos.getProcessoPorIndice(proximoProcessoIndice);
            proximoProcesso.setTempoRestante(proximoProcesso.getTempoRestante() - 1);
        }
        return proximoProcessoIndice;
    }

    @Override
    public void setTempoEspera(Processo processo, int tempo) {
        processo.setTempoEspera(tempo - 1);
    }

}
