package dm.triangles.sss;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrianglePandS triangle = (TrianglePandS) o;
        return Double.compare(triangle.aSide, this.aSide) == 0 && Double.compare(triangle.bSide, this.bSide) == 0 && Double.compare(triangle.cSide, this.cSide) == 0
                || Double.compare(triangle.aSide, this.bSide) == 0 && Double.compare(triangle.bSide, this.aSide) == 0 && Double.compare(triangle.cSide, this.cSide) == 0
                || Double.compare(triangle.aSide, this.cSide) == 0 && Double.compare(triangle.bSide, this.bSide) == 0 && Double.compare(triangle.cSide, this.aSide) == 0
                || Double.compare(triangle.aSide, this.cSide) == 0 && Double.compare(triangle.bSide, this.aSide) == 0 && Double.compare(triangle.cSide, this.bSide) == 0
                || Double.compare(triangle.aSide, this.bSide) == 0 && Double.compare(triangle.bSide, this.cSide) == 0 && Double.compare(triangle.cSide, this.aSide) == 0
                || Double.compare(triangle.aSide, this.aSide) == 0 && Double.compare(triangle.bSide, this.cSide) == 0 && Double.compare(triangle.cSide, this.bSide) == 0;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
