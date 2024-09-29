public class Cavia extends Pet {
    public Cavia(String nome) {
        this.nome = nome;
    }

    @Override
    void verso() {
        System.out.println(this.nome + " dice squit");
    }
}
