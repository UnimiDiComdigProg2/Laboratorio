public class Rat extends Pet {
//OVERVIEW: definisce un Pet di tipo Rat

    public Rat(String nome) {
        super(nome);
    }

    @Override
    public String verso() {
        return "squik";
    }

    @Override
    public String toString() {
        return "Rat: " + super.toString();
    }
}