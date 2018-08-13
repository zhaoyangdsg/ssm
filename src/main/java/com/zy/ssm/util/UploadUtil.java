package com.zy.ssm.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUtil {
	public static Map<String,Object> getParamsOfFormData(HttpServletRequest request) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory) ;
		//解决上传文件名的中文乱码
		servletFileUpload.setHeaderEncoding("UTF-8"); 
		try {
			List<FileItem> fileItems = servletFileUpload.parseRequest(request);
			Map<String,String> params = new HashMap<String,String>();
			Map<String,FileItem> fileItemsMap = new HashMap<String,FileItem>();
			Map<String,Object> paramsAndFile = new HashMap<String,Object>();
			for (FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {
					params.put(fileItem.getFieldName(), fileItem.getString());
				}else {
					fileItemsMap.put(fileItem.getFieldName(), fileItem);
				}
			}
			paramsAndFile.put("params", params);
			paramsAndFile.put("fileItems",fileItemsMap);
			return paramsAndFile;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<FileItem> getFileItems(HttpServletRequest request) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory) ;
		//解决上传文件名的中文乱码
		servletFileUpload.setHeaderEncoding("UTF-8"); 
		try {
			List<FileItem> fileItems = servletFileUpload.parseRequest(request);
			return fileItems;
		}catch (FileUploadException e) {
			e.printStackTrace();
		}
		return new ArrayList<FileItem>();
	}
	
	public static boolean uploadFile(HttpServletRequest request,FileItem fileItem,String fileName) {
		InputStream inputStream = null;
		FileOutputStream fileOutPutStream = null;
		String filePath = null;
		if (fileItem.isFormField()) {
			System.out.println(fileItem.getFieldName());
		}else {
			// 是文件
			try {
				inputStream = fileItem.getInputStream();
				// 1k的缓存
				byte[] bytes = new byte[1024];
				filePath = "/Users/zhaoyang"+request.getContextPath()+"/upload_file/";
				File file = new File(filePath);
//				File parentFile = file.getParentFile();
				if (!file.exists()) {
					file.mkdirs();
				}
//				file.createNewFile();
				fileOutPutStream = new FileOutputStream(filePath+fileName);
				int len=-1;
				while  ( (len = inputStream.read(bytes)) != -1) {
					fileOutPutStream.write(bytes,0,len);
				}
				// 存入数据库的路径
				System.out.println(filePath.substring(filePath.lastIndexOf("/")+1,filePath.length()));
				fileOutPutStream.close();
				inputStream.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public static boolean uploadFile(HttpServletRequest request,String fileName) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory) ;
		//解决上传文件名的中文乱码
		servletFileUpload.setHeaderEncoding("UTF-8"); 
		InputStream inputStream = null;
		FileOutputStream fileOutPutStream = null;
		String filePath = null;
		int flag = 0;
		//3、判断提交上来的数据是否是上传表单的数据
		if(!ServletFileUpload.isMultipartContent(request)){
			//按照传统方式获取数据
			System.out.println("没有文件上传");
			return false;
		}
		try {
			List<FileItem> fileItems = servletFileUpload.parseRequest(request);
			
			for (FileItem fileItem : fileItems) {
				System.out.println(fileItem.getName());
				// 如果不是文件,而是表单文字
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName());
				}else {
					// 是文件
					inputStream = fileItem.getInputStream();
					// 1k的缓存
					byte[] bytes = new byte[1024];
					filePath = "/Users/zhaoyang"+request.getContextPath()+"/upload_file/";
					File file = new File(filePath);
//					File parentFile = file.getParentFile();
					if (!file.exists()) {
						file.mkdirs();
					}
//					file.createNewFile();
					fileOutPutStream = new FileOutputStream(filePath+fileName);
					int len=-1;
					while  ( (len = inputStream.read(bytes)) != -1) {
						fileOutPutStream.write(bytes,0,len);
					}
					// 存入数据库的路径
					System.out.println(filePath.substring(filePath.lastIndexOf("/")+1,filePath.length()));
					fileOutPutStream.close();
					inputStream.close();
					flag = 1;
					
				}
			}
			if (flag==0) {
				return false;
			}else {
				return true;
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
