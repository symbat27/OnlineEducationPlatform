public class SecondYearFactory implements StudentFactory {
    @Override
    public Student createStudent(String name, String id) {
        return new SecondYearStudent(name, id);
    }
}

