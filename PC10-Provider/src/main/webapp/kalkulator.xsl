<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:kalk="http://kalkulator.vavatech.pl">
	<xsl:template match="kalk:iadd">
		<kalk:iaddResponse>
			<result>
				<xsl:value-of select="arg1 + arg2"/>
			</result>
		</kalk:iaddResponse>
	</xsl:template>

	<xsl:template match="kalk:isub">
		<kalk:isubResponse>
			<result>
				<xsl:value-of select="arg1 - arg2"/>
			</result>
		</kalk:isubResponse>
	</xsl:template>

	<xsl:template match="kalk:idiv">
		<kalk:idivResponse>
			<quotient>
				<xsl:value-of select="floor(arg1 div arg2)"/>
				<!-- Poprawnie tylko dla dodatnich) -->
			</quotient>
			<rest>
				<xsl:value-of select="arg1 mod arg2"/>
			</rest>
		</kalk:idivResponse>
	</xsl:template>

	<xsl:template match="kalk:fsum">
		<kalk:fsumResponse>
			<result>
				<xsl:value-of select="sum(arg)"/>
			</result>
		</kalk:fsumResponse>
	</xsl:template>

	<xsl:template match="kalk:favg">
		<kalk:favgResponse>
			<result>
				<xsl:value-of select="sum(arg) div count(arg)"/>
			</result>
		</kalk:favgResponse>
	</xsl:template>
</xsl:stylesheet>
