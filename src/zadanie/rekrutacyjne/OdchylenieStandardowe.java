/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie.rekrutacyjne;

/**
 *
 * @author Stanisław
 */
public class OdchylenieStandardowe {
    public OdchylenieStandardowe(double tablica[]) {
        double suma = 0.0; 
        double odchylenieStandardowe = 0.0;
        int dlugosc = 0;

        for(double liczba :tablica) {
            if (liczba > 0) {
                suma += liczba;
                dlugosc++;
            }
        }
        
        double srednia = suma/dlugosc;
        
        for(double liczba: tablica) {
            if (liczba > 0) {
                odchylenieStandardowe += Math.pow(liczba - srednia, 2);
            }
        }

        odchylenieStandardowe = Math.sqrt(odchylenieStandardowe/dlugosc);
        
        System.out.println((double)Math.round(odchylenieStandardowe * 10000d) / 10000d);
    }
}
