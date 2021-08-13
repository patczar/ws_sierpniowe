<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema">

	<xsl:param name="pozycja-od" select="10"/>
	<xsl:param name="pozycja-do" select="15"/>

	<xsl:output method="xml" indent="yes"/>

	<xsl:template match="/">
		<ArrayOfExchangeRatesTable>
			<xsl:copy-of select="/ArrayOfExchangeRatesTable/ExchangeRatesTable
				[position() >= $pozycja-od and position() &lt;= $pozycja-do]"/>
			
		</ArrayOfExchangeRatesTable>
	</xsl:template>
</xsl:stylesheet>