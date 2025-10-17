public class CertificateDecorator extends CourseDecorator {
    public CertificateDecorator(Course course) {
        super(course);
    }

    @Override
    public String deliverContent() {
        return super.deliverContent() + " + Certificate granted upon completion.";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " (With Certificate)";
    }
}


