public class ScontoCombinato extends PoliticaSconto {
//OVERVIEW: massimo tra due politiche sconto

//attributes
    public final PoliticaSconto a;
    public final PoliticaSconto b;

//constructor
    public ScontoCombinato(PoliticaSconto a, PoliticaSconto b) throws NullPointerException, IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: initializes this
    //         if a = null o b = null throw IllegalArgumentException
    //         if a.n != b.n o a.p != b.p throw IllegalArgumentException
        super(a.n, a.p); //also checks NullPointerException

        if(b == null)
            throw new NullPointerException("b null");

        if(a.n != b.n || a.p != b.p)
            throw new IllegalArgumentException("n or p different in a and b");

        this.a = a;
        this.b = b;
    }

//methods
    @Override
    public double calcolaSconto() {
    //EFFECTS: max of a and b
        return Math.max(a.calcolaSconto(), b.calcolaSconto());
    }

    @Override
    public String toString() {
        return "ScontoCombinato=" + calcolaSconto() + "\n\t" + a + "\n\t" + b;
    }
}
