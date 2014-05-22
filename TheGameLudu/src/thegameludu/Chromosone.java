/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thegameludu;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ibrahim
 */
public class Chromosone
{
    
    Random rand=new Random();
    int chromosone[]=new int[4];
    
    public void setChromosone(ArrayList<Piece> active_pieces)
    {
            for(int i=0; i<4; ++i)
            {
                chromosone[i]=0;
            }
            int option=rand.nextInt(((active_pieces.size()-1) - 1) + 1) + 0;

            chromosone[option]=active_pieces.get(option).pieceNumber;
    }

    public void print()
    {
        for(int i=0; i<4; i++)
        {
            System.out.print(this.chromosone[i]);
        }
        System.out.println();
    }
}