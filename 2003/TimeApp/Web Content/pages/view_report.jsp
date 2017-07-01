<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="/TimeApp/theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>view_report.jsp</TITLE>
</HEAD>
<%@taglib uri="http://www.wsbook.com/taglib" prefix="timeApp"%>
<BODY>
<jsp:useBean id="report" class="com.wsbook.casestudy.value.Report" scope="request"/>
<jsp:useBean class="com.wsbook.casestudy.util.Formatter" id="formatter" scope="session"/>
<%--METADATA type="DynamicData" startspan
<TABLE innerloopproperty="report.collections[]" innerloopdirection="vertical" innerloopstartindex="1" innerloopendindex="2" dynamicelement width="80%">
    <COL span="2" width="50%">
    <TBODY>
        <TR bgcolor="#ff80c0">
            <TD colspan="2" align="center">
            <H1>Generated Report</H1>
            </TD>
        </TR>
        <TR bgcolor="#80ffff">
            <TD><H2><WSPX:PROPERTY property="report.collections[].category"></H2>
            
            </TD>
            <TD align="right">Total Hours: <WSPX:PROPERTY property="report.collections[].totalHours"></TD>
        </TR>
        <TR>
            <TD colspan="2">
            <TABLE border="1" innerloopproperty="report.collections[].records[]" innerloopdirection="vertical" innerloopstartindex="0" innerloopendindex="0" dynamicelement width="100%">
                <COL span="2" width="50%">
                <TBODY>
                    <TR bgcolor="#ffff80">
                        <TD align="right" nowrap><WSPX:PROPERTY property="report.collections[].records[].label"></TD>
                        <TD align="right"><WSPX:PROPERTY property="report.collections[].records[].hours"></TD>
                    </TR>
                </TBODY>
            </TABLE>
            </TD>
        </TR>
    </TBODY>
</TABLE>
--%><%
try {
  com.wsbook.casestudy.value.ReportCollection[] _a0 = report.getCollections();
  com.wsbook.casestudy.value.ReportCollection _p0 = _a0[0]; // throws an exception if empty. %>
  <TABLE width="80%">
    <COL span="2" width="50%">
    <TBODY>
      <TR bgcolor="#ff80c0">
        <TD align="center" colspan="2">
            
          <H1>Generated Report</H1>
            </TD>
      </TR><%
      for (int _i0 = 0; ; ) { %>
        <TR bgcolor="#80ffff">
          <TD>
            <H2><%= _p0.getCategory() %></H2>
            
            </TD>
          <TD align="right">Total Hours: <%= _p0.getTotalHours() %></TD>
        </TR>
        <TR>
          <TD colspan="2">
            <%
            try {
              com.wsbook.casestudy.value.ReportRecord[] _a1 = _p0.getRecords();
              com.wsbook.casestudy.value.ReportRecord _p1 = _a1[0]; // throws an exception if empty. %>
              <TABLE border="1" width="100%">
                <COL span="2" width="50%">
                <TBODY><%
                  for (int _i1 = 0; ; ) { %>
                    <TR bgcolor="#ffff80">
                      <TD align="right" nowrap><%= _p1.getLabel() %></TD>
                      <TD align="right"><%= _p1.getHours() %></TD>
                    </TR><%
                    _i1++;
                    try {
                      _p1 = _a1[_i1];
                    }
                    catch (java.lang.ArrayIndexOutOfBoundsException _e1) {
                      break;
                    }
                  } %>
                </TBODY>
              </TABLE><%
            }
            catch (java.lang.ArrayIndexOutOfBoundsException _e1) {
            }
            %>
            </TD>
        </TR><%
        _i0++;
        try {
          _p0 = _a0[_i0];
        }
        catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
          break;
        }
      } %>
    </TBODY>
  </TABLE><%
}
catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
} %><%--METADATA type="DynamicData" endspan--%>
<P></P>
<TABLE width="80%">
    <TBODY>
        <TR>
            <TD><A href="/TimeApp/index.html"><IMG src="/TimeApp/images/HomeButton.gif" width="113" height="30" border="0"></A></TD>
            <TD align="right">Active Date Format: <%--METADATA type="DynamicData" startspan
<WSPX:PROPERTY property="formatter.displayFormat">
--%><%= formatter.getDisplayFormat() %><%--METADATA type="DynamicData" endspan--%></TD>
            <TD><A href="/TimeApp/pages/setdatepreference.jsp"><IMG src="/TimeApp/images/ChangeDateFormatButton.gif" width="202" height="30" border="0"></A></TD>
        </TR>
        <TR>
            <TD></TD>
            <TD></TD>
            <TD></TD>
        </TR>
    </TBODY>
</TABLE>
</BODY>
</HTML>
