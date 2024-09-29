import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		Recipe r = new Recipe(args[0],args[1]);
		Stack<Recipe> stack = new Stack<>();
		stack.push(r);

		Scanner s = new Scanner(System.in);

		System.out.println("\tInserisci ingredienti");
		System.out.println("\t\tse è un ingrediente misurabile in pezzi, viene inserito nel formato 'Qty <nome> <quantità>'");
		System.out.println("\t\tse è un ingrediente solido sfuso, viene inserito nel formato 'Wgt <nome> <quantità in l>'");
		System.out.println("\t\tse è un ingrediente liquido, viene inserito nel formato 'Vol <nome> <quantità in kg>'");
		System.out.println("\t\tse l'ingrediente è una sottoricetta, viene inserito nel formato 'Recipe <nome> <procedura>'");
		System.out.println("\t\tper terminare l'inserimento della (sotto)ricetta inserire una riga con solo un carattere '.'");

		while(true) {
			String[] l = s.nextLine().split(" ", 3);

			try {
				if(l[0].equals("Qty")) {
					stack.peek().add(new IngQty(l[1], Integer.parseInt(l[2])));
				} else if(l[0].equals("Wgt")) {
					stack.peek().add(new IngWgt(l[1], Double.parseDouble(l[2])));
				} else if(l[0].equals("Vol")) {
					stack.peek().add(new IngVol(l[1], Double.parseDouble(l[2])));
				} else if(l[0].equals("Recipe")) {
					Recipe t = new Recipe(l[1],l[2]);
					stack.peek().add(t);
					stack.push(t);
				} else if(l[0].equals(".")) {
					stack.pop();
					if(stack.empty())
						break;
				}
			} catch(IngredientException | UnsupportedOperationException e ) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println(r + "\n");

		System.out.println("Riassunto ingredienti:");
		for(Ingredient i : r)
			System.out.println(i);
	}
} 
