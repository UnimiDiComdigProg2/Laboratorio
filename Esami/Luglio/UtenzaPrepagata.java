public class UtenzaPrepagata extends Utenza {
//OVERVIEW: Utenza prepagata ricaricabile

//attributes
	private int credito = 0;

//constructors
	public UtenzaPrepagata(String numero, String nome) throws IllegalArgumentException {
		super(numero, nome);
	}

//methods
	public void ricarica(int credito) {
	//MODIFIES: this
	//EFFECTS: incrementa rimasti con credito. se credito <= 0 lancia IllegalArgumentException
		if(credito <= 0)
			throw new IllegalArgumentException("credito <= 0");

		this.credito+=credito;
	}

	public int getCredito() {
		return credito;
	}

	protected void setCredito(int credito) {
		this.credito=credito;
	}
	
	@Override
	public void chiama(int durata) throws IllegalArgumentException, TempoEsauritoException {
	//MODIFIES: this
	//EFFECTS: chiama solo se il consumo lo consente, altrimenti lancia una TempoEsauritoException
		if(this.credito < durata)
			throw new TempoEsauritoException("credito esaurito");

		this.credito-=durata;
		super.chiama(durata);
	}

	@Override
	public String toString() {
		return super.toString() + ", credito: " + credito; 
	}

	@Override
	public boolean repOk() {
		if(credito < 0)
			return false;

		return super.repOk();
	}
}