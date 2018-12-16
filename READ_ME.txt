【运行与使用】编码必看
获取最新版：
git clone git@github.com:ChinaLym/webpractice.git


The server time zone value '?D1ú±ê×?ê±??' is.....错误解决：
在mysql
SHOW VARIABLES LIKE '%time_zone%';
SET GLOBAL time_zone='+8:00';
---------------------------------------------------
在IDE中

设置tab变为4个空格，代码中禁止出现 /tab
设置unix分隔符，换号符禁止/r/n，务必设置为/r
设置编码为utf-8
下载阿里规约插件
eclipse怎么设置：https://blog.csdn.net/qq_35425070/article/details/83829440

后端详细参考，前端thymeleaf模板未提供可靠参考！

src
├─main
│  ├─java
│  │  └─com
│  │      └─edeclare
│  │          ├─annotation		注解
│  │          ├─aop			AOP切面
│  │          │  ├─filter		过滤器
│  │          │  └─interceptor	拦截器
│  │          ├─config		配置类
│  │          ├─constant		静态类
│  │          ├─controller		控制器
│  │          ├─entity		实体类
│  │          ├─exception		自定义异常类
│  │          ├─repository		持久层（dao）
│  │          ├─service		业务逻辑层
│  │          │  └─impl		业务逻辑实现类
│  │          ├─servlet		服务程序
│  │          └─utils		工具类
│  └─resources			
│      ├─static			前端仅供参考
│      │  ├─css
│      │  ├─image
│      │  └─js
│      └─templates
│          ├─common
│          ├─message
│          └─search
└─test
    └─java
        └─com
            └─edeclare		测试类
                └─test



【框架与技术选型springboot】
springboot比spring配置更少，约定大于配置
无疑问：Spring + SpringMVC
持久层：
jpa 而不用 mybatis
对比：
jpa：开发快速，无需写SQL					but 复杂查询效率低 学习成本高于 mybatis
mybatis 半自动框架 ，学习上手快速，可以定制优化sql，优化联查	but 开发代码量更大，略显臃肿
分析
组员年轻学习能力较强，不需要定制sql优化查询，需要短期写大量逻辑代码，使用jpa提升开发效率，收益高于学习成本因此选用全自动框架jpa

前端：
模板使用thymeleaf，弃用jsp，以便于前后分离，提升整体开发效率。
框架选型：vue。原因：学习成本（已有组员熟悉，降低项目开发成本）。


综上，技术选型为spring springMVC springdata jpa + vue，模板为thymeleaf 


【环境与工具】
开发环境：	eclipse 	（学习成本，项目周期较短，项目较小，使用熟悉的eclipse优于未掌握的idea）
版本控制： 	Git		（实用性大于SVN，且方便随时提交）
代码质量审核：	ali插件+约定命名（一键安装使用，组员较少，成本低于sonar）
包管理工具：	maven		（组员均熟悉maven，不用gradle or Ant）
持续集成:	无		（只有一个版本，同时考虑学习成本）

数据库		mysql		（开源免费主流，组员均会）

jdk版本		JDK8		（主流，稳定）

其他技术：	无		（成本不符）







【其他开发插件】
前端：
eclipse 安装 ZenCoding(或者直接在eclipse  http://emmet.io/eclipse/updates/)：
https://blog.csdn.net/lpftobetheone/article/details/17662485
	ZenCoding（使用起来大大提升开发效率，收益高于学习成本）
	安装完后与ctrl + d冲突解决：eclipse -> window -> preferences -> General -> Keys，去掉或修改

【使用】
thymeleaf入门：
官网 https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html

网友博客 https://www.cnblogs.com/hjwublog/p/5051732.html
	https://blog.csdn.net/huihuilovei/article/details/64466548
	https://www.cnblogs.com/topwill/p/7434955.html
	
	


【素材】
http://sc.chinaz.com/moban/
	


【管理地址】
Git https://github.com/ChinaLym/webpractice.git
or  git@github.com:ChinaLym/webpractice.git





【代码层的结构】(参考：https://blog.csdn.net/u012675150/article/details/79351990 ）

根目录：com.edeclare ---> com.edeclare

1.工程启动类(EdeclareApplication.java)置于com.edeclare包下

2.实体类(entity)置于com.edeclare.entity

3.数据访问层(Dao)置于com.edeclare.repository

4.数据服务层(Service)置于com,springboot.service,数据服务的实现接口(serviceImpl)至于com.edeclare.service.impl

5.前端控制器(Controller)置于com.edeclare.controller

6.工具类(utils)置于com.edeclare.utils

7.常量接口类(constant)置于com.edeclare.constant

8.配置信息类(config)置于com.edeclare.config

9.数据传输类(vo)置于com.edeclare.vo

资源文件的结构

根目录:src/main/resources

1.配置文件(.properties/.json等)置于config文件夹下

2.国际化(i18n))置于i18n文件夹下

3.spring.xml置于META-INF/spring文件夹下

4.页面以及js/css/image等置于static文件夹下的各自文件下