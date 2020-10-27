package cz.vse.andrasek.logika;

public class Vec {

    private String nazev;
    private boolean jeSebratelna;
    public String popis;

    public Vec(String nazev, boolean jeSebratelna, String popis){
        this.nazev = nazev;
        this.jeSebratelna = jeSebratelna;
        this.popis = popis;
    }

    public String getNazev() {
        return nazev;
    }

    public boolean jeSebratelna() {
        return jeSebratelna;
    }

    public boolean equals(Object object) {
        if (object instanceof Vec) {
            Vec vec = (Vec) object;
            return nazev.equals(vec.nazev);
        }
        return false;
    }

    public int hashCode() {
        return nazev.hashCode();
    }
}
