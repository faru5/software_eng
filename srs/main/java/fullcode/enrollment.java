package srs.main.java.fullcode;

import java.time.LocalDateTime;

import srs.main.java.fullcode.Course.Exam;

public class enrollment {
  String enrollmentID;
  student student;
  Course course;
  payment payment;
  Exam exam;
  float progress;
  LocalDateTime enrolmentDate;
  String status;

  // the following are the attributes of the enrollment class
  public enrollment(String enrollmentID, student student, Course course) {
    this.enrollmentID = enrollmentID;
    this.student = student;
    this.course = course;
    this.enrolmentDate = LocalDateTime.now();
    this.status = "Active";
  }

  // this is the constructor of the enrollment class
  public boolean cancelenrollment(String studentID, String courseID) {
    if (this.student.studentID.equals(studentID) && this.course.courseID.equals(courseID)) {
      this.status = "Cancelled";
      return true;
    }
    return false;
  }
}
