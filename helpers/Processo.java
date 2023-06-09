package helpers;

public class Processo {
    int tempoExecucao;
    int tempoChegada;
    int prioridade;
    int tempoEspera;
    int tempoRestante;

    public Processo(int tempoExecucao, int tempoChegada, int prioridade, int tempoEspera, int tempoRestante) {
        this.tempoExecucao = tempoExecucao;
        this.tempoChegada = tempoChegada;
        this.prioridade = prioridade;
        this.tempoEspera = tempoEspera;
        this.tempoRestante = tempoRestante;
    }

    public Processo(Processo processo) {
        this.tempoExecucao = processo.getTempoExecucao();
        this.tempoChegada = processo.getTempoChegada();
        this.prioridade = processo.getPrioridade();
        this.tempoEspera = processo.getTempoEspera();
        this.tempoRestante = processo.getTempoRestante();
    }

    public Processo(int tempoExecucao, int tempoChegada, int prioridade, int tempoRestante) {
        this.tempoExecucao = tempoExecucao;
        this.tempoChegada = tempoChegada;
        this.prioridade = prioridade;
        this.tempoEspera = -1;
        this.tempoRestante = tempoRestante;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public Processo setTempoExecucao(int tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
        return this;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public Processo setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
        return this;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public Processo setPrioridade(int prioridade) {
        this.prioridade = prioridade;
        return this;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public Processo setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
        return this;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public Processo setTempoRestante(int tempoRestante) {
        this.tempoRestante = tempoRestante;
        return this;
    }

    public String toString() {
        return String.format("tempo_execucao=\"%d\" " +
                "tempo_restante=\"%d\" " +
                "tempo_chegada=\"%d\" " +
                "prioridade =\"%d\" ",
                tempoExecucao,
                tempoRestante,
                tempoChegada,
                prioridade);
    }

    public Processo getClone() {
        return new Processo(this);
    }
}
