package sample;

public class Vein {

    private String vein;
    private int aasta;
    private double hind;
    private double hinne;

    public Vein() {
        this.vein = "";
        this.aasta = 0;
        this.hind = 0;
        this.hinne = 0;
    }

    public Vein(String vein, int aasta, double hind, double hinne) {
        this.vein = vein;
        this.aasta = aasta;
        this.hind = hind;
        this.hinne = hinne;
    }

    public String getVein() {
        return vein;
    }

    public void setVein(String vein){
        this.vein = vein;
    }

    public int getAasta() {
        return aasta;
    }

    public void setAasta(int aasta){
        this.aasta = aasta;
    }

    public double getHind() {
        return hind;
    }

    public void setHind(double hind){
        this.hind = hind;
    }

    public double getHinne() {
        return hinne;
    }

    public void setHinne(double hinne){
        this.hinne = hinne;
    }
}
