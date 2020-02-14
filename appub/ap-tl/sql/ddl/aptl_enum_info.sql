
-- 枚举信息

-- drop table aptl_enum_info;
create table aptl_enum_info
(
    alId                         varchar(10)      not null,
    enumName                     varchar(20)      not null,
    enumCnName                   varchar(20)      null
)
tablespace MID_DAT
;


-- alter table aptl_enum_info drop constraint aptl_enum_info_pk;
alter table aptl_enum_info add constraint aptl_enum_info_pk primary key (alId, enumName) using index tablespace MID_IDX;


comment on table  aptl_enum_info                              is '枚举信息';
comment on column aptl_enum_info.alId                         is '应用标识';
comment on column aptl_enum_info.enumName                     is '枚举名称';
comment on column aptl_enum_info.enumCnName                   is '枚举中文名称';
