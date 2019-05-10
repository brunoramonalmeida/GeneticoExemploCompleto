import java.util.ArrayList;
import java.util.Collections;

public class Principal {

    public static ArrayList<Cromossomo> populacao;
    public static int geracoes = 25;


    public static void main(String args[]) {
        populacao = popInicial();

        for(int i=0;i<geracoes;i++) {
            System.out.println("Geração "+(i+1));
            mostrarPopulacao(populacao);
            torneio();
        }

        System.out.println();
        System.out.println("Resultado final");
        mostrarPopulacao(populacao);
        System.out.println();
        System.out.println("Melhor cromossomo");
        melhorResultado();
    }

    static public ArrayList<Cromossomo> popInicial() {
        ArrayList<Cromossomo> pop = new ArrayList<>();
        pop.add(new Cromossomo());
        pop.add(new Cromossomo());
        pop.add(new Cromossomo());
        pop.add(new Cromossomo());
        return pop;
    }

    static void mostrarPopulacao(ArrayList<Cromossomo> l) {
        for(Cromossomo c: l)
            System.out.println(c);
    }

    static void torneio() {
        ArrayList<Cromossomo> timesA = populacao;
        ArrayList<Cromossomo> timesB = populacao;
        ArrayList<Cromossomo> resultado = new ArrayList<>();
        Collections.shuffle(timesA);
        Collections.shuffle(timesB);
        for(int i=0;i<2;i++) {
            if (timesA.get(i).getAptidao() > timesB.get(i).getAptidao())
                resultado.add(timesA.get(i));
            else
                resultado.add(timesB.get(i));
        }
        populacao = new ArrayList<>();
        populacao.addAll(resultado);
        populacao.addAll(crossOver(resultado.get(0),resultado.get(1)));
    }

    public static ArrayList<Cromossomo> crossOver(Cromossomo c1, Cromossomo c2) {
        Cromossomo filho1 = new Cromossomo();
        filho1.setDNA(c1.getDNA().substring(0,2).concat(c2.getDNA().substring(2,5)));

        Cromossomo filho2 = new Cromossomo();
        filho2.setDNA(c2.getDNA().substring(0,2).concat(c1.getDNA().substring(2,5)));

        ArrayList<Cromossomo> filhos = new ArrayList<>();
        filhos.add(filho1);
        filhos.add(filho2);

        return filhos;
    }

    public static void melhorResultado() {
        Cromossomo melhor = new Cromossomo();
        melhor.setAptidao(Integer.MIN_VALUE);
        for(Cromossomo c: populacao) {
            if (c.getAptidao() > melhor.getAptidao()) {
                melhor = c;
            }
        }
        System.out.println(melhor);
    }
 }
