<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:param name="data" select="'2017-07-03'"/>

	<xsl:output method="xml" indent="yes"/>

	<xsl:template match="/">
		<xsl:copy-of select="/ArrayOfExchangeRatesTable/ExchangeRatesTable[EffectiveDate=$data]"/>
	</xsl:template>
</xsl:stylesheet>