package waluty.wersja_json;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class PrzelicznikWalutOkno {
	
	private static final Font FONT_LABEL = new Font("Times New Roman", Font.PLAIN, 24);
	private static final Font FONT_WARTOSC = new Font("Dialog", Font.BOLD, 24);
	private static final Font FONT_TXT = new Font("Dialog", Font.BOLD, 32);
	private static final Font FONT_WYNIK = new Font("Dialog", Font.BOLD, 32);	
	private static final Font FONT_BUTTON = new Font("Dialog", Font.BOLD, 28);

	private Tabela tabela = null;
	private JFrame frmPrzelicznikWalut;
	private JTextField txtKwota;
	private JComboBox<String> comboBox_Waluta;
	private JLabel lbl_KodWaluty;
	private JLabel lbl_NazwaWaluty;
	private JLabel lbl_KursWaluty;
	private JRadioButton rdbtnWalutaNaZlote;
	private JRadioButton rdbtnZloteNaWalute;
	private JButton btnPrzelicz;
	private JLabel lblPrawdziwyWynik;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel_1;
	private JLabel lblTabela;
	private JLabel lbl_NumerTabeli;
	private JLabel lblData;
	private JLabel lbl_DataTabeli;
	private JTextField txtData;
	private JButton btnPobierzAktualne;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrzelicznikWalutOkno window = new PrzelicznikWalutOkno();
					window.txtData.setText(LocalDate.now().toString());
					window.frmPrzelicznikWalut.setVisible(true);
					window.pobierzAktualneKursy();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrzelicznikWalutOkno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrzelicznikWalut = new JFrame();
		frmPrzelicznikWalut.setTitle("Przelicznik Walut");
		frmPrzelicznikWalut.setBounds(100, 100, 480, 701);
		frmPrzelicznikWalut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblWybierzWalut = new JLabel("Wybierz walutę");
		lblWybierzWalut.setFont(FONT_LABEL);
		
		comboBox_Waluta = new JComboBox<>();
		comboBox_Waluta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				wyswietlDaneWaluty();
			}
		});
		comboBox_Waluta.setModel(
				new DefaultComboBoxModel<>(new String[] {"--"}));
		
		comboBox_Waluta.setFont(FONT_WARTOSC);
		
		JPanel panel = new JPanel();
		
		txtKwota = new JTextField();
		txtKwota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				przelicz();
			}
		});
		txtKwota.setText("100");
		txtKwota.setColumns(10);
		txtKwota.setFont(FONT_TXT);
		
		JLabel lblPodajKwot = new JLabel("Podaj kwotę");
		lblPodajKwot.setFont(FONT_LABEL);
		
		rdbtnWalutaNaZlote = new JRadioButton("waluta na złote");
		rdbtnWalutaNaZlote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				przelicz();
			}
		});
		rdbtnWalutaNaZlote.setFont(FONT_LABEL);
		
		buttonGroup.add(rdbtnWalutaNaZlote);
		
		rdbtnZloteNaWalute = new JRadioButton("złote na walute");
		rdbtnZloteNaWalute.setFont(FONT_LABEL);
		rdbtnZloteNaWalute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				przelicz();
			}
		});
		buttonGroup.add(rdbtnZloteNaWalute);
		
		btnPrzelicz = new JButton("Przelicz");
		btnPrzelicz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				przelicz();
			}
		});
		btnPrzelicz.setFont(FONT_BUTTON);
		
		JLabel lblWynik = new JLabel("Wynik");
		lblWynik.setFont(FONT_LABEL);
		
		lblPrawdziwyWynik = new JLabel("0.00");
		lblPrawdziwyWynik.setFont(FONT_WYNIK);
		lblPrawdziwyWynik.setForeground(Color.GRAY);
		
		panel_1 = new JPanel();
		
		JLabel lblPodajDat = new JLabel("Podaj datę");
		lblPodajDat.setFont(FONT_LABEL);
		
		txtData = new JTextField();
		txtData.setHorizontalAlignment(SwingConstants.CENTER);
		txtData.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtData.setText("data");
		txtData.setColumns(10);
		
		JButton btnZmieDat = new JButton("Zmień datę");
		btnZmieDat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pobierzKursyDlaDaty();
			}
		});
		btnZmieDat.setFont(new Font("Dialog", Font.BOLD, 18));
		
		btnPobierzAktualne = new JButton("Pobierz aktualne");
		btnPobierzAktualne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pobierzAktualneKursy();
			}
		});
		btnPobierzAktualne.setFont(new Font("Dialog", Font.BOLD, 18));
		
		GroupLayout groupLayout = new GroupLayout(frmPrzelicznikWalut.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
						.addComponent(btnPrzelicz, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(rdbtnWalutaNaZlote)
							.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
							.addComponent(rdbtnZloteNaWalute))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblPodajKwot)
							.addPreferredGap(ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
							.addComponent(txtKwota, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
						.addComponent(lblWynik, Alignment.LEADING)
						.addComponent(lblPrawdziwyWynik, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblPodajDat, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblWybierzWalut, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtData, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
								.addComponent(comboBox_Waluta, 0, 207, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPobierzAktualne, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(btnZmieDat, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPodajDat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnZmieDat)
						.addComponent(btnPobierzAktualne, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_Waluta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWybierzWalut))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtKwota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPodajKwot))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnWalutaNaZlote)
						.addComponent(rdbtnZloteNaWalute))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPrzelicz)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblWynik)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPrawdziwyWynik)
					.addGap(33))
		);
		
		lblTabela = new JLabel("Tabela");
		lblTabela.setFont(FONT_LABEL);
		
		lbl_NumerTabeli = new JLabel("?");
		lbl_NumerTabeli.setFont(new Font("Dialog", Font.BOLD, 24));
		
		lblData = new JLabel("Data:");
		lblData.setFont(FONT_LABEL);
		
		lbl_DataTabeli = new JLabel("?");
		lbl_DataTabeli.setFont(new Font("Dialog", Font.BOLD, 24));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblTabela, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lbl_NumerTabeli, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblData, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lbl_DataTabeli, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTabela, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_NumerTabeli, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblData, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_DataTabeli, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblKod = new JLabel("Kod:");
		lblKod.setFont(FONT_LABEL);
		
		JLabel lblNazwa = new JLabel("Nazwa:");
		lblNazwa.setFont(FONT_LABEL);
		
		JLabel lblKurs = new JLabel("Kurs:");
		lblKurs.setFont(FONT_LABEL);
		
		lbl_KodWaluty = new JLabel("kod");
		lbl_KodWaluty.setFont(FONT_WARTOSC);
		
		lbl_NazwaWaluty = new JLabel("nazwa");
		lbl_NazwaWaluty.setFont(FONT_WARTOSC);
		
		lbl_KursWaluty = new JLabel("1.0000");
		lbl_KursWaluty.setFont(FONT_WARTOSC);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblKurs, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNazwa, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblKod, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_KodWaluty, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addComponent(lbl_NazwaWaluty, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addComponent(lbl_KursWaluty, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKod)
						.addComponent(lbl_KodWaluty))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNazwa)
						.addComponent(lbl_NazwaWaluty))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKurs)
						.addComponent(lbl_KursWaluty))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmPrzelicznikWalut.getContentPane().setLayout(groupLayout);
	}
	
	protected void przelicz() {
		try {
			BigDecimal kwota = new BigDecimal(txtKwota.getText());
			String kod = "" + comboBox_Waluta.getSelectedItem();
			Waluta waluta = tabela.znajdz(kod);
			BigDecimal wynik = null;
			if(rdbtnWalutaNaZlote.isSelected()) {
				wynik = waluta.przeliczNaZlote(kwota);
			}
			if(rdbtnZloteNaWalute.isSelected()) {
				wynik = waluta.przeliczNaWalute(kwota);
			}
			lblPrawdziwyWynik.setText("" + wynik);
			lblPrawdziwyWynik.setForeground(Color.BLUE);
		} catch (Exception e) {
			lblPrawdziwyWynik.setText("błąd");
			lblPrawdziwyWynik.setForeground(Color.RED);
		}		
	}

	protected void wyswietlDaneWaluty() {
		String kod = "" + comboBox_Waluta.getSelectedItem();
		Waluta waluta = tabela.znajdz(kod);
		if(waluta != null) {
			lbl_KodWaluty.setText(waluta.getKod());
			lbl_NazwaWaluty.setText(waluta.getNazwa());
			lbl_KursWaluty.setText("" + waluta.getKurs());
			if(! txtKwota.getText().isEmpty()) {
				przelicz();
			}
			return;
		}
		lblPrawdziwyWynik.setText("0.00");
		lblPrawdziwyWynik.setForeground(Color.GRAY);
	}

	private void pobierzAktualneKursy() {
		// Pobieranie aktualnych kursów w tle (to znaczy w innym wątku)
		// Aby wykonać operację w tle, w Swingu najlepiej użyć klasy SwingWorker
		
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				tabela = ObslugaNBP.pobierzBiezaceKursy();
				return null;
			}
			
			protected void done() {
				// tu piszemy "co ma zrobić okno, gdy operacja jest zakończona"
				// to będzie wykonane przez wątek EDT
				odswiezDaneTabeli();
				wyswietlDaneWaluty();
			}
		};
		
		worker.execute();
	}

	private void pobierzKursyDlaDaty() {
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() throws Exception {
				
				String data = txtData.getText();
				Tabela nowaTabela = ObslugaNBP.pobierzKursyHistoryczne(data);
				if(nowaTabela != null) {
					tabela = nowaTabela;
					SwingUtilities.invokeLater(() -> {
						txtData.setForeground(Color.BLACK);
					});
				} else {
					SwingUtilities.invokeLater(() -> {
						txtData.setForeground(Color.RED);
					});
				}
				return null;
			}
			
			protected void done() {
				odswiezDaneTabeli();
				wyswietlDaneWaluty();
			}
		};
		
		worker.execute();
	}

	private void odswiezDaneTabeli() {
		lbl_NumerTabeli.setText(tabela.getNumerTabeli());
		lbl_DataTabeli.setText("" + tabela.getData());
		comboBox_Waluta.setModel(new DefaultComboBoxModel<>(tabela.getKodyWalut()));
	}
}