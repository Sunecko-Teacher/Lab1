package helpers;

public class ArrayUtils {

    /**
     * Helper function to count the real amount of non null elements within the
     * array <b><i>elements</i></b>
     * 
     * @param elements array to be counted
     * @return the real amount of non null elements within the array.
     *         <p>
     *         please be aware that
     *         between elements may exist null values, wich means that the array has
     *         holes of null elements.
     *         </p>
     */
    public static int realArrayLength(Object[] elements) {
        int cont = 0;
        for (Object x : elements) {
            if (x != null)
                cont++;
        }
        return cont;
    }

    /**
     * @param src  Array to be resized.
     * @param size New length of the array.
     * @return a duplicated version of the source array but with a bigger capacity.
     */
    public static Object[] resize(Object[] src, int size) {
        int arrSize = realArrayLength(src);
        Object[] arr = new Object[size];
        System.arraycopy(src, 0, arr, 0, arrSize);
        return arr;
    }
}
