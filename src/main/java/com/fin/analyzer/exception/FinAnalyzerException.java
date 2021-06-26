package com.fin.analyzer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FinAnalyzerException extends RuntimeException {

    private int errorCode;
    private String errorMessage;

    public FinAnalyzerException(int errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public FinAnalyzerException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }



//    @ExceptionHandler(CustomerNotFoundException.class)
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ErrorResponse handle404Error(CustomerNotFoundException e) {
//        return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
//
//    }
//
//
//    @ExceptionHandler(TransactionsNotFoundException.class)
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ErrorResponse errorForUpdate(TransactionsNotFoundException e) {
//        return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
//
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public ErrorResponse handle500Error() {
//        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                "Unable to process the request please try after some time");
//
//    }


}
