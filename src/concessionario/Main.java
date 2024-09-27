package concessionario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //Variabili di sistema
        String [] marca=new String[10]; //Array di marche auto
        String [] modello=new String[10]; //Array di modelli
        double [] prezzo=new double[10]; //Array di prezzi
        int scelta; //Variabile di scelta per il menù
        int index=0; //Numero di auto inserite
        int temp; //Utile per cose inutili

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
                    index= FunzioniClass.aggAuto(marca,modello,prezzo,index,marca0,modello0,prezzo0);
                    System.out.println("AUTO AGGIUNTA\n\n\n");
                break;
                case 1:
                    System.out.println("VISUALIZZA TUTTE LE AUTO");
                    System.out.println(FunzioniClass.visualizzaAuto(marca,modello,prezzo,index)+"\n");
                break;
                case 2:
                    System.out.println("RICERCA AUTO");
                    if (index==0)
                        System.out.println("NESSUN'AUTO ANCORA REGISTRATA\n");
                    else{
                        System.out.println("Inserire le seguenti informazioni:\n" +
                                "- Marca:");
                        String marca2 =in.nextLine();
                        System.out.println("- Modello:");
                        String modello2 = in.nextLine();
                        int i=FunzioniClass.ricercaMarcaModello(marca,modello,index,marca2,modello2);
                        if (i==-1)
                            System.out.println("Auto non trovata");
                        else
                            System.out.println("AUTO TROVATA: "+marca[i] + "\t" + modello[i] + "\t" + prezzo[i] + "\t\n");
                    }
                break;
                case 3:
                    System.out.println("CANCELLAZIONE DI UN'AUTO");
                    if (index==0)
                        System.out.println("NESSUN'AUTO ANCORA REGISTRATA\n");
                    else{
                        System.out.println("Inserire le seguenti informazioni:\n" +
                                "- Marca:");
                        String marca3 =in.nextLine();
                        System.out.println("- Modello:");
                        String modello3 = in.nextLine();
                        temp=index;
                        index= FunzioniClass.cancellaAuto(marca,modello,prezzo,index,marca3,modello3);
                        if (index==temp)
                            System.out.println("NESSUN AUTO TROVATA\n");
                        else
                            System.out.println("AUTO RIMOSSA\n");
                    }
                break;
                case 4:
                    System.out.println("MODIFICA DATI DI UN'AUTO");
                    if (index==0)
                        System.out.println("NESSUN'AUTO ANCORA REGISTRATA\n");
                    else{
                        System.out.println("Inserire le seguenti informazioni per l'auto da ricercare per essere sostituita:\n" +
                                "- Marca:");
                        String marca4 =in.nextLine();
                        System.out.println("- Modello:");
                        String modello4 = in.nextLine();
                        System.out.println("- Prezzo:");
                        double prezzo4=in.nextDouble();
                        in.nextLine();
                        System.out.println("Inserire le seguenti informazioni per l'auto sostituite:\n" +
                                "- Marca:");
                        String marca41 =in.nextLine();
                        System.out.println("- Modello:");
                        String modello41 = in.nextLine();
                        System.out.println("- Prezzo:");
                        double prezzo41=in.nextDouble();
                        System.out.println(FunzioniClass.modificaDati(marca,modello,prezzo,index,marca4,modello4,prezzo4,marca41,modello41,prezzo41).toUpperCase()+"\n\n");
                    }
                break;
                case 5:
                    System.out.println("VISUALIZZA TUTTE LE AUTO IN ORDINE CRESCENTE DI PREZZO");
                    if (index==0)
                        System.out.println("NESSUN'AUTO ANCORA REGISTRATA\n");
                    else
                        System.out.println(FunzioniClass.visualizzaAutoCrescente(marca,modello,prezzo,index));
                break;
                case 6:
                    if (index==0)
                        System.out.println("NESSUN'AUTO ANCORA REGISTRATA\n");
                    else{
                        System.out.println("VISUALIZZA TUTTE LE AUTO DISEL");
                        System.out.println(FunzioniClass.visualizzaAutoDisel(marca,modello,prezzo,index));
                    }
                break;
                case 7:
                    System.out.println("Buona giornata.");
                break;
                default:
                    System.out.println("Scegli solo una delle opzioni proposte.".toUpperCase());
            }
        }while (scelta!=7);
    }

}
