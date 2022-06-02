public class MedianOfInts {
    public static void medianOfInts(int[] array) {
        boolean done = false;
        int j = 0;
        while (!done) {
            done = true;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    array[i + 1] = array[i] + array[i + 1];
                    array[i] = array[i + 1] - array[i];
                    array[i + 1] = array[i + 1] - array[i];
                    done = false;
                }
            }
        }
    }
}
