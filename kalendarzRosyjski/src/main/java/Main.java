import com.google.gson.Gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main (String []args) throws IOException {

        String innaData = "";

        String wskazanaData = WybranaData(innaData);

        String api = "https://datazen.katren.ru/calendar/day" + wskazanaData;
//
//        System.out.println(JakaData(api));

        Gson json = new Gson();

        Data obiekt = json.fromJson(JakaData(api), Data.class);

        if (obiekt.holiday ==true) {
            System.out.println("W tym dniu: " + obiekt.date + " w Rosji jest wolne!");
        } else {
            System.out.println("W tym dniu: " + obiekt.date + " Zapomnij o wolnym!");
        }

    }

    public static String JakaData (String api) throws IOException {


        URL data = new URL(api);

        Scanner scan = new Scanner(data.openStream());

        String wypisz = scan.nextLine();

        return wypisz;
    }

    public static String WybranaData (String innaData){

        System.out.println("Wpisz rok ");

        Scanner wpis = new Scanner (System.in);

        String rok = wpis.nextLine();

        System.out.println("Teraz wpisz miesiac ");

        String miesiac = wpis.nextLine();

        System.out.println("Teraz wpisz dzień ");

        String dzien = wpis.nextLine();

        String nowaData = "/" + rok + "-" + miesiac + "-" + dzien + "/";

        return nowaData;
    }

}
