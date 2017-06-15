package com.StoreDispatchSystem.Dao;

import java.sql.*;
import java.util.Iterator;
import java.util.Set;

import com.StoreDispatchSystem.Model.*;


/**
 * ��Ʒ�����ݿ����
 * @author A_stray_wolf
 *
 */
public class WarehouseDao {
	/**
	 * ��ѯ����Ʒ������
	 * @param a
	 * @param ma
	 * @return 0���ݿ���Ϣ�ջ����ݿ�����ʧ��
	 * 		   1��ѯ�ɹ�
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
	 * �޸Ļ�Ʒ�������
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
