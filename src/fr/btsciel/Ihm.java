package fr.btsciel;

import com.btsciel.Temps;

import java.util.Random;

import static fr.btsciel.ConsoleColors.ANSI_BLUE_BOLD;
import static fr.btsciel.ConsoleColors.ANSI_RED_BOLD;

public class Ihm {
    public static void main(String[] args) {

        double totalMorning = 0;
        double totalEvening = 0;

        String [] j = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        Temps[] temperatures = new Temps[7];


        for (int i = 0; i < 7; i++) {
            temperatures[i] = new Temps();
            temperatures[i].morning = (Math.random() * 20) - 10;
            temperatures[i].evening = (Math.random() * 20) + 10;
            temperatures[i].day = j[i];
            totalMorning += temperatures[i].morning;
            totalEvening += temperatures[i].evening;
        }

        for (int i = 0; i < temperatures.length; i++) {
            System.out.printf("%s%s%s%.1f%s%.1f%s", "Les températures de ",temperatures[i].day, " sont :\nLe Matin : ",  temperatures[i].morning,"\nLe Soir : ", temperatures[i].evening,"\n");
        }

        System.out.printf("%s%.1f%s", "La moyenne des températures du matin de cette semaine est : ", (totalMorning / temperatures.length), "\n");
        System.out.printf("%s%.1f%s", "La moyenne des températures du soir de cette semaine est : ", (totalEvening / temperatures.length), "\n");
        System.out.printf("%s%.1f%s", "La moyenne des températures de cette semaine est : ", ((totalEvening + totalMorning) / (2 * temperatures.length)), "\n");

    }

}
