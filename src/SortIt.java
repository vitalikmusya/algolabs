import java.util.stream.Stream;

public class SortIt {
    private String typeOfSort;
    private Long execTime = 0L;
    private int[] inputArray;
    public int[] sortedArray;
    private int comparison = 0;
    private int swaps = 0;
    private String sortBy;

    public SortIt() {}

    public SortIt(String[] param) {
        sortBy = param[0];
        typeOfSort = param[2];
        makeIntArrayOfString(param[1]);
        startQuickSort(0, inputArray.length - 1);
        printSorted();
    }
    
    private void makeIntArrayOfString(String numbers) {
        String[] arrayTemp = numbers.split(",");
        try{
            inputArray = Stream.of(arrayTemp).mapToInt(Integer::parseInt).toArray();
        }catch (NumberFormatException e){
            System.out.println("input data cannot be expressions");
            System.exit(0);
        }

        sortedArray = inputArray;
    }

    private void printSorted() {
        CommandPromptIO cp = new CommandPromptIO();
        cp.printResult(sortBy,sortedArray,typeOfSort,execTime,swaps,comparison);
    }

    private void startQuickSort(int start,int end) {
        QuickSort quickSort = new QuickSort();
        if(sortBy.equals("desc")){
            getTimeExec(() -> quickSort.sort(sortedArray, start, end,(int a , int b) -> a >= b));
        }else {
            getTimeExec(() -> quickSort.sort(sortedArray, start, end,(int a , int b) -> a <= b));
        }
        typeOfSort = "QuickSort";
        swaps = quickSort.getSwaps();
        comparison = quickSort.getComparison();
    }

    private void getTimeExec(Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        execTime = System.nanoTime() - startTime;
    }

}