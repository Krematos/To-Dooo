package org.example;

import javax.swing.*;
import java.awt.*;

// Třída NavigacniMenu rozšiřuje JPanel, což znamená, že je to vizuální kontejner
public class NavigacniMenu extends JPanel {

    // Deklarace JLabel komponenty, která bude zobrazovat text "To-Dooo" v menu.
    // Je deklarována jako instanční proměnná, aby k ní bylo možné přistupovat v celém objektu.
    JLabel MenuText = new JLabel("To-Dooo");
    // Konstruktor třídy NavigacniMenu

    public NavigacniMenu(){
        // Nastaví preferovanou velikost tohoto panelu.
        this.setPreferredSize(new Dimension(400, 80));
        this.setBackground(new Color(0xD2691E));   // Nastaví barvu pozadí navigačního menu pomocí hexadecimální hodnoty.

        // Nastaví minimální velikost pro JLabel s textem menu.
        MenuText.setMinimumSize(new Dimension(150,40));
        MenuText.setFont(new Font("Segoe UI", Font.BOLD, 48));
        MenuText.setHorizontalAlignment(JLabel.CENTER); // Nastaví horizontální zarovnání textu v JLabelu na střed.
        this.add(this.MenuText);   // Přidá JLabel (MenuText) do tohoto panelu (NavigacniMenu)
    }

}
