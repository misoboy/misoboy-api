package kr.misoboy.api.service;

import kr.misoboy.api.model.FeedModel;

import java.util.List;

public interface FeedService {

    /**
     * 사용자 Feed 목록 조회
     * @param feedModel
     * @return
     */
    List<FeedModel> selectFeedList(FeedModel feedModel);

    /**
     * Feed 상세 조회
     * @param feedModel
     * @return
     */
    FeedModel selectFeedDetail(FeedModel feedModel);

    /**
     * Feed 등록
     * @param feedModel
     * @return
     */
    int insertFeed(FeedModel feedModel);

    /**
     * Feed 수정
     * @param feedModel
     * @return
     */
    int updateFeed(FeedModel feedModel);

    /**
     * Feed 삭제
     * @param feedModel
     * @return
     */
    int deleteFeed(FeedModel feedModel);
}
