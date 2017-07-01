<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="/TimeApp/theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>TimeApp Date Format Preference</TITLE>
</HEAD>
<BODY>
<jsp:useBean class="com.wsbook.casestudy.util.Formatter" id="formatter" scope="session"/>
<CENTER>
<FORM action="/TimeApp/SetDateFormat.do" method="POST">
<TABLE width="80%">
    <TBODY>
        <TR>
            <TD colspan="2" align="center">
            <H1>Set Date Format</H1>
            </TD>
        </TR>
        <TR>
            <TD align="right">Select desired date format</TD>
            <TD><%--METADATA type="DynamicData" startspan
<SELECT name="dateString" loopproperty="formatter.formatters[]" itemproperty="formatter.formatters[].displayFormat" valueproperty="formatter.formatters[].displayFormat" dynamicelement></SELECT>
--%><%
try {
  com.wsbook.casestudy.util.Formatter[] _a0 = formatter.getFormatters();
  com.wsbook.casestudy.util.Formatter _p0 = _a0[0]; // throws an exception if empty.
  %><SELECT name="dateString"><%
    for (int _i0 = 0; ; ) { %>
      <OPTION value="<%= _p0.getDisplayFormat() %>"><%= _p0.getDisplayFormat() %></OPTION><%
      _i0++;
      try {
        _p0 = _a0[_i0];
      }
      catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
        break;
      }
    } %></SELECT><%
}
catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
} %><%--METADATA type="DynamicData" endspan--%></TD>
        </TR>
        <TR>
            <TD colspan="2" align="right"><INPUT type="submit" name="selectFormat" value="Set Format"></TD>
        </TR>
    </TBODY>
</TABLE>
</FORM>
</CENTER>
</BODY>
</HTML>
