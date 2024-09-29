abstract class Tratta {
//OVERVIEW: modella una Tratta tra due luoghi

//attributi
    private final double len, vel;
    private final String ori, dst;

//costruttori
    public Tratta(String ori, String dst, double len, double vel) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: inizializza this con nome luogo ori e nome luogo dst, lunghezza tratta e velocità vel.
    //         se len o vel <= 0, oppure se ori o dst sono null o "" lancia IllegalArgumentException
        if(ori == null || ori.equals(""))
            throw new IllegalArgumentException("ori null o vuota");
            
        if(dst == null || dst.equals(""))
            throw new IllegalArgumentException("dst null o vuota");
            
        if(len <= 0)
            throw new IllegalArgumentException("len <=0");

        if(vel <= 0)
            throw new IllegalArgumentException("vel <=0");
        
        this.ori = ori;
        this.dst = dst;
        this.len = len;
        this.vel = vel;
    }

//metodi astratti
    public abstract double co2prodotta();
    //EFFECTS: restituisce la quantità di CO2 prodotta per la tratta

//metodi concreti
    public double getLen() {
        return len;
    }

    public double getVel() {
        return vel;
    }

    public String getOri() {
        return ori;
    }

    public String getDst() {
        return dst;
    }

    public double durata() {
    //EFFECTS: restituisce la durata in ore della tratta
        return this.len/this.vel;
    }

    @Override
    public String toString() {
        return "Tratta tra " + this.ori + " e " + this.dst + "; lunghezza: " + this.len + ", velocità: " + this.vel;
    }
}