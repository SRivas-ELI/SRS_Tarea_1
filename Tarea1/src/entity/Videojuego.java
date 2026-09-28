package entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Videojuego {
	private int idJuego, cantJugador;
	private String nombre, consola;
	private LocalDate fechaSaldia;
}