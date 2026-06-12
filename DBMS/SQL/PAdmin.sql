use Insurance;

drop table PolicyType;

create user 'BranchManager' identified by 'BM123';
grant insert, update on Policy to 'BranchManager';
show grants;