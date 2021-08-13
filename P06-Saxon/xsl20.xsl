<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema">

	<xsl:param name="data-od" select="'2017-07-01'"/>
	<xsl:param name="data-do" select="'2017-08-31'"/>

	<xsl:output method="xml" indent="yes"/>

	<xsl:template match="/">
		<ArrayOfExchangeRatesTable>
			<xsl:copy-of select="/ArrayOfExchangeRatesTable/ExchangeRatesTable
				[xs:date(EffectiveDate) >= xs:date($data-od)
				 and xs:date(EffectiveDate) &lt;= xs:date($data-do)]"/>

		</ArrayOfExchangeRatesTable>
	</xsl:template>
</xsl:stylesheet>