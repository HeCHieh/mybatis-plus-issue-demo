package com.example.mybatisplusmockdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomePopUpConfigServiceImpl implements HomePopUpConfigService {
    private final HomePopUpConfigMapper homePopUpConfigMapper;

    @Override
    public Page<HomePopUpConfig> list(PageDTO pageDTO) {
        Page<HomePopUpConfig> page = Page.of(pageDTO.getCurrent(), pageDTO.getLimit());
        Page<HomePopUpConfig> homePopUpConfigPage = this.homePopUpConfigMapper.selectPage(page, null);
        return homePopUpConfigPage;
    }
}
