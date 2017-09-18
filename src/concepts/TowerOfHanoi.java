package concepts;

/**
 * Created by Ajay on 9/17/17.
 * A -> C
 * Algo:
 *  Move n-1 disks from A to B using C
 *  Move remaining disk from A to C
 *  Move n-1 disk from B to C using A
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        new TowerOfHanoi().toh(3, 'A', 'C', 'B');
    }

    public void toh(int i, char a, char c, char b) {
        if (i>0) {
            toh(i - 1, a, b, c);
            System.out.println("Move " + a + " to " + c);
            toh(i - 1, b, c, a);
        }
    }
}
