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
    public static String modificaDati (String [] marca,String [] modello,double [] prezzo, int index, String marcaNuova, String modelloNuovo, double prezzoNuovo,String marcaNuova1, String modelloNuovo1, double prezzoNuovo1){
        int indice=ricercaMarcaModello(marca,modello,  index, marcaNuova,  modelloNuovo);
        if (indice==-1) //Se l'auto non esiste
            return "Non trovata";
        else { //Se l'auto esiste
            marca[indice]=marcaNuova1;
            modello[indice]=modelloNuovo1;
            prezzo[indice]=prezzoNuovo1;
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
                int p;
                // Cerchiamo la posizione corretta dove inserire l'elemento corrente
                for (p = 0; p < i; p++) {
                    if (prezzoAppoggio[p] > prezzo[i]) {
                        break; // Trovata la posizione dove inserire
                    }
                }

                // Spostiamo tutti gli elementi per fare spazio al nuovo elemento
                for (int l = i; l > p; l--) {
                    marcaAppoggio[l] = marcaAppoggio[l - 1];
                    modelloAppoggio[l] = modelloAppoggio[l - 1];
                    prezzoAppoggio[l] = prezzoAppoggio[l - 1];
                }

                // Inseriamo il nuovo elemento nella posizione corretta
                marcaAppoggio[p] = marca[i];
                modelloAppoggio[p] = modello[i];
                prezzoAppoggio[p] = prezzo[i];
            }
        }
        //Stringa di stampa
        return visualizzaAuto(marcaAppoggio,modelloAppoggio,prezzoAppoggio,index);
    }
    //Tutte auto con disel senza CharSequence
    public static String visualizzaAutoDisel(String [] marca, String [] modello, double [] prezzo, int index){
        String s="";
        for (int i=0;i<index;i++){
            String[] words = modello[i].split(" ");
            if (words.length==1)
                break;
            if (words[1].equalsIgnoreCase("DISEL")) {
                s = s + marca[i] + "\t" + modello[i] + "\t" + prezzo[i] + "\t\n";
            }
        }
        if (s.equalsIgnoreCase(""))
            s="Non trovate diesel";
        return s;
    }
}
