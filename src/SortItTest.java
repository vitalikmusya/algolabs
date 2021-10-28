import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortItTest {
    public QuickSort quickSort;
    public int[] arrTest = new int[] {1,2,56,45,-9,78,11,1,24,43434,535,55,35,5,3,8,7,5,3,2,-3,-4};
    public int[] arrDesc = new int[] {43434,535,78,56,55,45,35,24,11,8,7,5,5,3,3,2,2,1,1,-3,-4,-9};
    public int[] arrAsc = new int[] {-9,-4,-3,1,1,2,2,3,3,5,5,7,8,11,24,35,45,55,56,78,535,43434};
    public int[] arrTemp;

    public void setArrTemp(int[] arrTemp) {
        this.arrTemp = arrTemp;
    }

    @Before
    public void init() {
        quickSort = new QuickSort();
    }

    @Test
    public void testQuickSortInDesc() {
        setArrTemp(arrTest);
        quickSort.sort(arrTemp, 0, arrTemp.length - 1, (int a, int b) -> a >= b);
        Assert.assertArrayEquals(arrDesc, arrTemp);
    }

    @Test
    public void testQuickSortInAsc() {
        setArrTemp(arrTest);
        quickSort.sort(arrTemp, 0, arrTemp.length - 1, (int a, int b) -> a <= b);
        Assert.assertArrayEquals(arrAsc, arrTemp);
    }

    @Test
    public void testQuickSortSortedDesc() {
        setArrTemp(arrDesc);
        quickSort.sort(arrTemp, 0, arrTemp.length - 1, (int a, int b) -> a >= b);
        Assert.assertEquals(0,  quickSort.getSwaps());
    }

    @Test
    public void testQuickSortSortedAsc() {
        setArrTemp(arrDesc);
        quickSort.sort(arrTemp, 0, arrTemp.length - 1, (int a, int b) -> a >= b);
        Assert.assertEquals(0,  quickSort.getSwaps());
    }
}
