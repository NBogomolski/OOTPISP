package com.company.structures;

import com.company.figures.Figure;
import com.company.painting.FigurePainter;

public class FigurePainterMapper {

    private FigurePainter painter;
    private Figure figure;

    public FigurePainterMapper(FigurePainter painter, Figure figure) {
        this.painter = painter;
        this.figure = figure;
    }

    public FigurePainter getPainter() {
        return painter;
    }

    public void setPainter(FigurePainter painter) {
        this.painter = painter;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }
}
