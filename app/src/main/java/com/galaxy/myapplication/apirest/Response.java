package com.galaxy.myapplication.apirest;


public class Response<Data>{

    public boolean status;
    public Error error;
    public Body<Data> body;

    public class Body<Data>{
        public String message;
        public Data data;
    }

    public class Error{
        public Integer errorcode;
        public String errorMessage;


    }


}
