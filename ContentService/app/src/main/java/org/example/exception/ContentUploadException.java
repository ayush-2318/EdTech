package org.example.exception;

public class ContentUploadException extends RuntimeException{
    public ContentUploadException(String message){
        super(message);
    }
    public ContentUploadException(String messge,Throwable cause){
        super(messge,cause);
    }
}
