public class Dog extends Pet {
//OVERVIEW: definisce un Pet di tipo Dog

    public Dog(String nome) {
        super(nome);
    }

    @Override
    public String verso() {
        return "bau";
    }

    @Override
    public String toString() {
        return "Dog: " + super.toString();
    }
}