public class LastChoiceComputer extends Computer {
    private int lastChoice;
    private String name;

    public LastChoiceComputer() {
        this.name = "Mighty Last Choice Computer!";
        this.lastChoice = 0;
    }

    public void setLastChoice(int lastChoice) {
        this.lastChoice = lastChoice;
    }

    @Override
    protected String getName(){
        return name;
    }

    public void chooseMove(){

    }
}
