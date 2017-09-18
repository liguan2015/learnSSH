package cn.fjh.ssh.web.action;

import cn.fjh.ssh.container.ServiceProvider;
import cn.fjh.ssh.service.SshUserService;
import cn.fjh.ssh.web.form.SshUserForm;

import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class SshUserAction extends BaseAction implements
		ModelDriven<SshUserForm> {
	// 得到业务层的组件
	@SuppressWarnings("unused")
	private SshUserService sus = (SshUserService) ServiceProvider
			.getService(SshUserService.SERVICE_NAME);

	private SshUserForm suf = new SshUserForm();

	public SshUserForm getModel() {
		return suf;
	}

	public String save() {
		sus.saveSshUser(suf);
		System.out.println(suf.getUserName());
		System.out.println("saving done！");
		return "save";
	}
}
