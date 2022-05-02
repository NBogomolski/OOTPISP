package com.company;

import com.company.ui.UiInitializer;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        final JFrame frame = new JFrame();
        UiInitializer uiInitializer = new UiInitializer();
        uiInitializer.initFrame(frame);
    }
}
