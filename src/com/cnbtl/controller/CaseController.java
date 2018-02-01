package com.cnbtl.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cnbtl.entity.Case;
import com.cnbtl.entity.extra.TitleAndDate;
import com.cnbtl.service.CaseService;

/**
 * case controller ����������ص�����
 * 1.����ҳ�Ż�ȡĳһҳ�����ݺ����ҳ��Ϣ(��һҳ��һҳ,��ǰҳ)
 * 2.���ĳ�����е���ϸ��Ϣ
 * ��̨:
 * 3.����Ա�޸�ĳ������
 * 4.����Ա����һ������
 * 5.����Աɾ��ĳ������
 * 6.����Ա�鿴�����б�
 * 7.����Ա�鿴ĳ����ϸ�İ���
 * 
 * @author Mrruan
 *
 */
@Controller
@RequestMapping(value="/case")
public class CaseController {

	@Autowired
	CaseService caseService;
	
	/**
	 * 
	 */
	@RequestMapping("/allftd")
	@ResponseBody
	public String getAllcase() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
		List<TitleAndDate> rs = new ArrayList<>();
		TitleAndDate titleAndDate;
		//��ȡ����case.
		List<Case> cases = caseService.getAllCase();
		if(cases != null) {
			for (Case case1 : cases) {
				titleAndDate = new TitleAndDate();
				titleAndDate.setTitle(case1.getTitle());
				titleAndDate.setDate(sdf.format(new Date(case1.getDate().getTime())));
				titleAndDate.setId(case1.getId());
				rs.add(titleAndDate);
			}
		}
		//����json,����...
		String rsString = JSON.toJSONString(rs);
		System.out.println("JSON-->" + rsString);
		return rsString;
	}
}
