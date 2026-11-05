package fr.btsciel;

import com.btsciel.Temps;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;

import static fr.btsciel.ConsoleColors.ANSI_BLUE_BOLD;
import static fr.btsciel.ConsoleColors.ANSI_RED_BOLD;

public class Ihm {

    public static double minMatin = Double.MAX_VALUE;
    public static double maxMatin = Double.MIN_VALUE;
    public static double minAprem = Double.MAX_VALUE;
    public static double maxAprem = Double.MIN_VALUE;
    public static double maxTotal = Double.MIN_VALUE;
    public static double minTotal = Double.MAX_VALUE;

    public static void main(String[] args) {

        double totalMorning = 0;
        double totalEvening = 0;

        String [] j = new String[7];
        Temps[] temperatures = new Temps[7];
        LocalDate date = LocalDate.now();

        for (int i = 0; i < temperatures.length; i++) {
            date = DayOfWeek.from(date.plusDays(i));
            j[i] = toString();
        }


        for (int i = 0; i < temperatures.length; i++) {
            temperatures[i] = new Temps();
            temperatures[i].morning = (Math.random() * 20) - 10;
            temperatures[i].evening = (Math.random() * 20) + 10;
            temperatures[i].day = j[i];
            totalMorning += temperatures[i].morning;
            totalEvening += temperatures[i].evening;
        }

        for (int i = 0; i < temperatures.length; i++) {
            if(temperatures[i].morning < minMatin){
                minMatin = temperatures[i].morning;
            }
            if(temperatures[i].evening < minAprem){
                minAprem = temperatures[i].evening;
            }
            if(temperatures[i].morning > maxMatin){
                maxMatin = temperatures[i].morning;
            }
            if(temperatures[i].evening > maxAprem){
                maxAprem = temperatures[i].evening;
            }
            if(temperatures[i].morning < minTotal){
                minTotal = temperatures[i].morning;
            }
            if(temperatures[i].evening > maxTotal){
                maxTotal = temperatures[i].evening;
            }
        }

        for (int i = 0; i < temperatures.length; i++) {
            System.out.printf("%s%s%s%.1f%s%.1f%s", "Les températures de ",temperatures[i].day, " sont :\nLe Matin : ",  temperatures[i].morning,"\nLe Soir : ", temperatures[i].evening,"\n");
        }

        System.out.printf("%s%.1f%s", "La moyenne des températures du matin de cette semaine est : ", (totalMorning / temperatures.length), "\n");
        System.out.printf("%s%.1f%s", "La moyenne des températures du soir de cette semaine est : ", (totalEvening / temperatures.length), "\n");
        System.out.printf("%s%.1f%s", "La moyenne des températures de cette semaine est : ", ((totalEvening + totalMorning) / (2 * temperatures.length)), "\n");
        System.out.printf("%s%.1f%s", "Cette semaine, la température minimale du matin est : ", minMatin, "\n");
        System.out.printf("%s%.1f%s", "Cette semaine, la température maximale du matin est : ", maxMatin, "\n");
        System.out.printf("%s%.1f%s", "Cette semaine, la température minimale du soir est : ", minAprem, "\n");
        System.out.printf("%s%.1f%s", "Cette semaine, la température maximale du soir est : ", maxAprem, "\n");
        System.out.printf("%s%.1f%s", "Cette semaine, la température minimale est : ", minTotal, "\n");
        System.out.printf("%s%.1f%s", "Cette semaine, la température maximale est : ", maxTotal, "\n");

    }


}
