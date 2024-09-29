import java.util.ArrayList;

public class Pitagorica {

    public static ArrayList<ArrayList<Integer> > creaTavolaPitagorica(int n) {

        ArrayList<ArrayList<Integer> > tabella = new ArrayList<ArrayList<Integer> >();

        for(int i = 0; i < n; i++){
            ArrayList<Integer> riga = new ArrayList<Integer>();

            for(int j = 0; j < n; j++){
                riga.add((i+1)*(j+1));
            }

            tabella.add(riga);
        }

        return tabella;
    }

    public static void stampaTavolaPitagorica(ArrayList<ArrayList<Integer> > s) {
        for(int i=0;i<s.size();i++) {
            for(int j=0;j<(s.get(i)).size();j++) {
                System.out.print((s.get(i)).get(j) + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        stampaTavolaPitagorica(creaTavolaPitagorica(n));
    }
}
