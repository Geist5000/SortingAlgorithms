package de.geist5000.sort_examples.ui.view;

import de.geist5000.sort_examples.ui.SortingVisualisation;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * does visualize an array of numbers with bars.
 */
public class BarGraphCanvas extends JComponent implements SortingVisualisation<Integer> {


    public BarGraphCanvas(){
        this.setForeground(Color.BLACK);
    }


    /**
     * the current data, which gets displayed
     */
    private Integer[] data;

    /**
     * the amount of pixels, which stay untouched inside the Component
     */
    private int padding = 20;

    /**
     * does store the max value of the values inside the data array
     */
    private int maxValue;

    @Override
    public void setData(Integer[] data) {
        if(data.length<2){
            throw new IllegalArgumentException("Data array needs to have 2 elements at minimum");
        }
        this.data = data;
        this.repaint();
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBars(g);
    }


    /**
     * does draw all bars, specified in the data array to the component
     * @param g the graphics object used to draw the bars
     */
    private void drawBars(Graphics g){
        if(data != null && data.length>=2){

            Integer[] tmpData = Arrays.copyOf(data,data.length);
            maxValue = getMaxValue(tmpData);
            int barWidth = calcBarWidth(tmpData.length);


            for (int i = 0; i < tmpData.length; i++) {
                Integer value = tmpData[i];
                this.drawBar(g,getBarX(i,barWidth),barWidth,value);
            }
        }

    }

    /**
     * does calculate the x coordinate of the left side of the bar
     * @param index the index of the bar
     * @param width the width every bar has in pixel
     * @return the x coordinate of the left side of the bar
     */
    private int getBarX(int index, int width){
        return padding + index*width;
    }

    /**
     * does calculate the bar width of each bar
     * @param barCount the amount of bars which will get displayed
     * @return the width of each bar
     */
    private int calcBarWidth(int barCount){
        int possibleWidth = this.getWidth()-padding*2;
        return possibleWidth/barCount;
    }


    private Integer getMaxValue(Integer[] data){
        Integer tmpmaxValue = data[0];
        for (int i = 1; i < data.length; i++) {
            if(data[i]>tmpmaxValue){
                tmpmaxValue = data[i];
            }
        }
        return tmpmaxValue;
    }


    /**
     * does draw the bar on the component
     * @param g the Graphics object with is given by the paint method
     * @param x the x coordinate of the left side of the bar in pixels
     * @param width the with of the bar in pixels
     * @param value the value which needs to get represented
     */
    private void drawBar(Graphics g, int x, int width, int value) {
        width = Math.max(1,width);
        if(value > maxValue){
            throw new IllegalStateException("the given value is bigger than max value. Was max value updated?");
        }
        int possibleHeight = this.getHeight() - padding * 2;
        float percentHeight = ((float) value / maxValue);
        int relativeHeight = (int) (possibleHeight * percentHeight);
        g.setColor(getForeground());
        g.fillRect(x, this.getHeight() - padding - relativeHeight, width, relativeHeight);
        g.setColor(getBackground());
        g.drawRect(x, this.getHeight() - padding - relativeHeight, width, relativeHeight);
    }
}
