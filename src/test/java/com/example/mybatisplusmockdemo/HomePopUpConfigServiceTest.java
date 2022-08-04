package com.example.mybatisplusmockdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = MybatisplusMockDemoApplication.class)
public class HomePopUpConfigServiceTest {
    @Autowired
    private HomePopUpConfigService homePopUpConfigService;
    @MockBean
    private HomePopUpConfigMapper homePopUpConfigMapper;


    @Test
    public void testPageList() {
        PageDTO pageDTO = new PageDTO();
        pageDTO.setLimit(10L);
        pageDTO.setCurrent(1L);

        Page<HomePopUpConfig> page = Page.of(pageDTO.getCurrent(), pageDTO.getLimit());
        HomePopUpConfig build = HomePopUpConfig.builder().build();
        page.setRecords(List.of(build));
        page.setTotal(1L);
        page.setPages(1L);
        page.setSize(10L);
        page.setPages(1L);

        given(this.homePopUpConfigMapper.selectPage(page, null)).willReturn(page);

        Page<HomePopUpConfig> pages = this.homePopUpConfigService.list(pageDTO);

        assertEquals(1L, pages.getPages());
        assertEquals(1L, pages.getTotal());
        assertEquals(10L, pages.getSize());
        assertEquals(1L, pages.getPages());
        List<HomePopUpConfig> data = pages.getRecords();
        assertFalse(data.isEmpty());

        verify(homePopUpConfigMapper, times(1))
                .selectPage(page, null);
    }
}
