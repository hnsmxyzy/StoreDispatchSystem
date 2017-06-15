package com.StoreDispatchSystem.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.StoreDispatchSystem.Model.*;


/**
 * �ŵ����ݿ����
 * @author A_stray_wolf
 *
 */
public class StoreDao {
	/**
	 * �����Ϣ��֤����Ϣ��ȡ
	 * @param s1
	 * @return 	110���ݿ�����ʧ��
	 * 			111û�м�¼
	 * 			1�����ɹ�
	 * 			0����ʧ��
	 * @throws Exception
	 */
	public static int Check(Store s1, String[] resInf){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Store s2 = new Store();
		try{
			conn = LinkMysql.getDBconnection();
			if(conn == null){
				resInf[0] = "SQL link is failed!";
				return 110;
			}
			String sql="select * from store where storeId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, s1.getStoreId());
			rs=ps.executeQuery();
			
			rs.beforeFirst();
			if(!rs.next()){ 
				resInf[0] = "account is invalid!";
				return 111;
			}
			else{
					s2.setStoreId(rs.getInt("storeId"));
					String xpwd = rs.getString("password");
					s2.setPwd(xpwd);
					String x = s2.getPwd();
					s1.setApplyId(StringToSet(rs.getString("applyId"), "[+]"));
					s1.setRespondId(StringToSet(rs.getString("respondId"), "[+]"));
					if(x.equals(s1.getPwd())){
						resInf[0] = "password is right";
						return 1;
					}
					else{
						resInf[0] = "password is wrong";
						return 0;
					}
				}
			}catch(SQLException e){
				System.out.println("SQL link is fail!");
				return 0;
			}
		finally{LinkMysql.closeDB(conn, ps, rs);}
	}
	
	/**
	 * ��������
	 * @param s1
	 * @return  110���ݿ�����ʧ��
	 * 			111û�м�¼
	 * 			1�����ɹ�
	 * 			0����ʧ��
	 * @throws Exception
	 */
	public static int UpdatePwd(Store s1, String op, String np, String[] resInf){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Store s2 = new Store();
		try{
			conn = LinkMysql.getDBconnection();
			if(conn == null){
				resInf[0] = "SQL link is fail!";
				return 110;
			}
			String sql="select * from store where storeId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, s1.getStoreId());
			rs=ps.executeQuery();
			
			rs.beforeFirst();
			if(!rs.next()){ 
				resInf[0] = "acount is invalid!";
				return 111;
			}
			else{
					s2.setStoreId(rs.getInt("storeId"));
					String xpwd = rs.getString("password");
					s2.setPwd(xpwd);
					String x = s2.getPwd();
					s1.setApplyId(StringToSet(rs.getString("applyId"), "[+]"));
					s1.setRespondId(StringToSet(rs.getString("respondId"), "[+]"));
					if(x.equals(op)){
						int inf = 0;
						sql="update store set password=? where storeId=?";
						ps = conn.prepareStatement(sql);
						ps.setString(1, np);
						ps.setInt(2, s1.getStoreId());
						inf = ps.executeUpdate();
						if(inf == 0)
						{
							resInf[0] = "change failed!";
							return 0;
						}
						else
						{
							s1.setPwd(np);
							resInf[0] = "change success";
							return 1;
						}
					}
					else{
						resInf[0] = "old password is wrong!";
						return 0;
					}
				}
			}catch(SQLException e){
				System.out.println("SQL link is fail!");
				return 0;
			}
		finally{LinkMysql.closeDB(conn, ps, rs);}
	}
	
	/**
	 * �����ŵ�������ͱ��������Ϣ
	 * @param s1
	 * @param apply
	 * @param resp
	 * @return	110���ݿ�����ʧ��
	 * 			111û�м�¼
	 * 			1�����ɹ�
	 * 			0����ʧ��
	 * @throws Exception
	 */
	public static int UpdateApplyInf(Store s1, int apply[], int resp[], String[] resultInf){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Store s2 = new Store();
		try{
			conn = LinkMysql.getDBconnection();
			if(conn == null){
				resultInf[0] = "SQL link is failed!";
				return 110;
			}
			
			String sql="select * from store where storeId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, s1.getStoreId());
			rs=ps.executeQuery();
			
			rs.beforeFirst();
			if(!rs.next()){ 
				resultInf[0] = "account is invalid!";
				return 111;
			}
			
			String appInf = null, resInf = null;
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < apply.length; i++)
			{
				sb.append(apply[i]);
				sb.append("+");
			}
			sb.deleteCharAt(sb.length()-1);
			appInf = sb.toString();
			sb.delete(0, sb.length());
			for(int i = 0; i < resp.length; i++)
			{
				sb.append(resp[i]);
				sb.append("+");
			}
			sb.deleteCharAt(sb.length()-1);
			resInf = sb.toString();
			sb.delete(0, sb.length()-1);
			
			sql="update store set applyId=?, respondId=? where storeId=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, appInf);
			ps.setString(2, resInf);
			ps.setInt(3, s1.getStoreId());
			int reinf = ps.executeUpdate();
			
			if(reinf == 0){ 
				resultInf[0] = "change faild!";
				return 0;
			}
			else{
				s1.setApplyId(StringToSet(appInf, "[+]"));
				s1.setRespondId(StringToSet(resInf, "[+]"));
				resultInf[0] = "change success";
				return 1;
			}
		}catch(SQLException e){
			System.out.println("SQL link is fail!");
			return 0;
		}
		finally{LinkMysql.closeDB(conn, ps, rs);}
	}
	
	/**
	 * String����->Set<Integer>
	 * @param a
	 * @param b
	 * @return
	 */
	public static Set<Integer> StringToSet(String a, String b)
	{
		Set<Integer> temp = new HashSet<Integer>();
		if(a.isEmpty() || a == null)
		{
			return temp;
		}
		String[] stemp = a.split(b);
		for(int i = 0; i < stemp.length; i++)
		{
			temp.add(Integer.parseInt(stemp[i]) );
		}
		return temp;
	}
}
