public class Test {
    public static void main(String[] args) {
        PoliticaSconto a = new ScontoQuantita(5, 4.5, 4, 0.1);
        PoliticaSconto b = new UnoOgniNGratis(5, 4.5, 4);

        PoliticaSconto c = new ScontoCombinato(a, b);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
