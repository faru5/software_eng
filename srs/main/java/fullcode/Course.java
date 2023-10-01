package srs.main.java.fullcode;

import java.time.LocalDateTime;
import java.util.List;

//the following are the attributes of the course class
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

  // the following objects are the attributes of the course class
  public Course(String courseID, LocalDateTime startDate) {
    this.courseID = courseID;
    this.startDate = startDate;
  }

  // this is the constructor of the course class
  public class Exam {

  }

  // the following are the attributes of the exam class
  public void getCourseDetails() {
  }

  // this is the constructor of the exam class
  public String getCourseCategory() {
    return category;
  }

  // the following are the attributes of the exam class
  public void addstudent(student student) {
  }

  // this is the constructor of the exam class
  public void removestudent(student student) {
  }
}
