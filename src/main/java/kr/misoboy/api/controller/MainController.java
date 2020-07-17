package kr.misoboy.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.misoboy.api.model.MainVo;
import kr.misoboy.api.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Api(tags = {"1. 샘플 메인"})
@RestController
@RequestMapping(value = "/main")
public class MainController {

    @Resource(name = "mainService")
    private MainService mainService;

    @ApiOperation(
            value = "샘플 메인 목록 조회",
            response = MainVo.class,
            responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MainVo>> list(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        log.debug("main -> list 조회");

        List<MainVo> employeeList = mainService.selectEmployeeList();

        return new ResponseEntity(employeeList, HttpStatus.OK);
    }
}
