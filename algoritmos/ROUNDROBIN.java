package algoritmos;

import helpers.Processo;
import helpers.Processos;

import java.util.Scanner;

public class ROUNDROBIN extends BaseAlgoritmo {

    public ROUNDROBIN(Processos processos) {
        this.processos = processos;
    }

    @Override
    public void teste() {
        Processos processos1 = processos.getClone();
        Scanner teclado = new Scanner (System.in);
        int fatiaDeTempo =  teclado.nextInt();
        int fatiaDeTempoAtual = fatiaDeTempo;
        int indiceProcessoAtual = 0;
        for (int tempo = 1; hasProximoProcesso(processos1); tempo++) {

            if (fatiaDeTempoAtual == 0) {
                fatiaDeTempoAtual = fatiaDeTempo;
                indiceProcessoAtual = (indiceProcessoAtual + 1) % processos1.getProcessos().length;
            }
            processos1.getProcessoPorIndice(indiceProcessoAtual).setTempoRestante(
                    processos1.getProcessoPorIndice(indiceProcessoAtual).getTempoRestante() - 1
            );
            System.out.printf(
                    "tempo[%d]: processo[%d] restante=%d\n",
                    tempo,
                    indiceProcessoAtual,
                    processos1.getProcessoPorIndice(indiceProcessoAtual).getTempoRestante()
            );
        }

        processos1.imprimeEstatisticas();
    }

    @Override
    public int getProximoProcessoIndice(Processos processos, int tempo) {
        int proximoProcessoIndice = -1;
        for (int indice = 0; indice < processos.getProcessos().length; indice++) {
            Processo processoAtual = processos.getProcessoPorIndice(indice);
            if (processoAtual.getTempoRestante() > 0
                    && tempo >= processoAtual.getTempoChegada()
                    && (
                    proximoProcessoIndice == -1 || processos.getProcessoPorIndice(proximoProcessoIndice).getTempoChegada() > processoAtual.getTempoChegada()
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
