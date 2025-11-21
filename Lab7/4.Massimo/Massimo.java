import java.util.Comparator;

public class Massimo<T> {
    //OVERVIEW: modella una classe che mantiene un valore massimo tra quelli inseriti

    T max;
    final Comparator<T> c;

    public Massimo(Comparator<T> c) {
    //MODIFIES: this
    //EFFECTS: inizializza this con un comparator c che può anche essere nullo 
        this.c = c;
    }

    public T getMax() {
    //EFFECTS: restituisce l'elemento massimo inserito
        return max;
    }

    public void insert(T t) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: inserisce t in this se t è maggiore di getMax();
    //         se t null lancia IllegalArgumentException
        if(t == null)
            throw new IllegalArgumentException("t null");

        if(this.max == null)
            this.max = t;
        else if(c != null)
            if(c.compare(t,max) > 0)
                this.max = t;
        else if(t instanceof Comparable)
            if(((Comparable) t).compareTo(this.max) > 0)
                this.max = t;
    }

    @Override
    public String toString() {
        return "Massimo<" + max.getClass().getSimpleName() + ">: " + max;
    }

	public static void main(String[] args) {

        Massimo<Integer> m1 = new Massimo<>(null);

        m1.insert(1);
        m1.insert(5);
        m1.insert(2);

        System.out.println(m1);

        Comparator<String> comp = new Comparator<>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        Massimo<String> m2 = new Massimo<>(comp);
        m2.insert("zasefda");
        m2.insert("aaaaadadadasdsa");



        System.out.println(m2);
    }
}