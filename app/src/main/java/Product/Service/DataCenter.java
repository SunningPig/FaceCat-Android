/*
 * FaceCat图形通讯框架(非开源)
 * 著作权编号:2015SR229355+2020SR0266727
 * 上海卷卷猫信息技术有限公司
 */

package Product.Service;

import android.os.Environment;

import java.io.File;

import facecat.topin.core.FCFile;
import facecat.topin.service.FCClientService;
import topin.facecat.FaceCat.MainActivity;

/**
 处理行情数据

 */
public class DataCenter
{
	/**
	 程序路径

	 */
	private static String m_appPath;

	/**
	 获取程序路径

	 @return 程序路径
	 */
	public static String getAppPath()
	{
		return m_appPath;
	}

	private static String packageName = "";

	/**
	 获取用户目录

	 @return 用户目录
	 */
	public static String getUserPath()
	{
		if(packageName.length() == 0) {
			packageName = MainActivity.m_mainActivity.getPackageName();
		}
		File file = Environment.getExternalStorageDirectory();
		return file.getAbsolutePath() + "/Android/data/"+ packageName + "/files";
	}

	/**
	 设置程序路径

	 @param appPath 程序路径
	 */
	public static void setAppPath(String appPath)
	{
		m_appPath = appPath;
	}


	public static void startService()
	{

	}
}