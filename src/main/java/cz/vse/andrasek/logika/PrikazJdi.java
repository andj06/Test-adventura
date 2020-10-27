package cz.vse.andrasek.logika;

/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček
 *@version    pro školní rok 2016/2017
 */
class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private HerniPlan plan;
    private Hra hra;
    
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
    */    
    public PrikazJdi(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam mám jít? Musíš zadat jméno východu";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        if (sousedniProstor == null) {
            return "Tam se odsud jít nedá!";
        }
        else {
            plan.setAktualniProstor(sousedniProstor);
            if (plan.getAktualniProstor().getMaEvent()){
                if (plan.getBatoh().obsahujePredmet(plan.getAktualniProstor().getEvent().potrebneVeci.get(0))&& plan.getBatoh().obsahujePredmet(plan.getAktualniProstor().getEvent().potrebneVeci.get(1))){
                    if (plan.getAktualniProstor().getEvent().getEnd()){
                        hra.setKonecHry(true);
                        return plan.getAktualniProstor().getEvent().getPopis();
                    }

                    int promena = 0;

                    if (plan.getAktualniProstor().getEvent().potrebneVeci.get(1) == null){
                        for (int i = 0; i<=plan.getBatoh().getObsahBatohu().size(); i++){
                            if (plan.getBatoh().obsahBatohu.get(i).getNazev().equals(plan.getAktualniProstor().getEvent().potrebneVeci.get(0))){
                                plan.getBatoh().zahodPredmetZBatohu(i, plan);
                                break;
                            }
                        }
                    }
                    else {
                        for (int i = 0; i <= plan.getBatoh().getObsahBatohu().size(); i++) {
                            for (int y = 0; y < 2; y++) {
                                if (plan.getBatoh().obsahBatohu.get(i).getNazev().equals(plan.getAktualniProstor().getEvent().potrebneVeci.get(y))) {
                                    plan.getBatoh().zahodPredmetZBatohu(i, plan);
                                    promena++;
                                    if (promena==2){
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (plan.getAktualniProstor().getEvent().getVec() != null){
                        plan.getBatoh().pridejVec(plan.getAktualniProstor().getEvent().getVec());
                    }
                    if (plan.getAktualniProstor().getEvent().getVychod() !=null){
                        plan.getAktualniProstor().getEvent().setNewVychod(plan);
                    }
                    return plan.getAktualniProstor().getEvent().getPopis();
                }
            }
            return sousedniProstor.dlouhyPopis();
        }
    }
    
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
