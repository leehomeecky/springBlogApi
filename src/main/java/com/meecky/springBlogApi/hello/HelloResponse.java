package com.meecky.springBlogApi.hello;

public class HelloResponse {
//    @Autowired
    private String message;

    public HelloResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
