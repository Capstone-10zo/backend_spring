package project.capstone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoMatchImageException.class)
    public ResponseEntity<Object> handleNoMatchException(NoMatchImageException ex){
        ErrorResponse errorResponse = new ErrorResponse("No suitable result", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    static class ErrorResponse{

        private String title;
        private String message;

        public ErrorResponse(String title, String message) {
            this.title = title;
            this.message = message;
        }
    }
}
