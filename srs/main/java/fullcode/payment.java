package srs.main.java.fullcode;

public class payment {

  String paymentID;
  student student;
  double amount;
  String paymentMethod;
  String transactionID;
  String paymentStatus;

  public payment(String paymentID, student student, double amount) {
    this.paymentID = paymentID;
    this.student = student;
    this.amount = amount;
    this.paymentStatus = "Unprocessed";
  }

  public double calculateFee() {
    return amount;
  }

  public void processPayment() {
  }

  public void processRefund() {
    this.paymentStatus = "Refunded";
  }

  public void validateTransaction() {
  }
}
