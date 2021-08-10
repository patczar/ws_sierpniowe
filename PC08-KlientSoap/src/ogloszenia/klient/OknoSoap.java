package ogloszenia.klient;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingWorker;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ogloszenia.wygenerowane.BladBazyDanych_Exception;
import ogloszenia.wygenerowane.NieznanyRekord_Exception;
import ogloszenia.wygenerowane.Samochodowe;
import ogloszenia.wygenerowane.SerwisOgloszeniowy;
import ogloszenia.wygenerowane.SerwisOgloszeniowyService;

public class OknoSoap {
	private SerwisOgloszeniowy port;
	private JFrame frame;
	private JTextField txtTytul;
	private JTextField txtMarka;
	private JTextField txtModel;
	private JTextField txtCena;
	private JSpinner spinner;
	private JLabel lblFoto;
	private Samochodowe biezaceOgloszenie;
	private ImageIcon ikonaZeZdjeciem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OknoSoap window = new OknoSoap();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OknoSoap() {
		SerwisOgloszeniowyService serwis = new SerwisOgloszeniowyService();
		port = serwis.getSerwisOgloszeniowyPort();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 841, 801);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				wyswietl();
			}
		});
		spinner.setFont(new Font("Dialog", Font.BOLD, 22));
		
		JLabel lblPodajIdOgoszenia = new JLabel("Podaj ID ogłoszenia");
		lblPodajIdOgoszenia.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		JButton btnWywietl = new JButton("Wyświetl");
		btnWywietl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				wyswietl();
			}
		});
		btnWywietl.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JPanel panel = new JPanel();
		
		lblFoto = new JLabel("FOTO");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFoto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblPodajIdOgoszenia)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnWywietl))
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPodajIdOgoszenia)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnWywietl))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblFoto, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblTytu = new JLabel("Tytuł");
		lblTytu.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		txtTytul = new JTextField();
		txtTytul.setFont(new Font("Dialog", Font.BOLD, 16));
		txtTytul.setText("tytul");
		txtTytul.setColumns(10);
		
		JLabel lblMarka = new JLabel("Marka");
		lblMarka.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		txtMarka = new JTextField();
		txtMarka.setFont(new Font("Dialog", Font.BOLD, 16));
		txtMarka.setText("marka");
		txtMarka.setColumns(10);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		txtModel = new JTextField();
		txtModel.setFont(new Font("Dialog", Font.BOLD, 16));
		txtModel.setText("model");
		txtModel.setColumns(10);
		
		JLabel lblCena = new JLabel("Cena");
		lblCena.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		txtCena = new JTextField();
		txtCena.setFont(new Font("Dialog", Font.BOLD, 16));
		txtCena.setText("cena");
		txtCena.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblMarka, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTytu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMarka, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
								.addComponent(txtTytul, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblModel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCena))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCena, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
								.addComponent(txtModel, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTytu)
						.addComponent(txtTytul, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarka)
						.addComponent(txtMarka, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModel)
						.addComponent(txtModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCena)
						.addComponent(txtCena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}

	// jest wywoływane przez Swinga po kliknięciu guzika itp.
	// ta metoda jest wykonywana w wątku EDT
	protected void wyswietl() {
		int idOgloszenia = (Integer)spinner.getValue();
		
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				// to wykona się w oddzielnym wątku,
				// nie zablokuj okna, ale tutaj nie powinniśmy korzystać z elementów okna
				pobierzDane(idOgloszenia);
				return null;
			}
			
			@Override
			protected void done() {
				// tu powinniśmy wpisać polecenia dotyczace okna, które mają być wykonane przez EDT po zakończeniu operacji
				uaktualnijWidok();
			}
		};
		worker.execute();
	}

	private void pobierzDane(int idOgloszenia) {
		// ma być wykonane w tle
		try {
			ikonaZeZdjeciem = null;
			biezaceOgloszenie = null;
			biezaceOgloszenie = port.odczytajJednoOgloszenie(idOgloszenia);
			try {
				byte[] bajtyZeZdjeciem = port.foto(idOgloszenia);
				if(bajtyZeZdjeciem != null) {
					ikonaZeZdjeciem = new ImageIcon(bajtyZeZdjeciem);
				}
			} catch (NieznanyRekord_Exception e) {
				// zdjecie zostaje nullem
			}
		} catch (BladBazyDanych_Exception e) {
			e.printStackTrace();
		} catch (NieznanyRekord_Exception e) {
		}
	}
	
	private void uaktualnijWidok() {
		// ma być wykonane przez okno (czyli wątek EDT)
		if(biezaceOgloszenie != null) {
			txtTytul.setText(biezaceOgloszenie.getTytul());
			txtMarka.setText(biezaceOgloszenie.getMarka());
			txtModel.setText(biezaceOgloszenie.getModel());
			txtCena.setText(String.valueOf(biezaceOgloszenie.getCena()));
		} else {
			txtTytul.setText("");
			txtMarka.setText("");
			txtModel.setText("");
			txtCena.setText("");			
		}
		lblFoto.setIcon(ikonaZeZdjeciem);
	}
}
