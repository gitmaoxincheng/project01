
-- base
delete from aptl_datadict_type where alId='APTL' and typeName='base';
delete from aptl_datadict_item where alId='APTL' and typeName='base';
--
insert into aptl_datadict_type values ('APTL', 'base',  '基础');
--
insert into aptl_datadict_item values ('APTL', 'base',  'alId',             '应用标识',         'APTL:A1', '', 4, 10, '');
insert into aptl_datadict_item values ('APTL', 'base',  'enKeywordName',    '英文关键字名称',   'APTL:A1', '', 2, 20, '');
insert into aptl_datadict_item values ('APTL', 'base',  'cnKeywordName',    '中文关键字名称',   'APTL:U1', '', 2, 20, '');
insert into aptl_datadict_item values ('APTL', 'base',  'dataLen',          '数据长度',         'APTL:NI', '', 0, 10, '');
insert into aptl_datadict_item values ('APTL', 'base',  'seqNo',            '序号',             'APTL:NI', '', 0, 10, '');




-- java
delete from aptl_datadict_type where alId='APTL' and typeName='java';
delete from aptl_datadict_item where alId='APTL' and typeName='java';
--
insert into aptl_datadict_type values ('APTL', 'java',  'java');
--
insert into aptl_datadict_item values ('APTL', 'java',  'className',        '类名',             'APTL:A1', '', 2, 200, '');
insert into aptl_datadict_item values ('APTL', 'java',  'classSimpleName',  '类简单名',         'APTL:A1', '', 2, 20,  '');


-- dataDict
delete from aptl_datadict_type where alId='APTL' and typeName='dataDict';
delete from aptl_datadict_item where alId='APTL' and typeName='dataDict';
--
insert into aptl_datadict_type values ('APTL', 'dataDict',  '数据字典');
--
--
insert into aptl_datadict_item values ('APTL', 'dataDict',  'dataType',     '数据类型',         'APTL:A1', '', 0, 20, '');
insert into aptl_datadict_item values ('APTL', 'dataDict',  'dataEnum',     '数据枚举',         'APTL:A1', '', 0, 50, '');
insert into aptl_datadict_item values ('APTL', 'dataDict',  'extItem',      '扩展项',           'APTL:A1', '', 0, 50, '');
insert into aptl_datadict_item values ('APTL', 'dataDict',  'typeName',     '类型名称',         '', '', 0, 0,   'APTL:base:enKeywordName');
insert into aptl_datadict_item values ('APTL', 'dataDict',  'typeCnName',   '类型中文名称',     '', '', 0, 0,   'APTL:base:cnKeywordName');
insert into aptl_datadict_item values ('APTL', 'dataDict',  'itemName',     '项名称',           '', '', 0, 0,   'APTL:base:enKeywordName');
insert into aptl_datadict_item values ('APTL', 'dataDict',  'itemCnName',   '项中文名称',       '', '', 0, 0,   'APTL:base:cnKeywordName');
insert into aptl_datadict_item values ('APTL', 'dataDict',  'minLen',       '最小长度',         '', '', 0, 0,   'APTL:base:dataLen');
insert into aptl_datadict_item values ('APTL', 'dataDict',  'maxLen',       '最大长度',         '', '', 0, 0,   'APTL:base:dataLen');




-- dataEnum
delete from aptl_datadict_type where alId='APTL' and typeName='dataEnum';
delete from aptl_datadict_item where alId='APTL' and typeName='dataEnum';
--
insert into aptl_datadict_type values ('APTL', 'dataEnum',  '数据枚举');
--
--
insert into aptl_datadict_item values ('APTL', 'dataEnum',  'itemCode',     '枚举项代码',       'APTL:A1', '', 0, 2, '');
insert into aptl_datadict_item values ('APTL', 'dataEnum',  'enumName',     '枚举名称',         '', '', 0, 0,   'APTL:base:enKeywordName');
insert into aptl_datadict_item values ('APTL', 'dataEnum',  'enumCnName',   '枚举中文名称',     '', '', 0, 0,   'APTL:base:cnKeywordName');
insert into aptl_datadict_item values ('APTL', 'dataEnum',  'itemName',     '枚举项名称',       '', '', 0, 0,   'APTL:base:enKeywordName');
insert into aptl_datadict_item values ('APTL', 'dataEnum',  'itemCnName',   '枚举项中文名称',   '', '', 0, 0,   'APTL:base:cnKeywordName');

