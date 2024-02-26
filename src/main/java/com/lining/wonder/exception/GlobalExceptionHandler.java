package com.lining.wonder.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.SaTokenException;
import com.lining.wonder.common.Result;
import com.lining.wonder.common.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * @author liningwonder
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        //也可以只返回第一个
        BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
        List<ObjectError> errors = bindingResult.getAllErrors();
        StringBuilder message = new StringBuilder();
        for (ObjectError error : errors) {
            message.append(error.getDefaultMessage()).append(" ");
        }
        return Result.build(ResultCodeEnum.SC_VALIDATE_ERROR).msg(message.toString());
    }
    
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<Object> methodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        return Result.build(ResultCodeEnum.SC_METHOD_ERROR);
    }
    
    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result<Object> mediaTypeNotSupportedExceptionHandler(HttpMediaTypeNotSupportedException e) {
        return Result.build(ResultCodeEnum.SC_MEDIA_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<Object> noHandlerExceptionHandler(NoHandlerFoundException e) {
        return Result.build(ResultCodeEnum.SC_NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(HttpMessageConversionException.class)
    public Result<Object> convertExceptionHandler(HttpMessageConversionException e) {
        return Result.build(ResultCodeEnum.SC_BODY_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result<Object> mismatchExceptionHandler(MethodArgumentTypeMismatchException e) {
        return Result.build(ResultCodeEnum.SC_BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(ValidationException.class)
    public Result<Object> validExceptionHandler(ValidationException e) {
        return Result.build(ResultCodeEnum.SC_VALIDATE_ERROR).msg(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public Result<Object> serviceExceptionHandler(ServiceException e) {
        return Result.build(ResultCodeEnum.SC_INTERNAL_SERVER_ERROR).msg(e.getMessage());
    }
    
    @ResponseBody
    @ExceptionHandler(NotLoginException.class)
    public Result<Object> notLoginExceptionHandler(NotLoginException e) {
        return Result.build(ResultCodeEnum.SC_TOKEN_NOT_LOGIN);
    }
    
    @ResponseBody
    @ExceptionHandler(NotPermissionException.class)
    public Result<Object> notPermissionExceptionHandler(NotPermissionException e) {
        return Result.build(ResultCodeEnum.SC_TOKEN_PERMISSION_ERROR);
    }
    
    @ResponseBody
    @ExceptionHandler(NotRoleException.class)
    public Result<Object> notRoleExceptionHandler(NotRoleException e) {
        return Result.build(ResultCodeEnum.SC_TOKEN_PERMISSION_ERROR);
    }
    
    @ResponseBody
    @ExceptionHandler(SaTokenException.class)
    public Result<Object> saTokenExceptionHandler(SaTokenException e) {
        return Result.build(ResultCodeEnum.SC_TOKE_ERROR);
    }

}
