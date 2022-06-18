package domain;

public class TrainingSession {
    private int id;
    private String sessionDate;
    private String topic;
    private int trainer;

    public TrainingSession(int id, String sessionDate, String topic, int trainer) {
        this.id = id;
        this.sessionDate = sessionDate;
        this.topic = topic;
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return "TrainingSession{" +
                "id=" + id +
                ", sessionDate='" + sessionDate + '\'' +
                ", topic='" + topic + '\'' +
                ", trainer=" + trainer +
                '}';
    }
}
