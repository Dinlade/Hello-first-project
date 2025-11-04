package dm.triangles.sss;

public record TrianglePandS(int aSide, int bSide, int cSide) {

    public TrianglePandS {
        if (aSide + bSide < cSide || aSide + cSide < bSide || bSide + cSide < aSide) {
            throw new IllegalArgumentException("Сумма сторон должна быть больше третьей стороны");
        }
            if (aSide < 0 || bSide < 0 || cSide < 0) {
                throw new IllegalArgumentException("Сторона должна быть больше нуля");
            }
        }

        public static void main (String[]args){
        }
        public int perimetr () {
            return this.aSide + this.bSide + this.cSide;
        }

        public int area () {
            int p = (aSide + bSide + cSide) / 2;
            return (int) Math.sqrt(p * (p - aSide) * (p - bSide) * (p - cSide));
        }
    }
