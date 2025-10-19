public class NumeriRomani {

    public static int romanAtomAdecimale(String roman) {
    //REQUIRES: roman è un "atomo" romano
    //EFFECTS: restituisce l'intero corrispondente

    switch (roman) {
        case "I":
            return 1;
        case "IV":
            return 4;
        case "V":
            return 5;
        case "IX":
            return 9;
        case "X":
            return 10;
        case "XL":
            return 40;
        case "L":
            return 50;
        case "XC":
            return 90;
        case "C":
            return 100;
        case "CD":
            return 400;
        case "D":
            return 500;
        case "CM":
            return 900;
        case "M":
            return 1000;
        }

        return 0;
    }

    public static boolean romanoValido(String roman) {
    //EFFECTS: se roman è un numero romano valido restituisce true, false altrimenti
        for (int i = 0; i < roman.length(); i++)
            if(romanAtomAdecimale(roman.substring(i, i+1)) == 0)
                return false;

        return true;
    }

    public static int romanoAdecimale(String roman) throws IllegalArgumentException {
    //EFFECTS: restituisce un intero ottenuto dalla conversione del numero romano roman
    //         se non è un numero romano valido lancia IllegalArgumentException
        if(!(romanoValido(roman)))
            throw new IllegalArgumentException("numero romano non valido");

        int res = 0;
        for (int i = 0; i < roman.length(); i++) {
            if(i < roman.length()-1 && romanAtomAdecimale(roman.substring(i, i+1)) < romanAtomAdecimale(roman.substring(i+1, i+2))) {
                res += romanAtomAdecimale(roman.substring(i, i+2));
                i++;
            } else {
                res += romanAtomAdecimale(roman.substring(i, i+1));
            }
        }
        return res;
    }

    public static String decimaleAromano(int decimal) throws IllegalArgumentException {
    //EFFECTS: restituisce una stringa rappresentante un numero romano convertendo il decimal fornito
    //         se decimal <= 0 o >= 4000 lancia IllegalArgumentException

        if(decimal <= 0 || decimal >= 4000)
            throw new IllegalArgumentException("numero decimale non può essere convertito in romano");        

        String res = "";
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] romanValues = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i = 0; i < values.length; i++) {
            while(decimal >= values[i]) {
                decimal -= values[i];
                res += romanValues[i];
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(decimaleAromano(Integer.parseInt(args[0])));
        } catch (NumberFormatException e) {
            try {
                System.out.println(romanoAdecimale(args[0]));
            } catch (IllegalArgumentException f) {
            System.out.println(f.getMessage());
        }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
