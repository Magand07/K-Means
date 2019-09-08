/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k.means;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Your Name <Magand at MagandCode>
 */
public class Plain extends JFrame {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int radio = 5; 
    int margin = 20;
    int points; //number of points to paint
    int kategories; //number of groups
    int xmargin;
    int ymargin;
    Random rand = new Random(System.currentTimeMillis());
    
    public Plain(int xmargin,int ymargin,int points, int kategories){
        setVisible(true);
        setSize(xmargin+margin,ymargin+margin);
        setTitle("KMeans");
        this.points = points;
        this.kategories = kategories;
        this.xmargin = xmargin;
        this.ymargin = ymargin;
    }
    @Override
    public void paint(Graphics g){
        Point[] puntitos = PointsOnPlain();
        Kategory[] categorias = createKategory();
        calculateDistance(puntitos, categorias);
        System.out.println("Para dibujar...");
        /*
        for(int j =0;j<5;j++){
            checkMean(puntitos, categorias);
            calculateDistance(puntitos, categorias);
            checkMean(puntitos, categorias);
        
        }
        */
        DrawPoints(puntitos,g);
        
        try {
            String r =br.readLine();
            if(!r.equals('0')){
            } else {
                setVisible(false);
                System.exit(0);
            }
        } catch (IOException ex) {
            Logger.getLogger(Plain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /***
     * Generate all points on plain 
     * @param g to graficate point in plain, maybe i will don't do this
     * @return array with all points 
     */
    public Point[] PointsOnPlain(){
        Point [] ps = new Point[points];
        for(int i = 0 ;i<points;i++){
            ps[i] = new Point();
            ///x , y ,r1 ,r2     
            int x = rand.nextInt(xmargin-20+1)+20;
            int y = rand.nextInt(ymargin-20+1)+20;
           // ps[i].setColor(Color.WHITE);
            ps[i].setxCoord(x); 
            ps[i].setyCoord(y);
        }
        return ps;
    }
    /***
     * Generate n Categories on plain
     * @return an array with points type category
     */
    public Kategory[] createKategory(){
        Kategory[] k = new Kategory[kategories];
        for (int i = 0 ; i<kategories;i++){
            k[i] = new Kategory();
            int x = rand.nextInt(xmargin-20+1)+20;
            int y = rand.nextInt(ymargin-20+1)+20;
            
            float r = rand.nextFloat();
            float ge = rand.nextFloat();
            float b = rand.nextFloat();
            Color color = new Color(r,ge,b);
            
            k[i].setX(x);
            k[i].setY(y);
            k[i].setColor(color);
            k[i].setnKategory(i);
           //System.out.println(" vuelta: "+i+"c: "+x+","+y+" color: "+color.toString());
           //System.out.println(color.toString());
     
            //g.drawOval(x, y, radio+20, radio+20);
            //g.setColor(color);
            //g.fillOval(x, y, radio+20, radio+20);
        }
        return k;
    }
   /***
    * This function convert a nearest point to a kategory,
    * set the color,minus distance, and kategory of point
    * @param ps points in plain
    * @param k kategories of plain
    */
    public void calculateDistance(Point[] ps, Kategory[] k){
        Color color = null;
        for (int i= 0;i<points;i++){
            int xMin=0,yMin=0;
            
            int x1 = ps[i].getxCoord();
            int y1 = ps[i].getyCoord();
            int min = 99999999;
            for(int j = 0;j<kategories;j++){
                int x2 = k[j].getX();
                int y2 = k[j].getY();
                
                int distance = ps[i].DistancePoint(x1, y1, x2, y2);
                if(distance < min){
                   min = distance;
                   // nuevo color a puntito de la categoria con menor distancia
                   Color c = k[j].getColor();
                   //System.out.println(" ->"+c.toString());
                   ps[i].setColor(c);
                   ps[i].setKate(k[j].getnKategory());
                   ps[i].setMyDistance(distance);//posiblemente ayude a sacarlasmedias
                   color = k[j].getColor();
                }
                //System.out.println("Distancia : " + distance + " x1,y1 : "+x1+","+y1+ " x2,y2 : "+x2+","+y2);
            }
            //System.out.println("Distancia menor: "+min+" color que toca : "+color.toString()+" x,y "+xMin+","+yMin);
        } 
    }
    /***
     *This function move the kategories on our means 
     * @param ps
     * @param ks 
     */
    public void checkMean(Point[] ps,Kategory[] ks){
        int newX = 0;
        int newY = 0;
        int sumX = 0,sumY = 0;
        
        // un array donde meter el promedio de cada categoria
        for(int i =0;i<this.kategories;i++){
            int pointsOnKategory =1;
            for(int k = 0;k<points;k++){
                if(ps[k].getKate()==ks[i].getnKategory()){
                   sumX = sumX+ps[k].getxCoord();
                   sumY = sumY+ps[k].getyCoord();
                   pointsOnKategory++;
                }
            }
            newX = sumX / pointsOnKategory;
            newY = sumY / pointsOnKategory;
            ks[i].setX(newX);
            ks[i].setY(newY);
        }
    }
    /***
     * Loops colored the points on plain
     * @param ps
     * @param g 
     */
    public void DrawPoints(Point[] ps,Graphics g){
        for(int i =0;i<points;i++){
            
            g.fillOval(ps[i].getxCoord(),ps[i].getyCoord(), radio, radio);
            g.setColor(ps[i].getColor());
            g.fillOval(ps[i].getxCoord(),ps[i].getyCoord(), radio, radio);
        }
        /*
        for(int j = 0;j<kategories;j++){
            g.fillOval(ks[j].getX(),ks[j].getY(), radio+20, radio+20);
            g.setColor(ks[j].getColor());
            g.fillOval(ks[j].getX(),ks[j].getY(), radio+20, radio+20);
        }
        */
    }
    
    /***
     * for test
     * @param points 
     */
    public void seePoints(Point []points){
        for (Point point : points) {// recorrer un arreglo exaustivamente
            System.out.println(point.getxCoord() + "," + point.getyCoord());
        }
    }
     public void seePoints(Kategory []ks){
        for (Kategory k : ks) {// recorrer un arreglo exaustivamente
            System.out.println(k.getX() + "," + k.getY());
        }
    }
    
    
}    
    

