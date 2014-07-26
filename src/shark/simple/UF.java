package shark.simple;

/**
 * Created by shark
 * 26.07.2014
 */
public class UF {
    private final int[] array;
    private int count;

    /**
     * constructor, generates N sites with int names (0..N-1)
     *
     * @param N - number of sites
     */
    public UF(int N) {
        array = new int[N];
        count = N;
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    /**
     * add connection between sites p and q
     *
     * @param p site to connect
     * @param q site to connect
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        array[rootP] = rootQ;
        count--;
    }

    /**
     * component identifier for site (0..N-1)
     *
     * @param p site
     * @return component number (root)
     */
    public int find(int p) {
        while (array[p] != p) {
            p = array[p];
        }
        return p;
    }

    /**
     * are p and q in same component?
     *
     * @param p site to check
     * @param q site to check
     * @return true if p and q in same component, false otherwise
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * @return number of components
     */
    public int count() {
        return count;

    }
}
