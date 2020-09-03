package com.laine.casimir.tetris.swing;

import com.laine.casimir.tetris.swing.view.SwingManager;

import javax.swing.*;

public final class Main {

    private Main() {}

    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        SwingUtilities.invokeLater(SwingManager::new);
    }
}
