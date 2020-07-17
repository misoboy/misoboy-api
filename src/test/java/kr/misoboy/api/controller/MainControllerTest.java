package kr.misoboy.api.controller;

import kr.misoboy.api.AbstractSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringJUnitConfig
public class MainControllerTest extends AbstractSpringTest {

    @Resource
    protected MockMvc mockMvc;

    @DisplayName("ut_GET_main_101 : 샘플 메인 목록 테스트")
    @Test
    public void ut_GET_main_101() throws Exception {
        log.debug("ut_GET_main_101 : run test");
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/main/"))
                .andDo(print()).andExpect(status().isOk());
    }
}
