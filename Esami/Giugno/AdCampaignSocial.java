public class AdCampaignSocial extends AdCampaign {
//OVERVIEW: modella una campagna pubblicitaria mediante post su social.

//ATTRIBUTES
	private int nVis = 0;
	private int nLike = 0;

//CONSTRUCTORS
	AdCampaignSocial(String name) {
	//MODIFIES: this
	//EFFECTS: inizializza this
			super(name);
	}

//METHODS
	@Override
	public double performance() {
		return ((double) this.nLike)/this.nVis;
	}

	public void update(int nVisNew, int nLikeNew) throws IllegalArgumentException, CampaignClosedException {
	//MODIFIES: this
	//EFFECTS: incrementa nVis e nLike coi nuovi valori
	//         se nVisNew <= 0 o nLikeNew <= 0 o nVisNew > nLikeNew lancia IllegalArgumentException
		this.update();

		if(nVisNew <= 0)
			throw new IllegalArgumentException("nVisNew <= 0");

		if(nLikeNew <= 0)
			throw new IllegalArgumentException("nLikeNew <= 0");

		if(nVisNew < nLikeNew)
			throw new IllegalArgumentException("nVisNew < nLikeNew");

		this.nVis+=nVisNew;
		this.nLike+=nLikeNew;

		assert this.repOK();
	}

	@Override
	public String toString() {
		return "Social " + super.toString();
	}

	public boolean repOK() {
		if(
			(nVis < 0) ||
			(nLike < 0) ||
			(nVis < nLike)
		) return false;

		return true;
	}
}