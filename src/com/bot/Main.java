package com.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Point> points = new ArrayList<Point>();
    private static ArrayList<Line> lines = new ArrayList<Line>();
    static Point point_d = new Point(100, 100);
    static boolean check = false;
    static Point a, b, c, d;

    public static void createGUI() {
        final JFrame frame = new JFrame("Program");
        frame.setPreferredSize(new Dimension(700, 700));
        JPanel panel = new JPanel(new BorderLayout());
        final Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(250, 700));
        final Panel pointpane = new Panel();
        pointpane.setLayout(null);
        //pointpane.setPreferredSize(new Dimension(350,700));

        JLabel addPointwithCoords = new JLabel("Точка по координатам");
        addPointwithCoords.setBounds(2, 2, 300, 25);
        butPanel.add(addPointwithCoords);
        JLabel addRandomPoints = new JLabel("Добавить рандомное количество точек для мн-ва А");
        addRandomPoints.setBounds(2, 50, 300, 25);
        butPanel.add(addRandomPoints);
        JLabel X = new JLabel("X:");
        X.setBounds(2, 25, 15, 25);
        butPanel.add(X);
        JLabel Y = new JLabel("Y:");
        Y.setBounds(45, 25, 15, 25);
        butPanel.add(Y);
        JLabel N = new JLabel("NUM:");
        N.setBounds(2, 70, 30, 25);
        butPanel.add(N);
        final JTextField x = new JTextField();
        x.setBounds(17, 25, 25, 25);
        butPanel.add(x);
        final JTextField y = new JTextField();
        y.setBounds(60, 25, 25, 25);
        butPanel.add(y);
        final JTextField n = new JTextField();
        n.setBounds(35, 70, 25, 25);
        butPanel.add(n);


        JButton button1 = new JButton("Добавить точки из мн-ва А");
        button1.setBounds(2, 170, 230, 40);
        butPanel.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check = false;
                int X = (!x.getText().equals("") ? Integer.parseInt(x.getText()) : 0);
                int Y = (!y.getText().equals("") ? Integer.parseInt(y.getText()) : 0);
                int N = (!n.getText().equals("") ? Integer.parseInt(n.getText()) : 0);
                if (((X > 0) && (Y > 0)) && (!check)) {
                    Point b = new Point(X, Y);
                    points.add(b);
                    b.setBounds(b.x, b.y, b.x + 3, b.y + 3);
                    pointpane.add(b);
                    pointpane.revalidate();
                    pointpane.repaint();
                } else {
                    if (N > 0) {
                        for (int i = 0; i < N; i++) {
                            Point b = new Point((int) (Math.random() * (frame.getWidth() - 250)), (int) (Math.random() * frame.getHeight()));
                            points.add(b);
                            b.setBounds(b.x, b.y, b.x + 3, b.y + 3);
                            pointpane.add(b);
                            pointpane.revalidate();
                            pointpane.repaint();
                        }
                    }
                }

            }
        });


        JButton button = new JButton("Добавить точку d");
        button.setBounds(2, 210, 160, 40);
        butPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check = true;
                int X = (!x.getText().equals("") ? Integer.parseInt(x.getText()) : 0);
                int Y = (!y.getText().equals("") ? Integer.parseInt(y.getText()) : 0);
                if ((X > 0) && (Y > 0) && (check)) {
                    point_d.setX(X);
                    point_d.setY(Y);
                    point_d.setColor(239);
                    point_d.setBounds(point_d.x, point_d.y, point_d.x + 3, point_d.y + 3);
                    pointpane.add(point_d);
                    pointpane.revalidate();
                    pointpane.repaint();
                } else {
                    JLabel addPointwithCoords = new JLabel("Ошибка");
                }
            }
        });


        JButton button5 = new JButton("Считать данные из файла");
        button5.setBounds(2, 130, 200, 40);
        butPanel.add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Scanner in = new Scanner(new File("input.txt"))) {
                    point_d.x = in.nextInt();
                    point_d.y = in.nextInt();
                    point_d.setColor(239);
                    point_d.setBounds(point_d.x, point_d.y, point_d.x + 3, point_d.y + 3);
                    pointpane.add(point_d);
                    pointpane.revalidate();
                    pointpane.repaint();

                    int n = in.nextInt();
                    double points_x[] = new double[n];
                    double points_y[] = new double[n];
                    for (int i = 0; i < n; i++) {
                        points.add(new Point(in.nextInt(), in.nextInt()));
                        points_x[i] = points.get(i).getX();
                        points_y[i] = points.get(i).getY();
                        points.get(i).setBounds(points.get(i).x, points.get(i).y, points.get(i).x + 3, points.get(i).y + 3);
                        pointpane.add(points.get(i));
                        pointpane.revalidate();
                        pointpane.repaint();
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton button4 = new JButton("Рандомные кординаты точки d");
        button4.setBounds(2, 330, 260, 40);
        butPanel.add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                point_d.setX((int) ((Math.random() * (frame.getWidth() - 250))));
                point_d.setY((int) (Math.random() * frame.getHeight()));
                point_d.setColor(239);
                point_d.setBounds(point_d.x, point_d.y, point_d.x + 3, point_d.y + 3);
                pointpane.add(point_d);
                pointpane.revalidate();
                pointpane.repaint();
            }
        });


        JButton button2 = new JButton("очистить");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < points.size(); i++) {
                    while (points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }

                for (int i = 0; i < lines.size(); i++) {
                    while (lines.size() > 0) {
                        int index = lines.size() - 1;
                        Line line = lines.remove(index);
                        pointpane.remove(line);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }
                pointpane.remove(point_d);
                pointpane.repaint();
                pointpane.revalidate();
            }
        });
        button2.setBounds(2, 250, 160, 40);
        butPanel.add(button2);
        panel.add(pointpane, BorderLayout.CENTER);
        panel.add(butPanel, BorderLayout.EAST);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JButton button3 = new JButton("Выполнить");
        button3.setBounds(2, 290, 160, 40);
        butPanel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner sc = new Scanner(System.in);
                int cnt = 0; // определяет количество троек;
                double points_d1[] = new double[2]; //Здесь хранятся координаты точки d: d_x = d[0]; d_y = d[1];
                double ad;//Коэфициент наклона AD;
                double bc;//Коэфициент наклона BC;
                double cd;
                double ab;
                double ads;//смещение прямой на которой лежит отрезок AD по оси х от начала координат;
                double bcs;//смещение прямой на которой лежит отрезок BC по оси х от начала координат;
                int A = points.size();
                int x[] = new int[A];// Координаты_x каждой точки из множества A
                int y[] = new int[A];//Координаты_y каждой точки из множества A
                for (int i = 0; i < A; i++) {
                    x[i] = points.get(i).x;
                    y[i] = points.get(i).y;
                }
                //Вводим координаты точек из множества A
                TheA ArrA = new TheA(A, x, y);
                ArrA.setPoints_x(x, A);
                ArrA.setPoints_y(y, A);
                for (int i = 0; i <= A - 1; i++) // A-3 т.к. ожидаем еще точки b и с. То есть всего А-3 шага;
                {
                    for (int j = 0; j <= A - 1; j++) // Начинаем с i+1 до A-1, то есть всего A-2 шага
                    {
                        for (int k = 0; k <= A - 1; k++) //А-3 шага
                        {
                            if (i == j || j == k || i == k) continue;

                            //B этом цикле перебираются значения (всевозможные) для точек a,b,c. Также, заметим ,что у нас не могут эти точки совпадать.;
                            int m = 0;
                            //a[0]=x[i] a[1]=y[i] - то есть координата точки а_х = x[i]; а_y = y[i];
                            //b[0]=x[j] b[1]=y[j] аналогично
                            //c[0]=x[k] c[1]=y[k]
                            //d[0] и  d[1] смотри в var
                            if ((Math.abs(x[i] - point_d.getX()) == Math.abs(x[j] - x[k])) && (Math.abs(y[i] - point_d.getY()) == Math.abs(y[j] - y[k])) &&
                                    (Math.abs(x[j] - point_d.getX()) == Math.abs(x[i] - x[k])) && (Math.abs(y[j] - point_d.getY()) == Math.abs(y[i] - y[k]))) {
                                if (ArrA.getPoints_x()[i] - point_d.getX() != 0 && ArrA.getPoints_x()[j] - ArrA.getPoints_x()[k] != 0 && ArrA.getPoints_x()[k] - point_d.getX() != 0 && ArrA.getPoints_x()[i] - ArrA.getPoints_x()[j] != 0) {
                                    // Здесь была проверка на равенство проекций AD_x и BC_x, также равенство проекций на _y; Необходимое условие;
                                    ad = (ArrA.getPoints_y()[i] - point_d.getY()) / (ArrA.getPoints_x()[i] - point_d.getX()); // Вычисояем коэфициент наклона отрезка AD;
                                    bc = (ArrA.getPoints_y()[j] - ArrA.getPoints_y()[k]) / (ArrA.getPoints_x()[j] - ArrA.getPoints_x()[k]);// аналогично
                                    cd = (ArrA.getPoints_y()[k] - point_d.getY()) / (ArrA.getPoints_x()[k] - point_d.getX());
                                    ab = (ArrA.getPoints_y()[i] - ArrA.getPoints_y()[j]) / (ArrA.getPoints_x()[i] - ArrA.getPoints_x()[j]);
                                    if (ad == bc && cd == ab) { // сначала проверяем их на параллельность по угловым коэффициентам, а потом на то не лежат ли отрезки на одной прямой
                                        cnt++; // вспомогательный счетчик
                                        Line line = new Line(new Point((int) (ArrA.getPoints_x()[i]), (int) (ArrA.getPoints_y()[i])), point_d);
                                        lines.add(line);
                                        pointpane.add(line);
                                        line.setBounds(2, 2, frame.getWidth(), frame.getHeight());
                                        pointpane.revalidate();
                                        pointpane.repaint();

                                        line = new Line(new Point((int) (ArrA.getPoints_x()[k]), (int) (ArrA.getPoints_y()[k])), new Point((int) (ArrA.getPoints_x()[j]), (int) (ArrA.getPoints_y()[j])));
                                        lines.add(line);
                                        pointpane.add(line);
                                        line.setBounds(2, 2, frame.getWidth(), frame.getHeight());
                                        pointpane.revalidate();
                                        pointpane.repaint();

                                        line = new Line(new Point((int) (ArrA.getPoints_x()[j]), (int) (ArrA.getPoints_y()[j])), point_d);
                                        lines.add(line);
                                        pointpane.add(line);
                                        line.setBounds(2, 2, frame.getWidth(), frame.getHeight());
                                        pointpane.revalidate();
                                        pointpane.repaint();

                                        line = new Line(new Point((int) (ArrA.getPoints_x()[i]), (int) (ArrA.getPoints_y()[i])), new Point((int) (ArrA.getPoints_x()[k]), (int) (ArrA.getPoints_y()[k])));
                                        lines.add(line);
                                        pointpane.add(line);
                                        line.setBounds(2, 2, frame.getWidth(), frame.getHeight());
                                        pointpane.revalidate();
                                        pointpane.repaint();
                                    }
                                }
                            }
                        }
                    }
                }//вызываем нашу проверку всего 2 раза, вместо C из 3 по 2 ,так как только 2 точки из 3 образуют сторону, а последняя диагональ. А значит, если AD_1 и AD_2 не подходят, то это в любои случае не параллелограмм.
                if (cnt != 0)
                    System.out.print("Количество троек:" + cnt + "");
                else
                    System.out.print("Троек нет");
                JLabel addPointwithCoords = new JLabel("Ответ: " + (cnt == 0 ? "Троек Нет" : cnt));
                addPointwithCoords.setBounds(2, 390, 300, 25);
                butPanel.add(addPointwithCoords);
                butPanel.repaint();
                butPanel.revalidate();
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}