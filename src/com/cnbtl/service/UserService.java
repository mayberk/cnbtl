package com.cnbtl.service;

import com.cnbtl.entity.User;

public interface UserService {

	/**
	 * �û���¼����
	 * @param username �û���
	 * @param password ����
	 * @return �ɹ�����User
	 */
	User login(String username,String password);
}
