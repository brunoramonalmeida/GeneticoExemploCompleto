import java.util.Random;

public class Cromossomo {
    int aptidao;
    int valor;
    String DNA;

    public Cromossomo(int valor) {
        this.valor = valor;
        calcAptidao();
        generateDNA();
    }

    public Cromossomo() {
        this.valor = new Random().nextInt(31);
        calcAptidao();
        generateDNA();
    }

    public int getAptidao() {
        return aptidao;
    }

    public void setAptidao(int aptidao) {
        this.aptidao = aptidao;
    }

    public String getDNA() {
        return DNA;
    }

    public void setDNA(String DNA) {
        this.DNA = DNA;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    private int calcAptidao() {
        this.aptidao = valor*valor;
        return valor*valor;
    }

    private void generateDNA() {
        String x = Integer.toBinaryString(this.valor);
        this.DNA = String.format("%5s", x).replace(' ', '0');
    }

    @Override
    public String toString() {
        return "X = "+this.getValor()+" DNA="+this.getDNA()+ " Aptidão="+this.getAptidao();
    }
}
