package uz.pdp.springboot.springboot.config.handlers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.springboot.springboot.dto.reponse.AppErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        return null;
    }
}
