<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="data" select="'2017-07-03'"/>

	<xsl:output method="xml" ident="yes"/>

	<xsl:template match="ExchangeRatesTable[EffectiveDate != $data]">
		<!-- celowo pusty wynik - aby pominąć te tabele, których data się nie zgadza -->
	</xsl:template>

	<!-- standard copy template -->
	<xsl:template match="@*|node()">
		<xsl:copy>
			<!-- copy to płyta kopia - kopiuje węzły tekstowe, komentarze itp. wraz z tekstem,
				ale dla elementów tworzy w wyniku element o takiej samej nazwie, ale bez zawartości -->
				
			<!-- w środku określamy zawartość, jaka ma się pojawić w skopiowanym elemencie -->
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates/>
		</xsl:copy>
	</xsl:template>	
</xsl:stylesheet>