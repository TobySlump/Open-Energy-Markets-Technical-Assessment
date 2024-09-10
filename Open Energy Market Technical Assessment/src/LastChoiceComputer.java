public class LastChoiceComputer {
    private int options;

    public LastChoiceComputer(){
    }

    public void setOptions(String gameMode) {
        this.options = 2 * Integer.parseInt(gameMode) + 1;
    }

}
