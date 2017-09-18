package cn.fjh.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import cn.fjh.ssh.dao.SshUserDao;
import cn.fjh.ssh.domain.SshUser;

/**
 * SshUser的接口实现类
 * 
 * @author fang jie hui
 * 
 */
@Repository(SshUserDao.SERVICE_NAME)
public class SshUserDaoImpl extends CommonDaoImpl<SshUser> implements
		SshUserDao {

}
