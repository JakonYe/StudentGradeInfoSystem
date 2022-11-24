package com.jakon;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // 显示应用 com.jakon.GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                Method.initStudentInfo();
                GUI.createAndShowGUI();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
