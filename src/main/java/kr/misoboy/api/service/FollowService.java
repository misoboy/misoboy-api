package kr.misoboy.api.service;

import kr.misoboy.api.model.FollowModel;

import java.util.List;

public interface FollowService {

    /**
     * 팔로우 목록 조회
     * @param followModel
     * @return
     */
    List<FollowModel> selectFollowList(FollowModel followModel);

    /**
     * 팔로워 목록 조회
     * @param followModel
     * @return
     */
    List<FollowModel> selectFollowerList(FollowModel followModel);

    /**
     * 팔로우 상세 조회
     * @param followModel
     * @return
     */
    FollowModel selectFollowDetail(FollowModel followModel);

    /**
     * 팔로우 등록
     * @param followModel
     * @return
     */
    int insertFollow(FollowModel followModel);

    /**
     * 팔로우 허용 수정
     * @param followModel
     * @return
     */
    int updateFollowPermit(FollowModel followModel);

    /**
     * 팔로우 삭제
     * @param followModel
     * @return
     */
    int deleteFollow(FollowModel followModel);
}
