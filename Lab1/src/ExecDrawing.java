

import section.Section;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 1. "Ознакомление с концепциями ООП: наследование и полиморфизм типов (виртуальные методы)"
 Построить иерархию классов для вывода графических фигур: отрезок, прямоугольник, эллипс и
 т.д - не менее 6 фигур. Распределить классы по модулям. Создать список фигур в виде отдельного класса.
 В главном модуле программы добавить в список различные фигуры (статическая инициализация),
 после чего запустить рисование списка фигур. Выполнить задание на языке C++, C# или Java.
 Для рисования использовать любую подходящую графическую библиотеку.
 Если изучение графической библиотеки вызывает затруднение, допускается вывод фигур в файл или на экран
 в виде текстовых строк вида "Rectangle(10, 20, 30, 40)".
*/
/*
 2. "Графический редактор"
    Расширить пример с графическими фигурами так, чтобы фигуры можно было создавать на
    уровне пользовательского интерфейса. Существуют несколько способов: ввод координат с
    помощью мыши, диалоговый ввод значений, ввод на скриптовом языке. Студент может выбрать
    любой способ ввода. Создание объекта должно выполняться так, чтобы добавление нового
    класса в систему не требовало изменения существующего кода (выбор типа с помощью оператора
    case/switch и множественного if делать нельзя). Получившаяся программа должна представлять
    собой примитивный графический редактор.
    Классы фигур не должны содержать метод рисования.

    Проект должен разрабатываться с использование системы контроля версий git/svn.
    Все функции/процедуры, большие блоки кода должны содержать комментарии. Язык комментариев - английский.
 */

public class ExecDrawing {
    public static void main(String[] args) {
        Section section = new Section();
        section.setStart(new Point(100, 200));
        section.setEnd(new Point(300, 400));
        System.out.println(section.getStart().toString() + section.getEnd());
//        DrawingFrame window = new DrawingFrame();

    }

    static class DrawingFrame extends JFrame {
        MyCanvas canvas;


       public DrawingFrame() {
           this.setTitle("Shapes");
           this.setExtendedState(JFrame.MAXIMIZED_BOTH);
           this.setMinimumSize(new Dimension(300, 300));
           this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.setVisible(true);
//           MyCanvas canvas = new MyCanvas();
//           this.add(canvas);
        }


    }
}

class MyCanvas extends JPanel implements MouseListener {
    private Image img;      // Contains the image to draw on MyCanvas

    public MyCanvas() {
        // Initialize img here.
        this.addMouseListener(this);
    }


    public void paintComponent(Graphics g) {
        // Draws the image to the canvas
        g.drawImage(img, 0, 0, null);
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        Graphics g = img.getGraphics();
        g.fillOval(x, y, 3, 3);
        g.dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
