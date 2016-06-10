package com.sh321han.mommyshare.data;

public class ChatDataResultResult {
    private String reg_date;
    private String receiver_id;
    private boolean isread;
    private int message_id;
    private String _id;
    private String message;
    private String sender_id;

    public String getReg_date() {
        return this.reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getReceiver_id() {
        return this.receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    public boolean getIsread() {
        return this.isread;
    }

    public void setIsread(boolean isread) {
        this.isread = isread;
    }

    public int getMessage_id() {
        return this.message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender_id() {
        return this.sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }
}
