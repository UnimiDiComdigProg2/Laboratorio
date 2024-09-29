import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CompanyAds implements Iterable<AdCampaign>{
//OVERVIEW: campagne pubblicitarie per un'azienda.

//ATTRIBUTES
	final String name;
	private HashMap<String,AdCampaign> campaigns = new HashMap<>();

//CONSTRUCTORS
	public CompanyAds(String name) {
	//MODIFIES: this
	//EFFECTS: inizializza this
	//         se name == null o name.equals("") lancia IllegalArgumentException
		if(name == null || name.equals(""))
			throw new IllegalArgumentException("name empty or null");

		this.name = name;
	}

//METHODS
	public void addCampaign(AdCampaign c) throws IllegalArgumentException, CampaignExistsException {
	//MODIFIES: this
	//EFFECTS: aggiungi c a campaigns
	//         se c == null lancia IllegalArgumentException
	//         se esiste già lancia CampaignExistsException
		if(c == null)
			throw new IllegalArgumentException("c null");

		if(campaigns.containsKey(c.getName()))
			throw new CampaignExistsException(c.getName() + " already exists");

		this.campaigns.put(c.getName(), c);

		assert repOk();
	}

	public AdCampaign getCampaign(String name) {
	//EFFECTS: restituisce campagna con name
		return campaigns.get(name);
	}

	public Iterator<AdCampaign> iterator() {
	//EFFECTS: restituisce iteratore a campagne
		ArrayList<AdCampaign> tmp = new ArrayList<>(this.campaigns.values());

		tmp.sort(null);

		return new Iterator<AdCampaign>() {

			Iterator<AdCampaign> i = tmp.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public AdCampaign next() {
				return i.next();
			}  
		};
	}
	
	@Override
	public String toString() {
		String ret = "\nCampagne di " + this.name + ":\n";
		
		for(AdCampaign c : this)
			ret+= "\t" + c + "\n";
		
		return ret;
	}

	public boolean repOk() {
		for (AdCampaign c : campaigns.values())
			if(c == null)
				return false;

		return true;
	}
}