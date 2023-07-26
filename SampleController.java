public class SampleController {
    private SampleView sample;

    public SampleController(SampleView sample){
        this.sample = new SampleView();
    }

    public static void main(String[] args){
        SampleController controller = new SampleController(null);
    }
}
