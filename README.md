# tensquare

《十次方》是程序员的专属社交平台，包括头条、问答、活动、交友、吐槽、招聘六大 频道。<br>
根据页面导航index.html，完成对应的功能<br>
采用的分库分表设计，每个业务模块为1个独立的数据库。 <br>
tensquare_base 基础 <br> tensquare_friend 交友 <br> tensquare_gathering 活动 <br> tensquare_qa 问答 <br> tensquare_recruit 招聘  <br>tensquare_user 用户 <br> tensquare_spit 吐槽 <br>
<br>
![](https://2018cqu.oss-cn-beijing.aliyuncs.com/tens.png)
<br>

《十次方》采用前后端分离的系统架构，后端架构为： SpringBoot+SpringCloud+SpringMVC+SpringData<br>
<br>
![](https://2018cqu.oss-cn-beijing.aliyuncs.com/tens2.png)
<br>
数据库采用mysql和mongoDB(主要用于存储吐槽和评论）<br>
<br>
![](https://2018cqu.oss-cn-beijing.aliyuncs.com/tens3.png)
<br>
利用redis进行缓存；<br>
利用rabbitMq完成异步短信验证码校验功能；<br>
微服务之间调用：<br>
&emsp;&emsp;交友微服务 添加好友，在交友微服务中调用用户微服务的更改粉丝数与关注数的方法。<br>



