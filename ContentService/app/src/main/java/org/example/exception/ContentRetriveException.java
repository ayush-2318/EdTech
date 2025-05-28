package org.example.exception;

public class ContentRetriveException extends RuntimeException{
    public ContentRetriveException(String message){
        super(message);
    }
    public ContentRetriveException(String message,Throwable cause){
        super(message,cause);
    }
}
