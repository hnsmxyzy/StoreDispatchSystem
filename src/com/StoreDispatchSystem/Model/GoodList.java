package com.StoreDispatchSystem.Model;

import java.util.Set;
import java.util.Iterator;


/**
 * 货单模型
 * @author A_stray_wolf
 *
 */
public class GoodList {
	private int ListId;
	private int ApplyStoreId;
	private int ReponseStoreId;
	private String ListDate;
	private String ListStatus;
	private Set<Merchandise> Goods;
	
	public Set<Merchandise> getGoods() {
		return Goods;
	}
	public void setGoods(Set<Merchandise> goods) {
		Goods = goods;
	}
	public String getListDate() {
		return ListDate;
	}
	public void setListDate(String listDate) {
		ListDate = listDate;
	}
	public String getListStatus() {
		return ListStatus;
	}
	public void setListStatus(String listStatus) {
		ListStatus = listStatus;
	}
	public int getListId() {
		return ListId;
	}
	public void setListId(int listId) {
		ListId = listId;
	}
	public int getApplyStoreId() {
		return ApplyStoreId;
	}
	public void setApplyStoreId(int applyStoreId) {
		ApplyStoreId = applyStoreId;
	}
	public int getReponseStoreId() {
		return ReponseStoreId;
	}
	public void setReponseStoreId(int reponseStoreId) {
		ReponseStoreId = reponseStoreId;
	}
	public String toString()
	{
		String res = null;
		res = "ListId: " + this.ListId + '\n' + "ApplyStoreId: " + this.ApplyStoreId + '\n' 
				+ "ListDate: " + this.ListDate + '\n' + "ResponseStoreId: " + this.ReponseStoreId + '\n' 
				+ "ListStatus: " + this.ListStatus + '\n';
		Iterator<Merchandise> gi = Goods.iterator();
		while(gi.hasNext())
		{
			Merchandise m1 = gi.next();
			res += m1.getGoodsId() + ":" + m1.getAmount() + '\n';
		}
		return res;
	}
	
}
