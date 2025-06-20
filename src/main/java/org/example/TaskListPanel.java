package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TaskListPanel extends JPanel {

    // Seznam pro uchování všech panelů s úkoly. Každý úkol je reprezentován jako JPanel.
    private final java.util.List<JPanel> ukoly = new ArrayList<>();

    // Konstruktor třídy List
    public TaskListPanel() {
        // Nastaví rozvržení (layout) tohoto panelu na BoxLayout s osou Y.
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Nastaví barvu pozadí panelu s úkoly.
        this.setBackground(new Color(210, 180, 140));
    }

    /**
     * Metoda pro přidání nového úkolu do seznamu.
     * @param text Text úkolu, který se má zobrazit.
     */
    public void addUkol(String text) {


        JButton splneno = new JButton("✔");     // Vytvoření tlačítka "splněno"
        System.out.println("Jede pridat?");  // kontrola tlačítka
        splneno.setFocusPainted(false);     // Zabrání vykreslování rámečku při zaměření tlačítka
        splneno.setMargin(new Insets(2, 8, 2, 8));  // Nastaví vnitřní okraje tlačítka
        splneno.setBackground(new Color(0x4CAF50)); // Nastaví zelenou barvu pozadí
        splneno.setForeground(Color.WHITE);     // Nastaví bílou barvu textu
        splneno.setPreferredSize(new Dimension(40,40));

        // Vytvoření panelu pro jeden úkol.
        JPanel ukolPanel = new JPanel();
        ukolPanel.setBackground(new Color(210, 180, 140));
        System.out.println("Jede panel?");      // kontrola
        ukolPanel.setPreferredSize(new Dimension(150, 40));
        ukolPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        ukolPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Vytvoření textového pole pro zobrazení textu úkolu
        JTextField textLabel = new JTextField(text);
        System.out.println("Jede textové pole?");   // kontrola        ;
        textLabel.setPreferredSize(new Dimension(150, 40));
        textLabel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));

        // Odstranění úkolu po kliknutí
        JButton smazatUkol = new JButton("x");
        System.out.println("Jede smazat?");     // kontrola
        smazatUkol.setFocusPainted(false);      // Zabrání vykreslování rámečku při zaměření tlačítka
        smazatUkol.setMargin(new Insets(2, 8, 2, 8));
        smazatUkol.setPreferredSize(new Dimension(40,40));
        smazatUkol.setBackground(Color.RED);
        smazatUkol.setForeground(Color.WHITE);

        // Přidání posluchače událostí (ActionListener) na tlačítko "smazat úkol"
        smazatUkol.addActionListener(e -> {
            this.remove(ukolPanel);
            ukoly.remove(ukolPanel);
            System.out.println("Funguje smazat?"); // kontrola
            revalidate();   // Znovu přepočítá rozvržení
            repaint();      // Znovu překreslí
        });
        // Přidání posluchače událostí (ActionListener) na tlačítko "splněno"
        splneno.addActionListener(e -> {
            textLabel.setForeground(Color.GRAY);
            textLabel.setText("<html><strike>" + text + "</strike></html>");
            Zvuk.prehratZvukSplneni();
            System.out.println("Jede?"); // kontrola
        });

        ukolPanel.add(splneno, BorderLayout.WEST);
        ukolPanel.add(textLabel, BorderLayout.CENTER);
        ukolPanel.add(smazatUkol, BorderLayout.EAST);


        ukoly.add(ukolPanel);
        this.add(ukolPanel);
        //this.add(Box.createVerticalStrut(5)); // mezera mezi úkoly
        revalidate();
        repaint();
    }
}




