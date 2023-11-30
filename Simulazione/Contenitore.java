public abstract class Contenitore implements Comparable<Contenitore> {
//OVERVIEW: modella un contenitore ASTRATTO

//attributes
	private double volume;
	final private double capienza;
	private String tipo;

//methods
	public Contenitore(double volume, String tipo, double capienza) throws ExceededCapacityException, IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this con volume di tipo
	//         se volume > capienza lancia ExceededCapacityException
	//         se volume < 0 lancia IllegalArgumentException
	//         se capienza <= 0 lancia IllegalArgumentException
	//         se tipo == null && volume != 0 lancia IllegalArgumentException
	//         se tipo != null && volume == 0 lancia IllegalArgumentException

		if((tipo == null && volume != 0) || (tipo != null && volume == 0))
			throw new IllegalArgumentException("volume e tipo incompatibili");

		if(volume > capienza)
			throw new ExceededCapacityException("volume > capienza");

		if(volume < 0)
			throw new IllegalArgumentException("volume < 0 ");

		if(capienza <= 0)
			throw new IllegalArgumentException("capienza <= 0 ");

		this.volume = volume;
		this.tipo = tipo;
		this.capienza = capienza;

		assert repOk();
	}

	public void versa(Contenitore c) throws NullPointerException, IncompatibleLiquidsException {
	//MODIFIES: this, c
	//EFFECTS: travasa volume di this in c se capienza rimanente di c è sufficiente e hanno lo stesso tipo di liquido o c non ha liquido
	//         se la capienza di c non è sufficiente si travasa fino alla capienza massima
	//         se c null lancia NullPointerException
	//         se tipo di c incompatibile con tipo di this lancia IncompatibleLiquidsException
		if(c == null)
			throw new NullPointerException("c null");

		if(c.tipo == null)
			c.tipo = this.tipo;

		if(!(c.tipo.equals(this.tipo)))
			throw new IncompatibleLiquidsException("tipi di liquido incompatibili");

		if(this.volume == 0)
			return;

		if(c.capienza >= this.volume + c.volume) {
			c.volume+=this.volume;
			this.volume=0;
			this.tipo = null;
		} else {
			this.volume -= c.capienza - c.volume;
			c.volume = c.capienza;
		}

		assert repOk();
		assert c.repOk();
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public int compareTo(Contenitore o) {
		return Double.compare(o.capienza,this.capienza);
	}

	@Override
	public String toString() {
		String ret = "capienza: " + this.capienza + " volume: " + this.volume;
		if(tipo != null)
			ret+= " tipo: " + this.tipo;

		return ret;
	}

	public boolean repOk() {
		if((tipo == null && volume != 0) || (tipo != null && volume == 0))
			return false;

		if(volume > capienza)
			return false;

		if(volume < 0)
			return false;

		if(capienza <= 0)
			return false;

		return true;
	}
}