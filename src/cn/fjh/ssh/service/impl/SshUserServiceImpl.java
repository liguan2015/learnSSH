package cn.fjh.ssh.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.fjh.ssh.dao.SshUserDao;
import cn.fjh.ssh.domain.SshUser;
import cn.fjh.ssh.service.SshUserService;
import cn.fjh.ssh.web.form.SshUserForm;

@Transactional(readOnly = true)
@Service(SshUserService.SERVICE_NAME)
public class SshUserServiceImpl implements SshUserService {
	// 注入DAO层
	@Resource(name = SshUserDao.SERVICE_NAME)
	private SshUserDao sud;

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public void saveSshUser(SshUserForm suf) {
		SshUser su = new SshUser();
		su.setUserName(suf.getUserName());
		su.setUserDate(new Date());
		sud.save(su);
	}

	public List<SshUserForm> findCollectionByCondition(SshUserForm suf) {
		// 组织HQL语句的where条件
		String hqlwhere = "";
		List<String> paramsList = new ArrayList<String>();
		if (suf != null && StringUtils.isNotBlank(suf.getUserName())) {
			hqlwhere += "and o.userName like ?";
			paramsList.add("%" + suf.getUserName() + "%");
		}
		Object[] params = paramsList.toArray();
		// 组织排序语句
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.userID", "desc");
		List<SshUser> list = sud.findCollectionByCondition(hqlwhere, params,
				orderby);
		List<SshUserForm> formList = this.SshUserPoListToVoList(list);
		return formList;
	}

	private List<SshUserForm> SshUserPoListToVoList(List<SshUser> list) {
		List<SshUserForm> formList = new ArrayList<SshUserForm>();
		SshUserForm suf = null;
		for (int i = 0; list != null && i < list.size(); i++) {
			suf = new SshUserForm();
			suf.setUserID(list.get(i).getUserID());
			suf.setUserName(list.get(i).getUserName());
			suf.setUserDate(list.get(i).getUserDate().toString());
			formList.add(suf);
		}
		return formList;
	}

}
