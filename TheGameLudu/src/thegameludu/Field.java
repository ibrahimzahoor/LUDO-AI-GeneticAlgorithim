package thegameludu;
import java.util.ArrayList;


public class Field 
{
        int x;
	int y;
	boolean isStop;
	boolean isHome;
	boolean isFinalBox;
	boolean isHomePath;
	ArrayList<Piece> listOfPieces;
	
	
	public Field(int x,int y)
	{
            isFinalBox=false;
            isHome=false;
            isHomePath=false;
            isStop=false;
            listOfPieces=new ArrayList<Piece>();
	}
	
	
	
}
