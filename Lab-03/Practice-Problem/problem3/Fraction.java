
public class Fraction {
    private int num;
    private int den;

    public Fraction(int num, int den) {

        int g = gcd(num, den);
        this.num = num/g;
        this.den = den/g;
    }

    private int gcd(int a, int b){
        while(b!=0){
            int frac = b;
            b = a%b;
            a = frac;
        }
        return a;
    }

    public String toString(){
        return num + "/"+ den;
    }

    public boolean equals(Object obj)

    
}
