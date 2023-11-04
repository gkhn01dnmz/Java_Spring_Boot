package com.gokhan.springmongo.exception;

public class TodoCollectionException  extends Exception {
    

    private static final long serialVersionUID =1L;

    public TodoCollectionException(String message) {
        super(message);
    }

    public static String NotFoundException(String id){
        return "Todo with "+ id+" not found";
    }

    public static String TodoAlreadyExistsException(){
        return "Todo already exists";
    }

}
