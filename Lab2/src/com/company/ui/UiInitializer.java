package com.company.ui;


import com.company.structures.FigureList;
import com.company.ui.menu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


//Class for creating canvas panel & menu
public class UiInitializer {

    private JFrame frame;
    public JPanel drawingCanvas;
    private Graphics graphics;

    public void initFrame(JFrame frame){
        this.frame = frame;
        frame.setSize(700,600);
        frame.setTitle("Paint lite");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createShapesActionMenu());

        frame.setJMenuBar(menuBar);

        drawingCanvas = new JPanel(){
            @Override
            public void paint(Graphics g){
                super.paint(g);
                paintFigures(g);
            }
        };
        frame.add(drawingCanvas);

        JButton update = new JButton("Update");
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                drawingCanvas.repaint();
            }
        });
        menuBar.add(update);

        drawingCanvas.setVisible(true);
        drawingCanvas.revalidate();
        frame.setVisible(true);
    }


    //Adding menu items & creating a shape-specific form for each one
    private JMenu createShapesActionMenu(){
        JMenu menu = new JMenu("Add a new shape");

        JMenuItem lineItem = new JMenuItem("Line");
        JMenuItem rhombusItem = new JMenuItem("Rhombus");
        JMenuItem parallelogramItem = new JMenuItem("Parallelogram");
        JMenuItem rectangleItem = new JMenuItem("Rectangle");
        JMenuItem squareItem = new JMenuItem("Square");
        JMenuItem ovalItem = new JMenuItem("Ellipse");
        JMenuItem circleItem = new JMenuItem("Circle");

        lineItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MenuFigureItemListener itemLine = new MenuFigureItemLine();
                List<String> stringList = new ArrayList<>();
                stringList.add("x of first point");
                stringList.add("y of first point");
                stringList.add("x of second point");
                stringList.add("y of second point");
                itemLine.createFields("Draw a Line", stringList);
            }
        });

        rhombusItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MenuFigureItemListener itemRhombus = new MenuFigureItemRhombus();
                List<String> stringList = new ArrayList<>();
                stringList.add("x");
                stringList.add("y");
                stringList.add("x width");
                stringList.add("y angle (radians)");
                itemRhombus.createFields("Draw a Rhombus",stringList);

            }
        });

        parallelogramItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MenuFigureItemListener itemRhombus = new MenuFigureItemParallelogram();
                List<String> stringList = new ArrayList<>();
                stringList.add("x");
                stringList.add("y");
                stringList.add("width");
                stringList.add("height");
                stringList.add("y angle (radians)");
                itemRhombus.createFields("Draw a Parallelogram", stringList);
            }
        });

        rectangleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MenuFigureItemListener itemRhombus = new MenuFigureItemRectangle();
                List<String> stringList = new ArrayList<>();
                stringList.add("x");
                stringList.add("y");
                stringList.add("width");
                stringList.add("height");
                itemRhombus.createFields("Draw a Rectangle", stringList);
            }
        });

        squareItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MenuFigureItemListener itemRhombus = new MenuFigureItemSquare();
                List<String> stringList = new ArrayList<>();
                stringList.add("x");
                stringList.add("y");
                stringList.add("width");
                itemRhombus.createFields("Draw a Square", stringList);
            }
        });

        ovalItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MenuFigureItemListener itemRhombus = new MenuFigureItemOval();
                List<String> stringList = new ArrayList<>();
                stringList.add("x");
                stringList.add("y");
                stringList.add("width");
                stringList.add("height");
                itemRhombus.createFields("Draw an Ellipse", stringList);
            }
        });

        circleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MenuFigureItemListener itemRhombus = new MenuFigureItemCircle();
                List<String> stringList = new ArrayList<>();
                stringList.add("x");
                stringList.add("y");
                stringList.add("radius");
                itemRhombus.createFields("Draw a Circle", stringList);
            }
        });

        menu.add(lineItem);
        menu.add(rhombusItem);
        menu.add(parallelogramItem);
        menu.add(rectangleItem);
        menu.add(squareItem);
        menu.add(ovalItem);
        menu.add(circleItem);

        return menu;
    }


    private void paintFigures(Graphics g){
        FigureList.figures.forEach(i -> {i.getPainter().draw(g, i.getFigure());});
    }


    public JFrame getFrame() { return frame; }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getDrawingCanvas() {
        return drawingCanvas;
    }

    public void setDrawingCanvas(JPanel jPanel) {
        this.drawingCanvas = jPanel;
    }
}
