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
        int fatiaDeTempo;
        int fatiaDeTempoAtual;
        int indiceProcessoAtual = 0;

        System.out.print("Escolha o Time slice: ");
        fatiaDeTempo = teclado.nextInt();
        fatiaDeTempoAtual = fatiaDeTempo;

        for (int tempo = 1; hasProximoProcesso(processos1); tempo++, fatiaDeTempoAtual--) {
            if (fatiaDeTempoAtual == 0 || processos1.getProcessoPorIndice(indiceProcessoAtual).getTempoRestante() == 0) {
                fatiaDeTempoAtual = fatiaDeTempo;
                indiceProcessoAtual = getProximoProcessoIndice(processos1, (indiceProcessoAtual + 1) % processos.getProcessos().length);
            }
            System.out.printf(
                    "tempo[%d]: processo[%d] restante=%d\n",
                    tempo,
                    indiceProcessoAtual,
                    processos1.getProcessoPorIndice(indiceProcessoAtual).getTempoRestante()
            );
            processos1.getProcessoPorIndice(indiceProcessoAtual).setTempoRestante(
                    processos1.getProcessoPorIndice(indiceProcessoAtual).getTempoRestante() - 1
            );
        }

    }

    @Override
    public int getProximoProcessoIndice(Processos processos, int indiceProcessoAtual) {
        try {
            if (indiceProcessoAtual >= processos.getProcessos().length) {
                return getProximoProcessoIndice(processos, 0);
            }
            if (processos.getProcessoPorIndice(indiceProcessoAtual).getTempoRestante() <= 0) {
                return getProximoProcessoIndice(processos, indiceProcessoAtual + 1);
            }
            return indiceProcessoAtual;
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public void setTempoEspera(Processo processo, int tempo) {
        processo.setTempoEspera(tempo);
    }
}
