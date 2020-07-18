package kr.misoboy.api.service.impl;

import kr.misoboy.api.model.FeedModel;
import kr.misoboy.api.repository.FeedMapper;
import kr.misoboy.api.service.FeedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("feedService")
public class FeedServiceImpl implements FeedService {

    @Resource(name = "feedMapper")
    private FeedMapper feedMapper;

    @Override
    public List<FeedModel> selectFeedList(FeedModel feedModel) {
        return feedMapper.selectFeedList(feedModel);
    }

    @Override
    public FeedModel selectFeedDetail(FeedModel feedModel) {
        return feedMapper.selectFeedDetail(feedModel);
    }

    @Override
    public int insertFeed(FeedModel feedModel) {
        return feedMapper.insertFeed(feedModel);
    }

    @Override
    public int updateFeed(FeedModel feedModel) {
        return feedMapper.updateFeed(feedModel);
    }

    @Override
    public int deleteFeed(FeedModel feedModel) {
        return feedMapper.deleteFeed(feedModel);
    }
}
