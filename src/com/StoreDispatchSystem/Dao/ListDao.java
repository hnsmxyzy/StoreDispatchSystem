package com.StoreDispatchSystem.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.StoreDispatchSystem.Model.*;


/**
 * 货单数据库操作
 * @author A_stray_wolf
 *
 */
public class ListDao {
	/**
	 * 根据货单号和状态查询货单信息
	 * @param GoodId
	 * @param gl
	 * @param status
	 * @return 0数据库信息空或数据库链接失败
	 * 		   1查询成功
	 */
	public static int QueryListById(int GoodId, GoodList gl, int status){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = LinkMysql.getDBconnection();
			if(conn == null){
				System.out.println("connection is null");
			}
			String sql="select * from list where listId=?";
			if(status >= 0)
			{
				sql = "select * from list where listId=? and status=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, GoodId);
				ps.setInt(2, status);
			}
			else
			{
				ps = conn.prepareStatement(sql);
				ps.setInt(1, GoodId);
			}
			rs = ps.executeQuery();
			rs.beforeFirst();
			if(!rs.next()){
				return 0;
			}
			
			gl.setListId(rs.getInt("listId"));
			gl.setApplyStoreId(rs.getInt("applyId"));
			gl.setReponseStoreId(rs.getInt("respondId"));
			gl.setListStatus(rs.getString("status"));
			gl.setListDate(rs.getString("date"));
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			int GoodsTypeCount = columnCount-5;
			Set<Merchandise> ma = new HashSet<Merchandise>();
			for(int i = 0; i < GoodsTypeCount; i++)
			{
				int amount = rs.getInt(i+6);
				Merchandise m1 = new Merchandise();
				m1.setGoodsId(i+1);
				m1.setAmount(amount);
				ma.add(m1);
			}
			gl.setGoods(ma);
			return 1;
		} catch (SQLException e) {
			System.out.println("SQL link is fail!");
			return 0;
		}
		finally{LinkMysql.closeDB(conn, ps, rs);}
	}
	
	/**
	 * 根据申请人ID和状态查询订单
	 * @param ApplyId
	 * @param gl
	 * @param status
	 * @return 0数据库信息空或数据库链接失败
	 * 		   1查询成功
	 */
	public static int QueryListByApplyId(int ApplyId, Set<GoodList> gl, int status){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = LinkMysql.getDBconnection();
			if(conn == null){
				System.out.println("connection is null");
			}
			String sql="select * from list where applyId=?";
			if(status >= 0)
			{
				sql = "select * from list where ApplyId=? and status=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, ApplyId);
				ps.setInt(2, status);
			}
			else
			{
				ps = conn.prepareStatement(sql);
				ps.setInt(1, ApplyId);
			}
			rs = ps.executeQuery();
			rs.beforeFirst();
			while(rs.next()){
				GoodList g1 = new GoodList();
				g1.setListId(rs.getInt("listId"));
				g1.setApplyStoreId(rs.getInt("applyId"));
				g1.setReponseStoreId(rs.getInt("respondId"));
				g1.setListStatus(rs.getString("status"));
				g1.setListDate(rs.getString("date"));
				
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				int GoodsTypeCount = columnCount-5;
				Set<Merchandise> ma = new HashSet<Merchandise>();
				for(int i = 0; i < GoodsTypeCount; i++)
				{
					int amount = rs.getInt(i+6);
					Merchandise m1 = new Merchandise();
					m1.setGoodsId(i+1);
					m1.setAmount(amount);
					ma.add(m1);
				}
				g1.setGoods(ma);
				gl.add(g1);
			}
			return 1;
		} catch (SQLException e) {
			System.out.println("SQL link is fail!");
			return 0;
		}
		finally{LinkMysql.closeDB(conn, ps, rs);}
	}
	
	/**
	 * 根据被申请人ID和状态查询订单
	 * @param RespondId
	 * @param gl
	 * @param status
	 * @return 0数据库信息空或数据库链接失败
	 * 		   1查询成功
	 */
	public static int QueryListByRespondId(int RespondId, Set<GoodList> gl, int status){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = LinkMysql.getDBconnection();
			if(conn == null){
				System.out.println("connection is null");
			}
			String sql="select * from list where RespondId=?";
			if(status >= 0)
			{
				sql = "select * from list where RespondId=? and status=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, RespondId);
				ps.setInt(2, status);
			}
			else
			{
				ps = conn.prepareStatement(sql);
				ps.setInt(1, RespondId);
			}
			rs = ps.executeQuery();
			rs.beforeFirst();
			while(rs.next()){
				GoodList g1 = new GoodList();
				g1.setListId(rs.getInt("listId"));
				g1.setApplyStoreId(rs.getInt("applyId"));
				g1.setReponseStoreId(rs.getInt("respondId"));
				g1.setListStatus(rs.getString("status"));
				g1.setListDate(rs.getString("date"));
				
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				int GoodsTypeCount = columnCount-5;
				Set<Merchandise> ma = new HashSet<Merchandise>();
				for(int i = 0; i < GoodsTypeCount; i++)
				{
					int amount = rs.getInt(i+6);
					Merchandise m1 = new Merchandise();
					m1.setGoodsId(i+1);
					m1.setAmount(amount);
					ma.add(m1);
				}
				g1.setGoods(ma);
				gl.add(g1);
			}
			return 1;
		} catch (SQLException e) {
			System.out.println("SQL link is fail!");
			return 0;
		}
		finally{LinkMysql.closeDB(conn, ps, rs);}
	}
}
