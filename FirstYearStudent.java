public class FirstYearStudent extends Student {

    public FirstYearStudent(String name, String id) {
        super(name, id);
    }


    @Override
    public void study() {
        System.out.println("First-year student " + name + " is learning the basics.");
    }
}




