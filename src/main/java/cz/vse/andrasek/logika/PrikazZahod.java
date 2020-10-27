package cz.vse.andrasek.logika;

class PrikazZahod implements IPrikaz {

        private static final String NAZEV = "zahoď";
        private HerniPlan plan;


        /**
         *  Konstruktor třídy
         *
         *  @param plan herní plán, ve kterém se bude ve hře "zahazovat"
         */

        public PrikazZahod(HerniPlan plan) {
            this.plan = plan;
        }

        /**
         * Provádí příkaz "zahod" ve kterém postava zahazuje předmět
         * do místa, ve kterém se nachází.
         *
         * @param  parametry věci, které chce hráč zahodit
         * @return
         */

        @Override
        public String provedPrikaz(String... parametry) {
            if (parametry.length == 0) {
                // pokud chybí druhé slovo (jméno předmětu) tak.....
                return "Co mám zahodit?\n" +
                        plan.getBatoh().vypisVeci();
            }

            String vec = parametry[0];


            if (plan.getBatoh().getObsahBatohu().isEmpty()){ return "Nic u sebe nemáš."; }


            for (int i = 0; i<plan.getBatoh().getObsahBatohu().size(); i++){
                if (plan.getBatoh().getObsahBatohu().get(i).getNazev().equals(vec)){
                    plan.getBatoh().zahodPredmetZBatohu(i, plan);
                    return "Předmět zahozen";
                }
            }
            return "Takový předmět u sebe nemáš";
        }

        /**
         *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
         *
         *  @return nazev prikazu
         */

        @Override
        public String getNazev() { return NAZEV; }

}
