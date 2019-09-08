/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k.means;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * @author Your Name <Magand at MagandCode>
 */
public class KMeans {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Plain plano = new Plain(500,500,1000000,50);
        plano.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        plano.setBackground(Color.BLACK);
    }
    
}
