package org.example;

import javax.swing.*;


public class Tlacitka extends JPanel {



    /**
     * Vytvoří a vrátí moderní tlačítko "Přidat úkol" s textem a ikonou.
     * @param icon Ikona pro tlačítko.
     * @return JButton pro přidání úkolu
     */
    public static JButton createAddUkolButton(Icon icon) {
        return new StylePridatUkol("Přidat úkol", icon);
    }

    /**
     * Vytvoří a vrátí moderní tlačítko "Splněno" s textem a ikonou.
     * @param icon Ikona pro tlačítko.
     * @return JButton pro dokončení úkolu
     */

    public static JButton createAddSmazatButton(Icon icon){
        return new StyleSmazat("Smazat", icon);
    }

}
