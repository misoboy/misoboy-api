package kr.misoboy.api.controller;

import io.swagger.annotations.*;
import kr.misoboy.api.model.FeedModel;
import kr.misoboy.api.service.FeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Api(tags = {"2. 피드"})
@RestController
@RequestMapping(value = "/v1/feed")
public class FeedController {

    @Resource(name = "feedService")
    private FeedService feedService;

    @ApiOperation(
            value = "Feed 목록 조회",
            response = FeedModel.class,
            responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 401, message = "권한 없음")
            }
    )
    @GetMapping(value = "/{emplyrId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeedModel>> getFeeds(
            @ApiParam(value = "사용자 아이디", required = true, defaultValue = "00000000000000000001")
            @PathVariable(name = "emplyrId") String emplyrId
    ) {

        FeedModel feedModel = new FeedModel();
        feedModel.setRegistEmplyrId(emplyrId);
        // Feed 목록 조회
        List<FeedModel> feedList = feedService.selectFeedList(feedModel);
        return ResponseEntity.status(HttpStatus.OK).body(feedList);
    }

    @ApiOperation(
            value = "Feed 상세 조회",
            response = FeedModel.class,
            responseContainer = "Object",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 401, message = "권한 없음")
            }
    )
    @GetMapping(value = "/{emplyrId}/{feedSn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeedModel> getFeed(
            @ApiParam(value = "사용자 아이디", required = true, defaultValue = "00000000000000000001")
            @PathVariable(name = "emplyrId") String emplyrId,
            @ApiParam(value = "피드 일련번호", required = true, defaultValue = "1")
            @PathVariable(name = "feedSn") Integer feedSn
    ) {

        FeedModel feedModel = new FeedModel();
        feedModel.setRegistEmplyrId(emplyrId);
        feedModel.setFeedSn(feedSn);
        // Feed 상세 조회
        FeedModel feedDetail = feedService.selectFeedDetail(feedModel);
        return ResponseEntity.status(HttpStatus.OK).body(feedDetail);
    }

    @ApiOperation(
            value = "Feed 등록",
            responseContainer = "Object",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 401, message = "권한 없음")
            }
    )
    @PostMapping(value = "/{emplyrId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createFeed(
            @ApiParam(value = "사용자 아이디", required = true, defaultValue = "00000000000000000001")
            @PathVariable(name = "emplyrId") String emplyrId,
            @ApiParam(value = "피드 내용", required = true, defaultValue = "테스트 피드 내용 입니다.")
            @RequestParam(name = "cn") String cn
    ) {

        FeedModel feedModel = new FeedModel();
        feedModel.setRegistEmplyrId(emplyrId);
        feedModel.setCn(cn);
        // Feed 등록
        feedService.insertFeed(feedModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(
            value = "Feed 수정",
            responseContainer = "Object",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 401, message = "권한 없음")
            }
    )
    @PutMapping(value = "/{emplyrId}/{feedSn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity modifyFeed(
            @ApiParam(value = "사용자 아이디", required = true, defaultValue = "00000000000000000001")
            @PathVariable(name = "emplyrId") String emplyrId,
            @ApiParam(value = "피드 일련번호", required = true, defaultValue = "1")
            @PathVariable(name = "feedSn") Integer feedSn,
            @ApiParam(value = "피드 내용", required = true, defaultValue = "테스트 피드 내용 입니다.")
            @RequestParam(name = "cn") String cn
    ) {

        FeedModel feedModel = new FeedModel();
        feedModel.setRegistEmplyrId(emplyrId);
        feedModel.setFeedSn(feedSn);
        feedModel.setCn(cn);
        // Feed 수정
        feedService.updateFeed(feedModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(
            value = "Feed 삭제",
            responseContainer = "Object",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 401, message = "권한 없음")
            }
    )
    @DeleteMapping(value = "/{emplyrId}/{feedSn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity removeFeed(
            @ApiParam(value = "사용자 아이디", required = true, defaultValue = "00000000000000000001")
            @PathVariable(name = "emplyrId") String emplyrId,
            @ApiParam(value = "피드 일련번호", required = true, defaultValue = "1")
            @PathVariable(name = "feedSn") Integer feedSn
    ) {

        FeedModel feedModel = new FeedModel();
        feedModel.setRegistEmplyrId(emplyrId);
        feedModel.setFeedSn(feedSn);
        // Feed 삭제
        feedService.deleteFeed(feedModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
