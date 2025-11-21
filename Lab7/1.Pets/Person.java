import java.util.ArrayList;
import java.util.Iterator;

public class Person implements Iterable<Pet> {
//OVERVIEW: modella una Person (mutabile)

    final public String nome;
    private ArrayList<Pet> pets = new ArrayList<>();

    public Person(String nome) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: inizializza this
    //         se nome null o vuoto lancia IllegalArgumentException
        if(nome == null || nome.equals(""))
            throw new IllegalArgumentException("nome null o vuoto");

        this.nome = nome;
    }

    public void add(Pet p) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: aggiunge p a this
    //         se p == null lancia IllegalArgumentException
    //         se p esiste in this lancia IllegalArgumentException
        if(p == null)
            throw new IllegalArgumentException("p null");

        if(pets.contains(p))
            throw new IllegalArgumentException("p esiste");

        pets.add(p);

        assert repOk();
    }

    public void rem(String petName) {
    //MODIFIES: this
    //EFFECTS: rimuove pet p col nome perName da this
    //         se petName == null o vuota lancia IllegalArgumentException
    //         se pet col nome petName non esiste in this lancia IllegalArgumentException
        if(petName == null || petName.equals(""))
            throw new IllegalArgumentException("nome pet nullo o vuoto");

        for(Pet p : pets) {
            if(p.nome.equals(petName)) {
               pets.remove(p);

               assert repOk();

               return; 
            }
        }

        throw new IllegalArgumentException("pet con quel nome non trovato");
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {

            Iterator<Pet> i = pets.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Pet next() {
                return i.next();
            }
        };
    }

    @Override
    public String toString() {
        String res = "Persona (" + nome + ")\n";

        for(Pet p : this)
            res+= "\t" + p.nome + " dice " + p.verso() + "\n";

        return res;
    }

    public boolean repOk() {
        if(nome == null || nome.equals(""))
            return false;

        for(Pet p : pets)
            if(p == null)
                return false;

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(o == null)
            return false;

        if(!(this.getClass().equals(o.getClass())))
            return false;

        Person t = (Person)o;

        if(this.nome.equals(t.nome))
            return true;

        return false;
    }

	public static void main(String[] args) {

        Person p = new Person("Aldo");

        p.add(new Dog("ringhio"));
        p.add(new Cat("silvestro"));
        p.add(new Rat("lara"));

        System.out.println(p);
    }
}