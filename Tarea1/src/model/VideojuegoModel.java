package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import entity.Videojuego;
import util.MySqlDBConexion;

public class VideojuegoModel {
	public int insertaVideojuego(Videojuego videojuego) {
		int insertados = 0;
			
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "INSERT INTO videojuego(nombre, consola, cantidadJugador, fechaSalida) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, videojuego.getNombre());
			ps.setString(2, videojuego.getConsola());
			ps.setInt(3, videojuego.getCantJugador());
			ps.setDate(4, Date.valueOf(videojuego.getFechaSaldia()));
			
			//Devuelve 1 si inserto o 0 si no.
			insertados = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al insertar el videojuego: " + e.getMessage());
		} finally {
			//Para Cerrar Conexion
			try {
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion: " + e.getMessage());
			}
		}
		
		return insertados;
	}
}
