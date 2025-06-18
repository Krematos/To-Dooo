package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StylePridatUkol extends JButton {

    public StylePridatUkol(String text, Icon icon) {
        super(text, icon);
        initUI();
    }

    private void initUI() {
        // Základní nastavení
        setFocusPainted(false); // Vypne rámeček kolem textu při focusu
        setContentAreaFilled(false); // Vypne výchozí výplň tlačítka
        Zvuk.prehratZvukPridaniUkolu();
        // Nastavení písma
        setFont(new Font("Segoe UI", Font.BOLD, 24)); // Moderní písmo, tučné, velikost 24

        // Barvy
        Color backgroundColor = new Color(0, 123, 255); // Modrá barva pro pozadí (moderní, svěží)
        Color foregroundColor = Color.WHITE; // Bílá barva pro text/ikonu
        Color hoverColor = new Color(0, 86, 179); // Tmavší modrá při najetí myši
        Color pressedColor = new Color(0, 69, 143); // Ještě tmavší modrá při stisknutí

        setBackground(backgroundColor); // Nastaví pozadí pro logiku hoveru
        setForeground(foregroundColor);

        // Zaoblené rohy
        Border roundedBorder = BorderFactory.createEmptyBorder(10, 20, 10, 20); // Vnitřní odsazení
        setBorder(roundedBorder);

        // Efekt při najetí myši a stisknutí
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Přechod barvy by vyžadoval Timer, ale pro jednoduchost změníme hned
                StylePridatUkol.this.setBackground(hoverColor);
                StylePridatUkol.this.setForeground(Color.LIGHT_GRAY); // Lehce zesvětlit text
                StylePridatUkol.this.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                StylePridatUkol.this.setBackground(backgroundColor);
                StylePridatUkol.this.setForeground(foregroundColor);
                StylePridatUkol.this.setBorder(roundedBorder);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                StylePridatUkol.this.setBackground(pressedColor);
                StylePridatUkol.this.setForeground(Color.WHITE); // Zajištění bílé barvy textu při stisknutí
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Vrátí barvu po uvolnění stisku (pokud je myš stále nad tlačítkem, vrátí se na hoverColor)
                if (contains(e.getPoint())) { // Zkontroluje, zda je kurzor stále nad tlačítkem
                    mouseEntered(e);
                } else {
                    mouseExited(e);
                }
            }
        });
    }

    // Přepsání paintComponent pro vlastní vykreslení pozadí (pro zaoblené rohy a barvu)
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Vyhlazení hran

        int width = getWidth();
        int height = getHeight();
        int arc = 20; // Poloměr zaoblení rohů

        g2.setColor(getBackground()); // Použijte nastavenou barvu pozadí
        g2.fillRoundRect(0, 0, width, height, arc, arc);

        super.paintComponent(g2); // Vykreslete zbytek komponenty (text, ikonu)
        g2.dispose();
    }
}
