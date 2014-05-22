package thegameludu;

public class Piece 
{
	public String color;
	public int x;
	public int y;
        public int boardpoint;
	public boolean activated;
	public boolean atFinalHome;
        public boolean isAtFinalPath;
	public int finalhomeStartAt;
	public boolean isComputerPlayer;
        public int pieceNumber;
        public int startAt;
        public int score;
	
	public Piece(int x,int y,int BoardPoint, int PieceNumber, String color)
	{
                isAtFinalPath=false;
                score=0;
                isComputerPlayer=true;
                
		
		if(color.equals("RED"))
		{
			finalhomeStartAt=83;
                        startAt=39;
		}
		else if(color.equals("GREEN"))
		{
			finalhomeStartAt=56;
                        isComputerPlayer=false;
                        startAt=0;
		}
		else if(color.equals("BLUE"))
		{
			finalhomeStartAt=74;
                        startAt=26;
		}
		else if(color.equals("YELLOW"))
		{
			finalhomeStartAt=65;
                        startAt=13;
		}
                boardpoint=BoardPoint;
                pieceNumber=PieceNumber;
                
                
		this.activated=false;
		this.x=x;
		this.y=y;
		this.color=color;
		this.atFinalHome=false;
	}
	
}
