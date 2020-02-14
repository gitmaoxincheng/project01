
-- 枚举项信息

-- drop table aptl_datadict_item;
create table aptl_datadict_item
(
    alId                         varchar(10)      not null,
    typeName                     varchar(20)      not null,
    itemName                     varchar(20)      not null,
    itemCnName                   varchar(20)      null,
    dataType                     varchar(20)      null,
    dataEnum                     varchar(50)      null,
    minLen                       number(10, 0)    null,
    maxLen                       number(10, 0)    null,
    extItem                      varchar(50)      null
)
tablespace MID_DAT
;


-- alter table aptl_datadict_item drop constraint aptl_datadict_item_pk;
alter table aptl_datadict_item add constraint aptl_datadict_item_pk primary key (alId, typeName, itemName) using index tablespace MID_IDX;


comment on table  aptl_datadict_item                              is '枚举项信息';
comment on column aptl_datadict_item.alId                         is '应用标识';
comment on column aptl_datadict_item.typeName                     is '类型名称';
comment on column aptl_datadict_item.itemName                     is '项名称';
comment on column aptl_datadict_item.itemCnName                   is '项中文名称';
comment on column aptl_datadict_item.dataType                     is '数据类型';
comment on column aptl_datadict_item.dataEnum                     is '数据枚举';
comment on column aptl_datadict_item.minLen                       is '最小长度';
comment on column aptl_datadict_item.maxLen                       is '最大长度';
comment on column aptl_datadict_item.extItem                      is '扩展项';
