import java.util.*;
import java.lang.*;

public class Piatto implements Cloneable { //DRAGAN: bravo ad averla fatta immutable
	// OVERVIEW: it models a Piatto with
	// unique name and type (primo,secondo,contorno...)
	// note that this class is immutable, and concrete
	// doesn't allow manipulators

	// CLASS ATTRIBUTES:
	private final String nome;
	private final String tipo;
	private final int costo;

	// CONSTRUCTORS:
	public Piatto(String nome, String tipo, int costo) throws IllegalArgumentException {
		// MODIFIES: this statements
		// EFFECTS: it create an unique istance of Piatto
		// note that if costo is < 0 it throws an illegalargumentexception
		if(costo < 0)
			throw new IllegalArgumentException("Costo non può essere minore di 0");
		
		//DRAGAN: aggiunto controllo su nome e tipo null, volendo si potrebbe controllare se vuoti
		if(nome == null)
			throw new IllegalArgumentException("Nome nullo");
		
		if(tipo == null)
			throw new IllegalArgumentException("Tipo nullo");
		
		this.nome = nome;
		this.tipo = tipo;
		this.costo = costo;
		assert repOk();
	}

	// CONCRETE METHODS:
	public String getNome() {// OBSERVER
	// EFFECTS: it returns the name of this
		return this.nome;
	}

	public int getCosto() {// OBSERVER
	// EFFECTS: it returns the costo of this
		return this.costo;
	}

	public String getTipo() { // OBSERVER
		// EFFECTS: it returns the type of this
		return this.tipo;
	}

	public boolean repOk() { // REPRESENTATION INVARIANT
		if ((this.getCosto() < 0) || (nome == null) || (tipo == null)) //DRAGAN: aggiunto controllo su nome e tipo null, volendo si potrebbe controllare se vuoti
			return false;
		
		return true;
	}

	@Override
	public boolean equals(Object o) { // EQUALS
		if (!(o instanceof Piatto))
			return false;
		
		Piatto p = (Piatto) o;
		
		if (this.costo == p.getCosto() && this.nome.equals(p.getNome()) && this.tipo.equals(p.getTipo()))
			return true;
		
		return false;
	}

	@Override
	public String toString() {
		return this.getNome() + ", " + this.getTipo() + ": " + this.getCosto();
	}
	
	//DRAGAN: ho tolto clone, non mi sembra serva
}