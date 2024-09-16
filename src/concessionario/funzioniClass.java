package concessionario;

public class funzioniClass {
    //aggiunta di una nuova auto
    public int aggAuto (String [] marca,String [] modello,int [] prezzo, int index, String marcaNuova, String modelloNuovo, int prezzoNuovo){
        index+=1;
        marca[index]=marcaNuova;
        modello[index]=modelloNuovo;
        prezzo[index]=prezzoNuovo;
        return index;
    }
    //Visualizzazione di tutte le auto

}
