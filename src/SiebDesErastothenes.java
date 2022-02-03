import java.util.List;

public class SiebDesErastothenes {

    /** Erzeugt eine Array von Primzahlen bis zur Zahl n
     * @param n
     * @return
     */
    public void calcPrimes(int n){
        //Der Wert an dem Index i entspricht der Zahl
        boolean[] marked = new boolean[n+1];
        for (int i = 2; i * i < marked.length ; i++) {
            if (!marked[i]){
                for (int j = i*i; j < marked.length ; j+=i) {
                    marked[j] = true;
                }
            }
        }
        for (int i = 2; i <marked.length ; i++) {
            if (!marked[i]) System.out.print(i+", ");
        }
    }

    public static void main(String[] args) {
        SiebDesErastothenes a = new SiebDesErastothenes();
        a.calcPrimes(541);
    }
}
