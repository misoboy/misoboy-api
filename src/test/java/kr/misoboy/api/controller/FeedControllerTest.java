package kr.misoboy.api.controller;

import kr.misoboy.api.AbstractSpringTest;
import kr.misoboy.api.common.SecurityConst;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringJUnitConfig
@ActiveProfiles("test")
@WithMockUser(roles = {SecurityConst.API_ACCESS_USER_ROLE})
public class FeedControllerTest extends AbstractSpringTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("ut_feed_101 : Feed 목록 조회 테스트")
    @Test
    public void ut_feed_101() throws Exception {
        final String emplyrId = "00000000000000000001";
        mockMvc.perform(MockMvcRequestBuilders
                .get(String.format("/v1/feed/%s", emplyrId))
        ).andDo(print()).andExpect(status().isOk());
    }

    @DisplayName("ut_feed_102 : Feed 상세 조회 테스트")
    @Test
    public void ut_feed_102() throws Exception {
        final String emplyrId = "00000000000000000001";
        final int feedSn = 1;
        mockMvc.perform(MockMvcRequestBuilders
                .get(String.format("/v1/feed/%s/%d", emplyrId, feedSn))
        ).andDo(print()).andExpect(status().isOk());
    }

    @DisplayName("ut_feed_103 : Feed 등록")
    @Test
    public void ut_feed_103() throws Exception {
        final String emplyrId = "00000000000000000001";
        mockMvc.perform(MockMvcRequestBuilders
                .post(String.format("/v1/feed/%s", emplyrId))
                .param("cn", "테스트 피드 내용 입니다.")
        ).andDo(print()).andExpect(status().isOk());
    }

    @DisplayName("ut_feed_104 : Feed 수정 테스트")
    @Test
    public void ut_feed_104() throws Exception {
        final String emplyrId = "00000000000000000001";
        final int feedSn = 1;
        mockMvc.perform(MockMvcRequestBuilders
                .put(String.format("/v1/feed/%s/%d", emplyrId, feedSn))
                .param("cn", "테스트 피드 내용 입니다.")
        ).andDo(print()).andExpect(status().isOk());
    }

    @DisplayName("ut_feed_105 : Feed 삭제 테스트")
    @Test
    public void ut_feed_105() throws Exception {
        final String emplyrId = "00000000000000000001";
        final int feedSn = 1;
        mockMvc.perform(MockMvcRequestBuilders
                .delete(String.format("/v1/feed/%s/%d", emplyrId, feedSn))
        ).andDo(print()).andExpect(status().isOk());
    }
}
