select
  ===
  select * from user where 1=1
  @if(!isEmpty(age)){
  and age = #age#
  @}
  @if(!isEmpty(name)){
  and name = #name#
  @}

insert
===
insert into user(name,age)values(#name#,#age#)

createTable
===
CREATE TABLE #text(tableName)#(
    #text(id)# bigint PRIMARY KEY NOT NULL COMMENT '主键id' AUTO_INCREMENT,
    #text(name)# varchar(255) COMMENT '姓名',
    #text(age)# int COMMENT '年龄',
    #text(create_time)# timestamp DEFAULT current_timestamp COMMENT '创建时间'
);

insertBatch
===
INSERT INTO  #text(param0)# 
(#text(param1)#, #text(param2)#)
value(#name#,#age#)




