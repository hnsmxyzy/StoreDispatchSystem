package com.StoreDispatchSystem.Dao;

import java.sql.*;
import java.util.Iterator;
import java.util.Set;

import com.StoreDispatchSystem.Model.*;


/**
 * 货品库数据库操作
 * @author A_stray_wolf
 *
 */
public class WarehouseDao {
	/**
	 * 查询库存货品的数量
	 * @param a
	 * @param ma
	 * @return 0数据库信息空或数据库链接失败
	 * 		   1查询成功
	 */
	public static int QueryGoodsAmount(Store a, Set<Merchandise> ma){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = LinkMysql.getDBconnection();
			if(conn == null){
				System.out.println("connection is null");
			}
			String sql="select * from goods where storeId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getStoreId());
			rs = ps.executeQuery();
			rs.beforeFirst();
			if(!rs.next()){
				return 0;
			}
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			int GoodsTypeCount = columnCount-1;
			for(int i = 0; i < GoodsTypeCount; i++)
			{
				int amount = rs.getInt(i+2);
				Merchandise m1 = new Merchandise();
				m1.setGoodsId(i+1);
				m1.setAmount(amount);
				ma.add(m1);
			}
			return 1;
		} catch (SQLException e) {
			System.out.println("SQL link is fail!");
			return 0;
		}
		finally{LinkMysql.closeDB(conn, ps, rs);}
	}
	
	/**
	 * 修改货品库的数据
	 * @param a
	 * @param ma
	 * @return
	 * @throws SQLException 
	 */
	public static int UpdateGoodsAmount(Store a, Set<Merchandise> ma){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = LinkMysql.getDBconnection();
			if(conn == null){
				System.out.println("connection is null");
			}
			String sql="select * from goods where storeId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getStoreId());
			rs = ps.executeQuery();
			rs.beforeFirst();
			if(!rs.next()){
				return 0;
			}
			
			sql = "update goods set ";
			Iterator<Merchandise> mi = ma.iterator();
			StringBuffer sbuf = new StringBuffer();
			while(mi.hasNext())
			{
				Merchandise mtemp = mi.next();
				sbuf.append("n" + mtemp.getGoodsId() + "=" + mtemp.getAmount() + ",") ;
			}
			sbuf.deleteCharAt(sbuf.length()-1);
			sbuf.append(" where storeId=" + a.getStoreId());
			sql += sbuf.toString();
			System.out.println(sql);

			ps = conn.prepareStatement(sql);
			
			int rsInf = 0;
			rsInf = ps.executeUpdate();
			if(rsInf == 0)
			{
				return 0;
			}
			else
			{
				return 1;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
		finally{LinkMysql.closeDB(conn, ps, rs);}
	}
}
