package champter1;

import com.miaozhen.tong.ETL;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by daolei.su on 2018/11/5
 */
public class a {

    public static void main(String[] args) throws UnsupportedEncodingException {

        a a1 = new a();
        int[] arr = {1, 2, 3};
        a1.totalOrdering(arr, 0, arr.length);

    }

    private static String recursionDecode(String value) throws UnsupportedEncodingException {
        String tmp;
        boolean changed = false;
        while (!(tmp = java.net.URLDecoder.decode(value, "utf-8")).equals(value)) {
            value = tmp;
            changed = true;
        }
        return changed ? value : null;
    }


    public void totalOrdering(int[] arr, int k, int length) {
        if (k == length) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }

            System.out.println();
        }
        for (int i = k; i < length; i++) {
            swap(arr, i, k);
            totalOrdering(arr, k + 1, length);
            swap(arr, i, k);
        }
    }

    private void swap(int[] arr, int i, int k) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}
