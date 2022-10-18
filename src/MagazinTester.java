import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;


public class MagazinTester {

    /**
     * aici introducerea fisierului.
     * am tratat problema existentei fisierului
     */
    public static void main(String[] args) throws FileNotFoundException {

        try{

            File inputFile = new File(JOptionPane.showInputDialog("Introdu numele magazinului"));

            MainFrame guiFrame = new MainFrame(inputFile);
        }

        catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Eroare. Fisier negasit!", "Eroare gasire fisier.", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e) {

            JOptionPane.showMessageDialog(null, "Eroare. Programul se inchide."
                    , " Eroare", JOptionPane.ERROR_MESSAGE);
        }


    }

}
