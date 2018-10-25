/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie.rekrutacyjne;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Stanisław
 */
public class ZadanieRekrutacyjne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Pattern code = Pattern.compile("[A-Z]{3}");
        Pattern date = Pattern.compile("[0-9-]{10}");
        
        boolean looping = true;
        while (looping) {
            try {
                System.out.println("Proszę podać kod waluty (3 wielkie litery)"
                        + " oraz przedział dat od 2002-01-02, nie większy niż 93 dni, "
                        + "w formacie (rrrr-mm-dd), zatwierdzając każdą informację \"Enterem\"");

                String Kod = scanner.next(code);
                String DataPoczatek = scanner.next(date);
                String DataKoniec = scanner.next(date);
                
                SKKiOS temp = new SKKiOS(Kod, DataPoczatek, DataKoniec);
                
                looping = false;
            }
            catch (Exception e) {
                System.out.println("Błąd w formacie podanych danych!");
                
                scanner.next();
            }
        }
    }
}
