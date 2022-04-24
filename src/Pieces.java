import java.util.LinkedList;
public class Pieces {
    int xp;
    int yp;
    int x;
    int y;
    boolean isWhite;
    LinkedList<Pieces> ps;
    String name;
    public Pieces(int xp, int yp, boolean isWhite,String n, LinkedList<Pieces> ps) {
        this.xp = xp;
        this.yp = yp;
        x=xp*170;
        y=yp*90;
        this.isWhite = isWhite;
        this.ps=ps;
        name=n;
        ps.add(this);
    }

    public void move(int xp,int yp){
        if(ChessGame.getPieces(xp *170,yp *90)!=null) {
            if(ChessGame.getPieces(xp *170,yp *90).isWhite!=isWhite){
                ChessGame.getPieces(xp * 170, yp * 90).kill();
            }else{
                x=this.xp*170;
                y=this.yp*90;
                return;
            }

        }
        this.xp=xp;
        this.yp=yp;
        x=xp*170;
        y=yp*90;
    }
    public void kill(){
        ps.remove(this);
    }
}
