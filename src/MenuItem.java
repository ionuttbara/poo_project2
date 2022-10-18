import java.math.BigDecimal;

/**
 * aici este vorba despre itemul din meniu
 * am importat un nr de tip big decimal pentru remedierea scrierii pretului
 * de asemenea s-a suprascris metoda toString(), cu scopul afisarii informatilor in fereastra cat si in fisier
 */
public class MenuItem {

    private String numeProdus;
    private BigDecimal pretProdus;

    public MenuItem(String numeProdus, BigDecimal pretProdus) {

        this.numeProdus = numeProdus;
        this.pretProdus = pretProdus;
    }

    public String getName(){
        return numeProdus;
    }

    public BigDecimal getCost(){
        return pretProdus;
    }

    public String produsToString(){
        String info = numeProdus + "\n" + pretProdus;
        return info;
    }

}


