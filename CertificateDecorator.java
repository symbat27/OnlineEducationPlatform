public class CertificateDecorator extends CourseDecorator {
    public CertificateDecorator(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public void deliverContent() {
        System.out.println("Certificate will be given after completion.");
    }
}



