package cz.vse.andrasek.logika;

import java.util.List;
import java.util.ArrayList;

public class Batoh {

    public List<Vec> obsahBatohu;
    private static final int KAPACITA_BATOHU = 5;

    public Batoh(List<Vec> obsahBatohu) {
        this.obsahBatohu = obsahBatohu;
    }

    public Batoh(){
        obsahBatohu = new ArrayList<Vec>();
    }

    public boolean pridejVec(Vec vec){
        return obsahBatohu.add(vec);
    }

    public boolean jeVBatohuMisto(){
        if(obsahBatohu.size() < KAPACITA_BATOHU){
            return true;
        }
        else {
            return false;
        }
    }

    public String vypisVeci(){
        String vypsaneVeci = "";
        for(Vec vec : obsahBatohu){
            vypsaneVeci +=  String.valueOf(vec.getNazev()) + ", ";
        }
        return vypsaneVeci;
    }

    public boolean obsahujePredmet(String nazevPredmetu){
        if (nazevPredmetu == null){return true;}
        for(Vec vec : obsahBatohu){
            if(vec.getNazev().equals(nazevPredmetu)){
                return true;
            }
        }
        return false;
    }

    public Vec getVec (String nazevPredmetu){
        for (Vec vec : obsahBatohu){
            if (vec.getNazev().equals(nazevPredmetu)){
                return vec;
            }
        }
        return null;
    }

    public void zahodPredmetZBatohu(int i, HerniPlan plan) {
        Vec vec = obsahBatohu.get(i);
        plan.getAktualniProstor().vlozVec(vec);
        obsahBatohu.remove(i);
    }

    public List<Vec> getObsahBatohu(){
        return obsahBatohu;
    }
}
