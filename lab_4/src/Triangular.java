public class Triangular {
    private Point a, b, c;

    public Triangular() {};

    public Triangular(Point a, Point b, Point c) throws ImpossibleTriangularException {
        this.a = a;
        this.b = b;
        this.c = c;

        if (getSide(a, b)+getSide(b, c)<getSide(a, c) ||
        getSide(b, c)+getSide(a, c)<getSide(a, b) ||
        getSide(a, c)+getSide(a, b)<getSide(b, c)) throw new ImpossibleTriangularException();
    }

    public double getSide(Point one, Point two) {
        double diffX=Math.pow(one.getX()-two.getX(), 2);
        double diffY=Math.pow(one.getY()-two.getY(), 2);
        double side=Math.sqrt(diffX+diffY);

        return side;
    }

    public double getPerimeter() {
        double perimeter=getSide(this.a, this.b)+
                getSide(this.b, this.c)+
                getSide(this.c, this.a);

        return perimeter;
    }

    public double getArea() {
        double hp=this.getPerimeter()/2;
        double area=Math.sqrt(hp*(hp-this.getSide(this.a, this.b)*
                (hp-this.getSide(this.b, this.c)*
                        (hp-this.getSide(this.c, this.a)))));

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

