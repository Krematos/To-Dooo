package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StyleSmazat extends JButton {


    public StyleSmazat(String text, Icon icon) {
        super(text, icon);
        initUI();
    }

    private void initUI() {
        setFocusPainted(false);
        setContentAreaFilled(false);

        setFont(new Font("Segoe UI", Font.BOLD, 24));

        // Barvy pro smazání (červená paleta)
        Color backgroundColor = new Color(220, 53, 69); // Intenzivní červená
        Color foregroundColor = Color.WHITE; // Bílý text pro kontrast
        Color hoverColor = new Color(194, 46, 59); // Tmavší červená při najetí myší
        Color pressedColor = new Color(171, 40, 52); // Ještě tmavší červená při stisknutí

        setBackground(backgroundColor);
        setForeground(foregroundColor);

        // Zaoblené rohy
        Border roundedBorder = BorderFactory.createEmptyBorder(10, 20, 10, 20);
        setBorder(roundedBorder);

        // Efekty při najetí myší a stisknutí
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                StyleSmazat.this.setBackground(hoverColor);
                StyleSmazat.this.setForeground(Color.LIGHT_GRAY); // Lehce zesvětlit text
                StyleSmazat.this.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                StyleSmazat.this.setBackground(backgroundColor);
                StyleSmazat.this.setForeground(foregroundColor);
                StyleSmazat.this.setBorder(roundedBorder);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                StyleSmazat.this.setBackground(pressedColor);
                StyleSmazat.this.setForeground(Color.WHITE);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (contains(e.getPoint())) {
                    mouseEntered(e);
                } else {
                    mouseExited(e);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int arc = 20; // Stejné zaoblení jako u tlačítka přidat pro konzistenci

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, arc, arc);

        super.paintComponent(g2);
        g2.dispose();
    }
}
