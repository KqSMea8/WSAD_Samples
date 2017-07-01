<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0"
    xmlns:xalan="http://xml.apache.org/xslt">
    
  <xsl:strip-space elements="*" />
  <xsl:output method="html" />
	<xsl:template match="TimeSheet">
		<H1>Time Sheet</H1>
		<TABLE border="0">
			<TR>
				<TD><B>Week Ending:</B></TD><TD><xsl:value-of select="@weekEnding"/> </TD>		
				<TD> </TD>
				<TD> </TD>				
			</TR>
			<TR>
				<TD><B>Employee:</B></TD><TD><xsl:value-of select="Employee/@name"/> </TD>
				<TD>      </TD>				
				<TD><B>Total Hours:</B></TD><TD><xsl:value-of select="Summary/@totalHours"/> </TD>				
			</TR>
			<TR>
				<TD><B>Department:</B></TD><TD><xsl:value-of select="Employee/@deptName"/> </TD>
				<TD> </TD>				
				<TD><B>Total Overtime Hours:</B></TD><TD><xsl:value-of select="Summary/@overTimeHours"/> </TD>
			</TR>
			
		</TABLE>
		
	</xsl:template>
	
</xsl:stylesheet>