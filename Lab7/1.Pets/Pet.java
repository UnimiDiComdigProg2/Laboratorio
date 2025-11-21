abstract class Pet {
//OVERVIEW: modella un Pet astratto immutabile

    public final String nome;

    public Pet(String nome) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: inizializza this
    //         se nome null o vuoto lancia IllegalArgumentException
        if(nome == null || nome.equals(""))
            throw new IllegalArgumentException("nome null o vuoto");

        this.nome = nome;
    }

    abstract public String verso();
    //EFFECTS: restituisce il verso dell'animale

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(o == null)
            return false;

        if(!(this.getClass().equals(o.getClass())))
            return false;

        Pet t = (Pet)o;

        if(this.nome.equals(t.nome))
            return true;

        return false;
    }

    @Override
    public String toString() {
        return nome;
    }

    public static void main(String[] args) {

        Pet c = new Cat("Aretha");
        Pet d = new Dog("Axel");
        Pet r = new Rat("Axel");

        System.out.println(c);
        System.out.println(d);
        System.out.println(r);

        System.out.println(d.equals(r));
    }
}