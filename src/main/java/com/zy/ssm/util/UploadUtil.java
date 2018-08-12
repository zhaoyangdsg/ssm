package com.zy.ssm.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUtil {
	public static boolean uploadFile(HttpServletRequest request,String fileName) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory) ;
		InputStream inputStream = null;
		FileOutputStream fileOutPutStream = null;
		String filePath = null;
		int flag = 0;
		try {
			List<FileItem> fileItems = servletFileUpload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				// 如果不是文件,而是表单文字
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName());
				}else {
					// 是文件
					inputStream = fileItem.getInputStream();
					// 1k的缓存
					byte[] bytes = new byte[1024];
					filePath = request.getContextPath()+"/upload_file/"+fileName;
					File file = new File(filePath);
					fileOutPutStream = new FileOutputStream(file);
					while  (inputStream.read(bytes) != -1) {
						fileOutPutStream.write(bytes);
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
