create user 'bull'@'localhost' identified by 'pw_bull';
create user 'bull'@'%' identified by 'pw_bull';
grant all privileges on *.* to 'bull'@'localhost' ;
grant all privileges on *.* to 'bull'@'%' ;

