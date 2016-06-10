package com.sh321han.mommyshare.data;

public class ChatDataResult {
    private ChatDataResultResult[] result;
    private boolean success;
    private String message;

    public ChatDataResultResult[] getResult() {
        return this.result;
    }

    public void setResult(ChatDataResultResult[] result) {
        this.result = result;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
