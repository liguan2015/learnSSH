# ssh项目框架搭建总结

## 建立web工程

	1. 导入需要的jar的包
		1. db：连接数据库的驱动包
		2. hibernate：使用hibernate的jar的包
		3. jstl：Java的标准标签库
		4. junit：测试用到的jar包
		5. spring：使用spring的jar包
		6. struts2：使用struts2的jar包
	2. 项目体系分层
		1. container：自定义的spring容器，用于在控制层调用操作业务层
		2. dao：项目的dao层，负责连接数据库的操作
		3. domain：封装实体对象（PO对象），对应连接数据库的映射文件
		4. service：项目service层，负责操作各个功能模块的业务逻辑
		5. util：封装系统使用到的公用类的方法和属性
		6. web.action：系统控制层，负责页面和项目后台的跳转
		7. web.form：封装值对象（VO对象），对应页面传递的表单值的属性
		8. junit：测试类
	3. 配置文件
		1. 放置到src的目录下
			1. beans.xml:spring的配置文件
			2. hibernate.cfg.xml：hibernate的配置文件
			3. struts.xml：struts2的配置文件
## 建立持久层

	1. 在domain中创建持久层对象（PO对象）
	2. 对应JavaBean的PO对象，创建于表的映射文件xxx.hbm.xml文件
	3. 创建连接数据库的hibernate配置文件，hibernate.cfg.xml文件，放置到src目录下
	
## DAO层的搭建
	1. 在dao中，创建xxxDao的接口和公用的接口
	2. 在dao.impl中，创建xxxDao接口和公用接口对应的实现类
	3. 配置spring的配置文件beans.xml文件
## 业务层（service）的搭建
	1. 在service中，创建xxxService的接口
	2. 在service.impl中，创建xxxService接口的实现类
## 控制层（Action）的搭建
	1. 在web.action中，创建xxxAction
	2. 在web.form中，创建xxxForm对象（值对象）
	3. 在web.action中，创建BaseAction类
	4. 在container中，自定义spring的容器（ServiceProviderCord类，ServiceProvider类）
	5. 建立struts的配置文件，放置在src的目录下
	6. 在web.xml文件中添加struts的过滤器
	
## 该项目存在问题
* 本项目采用的Spring 2.5不会在比1.7版本更高的Java JDK上运行.对于Java 8及以上的版本，代码会默认在JDK 1.4 的版本上运行。
* 解决1：升级Spring 版本，说是Spring 大于等于3.2.3的版本才可以支持Java 8 --- 已把spring2.5升级为spring4.3
* 解决2：用JDK 1.7
test