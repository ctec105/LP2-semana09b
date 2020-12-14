package demo.accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.recursos.beans.BeanVendedor;
import demo.recursos.util.MySqlDBConn;

public class MySqlVendedorDAO{
	
	public List<BeanVendedor> obtenerPorEstadoCivil(String estado) throws Exception {

		List<BeanVendedor> lista = new ArrayList<BeanVendedor>();
		BeanVendedor bean = null;
		String sql = "SELECT  *  FROM  tb_vendedor where est_civ_ven='" + estado + "'";
		System.out.println("SENTENCIA SQL : " + sql);	

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new BeanVendedor();
				bean.setCodigo(rst.getInt(1));
				bean.setNombre(rst.getString(2));
				bean.setApellido(rst.getString(3));
				bean.setEdad(rst.getInt(4));
				bean.setFecha(rst.getString(5));
				bean.setEstadoCivil(rst.getString(6));
				bean.setDistrito(rst.getString(7));
				lista.add(bean);
			}

			rst.close();
			pstm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return lista;
	}

	public BeanVendedor obtenerPorPK(Integer codigo) throws Exception {
		
		BeanVendedor bean = null;
		String sql = "SELECT  *  FROM  tb_vendedor where cod_ven ='"  + codigo + "'";
		System.out.println("SENTENCIA SQL : " + sql);	
		
		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);

			while (rst.next()) {
				bean = new BeanVendedor();
				bean.setCodigo(rst.getInt(1));
				bean.setNombre(rst.getString(2));
				bean.setApellido(rst.getString(3));
				bean.setEdad(rst.getInt(4));
				bean.setFecha(rst.getString(5));
				bean.setEstadoCivil(rst.getString(6));
				bean.setDistrito(rst.getString(7));
			}

			rst.close();
			pstm.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
		return bean;
		
	}

	public List<BeanVendedor> listarTodos() throws Exception {

		List<BeanVendedor> lista = new ArrayList<BeanVendedor>();
		BeanVendedor bean = null;
		String sql = "SELECT  *  FROM  tb_vendedor ";
		System.out.println("SENTENCIA SQL : " + sql);	

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new BeanVendedor();
				bean.setCodigo(rst.getInt(1));
				bean.setNombre(rst.getString(2));
				bean.setApellido(rst.getString(3));
				bean.setEdad(rst.getInt(4));
				bean.setFecha(rst.getString(5));
				bean.setEstadoCivil(rst.getString(6));
				bean.setDistrito(rst.getString(7));
				lista.add(bean);
			}

			rst.close();
			pstm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return lista;
	}

	public void insertar(BeanVendedor bean) throws Exception {
		
		String sql = 
			"insert into tb_vendedor values(null,'"
					+ bean.getNombre()
					+"','"
					+ bean.getApellido()
					+"','"
					+ bean.getEdad()
					+"','"
					+ bean.getFecha()
					+"','"
					+ bean.getEstadoCivil()
					+"','"
					+ bean.getDistrito()
					+ "')";
		System.out.println("SENTENCIA SQL : " + sql);
		
		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);

			stm.close();
			conn.close();	
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
		
	}

	public void eliminar(Integer codigo) throws Exception {
		String sql = 
			"delete from tb_vendedor where cod_ven='" + codigo +"'";
		System.out.println("SENTENCIA SQL : " + sql);
		
		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);

			stm.close();
			conn.close();	
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
	}
	
	

	public void actualizar(BeanVendedor bean) throws Exception {
		String sql  =
			"update tb_vendedor set nom_ven='"
				+ bean.getNombre()
				+ "',  ape_ven='"
				+ bean.getApellido()
				+ "',  eda_ven='"
				+ bean.getEdad()
				+ "',  fec_nac_ven='"
				+ bean.getFecha()
				+ "',  est_civ_ven='"
				+ bean.getEstadoCivil()
				+ "',  dis_ven='"
				+ bean.getDistrito()
				+ "' where cod_ven='"
				+ bean.getCodigo()
				+ "'";
		System.out.println("SENTENCIA SQL : " + sql);		
		
		Connection conn = null;

		try {
			conn = new MySqlDBConn().getConnection();
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);
	
			stm.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
	}
	
	

	
}
