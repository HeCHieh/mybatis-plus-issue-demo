package com.example.mybatisplusmockdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface HomePopUpConfigService {
    Page<HomePopUpConfig> list(PageDTO pageDTO);
}
