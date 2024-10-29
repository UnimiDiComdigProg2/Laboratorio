import java.util.Scanner;

public class Tris {
//OVERVIEW: Gioco del tris a 2 giocatori con turni alternati
	private char[][] tabellone;
	private boolean turno; //false = primo (`O`), true = secondo (`X`)
	private int conteggio; // Il gioco termina quando il tabellone è pieno (conteggio 0 9)

	public Tris() {
	//MODIFIES: this
	//EFFECTS: inizializza un nuovo tabellone e imposta il turno al primo giocatore (`O`);
		this.tabellone = new char[3][3];
		this.turno = false;
		this.conteggio = 0;

		assert repOk(); //non serve per forza repOk perchè l'inizializzazione è semplice (assegnamenti diretti) e non dipende da parametri, ma è comunque utile in caso di cambiamenti al codice
	}

	public char turno() {
	//EFFECTS: ritorna il carattere del giocatore corrispondente al turno da fare
		return this.turno ? 'X' : 'O';
	}

	public void mossa(int x, int y) throws IllegalArgumentException, PartitaTerminataException {
	//MODIFIES: this
	//EFFECTS: inserisce il carattere del giocatore di turno alla posizione x, y sul tabellone
	//         se la posizione è occupata lancia una IllegalArgumentException
	//         se le coordinate vanno fuori dal tabellone lancia una IllegalArgumentException
		if((x < 0) || (x > 2) || (y < 0) || (y > 2))
			throw new IllegalArgumentException("x e y devono essere tra 1 a 3");

		if(this.tabellone[x][y] != 0)
			throw new IllegalArgumentException("Posizione occupata, riprova");

		if(this.terminato())
			throw new PartitaTerminataException("Mosse finite");

		if(this.vittoria())
			throw new PartitaTerminataException("Ha già vinto l'avversario");

		this.tabellone[x][y] = this.turno ? 'X' : 'O';
		this.turno = !(this.turno);
		this.conteggio++;

		assert repOk();
	}

	public boolean vittoria() {
	//EFFECTS: se il giocatore che ha appena giocato ha vinto restituisce true, altrimenti false
		char curr = this.turno ? 'O' : 'X';

		for(int i=0;i<this.tabellone.length;i++)
			if((this.tabellone[i][0] == curr && this.tabellone[i][1] == curr && this.tabellone[i][2] == curr) || (this.tabellone[0][i] == curr && this.tabellone[1][i] == curr && this.tabellone[2][i] == curr))
				return true;

		if((this.tabellone[0][0] == curr && this.tabellone[1][1] == curr && this.tabellone[2][2] == curr) || (this.tabellone[0][2] == curr && this.tabellone[1][1] == curr && this.tabellone[2][0] == curr))
			return true;

		return false;
	}

	public boolean terminato() {
	//EFFECTS: ritorna true se il tabellone è pieno
		return this.conteggio == 9;
	}

	public boolean repOk() {
		if(conteggio < 0 || conteggio > 9)
			return false;

		if(tabellone == null)
			return false;

		if(tabellone.length != 3)
			return false;

		if(tabellone[0].length != 3)
			return false;

		return true;
	}

	@Override
	public String toString() {
		String ret="\n-----------------\n";
		ret+="|R\\C| 1 | 2 | 3 |\n";
		ret+="-----------------\n";

		for(int i=0;i<this.tabellone.length;i++) {
			ret+="| " + (i + 1) + " |";

			for(int j=0;j<this.tabellone.length;j++)
				if(tabellone[i][j] != 0)
					ret+=" " + tabellone[i][j] + " |";
				else
					ret+="   |";

			ret+="\n-----------------\n";
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean altraPartita = true;

		while(altraPartita) {
			Tris t = new Tris();
			char turno = 0;

			while(true) {
				turno = t.turno();
				System.out.println("Mossa di " + turno);
				System.out.println("Inserisci: x y");
				int riga = s.nextInt();
				int colonna = s.nextInt();

				try {
					t.mossa(riga-1,colonna-1);
					System.out.println(t);
				} catch(IllegalArgumentException | PartitaTerminataException e) {
					System.out.println(e.getMessage());
				}

				if(t.terminato()) {
					System.out.println("Mosse Finite");
					break;
				}

				if(t.vittoria()) {
					System.out.println("Ha vinto " + turno);
					break;
				}
			}

			System.out.println("Un'altra partita? (S/s per si)");
			char ripeti = s.next().charAt(0);

			if (ripeti == 's' || ripeti == 'S')
				altraPartita = true;
			else
				altraPartita = false;
		}
	}
}