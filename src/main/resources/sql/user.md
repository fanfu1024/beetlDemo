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
insert into user(name,age,create_time)values(#name#,#age#,#createTime#)

createTable
===
CREATE TABLE #text(param0)#(
    #text(param1)# bigint PRIMARY KEY NOT NULL COMMENT '主键id' AUTO_INCREMENT,
    #text(param2)# varchar(255) COMMENT '姓名',
    #text(param3)# int COMMENT '年龄',
    #text(param4)# timestamp DEFAULT current_timestamp COMMENT '创建时间'
);

insertBatch
===
INSERT INTO  sys_teacher
(name,age)
value
@for(user in list){
(#user.name#,#user.age#)
@if(!userLP.last){
,
@}
@}








