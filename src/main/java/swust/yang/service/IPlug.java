package swust.yang.service;

import java.util.List;

import swust.yang.entity.PluginInfo;
import swust.yang.entity.ResultMsg;

public interface IPlug {
	/***
	 * 
	 * @param config_info 插件配置信息，JSon格式的字符串
	 * @param file_path  所要执行的文件所在路径（包含文件名）
	 * @param logpath  日志保存路径（不包含文件名）
	 * @description 执行单个文件
	 * @return 返回单个文件的执行结果（日志放在平台指定目录下）
	 */
    ResultMsg singleExecute(String config_info,String file_path,String log_path);
   
    /***
     * 
     * @param config_info  插件配置信息
     * @param src_path  批量执行文件所在目录（不包含文件名）
     * @param dest_path 日志文件和结果分析汇总文件存放目录
     * @return 返回批量执行结果
     * @description 批量执行文件
    */
    List<ResultMsg> batchExecute(String config_info,String src_dir,String dest_path);
    
    /***
     * @param config_info 配置信息（包括：执行参数、分数占比）
     * @param file_path XML文件的保存位置，包含文件后缀名
     * @return 解析平台送回的配置信息，并把解析后的信息送回给平台存储(实现配置信息持久化)，XML格式
     */
    void saveBaseInfo(String config_info,String file_path);
    
    /**
     * 
     * @return 获取插件信息
     */
    PluginInfo getPluginInfo(); 
    
    /***
     * 
     * @param preSetting 之前的配置信息，第一次配置参数置为null
     * @return 返回前端插件配置界面代码
     */
    String getHtml(String preSetting);
}
