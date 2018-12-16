package com.edeclare.test;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.druid.pool.DruidDataSource;
import com.edeclare.utils.SpringUtil;

/**
* Type: EdeclareApplicationTests
* Description: 测试类，写测试代码务必遵循 AIR 原则
* @author LYM
* @date Dec 16, 2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EdeclareApplicationTests {

	/**
	 * Title: 测试druid连接池是否生效，若输出为DruidDataSource的toString方法则连接池生效
	 * Description:
	 */
	@Test
	public void contextLoads() {
		 DruidDataSource  proxyBean = SpringUtil.getBean(DruidDataSource.class);
		 System.out.println(proxyBean);
	}

}
