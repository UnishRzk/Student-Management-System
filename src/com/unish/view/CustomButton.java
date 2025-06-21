package com.unish.view;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButton extends JButton {

    private final Color baseColor = new Color(25, 118, 210);
    private final Color hoverColor = new Color(30, 136, 229);
    private final Color pressedColor = new Color(33, 150, 243);

    public CustomButton(String text, Dimension dimension) {
        super(text);

        setPreferredSize(dimension);
        setFont(new Font("Segoe UI", Font.BOLD, 16));
        setBackground(baseColor);
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorder(new RoundedBorder(12));
        setContentAreaFilled(false);
        setOpaque(true);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setMargin(new Insets(10, 20, 10, 20)); // Padding

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(baseColor);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedColor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (getBounds().contains(e.getPoint())) {
                    setBackground(hoverColor);
                } else {
                    setBackground(baseColor);
                }
            }
        });
    }

    static class RoundedBorder extends AbstractBorder {
        private final int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(200, 200, 200)); // Light gray border
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(10, 20, 10, 20);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.set(10, 20, 10, 20);
            return insets;
        }
    }
    }

