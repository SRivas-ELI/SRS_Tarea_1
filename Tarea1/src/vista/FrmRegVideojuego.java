package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Videojuego;
import model.VideojuegoModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class FrmRegVideojuego extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtConsola;
	private JTextField txtJugadores;
	private JTextField txtFecha;
	private JButton btnRegistrar;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegVideojuego frame = new FrmRegVideojuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRegVideojuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro Videojuego");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(10, 11, 264, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 52, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(120, 49, 154, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtConsola = new JTextField();
		txtConsola.setBounds(120, 80, 154, 20);
		contentPane.add(txtConsola);
		txtConsola.setColumns(10);
		
		txtJugadores = new JTextField();
		txtJugadores.setBounds(120, 111, 154, 20);
		contentPane.add(txtJugadores);
		txtJugadores.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Consola:");
		lblNewLabel_2.setBounds(10, 83, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cant. Jugadores:");
		lblNewLabel_3.setBounds(10, 114, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(120, 142, 154, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Salida:");
		lblNewLabel_4.setBounds(10, 145, 100, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("(YY-MM-DD)");
		lblNewLabel_5.setBounds(10, 163, 68, 14);
		contentPane.add(lblNewLabel_5);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(10, 204, 95, 23);
		contentPane.add(btnRegistrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(179, 204, 95, 23);
		contentPane.add(btnLimpiar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
	}
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		String vNom, vCon, vFec;
		int vCant;
		
		vNom = txtNombre.getText().trim();
		vCon = txtConsola.getText().trim();
		vFec = txtFecha.getText().trim();
		vCant = Integer.parseInt(txtJugadores.getText().trim());
		
		Videojuego objJuego = new Videojuego();
		objJuego.setNombre(vNom);
		objJuego.setConsola(vCon);
		objJuego.setCantJugador(vCant);
		objJuego.setFechaSaldia(LocalDate.parse(vFec));
		
		VideojuegoModel objVgModel = new VideojuegoModel();
		int insertados = objVgModel.insertaVideojuego(objJuego);
		
		if (insertados > 0) {
			JOptionPane.showMessageDialog(this, "Videojuego registrado correctamente.");
		}
	}
	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		txtNombre.setText("");
		txtConsola.setText("");
		txtJugadores.setText("");
		txtFecha.setText("");
	}
}
