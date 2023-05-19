package algoritmos;

import helpers.Processo;
import helpers.Processos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public boolean hasProximoProcesso(Processos processos) {
        for (Processo processo : processos.getProcessos()) {
            if (processo.getTempoRestante() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setTempoEspera(Processo processo, int tempo) {
        processo.setTempoEspera(tempo - 1);
    }

}
