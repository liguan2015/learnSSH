package cn.fjh.ssh.container;

import org.apache.commons.lang.xwork.StringUtils;

@SuppressWarnings("static-access")
public class ServiceProvider {
	private static ServiceProviderCord spc;
	static {
		// 加载beans.xml文件
		spc = new ServiceProviderCord();
		spc.load("beans.xml");
	}

	public static Object getService(String serviceName) {
		if (StringUtils.isBlank(serviceName)) {
			throw new RuntimeException("当前服务器名称不存在");
		}
		Object object = null;
		if (spc.ac.containsBean(serviceName)) {
			object = spc.ac.getBean(serviceName);
		}
		if (object == null) {
			throw new RuntimeException("当前服务名称【" + serviceName + "】 下的服务节点不存在");
		}
		return object;
	}
}
