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
public class GeneticAlgorithim 
{
    ArrayList<Piece> activePieces;
    Chromosone population[];
    int population_size;
    
    public GeneticAlgorithim(ArrayList<Piece> active_pieces)
    {
        population_size=40;
        this.activePieces=active_pieces;
        population = new Chromosone[population_size];
        
        for(int i=0; i<population_size;i++)
        {
            population[i]=new Chromosone();
            population[i].setChromosone(activePieces);
        }
        
    }
    
    public int calculateFitness(Chromosone chromosone)
    {
        int i=0;
        for (int k=0; k<4; ++k)
        {
            if(chromosone.chromosone[k] != 0  )
            {
                i=k;
                break;
            
            }
        }
        
        
        int score=0;
            
            //beat other pawn directly
            if(activePieces.get(i).boardpoint + LudoTheGame.board.dice_num <44)
            {
                if(LudoTheGame.board.fields[activePieces.get(i).boardpoint + LudoTheGame.board.dice_num].listOfPieces.size()!=0 &&
                    LudoTheGame.board.fields[activePieces.get(i).boardpoint + LudoTheGame.board.dice_num].listOfPieces.get(0).color !=activePieces.get(i).color)
                {
                    score += 3;
                }
            
                //get into range to beat the opponent pawn
                if(LudoTheGame.board.fields[activePieces.get(i).boardpoint].isStop==false)
                {
                    for(int j=0; j<7; ++j)
                    {
                        if(activePieces.get(i).boardpoint + LudoTheGame.board.dice_num + j<44 && LudoTheGame.board.fields[activePieces.get(i).boardpoint + LudoTheGame.board.dice_num+ j].listOfPieces.size()!=0)
                        {
                            score += 2;
                        }
                    }
                }
                
                //get out of beating range
                for(int k=0; k<10; ++k)
                {
                    if(activePieces.get(i).boardpoint + LudoTheGame.board.dice_num + k<44 && LudoTheGame.board.fields[activePieces.get(i).boardpoint + LudoTheGame.board.dice_num+ k].listOfPieces.size()!=0)
                    {
                        break;
                    }
                    score--;
                }
                
                //get onto another beginning field
                if(activePieces.get(i).boardpoint + LudoTheGame.board.dice_num <44 && activePieces.get(i).boardpoint + LudoTheGame.board.dice_num %10 == 0) {
                        score-=2;
                }
            
                if(activePieces.get(i).score==0)
                {
                    score-=3;
                }
                
            
                //get to target field
                if(activePieces.get(i).boardpoint + LudoTheGame.board.dice_num <44 && activePieces.get(i).boardpoint + LudoTheGame.board.dice_num >36) {
                        score+=3;
                }
                
        }
        return score;
    }

    public void print()
    {
        for(int i=0; i<40; i++)
        {
            System.out.println("Chromosone " + (i+1));
            this.population[i].print();
            
        }
        
    
    }

    public Chromosone getBestChromosone()
    {
	double bestScore = -1;
	int bestIndex=0;
                
        for (int i = 0; i < population_size; i++)
        {
            if(calculateFitness(population[i]) > bestScore)
            {
		bestScore = calculateFitness(population[i]);
                bestIndex=i;
            }
        }
        return population[bestIndex];
    }
    
    public void mutate(int [] chromosone)
    {
        Random rand=new Random();
        int random=rand.nextInt((1 - 1) + 1) + 0;
	
        
        
        
        // Nope, didn't happen 
	if(random == 0)
	{
		return;
	}
	

        
	int random_1 = rand.nextInt((1 - 1) + 1) + 0;
	int random_2 = rand.nextInt((1 - 1) + 1) + 0;
	
	while(random_1 == random_2)
	{
            random_2 = rand.nextInt((3 - 1) + 1) + 0;
	
	}

	int tmp = chromosone[random_1];
	chromosone[random_1] = chromosone[random_2];
	chromosone[random_2] = tmp;
    }
    
    
    public void crossover(Chromosone individual1, Chromosone individual2) {

        Random rand=new Random();
                
                int random_1 = rand.nextInt((1 - 1) + 1) + 0;
                int random_2 = rand.nextInt((1 - 1) + 1) + 0;
        
		int crossoverPoint1 = rand.nextInt((activePieces.size()-1 - 1) + 1) + 0;
		while(crossoverPoint1 > (3)) {
			crossoverPoint1 = rand.nextInt((activePieces.size()-1 - 1) + 1) + 0;
		}

		int crossoverPoint2 = crossoverPoint1;
		while(crossoverPoint2 < crossoverPoint1) {
			crossoverPoint2 = rand.nextInt((activePieces.size()-1 - 1) + 1) + 0;;
		}

		for (int i = 0; i < 4; i++) {
			if(i >= crossoverPoint1 && i <= crossoverPoint2) {
				int tmp = individual1.chromosone[i];
                                individual1.chromosone[i] = individual2.chromosone[random_2];
                                individual2.chromosone[i] = tmp;
			}
		}
	}
    
    
    
    public int getPieceToMove()
    {
        Chromosone c=getBestChromosone();
        int piece_number=0;
        for (int k=0; k<4; ++k)
        {
            if(c.chromosone[k] != 0  )
            {
                piece_number = c.chromosone[k];
            }
        }
        return piece_number;
    }
}
