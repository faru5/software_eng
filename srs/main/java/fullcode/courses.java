package srs.main.java.fullcode;

import java.time.LocalDateTime;
import java.util.List;

public class Course {
  String courseID;
  String name;
  LocalDateTime startDate;
  LocalDateTime endDate;
  String category;
  String description;
  String duration;
  double fee;
  int availableSeats;
  boolean isOnline;
  boolean isFaceToFace;
  List<student> Enrolledstudents;

  public Course(String courseID, LocalDateTime startDate) {
    this.courseID = courseID;
    this.startDate = startDate;
  }

  public void getCourseDetails() {
  }

  public String getCourseCategory() {
    return category;
  }

  public void addstudent(student student) {
  }

  public void removestudent(student student) {
  }
}
