package de.geist5000.sort_examples.ui;

import de.geist5000.sort_examples.ui.view.BarGraphCanvas;

import javax.swing.*;
import java.awt.*;

public class UIFrame extends JFrame implements SortingVisualisation<Integer> {


    private BarGraphCanvas barCanvas;

    public static void main(String[] args) {
        JFrame frame = new UIFrame();
    }

    public UIFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setSize(500, 300);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setTitle("Sorting visualisation!");
        addComponents();
    }

    private void addComponents() {
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());


        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.RED);
        controlPanel.setPreferredSize(new Dimension(100, 0));


        container.add(controlPanel, BorderLayout.LINE_END);
        this.barCanvas = new BarGraphCanvas();
        container.add(this.barCanvas, BorderLayout.CENTER);
    }

    @Override
    public void setData(Integer[] data) {
        this.barCanvas.setData(data);
    }
}
