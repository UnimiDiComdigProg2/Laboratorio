public class Cat extends Pet {
//OVERVIEW: definisce un Pet di tipo Cat

    public Cat(String nome) {
        super(nome);
    }

    @Override
    public String verso() {
        return "miao";
    }

    @Override
    public String toString() {
        return "Cat: " + super.toString();
    }
}