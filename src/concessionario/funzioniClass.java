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
            if (marca[i]==marcaNuova && modello[i]==modelloNuovo)
                s=s+marca[i]+"\t"+modello[i]+"\t"+prezzo[i]+"\t\n";
        }
        return s;
    }
}
