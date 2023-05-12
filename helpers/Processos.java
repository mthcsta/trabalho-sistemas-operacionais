package helpers;

import java.util.Random;
import java.util.Scanner;

public class Processos implements Cloneable {
    Processo[] processos;

    public Processos(int numeroDeProcessos) {
        this.processos = new Processo[numeroDeProcessos];
    }

    public Processo getProcessoPorIndice(int indice) {
        return this.processos[indice];
    }

    public void popularProcessos()
    {
        int aleatorio, tempoExecucao, tempoChegada, prioridade, tempoRestante;
        Random random = new Random();
        Scanner teclado = new Scanner (System.in);

        System.out.print("Será aleatório?:  ");
        aleatorio = 2; //teclado.nextInt();

        if (aleatorio == 2) {
            this.processos[0] = new Processo(10, 3, 9, 10);
            this.processos[1] = new Processo(7, 7, 7, 7);
            this.processos[2] = new Processo(3, 2, 15, 3);
        } else {
            for (int i = 0; i < this.processos.length; i++) {
                //Popular helpers.Processos Aleatorio
                if (aleatorio == 1){
                    tempoExecucao = random.nextInt(10)+1;
                    tempoChegada = random.nextInt(10)+1;
                    prioridade = random.nextInt(10)+1;
                }
                //Popular helpers.Processos Manual
                else {
                    System.out.print("Digite o tempo de execução do processo["+i+"]:  ");
                    tempoExecucao = teclado.nextInt();
                    System.out.print("Digite o tempo de chegada do processo["+i+"]:  ");
                    tempoChegada = teclado.nextInt();
                    System.out.print("Digite a prioridade do processo["+i+"]:  ");
                    prioridade = teclado.nextInt();
                }
                tempoRestante = tempoExecucao;

                this.processos[i] = new Processo(tempoExecucao, tempoChegada, prioridade, tempoRestante);
            }
        }

    }

    public void imprimeProcessos()
    {
        //Imprime lista de processos
        for (int indice = 0; indice < this.processos.length; indice++) {
            System.out.printf("Processo[\"%d\"]: %s\n", indice, this.getProcessoPorIndice(indice));
        }
    }

    public Processo[] getProcessos() {
        return processos;
    }

    public Processos getClone() {
        try {
            return (Processos) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean hasProcessoIndice(int processoIndice) {
        return processoIndice > 0 && processoIndice < this.processos.length;
    }

    public void setProcesso(int processoIndice, Processo processo) {
        this.processos[processoIndice] = processo;
    }

    public void imprimeEstatisticas() {
        float tempoMedio = 0;
        for (int indice = 0; indice < processos.length; indice++) {
            int tempoEspera = getProcessoPorIndice(indice).getTempoEspera();
            tempoMedio += tempoEspera;
            System.out.printf("Processo[%d]: tempo_espera=%d\n", indice, tempoEspera);
        }
        tempoMedio /= processos.length;
        System.out.printf("Tempo médio de espera: %f", tempoMedio);
    }
}
