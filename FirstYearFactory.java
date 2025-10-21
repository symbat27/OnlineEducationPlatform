public class FirstYearFactory implements StudentFactory {
    @Override
    public Student createStudent(String name, String id) {
        return new FirstYearStudent(name, id);
    }
}

