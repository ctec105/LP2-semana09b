package demo.accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.recursos.beans.BeanProducto;
import demo.recursos.util.MySqlDBConn;

public class MySqlProductoDAO {

	public List<BeanProducto> obtenerCategoria(String estado) throws Exception {
		List<BeanProducto> lista = new ArrayList<BeanProducto>();
		BeanProducto bean = null;
		String sql = "SELECT  *  FROM  tb_producto where cat_pro='" + estado + "'";
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new BeanProducto();
				bean.setCodigo(rst.getInt(1));
				bean.setNombre(rst.getString(2));
				bean.setPrecio(rst.getDouble(3));
				bean.setStock(rst.getInt(4));
				bean.setCategoria(rst.getString(5));
				bean.setFecha(rst.getString(6));
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

	public BeanProducto obtenerPorPK(Integer codigo) throws Exception {
		BeanProducto bean = null;
		String sql = "SELECT  *  FROM  tb_producto where cod_pro ='" + codigo + "'";
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);

			while (rst.next()) {
				bean = new BeanProducto();
				bean.setCodigo(rst.getInt(1));
				bean.setNombre(rst.getString(2));
				bean.setPrecio(rst.getDouble(3));
				bean.setStock(rst.getInt(4));
				bean.setCategoria(rst.getString(5));
				bean.setFecha(rst.getString(6));
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

	public List<BeanProducto> listarTodos() throws Exception {
		List<BeanProducto> lista = new ArrayList<BeanProducto>();
		BeanProducto bean = null;
		String sql = "SELECT  *  FROM  tb_producto ";
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new BeanProducto();
				bean.setCodigo(rst.getInt(1));
				bean.setNombre(rst.getString(2));
				bean.setPrecio(rst.getDouble(3));
				bean.setStock(rst.getInt(4));
				bean.setCategoria(rst.getString(5));
				bean.setFecha(rst.getString(6));
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

	public void insertar(BeanProducto bean) throws Exception {
		String sql = "insert into tb_producto values(null,'" + bean.getNombre()
				+ "','" + bean.getPrecio() + "','" + bean.getStock() + "','"
				+ bean.getCategoria() + "','" + bean.getFecha() + "')";

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
		String sql = "delete from tb_producto where cod_pro='" + codigo + "'";
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

	public void actualizar(BeanProducto bean) throws Exception {
		String sql = "update tb_producto set nom_pro='" + bean.getNombre()
		+ "',  pre_pro='" + bean.getPrecio()
		+ "',  stk_pro='" + bean.getStock()
		+ "',  cat_pro='" + bean.getCategoria()
		+ "',  fec_reg_pro='" + bean.getFecha()
		+ "' where cod_pro='" + bean.getCodigo() + "'";

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

	public List<BeanProducto> obtenerPorFechaRegistro(String fechaIni,
			String fechaFin) throws Exception {
		List<BeanProducto> lista = new ArrayList<BeanProducto>();
		BeanProducto bean = null;
		String sql = "SELECT  * FROM  tb_producto where fec_reg_pro >'"
				+ fechaIni + "' and " + "fec_reg_pro <'" + fechaFin + "'";
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new BeanProducto();
				bean.setCodigo(rst.getInt(1));
				bean.setNombre(rst.getString(2));
				bean.setPrecio(rst.getDouble(3));
				bean.setStock(rst.getInt(4));
				bean.setCategoria(rst.getString(5));
				bean.setFecha(rst.getString(6));
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

	public List<BeanProducto> obtenerPorPrecio(String interPrecio)
			throws Exception {
		String[] var = interPrecio.split(",");
		List<BeanProducto> lista = new ArrayList<BeanProducto>();
		BeanProducto bean = null;
		String sql = null;
		if (var.length == 2)
			sql = "SELECT  *  FROM  tb_producto where pre_pro between'" 
					+ var[0] + "' and '" + var[1] + "'";
		else
			sql = "SELECT  *  FROM  tb_producto where pre_pro > '" + var[0] + "'";
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new BeanProducto();
				bean.setCodigo(rst.getInt(1));
				bean.setNombre(rst.getString(2));
				bean.setPrecio(rst.getDouble(3));
				bean.setStock(rst.getInt(4));
				bean.setCategoria(rst.getString(5));
				bean.setFecha(rst.getString(6));
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