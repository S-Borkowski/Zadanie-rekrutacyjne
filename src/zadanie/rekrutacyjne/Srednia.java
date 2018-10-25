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
public class Srednia {
    public Srednia (double tablica[]) {
        double suma = 0.0;
        int dlugosc = 0;

        for(double liczba :tablica) {
            if (liczba > 0) {
                suma += liczba;
                dlugosc++;
            }
        }

        double srednia = suma/dlugosc;
        System.out.println((double)Math.round(srednia * 10000d) / 10000d);
    }
}
