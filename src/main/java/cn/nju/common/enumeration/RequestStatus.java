package cn.nju.common.enumeration;

public enum RequestStatus {
    SUCCESS("success"),
    FAIL("fail");

    private String message;

    private RequestStatus(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
