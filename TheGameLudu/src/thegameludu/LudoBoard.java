package thegameludu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class LudoBoard extends JFrame implements MouseListener,KeyListener
{
    Field[] fields;
    GeneticAlgorithim GA;
    public int turn;
    public int dice_num;
                
    public Piece[] yellow_pieces = new Piece[4];
    public Piece[] red_pieces = new Piece[4];
    public Piece[] blue_pieces = new Piece[4];
    public Piece[] green_pieces = new Piece[4];
    
        //Objects for images
    private BufferedImage background;
    private BufferedImage bird;
    
    
    private BufferedImage green_dice;
    private BufferedImage yellow_dice;
    private BufferedImage blue_dice;
    private BufferedImage red_dice;
    
    private BufferedImage dice1;
    private BufferedImage dice2;
    private BufferedImage dice3;
    private BufferedImage dice4;
    private BufferedImage dice5;
    private BufferedImage dice6;
    
    
    //First coordinates of bird image
    private int cordX = 50;
    private int cordY = 250;
    //Objects for doble buffer
    private BufferStrategy myBuffer;
    public boolean diceRolled;
    
    
	public LudoBoard()
	{
            
            turn=0;
            setTitle("Doble Buffer Image Sample");
            //set window dimension 480x320px
            setSize(700, 720);
            //load images...
            loadImages();
            //make window visible
            setVisible(true);
            //Ignore OS paint calls
            setIgnoreRepaint(true);

            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            //create a doble buffer objects
            //NOTE: It's very important to create bufferStrategy after
            //JFrame is visible, in other case fail!
            this.createBufferStrategy(2);
            myBuffer = this.getBufferStrategy();
            //call explicit to paint first time
            repaint();
        
        
               fields=new Field[89];
		
               for(int i=0;i<89;i++)
		{
                    fields[i]=new Field(0,0);
                    fields[i].isFinalBox=false;
                    fields[i].isHome=false;
                    fields[i].isHomePath=false;
                    fields[i].isStop=false;                    
		}
               
               
               //left row 1 
                fields[25].x=28;
                fields[25].y=305; 
		fields[26].x=72;
                fields[26].y=305; 
		fields[27].x=116;
                fields[27].y=305; 
		fields[28].x=160;
                fields[28].y=305; 
		fields[29].x=203;
                fields[29].y=305; 
		fields[30].x=247;
                fields[30].y=305;
                
                //left row2
		fields[78].x=248;
                fields[78].y=348; 
		fields[77].x=203;
                fields[77].y=348; 
		fields[76].x=159;
                fields[76].y=348; 
		fields[75].x=116;
                fields[75].y=348; 
		fields[74].x=72;
                fields[74].y=348; 
		fields[24].x=28;
                fields[24].y=348;
                
                //left row3
		fields[23].x=28;
                fields[23].y=393; 
		fields[22].x=72;
                fields[22].y=393; 
		fields[21].x=115;
                fields[21].y=393; 
		fields[20].x=160;
                fields[20].y=393; 
		fields[19].x=204;
                fields[19].y=393; 
		fields[18].x=247;
                fields[18].y=393;


//               //right row 1 
                fields[44].x=423;
                fields[44].y=305; 
		fields[45].x=467;
                fields[45].y=305; 
		fields[46].x=511;
                fields[46].y=305; 
		fields[47].x=554;
                fields[47].y=305; 
		fields[48].x=598;
                fields[48].y=305; 
		fields[49].x=642;
                fields[49].y=305;

//                //right row2
		fields[50].x=642;
                fields[50].y=348; 
		fields[56].x=598;
                fields[56].y=348; 
		fields[57].x=554;
                fields[57].y=348; 
		fields[58].x=511;
                fields[58].y=348; 
		fields[59].x=467;
                fields[59].y=348; 
		fields[60].x=423;
                fields[60].y=348;

//                //right row3
		fields[51].x=642;
                fields[51].y=392; 
		fields[0].x=598;
                fields[0].y=392; 
		fields[1].x=554;
                fields[1].y=392; 
		fields[2].x=511;
                fields[2].y=392; 
		fields[3].x=467;
                fields[3].y=392; 
		fields[4].x=423;
                fields[4].y=392;
                 
                
                


//                //up row3
		fields[43].x=379;
                fields[43].y=260; 
		fields[42].x=379;
                fields[42].y=217; 
		fields[41].x=379;
                fields[41].y=174; 
		fields[40].x=379;
                fields[40].y=131; 
		fields[39].x=379;
                fields[39].y=87; 
		fields[38].x=379;
                fields[38].y=44;

                
                
                
                
                fields[87].x=335;
                fields[87].y=260; 
		fields[86].x=335;
                fields[86].y=218; 
		fields[85].x=335;
                fields[85].y=174; 
		fields[84].x=335;
                fields[84].y=131; 
		fields[83].x=335;
                fields[83].y=87; 
		fields[37].x=335;
                fields[37].y=44;
                
                fields[31].x=292;
                fields[31].y=260; 
		fields[32].x=292;
                fields[32].y=218; 
		fields[33].x=292;
                fields[33].y=174; 
		fields[34].x=292;
                fields[34].y=131; 
		fields[35].x=292;
                fields[35].y=87; 
		fields[36].x=292;
                fields[36].y=44;
                
                //up row3
		fields[5].x=379;
                fields[5].y=437; 
		fields[6].x=379;
                fields[6].y=480; 
		fields[7].x=379;
                fields[7].y=523; 
		fields[8].x=379;
                fields[8].y=567; 
		fields[9].x=379;
                fields[9].y=610; 
		fields[10].x=379;
                fields[10].y=656;
                
                
                fields[11].x=335;
                fields[11].y=657; 
		fields[65].x=335;
                fields[65].y=613; 
		fields[66].x=335;
                fields[66].y=570; 
		fields[67].x=335;
                fields[67].y=525; 
		fields[68].x=335;
                fields[68].y=482; 
		fields[69].x=335;
                fields[69].y=435;
                
                fields[12].x=292;
                fields[12].y=655; 
		fields[13].x=292;
                fields[13].y=613; 
		fields[14].x=292;
                fields[14].y=569; 
		fields[15].x=292;
                fields[15].y=526; 
		fields[16].x=292;
                fields[16].y=482; 
		fields[17].x=292;
                fields[17].y=435;
                
                
                
		fields[0].isStop=true;
		fields[47].isStop=true;
		fields[8].isStop=true;
		fields[13].isStop=true;
		fields[21].isStop=true;
		fields[26].isStop=true;
		fields[34].isStop=true;
		fields[38].isStop=true;
		
		
		fields[56].isHomePath=true;
		fields[57].isHomePath=true;
		fields[58].isHomePath=true;
		fields[59].isHomePath=true;
		fields[60].isHomePath=true;
		fields[65].isHomePath=true;
		fields[66].isHomePath=true;
		fields[67].isHomePath=true;
		fields[68].isHomePath=true;
		fields[69].isHomePath=true;
		fields[74].isHomePath=true;
		fields[75].isHomePath=true;
		fields[76].isHomePath=true;
		fields[77].isHomePath=true;
		fields[78].isHomePath=true;
		fields[83].isHomePath=true;
		fields[84].isHomePath=true;
		fields[85].isHomePath=true;
		fields[86].isHomePath=true;
		fields[87].isHomePath=true;

                
		
		fields[88].isFinalBox=true;
		
                fields[52].isHome=true;
		fields[53].isHome=true;
		fields[54].isHome=true;
		fields[55].isHome=true;
		
		fields[79].isHome=true;
		fields[80].isHome=true;
		fields[81].isHome=true;
		fields[82].isHome=true;
		
		fields[70].isHome=true;
		fields[71].isHome=true;
		fields[72].isHome=true;
		fields[73].isHome=true;
		
		fields[61].isHome=true;
		fields[62].isHome=true;
		fields[63].isHome=true;
		fields[64].isHome=true;
		
                
                blue_pieces[0]= new Piece(94,150,52,0,"BLUE");
                blue_pieces[1]= new Piece(181,150,53,1,"BLUE");
                blue_pieces[2] = new Piece(138,193,54,2,"BLUE");
                blue_pieces[3] = new Piece(138,107,55,3,"BLUE");
                
                fields[52].listOfPieces.add(blue_pieces[0]);
		fields[52].x=94;
                fields[52].y=150;
                fields[53].listOfPieces.add(blue_pieces[1]);
		fields[53].x=181;
                fields[53].y=150;
                fields[54].listOfPieces.add(blue_pieces[2]);
		fields[54].x=138;
                fields[54].y=193;
                fields[55].listOfPieces.add(blue_pieces[3]);
		fields[55].x=138;
                fields[55].y=107;
                
                
                red_pieces[0] = new Piece(489,150,79,0,"RED");
                red_pieces[1] = new Piece(577,150,80,1,"RED");
                red_pieces[2] = new Piece(532,195,81,2,"RED");
                red_pieces[3] = new Piece(532,108,82,3,"RED");
                
		fields[79].listOfPieces.add(red_pieces[0]);
		fields[79].x=489;
                fields[79].y=150;
                fields[80].listOfPieces.add(red_pieces[1]);
		fields[80].x=577;
                fields[80].y=150;
                fields[81].listOfPieces.add(red_pieces[2]);
		fields[81].x=532;
                fields[81].y=195;
                fields[82].listOfPieces.add(red_pieces[3]);
		fields[82].x=532;
                fields[82].y=108;
                
                green_pieces[0] = new Piece(532,502,70,0,"GREEN");
                green_pieces[1] = new Piece(532,589,71,1,"GREEN");
                green_pieces[2] = new Piece(489,544,72,2,"GREEN");
                green_pieces[3] = new Piece(576,544,73,3,"GREEN");
                
		fields[70].listOfPieces.add(green_pieces[0]);
                fields[70].x=532;
                fields[70].y=502;
                
		fields[71].listOfPieces.add(green_pieces[1]);
		fields[71].x=532;
                fields[71].y=589;
                
                fields[72].listOfPieces.add(green_pieces[2]);
		fields[72].x=489;
                fields[72].y=544;
                
                fields[73].listOfPieces.add(green_pieces[3]);
		fields[73].x=576;
                fields[73].y=544;
                
                
                
                yellow_pieces[0] = new Piece(94,545,61,0,"YELLOW");
                yellow_pieces[1] = new Piece(181,545,62,1,"YELLOW");
                yellow_pieces[2] = new Piece(138,588,63,2,"YELLOW");
                yellow_pieces[3] = new Piece(138,501,64,3,"YELLOW");
                
		fields[61].listOfPieces.add(yellow_pieces[0]);
                fields[61].x=94;
                fields[61].y=545;
		fields[62].listOfPieces.add(yellow_pieces[1]);
		fields[62].x=181;
                fields[62].y=545;
                fields[63].listOfPieces.add(yellow_pieces[2]);
		fields[63].x=138;
                fields[63].y=588;
                
                fields[64].listOfPieces.add(yellow_pieces[3]);
                fields[64].x=138;
                fields[64].y=501;
              
        }
    
        
    public void loadImages()
    {
        try
        {
            //path for image file
            background = ImageIO.read(new File("LudoBoard.png"));
            
            String pathBird = "blue.png";
            bird = ImageIO.read(new File(pathBird));
            
            green_dice=ImageIO.read(new File("green.png"));
            yellow_dice=ImageIO.read(new File("yellow.png"));
            blue_dice=ImageIO.read(new File("blue.png"));
            red_dice=ImageIO.read(new File("red.png"));
            
            dice1=ImageIO.read(new File("1.png"));
            dice2=ImageIO.read(new File("2.png"));
            dice3=ImageIO.read(new File("3.png"));
            dice4=ImageIO.read(new File("4.png"));
            dice5=ImageIO.read(new File("5.png"));
            dice6=ImageIO.read(new File("6.png"));
         
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        //asociate the keyboard listener with this JFrame
        addKeyListener(this);
        addMouseListener(this);
    }
 
    public void drawImages(Graphics2D g) {
        //draw brackground image (first image)
        g.drawImage(background, 5, 25, this);
        //draw bird image (second image, in this order)
        g.drawImage(bird, cordX, cordY, this);
          
        int x=274,y=292;
        if(this.dice_num==1)
            g.drawImage(dice1, x,y, this);
        else if(this.dice_num==2)
            g.drawImage(dice2, x,y, this);
        else if(this.dice_num==3)
            g.drawImage(dice3, x,y, this);
        else if(this.dice_num==4)
            g.drawImage(dice4, x,y, this);
        else if(this.dice_num==5)
            g.drawImage(dice5, x,y, this);
        else if(this.dice_num==6)
            g.drawImage(dice6, x,y, this);
        
        
        for(int i=0; i<this.fields.length; ++i)
        {
            int z=0;
            for(int k=0; k<this.fields[i].listOfPieces.size(); k++)
            //if(this.fields[i].listOfPieces.size()>0)
            {
                if(this.fields[i].listOfPieces.get(k).color.equals("RED"))
                {
                    g.drawImage(red_dice, this.fields[i].listOfPieces.get(k).x + z, this.fields[i].listOfPieces.get(k).y + z, this);
                }
                else if(this.fields[i].listOfPieces.get(k).color.equals("GREEN"))
                {
                    g.drawImage(green_dice, this.fields[i].listOfPieces.get(k).x + z, this.fields[i].listOfPieces.get(k).y + z, this);
                }
                else if(this.fields[i].listOfPieces.get(k).color.equals("BLUE"))
                {
                    g.drawImage(blue_dice, this.fields[i].listOfPieces.get(k).x + z, this.fields[i].listOfPieces.get(k).y+ z, this);
                }
                else if(this.fields[i].listOfPieces.get(k).color.equals("YELLOW"))
                {
                    g.drawImage(yellow_dice, this.fields[i].listOfPieces.get(k).x + z, this.fields[i].listOfPieces.get(k).y+z, this);
                }
                z=z+7;
            }
        } 
    }
 
    public void paint(Graphics g) 
    {
        Graphics2D g2 = null;
        if (myBuffer != null) 
        {
            try 
            {
                //get the graphics2d object of the buffer
                g2 = (Graphics2D) myBuffer.getDrawGraphics();
                //draw images in buffer
                drawImages(g2);
            } 
            finally 
            {
                g2.dispose();
            }
            //draw the content of buffer in the screen
            myBuffer.show();
        }
    }
 
   
 
    //While a key is pressed
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            //if the right arrow in keyboard is pressed...
            case KeyEvent.VK_SPACE: 
            {
                turn();
            }
            break;
 
            case KeyEvent.VK_RIGHT: 
            {
                cordX ++;
                    System.out.println("X="+cordX + " & " + "Y="+ cordY );
            
            }
            break;
            //if the left arrow in keyboard is pressed...
            case KeyEvent.VK_LEFT: 
            {
                cordX --;
                System.out.println("X="+cordX + " & " + "Y="+ cordY );
            }
            break;
 
            //if the down arrow in keyboard is pressed...
            case KeyEvent.VK_DOWN: 
            {
                cordY ++;
                    System.out.println("X="+cordX + " & " + "Y="+ cordY );
            
            }
            break;
 
            //if the up arrow in keyboard is pressed...
            case KeyEvent.VK_UP: 
            {
                cordY --;
                System.out.println("X="+cordX + " & " + "Y="+ cordY );
            
            }
            break;
 
        } 
        //call explicit to paint
        repaint();
    }
 
    //When a key is typed (once)
    public void keyTyped(KeyEvent ke) 
    {
        
    }
 
    //When a key is released (typed or pressed)
    public void keyReleased(KeyEvent ke) 
    {
        
    }
    
    
    public int selectPieceToMove()
    {
        //for now its random
        Random rand=new Random();
        return rand.nextInt((3 - 0) + 1) + 0;
        
    }
    
    
    public int selectPieceViaGA(String color)
    {
        ArrayList<Piece> listOfActivePieces=new ArrayList<Piece>();
        if(getPiece(0,color).activated)
        {
            listOfActivePieces.add(getPiece(0,color));
        }
        if(getPiece(1,color).activated)
        {
            listOfActivePieces.add(getPiece(1,color));
        }
        if(getPiece(1,color).activated)
        {
            listOfActivePieces.add(getPiece(1,color));
        }
        if(getPiece(1,color).activated)
        {
            listOfActivePieces.add(getPiece(1,color));
        }
        
        if(listOfActivePieces.size()>1)
        {
            GA=new GeneticAlgorithim(listOfActivePieces);
            GA.print();  
            return GA.getPieceToMove();
        }
        if(listOfActivePieces.size()>0)
            return listOfActivePieces.get(0).pieceNumber;
        else
            return 0;
    }
    
    Piece getPiece(int pieceNumber,String color)
    {
        
        if(color.equals("GREEN"))
        {
            System.out.println("Green's "+pieceNumber+" selected");
            return green_pieces[pieceNumber];
        }
        else if(color.equals("RED"))
        {
            System.out.println("RED's "+pieceNumber+" selected");
            return red_pieces[pieceNumber];
        }
        else if(color.equals("BLUE"))
        {
            System.out.println("BLUE's "+pieceNumber+" selected");
            return blue_pieces[pieceNumber];
        }
        else if(color.equals("YELLOW"))
        {
            System.out.println("YELLOW's "+pieceNumber+" selected");
            return yellow_pieces[pieceNumber];
        }
        
        return null;
        
    }
    
    
    
    public boolean movePiece(int pieceNumber,int number,String color)
    {
        if(number==6)
        {
            turn=(turn-1)%4; //for second dice rolling because of 6 of current player
        }
        
        if(number==6)
        {
            if(!this.getPiece(0, color).activated)
                {
                    Piece p=this.getPiece(0, color);
                    p.activated=true;
                    
                    p.x=fields[p.startAt].x;
                    p.y=fields[p.startAt].y;
                    
                    //System.out.println("Previous point : "+p.boardpoint );
                    
                    fields[p.startAt].listOfPieces.add(fields[p.boardpoint].listOfPieces.remove(0));
                    p.boardpoint=p.startAt;
                    
                    //System.out.println("New  point : "+p.boardpoint );
                
                
                    repaint();


                    return true;
                    
                }
                else if(!this.getPiece(1, color).activated)
                {
                    Piece p=this.getPiece(1, color);
                    p.activated=true;
                    
                    p.x=fields[p.startAt].x;
                    p.y=fields[p.startAt].y;
                    
                    //System.out.println("Previous point : "+p.boardpoint );
                    
                    fields[p.startAt].listOfPieces.add(fields[p.boardpoint].listOfPieces.remove(0));
                    p.boardpoint=p.startAt;
                    
                    //System.out.println("New  point : "+p.boardpoint );
                
                
                    repaint();


                    return true;
                }
                else if(!this.getPiece(2, color).activated)
                {
                    Piece p=this.getPiece(2, color);
                    p.activated=true;
                    
                    p.x=fields[p.startAt].x;
                    p.y=fields[p.startAt].y;
                    
                    //System.out.println("Previous point : "+p.boardpoint );
                    
                    fields[p.startAt].listOfPieces.add(fields[p.boardpoint].listOfPieces.remove(0));
                    p.boardpoint=p.startAt;
                    
                    //System.out.println("New  point : "+p.boardpoint );
                
                
                    repaint();


                    return true;
                }
                else if(!this.getPiece(3, color).activated)
                {
                    Piece p=this.getPiece(3, color);
                    p.activated=true;
                    
                    p.x=fields[p.startAt].x;
                    p.y=fields[p.startAt].y;
                    
                    //System.out.println("Previous point : "+p.boardpoint );
                    
                    fields[p.startAt].listOfPieces.add(fields[p.boardpoint].listOfPieces.remove(0));
                    p.boardpoint=p.startAt;
                    
                    //System.out.println("New  point : "+p.boardpoint );
                
                
                    repaint();


                    return true;
                }
        }
        
        if(!this.getPiece(0, color).activated&&!this.getPiece(1, color).activated &&
                !this.getPiece(2, color).activated &&
                !this.getPiece(3, color).activated &&
                number!=6)
        {
            System.out.println("+first out" );
            return true;
        }
        else
        {
            if(number!=6)
            {
                if( !( (this.getPiece(0, color).activated&&this.getPiece(0, color).score+number<=56) || 
                     (this.getPiece(1, color).activated&&this.getPiece(1, color).score+number<=56)|| 
                        (this.getPiece(2, color).activated&&this.getPiece(2, color).score+number<=56)|| 
                        (this.getPiece(3, color).activated&&this.getPiece(3, color).score+number<=56)) )
                {
                    return true;
                }
            }
            else
            {
                if(!this.getPiece(0, color).activated)
                {
                    this.getPiece(0, color).activated=true;
                }
                else if(!this.getPiece(1, color).activated)
                {
                    this.getPiece(1, color).activated=true;
                }
                else if(!this.getPiece(2, color).activated)
                {
                    this.getPiece(2, color).activated=true;
                }
                else if(!this.getPiece(3, color).activated)
                {
                    this.getPiece(3, color).activated=true;
                }
            }
        }
        
        
        
        
        
        Piece p= this.getPiece(pieceNumber, color);
        

        if(!(((!p.activated)&&number==6) ||  (p.activated&&(!p.atFinalHome)&&(p.score+number<=56)) || (p.activated && (p.score+number<=56) ) ) )
        {
            System.out.println("+second out" );
            return false;
        }
        
        System.out.println("Co-ordinates of selected piece : x="+p.x+", y="+p.y );
        
        System.out.println("Avtivation Details : "+p.activated );
        System.out.println("Color Details : "+p.color );
        System.out.println("piece# Details : "+p.pieceNumber );
        
        
        
        if(!p.activated)
        {
            if(number==6)
            {
                
                if(color.equals(p.color))
                {
                    p.activated=true;
                    
                    p.x=fields[p.startAt].x;
                    p.y=fields[p.startAt].y;
                    
                    //System.out.println("Previous point : "+p.boardpoint );
                    
                    fields[p.startAt].listOfPieces.add(fields[p.boardpoint].listOfPieces.remove(0));
                    p.boardpoint=p.startAt;
                    
                    //System.out.println("New  point : "+p.boardpoint );
                }
                
                repaint();
                
                
                return true;
            }
        }
        
        
        if(p.score<=50)
        {
            System.out.println("before score++ <=50 score : "+p.score );
            p.score+=number;
            if(p.score>=50)
            {
                System.out.println("after score++ >50  : "+ p.score );
                
                fields[p.score-50+p.finalhomeStartAt].listOfPieces.add(fields[p.boardpoint].listOfPieces.remove(0));
                
                p.boardpoint=p.score-50+p.finalhomeStartAt;
                
                
                p.x=fields[p.boardpoint].x;
                p.y=fields[p.boardpoint].y;
                
                p.isAtFinalPath=true;

                if(p.score==56)
                {
                    p.atFinalHome=true;

                }
                repaint();
                return true;
            }
            else
            {
                System.out.println("after score++ <50" );
                
                System.out.println("before p.boardpoint : "+ p.boardpoint );
                fields[(p.boardpoint+number)%52].listOfPieces.add(fields[p.boardpoint].listOfPieces.remove(0));
                
                p.boardpoint=(p.boardpoint+number)%52;
                p.x=fields[p.boardpoint].x;
                p.y=fields[p.boardpoint].y;
                System.out.println("after p.boardpoint : "+ p.boardpoint );
                
                if(p.score==56)
                {
                    p.atFinalHome=true;

                }
                
            }
        }
        else
        {

            if(p.score+number<=50)
            {
                System.out.println("before number<=50 score: "+p.score );
                p.score+=number;

                fields[(p.boardpoint+number)%52].listOfPieces.add(fields[p.boardpoint].listOfPieces.remove(0));

                p.boardpoint=(p.boardpoint+number)%52;
                p.x=fields[p.boardpoint].x;
                p.y=fields[p.boardpoint].y;
                repaint();
                return true;
            }
            else if(p.score+number>50)
            {
                
                System.out.println("before  score++ number>50, score : "+p.score );
                p.atFinalHome=true;

                
                        
                fields[p.score+number-50+p.finalhomeStartAt].listOfPieces.add(fields[p.boardpoint].listOfPieces.remove(0));
                
                p.boardpoint=p.score+number-50+p.finalhomeStartAt;
                
                
                p.x=fields[p.boardpoint].x;
                p.y=fields[p.boardpoint].y;
                p.score+=number;
                p.isAtFinalPath=true;
                repaint();
                return true;

            }
            else
            {
                return false;
            }
 
        }
        repaint();
        return true;
    }
    
    public boolean killOther(Piece p)
    {
        if(fields[p.boardpoint].listOfPieces.size()>1)
        {
            
        }
        return true;
    }
    
    public void turn()
    {
        System.out.println("Turn : "+turn );
        if(turn>3||turn<0)
        {
            turn =0;
        }
        if(turn==0)
        {
            // getting input manually from user
            int diceResult=this.rollDice();
            System.out.println("Dice Out Put :"+diceResult);
            System.out.println("Green's Turn");
            
            while(!movePiece(selectPieceToMove(),diceResult,"GREEN"))
            {
                
            }
            turn=(turn+1)%4;
        }
        else
        {
            if(turn==1)
            {
                
                // getting input manually from user
                int diceResult=this.rollDice();
                System.out.println("Dice Out Put :"+diceResult);
                System.out.println("RED's Turn");

                while(!movePiece(selectPieceViaGA("RED"),diceResult,"RED"))
                {
                    
                }
                turn=(turn+1)%4;
            }
            else if(turn==2)
            {
                // getting input manually from user
                int diceResult=this.rollDice();
                System.out.println("Dice Out Put :"+diceResult);
                System.out.println("BLUE's Turn");

                while(!movePiece(selectPieceViaGA("BLUE"),diceResult,"BLUE"))
                {
                    
                }
                turn=(turn+1)%4;
            }
            else if(turn==3)
            {
               // getting input manually from user
                int diceResult=this.rollDice();
                System.out.println("Dice Out Put :"+diceResult);
                System.out.println("YELLOW's Turn");

                while(!movePiece(selectPieceViaGA("YELLOW"),diceResult,"YELLOW"))
                {
                    
                }
                turn=(turn+1)%4;
            }
        }
        
        this.repaint();
    }
    
    public int rollDice()
    {
        Random rand=new Random();
        this.dice_num=rand.nextInt((6 - 1) + 1) + 1;
        this.diceRolled=true;
        return dice_num;
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if(diceRolled&&turn==0)
        {
            
            for(int i=0;i<4;i++)
            {
                if((green_pieces[i].x>e.getX() && e.getX()<green_pieces[i].x+40) &&
                        (green_pieces[i].y>e.getY() && e.getY()<green_pieces[i].y+40)) 
                {
                    System.out.println("Green clicked : "+ i );
                }
            }
        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        //throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
