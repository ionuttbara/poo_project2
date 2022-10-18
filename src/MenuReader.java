import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.math.BigDecimal;

public class MenuReader {
    /**
     * aici se citeste meniurile din fisier
     * S-a folosit singleton , pentru ca totul sa se salveze intr-un singur fisier.
     * Adica toate comenzile s-au salvat intr-un fisier
     * Folosim FileBuffer si WriteBuffer ca sa scriem fisierul
     * Un contor pentru a numara comenzile
     * Importam calendarul , timpul cu scopul de a sti momentul realizarii comenzii.
     *
     *
     */
    private File orders;
    private Scanner readMenu;
    private BufferedWriter salvareComanda;
    private FileWriter salvareComandaStream;
    private int contor;
    private String inputFile;
    private Calendar calendar;
    private ArrayList<MenuItem> menuItems;

    public MenuReader(File inputMenu) throws FileNotFoundException {

        menuItems = new ArrayList<MenuItem>();
        readMenu = new Scanner(inputMenu);
        calendar = new GregorianCalendar();
        contor = 1;
        inputFile = inputMenu.getName();
    }

    public void readInputFile() {
        /**
         * Citirea informatilor din fisier
         * Se adauga intr-un array list , dupa nume si pret
         */
        while (readMenu.hasNextLine()) {

            String item = readMenu.nextLine();
            String itemCost = readMenu.nextLine();
            BigDecimal pretProdus = new BigDecimal(itemCost);

            MenuItem createItem = new MenuItem(item, pretProdus);
            menuItems.add(createItem);
        }
        readMenu.close();
    }

   // aici se returneaza ce s-a gasit pe fisier
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void logOrder(ArrayList<MenuItem> itemsOrdered, BigDecimal orderPrice) throws IOException {
        /**
         * Din now, folosim FileWriter si BufferWriter cu scopul de a scrie in fisier datele.
         * se scriu data si ora din momentul realizarii comenzii
         * Aici se incrementeaza nr comenzii si se trece pe fisier #
         * Pentru sfarsitul scrierii in fisier se pune comanda close
         */
        salvareComandaStream = new FileWriter(getFileInstance(),true);
        salvareComanda = new BufferedWriter(salvareComandaStream);

        java.util.Date orderDate = new java.util.Date();

        if(contor == 1) {

            salvareComanda.write( "Data: " + calendar.get(Calendar.DAY_OF_MONTH)
                    + " " + calendar.get((Calendar.MONTH + 1)) + " " + calendar.get(Calendar.YEAR) + " " + "\n \n");

        }

        salvareComanda.write("Nr Comanda" + contor + ", ");
        contor++;
        salvareComanda.write(" " + new Timestamp(orderDate.getTime()) + "\n");

        for (MenuItem item: itemsOrdered) {
            salvareComanda.write(item.produsToString() + "\n");

        }

        salvareComanda.write("Pretul total este de RONI" + orderPrice + "\n \n");
        salvareComanda.close();
    }

    /**
     * am folosit si singleton
     * aici s-a facut o metoda privata si returneaza un singur fisier daca instanta e null
     * adica comenzile se scriu intr-un singur fisier , nu mai multe comenzi pe toate fisiere.
     * @return
     */
    private File getFileInstance() {

        if (orders == null) {
            String fileName = inputFile + " " + "Comenzi.txt";
            orders = new File(fileName);
        }
        return orders;
    }
}

