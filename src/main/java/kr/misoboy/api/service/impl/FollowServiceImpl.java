package kr.misoboy.api.service.impl;

import kr.misoboy.api.model.FollowModel;
import kr.misoboy.api.repository.FollowMapper;
import kr.misoboy.api.service.FollowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("followService")
public class FollowServiceImpl implements FollowService {

    @Resource(name = "followMapper")
    private FollowMapper followMapper;

    @Override
    public List<FollowModel> selectFollowList(FollowModel followModel) {
        return followMapper.selectFollowList(followModel);
    }

    @Override
    public List<FollowModel> selectFollowerList(FollowModel followModel) {
        return followMapper.selectFollowerList(followModel);
    }

    @Override
    public FollowModel selectFollowDetail(FollowModel followModel) {
        return followMapper.selectFollowDetail(followModel);
    }

    @Override
    public int insertFollow(FollowModel followModel) {
        return followMapper.insertFollow(followModel);
    }

    @Override
    public int updateFollowPermit(FollowModel followModel) {
        return followMapper.updateFollowPermit(followModel);
    }

    @Override
    public int deleteFollow(FollowModel followModel) {
        return followMapper.deleteFollow(followModel);
    }
}
