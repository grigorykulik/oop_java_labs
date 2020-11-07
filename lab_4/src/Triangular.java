public class Triangular {
    private Point a, b, c;
    public double sideA;
    public double sideB;
    public double sideC;


    public Triangular() {};

    public Triangular(Point a, Point b, Point c) throws ImpossibleTriangularException {
        this.a = a;
        this.b = b;
        this.c = c;
        sideA=getSide(a, b);
        sideB=getSide(b, c);
        sideC=getSide(a, c);

        if (sideA+sideB<=sideC ||
                sideB+sideC<=sideA ||
                sideC+sideA<=sideB) throw new ImpossibleTriangularException();
    }

    public double getSide(Point one, Point two) {
        double diffX=Math.pow(one.getX()-two.getX(), 2);
        double diffY=Math.pow(one.getY()-two.getY(), 2);
        double side=Math.sqrt(diffX+diffY);

        return side;
    }

    public double getPerimeter() {
        double perimeter=sideA+sideB+sideC;

        return perimeter;
    }

    public double getArea() {

        double hp=this.getPerimeter()/2;
        double area=Math.sqrt(hp*(hp-sideA)*(hp-sideB)*(hp-sideC));

        return area;
    }

    public Point getMIP () {
        Point MIP=new Point();

        double MIPx=(this.a.getX()+this.b.getX()+this.c.getX())/3.0;
        MIP.setX(MIPx);

        double MIPy=(this.a.getY()+this.b.getY()+this.c.getY())/3.0;
        MIP.setY(MIPy);

        return MIP;
    }
}

