import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandPromptIO {
    private String[] input;
    private final String[] parameters = new String[3];

    public String[] getParameter() {
        return parameters;
    }

    public CommandPromptIO(){}

    public CommandPromptIO(String[] inputTerm) {
        this.input = inputTerm;
        cutParameters();
    }

    public void printResult(String asc, int[] sortedArray, String typeOfSort, long exec, int swaps, int comparison){
        System.out.println("Sorted Type: " + typeOfSort);
        System.out.println("Sorted by: " + asc);
        System.out.println("Execution time: " + exec + " ns");
        System.out.println("Execution time: " + exec/1000000 + " ms");
        System.out.println("Comparison: " + comparison);
        System.out.println("Swaps: " + swaps);
        System.out.println(Arrays.toString(sortedArray));
    }

    private void cutParameters() {
        if(input.length == 0) {
            System.out.println("There isn`t any parameters!");
            System.exit(0);
        }

        Pattern pattern = Pattern.compile("(asc|desc)+\\s+([\\-\\d,]+)+\\s+(qs|ms|hs)");

        String tempLine = "";
        for (int i = 0; i < input.length; i++) {
            tempLine += input[i] + " ";
        }

        Matcher matcher = pattern.matcher(tempLine);

        if (matcher.find()) {
            parameters[0]=matcher.group(1);
            parameters[1]=matcher.group(2);
            parameters[2]=matcher.group(3);
        } else {
            System.out.println("Not Valid format!All parameters in one line!");
            System.out.println("First asc or desc");
            System.out.println("Second values dividing by comma \",\"");
            System.out.println("Third type of sort \n QuickSort - qs ");
            System.out.println("Example \"desc 1,2,56,45,-9,78,11 qs\"");
            System.exit(0);
        }

    }
}
