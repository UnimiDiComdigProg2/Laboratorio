public class TrattaTreno extends Tratta {

//attributi
    private final double qKm;

//costruttori
    public TrattaTreno(String ori, String dst, double len, double vel, double qKm) throws IllegalArgumentException  {
    //MODIFIES: this
    //EFFECTS: inizializza this, Tratta di tipo TrattaTreno, con quota CO2 per km
    //         se qKm <= 0 lancia IllegalArgumentException

        super(ori, dst, len, vel);

        if(qKm <= 0)
            throw new IllegalArgumentException("qKm <= 0");

        this.qKm = qKm;
    }

//metodi
    @Override
    public double co2prodotta() {
    //EFFECTS: restituisce co2 prodotta come qKm * len
        return this.qKm * this.getLen();
    }
    
    @Override
    public String toString() {
        return super.toString() + ", qKm: " + this.qKm + " (Treno)";
    }
}
