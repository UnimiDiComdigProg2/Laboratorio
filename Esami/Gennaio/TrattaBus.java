public class TrattaBus extends Tratta {

    //attributi
        private final double qHr;
    
    //costruttori
        public TrattaBus(String ori, String dst, double len, double vel, double qHr) throws IllegalArgumentException  {
        //MODIFIES: this
        //EFFECTS: inizializza this, Tratta di tipo TrattaBus, con quota CO2 per ora
        //         se qHr <= 0 lancia IllegalArgumentException
    
            super(ori, dst, len, vel);
    
            if(qHr <= 0)
                throw new IllegalArgumentException("qHr <= 0");
    
            this.qHr = qHr;
        }
    
    //metodi
        @Override
        public double co2prodotta() {
        //EFFECTS: restituisce co2 prodotta come qHr * durata
            return this.qHr * this.durata();
        }

        @Override
        public String toString() {
            return super.toString() + ", qHr: " + this.qHr + " (Bus)";
        }
    }
    