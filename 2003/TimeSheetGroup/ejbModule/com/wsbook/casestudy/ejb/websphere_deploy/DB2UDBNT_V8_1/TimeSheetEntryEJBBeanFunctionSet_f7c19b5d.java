package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import com.ibm.ws.rsadapter.exceptions.DataStoreAdapterException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * TimeSheetEntryEJBBeanFunctionSet_f7c19b5d
 */
public class TimeSheetEntryEJBBeanFunctionSet_f7c19b5d extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection,"INSERT INTO TIMESHEETENTRYEJB (ENTRYID, DATE1, HOURS1, TIMESHEET_TIMESHEETID, PROJECT_PROJNUMBER) VALUES (?, ?, ?, ?, ?)");

			// For column DATE1
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column HOURS1
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(1);
				if(tempDouble != null)
					pstmt.setDouble(3,tempDouble.doubleValue());
				else
					pstmt.setNull(3,java.sql.Types.DOUBLE);
			}
			// For column ENTRYID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column TIMESHEET_TIMESHEETID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column PROJECT_PROJNUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			if (pstmt.executeUpdate()==0)
				throw new DataStoreAdapterException("DSA_ERROR",new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw new DataStoreAdapterException("DSA_ERROR", e ,this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection,"DELETE FROM TIMESHEETENTRYEJB  WHERE ENTRYID = ?");

			// For column ENTRYID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			if (pstmt.executeUpdate()==0)
				throw new DataStoreAdapterException("DSA_ERROR",new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw new DataStoreAdapterException("DSA_ERROR", e ,this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection,"UPDATE TIMESHEETENTRYEJB  SET DATE1 = ?, HOURS1 = ?, TIMESHEET_TIMESHEETID = ?, PROJECT_PROJNUMBER = ? WHERE ENTRYID = ?");

			// For column DATE1
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column HOURS1
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(1);
				if(tempDouble != null)
					pstmt.setDouble(2,tempDouble.doubleValue());
				else
					pstmt.setNull(2,java.sql.Types.DOUBLE);
			}
			// For column ENTRYID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column TIMESHEET_TIMESHEETID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column PROJECT_PROJNUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			if (pstmt.executeUpdate()==0)
				throw new DataStoreAdapterException("DSA_ERROR",new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw new DataStoreAdapterException("DSA_ERROR", e ,this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection,"UPDATE TIMESHEETENTRYEJB  SET DATE1 = ?, HOURS1 = ?, TIMESHEET_TIMESHEETID = ?, PROJECT_PROJNUMBER = ? WHERE ENTRYID = ? AND HOURS1 = ?");

			// For column DATE1
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column HOURS1
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(1);
				if(tempDouble != null)
					pstmt.setDouble(2,tempDouble.doubleValue());
				else
					pstmt.setNull(2,java.sql.Types.DOUBLE);
			}
			// For column ENTRYID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column TIMESHEET_TIMESHEETID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column PROJECT_PROJNUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column HOURS1
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(1);
				if(tempDouble != null)
					pstmt.setDouble(6,tempDouble.doubleValue());
				else
					pstmt.setNull(6,java.sql.Types.DOUBLE);
			}
			if (pstmt.executeUpdate()==0)
				throw new DataStoreAdapterException("DSA_ERROR",new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw new DataStoreAdapterException("DSA_ERROR", e ,this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	/**
	 * FindAll
	 */
	public javax.resource.cci.Record FindAll(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from TimeSheetEntryEJB o */
			pstmt = prepareStatement(connection,"select  q1.\"DATE1\",  q1.\"HOURS1\",  q1.\"ENTRYID\",  q1.\"TIMESHEET_TIMESHEETID\",  q1.\"PROJECT_PROJNUMBER\" from TIMESHEETENTRYEJB q1");

			result = pstmt.executeQuery();

		}
		catch (SQLException e) {
			throw new DataStoreAdapterException("DSA_ERROR", e ,this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	/**
	 * FindAllForUpdate
	 */
	public javax.resource.cci.Record FindAllForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from TimeSheetEntryEJB o */
			pstmt = prepareStatement(connection,"select  q1.\"DATE1\",  q1.\"HOURS1\",  q1.\"ENTRYID\",  q1.\"TIMESHEET_TIMESHEETID\",  q1.\"PROJECT_PROJNUMBER\" from TIMESHEETENTRYEJB q1 for update of \"DATE1\"");

			result = pstmt.executeQuery();

		}
		catch (SQLException e) {
			throw new DataStoreAdapterException("DSA_ERROR", e ,this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection,"SELECT T1.DATE1, T1.HOURS1, T1.ENTRYID, T1.TIMESHEET_TIMESHEETID, T1.PROJECT_PROJNUMBER FROM TIMESHEETENTRYEJB  T1 WHERE T1.ENTRYID = ?");

			// For column ENTRYID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = pstmt.executeQuery();

		}
		catch (SQLException e) {
			throw new DataStoreAdapterException("DSA_ERROR", e ,this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection,"SELECT T1.DATE1, T1.HOURS1, T1.ENTRYID, T1.TIMESHEET_TIMESHEETID, T1.PROJECT_PROJNUMBER FROM TIMESHEETENTRYEJB  T1 WHERE T1.ENTRYID = ? FOR UPDATE  OF DATE1");

			// For column ENTRYID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = pstmt.executeQuery();

		}
		catch (SQLException e) {
			throw new DataStoreAdapterException("DSA_ERROR", e ,this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	/**
	 * findEntriesByTimesheetKey_Local
	 */
	public javax.resource.cci.Record findEntriesByTimesheetKey_Local(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection,"SELECT T1.DATE1, T1.HOURS1, T1.ENTRYID, T1.TIMESHEET_TIMESHEETID, T1.PROJECT_PROJNUMBER FROM TIMESHEETENTRYEJB  T1 WHERE T1.TIMESHEET_TIMESHEETID = ?");

			// For column TIMESHEET_TIMESHEETID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = pstmt.executeQuery();

		}
		catch (SQLException e) {
			throw new DataStoreAdapterException("DSA_ERROR", e ,this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	/**
	 * findEntriesByTimesheetKey_LocalForUpdate
	 */
	public javax.resource.cci.Record findEntriesByTimesheetKey_LocalForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection,"SELECT T1.DATE1, T1.HOURS1, T1.ENTRYID, T1.TIMESHEET_TIMESHEETID, T1.PROJECT_PROJNUMBER FROM TIMESHEETENTRYEJB  T1 WHERE T1.TIMESHEET_TIMESHEETID = ? FOR UPDATE  OF DATE1");

			// For column TIMESHEET_TIMESHEETID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = pstmt.executeQuery();

		}
		catch (SQLException e) {
			throw new DataStoreAdapterException("DSA_ERROR", e ,this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	/**
	 * findTimesheetentryByProjectKey_Local
	 */
	public javax.resource.cci.Record findTimesheetentryByProjectKey_Local(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection,"SELECT T1.DATE1, T1.HOURS1, T1.ENTRYID, T1.TIMESHEET_TIMESHEETID, T1.PROJECT_PROJNUMBER FROM TIMESHEETENTRYEJB  T1 WHERE T1.PROJECT_PROJNUMBER = ?");

			// For column PROJECT_PROJNUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = pstmt.executeQuery();

		}
		catch (SQLException e) {
			throw new DataStoreAdapterException("DSA_ERROR", e ,this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	/**
	 * findTimesheetentryByProjectKey_LocalForUpdate
	 */
	public javax.resource.cci.Record findTimesheetentryByProjectKey_LocalForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection,"SELECT T1.DATE1, T1.HOURS1, T1.ENTRYID, T1.TIMESHEET_TIMESHEETID, T1.PROJECT_PROJNUMBER FROM TIMESHEETENTRYEJB  T1 WHERE T1.PROJECT_PROJNUMBER = ? FOR UPDATE  OF DATE1");

			// For column PROJECT_PROJNUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = pstmt.executeQuery();

		}
		catch (SQLException e) {
			throw new DataStoreAdapterException("DSA_ERROR", e ,this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	/**
	 * TimeSheetEntryEJBBeanFunctionSet_f7c19b5d
	 */
	public TimeSheetEntryEJBBeanFunctionSet_f7c19b5d() {
		functionHash=new java.util.HashMap(12);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindAll",new Integer(4));
		functionHash.put("FindAllForUpdate",new Integer(5));
		functionHash.put("FindByPrimaryKey",new Integer(6));
		functionHash.put("FindByPrimaryKey444Update",new Integer(7));
		functionHash.put("findEntriesByTimesheetKey_Local",new Integer(8));
		functionHash.put("findEntriesByTimesheetKey_LocalForUpdate",new Integer(9));
		functionHash.put("findTimesheetentryByProjectKey_Local",new Integer(10));
		functionHash.put("findTimesheetentryByProjectKey_LocalForUpdate",new Integer(11));
	}
	/**
	 * execute
	 */
	public Record execute(WSInteractionSpec interactionSpec, IndexedRecord inputRecord, Object connection) throws javax.resource.ResourceException {
		String functionName=interactionSpec.getFunctionName();
		Record outputRecord=null;
		int functionIndex=((Integer)functionHash.get(functionName)).intValue();

		switch (functionIndex) {
		case 0:
			Create(inputRecord,connection,interactionSpec);
			break;
		case 1:
			Remove(inputRecord,connection,interactionSpec);
			break;
		case 2:
			Store(inputRecord,connection,interactionSpec);
			break;
		case 3:
			StoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		case 4:
			outputRecord=FindAll(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindAllForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=findEntriesByTimesheetKey_Local(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=findEntriesByTimesheetKey_LocalForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=findTimesheetentryByProjectKey_Local(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=findTimesheetentryByProjectKey_LocalForUpdate(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
}
