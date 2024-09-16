package concessionario;

public class funzioniClass {
    //aggiunta di una nuova auto
    public int aggAuto (String [] marca,String [] modello,double [] prezzo, int index, String marcaNuova, String modelloNuovo, double prezzoNuovo){
        index+=1;
        marca[index]=marcaNuova;
        modello[index]=modelloNuovo;
        prezzo[index]=prezzoNuovo;
        return index;
    }
    //Visualizzazione di tutte le auto
    public String visualizzaAuto (String [] marca,String [] modello,double [] prezzo, int index){
        String s="";
        for (int i=0;i<index;i++){
            s=s+marca[i]+"\t"+modello[i]+"\t"+prezzo[i]+"\t\n";
        }
        return s;
    }
    // ricerca di un'auto tramite marca e modello
    public String ricercaMarcaModello(String [] marca,String [] modello,double [] prezzo, int index,String marcaNuova, String modelloNuovo){
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
    public int cancellaAuto (String [] marca,String [] modello,double [] prezzo, int index, String marcaNuova, String modelloNuovo, double prezzoNuovo){
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
    private int ricercaIndiceAuto(String [] marca,String [] modello,double [] prezzo, int index,String marcaNuova, String modelloNuovo, double prezzoNuovo){
        for (int i=0;i<index;i++){
            if (marca[i].equalsIgnoreCase(marcaNuova) && modello[i].equalsIgnoreCase(modelloNuovo) && prezzo[i]==prezzoNuovo) {
                return i;
            }
        }
        return -1;
    }
    //Modifica
    public String modificaDati (String [] marca,String [] modello,double [] prezzo, int index, String marcaNuova, String modelloNuovo, double prezzoNuovo){
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
}
