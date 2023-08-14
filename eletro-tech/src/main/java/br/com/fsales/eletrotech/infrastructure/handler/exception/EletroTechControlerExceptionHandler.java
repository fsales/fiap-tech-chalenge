package br.com.fsales.eletrotech.infrastructure.handler.exception;


import br.com.fsales.eletrotech.infrastructure.exception.EletroTechNegocioException;
import br.com.fsales.eletrotech.infrastructure.exception.NotFoundException;
import br.com.fsales.eletrotech.infrastructure.exception.dto.ValidationErrorResponse;
import br.com.fsales.eletrotech.infrastructure.exception.dto.Violation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class EletroTechControlerExceptionHandler extends ResponseEntityExceptionHandler {

    private static void montarListaErro(
            ValidationErrorResponse error,
            ConstraintViolationException constraintViolationException
    ) {
        constraintViolationException
                .getConstraintViolations().forEach(violation -> {
                    error.getViolations()
                            .add(
                                    new Violation(
                                            violation.getPropertyPath().toString()
                                            , violation.getMessage()
                                    )
                            );
                });
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ValidationErrorResponse> handleGeneralExceptions(
            Exception ex
    ) {
        var statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        log.error(ex.getMessage(), ex);

        ValidationErrorResponse error = new ValidationErrorResponse();

        error.violation(
                Violation
                        .builder()
                        .message(ex.getMessage())
                        .build()
        );

        return new ResponseEntity<>(
                error,
                new HttpHeaders(),
                statusCode
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ValidationErrorResponse> handleRuntimeExceptions(
            RuntimeException ex
    ) {

        var statusCode = HttpStatus.INTERNAL_SERVER_ERROR;

        ValidationErrorResponse error = new ValidationErrorResponse();

        error.violation(
                Violation
                        .builder()
                        .message(ex.getMessage())
                        .build()
        );


        log.error(ex.getMessage(), ex);

        return new ResponseEntity<>(
                error,
                new HttpHeaders(),
                statusCode
        );
    }


    @ExceptionHandler(org.springframework.orm.jpa.JpaObjectRetrievalFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse entityNotFoundException(
            org.springframework.orm.jpa.JpaObjectRetrievalFailureException e
    ) {
        log.error(e.getMessage(), e);
        ValidationErrorResponse error = new ValidationErrorResponse();

        error.violation(
                Violation
                        .builder()
                        .message("Registro não encontrado")
                        .build()
        );

        return error;
    }


    @ExceptionHandler(jakarta.persistence.EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse entityNotFoundException(
            jakarta.persistence.EntityNotFoundException e
    ) {
        log.error(e.getMessage(), e);
        ValidationErrorResponse error = new ValidationErrorResponse();

        error.violation(
                Violation
                        .builder()
                        .message("Registro não encontrado")
                        .build()
        );

        return error;
    }

    @ExceptionHandler(TransactionSystemException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onConstraintValidationException(
            TransactionSystemException e
    ) {
        log.error(e.getMessage(), e);
        ValidationErrorResponse error = new ValidationErrorResponse();

        if (e.getRootCause() instanceof ConstraintViolationException constraintViolationException) {
            montarListaErro(error, constraintViolationException);
        } else {

            var throwable = org.apache.commons.lang3.exception
                    .ExceptionUtils.getRootCause(e);
            error.getViolations()
                    .add(
                            new Violation(
                                    null,
                                    throwable.getMessage()
                            )
                    );
        }

        return error;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onConstraintValidationException(
            ConstraintViolationException e
    ) {
        log.error(e.getMessage(), e);
        ValidationErrorResponse error = new ValidationErrorResponse();

        montarListaErro(error, e);

        return error;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse notFoundException(
            NotFoundException notFoundException
    ) {
        log.error(
                notFoundException.getMessage(),
                notFoundException
        );

        ValidationErrorResponse error = new ValidationErrorResponse();

        error.getViolations()
                .add(
                        Violation
                                .builder()
                                .message(
                                        notFoundException.getMessage()
                                )
                                .build()
                );

        return error;
    }

    @ExceptionHandler(EletroTechNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse eletroTechNegocioException(
            EletroTechNegocioException eletroTechNegocioException
    ) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.violation(
                eletroTechNegocioException.list()
        );

        return error;
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException e,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        var statusCode = HttpStatus.BAD_REQUEST;

        ValidationErrorResponse error = new ValidationErrorResponse();

        log.error(e.getMessage(), e);
        e.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> {
                    error
                            .getViolations()
                            .add(
                                    new Violation(
                                            fieldError.getField(),
                                            fieldError.getDefaultMessage()
                                    )
                            );

                });

        return handleExceptionInternal(
                e,
                error,
                headers,
                statusCode,
                request
        );
    }
}
