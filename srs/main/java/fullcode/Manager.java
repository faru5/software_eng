package srs.main.java.fullcode;

import java.util.ArrayList;

public class Manager extends user {
    ArrayList<FeedbackPoll> polls;
    private ArrayList enquiries;

    public Manager(String username, String password) {
        super(username, password);
        this.enquiries = new ArrayList<>();
        this.polls = new ArrayList<>();
    }

    public void respondEnquiry(Website website, String enquiryID, String response) {
        Message message = new Message();
        // set message object with sender detail and message content;
        message.setMessage(this.email, response);

        // select enquiry that matches ID and attach response message
        for (Enquiry enquiry : website.openEnquiries) {
            if (enquiry.enquiryID.equals(enquiryID)) {
                enquiry.sendResponse(message);
                return;
            }
        }

    }

    public void createFeedbackPoll() {

    }

    public void managePoll() {

    }
}
