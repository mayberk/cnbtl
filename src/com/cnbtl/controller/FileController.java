package com.cnbtl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 *���Դ���file��controller
 *��Ҫ����:
 *1.�ϴ�ͼƬ
 *2.�ϴ�����(������Ƶ)
 * 
 * 
 * @author Mrruan
 *
 */
@Controller
public class FileController {
	
	
	/**
	 * �ϴ�ͼƬ�Ĵ�����
	 * @param img �ϴ���ͼƬ
	 * @return �ϴ���ͼƬ��·��(�������Ŀ��·��)
	 */
	@RequestMapping(value="/uploadimg",method=RequestMethod.POST)
	public String uploadImage(MultipartFile img) {
		//��Ҫ�пմ���
		if(!img.isEmpty()) {
			
		}
		return null;
	}
}
