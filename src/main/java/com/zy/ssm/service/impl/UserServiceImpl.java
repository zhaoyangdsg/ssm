package com.zy.ssm.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zy.ssm.dao.IUserDao;
import com.zy.ssm.domain.Follow;
import com.zy.ssm.domain.User;
import com.zy.ssm.service.IUserService;
import com.zy.ssm.util.UploadUtil;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	IUserDao userDao;

	@Override
	public User getUserById(Integer id) {
		User user = userDao.getUserById(id);
		if (user != null) {
			return user;
		}
		return null;
	}

	@Override
	public User getUserByMobile(String mobile) {
		User user = userDao.getUserByMobile(mobile);
		if (user != null) {
			return user;
		}
		return null;
	}

	@Override
	public RegistResult registUser(User user) {
		if (userDao.getUserByMobile(user.getMobile()) == null) {
			int row = userDao.addUser(user);
			if (row > 0) {
				return RegistResult.SUCCESS;
			} else {
				return RegistResult.FAILURE;
			}
		}
		return RegistResult.EXSIT;
	}

	public Boolean updateUser(User user) {

		int row = userDao.updateUser(user);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean deleteUser(User user) {
		int row = userDao.deleteUser(user.getId());
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean uploadAvater(HttpServletRequest request) {
		Map<String,Object> paramAndFile = UploadUtil.getParamsOfFormData(request);
		if (paramAndFile != null && paramAndFile.size()>0) {
			Map<String,String> params = (Map<String, String>) paramAndFile.get("params");
			HashMap<String,FileItem> fileItemsMap = (HashMap<String, FileItem>) paramAndFile.get("fileItems"); 
			String userId = params.get("userId");
			String password = params.get("password");
			// id 密码不为空,文件FileItem 不为空
			if (StringUtils.hasText(password) && StringUtils.hasText(userId)&&fileItemsMap.size()>0) {
				User user = userDao.getUserById(Integer.parseInt(userId));
				if (StringUtils.hasText(user.getPassword()) && password.equals(user.getPassword())) {
					String fileName = UUID.randomUUID().toString() + ".jpg";
					FileItem  fileItem = fileItemsMap.get("pic");
					boolean isOK = UploadUtil.uploadFile(request, fileItem, fileName);// .uploadFile(request, fileName);
					System.out.println("isOK "+isOK);
					if (isOK) {
						user.setAvatar(fileName);
						userDao.updateUser(user);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkUser(Integer id,String password) {
		if (id != null && StringUtils.hasText(password)) {
			User user = userDao.getUserById(id);
			if (user != null && StringUtils.hasText(user.getPassword())&& user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	private String getRequestPayload(HttpServletRequest req) {
	     StringBuilder sb = new StringBuilder();
	     try(BufferedReader reader = req.getReader();) {
	          char[]buff = new char[1024];
	          int len;
	          while((len = reader.read(buff)) != -1) {
	              sb.append(buff,0, len);
	          }
	     }catch (IOException e) {
	          e.printStackTrace();
	     }
	     System.out.println(sb.toString());
	     return sb.toString();
	}

	@Override
	public boolean followUser(Integer followedId,Integer userId) {
		Follow follow = new Follow();
		follow.setFollowedId(followedId);
		follow.setUserId(userId);
		if (userDao.checkFollow(follow) > 0) {
			int row = userDao.followUser(follow);
			if (row >0) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean cancelFollowUser(Integer followedId,Integer userId) {
		Follow follow = new Follow();
		follow.setFollowedId(followedId);
		follow.setUserId(userId);
		int row = userDao.cancelFollow(follow);
		if (row >0) {
			return true;
		}
		return false;
	}

}
