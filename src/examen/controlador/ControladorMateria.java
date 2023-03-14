package examen.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import examen.modelo.Materia;

public class ControladorMateria {
	
	/**
	 * Método para modificar un registro
	 * @param s
	 * @return
	 */
	public static int modificar(Materia m) {
		int affectedRows = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("update nivelesymaterias.materia set"
					+ " nombre = ?, codigo = ?, urlClassroom = ?, fechaInicio = ?, admiteMatricula = ?"
					+ " where id = " + m.getId());
			ps.setString(1, m.getNombre());
			ps.setString(2, m.getCodigo());
			ps.setString(3, m.getUrl());
			ps.setInt(4, m.getMatricula());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			ps.setString(5, sdf.format(m.getFechaInicio()));
			affectedRows = ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}
	
	/**
	 * Método para obtener un registro
	 * @param str
	 * @return
	 * @throws ParseException 
	 */
	public static Materia getMateria(int id) throws ParseException {
		Materia m = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from nivelesymaterias.materia where id = " + id);
			ResultSet rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				m = new Materia();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setIdNivel(rs.getInt("idNivel"));
				m.setCodigo(rs.getString("codigo"));
				m.setUrl(rs.getString("urlClassroom"));
				m.setMatricula(rs.getInt("admiteMatricula"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				m.setFechaInicio((Date) sdf.parse(rs.getString("fechaInicio")));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	/**
	 * Método para guardar los registros en una lista
	 * @return
	 * @throws ParseException 
	 */
	public static List<Materia> getAll(int id) throws ParseException {
		List<Materia> materias = new ArrayList<Materia>();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from nivelesymaterias.materia where idNivel = " + id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Materia m = new Materia();
				m.setId(rs.getInt(1));
				m.setNombre(rs.getString(2));
				m.setIdNivel(rs.getInt(3));
				m.setCodigo(rs.getString(4));
				m.setUrl(rs.getString(5));
				m.setMatricula(rs.getInt(6));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				m.setFechaInicio((Date) sdf.parse(rs.getString(7)));
				materias.add(m);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return materias;
	}

}
