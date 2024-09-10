public class OriginalComputer {
    private int options;

    public OriginalComputer(){
    }

    public void setOptions(String gameMode) {
        this.options = 2 * Integer.parseInt(gameMode) + 1;
    }
}
