/**
 ----------------------------------
 | Program created by Tushar Sharma.|
 | CS27500 Homework 4               |
 | Email: sharm191@pnw.edu          |
 | File Info: Pair Class            |
 ----------------------------------
 */
public class Pair<T1,T2> {
    private T1 first;
    private T2 second;
    public Pair() {
        this.first = null;
        this.second = null;
    }
    public Pair(T1 fParam, T2 sParam) {
        this.first = fParam;
        this.second = sParam;
    }
    public Pair(Pair<T1,T2> p) {
        this.first = p.getFirst();
        this.second = p.getSecond();
    }
    public T1 getFirst() {
        return this.first;
    }
    public T2 getSecond() {
        return this.second;
    }
    public Pair<T1, T2> setFirst(T1 fParam) {
        this.first = fParam;
        return this;
    }
    public Pair<T1, T2> setSecond(T2 sParam) {
        this.second = sParam;
        return this;
    }
    public Pair<T2,T1> transpose()
    {
        Pair<T2,T1> p = new Pair<>();
        p.setFirst(second);
        p.setSecond(first);
        return p;
    }
    public <T> Pair<T,T2> replaceFirst(T o) {
        Pair<T, T2> p = new Pair<>(o, second);
        return p;
    }
    public <T> Pair<T1,T> replaceSecond(T o) {
        Pair<T1, T> p = new Pair<>(first, o);
        return p;
    }
    @Override
    public boolean equals(Object that) {
        if (that != null && that instanceof Pair) {
            if (first.equals(((Pair) that).getFirst()) && second.equals(((Pair) that).getSecond()))
                return true;
        }
        return false;
    }
    public String toString() {
        return ("[" + this.first + "," + this.second + "]");
    }
}