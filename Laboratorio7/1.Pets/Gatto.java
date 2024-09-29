public class Gatto extends Pet {
    public Gatto(String nome) {
        this.nome = nome;
    }

    @Override
    void verso() {
        System.out.println(this.nome + " dice miao");
    }
}
