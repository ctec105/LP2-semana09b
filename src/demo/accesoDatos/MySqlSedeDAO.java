package demo.accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.recursos.beans.BeanSede;
import demo.recursos.util.MySqlDBConn;

public class MySqlSedeDAO {

	public List<BeanSede> obtenerPorEstadoCivil(String estado) throws Exception {
		List<BeanSede> lista = new ArrayList<BeanSede>();
		BeanSede bean = null;
		String sql = "SELECT  *  FROM  tb_sede where dis_sed='" + estado + "'";
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new BeanSede();
				bean.setCodigo(rst.getInt(1));
				bean.setNombre(rst.getString(2));
				bean.setDireccion(rst.getString(3));
				bean.setFecha(rst.getString(4));
				bean.setGerente(rst.getString(5));
				bean.setDistrito(rst.getString(6));
				lista.add(bean);
			}

			rst.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return lista;
	}

	public BeanSede obtenerPorPK(Integer codigo) throws Exception {
		BeanSede bean = null;
		String sql = "SELECT  *  FROM  tb_sede where cod_sed ='" + codigo + "'";
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);

			while (rst.next()) {
				bean = new BeanSede();
				bean.setCodigo(rst.getInt(1));
				bean.setNombre(rst.getString(2));
				bean.setDireccion(rst.getString(3));
				bean.setFecha(rst.getString(4));
				bean.setGerente(rst.getString(5));
				bean.setDistrito(rst.getString(6));
			}

			rst.close();
			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;
	}

	public List<BeanSede> listarTodos() throws Exception {
		List<BeanSede> lista = new ArrayList<BeanSede>();
		BeanSede bean = null;
		String sql = "SELECT  *  FROM  tb_sede ";
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new BeanSede();
				bean.setCodigo(rst.getInt(1));
				bean.setNombre(rst.getString(2));
				bean.setDireccion(rst.getString(3));
				bean.setFecha(rst.getString(4));
				bean.setGerente(rst.getString(5));
				bean.setDistrito(rst.getString(6));
				lista.add(bean);
			}

			rst.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return lista;
	}

	public void insertar(BeanSede bean) throws Exception {
		String sql = "insert into tb_sede values(null,'" + bean.getNombre()
				+ "','" + bean.getDireccion() + "','" + bean.getFecha() + "','"
				+ bean.getGerente() + "','" + bean.getDistrito() + "')";
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);

			stm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public void eliminar(Integer codigo) throws Exception {
		String sql = "delete from tb_sede where cod_sed='" + codigo + "'";
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);

			stm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public void actualizar(BeanSede bean) throws Exception {
		String sql = "update tb_sede set nom_sed='" + bean.getNombre()
				+ "',  dir_sed='" + bean.getDireccion() + "',  fec_ina_sed='"
				+ bean.getFecha() + "',  ger_sed='" + bean.getGerente()
				+ "',  dis_sed='" + bean.getDistrito() + "' where cod_sed='"
				+ bean.getCodigo() + "'";
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);
			stm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

}