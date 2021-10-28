public class QuickSort {
    private int comparison = 0;
    private int swaps = 0;

    public int getComparison() {
        return comparison;
    }

    public int getSwaps() {
        return swaps;
    }

    public void sort(int[] arr, int start, int end, SortComparator comparator){
        if (start < end) {
            int middlePoint = partition(arr, start, end, comparator);
            sort(arr, start, middlePoint - 1, comparator);
            sort(arr, middlePoint + 1, end, comparator);
        }
    }

    private int partition(int[] arr, int start, int end,SortComparator comparator){
        int pivot = arr[end];
        int point = start-1;

        for (int i = start; i < end; i++) {
            if (comparator.compare(arr[i],pivot)){
                comparison++;
                point++;
                if(arr[i] != arr[point]){
                    swap(arr,i,point);
                }

            }
        }
        if(arr[point+1] != arr[end]){
            swap(arr, point+1, end);
        }
        return point+1;
    }

    private void swap(int[] arr, int index1, int index2) {
        swaps++;
        int tmp  = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}
