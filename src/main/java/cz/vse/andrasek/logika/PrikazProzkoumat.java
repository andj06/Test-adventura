package cz.vse.andrasek.logika;

class PrikazProzkoumat implements IPrikaz {

    private static final String NAZEV = "prozkoumat";
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se bude ve hře "prozkoumávat"
     */
    public PrikazProzkoumat(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "prozkoumat". Zkouší prozkoumat nějaký předmět
     *  pokud předmět neexistuje vypíše chybu
     *  pokud existuje, předmět prozkoumá.
     *
     *@param parametry - jako  parametr obsahuje jméno předmětu,
     *                         který má prozkoumat.
     *@return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (jméno předmětu) tak.....
            return "Co mám prozkoumat?\n" +
                    plan.getAktualniProstor().vypisVeci() + "\n Věci v batohu: "
                    + plan.getBatoh().vypisVeci();
        }

        String nazevVeci = parametry[0];

        Batoh batoh = plan.getBatoh();
        Prostor aktProstor = plan.getAktualniProstor();

        if(aktProstor.obsahujePredmet(nazevVeci)){
            return aktProstor.getVec(nazevVeci).popis;
        }
        if (batoh.obsahujePredmet(nazevVeci)){
            return batoh.getVec(nazevVeci).popis;
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
