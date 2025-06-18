package org.example;

import javax.swing.*;
import java.awt.*;

public class AppOkno extends JFrame {

    private JButton pridatukol;
    private JButton smazat;

    private Ukoly ukolPanel;

    private JPanel tlacitkaPanel;
    NavigacniMenu menu = new NavigacniMenu();

    private TaskListPanel taskListPanel;


    public AppOkno(){
        this.setTitle("To-Dooo");
        this.setSize(400, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //  Přidání navigačního menu
        this.add(this.menu, BorderLayout.NORTH);

        taskListPanel = new TaskListPanel();

        // Vytvoření tlačítek pomocí  Tlacitka  třídy
        Icon addIcon = UIManager.getIcon("OptionPane.informationIcon"); //  ikona přidání
        Icon deleteIcon = UIManager.getIcon("OptionPane.errorIcon");   //  ikona smazání

        // inicializace tlačítek
        pridatukol = Tlacitka.createAddUkolButton(addIcon); //  metoda s ikonou
        smazat = Tlacitka.createAddSmazatButton(deleteIcon); //  metoda s ikonou

        // Inicializace panelu 'tlacitkaPanel' a přidání tlačítek
        tlacitkaPanel = new JPanel();
        tlacitkaPanel.setBackground(new Color(0xD2691E)); // Barva pro pozadí za tlačítky
        tlacitkaPanel.add(pridatukol);
        tlacitkaPanel.add(smazat);
        this.add(this.tlacitkaPanel, BorderLayout.SOUTH);

        TaskListPanel seznamUkolu = new TaskListPanel();
        this.add(new JScrollPane(seznamUkolu), BorderLayout.CENTER);


        // Inicializace a přidámí hlavního panelu pro úkoly
        ukolPanel = new Ukoly(pridatukol, smazat, taskListPanel);
        JPanel hlavniPanel = new JPanel();
        hlavniPanel.setLayout(new BoxLayout(hlavniPanel, BoxLayout.Y_AXIS));
        hlavniPanel.add(taskListPanel);

        this.add(hlavniPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }


}
