package examen.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examen.modelo.CentroEducativo;

public class ControladorCentroEducativo {
	
	/**
	 * Método para guardar los registros en una lista
	 * @return
	 */
	public static List<CentroEducativo> getAll() {
		List<CentroEducativo> centros = new ArrayList<CentroEducativo>();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from nivelesymaterias.centroeducativo");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CentroEducativo c = new CentroEducativo();
				c.setId(rs.getInt(1));
				c.setDescripcion(rs.getString(2));
				centros.add(c);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return centros;
	}

}
