��������ʹ�á�����ؿ�

The server time zone value '?D1��������?����??' is.....��������
��mysql
SHOW VARIABLES LIKE '%time_zone%';
SET GLOBAL time_zone='+8:00';
---------------------------------------------------
��IDE��

����tab��Ϊ4���ո񣬴����н�ֹ���� /tab
����unix�ָ��������ŷ���ֹ/r/n���������Ϊ/r
���ñ���Ϊutf-8
���ذ����Լ���
eclipse��ô���ã�https://blog.csdn.net/qq_35425070/article/details/83829440

�����ϸ�ο���ǰ��thymeleafģ��δ�ṩ�ɿ��ο���










������뼼��ѡ��springboot��
springboot��spring���ø��٣�Լ����������
�����ʣ�Spring + SpringMVC
�־ò㣺
jpa ������ mybatis
�Աȣ�
jpa���������٣�����дSQL					but ���Ӳ�ѯЧ�ʵ� ѧϰ�ɱ����� mybatis
mybatis ���Զ���� ��ѧϰ���ֿ��٣����Զ����Ż�sql���Ż�����	but ������������������ӷ��
����
��Ա����ѧϰ������ǿ������Ҫ����sql�Ż���ѯ����Ҫ����д�����߼����룬ʹ��jpa��������Ч�ʣ��������ѧϰ�ɱ����ѡ��ȫ�Զ����jpa

ǰ�ˣ�
ģ��ʹ��thymeleaf������jsp���Ա���ǰ����룬�������忪��Ч�ʡ�
���ѡ�ͣ�vue��ԭ��ѧϰ�ɱ���������Ա��Ϥ��������Ŀ�����ɱ�����


���ϣ�����ѡ��Ϊspring springMVC springdata jpa + vue��ģ��Ϊthymeleaf 


�������빤�ߡ�
����������	eclipse 	��ѧϰ�ɱ�����Ŀ���ڽ϶̣���Ŀ��С��ʹ����Ϥ��eclipse����δ���յ�idea��
�汾���ƣ� 	Git		��ʵ���Դ���SVN���ҷ�����ʱ�ύ��
����������ˣ�	ali���+Լ��������һ����װʹ�ã���Ա���٣��ɱ�����sonar��
�������ߣ�	maven		����Ա����Ϥmaven������gradle or Ant��
��������:	��		��ֻ��һ���汾��ͬʱ����ѧϰ�ɱ���

���ݿ�		mysql		����Դ�����������Ա���ᣩ

jdk�汾		JDK8		���������ȶ���

����������	��		���ɱ�������







���������������
ǰ�ˣ�
eclipse ��װ ZenCoding(����ֱ����eclipse  http://emmet.io/eclipse/updates/)��
https://blog.csdn.net/lpftobetheone/article/details/17662485
	ZenCoding��ʹ�����������������Ч�ʣ��������ѧϰ�ɱ���
	��װ�����ctrl + d��ͻ�����eclipse -> window -> preferences -> General -> Keys��ȥ�����޸�

��ʹ�á�
thymeleaf���ţ�
���� https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html

���Ѳ��� https://www.cnblogs.com/hjwublog/p/5051732.html
	https://blog.csdn.net/huihuilovei/article/details/64466548
	https://www.cnblogs.com/topwill/p/7434955.html
	
	


���زġ�
http://sc.chinaz.com/moban/
	


�������ַ��
Git https://github.com/ChinaLym/webpractice.git
or  git@github.com:ChinaLym/webpractice.git





�������Ľṹ��(�ο���https://blog.csdn.net/u012675150/article/details/79351990 ��

��Ŀ¼��com.edeclare ---> com.edeclare

1.����������(EdeclareApplication.java)����com.edeclare����

2.ʵ����(entity)����com.edeclare.entity

3.���ݷ��ʲ�(Dao)����com.edeclare.repository

4.���ݷ����(Service)����com,springboot.service,���ݷ����ʵ�ֽӿ�(serviceImpl)����com.edeclare.service.impl

5.ǰ�˿�����(Controller)����com.edeclare.controller

6.������(utils)����com.edeclare.utils

7.�����ӿ���(constant)����com.edeclare.constant

8.������Ϣ��(config)����com.edeclare.config

9.���ݴ�����(vo)����com.edeclare.vo

��Դ�ļ��Ľṹ

��Ŀ¼:src/main/resources

1.�����ļ�(.properties/.json��)����config�ļ�����

2.���ʻ�(i18n))����i18n�ļ�����

3.spring.xml����META-INF/spring�ļ�����

4.ҳ���Լ�js/css/image������static�ļ����µĸ����ļ���