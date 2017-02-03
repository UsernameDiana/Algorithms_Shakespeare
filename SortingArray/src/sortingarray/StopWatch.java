package sortingarray;

/**
 *
 * @author jb
 */
public class StopWatch {

    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public double endTime() {
        long endNow = System.currentTimeMillis();
        return (endNow - start) / 1000.0;
    }
}
