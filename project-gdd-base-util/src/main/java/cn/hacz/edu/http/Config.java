package cn.hacz.edu.http;

/**
 * 功能模块：调用接口的配置文件
 *
 * @author guo
 * @project SHOP++
 * @version 3.0
 * @time 2017年7月17日
 */
public class Config implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	// 正式环境：http://10.249.8.100:8101/isppreserver/api
	// 测试环境：http://10.9.4.214:7105
	// 本机环境：http://10.9.4.214:7105/etcinsOrder/findAllEtcInsOrder
	public static final String URL = "http://10.9.254.182:7105";
	// ETC预约下单
	public static final String ETCINSADD = URL + "/etcinsOrder/etcInsAdd";
	// 查询ETC预约信息
	public static final String FINDALLETCINSORDER = URL + "/etcinsOrder/findAllEtcInsOrder";
	// 上传图片
	public static final String ETCINSUPLOAD = URL + "/etcinsOrder/etcInsUpload";

}
