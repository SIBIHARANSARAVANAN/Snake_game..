/*
 * Copyright © 2016-2017 spypunk <spypunk@gmail.com>
 *
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 */

package spypunk.snake.ui.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import spypunk.snake.model.Snake;
import spypunk.snake.ui.cache.ImageCache;
import spypunk.snake.ui.font.cache.FontCache;

public abstract class AbstractSnakeView extends AbstractView {

    private final SnakeViewComponent snakeViewComponent = new SnakeViewComponent();

    protected final class SnakeViewComponent extends JLabel {

        private static final long serialVersionUID = 6003149880091809914L;

        @Override
        protected void paintComponent(final Graphics graphics) {
            super.paintComponent(graphics);

            final Graphics2D graphics2d = (Graphics2D) graphics;

            graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            doPaint(graphics2d);
        }
    }

    protected AbstractSnakeView(final FontCache fontCache, final ImageCache imageCache, final Snake snake) {
        super(fontCache, imageCache, snake);
    }

    protected void initializeComponent(final int width, final int height) {
        snakeViewComponent.setPreferredSize(new Dimension(width, height));
    }

    protected void initializeComponentWithBorders(final int width, final int height) {
        initializeComponent(width, height);

        snakeViewComponent.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    public Component getComponent() {
        return snakeViewComponent;
    }

    protected abstract void doPaint(final Graphics2D graphics);
}
