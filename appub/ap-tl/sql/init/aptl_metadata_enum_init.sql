
-- 清理
-- delete from aptl_enum_info where alId='APTL';
-- delete from aptl_enum_item where alId='APTL';


-- Status
delete from aptl_enum_info where alId='APTL' and enumName='Status';
delete from aptl_enum_item where alId='APTL' and enumName='Status';
-- 
insert into aptl_enum_info values ('APTL', 'Status', '状态');
insert into aptl_enum_item values ('APTL', 'Status', 'S', 'SUCCESS',   '成功', 0);
insert into aptl_enum_item values ('APTL', 'Status', 'F', 'FAILURE',   '失败', 1);
insert into aptl_enum_item values ('APTL', 'Status', 'A', 'ABEND',     '异常', 2);


