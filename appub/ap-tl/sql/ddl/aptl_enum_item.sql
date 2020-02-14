
-- 枚举项信息

-- drop table aptl_enum_item;
create table aptl_enum_item
(
    alId                         varchar(10)      not null,
    enumName                     varchar(20)      not null,
    itemCode                     varchar(2)       not null,
    itemName                     varchar(20)      null,
    itemCnName                   varchar(20)      null,
    seqNo                        number(10, 0)    null
)
tablespace MID_DAT
;


-- alter table aptl_enum_item drop constraint aptl_enum_item_pk;
alter table aptl_enum_item add constraint aptl_enum_item_pk primary key (alId, enumName, itemCode) using index tablespace MID_IDX;


comment on table  aptl_enum_item                              is '枚举项信息';
comment on column aptl_enum_item.alId                         is '应用标识';
comment on column aptl_enum_item.enumName                     is '枚举名称';
comment on column aptl_enum_item.itemCode                     is '枚举项代码';
comment on column aptl_enum_item.itemName                     is '枚举项名称';
comment on column aptl_enum_item.itemCnName                   is '枚举项中文名称';
comment on column aptl_enum_item.seqNo                        is '序号';
