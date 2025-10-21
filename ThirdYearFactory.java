public class ThirdYearFactory implements StudentFactory {
    @Override
    public Student createStudent(String name, String id) {
        return new ThirdYearStudent(name, id);
    }
}
