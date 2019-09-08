/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k.means;

import java.awt.Color;
/**
 *
 * @author Your Name <Magand at MagandCode>
 */

public class Kategory {
int nKategory;
Color color;
int mean = 1;
int x,y;
    public Kategory(){
        this.nKategory = nKategory;
        this.color = color;
        this.mean=mean;
        this.x = x;
        this.y = y;
    }
    
    public int CalculateMean(Point point,Kategory k){
        int sum = 0;
        //si la categoria del punto revisado es igual a la kategoria que reviso 
        // sumo la media
        if(point.getKate()==k.getnKategory()){
            sum = point.DistancePoint(point.getxCoord(), point.getyCoord(),k.getX(),k.getY())+sum;
        }
        return sum;
    }

    public int getMean() {
        return mean;
    }

    public void setMean(int mean) {
        this.mean = mean;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getnKategory() {
        return nKategory;
    }

    public void setnKategory(int nKategory) {
        this.nKategory = nKategory;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
     public int DistancePoint(int x1,int y1, int x2,int y2){
        float distance = 0;
        float a = x2-x1;
        float b = y2-y1;
        a = a*a;
        b = b*b;
        distance = (float) Math.sqrt(a+b);
        return (int)distance;
    }
}
