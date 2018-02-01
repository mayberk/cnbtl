package com.cnbtl.dao;

import java.util.List;

import com.cnbtl.entity.Case;

public interface CaseDao {
	
	/**
	 * ����һ���µ�case(����)
	 * @param mycase �ҵİ���
	 * @return �Ƿ����ɹ�,����1��ʾ�ɹ�,����0��ʾʧ��
	 */
	int insert(Case mycase);
	
	/**
	 * ���ҵ�ĳһ�������case
	 * @param id case��id
	 * @return ����һ��case����.
	 */
	Case selectById(Integer id);
	
	/**
	 *  ����һ�鰸��.
	 * @param index ���п�ʼ������ֵ
	 * @param end ��������������ֵ
	 * @return һ�鰸�е��б���ʽ
	 */
	List<Case> selectSome(Integer index,Integer end);
	
	/**
	 * �����ܼ�¼����
	 * @return ��¼����
	 */
	Integer selectForCount();
	
	/**
	 * ���±���ĳһ�е�ֵ+һ������
	 * @param colName ����
	 * @param plusNum  Ҫ���ӵ�ֵ
	 * @return �ɹ����µ�����.
	 */
	Integer updateClickPlusOne(Integer id,Integer plusNum);
}