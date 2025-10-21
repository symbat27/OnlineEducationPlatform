public class ThirdYearStudent extends Student {

    public ThirdYearStudent(String name, String id) {
        super(name, id);
    }

    @Override
    public void study() {
        System.out.println("Third-year student " + name + " is specializing in their field.");
    }
}
