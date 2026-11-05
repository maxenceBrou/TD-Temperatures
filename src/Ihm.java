import java.util.Random;

public class Ihm {
    private static double [] temperatures = new double[14];
    public static Random random = new Random();
    public static double minMatin = Double.MAX_VALUE;
    public static double maxMatin = Double.MIN_VALUE;
    public static double minAprem = Double.MAX_VALUE;
    public static double maxAprem = Double.MIN_VALUE;
    public static double maxTotal = Double.MIN_VALUE;
    public static double minTotal = Double.MAX_VALUE;
    public static double totalTemp;

    public static void main (String[] args){
        randTemp();
        setMinMax();

        System.out.println("Températures du matin :");
        affichageTemp(0);

        System.out.println("\nTempératures de l'après-midi :");
        affichageTemp(1);


        System.out.printf("%s%s%.1f", "\n", "Température minimale du matin = ", minMatin);
        System.out.printf("%s%s%.1f", "\n", "Température maximale du matin = ", maxMatin);

        sortie();

        System.out.printf("%s%s%.1f", "\n", "Température minimale = ", minTotal);
        System.out.printf("%s%s%.1f", "\n", "Température maximale = ", maxTotal);

        System.out.printf("%s%s%.1f", "\n", "Moyenne des températures du matin de la semaine : ", moyenneTotal(0));
        System.out.printf("%s%s%.1f", "\n", "Moyenne des températures de l'aprés-midi de la semaine : ", moyenneTotal(1));
        System.out.printf("%s%s%.1f", "\n", "Moyenne des températures de la semaine : ", ((moyenneTotal(0)+moyenneTotal(1))/2));

    }

    private static void sortie() {
        System.out.printf("%s%s%.1f", "\n", "Température minimale de l'aprés-midi = ", minAprem);
        System.out.printf("%s%s%.1f", "\n", "Température maximale de l'aprés-midi = ", maxAprem);
    }

    public static void setMinMax(){
        for (int i = 0; i < temperatures.length; i += 2){
            if (temperatures[i] < minMatin) {
                minMatin = temperatures[i];
                minTotal = temperatures[i];
            }
            if (temperatures[i] > maxMatin) {
                maxMatin = temperatures[i];
            }
            if (temperatures[i + 1] < minAprem) {
                minAprem = temperatures[i + 1];
            }
            if (temperatures[i + 1] > maxAprem) {
                maxAprem = temperatures[i + 1];
                maxTotal = temperatures[i + 1];
            }
        }
    }

    public static void affichageTemp(int depart) {
        for (int i = depart; i < temperatures.length; i += 2) {
            System.out.printf("%.1f %s", temperatures[i], "\t");
        }
    }

    public static void randTemp(){
        for (int i = 0; i < temperatures.length; i+=2){
            temperatures[i] = -10 + (Math.random()*20);
            temperatures[(i+1)] = 10 + (Math.random()*20);
        }
    }

    public static double moyenneTotal(int index){
        for (int i = index; i < temperatures.length; i+=2){
            totalTemp = temperatures[i];
        }
        return (totalTemp / ((double) temperatures.length / 2));

    }

}
