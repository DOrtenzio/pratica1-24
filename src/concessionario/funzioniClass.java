package concessionario;

public class funzioniClass {
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
        String s="";
        for (int i=0;i<index;i++){
            s=s+marca[i]+"\t"+modello[i]+"\t"+prezzo[i]+"\t\n";
        }
        return s;
    }
    // ricerca di un'auto tramite marca e modello
    public static String ricercaMarcaModello(String [] marca,String [] modello,double [] prezzo, int index,String marcaNuova, String modelloNuovo){
        String s="";
        for (int i=0;i<index;i++){
            if (marca[i].equalsIgnoreCase(marcaNuova) && modello[i].equalsIgnoreCase(modelloNuovo)) {
                s = s + marca[i] + "\t" + modello[i] + "\t" + prezzo[i] + "\t\n";
            }
        }
        if (s.equalsIgnoreCase(""))
            s="Non trovata";
        return s;
    }
    //cancellazione di un'auto
    public static int cancellaAuto (String [] marca,String [] modello,double [] prezzo, int index, String marcaNuova, String modelloNuovo, double prezzoNuovo){
        int indice=ricercaIndiceAuto(marca,modello, prezzo,  index, marcaNuova,  modelloNuovo,  prezzoNuovo);
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
    // ricerca di un'auto tramite info
    private static int ricercaIndiceAuto(String [] marca,String [] modello,double [] prezzo, int index,String marcaNuova, String modelloNuovo, double prezzoNuovo){
        for (int i=0;i<index;i++){
            if (marca[i].equalsIgnoreCase(marcaNuova) && modello[i].equalsIgnoreCase(modelloNuovo) && prezzo[i]==prezzoNuovo) {
                return i;
            }
        }
        return -1;
    }
    //Modifica
    public static String modificaDati (String [] marca,String [] modello,double [] prezzo, int index, String marcaNuova, String modelloNuovo, double prezzoNuovo){
        int indice=ricercaIndiceAuto(marca,modello, prezzo,  index, marcaNuova,  modelloNuovo,  prezzoNuovo);
        String s="";
        if (indice==-1) //Se l'auto non esiste
            return "Non trovata";
        else { //Se l'auto esiste
            marca[indice]=marcaNuova;
            modello[indice]=modelloNuovo;
            prezzo[indice]=prezzoNuovo;
        }
        return "Modificato";
    }
    //Visualizzazione di tutte le auto in ordine crescente non modifica in ordine crescente
    public static String visualizzaAutoCrescente (String [] marca,String [] modello,double [] prezzo, int index){
        //Variabili d'appoggio
        String [] marcaAppoggio=new String[index];
        String [] modelloAppoggio=new String[index];
        double [] prezzoAppoggio=new double[index];
        //Riordino
        for (int i=0;i<index;i++){
            if(i==0){
                marcaAppoggio[i]=marca[i];
                modelloAppoggio[i]=modello[i];
                prezzoAppoggio[i]=prezzo[i];
            }else{
                for (int p=0;p<i;i++){
                    if (prezzoAppoggio[p]>prezzo[p]){
                        for (int l=i;l>p;l--){ //Sposto
                             //Prendo l'elemento prima
                                marcaAppoggio[l+1]=marcaAppoggio[l];
                                modelloAppoggio[l+1]=modelloAppoggio[l];
                                prezzoAppoggio[l+1]=prezzoAppoggio[l];
                        }
                        marcaAppoggio[p]=marca[i];
                        modelloAppoggio[p]=modello[i];
                        prezzoAppoggio[p]=prezzo[i];
                        break;
                    }
                }
            }
        }
        //Stringa di stampa
        return visualizzaAuto(marcaAppoggio,modelloAppoggio,prezzoAppoggio,index);
    }
    //Tutte auto con disel
    public static String visualizzaAutoDisel (String [] marca,String [] modello,double [] prezzo, int index){
        String s="";
        CharSequence d="disel",d1="Disel",d2="DISEL";
        for (int i=0;i<index;i++){
            if (modello[i].contains(d) || modello[i].contains(d1) || modello[i].contains(d2)) {
                s = s + marca[i] + "\t" + modello[i] + "\t" + prezzo[i] + "\t\n";
            }
        }
        if (s.equalsIgnoreCase(""))
            s="Non trovate diesel";
        return s;
    }
}
