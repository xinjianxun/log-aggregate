# 微服务日志聚合
## 项目简介
项目包含两个微服务log-A及log-B。
1、通过lockback配置logstash appender异步将日志信息同步到logstash，logstash接收日志，并按日期建立索引库，同步索引库到
elestic search。kibana连接elestic search做图形化或通过查询语句查询日志。
2、通过lockback配置数据库appender将日志同步到mysql数据库
3、通过zipkin-server将sleuth聚合的信息进行图形化展示、zipkin-server可以将信息持久化到elestic search中
### 简单架构图
