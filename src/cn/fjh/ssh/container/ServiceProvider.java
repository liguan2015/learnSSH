package cn.fjh.ssh.container;

import org.apache.commons.lang.xwork.StringUtils;

@SuppressWarnings("static-access")
public class ServiceProvider {
	private static ServiceProviderCord spc;
	static {
		// ����beans.xml�ļ�
		spc = new ServiceProviderCord();
		spc.load("beans.xml");
	}

	public static Object getService(String serviceName) {
		if (StringUtils.isBlank(serviceName)) {
			throw new RuntimeException("��ǰ���������Ʋ�����");
		}
		Object object = null;
		if (spc.ac.containsBean(serviceName)) {
			object = spc.ac.getBean(serviceName);
		}
		if (object == null) {
			throw new RuntimeException("��ǰ�������ơ�" + serviceName + "�� �µķ���ڵ㲻����");
		}
		return object;
	}
}
