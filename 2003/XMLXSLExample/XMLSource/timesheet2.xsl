<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0"
    xmlns:xalan="http://xml.apache.org/xslt">
    
  <xsl:strip-space elements="*" />
  <xsl:output method="html" />
  	<xsl:template match="TimeSheet">
		<H1>Time Sheet</H1>
		<TABLE border="0">
			<TR colspan="2">
				<TD><B>Week Ending:</B><xsl:text>  </xsl:text><xsl:value-of select="@weekEnding"/></TD>		
				<TD></TD>
			</TR>
			<TR>
				<TD><xsl:apply-templates select="Employee"/></TD>
				<TD><xsl:apply-templates select="Summary"/></TD>				
			</TR>
		
		</TABLE>

		<HR/>
		
		<TABLE border="0">
			<TR colspan="2">
				<TD><B>Project Totals</B></TD>		
				<TD></TD>
			</TR>

			<TR>
				<TD><xsl:apply-templates select="Summary/ProjectTotals"/></TD>
				<TD></TD>
			</TR>
		</TABLE>

		<HR/>

		<xsl:apply-templates select="Entries"/>		
	</xsl:template>


	<xsl:template match="Employee">
		<TABLE border="0">
			<TR>
				<TD><B>Employee:</B></TD><TD><xsl:value-of select="@name"/> </TD>
			</TR>
			<TR>
				<TD><B>Department:</B></TD><TD><xsl:value-of select="@deptName"/> </TD>
			</TR>			
		</TABLE>
	</xsl:template>
	
	<xsl:template match="Summary">
		<TABLE border="0">
			<TR>
				<TD><B>Total Hours:</B></TD><TD><xsl:value-of select="@totalHours"/> </TD>				
			</TR>
			<TR>
				<TD><B>Total Overtime Hours:</B></TD><TD><xsl:value-of select="@overTimeHours"/> </TD>
			</TR>
		</TABLE>	
	</xsl:template>


		<xsl:template match="Entries">		
		<TABLE border="1" cellpadding="0" cellspacing="0" width="100%">
			<TR>
				<TH>Date</TH>
				<TH>Hours</TH>
				<TH>Project</TH>
			</TR>

			<xsl:apply-templates select="Entry">
				<xsl:sort data-type="text" order="descending" select="Date"/>
			</xsl:apply-templates>
			
		</TABLE>
	</xsl:template>

	<xsl:template match="Entry">
			<TR>
				<TD><xsl:value-of select="Date"/></TD>
				<TD><xsl:value-of select="Hours"/></TD>
				<TD><xsl:value-of select="Project/@name"/></TD>
			</TR>
	</xsl:template>    
	
	
	<xsl:template match="ProjectTotals">
		<TABLE border="1">
			<TR>
				<TH>Project ID</TH>
				<TH>Name</TH>
				<TH>Hours</TH>
			</TR>
			<xsl:apply-templates select="Project"/>
		</TABLE>	
	</xsl:template>
	
	<xsl:template match="Project">
			<TR>
				<TD><xsl:value-of select="@id"/></TD>
				<TD><xsl:value-of select="@name"/></TD>
				<TD><xsl:value-of select="@totalHours"/></TD>
			</TR>
	</xsl:template>
		
		<!-- Greg -->
</xsl:stylesheet>
