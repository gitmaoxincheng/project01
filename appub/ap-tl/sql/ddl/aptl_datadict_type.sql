
-- 枚举项信息

-- drop table aptl_datadict_type;
create table aptl_datadict_type
(
    alId                         varchar(10)      not null,
    typeName                     varchar(20)      not null,
    typeCnName                   varchar(20)      null
)
tablespace MID_DAT
;


-- alter table aptl_datadict_type drop constraint aptl_datadict_type_pk;
alter table aptl_datadict_type add constraint aptl_datadict_type_pk primary key (alId, typeName) using index tablespace MID_IDX;


comment on table  aptl_datadict_type                              is '枚举项信息';
comment on column aptl_datadict_type.alId                         is '应用标识';
comment on column aptl_datadict_type.typeName                     is '类型名称';
comment on column aptl_datadict_type.typeCnName                   is '类型中文名称';
