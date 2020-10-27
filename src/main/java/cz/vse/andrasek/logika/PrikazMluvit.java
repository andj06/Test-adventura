package cz.vse.andrasek.logika;

class PrikazMluvit implements IPrikaz {
    private static final String NAZEV = "mluvit";
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se bude ve hře "mluvit"
     */
    public PrikazMluvit(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "mluvit". Promluví si s nějakou postavou
     *
     *
     *@return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (jméno předmětu) tak.....
            return "S kým mám mluvit?\n" +
                    plan.getAktualniProstor().vypisPostavy();
        }

        String nazevPostavy = parametry[0];

        Prostor aktProstor = plan.getAktualniProstor();

        if(aktProstor.obsahujePostavu(nazevPostavy)) {
            return aktProstor.getNPC(nazevPostavy).getOdpoved();
        }
        return "Tady taková postava není";
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
