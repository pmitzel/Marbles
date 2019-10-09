/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Del Peter
 */
public class Outlab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //New instance of Nim class
        Nim n = new Nim();
        
        //Three methods that run the program
        n.setup();
        n.print_setup();
        n.play_game();
}
}
