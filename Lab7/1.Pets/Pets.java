import java.util.ArrayList;
import java.util.Scanner;

public class Pets {
	public static void main(String[] args) {

        ArrayList<Person> persons = new ArrayList<>();

        Scanner s = new Scanner(System.in);

        while(s.hasNextLine()) {

            String line = s.nextLine();

            String[] lineParts = line.split(" ");

            Person p = new Person(lineParts[0]);

            int personId = persons.indexOf(p);

            if(personId != -1)
                p = persons.get(personId);
            else
                persons.add(p);

            try {
                if(lineParts[2].equals("Cane"))
                    p.add(new Dog(lineParts[1]));
                else if(lineParts[2].equals("Gatto"))
                    p.add(new Cat(lineParts[1]));
                else if(lineParts[2].equals("Cavia"))
                    p.add(new Rat(lineParts[1]));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for(Person tp : persons)
            System.out.println(tp);
    }
}