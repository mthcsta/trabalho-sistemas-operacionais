package algoritmos;

import helpers.Processo;
import helpers.Processos;

public class SJFPreemptivo extends BaseAlgoritmo {
    public SJFPreemptivo(Processos processos) {
        this.processos = processos;
    }

    @Override
    public int getProximoProcessoIndice(Processos processos, int tempo) {
        int proximoProcessoIndice = -1;
        for (int indice = 0; indice < processos.getProcessos().length; indice++) {
            Processo processoAtual = processos.getProcessoPorIndice(indice);
            if (processoAtual.getTempoRestante() > 0
                    && tempo >= processoAtual.getTempoChegada()
                    && (
                        proximoProcessoIndice == -1 || (
                                processos.getProcessoPorIndice(proximoProcessoIndice).getPrioridade() < processoAtual.getPrioridade()
                                || (
                                        processos.getProcessoPorIndice(proximoProcessoIndice).getPrioridade() == processoAtual.getPrioridade()
                                                && processos.getProcessoPorIndice(proximoProcessoIndice).getTempoChegada() < processoAtual.getTempoChegada())
                        )
                    )
            ) {
                proximoProcessoIndice = indice;
            }
        }
        for (Processo processo : processos.getProcessos()) {
            if (
                    processo.getTempoRestante() > 0
                    && (proximoProcessoIndice != -1 && processo != processos.getProcessoPorIndice(proximoProcessoIndice))
            ) {
                processo.setPrioridade(processo.getPrioridade() + 1);
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
        processo.setTempoEspera(tempo - processo.getTempoChegada());
    }
}
