public class SecondYearStudent extends Student {

    public SecondYearStudent(String name, String id) {
        super(name, id);
    }

    @Override
    public void study() {
        System.out.println("Second-year student " + name + " is mastering advanced topics.");
    }
}





