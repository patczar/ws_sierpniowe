package waluty.wersja_xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import waluty.wersja_xml.Waluta;

class WalutaTest {

	@Test
	void testToString() {
		Waluta usd = new Waluta("USD", "dolar amerykański", new BigDecimal("4.0000"));
		assertEquals("dolar amerykański (USD): 4.0000", usd.toString());
	}

	@Test
	void testPrzeliczNaZlote() {
		Waluta usd = new Waluta("USD", "dolar amerykański", new BigDecimal("4.0000"));
		BigDecimal kwota = new BigDecimal("1000.00");
		BigDecimal wynik = usd.przeliczNaZlote(kwota);
		BigDecimal oczekiwanyWynik = new BigDecimal("4000.00");

		assertEquals(oczekiwanyWynik, wynik);
	}

	@Test
	void testPrzeliczNaZlote2() {
		Waluta euro = new Waluta("EUR", "euro", new BigDecimal("4.3333"));
		BigDecimal kwota = new BigDecimal("2.00");
		BigDecimal wynik = euro.przeliczNaZlote(kwota);
		BigDecimal oczekiwanyWynik = new BigDecimal("8.67");

		assertEquals(oczekiwanyWynik, wynik);
	}

	@Test
	void testPrzeliczNaWalute() {
		Waluta usd = new Waluta("USD", "dolar amerykański", new BigDecimal("4.0000"));
		BigDecimal kwota = new BigDecimal("4000.00");
		BigDecimal wynik = usd.przeliczNaWalute(kwota);
		BigDecimal oczekiwanyWynik = new BigDecimal("1000.00");

		assertEquals(oczekiwanyWynik, wynik);
	}

	@Test
	void testPrzeliczNaWaluteZaokraglanie() {
		Waluta trzy = new Waluta("TRI", "waluta trzy", new BigDecimal("3.0000"));
		BigDecimal kwota = new BigDecimal("2000.00");
		BigDecimal wynik = trzy.przeliczNaWalute(kwota);
		BigDecimal oczekiwanyWynik = new BigDecimal("666.67");

		assertEquals(oczekiwanyWynik, wynik);
	}
}
