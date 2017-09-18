package cn.fjh.ssh.service;

import java.util.List;

import cn.fjh.ssh.web.form.SshUserForm;

/**
 * SshUser的业务层接口
 * 
 * @author fang jie hui
 * 
 */
public interface SshUserService {
	public final static String SERVICE_NAME = "cn.fjh.ssh.service.impl.SshUserServiceImpl";

	// 保存SshUser对象
	public void saveSshUser(SshUserForm suf);

	// 根据条件查找SshUserForm
	public List<SshUserForm> findCollectionByCondition(SshUserForm suf);
}
