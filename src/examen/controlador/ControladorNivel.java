package examen.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examen.modelo.Nivel;

public class ControladorNivel {
	
	/**
	 * Método para guardar los registros en una lista
	 * @return
	 */
	public static List<Nivel> getAll(int id) {
		List<Nivel> niveles = new ArrayList<Nivel>();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from nivelesymaterias.nivel where idCentro = " + id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Nivel n = new Nivel();
				n.setId(rs.getInt(1));
				n.setDescripcion(rs.getString(2));
				n.setIdCentro(rs.getInt(3));
				niveles.add(n);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return niveles;
	}

}
