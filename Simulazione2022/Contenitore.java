public abstract class Contenitore implements Comparable<Contenitore> {
//OVERVIEW: classe astratta che modella un Contenitore di una Vetreria,
//          con un contenuto di liquido di un certo tipo,
//          e una capienza massima data dal volume del contenitore.

//attributi
	private double contenuto;
	private String liquido;
	private final double capienza;

//costruttori
	Contenitore(double contenuto, String liquido, double capienza) throws IllegalArgumentException, ExceededCapacityException {
	//MODIFIES: this
	//EFFECTS: inizializza la rappresentazione comune di Contenitore
	//         se il volume del contenuto supera la capienza del contenitore, lancia ExceededCapacityException
		if(liquido == null || liquido.equals(""))
			throw new IllegalArgumentException("nome del liquido nullo o vuoto");
		
		if(contenuto <= 0)
			throw new IllegalArgumentException("contenuto <= 0");

		if(capienza <= 0)
			throw new IllegalArgumentException("capienza <= 0");

		if(capienza < contenuto)
			throw new ExceededCapacityException("Il contenitore ha capienza: " + capienza + " ma il liquido ha un volume di: " + contenuto);
		
		this.contenuto = contenuto;
		this.liquido = liquido;
		this.capienza = capienza;
		
		assert repOk();
	}

//metodi
	public double getContenuto() {
	//EFFECTS: restituisce il contenuto;
		return this.contenuto;
	}

	public double getCapienza() {
	//EFFECTS: restituisce la capienza;
		return this.capienza;
	}

	public String getLiquido() {
	//EFFECTS: restituisce il liquido
		return this.liquido;
	}

	public void travasa(Contenitore c) throws IncompatibleLiquidsException, NullPointerException {
	//MODIFIES: this, c
	//EFFECTS: se c è vuoto o ha lo stesso tipo di liquido di this, versa il contenuto di this in c, fino a svuotare this o riempire c
	//         altrimenti lancia IncompatibleLiquidsException
	//         se c è null lancia NullPointerException
	//         se this si svuota, rimuovere il tipo di liquido contenuto.
		if(this.contenuto == 0)
			return;
		
		if(c == null)
			throw new NullPointerException("Il contenitore di destinazione è nullo");
		
		if(c.contenuto == c.capienza)
			return;
		
		if(c.liquido.equals(""))
			c.liquido = this.liquido;
		else
			if(!(this.liquido.equals(c.liquido)))
				throw new IncompatibleLiquidsException("I due contenitori hanno liquidi diversi");
		
		if(this.contenuto + c.contenuto > c.capienza) {
			this.contenuto -= (c.capienza - c.contenuto);
			c.contenuto = c.capienza;
		} else {
			c.contenuto += this.contenuto;
			this.contenuto = 0;
			this.liquido = "";
		}
		
		assert repOk();
	}

	@Override
	public int compareTo(Contenitore c) {
		if(this.capienza > c.capienza)
			return -1;
		else if(this.capienza < c.capienza)
			return 1;
		
		return 0;
	}

	@Override
	public String toString() {
		String ret = "capienza: " + capienza + ", contenuto: " + contenuto;
		ret+= liquido.equals("") ? "" : ", liquido: " + liquido;
		return ret;
	}
	
	public boolean repOk() {
		if(
			(liquido == null) ||
			(contenuto <= 0) ||
			(this.capienza < this.contenuto)
		)
			return false;
		
		return true;
	}
}