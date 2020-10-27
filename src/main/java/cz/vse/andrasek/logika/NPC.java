package cz.vse.andrasek.logika;

import java.util.Objects;

public class NPC {
    private String nazev;
    private String odpoved;

    public NPC(String nazev, String odpoved) {
        this.nazev = nazev;
        this.odpoved = odpoved;
    }

    public String getNazev() {
        return nazev;
    }

    public String getOdpoved() {
        return odpoved;
    }

    public boolean equals(Object object) {
        if (object instanceof NPC) {
            NPC npc = (NPC) object;
            return nazev.equals(npc.nazev);
        }
        return false;
    }

    public int hashCode() {
        return nazev.hashCode();
    }
}
