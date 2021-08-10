<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html" encoding="utf-8"/>
	
	<xsl:template match="/">
		<html>
			<head>
				<style type="text/css">
					<xsl:call-template name="css"/>
				</style>
			</head>
			<body><xsl:apply-templates/></body>
		</html>
	</xsl:template>
	
	<xsl:template match="ogloszenie">
		<div class="ogloszenie">
			<h2>
				<xsl:apply-templates select="marka"/>
				<xsl:text> </xsl:text>
				<xsl:apply-templates select="model"/>
				<xsl:text> </xsl:text>
				<xsl:apply-templates select="generacja"/>
			</h2>
			<p>Rocznik: <b><xsl:value-of select="rocznik"/></b></p>
			<p><b><xsl:value-of select="cena"/></b></p>
			<p class="tytul"><xsl:apply-templates select="opis"/></p>
			<xsl:call-template name="silnik" />
			<xsl:apply-templates select="sprzedawca" />			
		</div>
	</xsl:template>

	<xsl:template name="silnik">
		<div>
			Silnik: <b><xsl:value-of select="pojemnosc"/></b>
			<xsl:text> </xsl:text>
			<b><xsl:value-of select="moc"/></b>
			(<xsl:value-of select="paliwo"/>)
		</div>
	</xsl:template>

	<xsl:template match="sprzedawca">
		<div>
			<h3>Sprzedawca</h3>
			<p><xsl:value-of select="nazwa"/></p>
			<p><xsl:value-of select="adres/ulica"/></p>
			<p><xsl:value-of select="adres/kod-pocztowy"/>
				<xsl:text> </xsl:text>
				<xsl:value-of select="adres/miasto"/>
			</p>
			<p>Kontakt: <xsl:value-of select="telefon"/>
			<xsl:text> </xsl:text>
			<xsl:value-of select="email"/></p>
		</div>
	</xsl:template>
	
	<xsl:template name="css"><![CDATA[
	
	body {
		background-color: #FFFFDD;
	}
	
	.ogloszenie {
		border: outset 4px #FF4488;
		padding: 0.5em;
		margin: 1em;
		background-color: #EEFFFF;
		
	}
	]]>
	</xsl:template>
</xsl:stylesheet>