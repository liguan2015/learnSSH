package cn.fjh.ssh.dao;

import cn.fjh.ssh.domain.SshUser;

/**
 * SshUser�Ľӿ�
 * 
 * @author fang jie hui
 * 
 */
public interface SshUserDao extends CommonDao<SshUser> {
	public final static String SERVICE_NAME = "cn.fjh.ssh.dao.impl.SshUserDaoImpl";
}
