public class Main {
    public static void main(String[] args) {
        CommandPromptIO commandPromptIO = new CommandPromptIO(args);
        SortIt sortIt = new SortIt(commandPromptIO.getParameter());
    }
}