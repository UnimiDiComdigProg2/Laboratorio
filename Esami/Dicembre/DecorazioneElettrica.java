public class DecorazioneElettrica extends Decorazione implements Comparable<DecorazioneElettrica> {
//OVERVIEW: Decorazione elettrica che ha una certa potenza richiesta e può essere accesa/spenta

//attributi
	private final double potenza;
	private boolean accesa;

//costruttori
	public DecorazioneElettrica(String nome, double peso, double potenza) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza una nuova DecorazioneElettrica; se potenza <= 0 lancia IllegalArgumentException
		super(nome, peso);
		
		if(potenza <= 0)
			throw new IllegalArgumentException("potenza <= 0");

		this.potenza = potenza;
		this.accesa = false;
	}

//metodi
	public void interruttore() {
	//MODIFIES: this
	//EFFECTS: se spenta accendi, se accesa spegni
		this.accesa = this.accesa ? false : true;
	}

	public double getPotenza() {
		return this.potenza;
	}

	public boolean getAccesa() {
		return this.accesa;
	}

	@Override
	public String toString() {
		return super.toString() + ", potenza: " + this.potenza + (this.accesa ? ", accesa" : ", spenta");
	}

	@Override
	public int compareTo(DecorazioneElettrica o) {
		if(this.potenza > o.potenza)
			return 1;

		if(this.potenza < o.potenza)
			return -1;

		return 0;
	}
}
