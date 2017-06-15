package com.StoreDispatchSystem.Model;

import java.util.HashSet;
import java.util.Set;

public class Store {

	private int StoreId;
	private String Pwd;
	private Set<Integer> ApplyId;
	private Set<Integer> RespondId;
	
	public Store()
	{
		StoreId = 0;
		Pwd = "";
		ApplyId = new HashSet<Integer>();
		RespondId = new HashSet<Integer>();
	}
	public Set<Integer> getApplyId() {
		return ApplyId;
	}
	public void setApplyId(Set<Integer> applyId) {
		ApplyId = applyId;
	}
	public Set<Integer> getRespondId() {
		return RespondId;
	}
	public void setRespondId(Set<Integer> respondId) {
		RespondId = respondId;
	}
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		this.Pwd = pwd;
	}
	public String toString(){
		String temp = null;
		temp = "StoreId: " + this.StoreId +'\n' + "pwd: " + this.Pwd + '\n';
		temp += "applyId: ";
		if(!ApplyId.isEmpty() || ApplyId == null)
		{
			for(Integer i : ApplyId)
			{
				temp += i.toString() + ' ';
			}
		}
		temp += '\n' + "respondId: ";
		if(!RespondId.isEmpty() || RespondId == null)
		{
			for(Integer i : RespondId)
			{
				temp += i.toString() + ' ';
			}
		}
		temp += '\n';
		return temp;
	}
}
