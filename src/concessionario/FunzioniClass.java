package concessionario;

public class FunzioniClass {
    //aggiunta di una nuova auto
    public static int aggAuto (String [] marca,String [] modello,double [] prezzo, int index, String marcaNuova, String modelloNuovo, double prezzoNuovo){
        marca[index]=marcaNuova;
        modello[index]=modelloNuovo;
        prezzo[index]=prezzoNuovo;
        index+=1;
        return index;
    }
    //Visualizzazione di tutte le auto
    public static String visualizzaAuto (String [] marca,String [] modello,double [] prezzo, int index){
        if (index == 0)
            return "Nessun'auto trovata";
        else{
            String s="";
            for (int i=0;i<index;i++){
                s=s+marca[i]+"\t"+modello[i]+"\t"+prezzo[i]+"€\t\n";
            }
            return s;
        }
    }
    // ricerca di un'auto tramite marca e modello
    public static int ricercaMarcaModello(String [] marca,String [] modello, int index,String marcaNuova, String modelloNuovo){
        for (int i=0;i<index;i++){
            if (marca[i].equalsIgnoreCase(marcaNuova) && modello[i].equalsIgnoreCase(modelloNuovo)) {
                return i;
            }
        }
        return -1;
    }
    //cancellazione di un'auto
    public static int cancellaAuto (String [] marca,String [] modello,double [] prezzo, int index, String marcaNuova, String modelloNuovo){
        int indice=ricercaMarcaModello(marca,modello,  index, marcaNuova,  modelloNuovo);
        if (indice==-1) //Se l'auto non esiste
            return index;
        else { //Se l'auto esiste
            for (int i=indice;i<=index;i++){ //Rimuovo
                if (i==index){ //Se siamo all'ultimo
                    marca[i]="";
                    modello[i]="";
                    prezzo[i]=0.0;
                }else { //Prendo l'elemento prima
                    marca[i]=marca[i+1];
                    modello[i]=modello[i+1];
                    prezzo[i]=prezzo[i+1];
                }
            }
            return index-1;
        }
    }
    //Modifica
    public static boolean modificaDati (String [] marca,String [] modello,double [] prezzo, int index, String marcaNuova, String modelloNuovo, double prezzoNuovo,String marcaNuova1, String modelloNuovo1, double prezzoNuovo1){
        int indice=ricercaMarcaModello(marca,modello,  index, marcaNuova,  modelloNuovo);
        if (indice==-1) //Se l'auto non esiste
            return false;
        else { //Se l'auto esiste
            marca[indice]=marcaNuova1;
            modello[indice]=modelloNuovo1;
            prezzo[indice]=prezzoNuovo1;
        }
        return true;
    }
    //Visualizzazione di tutte le auto in ordine crescente non modifica in ordine crescente
    public static String visualizzaAutoCrescente (String [] marca,String [] modello,double [] prezzo, int index){
        //Variabili d'appoggio
        String [] marcaAppoggio=new String[index];
        String [] modelloAppoggio=new String[index];
        double [] prezzoAppoggio=new double[index];
        int posmin=0;
        //Copio
        for (int i=0;i<index;i++){
            marcaAppoggio[i]=marca[i];
            modelloAppoggio[i]=modello[i];
            prezzoAppoggio[i]=prezzo[i];
        }
        //Riordino tramite il selection sort
        for (int l=0;l<index-1;l++){
            //cerco la posmin
            for (int g=l+1;g<index;g++){
                if (prezzoAppoggio[posmin]>prezzoAppoggio[g])
                    posmin=g;
            }
            //Scambio
            scambioArray(marcaAppoggio,modelloAppoggio,prezzoAppoggio,l,posmin);
        }
        //Stringa di stampa
        return visualizzaAuto(marcaAppoggio,modelloAppoggio,prezzoAppoggio,index);
    }
    private static void scambioArray(String [] marcaApp,String [] modelloApp,double [] prezzoApp,int posCorrente,int posMinima){
        String temp;
        double temps;
        //Scambio marca
        temp=marcaApp[posCorrente];
        marcaApp[posCorrente]=marcaApp[posMinima];
        marcaApp[posMinima]=temp;
        //Scambio modello
        temp=modelloApp[posCorrente];
        modelloApp[posCorrente]=modelloApp[posMinima];
        modelloApp[posMinima]=temp;
        //Scambio prezzo
        temps=prezzoApp[posCorrente];
        prezzoApp[posCorrente]=prezzoApp[posMinima];
        prezzoApp[posMinima]=temps;
    }
    //Tutte auto con disel
    public static String visualizzaAutoDisel(String [] marca, String [] modello, double [] prezzo, int index){
        String s="";
        for (int i=0;i<index;i++){
            if (modello[i].indexOf("disel")!=-1 && modello[i].indexOf("Disel")!=-1) {
                s = s + marca[i] + "\t" + modello[i] + "\t" + prezzo[i] + "\t\n";
            }
        }
        if (s.equalsIgnoreCase(""))
            s="Non trovate disel";
        return s;
    }
}
