package concessionario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //Variabili di sistema
        String [] marca=new String[100]; //Array di marche auto
        String [] modello=new String[100]; //Array di modelli
        double [] prezzo=new double[100]; //Array di prezzi
        int scelta; //Variabile di scelta per il menù
        int index=0; //Numero di auto inserite

        //Ciclo effettivo
        do {
            System.out.println("Benvenuto nel gestionale della concessionaria ####.\nScegli una tra le seguenti opzioni:");
            System.out.println("0- Aggiunta di una nuova auto;\n" +
                    "1- Visualizzazione di tutte le auto;\n" +
                    "2- Ricerca di un'auto tramite marca e modello;\n" +
                    "3- Cancellazione di un'auto;\n" +
                    "4- Modifica dei dati di un'auto;\n" +
                    "5- Visualizzazione delle auto in ordine crescente;\n" +
                    "6- Visualizzare tutti i modelli che diesel;\n" +
                    "7- Esci.");
            scelta=in.nextInt();
            in.nextLine();
            switch (scelta){
                case 0:
                    System.out.println("AGGIUNTA DI UNA NUOVA AUTO");
                    System.out.println("Inserire le seguenti informazioni:\n" +
                            "- Marca:");
                    String marca0 =in.nextLine();
                    System.out.println("- Modello:");
                    String modello0 = in.nextLine();
                    System.out.println("- Prezzo:");
                    double prezzo0=in.nextDouble();
                    index=funzioniClass.aggAuto(marca,modello,prezzo,index,marca0,modello0,prezzo0);
                    System.out.println("AUTO AGGIUNTA\n\n\n");
                break;
                case 1:
                    System.out.println("VISUALIZZA TUTTE LE AUTO");
                    System.out.println(funzioniClass.visualizzaAuto(marca,modello,prezzo,index));
                break;
                case 2:
                    System.out.println("RICERCA AUTO");
                    System.out.println("Inserire le seguenti informazioni:\n" +
                            "- Marca:");
                    String marca2 =in.nextLine();
                    System.out.println("- Modello:");
                    String modello2 = in.nextLine();
                    System.out.println(funzioniClass.ricercaMarcaModello(marca,modello,prezzo,index,marca2,modello2));
                break;
                case 3:
                    System.out.println("CANCELLAZIONE DI UN'AUTO");
                    System.out.println("Inserire le seguenti informazioni:\n" +
                            "- Marca:");
                    String marca3 =in.nextLine();
                    System.out.println("- Modello:");
                    String modello3 = in.nextLine();
                    System.out.println("- Prezzo:");
                    double prezzo3=in.nextDouble();
                    index=funzioniClass.cancellaAuto(marca,modello,prezzo,index,marca3,modello3,prezzo3);
                    if (index<0)
                        index=0;
                    System.out.println("AUTO RIMOSSA\n\n\n");
                break;
                case 4:
                    System.out.println("MODIFICA DATI DI UN'AUTO");
                    System.out.println("Inserire le seguenti informazioni per l'auto da ricercare per essere sostituita:\n" +
                            "- Marca:");
                    String marca4 =in.nextLine();
                    System.out.println("- Modello:");
                    String modello4 = in.nextLine();
                    System.out.println("- Prezzo:");
                    double prezzo4=in.nextDouble();
                    System.out.println("Inserire le seguenti informazioni per l'auto sostituite:\n" +
                            "- Marca:");
                    String marca41 =in.nextLine();
                    System.out.println("- Modello:");
                    String modello41 = in.nextLine();
                    System.out.println("- Prezzo:");
                    double prezzo41=in.nextDouble();
                    System.out.println(funzioniClass.modificaDati(marca,modello,prezzo,index,marca4,modello4,prezzo4,marca41,modello41,prezzo41)+"\n\n\n");
                break;
                case 5:
                    System.out.println("VISUALIZZA TUTTE LE AUTO IN ORDINE CRESCENTE DI PREZZO");
                    System.out.println(funzioniClass.visualizzaAutoCrescente(marca,modello,prezzo,index));
                break;
                case 6:
                    System.out.println("VISUALIZZA TUTTE LE AUTO DISEL");
                    System.out.println(funzioniClass.visualizzaAutoDiselNoCharSequence(marca,modello,prezzo,index));
                break;
                case 7:
                    System.out.println("Buona giornata.");
                break;
                default:
                    System.out.println("Scegli solo una delle opzioni scelte.");
            }
        }while (scelta!=7);
    }

}
