package cz.vse.andrasek.logika;

/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Jarmila Pavlickova, Luboš Pavlíček
 *@version    pro školní rok 2016/2017
 */
class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber";
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se bude ve hře "brát"
     */
    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "seber". Zkouší sebrat předmět ze země
     *  pokud předmět neexistuje vypíše chybu
     *  pokud existuje, předmět přidá do batohu.
     *
     *@param parametry - jako  parametr obsahuje jméno předmětu,
     *                         který má sebrat.
     *@return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (jméno předmětu) tak.....
            return "Co mám sebrat?\n" +
                    plan.getAktualniProstor().vypisVeci();
        }

        String nazevVeci = parametry[0];

        Batoh batoh = plan.getBatoh();
        Prostor aktProstor = plan.getAktualniProstor();

        if(aktProstor.obsahujePredmet(nazevVeci)){
            if(!batoh.jeVBatohuMisto()){
                return "V batohu už není místo.";
            }
            Vec vec = aktProstor.odeberVec(nazevVeci);

            if (!vec.jeSebratelna()){
                aktProstor.vlozVec(vec);
                return "Tato věc nejde sebrat.";
            }

            batoh.pridejVec(vec);
            return "Věc byla přidána do batohu.";
        }
        return "Tady taková věc není!";
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
