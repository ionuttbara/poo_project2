public class Produse {
    String numeproduse,tipprodus;
     double pretproduse;

     // creeare constructor pentru produse
    public Produse(String fn,String fl,double fp){
        this.numeproduse = fn;
        this.tipprodus = fl;
        this.pretproduse = fp;
    }
    public Produse(String fn,String fl){
        this.numeproduse = fn;
        this.tipprodus = fl;
    }
    public Produse(String fn,double fp){
        this.numeproduse = fn;
        this.pretproduse = fp;
    }
}
