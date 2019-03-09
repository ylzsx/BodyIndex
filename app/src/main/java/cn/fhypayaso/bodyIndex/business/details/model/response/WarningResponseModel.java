package cn.fhypayaso.bodyIndex.business.details.model.response;

public class WarningResponseModel {

    /**
     * message : 心率过快
     * time : 15分钟前
     */

    private String message;
    private String time;

    public WarningResponseModel(String message, String time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
