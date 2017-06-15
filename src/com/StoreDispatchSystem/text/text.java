package com.StoreDispatchSystem.text;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.StoreDispatchSystem.Dao.ListDao;
import com.StoreDispatchSystem.Dao.StoreDao;
import com.StoreDispatchSystem.Dao.WarehouseDao;
import com.StoreDispatchSystem.Model.GoodList;
import com.StoreDispatchSystem.Model.Merchandise;
import com.StoreDispatchSystem.Model.Store;


public class text {
	public static void main(String[] args)
	{
		/**
		 * 货单数据库操作
		 */
//		int resInf = 0;
//		GoodList g1 = new GoodList();
//		//根据货单号和状态查询货单信息
//		resInf = ListDao.QueryListById(2, g1, 1);
//		if(resInf == 1)
//		{
//			//System.out.println(g1.toString());
//		}
//		else
//		{
//			System.out.println("no register!");
//		}
		
//		//根据申请人ID和状态查询订单
//		Set<GoodList> g2 = new HashSet<GoodList>();
//		resInf = ListDao.QueryListByApplyId(1, g2, -1);
//		if(resInf == 1)
//		{
//			for(GoodList i : g2)
//			{
//				//System.out.println(i.toString());
//			}
//		}
//		else
//		{
//			System.out.println("no register!");
//		}
		
		
//		//根据被申请人ID和状态查询订单
//		Set<GoodList> g3 = new HashSet<GoodList>();
//		resInf = ListDao.QueryListByRespondId(3, g3, -1);
//		if(resInf == 1)
//		{
//			for(GoodList i : g3)
//			{
//				//System.out.println(i.toString());
//			}
//		}
//		else
//		{
//			System.out.println("no register!");
//		}
		
		/**
		 * 门店数据库操作
		 */
//		//身份信息验证及信息提取
//		String[] Inf = new String[1];
//		int rint = 0;
//		Store s1 = new Store();
//		s1.setStoreId(0);
//		s1.setPwd("000");
//		rint = StoreDao.Check(s1, Inf);
		//System.out.println(Inf[0] + '\n' + s1.toString());
		
//		//更改密码
//		String npwd = "000";
//		Store s2 = new Store();
//		s2.setStoreId(1);
//		s2.setPwd("123");
//		rint = StoreDao.UpdatePwd(s2, s2.getPwd(), npwd, Inf);
		//System.out.println(Inf[0] + '\n' + s2.toString());
		
//		//更改门店中申请和被申请的信息
//		int[] applyId = {1,2,3};
//		int[] respondId = {2,4,1};
//		Store s3 = new Store();
//		s3.setStoreId(2);
//		s3.setPwd("000");
//		rint = StoreDao.UpdateApplyInf(s3, applyId, respondId, Inf);
		//System.out.println(Inf[0] + '\n' + s3.toString());
		
		/**
		 * 库存操作
		 */
//		//查询库存货品的数量
//		Set<Merchandise> m1 = new HashSet<Merchandise>();
//		Store s1 = new Store();
//		s1.setStoreId(0);
//		WarehouseDao.QueryGoodsAmount(s1, m1);
//		System.out.println(s1.toString());
//		Iterator<Merchandise> si = m1.iterator();
//		while(si.hasNext())
//		{
//			Merchandise mtemp = si.next();
//			System.out.println(mtemp.toString());
//		}
		
//		//修改货品库的数据
//		Set<Merchandise> m1 = new HashSet<Merchandise>();
//		Store s1 = new Store();
//		s1.setStoreId(0);
//		Merchandise mtemp = new Merchandise(), mtemp1 = new Merchandise();
//		mtemp.setGoodsId(1);
//		mtemp.setAmount(100);
//		m1.add(mtemp);
//		mtemp1.setGoodsId(2);
//		mtemp1.setAmount(29);
//		m1.add(mtemp1);
//		WarehouseDao.UpdateGoodsAmount(s1, m1);
	}
}
