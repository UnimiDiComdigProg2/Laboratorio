public class Cane extends Pet {
    public Cane(String nome) {
        this.nome = nome;
    }

    @Override
    void verso() {
        System.out.println(this.nome + " dice bau");
    }
}
