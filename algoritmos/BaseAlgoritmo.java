package algoritmos;

import helpers.Processo;
import helpers.Processos;

public abstract class BaseAlgoritmo {
    protected Processos processos;
    public static void test(Processos processos) {
        return;
    }

    public static void test(boolean prioridade, Processos processos) {
        return;
    }

    public void teste() {
        Processos processos1 = processos.getClone();

        int indiceProcessoAnterior = -1;
        for (int tempo = 1; hasProximoProcesso(processos1); tempo++) {
            int indiceProcessoAtual = getProximoProcessoIndice(processos1, tempo);
            if (indiceProcessoAtual != -1 && indiceProcessoAtual != indiceProcessoAnterior && processos1.getProcessoPorIndice(indiceProcessoAtual).getTempoEspera() == -1) {
                setTempoEspera(processos1.getProcessoPorIndice(indiceProcessoAtual), tempo);
            }
            indiceProcessoAnterior = indiceProcessoAtual;
            if (indiceProcessoAtual == -1) {
                System.out.printf(
                        "tempo[%d]: nenhum processo está pronto\n",
                        tempo
                );
            } else {
                System.out.printf(
                        "tempo[%d]: processo[%d] restante=%d\n",
                        tempo,
                        indiceProcessoAtual,
                        processos1.getProcessoPorIndice(indiceProcessoAtual).getTempoRestante()
                );
            }
        }

        processos1.imprimeEstatisticas();
    }

    public abstract int getProximoProcessoIndice(Processos processos, int tempo);

    public abstract boolean hasProximoProcesso(Processos processos);

    public abstract void setTempoEspera(Processo processo, int tempo);
}
