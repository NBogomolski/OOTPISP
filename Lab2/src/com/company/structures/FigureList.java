package com.company.structures;

import com.company.figures.Figure;
import com.company.painting.FigurePainter;

import java.util.ArrayList;
import java.util.List;

public class FigureList {

    public static List<FigurePainterMapper> figures = new ArrayList<>();

    public static void add(FigurePainter painter, Figure figure){
        figures.add(new FigurePainterMapper(painter, figure));
    }
}
