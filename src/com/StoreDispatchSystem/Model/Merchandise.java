package com.StoreDispatchSystem.Model;


/**
 * ��Ʒģ��
 * @author A_stray_wolf
 *
 */
public class Merchandise {
	private int GoodsId;
	private int Amount;
	
	public int getGoodsId() {
		return GoodsId;
	}
	public void setGoodsId(int goodsId) {
		GoodsId = goodsId;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String toString(){
		return "GoodsId: " + GoodsId + '\n' + "Amount: " + Amount + '\n';
	}
}
