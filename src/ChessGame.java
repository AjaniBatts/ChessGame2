import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
public class ChessGame {
    public static LinkedList<Pieces> ps=new LinkedList<>();
    public static Pieces selectedPieces=null;
    public static void main(String[] args) throws IOException {
        Toolkit tk= Toolkit.getDefaultToolkit();

        int WIDTH = tk.getScreenSize().width;
        int HEIGHT = tk.getScreenSize().height;

        //Brings in image
        BufferedImage all=ImageIO.read(new File("C:\\Users\\Ajani\\Downloads\\chess.png"));
        Image imgs[]=new Image[12];
        int ind=0;
        //cuts the pieces on the image
        for(int y=0;y<400;y+=200){
            for(int x=0;x<1200;x+=200){
                imgs[ind]=all.getSubimage(x, y, 200, 200).getScaledInstance(90, 90, BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }
        Pieces brook=new Pieces(0, 0, false, "rook", ps);
        Pieces bkinght=new Pieces(1, 0, false, "knight", ps);
        Pieces bbishop=new Pieces(2, 0, false, "bishop", ps);
        Pieces bqueen=new Pieces(3, 0, false, "queen", ps);
        Pieces bking=new Pieces(4, 0, false, "king", ps);
        Pieces bbishop2=new Pieces(5, 0, false, "bishop", ps);
        Pieces bkight2=new Pieces(6, 0, false, "knight", ps);
        Pieces brook2=new Pieces(7, 0, false, "rook", ps);
        Pieces bpawn1=new Pieces(1, 1, false, "pawn", ps);
        Pieces bpawn2=new Pieces(2, 1, false, "pawn", ps);
        Pieces bpawn3=new Pieces(3, 1, false, "pawn", ps);
        Pieces bpawn4=new Pieces(4, 1, false, "pawn", ps);
        Pieces bpawn5=new Pieces(5, 1, false, "pawn", ps);
        Pieces bpawn6=new Pieces(6, 1, false, "pawn", ps);
        Pieces bpawn7=new Pieces(7, 1, false, "pawn", ps);
        Pieces bpawn8=new Pieces(0, 1, false, "pawn", ps);

        Pieces wrook=new Pieces(0, 7, true, "rook", ps);
        Pieces wkinght=new Pieces(1, 7, true, "knight", ps);
        Pieces wbishop=new Pieces(2, 7, true, "bishop", ps);
        Pieces wqueen=new Pieces(3, 7, true, "queen", ps);
        Pieces wking=new Pieces(4, 7, true, "king", ps);
        Pieces wbishop2=new Pieces(5, 7, true, "bishop", ps);
        Pieces wkight2=new Pieces(6, 7, true, "knight", ps);
        Pieces wrook2=new Pieces(7, 7, true, "rook", ps);
        Pieces wpawn1=new Pieces(1, 6, true, "pawn", ps);
        Pieces wpawn2=new Pieces(2, 6, true, "pawn", ps);
        Pieces wpawn3=new Pieces(3, 6, true, "pawn", ps);
        Pieces wpawn4=new Pieces(4, 6, true, "pawn", ps);
        Pieces wpawn5=new Pieces(5, 6, true, "pawn", ps);
        Pieces wpawn6=new Pieces(6, 6, true, "pawn", ps);
        Pieces wpawn7=new Pieces(7, 6, true, "pawn", ps);
        Pieces wpawn8=new Pieces(0, 6, true, "pawn", ps);

        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        frame.setUndecorated(true);
        JPanel pn=new JPanel(){
            @Override
            public void paint(Graphics g) {
                boolean white=true;
                for(int y= 0;y<8;y++){
                    for(int x= 0;x<8;x++){
                        if(white){
                            g.setColor(new Color(235,235, 208));
                        }else{
                            g.setColor(new Color(119, 148, 85));

                        }
                        g.fillRect(x*160, y*90, 160, 90);
                        white=!white;
                    }
                    white=!white;
                }
                for(Pieces p: ps){
                    int value=0;
                    if(p.name.equalsIgnoreCase("king")){
                        value=0;
                    }
                    if(p.name.equalsIgnoreCase("queen")){
                        value=1;
                    }
                    if(p.name.equalsIgnoreCase("bishop")){
                        value=2;
                    }
                    if(p.name.equalsIgnoreCase("knight")){
                        value=3;
                    }
                    if(p.name.equalsIgnoreCase("rook")){
                        value=4;
                    }
                    if(p.name.equalsIgnoreCase("pawn")){
                        value=5;
                    }
                    if(!p.isWhite){
                        value+=6;
                    }
                    g.drawImage(imgs[value], p.x, p.y, this);
                }
            }

        };
        frame.add(pn);
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedPieces!=null){
                    selectedPieces.x=e.getX()-45;
                    selectedPieces.y=e.getY()-45;
                    frame.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
               // System.out.println((getPieces(e.getX(),e.getY()).isWhite?"white ":"black ")+ getPieces(e.getX(),e.getY()).name);
                selectedPieces= getPieces(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedPieces.move(e.getX()/170,e.getY()/90);
                frame.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
    public static Pieces getPieces(int x,int y){
        int xp=x/170;
        int yp=y/90;
        for(Pieces p: ps){
            if(p.xp==xp&&p.yp==yp){
                return p;
            }
        }
        return null;
    }
}


