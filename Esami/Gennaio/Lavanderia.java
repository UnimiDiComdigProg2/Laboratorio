import java.util.ArrayList;
import java.util.Iterator;

public class Lavanderia implements Iterable<Macchina> {
//OVERVIEW: laundry of washers and dryers

	private ArrayList<Macchina> l = new ArrayList<>();
	private double credit = 0;

	public double addCredit(double c) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: add c to credit
	//         if c <= 0 throw IllegalArgumentException
		if(c <= 0)
			throw new IllegalArgumentException("c <= 0");

		credit += c;

		assert repOk();

		return credit;
	}

	public int install(Macchina m) throws NullPointerException {
	//MODIFIES: this
	//EFFECTS: add m to l
	//         if m null throw NullPointerException
		if(m == null)
			throw new NullPointerException("m nulla");

		Macchina t = m.clone();

		l.add(t);

		assert repOk();

		return l.indexOf(t);
	}

	public void uninstall(int id) throws IllegalArgumentException, IndexOutOfBoundsException {
	//MODIFIES: this
	//EFFECTS: remove id from l
	//         if id < 0 throw IllegalArgumentException
	//         if l[id] does not exist throw IndexOutOfBoundsException
		if(id < 0)
			throw new IllegalArgumentException("id < 0");

		l.remove(id);

		assert repOk();
	}

	public double wash(int id) throws IllegalArgumentException, IndexOutOfBoundsException, UnsupportedOperationException, LockException, CreditException {
	//MODIFIES: l[id]
	//EFFECTS: locks l[id], decreases credit by the amount requested for washing, and returns remaining credit
	//         if id < 0 throw IllegalArgumentException
	//         if l[id] does not exist throw IndexOutOfBoundsException
	//         if l[id] is not Lavatrice throw UnsupportedOperationException
	//         if cost > credit throw CreditException
	//         if l[id] locked throw LockException
		if(id < 0)
			throw new IllegalArgumentException("id < 0");

		if(l.get(id).getClass() != Lavatrice.class)
			throw new UnsupportedOperationException("m non è Lavatrice");

		Lavatrice m = (Lavatrice) l.get(id);

		if(m.cost > credit)
			throw new CreditException("costo > credito");

		credit-= m.cost;

		m.lock();

		return credit;
	}

	public double dry(int id) throws IllegalArgumentException, IndexOutOfBoundsException, UnsupportedOperationException, LockException, CreditException {
		//MODIFIES: l[id]
		//EFFECTS: locks l[id], decreases credit by the amount requested for drying, and returns remaining credit
		//         if id < 0 throw IllegalArgumentException
		//         if l[id] does not exist throw IndexOutOfBoundsException
		//         if l[id] is not Asciugatrice throw UnsupportedOperationException
		//         if cost > credit throw CreditException
		//         if l[id] locked throw LockException
			if(id < 0)
				throw new IllegalArgumentException("id < 0");

			if(l.get(id).getClass() != Asciugatrice.class)
				throw new UnsupportedOperationException("m non è Asciugatrice");

			Asciugatrice m = (Asciugatrice) l.get(id);

			if(m.cost > credit)
				throw new CreditException("costo > credito");

			credit-= m.cost;

			m.lock();

			return credit;
		}

	public void unlock(int id) throws IllegalArgumentException, IndexOutOfBoundsException, LockException {
	//MODIFIES: l[id]
	//EFFECTS: unlocks l[id]
	//         if id < 0 throw IllegalArgumentException
	//         if l[id] does not exist throw IndexOutOfBoundsException
	//         if machine[id] unlocked throw LockException
		if(id < 0)
			throw new IllegalArgumentException("id < 0");

		l.get(id).unlock();
	}

	public Iterator<Macchina> iterator() {
		return new Iterator<Macchina>() {
			Iterator<Macchina> i = l.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Macchina next() {
				return i.next();
			}
		};
	}

	public boolean repOk() {
		if(credit < 0)
			return false;

		for(Macchina m : l)
			if(m == null)
				return false;

		return true;
	}

	public String toString() {
		String ret = "\tLavanderia - credito: " + credit + " macchine:";

		for(int i = 0; i < l.size(); i++)
			ret += "\n\t\t[" + i + "] " + l.get(i);

		return ret;
	}
}