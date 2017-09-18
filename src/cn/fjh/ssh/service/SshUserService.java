package cn.fjh.ssh.service;

import java.util.List;

import cn.fjh.ssh.web.form.SshUserForm;

/**
 * SshUser��ҵ���ӿ�
 * 
 * @author fang jie hui
 * 
 */
public interface SshUserService {
	public final static String SERVICE_NAME = "cn.fjh.ssh.service.impl.SshUserServiceImpl";

	// ����SshUser����
	public void saveSshUser(SshUserForm suf);

	// ������������SshUserForm
	public List<SshUserForm> findCollectionByCondition(SshUserForm suf);
}
