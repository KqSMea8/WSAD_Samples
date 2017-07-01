package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import com.ibm.ws.rsadapter.exceptions.DataStoreAdapterException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * TimeSheetEJBBeanFunctionSet_9e979f5e
 */
public class TimeSheetEJBBeanFunctionSet_9e979f5e extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection,"INSERT INTO TIMESHEETEJB (TIMESHEETID, WEEKEND, STATE1, SUBMITTER_EMPID, APPROVER_EMPID) VALUES (?, ?, ?, ?, ?)");

			// For column WEEKEND
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column STATE1
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column TIMESHEETID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SUBMITTER_EMPID
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column APPROVER_EMPID
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
			pstmt = prepareStatement(connection,"DELETE FROM TIMESHEETEJB  WHERE TIMESHEETID = ?");

			// For column TIMESHEETID
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
			pstmt = prepareStatement(connection,"UPDATE TIMESHEETEJB  SET WEEKEND = ?, STATE1 = ?, SUBMITTER_EMPID = ?, APPROVER_EMPID = ? WHERE TIMESHEETID = ?");

			// For column WEEKEND
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column STATE1
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column TIMESHEETID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column SUBMITTER_EMPID
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column APPROVER_EMPID
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
			pstmt = prepareStatement(connection,"UPDATE TIMESHEETEJB  SET WEEKEND = ?, STATE1 = ?, SUBMITTER_EMPID = ?, APPROVER_EMPID = ? WHERE TIMESHEETID = ?");

			// For column WEEKEND
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column STATE1
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column TIMESHEETID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column SUBMITTER_EMPID
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column APPROVER_EMPID
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
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
	 * FindPendingByEmployee
	 */
	public javax.resource.cci.Record FindPendingByEmployee(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from TimeSheetEJB o where (o.state = 'PENDING') AND (o.submitter.empId = ?1) */
			pstmt = prepareStatement(connection,"select  q1.\"WEEKEND\",  q1.\"STATE1\",  q1.\"TIMESHEETID\",  q1.\"SUBMITTER_EMPID\",  q1.\"APPROVER_EMPID\" from TIMESHEETEJB q1, EMPLOYEEEJB q2 where  ( q1.\"STATE1\" = \'PENDING\')  and  ( q2.\"EMPID\" = ?)  and  ( q2.\"EMPID\" =  q1.\"SUBMITTER_EMPID\")");

			// For ?1 (empId)
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
	 * FindApprovedTimesheetsByApprover
	 */
	public javax.resource.cci.Record FindApprovedTimesheetsByApprover(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from TimeSheetEJB o where o.approver.empId = ?1 */
			pstmt = prepareStatement(connection,"select  q1.\"WEEKEND\",  q1.\"STATE1\",  q1.\"TIMESHEETID\",  q1.\"SUBMITTER_EMPID\",  q1.\"APPROVER_EMPID\" from TIMESHEETEJB q1, EMPLOYEEEJB q2 where  ( q2.\"EMPID\" = ?)  and  ( q2.\"EMPID\" =  q1.\"APPROVER_EMPID\")");

			// For ?1 (inKey)
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
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection,"SELECT T1.WEEKEND, T1.STATE1, T1.TIMESHEETID, T1.SUBMITTER_EMPID, T1.APPROVER_EMPID FROM TIMESHEETEJB  T1 WHERE T1.TIMESHEETID = ?");

			// For column TIMESHEETID
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
			pstmt = prepareStatement(connection,"SELECT T1.WEEKEND, T1.STATE1, T1.TIMESHEETID, T1.SUBMITTER_EMPID, T1.APPROVER_EMPID FROM TIMESHEETEJB  T1 WHERE T1.TIMESHEETID = ? FOR UPDATE  OF WEEKEND");

			// For column TIMESHEETID
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
	 * FindByPrimaryKeyWithReadAhead
	 */
	public javax.resource.cci.Record FindByPrimaryKeyWithReadAhead(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			// Read ahead path: entries
			pstmt = prepareStatement(connection,"SELECT A1.WEEKEND, A1.STATE1, A1.TIMESHEETID, A1.SUBMITTER_EMPID, A1.APPROVER_EMPID, A2.DATE1, A2.HOURS1, A2.ENTRYID, A2.TIMESHEET_TIMESHEETID, A2.PROJECT_PROJNUMBER FROM TIMESHEETEJB  A1 LEFT OUTER JOIN TIMESHEETENTRYEJB  A2 ON A1.TIMESHEETID = A2.TIMESHEET_TIMESHEETID WHERE A1.TIMESHEETID = ?");

			// For column TIMESHEETID
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
	 * FindAll
	 */
	public javax.resource.cci.Record FindAll(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from TimeSheetEJB o */
			pstmt = prepareStatement(connection,"select  q1.\"WEEKEND\",  q1.\"STATE1\",  q1.\"TIMESHEETID\",  q1.\"SUBMITTER_EMPID\",  q1.\"APPROVER_EMPID\" from TIMESHEETEJB q1");

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
			/* select object(o) from TimeSheetEJB o */
			pstmt = prepareStatement(connection,"select  q1.\"WEEKEND\",  q1.\"STATE1\",  q1.\"TIMESHEETID\",  q1.\"SUBMITTER_EMPID\",  q1.\"APPROVER_EMPID\" from TIMESHEETEJB q1 for update of \"WEEKEND\"");

			result = pstmt.executeQuery();

		}
		catch (SQLException e) {
			throw new DataStoreAdapterException("DSA_ERROR", e ,this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	/**
	 * FindTimesheetsBySubmitter
	 */
	public javax.resource.cci.Record FindTimesheetsBySubmitter(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from TimeSheetEJB o where o.submitter.empId = ?1 */
			pstmt = prepareStatement(connection,"select  q1.\"WEEKEND\",  q1.\"STATE1\",  q1.\"TIMESHEETID\",  q1.\"SUBMITTER_EMPID\",  q1.\"APPROVER_EMPID\" from TIMESHEETEJB q1, EMPLOYEEEJB q2 where  ( q2.\"EMPID\" = ?)  and  ( q2.\"EMPID\" =  q1.\"SUBMITTER_EMPID\")");

			// For ?1 (inKey)
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
	 * findTimesheetsBySubmitterKey_Local
	 */
	public javax.resource.cci.Record findTimesheetsBySubmitterKey_Local(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection,"SELECT T1.WEEKEND, T1.STATE1, T1.TIMESHEETID, T1.SUBMITTER_EMPID, T1.APPROVER_EMPID FROM TIMESHEETEJB  T1 WHERE T1.SUBMITTER_EMPID = ?");

			// For column SUBMITTER_EMPID
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
	 * findTimesheetsBySubmitterKey_LocalForUpdate
	 */
	public javax.resource.cci.Record findTimesheetsBySubmitterKey_LocalForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection,"SELECT T1.WEEKEND, T1.STATE1, T1.TIMESHEETID, T1.SUBMITTER_EMPID, T1.APPROVER_EMPID FROM TIMESHEETEJB  T1 WHERE T1.SUBMITTER_EMPID = ? FOR UPDATE  OF WEEKEND");

			// For column SUBMITTER_EMPID
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
	 * findApprovedTimesheetsByApproverKey_Local
	 */
	public javax.resource.cci.Record findApprovedTimesheetsByApproverKey_Local(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection,"SELECT T1.WEEKEND, T1.STATE1, T1.TIMESHEETID, T1.SUBMITTER_EMPID, T1.APPROVER_EMPID FROM TIMESHEETEJB  T1 WHERE T1.APPROVER_EMPID = ?");

			// For column APPROVER_EMPID
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
	 * findApprovedTimesheetsByApproverKey_LocalForUpdate
	 */
	public javax.resource.cci.Record findApprovedTimesheetsByApproverKey_LocalForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws DataStoreAdapterException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection,"SELECT T1.WEEKEND, T1.STATE1, T1.TIMESHEETID, T1.SUBMITTER_EMPID, T1.APPROVER_EMPID FROM TIMESHEETEJB  T1 WHERE T1.APPROVER_EMPID = ? FOR UPDATE  OF WEEKEND");

			// For column APPROVER_EMPID
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
	 * TimeSheetEJBBeanFunctionSet_9e979f5e
	 */
	public TimeSheetEJBBeanFunctionSet_9e979f5e() {
		functionHash=new java.util.HashMap(16);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindPendingByEmployee",new Integer(4));
		functionHash.put("FindApprovedTimesheetsByApprover",new Integer(5));
		functionHash.put("FindByPrimaryKey",new Integer(6));
		functionHash.put("FindByPrimaryKey444Update",new Integer(7));
		functionHash.put("FindByPrimaryKeyWithReadAhead",new Integer(8));
		functionHash.put("FindAll",new Integer(9));
		functionHash.put("FindAllForUpdate",new Integer(10));
		functionHash.put("FindTimesheetsBySubmitter",new Integer(11));
		functionHash.put("findTimesheetsBySubmitterKey_Local",new Integer(12));
		functionHash.put("findTimesheetsBySubmitterKey_LocalForUpdate",new Integer(13));
		functionHash.put("findApprovedTimesheetsByApproverKey_Local",new Integer(14));
		functionHash.put("findApprovedTimesheetsByApproverKey_LocalForUpdate",new Integer(15));
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
			outputRecord=FindPendingByEmployee(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindApprovedTimesheetsByApprover(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindByPrimaryKeyWithReadAhead(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindAll(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindAllForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindTimesheetsBySubmitter(inputRecord,connection,interactionSpec);
			break;
		case 12:
			outputRecord=findTimesheetsBySubmitterKey_Local(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=findTimesheetsBySubmitterKey_LocalForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 14:
			outputRecord=findApprovedTimesheetsByApproverKey_Local(inputRecord,connection,interactionSpec);
			break;
		case 15:
			outputRecord=findApprovedTimesheetsByApproverKey_LocalForUpdate(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
}
