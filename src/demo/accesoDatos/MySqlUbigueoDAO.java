package demo.accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.recursos.beans.BeanUbigeo;
import demo.recursos.util.MySqlDBConn;

public class MySqlUbigueoDAO {

	public List<BeanUbigeo> traerDepartamentos() throws Exception {
		List<BeanUbigeo> lista = new ArrayList<BeanUbigeo>();
		BeanUbigeo bean = null;
		String sql = "SELECT distinct idDepartamento, departamento FROM  tb_ubigeo ";
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new BeanUbigeo();
				bean.setIdDepartamento(rst.getInt(1));
				bean.setDepartamento(rst.getString(2));
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

	public List<BeanUbigeo> traerProvincias(Integer idDepartamento) throws Exception {
		List<BeanUbigeo> lista = new ArrayList<BeanUbigeo>();
		BeanUbigeo bean = null;
		String sql = "SELECT distinct idProvincia, provincia FROM  tb_ubigeo where idDepartamento ="
				+ idDepartamento;
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new BeanUbigeo();
				bean.setIdProvincia(rst.getInt(1));
				bean.setProvincia(rst.getString(2));
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

	public List<BeanUbigeo> traerDistritos(Integer idDepartamento,
			Integer idProvincia) throws Exception {
		List<BeanUbigeo> lista = new ArrayList<BeanUbigeo>();
		BeanUbigeo bean = null;
		String sql = "SELECT distinct idDistrito, distrito FROM  tb_ubigeo where idDepartamento="
				+ idDepartamento + " and  idProvincia =" + idProvincia;
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new BeanUbigeo();
				bean.setIdDistrito(rst.getInt(1));
				bean.setDistrito(rst.getString(2));
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

}