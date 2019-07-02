package com.address.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.address.dao.AddressDao;
import com.address.po.Address;
import com.sxt.util.ResultInfo;
import com.util.StringUtil;

//用户点击"管理收货地址", 加载页面, 调用此方法
public class AddressService {
	private AddressDao addressDao = new AddressDao();
	public ResultInfo<List<Address>> findAddress(Integer uid) {
		List<Address> list = addressDao.findListByUserId(uid);
		List<Address> aList =new ArrayList<>();
		for(Address a :list){
			if(a.getIsdefault() ==1){
				//把默认地址放在列表的首位
				aList.add(0, a);
			}else{
				aList.add(a);
			}
		}
		ResultInfo<List<Address>> resultInfo = new ResultInfo<>();
		//锟叫断非匡拷
		if(aList==null||aList.size()<1){
			//锟斤拷锟轿拷锟�
			resultInfo.setCode(0);
			resultInfo.setMsg("加载失败");
		}else{
			//锟斤拷锟斤拷锟轿拷锟�
			resultInfo.setCode(1);
			resultInfo.setResult(aList);
		}
		
		return resultInfo;
	}
	
	
	/*
	 * address.jsp 点击删除地址, 使用此方法
	 * 1  规则 当地址中只存在一条地址, 则允许删除
	 * 2 当地址中多于一条地址  且删除的是默认地址, 提示用户不能删除, 需要指定其他地址为默认
	 */
	public ResultInfo<Address> deleteAddress(String aid, Integer uid) {
		ResultInfo<Address> resultInfo = new ResultInfo<>();
		if(StringUtil.isEmpty(aid)){
			resultInfo.setCode(0);
			resultInfo.setMsg("未成功删除");
			return resultInfo;
		}
		
		//验证aid是否对应默认地址
		try {
			Address address = addressDao.findAddressById(aid);
			if(address.getIsdefault() ==1){
				//当地址为默认, 需要判断当前有几条记录
				Integer records =addressDao.findListByUserId(uid).size();
				//当 记录数大于 1, 删除不成功, 提示失败信息
				if(records >1){
					resultInfo.setCode(0);
					resultInfo.setMsg("请先设置其他地址为默认, 再删除!");
					return resultInfo;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
		int row=addressDao.deleteAddress(aid);
		if(row>0){
			resultInfo.setCode(1);
			resultInfo.setMsg("删除成功!");
			
		}else{
			resultInfo.setCode(0);
			resultInfo.setMsg("删除失败!");
		}
		return resultInfo;
	}
	
	/*
	 * 添加地址时调用, 验证地址唯一
	 */
	public ResultInfo<Address> checkaddress(Integer uid,String address,String aid) {
		ResultInfo<Address> resultInfo=new ResultInfo<>();
		if(StringUtil.isEmpty(address)){
			resultInfo.setCode(0);
			resultInfo.setMsg("添加错误!");
			return resultInfo;
		}
		
		//验证当前地址是否唯一, 如果当前用户 名下其他aid 还有其他地址, 返回对象非空, 地址不唯一
		Address addr=addressDao.checkaddress(address,uid,aid);
		if(addr ==null){
			//地址唯一
			resultInfo.setCode(1);
		}else{
			resultInfo.setCode(0);
			resultInfo.setMsg("重复的地址!");
		}
		
		return resultInfo;
	}
	
	/**
	 * 前台添加和修改地址, 都会调用此方法
	 * 当 aid 为空, 则为添加; 否则为修改
	 * 得到Address 对象, 如果是(被新增或被修改的)
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public ResultInfo<List<Address>> addorupdate(String address, String aid, String isdefault, Integer uid) {
		ResultInfo<List<Address>> resultInfo=new ResultInfo<>();
		//验证用户填写的地址非空
		if(StringUtil.isEmpty(address)){
			resultInfo.setCode(0);
			resultInfo.setMsg("添加错误!");
			return resultInfo;
		}
		
		//验证地址唯一
		ResultInfo<Address> res=checkaddress(uid,address,aid);
		if(res.getCode()== 0){
			resultInfo.setCode(0);
			resultInfo.setMsg("已存在的地址!");
			return resultInfo;
		}
		
		//调用下层执行添加或修改业务
		try {
			resultInfo =addressDao.addorupdate(address,aid,isdefault,uid);
			return resultInfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}


	//修改或添加完成后, 前台回显用户的所有地址信息, 调用此方法查询 Address的集合
	public List<Address> findAddressList(Integer uid) {
		List<Address> list =addressDao.findListByUserId(uid);
		List<Address> aList =new ArrayList<>();
		for(Address a :list){
			if(a.getIsdefault() ==1){
				//把默认地址放在列表的首位
				aList.add(0, a);
			}else{
				aList.add(a);
			}
		}
		return aList;
	}


}
