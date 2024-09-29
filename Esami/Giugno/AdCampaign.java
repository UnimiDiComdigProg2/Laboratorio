abstract class AdCampaign implements Comparable<AdCampaign> {
//OVERVIEW: modella una campagna pubblicitaria identificata da un nome.

//ATTRIBUTES
	final String name;
	private boolean open = true;

//CONSTRUCTORS
	AdCampaign(String name) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this
	//         se name null o vuoto lancia InvalidArgumentException
		if(name == null || name.equals(""))
			throw new IllegalArgumentException("name null or empty");

		this.name = name;
	}

//METHODS
	public abstract double performance();
	//EFFECTS: restituisce la performance (tra 0 e 1)

	public void update() throws CampaignClosedException {
	//EFFECTS: se chiusa lancia CampaignClosedException
		if(!this.open)
			throw new CampaignClosedException(this.name + " is closed");
	}

	public String getName() {
		return this.name;
	}

	public boolean isOpen() {
		return this.open;
	}

	public void close() {
	//MODIFIES: this
	//EFFECTS: chiude la campagna
		this.open = false;
	}

	@Override
	public int compareTo(AdCampaign o) {
		if(this.performance() > o.performance())
			return -1;
		else if(this.performance() < o.performance())
			return 1;

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AdCampaign)
			if(this.name.equals(((AdCampaign)obj).name))
				return true;

		return false;
	}

	@Override
	public String toString() {
		return "name: " + this.name + " performance: " + this.performance();
	}
}