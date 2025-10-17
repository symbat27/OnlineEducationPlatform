public class Demo {
    public static void main(String[] args) {

        StudentPortalFacade portal = new StudentPortalFacade();

        Student symbat = new Symbat("Symbat");
        Student gulzada = new Gulzada("Gulzada");

        Course calculusCourse = new CalculusCourse();
        Course enhancedCalculusCourse = new MentorSupportDecorator(new CertificateDecorator(calculusCourse));
        portal.enrollStudent(symbat, enhancedCalculusCourse);
        portal.startLearning(symbat, enhancedCalculusCourse);
        portal.completeCourse(symbat, enhancedCalculusCourse);

        Course webTechnologiesCourse = new WebTechnologiesCourse();
        Course enhancedWebTechnologiesCourse = new GamificationDecorator(new CertificateDecorator(webTechnologiesCourse));
        portal.enrollStudent(gulzada, enhancedWebTechnologiesCourse);
        portal.startLearning(gulzada, enhancedWebTechnologiesCourse);
        portal.completeCourse(gulzada, enhancedWebTechnologiesCourse);

        portal.getCourseProgress(enhancedCalculusCourse.getDescription());
        portal.getCourseProgress(enhancedWebTechnologiesCourse.getDescription());
    }
}






