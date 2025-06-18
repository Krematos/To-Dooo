package org.example;

import javax.swing.*;
import java.awt.*;

// Třída Ukoly rozšiřuje JPanel, což znamená, že je to vizuální kontejner
public class Ukoly extends JPanel {

    // Textové pole pro zadávání nového úkolu.
    // Inicializováno s výchozím textem "Zadej úkol"
    private JTextField ukol = new JTextField("Zadej úkol");

    // Reference na panel, který spravuje a zobrazuje seznam úkolů.
    private TaskListPanel taskListPanel;

    /**
     * Konstruktor třídy Ukoly.
     * @param pridatukol Tlačítko pro přidání úkolu (předáno z hlavního okna).
     * @param smazat Tlačítko pro smazání všech úkolů (předáno z hlavního okna).
     * @param taskListPanel Panel, který obsahuje a spravuje jednotlivé úkoly.
     */
    public Ukoly(JButton pridatukol, JButton smazat, TaskListPanel taskListPanel) {
        // Uloží referenci na TaskListPanel, aby s ním třída Ukoly mohla interagovat.
        this.taskListPanel = taskListPanel;

        // Nastaví rozvržení (layout) tohoto panelu na FlowLayout se zarovnáním doleva.
        // Komponenty se budou řadit zleva doprava v jednom řádku.
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setPreferredSize(new Dimension(350, 50));  // Nastaví preferovanou velikost tohoto panelu (šířka 350, výška 50 pixelů).

        // Nastaví preferovanou velikost textového pole pro úkol.
        ukol.setPreferredSize(new Dimension(100, 20));
        // Nastaví okraj textového pole s barvou (0xD2691E je oranžová/hnědá)
        ukol.setBorder(BorderFactory.createLineBorder(new Color(0xD2691E)));
        this.add(ukol);     // Přidá textové pole do tohoto panelu (Ukoly).


        pridatukol.addActionListener(e -> {
            String textZPole = ukol.getText().trim();
            System.out.println("Funguje přidání"); // kontrola
            taskListPanel.addUkol(textZPole);
            taskListPanel.revalidate();
            taskListPanel.repaint();
        });

        // Přidá posluchače událostí na tlačítko "smazat" (pravděpodobně pro smazání všech úkolů).
        smazat.addActionListener(e -> {
            taskListPanel.removeAll();  // Odstraní všechny komponenty (úkoly) z taskListPanelu.
            taskListPanel.revalidate(); // Znovu přepočítá rozvržení taskListPanelu.
            taskListPanel.repaint();    // Znovu překreslí taskListPanel, aby se změny projevily.
        });

    }

}
