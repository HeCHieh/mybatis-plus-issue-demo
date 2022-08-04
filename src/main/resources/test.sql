create table home_pop_up_config
(
    id                 bigint auto_increment comment '主键'
        primary key,
    pop_up_name        varchar(50)                        not null comment '弹窗名称 ',
    create_time        datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time        datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
);
