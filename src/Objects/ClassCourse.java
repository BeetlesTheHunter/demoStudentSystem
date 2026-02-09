package Objects;

public interface ClassCourse {

    public enum Course {
    
        LOW("low"),
        UPPER("upper"),
        HIGH("high");

        private final String description;

        Course(String description) {
            this.description = description;
        }

        
        public String getCourseString() {
            return description;
        }
    }

    public void setCourse(String _course);

}
