package com.example.umcdongdong2.global.apiPayload.handler;

import com.example.umcdongdong2.global.apiPayload.ApiResponse;
import com.example.umcdongdong2.global.apiPayload.code.BaseErrorCode;
import com.example.umcdongdong2.global.apiPayload.code.GeneralErrorCode;
import com.example.umcdongdong2.global.apiPayload.exception.ProjectException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionAdvice {

    // 프로젝트에서 발생한 예외 처리
    @ExceptionHandler(ProjectException.class)
    // ResponseEntity는 Spring에서 실제로 response를 보내줄때 최종적으로 만드는 raw 객체?
    public ResponseEntity<ApiResponse<Void>> handleMemberException(ProjectException e) {
        BaseErrorCode errorCode = e.getErrorCode();
        return ResponseEntity.status(errorCode.getStatus())
                .body(ApiResponse.onFailure(errorCode, null));
    }

    // 그 외의 정의되지 않은 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception ex) {

        BaseErrorCode code = GeneralErrorCode.NOT_FOUND;
        return ResponseEntity.status(code.getStatus())
                .body(ApiResponse.onFailure(
                                code,
                                ex.getMessage()
                        )
                );
    }
}