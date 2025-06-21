package com.unish.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class CustomButton extends JButton {

    private final Color baseColor = new Color(25, 118, 210);
    private final Color hoverColor = new Color(30, 136, 229);
    private final Color pressedColor = new Color(33, 150, 243);
    private final int arc = 10; // Controls roundness

    public CustomButton(String text, Dimension size) {
        super(text);
        setPreferredSize(size);
        setFont(new Font("Segoe UI", Font.BOLD, 16));
        setBackground(baseColor);
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setContentAreaFilled(false); // We'll paint ourselves
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Hover and click effects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(baseColor);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedColor);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (getBounds().contains(e.getPoint())) {
                    setBackground(hoverColor);
                } else {
                    setBackground(baseColor);
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape round = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arc, arc);
        g2.setColor(getBackground());
        g2.fill(round);

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape round = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
        g2.setColor(new Color(200, 200, 200));
        g2.draw(round);

        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        Shape shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arc, arc);
        return shape.contains(x, y);
    }
}
