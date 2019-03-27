package swust.yang.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import swust.yang.entity.ConfigInfo;

public class XMLParse {

	/**
	 * 
	 * @param config_info  配置信息
	 * @param file_path  XML文件保存位置（路径 + 文件名 + 文件后缀名）
	 */
	public static void createXML(ConfigInfo config_info,String file_path) {
		    //1、创建一个SAXTransformerFactory一个对象
		    SAXTransformerFactory sf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		    OutputStream in =null;
		    try {
		        //2、通过SAXTransformerFactory创建一个TransformerHandler对象
		        TransformerHandler handler = sf.newTransformerHandler();
		        //3、通过TransformerHandler对象获取Transformer对象(用于设置xml输出的样式和头）
		        Transformer transformer = handler.getTransformer();
		        //设置没有其他的DTD(Document Type Defination 文档类型定义）规范
		        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
		        //设置编码格式，显式的显示在<?xml version="1.0" ?>中
		        transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		        //设置换行
		        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		        //文件输出
		        File file =new File(file_path);
		        //确保file是存在的
		        if(!file.exists()){
		            if(!file.createNewFile()){
		                throw new FileNotFoundException("文件创建失败！");
		            }
		        }
		        //4、创建输出流OutputStream对象
		        in = new FileOutputStream(file);
		        //5、创建流Result对象
		        Result result = new StreamResult(in);
		        //6、关联result，此时有了生成元素的方法（handler提供的方法）和装元素的容器（result对象）
		        handler.setResult(result);
		        //打开文档
		        handler.startDocument();
		        //属性设置
		        AttributesImpl attr = new AttributesImpl();
		        //开始创建元素
		        handler.startElement("", "", "Cpplint", attr);
		        if(config_info.getScore() != null) {
		        	attr.addAttribute("", "", "Value", "", config_info.getScore().toString());
			        handler.startElement("", "", "Score", attr);	
			        handler.endElement("", "", "Score");
			        attr.clear();			        
		        }
		       
		        if(config_info.getNestedLoop() != null && !config_info.getNestedLoop().isEmpty()) {
		        	attr.addAttribute("", "", "Value", "", "true");
		        	handler.startElement("", "", "NestedLoop", attr);	
		        	handler.endElement("", "", "NestedLoop");
		        	attr.clear();
		        }
		        if(config_info.getNestedSelect() != null && !config_info.getNestedSelect().isEmpty()) {
		        	attr.addAttribute("", "", "Value", "", "true");
		        	handler.startElement("", "", "NestedSelect", attr);
		        	handler.endElement("", "", "NestedSelect");
		        	attr.clear();
		        }
		        if(config_info.getFuncAnnotation() != null && !config_info.getFuncAnnotation().isEmpty()) {
		        	attr.addAttribute("", "", "Value", "", "true");
		        	handler.startElement("", "", "FuncAnnotation", attr);
		        	handler.endElement("", "", "FuncAnnotation");
		        	attr.clear();
		        }
		        if(config_info.getVariableName() != null && !config_info.getVariableName().isEmpty()) {
		        	attr.addAttribute("", "", "Value", "", "true");
		        	handler.startElement("", "", "VariableName", attr);
		        	handler.endElement("", "", "VariableName");
		        	attr.clear();
		        }
		        if(config_info.getCheckExtend() != null && !config_info.getCheckExtend().isEmpty()) {
		        	attr.addAttribute("", "", "Value", "", config_info.getCheckExtend());
		        	handler.startElement("", "", "CheckExtend", attr);
		        	handler.endElement("", "", "CheckExtend");
		        	attr.clear();
		        }
		        //结束元素创建
		        handler.endElement("", "", "Cpplint");
		        //关闭文档
		        handler.endDocument();
		    } catch (TransformerConfigurationException e) {
		        e.printStackTrace();
		    } catch (SAXException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }   finally{
		            try {
		                //关闭流
		                in.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		    }

	}
	
}
