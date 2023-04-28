package helpers;

import java.util.Random;
import java.util.Scanner;

public class Processos {
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
        aleatorio = teclado.nextInt();

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

            this.processos[i].setTempoExecucao(tempoExecucao)
                    .setTempoChegada(tempoChegada)
                    .setPrioridade(prioridade)
                    .setTempoRestante(tempoRestante);
        }
    }

    public void imprimeProcessos()
    {
        //Imprime lista de processos
        for (int indice = 0; indice < this.processos.length; indice++) {
            System.out.printf("helpers.Processo[\"%d\"]: %s", indice, this.getProcessoPorIndice(indice));
        }
    }
}
