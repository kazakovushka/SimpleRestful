package ru.kazakovushka.edu;

public class BaseResponse {
    private final Integer code;
    private final String status;

    public BaseResponse(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
