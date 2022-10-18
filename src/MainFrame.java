import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
// aici se initiaza variabilele si fereastra aferenta
public class MainFrame extends JFrame {

    private BigDecimal costTotal;
    private MenuReader menuRead;
    private JPanel factura;
    private JPanel centerPanel;
    private JTextField pretComanda;
    private ArrayList <MenuItem> produseCumparate;
    private JTextPane orderItems;
    private String infoProdus;

    public MainFrame(File givenMenu) throws FileNotFoundException {
        /**
         * initializari variabile
         */
        costTotal = new BigDecimal(0);
        infoProdus = "";

        produseCumparate = new ArrayList<MenuItem>();
        // meniul se va citi din fisiere
        menuRead = new MenuReader(givenMenu);
        menuRead.readInputFile();
        create();
        // fereastra
        setSize(1300,1300);
        setTitle("Magazin IT");
        setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

  // pannel
    public void create() {
        JPanel mainPanel = (JPanel) getContentPane();
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, getItemButtons(), getfactura());

        splitPane.setDividerLocation(780);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(splitPane, BorderLayout.CENTER);


    }

    private JScrollPane getItemButtons() {
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(0,2));

        ArrayList<MenuItem> itemButtons = menuRead.getMenuItems();
   // se citeste din fisier si se creeaza fiecare buton din fisier
        for (final MenuItem itemButton: itemButtons) {

            final JButton createButton = new JButton(itemButton.getName());
            createButton.setToolTipText(itemButton.getName());

            createButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    refreshPanel(itemButton);
                }
            });
            pan.add(createButton);
            createButton.setPreferredSize(new Dimension(30,60));

        }
        /**
            aici e panelul unde vor si butoanele
         */
        JScrollPane scroller = new JScrollPane(pan);
        Border etchedBorder = BorderFactory.createEtchedBorder();
        Border border = BorderFactory.createTitledBorder(etchedBorder, "Lista de produse",TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Lucida", Font.BOLD, 20) , Color.BLACK);
        pan.setBorder(border);
        return scroller;

    }
    /**
     * aici se afla pozitionarea listelor de comenzi, si multe altele
     */
    private JPanel getfactura() {

        factura = new JPanel();
        JLabel label = new JLabel("Lista comanda:");
        factura.setLayout(new BorderLayout());

        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new BorderLayout());

        factura.add(lowerPanel,BorderLayout.SOUTH);
        factura.add(label, BorderLayout.NORTH);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0,1));

        orderItems = new JTextPane();
        centerPanel.add(orderItems);

        orderItems.setEditable(false);

        JScrollPane centerPanelScroller = new JScrollPane(centerPanel);
        factura.add(centerPanelScroller, BorderLayout.CENTER);

        pretComanda = new JTextField(20);
        pretComanda.setText("Cost Total = RON0.00");
        pretComanda.setEditable(false);
        JButton placeOrder = new JButton("Trimite Comanda");
        JButton clearOrder = new JButton("Sterge Lista");

        placeOrder.setPreferredSize(new Dimension(30,50));
        clearOrder.setPreferredSize(new Dimension(30,50));

        centerPanel.setBackground(Color.LIGHT_GRAY);
        placeOrder.setForeground(Color.BLUE);
        clearOrder.setForeground(Color.RED);

        placeOrder.setFont(new Font ("Google Sans", Font.BOLD,40));
        clearOrder.setFont(new Font ("Google Sans", Font.BOLD,40));

        clearOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                delete();

            }

        });

        placeOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Aici se verefica daca exista comenzi si afiseaza mesajul daca exista. Daca nu , apare eroare.
                 */
                try {
                    if (!pretComanda.getText().equals("Cost Total = RON0.00")) {
                        menuRead.logOrder(produseCumparate, costTotal);
                        JOptionPane.showMessageDialog(getContentPane(), "Comanda a fost trimisa.", "Continut a fost salvat in fisier.", JOptionPane.INFORMATION_MESSAGE);
                        delete();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Nu sunt produse cumparate.", "Cumpara", JOptionPane.ERROR_MESSAGE);
                    }

                }
                catch (IOException g) {

                    JOptionPane.showMessageDialog(null, "Eroare! Programul se inchide!"
                            , "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        });
        /**
         * Adding to the panel
         */
        lowerPanel.add(pretComanda, BorderLayout.NORTH);
        lowerPanel.add(placeOrder, BorderLayout.CENTER);
        lowerPanel.add(clearOrder, BorderLayout.SOUTH);
        lowerPanel.setBackground(Color.LIGHT_GRAY);
        factura.setBackground(Color.WHITE);
        return factura;

    }

    private void delete() {
        pretComanda.setText("Cost Total = RON0.00");
        costTotal = new BigDecimal(0);
        produseCumparate.clear();
        infoProdus = "";
        orderItems.setText(null);
    }

    private void refreshPanel(final MenuItem itemButton) {
        String item = itemButton.getName();
        BigDecimal pretProdus = itemButton.getCost();
        infoProdus += "\n" + item + "\n" + pretProdus + "\n";
        orderItems.setText(infoProdus);
        produseCumparate.add(itemButton);

        costTotal = costTotal.add(pretProdus) ;
        pretComanda.setText("Pret total = lei" + costTotal);
    }


}
