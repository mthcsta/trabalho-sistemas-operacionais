package algoritmos;

import helpers.Processo;
import helpers.Processos;

public class PRIORIDADEPreemptivo extends BaseAlgoritmo {

    public PRIORIDADEPreemptivo(Processos processos) {
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
                    )
            )
            ) {
                proximoProcessoIndice = indice;
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
        processo.setTempoEspera(tempo - processo.getTempoChegada());
    }
}
