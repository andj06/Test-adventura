package cz.vse.andrasek.logika;


class PrikazRozhlidni implements IPrikaz {

    private static final String NAZEV = "rozhlídni";
    private HerniPlan plan;


    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se bude ve hře "rozhlížet"
     */

    public PrikazRozhlidni(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Provádí příkaz "rozhildni" ve kterém se bude postava rozhlížet, aby viděla všechny předměty,
     * které se zde nacházejí
     *
     * @return
     */

    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getAktualniProstor().vypisVeci() == ""){ return "Nic tu není"; }
        return plan.getAktualniProstor().vypisVeci() + "\n" + plan.getAktualniProstor().vypisPostavy() + "\n" + plan.getAktualniProstor().popisVychodu();
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     *  @return nazev prikazu
     */

    @Override
    public String getNazev() { return NAZEV; }
}
