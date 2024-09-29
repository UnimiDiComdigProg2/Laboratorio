public class TrattaAereo extends Tratta {

    //attributi
        private final double qKm, qFix;
    
    //costruttori
        public TrattaAereo(String ori, String dst, double len, double vel, double qKm, double qFix) throws IllegalArgumentException  {
        //MODIFIES: this
        //EFFECTS: inizializza this, Tratta di tipo TrattaAereo, con quota CO2 per km e fissa per decollo
        //         se qKm <= 0 o qFix <= 0 lancia IllegalArgumentException
    
            super(ori, dst, len, vel);
    
            if(qKm <= 0)
                throw new IllegalArgumentException("qKm <= 0");
 
            if(qFix <= 0)
                throw new IllegalArgumentException("qFix <= 0");
 
            this.qKm = qKm;
            this.qFix = qFix;
        }
    
    //metodi
        @Override
        public double co2prodotta() {
        //EFFECTS: restituisce co2 prodotta come qFix + qKm * len
            return this.qFix + this.qKm * this.getLen();
        }

        @Override
        public String toString() {
            return super.toString() + ", qKm: " + this.qKm + ", qFix: " + this.qFix + " (Aereo)";
        }
    }
    