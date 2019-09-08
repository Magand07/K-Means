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
public class Point {
    int xCoord;
    int yCoord;
    int myDistance;
    int kate;
    float r,ge,b;
    Color color;
    
    public Point(){
        this.myDistance = myDistance;
        this.kate = kate;
        this.color = color;
        this.xCoord=xCoord;
        this.yCoord=yCoord;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getGe() {
        return ge;
    }

    public void setGe(float ge) {
        this.ge = ge;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }
    

    public int getMyDistance() {
        return myDistance;
    }

    public void setMyDistance(int myDistance) {
        this.myDistance = myDistance;
    }

    public int getKate() {
        return kate;
    }

    public void setKate(int kate) {
        this.kate = kate;
    }

    
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
    
    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
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
