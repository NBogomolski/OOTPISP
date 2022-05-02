package com.company;

import com.company.ui.UIConfigurer;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        final JFrame frame = new JFrame();
        UIConfigurer uiConfigurer = new UIConfigurer();
        uiConfigurer.initFrame(frame);
    }
}
