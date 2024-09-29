public class AdCampaignWebRestyle extends AdCampaign {
//OVERVIEW: modella una campagna pubblicitaria che prevede il redesign del sito web.

//ATTRIBUTES
	final double tVisOld;
	private double tVis = 0;
	private int nVis = 0;

//CONSTRUCTORS
	AdCampaignWebRestyle(String name, double tVisOld) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this
	//         se tVisOld <= 0 lancia IllegalArgumentException
	super(name);

		if(tVisOld <= 0)
			throw new IllegalArgumentException("tVisOld <= 0");

		this.tVisOld = tVisOld;

		assert this.repOK();
	}

//METHODS
	public void update(int nVisNew, double tVisNew) throws IllegalArgumentException, CampaignClosedException {
	//MODIFIES: this
	//EFFECTS: incrementa nVis e ricalcola la media di tVis
	//         se nVisNew <= 0 o tVisNew <= 0 lancia IllegalArgumentException
		this.update();

		if(nVisNew <= 0)
			throw new IllegalArgumentException("nVisNew <= 0");

		if(tVisNew <= 0)
			throw new IllegalArgumentException("tVisNew <= 0");

		this.tVis = ((this.nVis * this.tVis)+(nVisNew * tVisNew))/(this.nVis+nVisNew);
		this.nVis+=nVisNew;

		assert this.repOK();
	}

	@Override
	public double performance() {
		return this.tVis/(this.tVis+this.tVisOld);
	}

	@Override
	public String toString() {
		return "WebRestyle " + super.toString();
	}

	public boolean repOK() {
		if(
			(this.nVis < 0) ||
			(this.tVis < 0)
		) return false;

		return true;
	}
}
