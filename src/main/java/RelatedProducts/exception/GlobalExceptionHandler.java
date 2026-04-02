package RelatedProducts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleResourceNotFound(ResourceNotFoundException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
        problemDetail.setType(URI.create("https://api.relatedproducts.ru/errors/not-found"));
        problemDetail.setTitle("Resource not found");
        problemDetail.setProperty("resource", ex.getResourceName());
        problemDetail.setProperty("resourceId", ex.getResourceId());
        problemDetail.setInstance(URI.create("api/products/" + ex.getResourceId()));

        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleAllOtherException(Exception ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Internal server error"
        );
        problemDetail.setType(URI.create("https://api.relatedproducts.ru/errors/internal-server-error"));
        problemDetail.setTitle("Internal server error");

        return problemDetail;
    }
}
