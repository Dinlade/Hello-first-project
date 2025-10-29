package dm.triangles.sss;

public record trianglePandS(int aSide, int bSide, int cSide) {

    public static void main(String[] args) {
    }
    public int perimetr() {
        return  this.aSide + this.bSide + this.cSide;
    }

    public int area () {
        int p = (aSide + bSide + cSide) / 2;
        return (int) Math.sqrt(p * (p - aSide) * (p - bSide) * (p - cSide));
    }
}
