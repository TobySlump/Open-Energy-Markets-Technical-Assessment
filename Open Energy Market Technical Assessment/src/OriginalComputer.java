public class OriginalComputer extends Computer{

    private String name;

    public OriginalComputer(){
        this.name = "Glorious Common Computer!";
    }

    @Override
    protected String getName(){
        return name;
    }
}
