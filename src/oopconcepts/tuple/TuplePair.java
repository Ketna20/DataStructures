package oopconcepts.tuple;
/*
 * ketnakhalasi created on 7/20/21
 * */

public class TuplePair<L, R> {
    final L left;
    final R right;


    public TuplePair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    static <L, R> TuplePair<L, R> of(L left, R right) {
        return new TuplePair<>(left, right);
    }

    @Override
    public int hashCode() {
        return left.hashCode() ^ right.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof TuplePair)) {
            return false;
        }

        TuplePair tuplePair = (TuplePair) obj;
        return this.left.equals(tuplePair.left) &&
                this.right.equals(tuplePair.right);

    }
}
