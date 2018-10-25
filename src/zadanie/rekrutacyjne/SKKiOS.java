package zadanie.rekrutacyjne;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanisław
 */
public class SKKiOS {
    public SKKiOS (String Kod, String DataPoczatek, String DataKoniec) {
        double[] sprzedaz;
        double[] kupno;
        sprzedaz = new double[93];
        kupno = new double[93];
            
        try {
            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/C/" 
                    + Kod + "/" + DataPoczatek + "/" + DataKoniec + "/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            
            BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
            String inputLine;
            
            inputLine = in.readLine();
            
            int i = 0;
            while (inputLine.contains("bid")) {
                kupno[i] = Double.parseDouble(inputLine.substring(inputLine.indexOf("bid\":")+5, inputLine.indexOf(",\"ask")));
                sprzedaz[i] = Double.parseDouble(inputLine.substring(inputLine.indexOf("ask\":")+5, inputLine.indexOf("}")));
                inputLine = inputLine.replaceFirst("bid", "");
                inputLine = inputLine.replaceFirst("ask", "");
                inputLine = inputLine.replaceFirst("}", "");
                i++;
            }
            in.close();
            con.disconnect();
            
            Srednia srednia = new Srednia(kupno);
            OdchylenieStandardowe os = new OdchylenieStandardowe(sprzedaz);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
