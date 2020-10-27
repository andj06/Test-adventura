package cz.vse.andrasek.logika;

class PrikazBatoh implements IPrikaz {
    private static final String NAZEV = "inventář";
    private HerniPlan plan;


    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se bude ve hře "zahazovat"
     */

    public PrikazBatoh(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Provádí příkaz "inventář" ve kterém postava prohledá svůj batoh, aby věděla, co má.
     *
     *
     *
     * @return věci v batohu
     */

    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getBatoh().getObsahBatohu().isEmpty() == true){ return "Nic u sebe nemáš."; }
        return plan.getBatoh().vypisVeci();
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     *  @return nazev prikazu
     */

    @Override
    public String getNazev() { return NAZEV; }
}
