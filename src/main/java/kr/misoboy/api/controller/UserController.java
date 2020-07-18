package kr.misoboy.api.controller;

import io.swagger.annotations.*;
import kr.misoboy.api.model.FollowModel;
import kr.misoboy.api.model.UserModel;
import kr.misoboy.api.service.FollowService;
import kr.misoboy.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Slf4j
@Api(tags = {"1. 사용자"})
@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "followService")
    private FollowService followService;

    @ApiOperation(
            value = "사용자 목록 조회",
            response = UserModel.class,
            responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 401, message = "권한 없음"),
            }
    )
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserModel>> getUsers(
    ) {

        // 사용자 목록 조회
        List<UserModel> userList = userService.selectUserList();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @ApiOperation(
            value = "사용자 정보 조회",
            response = UserModel.class,
            responseContainer = "Object",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 401, message = "권한 없음"),
            }
    )
    @GetMapping(value = "/{emplyrId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> getUser(
            @ApiParam(value = "사용자 아이디", required = true, defaultValue = "00000000000000000001")
            @PathVariable(name = "emplyrId") String emplyrId
    ) {

        // 사용자 상세 정보 조회
        UserModel userDetail = userService.selectUserDetail(emplyrId);
        return ResponseEntity.status(HttpStatus.OK).body(userDetail);
    }

    @ApiOperation(
            value = "Follow 목록 조회",
            response = FollowModel.class,
            responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 401, message = "권한 없음"),
            }
    )
    @GetMapping(value = "/follow/{emplyrId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FollowModel>> getFollows(
            @ApiParam(value = "사용자 아이디", required = true, defaultValue = "00000000000000000001")
            @PathVariable(name = "emplyrId") String emplyrId
    ) {

        FollowModel followModel = new FollowModel();
        followModel.setEmplyrId(emplyrId);

        // Follow 목록 조회
        List<FollowModel> followList = followService.selectFollowList(followModel);
        return ResponseEntity.status(HttpStatus.OK).body(followList);
    }

    @ApiOperation(
            value = "Follower 목록 조회",
            response = FollowModel.class,
            responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 401, message = "권한 없음"),
            }
    )
    @GetMapping(value = "/follower/{emplyrId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FollowModel>> getFollowers(
            @ApiParam(value = "사용자 아이디", required = true, defaultValue = "00000000000000000001")
            @PathVariable(name = "emplyrId") String emplyrId
    ) {

        FollowModel followModel = new FollowModel();
        followModel.setEmplyrId(emplyrId);

        // Follower 목록 조회
        List<FollowModel> followerList = followService.selectFollowerList(followModel);
        return ResponseEntity.status(HttpStatus.OK).body(followerList);
    }

    @ApiOperation(
            value = "Follow 등록",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 401, message = "권한 없음"),
                    @ApiResponse(code = 409, message = "이미 존재한 데이터")
            }
    )
    @PostMapping(value = "/follow/{emplyrId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createFollow(
            @ApiParam(value = "사용자 아이디", required = true, defaultValue = "00000000000000000001")
            @PathVariable(name = "emplyrId") String emplyrId,
            @ApiParam(value = "팔로우 대상 아이디", required = true, defaultValue = "00000000000000000002")
            @RequestParam(name = "trgetEmplyrId", defaultValue = "00000000000000000002") String trgetEmplyrId
    ) {

        FollowModel followModel = new FollowModel();
        followModel.setEmplyrId(emplyrId);
        followModel.setTrgetEmplyrId(trgetEmplyrId);

        // Follow 상세 조회
        FollowModel followDetail = followService.selectFollowDetail(followModel);
        if (!Objects.isNull(followDetail)){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            // Follow 등록
            followService.insertFollow(followModel);
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(
            value = "Follow 허용",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 204, message = "데이터가 없음"),
                    @ApiResponse(code = 401, message = "권한 없음")
            }
    )
    @PutMapping(value = "/follow/{emplyrId}/permit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity permitFollow(
            @ApiParam(value = "사용자 아이디", required = true, defaultValue = "00000000000000000001")
            @PathVariable(name = "emplyrId") String emplyrId,
            @ApiParam(value = "팔로우 대상 아이디", required = true, defaultValue = "00000000000000000002")
            @RequestParam(name = "trgetEmplyrId", defaultValue = "00000000000000000002") String trgetEmplyrId

    ) {

        FollowModel followModel = new FollowModel();
        followModel.setEmplyrId(emplyrId);
        followModel.setTrgetEmplyrId(trgetEmplyrId);

        // Follow 상세 조회
        FollowModel followDetail = followService.selectFollowDetail(followModel);
        if (Objects.isNull(followDetail)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        // Follow 허용
        followService.updateFollowPermit(followModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(
            value = "Follow 삭제",
            responseContainer = "Object",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 401, message = "권한 없음")
            }
    )
    @DeleteMapping(value = "/follow/{emplyrId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity removeFollow(
            @ApiParam(value = "사용자 아이디", required = true, defaultValue = "00000000000000000001")
            @PathVariable(name = "emplyrId") String emplyrId,
            @ApiParam(value = "팔로우 대상 아이디", required = true, defaultValue = "00000000000000000002")
            @RequestParam(name = "trgetEmplyrId", defaultValue = "00000000000000000002") String trgetEmplyrId

    ) {

        FollowModel followModel = new FollowModel();
        followModel.setEmplyrId(emplyrId);
        followModel.setTrgetEmplyrId(trgetEmplyrId);

        // Follow 삭제
        followService.deleteFollow(followModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
