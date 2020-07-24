package com.example.backend_template.exception;

import com.example.backend_template.utils.ResultData;
import com.example.backend_template.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @ClassName GlobalExceptionHandler 全局统一处理异常
 * @Description
 * @Author L
 * @Date Create by 2020/7/7
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 该请求控制器存在，但请求HTTP方法与该控制器提供不符
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(405, "Http Request Method Not Supported!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Http Request Method Not Supported", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * content-type 内容设置类型不支持
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(415, "Http Media Type Not Supported!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Http Media Type Not Supported", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    /**
     * content-type 内容设置类型不能接受
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(406, "Http Media Type Not Acceptable!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Http Media Type Not Acceptable", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * 缺少路径参数
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(MissingPathVariableException.class)
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(500, "Missing Path Variable!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Missing Path Variable", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 缺少请求参数
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(400, "Missing Servlet Request Parameter!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Missing Servlet Request Parameter", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    /**
     * Servlet请求绑定出错
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(ServletRequestBindingException.class)
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(400, "Servlet Request Binding!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Servlet Request Binding", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    /**
     * 转换不支持
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(ConversionNotSupportedException.class)
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(500, "Conversion Not Supported!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Conversion Not Supported", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 参数类型匹配失败
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(TypeMismatchException.class)
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(400, "Type Mismatch!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Type Mismatch", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    /**
     * HTTP 信息请求不可读
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(400, "Http Message Not Readable!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Http Message Not Readable", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    /**
     * HTTP 信息请求不可写
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(HttpMessageNotWritableException.class)
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(500, "Http Message Not Writable!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Http Message Not Writable", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 参数校验出错
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(400, "Method Argument Not Valid!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Method Argument Not Valid", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    /**
     * 丢失了一部分请求信息
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(MissingServletRequestPartException.class)
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(400, "Missing Servlet Request Part!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Missing Servlet Request Part", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    /**
     * 参数绑定出错
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<Object> handleBindException(BindException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(400, "Bind Exception!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Bind Exception", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    /**
     * 根据请求url找不到控制器，即404异常
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(404, "No Handler Found!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "No Handler Found", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }

    /**
     * 异步请求超时
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(AsyncRequestTimeoutException.class)
    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(503, "Async Request Timeout!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Async Request Timeout", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.SERVICE_UNAVAILABLE);
    }

    /**
     * 其它未统一的异常，都由以下handle处理，生产可写网络异常
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(500, "Server Error!", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "Server Error", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //以下是自定义异常

    /**
     * 没有找到该用户
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        ResultData<Object> errorBody = ResultUtils.fail(404, "User Not Found", ex.getLocalizedMessage());
        log.error("Throw [{}] exception: {}", "User Not Found", ex.getLocalizedMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }

}
