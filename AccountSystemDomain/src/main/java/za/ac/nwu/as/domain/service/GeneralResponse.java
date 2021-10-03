package za.ac.nwu.as.domain.service;

import java.util.Objects;

public class GeneralResponse<T> {

    private String message;

    private Boolean success;

    private T response;

    public GeneralResponse() {
    }

    public GeneralResponse(String message, Boolean success, T response) {
        this.message = message;
        this.success = success;
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralResponse<?> that = (GeneralResponse<?>) o;
        return Objects.equals(message, that.message) && Objects.equals(success, that.success) && Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, success, response);
    }

    @Override
    public String toString() {
        return "GeneralResponse{" +
                "message='" + message + '\'' +
                ", success=" + success +
                ", response=" + response +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
