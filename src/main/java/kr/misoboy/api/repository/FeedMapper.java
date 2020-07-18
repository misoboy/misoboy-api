package kr.misoboy.api.repository;

import kr.misoboy.api.model.FeedModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {

    /**
     * 사용자 피드 목록 조회
     * @param feedModel
     * @return
     */
    List<FeedModel> selectFeedList(FeedModel feedModel);

    /**
     * 피드 상세 조회
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
