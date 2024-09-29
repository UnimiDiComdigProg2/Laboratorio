import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AlberoNatalizio implements Iterable<Decorazione> {
//OVERVIEW: Albero di Natale con Decorazioni;

//attributi
	private final double carico, potenza;
	private ArrayList<Decorazione> decorazioni = new ArrayList<>();

//costruttori
	public AlberoNatalizio(double carico, double potenza) throws IllegalArgumentException, TopperExistsException {
	//MODIFIES: this
	//EFFECTS: inizializza this con carico e potenza. se carico o potenza <= 0 lancia IllegalArgumentException
		if(carico <= 0)
			throw new IllegalArgumentException("carico <= 0");
		
		if(potenza <= 0)
			throw new IllegalArgumentException("potenza <= 0");
		
		this.carico = carico;
		this.potenza = potenza;
		
		assert repOk();
	}

//metodi
	public void add(Decorazione d) throws IllegalArgumentException, WeightReachedException {
	//MODIFIES: this
	//EFFECTS: aggiungi una nuova Decorazione.
	//         se d nulla lancia IllegalArgumentException
	//         se peso di d superiore al carico rimanente lancia WeightReachedException.
	//         se d è puntale e già un puntale presente lancia TopperExistsException
		if(d == null)
			throw new IllegalArgumentException("Non si può aggiungere: Decorazione nulla");
		
		if(this.pesoCorrente() + d.getPeso() > this.carico)
			throw new WeightReachedException("Non si può aggiungere: Carico superato");
		
		if(d.getClass().equals(Puntale.class))
			if(this.countPuntale() > 0)
				throw new TopperExistsException("Non si può aggiungere: Puntale già aggiunto");
		
		this.decorazioni.add(d);
		
		assert repOk();
	}

	public void accendi() {
	//MODIFIES: this
	//EFFECTS: ordina le DE in base alla potenza e accendile fino alla massima potenza sopportata
		ArrayList<DecorazioneElettrica> de = new ArrayList<>();
		
		for(Decorazione d : decorazioni)
			if(d.getClass().equals(DecorazioneElettrica.class))
				de.add((DecorazioneElettrica)d);
		
		de.sort(null);
		
		for(DecorazioneElettrica d : de)
			if(this.potenzaCorrente() + d.getPotenza() <= this.potenza)
				d.interruttore();
		
		assert repOk();
	}

	@Override
	public Iterator<Decorazione> iterator() throws NoSuchElementException {
		return new Iterator<Decorazione>() {
			
			Iterator<Decorazione> i = decorazioni.iterator();
			
			@Override
			public boolean hasNext() {
				return i.hasNext();
			}
			
			@Override
			public Decorazione next() {
				return i.next();
			}
		};
	}

	@Override
	public String toString() {
		return "Albero (Carico: " + this.carico + ", Potenza: " + this.potenza + ")"; 
	}

	private double pesoCorrente() {
	//EFFECTS: restuisci il peso corrente delle decorazioni
		double pesoCorrente = 0;
		
		for (Decorazione decorazione : decorazioni)
			pesoCorrente+=decorazione.getPeso();
		
		return pesoCorrente;
	}
	
	private double potenzaCorrente() {
	//EFFECTS: restuisci la potenza corrente delle decorazioni accese
		double potenzaCorrente = 0;
		
		for(Decorazione decorazione : decorazioni)
			if(decorazione.getClass().equals(DecorazioneElettrica.class))
				if(((DecorazioneElettrica)decorazione).getAccesa())
					potenzaCorrente+=((DecorazioneElettrica)decorazione).getPotenza();
		
		return potenzaCorrente;
	}
	
	private int countPuntale() {
	//EFFECTS: restituisci il conteggio dei puntali
		int c = 0;
		for(Decorazione decorazione : decorazioni)
			if(decorazione.getClass().equals(Puntale.class))
				c++;
				
		return c;
	}

	public boolean repOk() {
		for (Decorazione decorazione : decorazioni)
			if(decorazione == null)
				return false;
		
		if(this.countPuntale() > 1)
			return false;
		
		if(this.pesoCorrente() > this.carico)
			return false;
		
		if(this.potenzaCorrente() > this.potenza)
			return false;
		
		return true;
	}
}