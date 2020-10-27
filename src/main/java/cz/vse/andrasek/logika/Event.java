package cz.vse.andrasek.logika;

import java.util.List;
import java.util.ArrayList;

public class Event {
    private String nazev;
    public List<String> potrebneVeci;
    private String popis;
    private Vec vec;
    private String vychod;
    private Prostor prostor;
    private boolean end;

    public Event(String nazev, String popis, Vec vec, String vychod, Prostor prostor, boolean end) {
        this.nazev = nazev;
        this.popis = popis;
        this.vec = vec;
        this.vychod = vychod;
        this.prostor = prostor;
        potrebneVeci = new ArrayList<String>();
        this.end = end;
    }

    public String getNazev() {
        return nazev;
    }

    public String vypisVeci(){
        String vypsaneVeci = "";
        for(int i = 0; i<potrebneVeci.size(); i++){
            vypsaneVeci += potrebneVeci.get(i)  + ", ";
        }
        return vypsaneVeci;
    }

    public List<String> getPotrebneVeci() {
        return potrebneVeci;
    }

    public String getPotrebnouVec (String nazevPredmetu){
        for(int i = 0; i<potrebneVeci.size(); i++){
            if (potrebneVeci.get(i).equals(nazevPredmetu)){
                return potrebneVeci.get(i);
            }
        }
        return null;
    }

    public void vlozVec(String vec){
        potrebneVeci.add(vec);
    }

    public void setNewVychod(HerniPlan herniPlan){
        herniPlan.getAktualniProstor().vratSousedniProstorProEvent(vychod).setPristupne(true);
    }

    public String getPopis() {
        return popis;
    }


    public Vec getVec() {
        return vec;
    }

    public boolean getEnd(){
        return end;
    }

    public String getVychod() {
        return vychod;
    }
}
