package cz.vse.andrasek.logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Batoh batoh;
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví město.
     */
    public HerniPlan() {
        zalozProstoryHry();
        batoh = new Batoh();
        batoh.pridejVec(new Vec("Meč", true, "Klasický meč, vypadá nepoužitě."));
        batoh.pridejVec(new Vec("Štít", true, "Klasický štít, vypadá nepoužitě."));
    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví město.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor mesto = new Prostor("město","město, ve kterém sídlí Král a Kovář.", true, true);
        Prostor pole_s_chatkou = new Prostor("pole_s_chatkou", "pole s chatkou chasníka a jeho dítěte.", true, true);
        Prostor skryta_jeskyne = new Prostor("skrytá_jeskyně","tajemná jeskyně ve které leží ampulka Lék na mor.", false, false);
        Prostor vstup_do_lesa = new Prostor("vstup_do_lesa","vstup do lesa s cestovatelem a krásným oblázkem na zemi.", false, true);
        Prostor krizovatka_v_lese = new Prostor("křižovatka_v_lese","křižovatka v lese, u cedule ukazující cestu, jsou viditelné stopy.", false, true);
        Prostor utes = new Prostor("útes","útes vypadá prázdně.", true, true);
        Prostor temna_stezka = new Prostor("temná_stezka","temná stezka, na zemi leží mrtvý vesničan a u něj schnilé jablko", true, true);
        Prostor mytina = new Prostor("mýtina","mýtina se sedmikráskami a zvláštním zámkem na kraji skály.", true, true);
        Prostor chatrc_agaty = new Prostor("chatrč_Agáty","chatrč Agáty, Agáta stojí u ohně s kotlem a oznámí 'Dlouho jsem na tebe čekala'.", true, true);

        // přiřazují se průchody mezi prostory (sousedící prostory)
        mesto.setVychod(vstup_do_lesa);
        mesto.setVychod(pole_s_chatkou);
        vstup_do_lesa.setVychod(mesto);
        vstup_do_lesa.setVychod(pole_s_chatkou);
        vstup_do_lesa.setVychod(krizovatka_v_lese);
        pole_s_chatkou.setVychod(vstup_do_lesa);
        pole_s_chatkou.setVychod(mesto);
        krizovatka_v_lese.setVychod(vstup_do_lesa);
        krizovatka_v_lese.setVychod(utes);
        krizovatka_v_lese.setVychod(temna_stezka);
        utes.setVychod(krizovatka_v_lese);
        temna_stezka.setVychod(krizovatka_v_lese);
        temna_stezka.setVychod(chatrc_agaty);
        temna_stezka.setVychod(mytina);
        chatrc_agaty.setVychod(temna_stezka);
        chatrc_agaty.setVychod(skryta_jeskyne);
        mytina.setVychod(temna_stezka);
        mytina.setVychod(skryta_jeskyne);
        skryta_jeskyne.setVychod(mytina);
        skryta_jeskyne.setVychod(chatrc_agaty);

        aktualniProstor = mesto;  // hra začíná v městě

        // přiřazuje věci do prostorů
        mesto.vlozVec(new Vec("Kůň", false, "Kůň na tebe zírá."));
        mesto.vlozVec(new Vec("Měšec_zlaťáků", true, "Měšec, který vypadá plný zlaťáků."));
        mesto.vlozVec(new Vec("Koš_s_jídlem", true, "Koš, který je plný jídla."));
        vstup_do_lesa.vlozVec(new Vec("Oblázek", true, "Oblázek ležící na zemi, vypadá skoro perfektně."));
        pole_s_chatkou.vlozVec(new Vec("Pochodeň", true, "Pochodeň je vložená v železném držáku, vypadá, že tu hořela dlouho."));
        pole_s_chatkou.vlozVec(new Vec("Pytel_zrní", true, "Pyte, který vypadá, že je plný zrní."));
        krizovatka_v_lese.vlozVec(new Vec("Cedule", false, "Cedule ukazující doleva 'Cesta k ježibabě' a do prava 'Cesta k útesu víl'."));
        krizovatka_v_lese.vlozVec(new Vec("Stopy", false, "Stopy vedoucí doleva jsou od tvrdých bot a úzká rýha vypadá jako od čepele. Stopy vedoucí doprava jsou bosých nohou."));
        temna_stezka.vlozVec(new Vec("Mrtvý_vesničan", false, "Tělo má na sobě rány od meče, lezou po něm brouci, ale ještě se nezačalo rozpadat. Vypadá to, že tu byl zabit nedávno."));
        temna_stezka.vlozVec(new Vec("Shnilé_jablko", true, "Jablko vypadá starší než mrtvé tělo. Nedoporučoval bych ho jíst."));
        mytina.vlozVec(new Vec("Sedmikrásky", true, "Sedmikrásky se hybají ve větru. Každou ženu by potěšilo je dostat."));
        mytina.vlozVec(new Vec("Zámek", false, "Zámek je zlatý a vypadá složitě. Bez správného klíče jej neotevřeš."));
        chatrc_agaty.vlozVec(new Vec("Kotel", false, "V kotli se vaří voda se zeleninou."));
        chatrc_agaty.vlozVec(new Vec("Provaz", true, "Provaz je silný se zaschlou krví na sobě."));
        chatrc_agaty.vlozVec(new Vec("Pytel", true, "Pytel vypadá, že byl nedávno zašit, ale přesto vypadá kvalitně."));
        skryta_jeskyne.vlozVec(new Vec("Lék_na_mor", true, "Lék, který hledá celé království. Za toto tě jistě dobře odmění."));

        //přiřazuje postavy do prostorů
        mesto.vlozPostavu(new NPC("Král", "Vítám tě, mladý Williame, obávám se, že ti nemohu nabídnout nic jiného než štěstí při hledání léku. Celé království na tebe spoléhá, nezklam nás."));
        mesto.vlozPostavu(new NPC("Kovář", "Omlouvám se, že nemohu jít s tebou. Mám tu jisté povinnosti. Ale věřím, že ten štít a meč použiješ rozumně. A opatrně, v lese se nacházejí banditi."));
        pole_s_chatkou.vlozPostavu(new NPC("Chasník", "Ahoj cizinče, vidím, že máš na spěch. Nabídl bych ti něco k snědku, ale sám málo."));
        pole_s_chatkou.vlozPostavu(new NPC("Dítě", "Ty seš ale divnej!"));
        vstup_do_lesa.vlozPostavu(new NPC("Cestovatel", "Nemáš nějaký suvenýr, hochu?"));
        chatrc_agaty.vlozPostavu(new NPC("Agáta", "Ahoj, mladíku. Pokud si vezmeš ode mne Provaz a Pytel, kterými chytíš drzého chlapce z chatky u pole a přineseš mi ho. Tak ti otevřu tajný vchod k léku na mor, který stíhá tvé království."));

        //přiřazuje eventy prostorům
        mesto.setEvent(new Event("Konec dobrý", "Stráže tě dovedli ke králi, který ti předal odměnu za záchranu království před hrozným morem. \nÚspěšně jsi dokončil hru.", null, null, mesto, true));
        pole_s_chatkou.setEvent(new Event("Vražda", "Dostaneš se na pole, rychle zabiješ chasníka a vezmeš dítě svazané v pytli. Měl bys co nejrychleji utéct, než si tě někdo všimne.", new Vec("Dítě", false, "Dítě svázané v pytli. Stále se snaží vyprostit"), null, mesto, false));
        utes.setEvent(new Event("Skrytá naděje", "Víla se vynoří z oceánu, zaujata tvými předměty. 'Copak to neseš cizinče?'. Společně se vrhnete do konverzace a nakonec ji dáš Oblázek a Sedmikrásku, výměnou za klíč do zámku na mýtině.", new Vec("Klíč", true, "Třpytící se klíč ještě mokrý."), null, utes, false));
        temna_stezka.setEvent(new Event("Přepadení špatné", "Banditi viděli tvůj měšec plný zlaťáků a rozhodli se ho vzít z tvých mrtvých rukou. Bohužel jsi byl přemožen jejich počtem. \nKonec hry, zemřel jsi.", null, null, temna_stezka, true));
        chatrc_agaty.setEvent(new Event("Výměna", "Agáta je spokojená s tvým darem a rychle si dítě bere. Poté ti otevře dveře do skryté jeskyně.", new Vec("Cejch", false, "Cejch černé lebky na tvé ruce."), "skrytá_jeskyně", chatrc_agaty, false));
        mytina.setEvent(new Event("Lék", "Když přijdeš na mýtinu, rychle spěcháš k podivnému zámku a pomocí klíče jej odemykáš. Z ničeho nic se otevírají dveře do jeskyně.", null, "skrytá_jeskyně", mytina, false));

        mesto.getEvent().vlozVec("Lék_na_mor");
        mesto.getEvent().vlozVec(null);
        pole_s_chatkou.getEvent().vlozVec("Provaz");
        pole_s_chatkou.getEvent().vlozVec("Pytel");
        utes.getEvent().vlozVec("Oblázek");
        utes.getEvent().vlozVec("Sedmikrásky");
        temna_stezka.getEvent().vlozVec("Měšec_zlaťáků");
        temna_stezka.getEvent().vlozVec(null);
        chatrc_agaty.getEvent().vlozVec("Dítě");
        chatrc_agaty.getEvent().vlozVec(null);
        mytina.getEvent().vlozVec("Klíč");
        mytina.getEvent().vlozVec(null);

    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve kterém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

    public Batoh getBatoh() {
        return batoh;
    }

}
