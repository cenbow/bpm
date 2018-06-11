drop index ACT_RU_EXECUTION.ACT_IDX_EXEC_BUSKEY;
drop index ACT_RU_TASK.ACT_IDX_TASK_CREATE;
drop index ACT_RU_TASK.ACT_IDX_TASK_ASSIGNEE;
drop index ACT_RU_IDENTITYLINK.ACT_IDX_IDENT_LNK_USER;
drop index ACT_RU_IDENTITYLINK.ACT_IDX_IDENT_LNK_GROUP;
drop index ACT_RU_VARIABLE.ACT_IDX_VARIABLE_TASK_ID;
drop index ACT_RU_EVENT_SUBSCR.ACT_IDX_EVENT_SUBSCR_CONFIG_;
drop index ACT_RU_INCIDENT.ACT_IDX_INC_CONFIGURATION;
drop index ACT_RU_JOB.ACT_IDX_JOB_PROCINST;
drop index ACT_RU_AUTHORIZATION.ACT_UNIQ_AUTH_GROUP;
drop index ACT_RU_AUTHORIZATION.ACT_UNIQ_AUTH_USER;
drop index ACT_RU_VARIABLE.ACT_UNIQ_VARIABLE;
drop index ACT_RU_AUTHORIZATION.ACT_IDX_AUTH_GROUP_ID;

-- new metric milliseconds column
DROP INDEX ACT_RU_METER_LOG.ACT_IDX_METER_LOG_MS;
DROP INDEX ACT_RU_METER_LOG.ACT_IDX_METER_LOG_NAME_MS;
DROP INDEX ACT_RU_METER_LOG.ACT_IDX_METER_LOG_REPORT;

-- old metric timestamp column
DROP INDEX ACT_RU_METER_LOG.ACT_IDX_METER_LOG_TIME;
DROP INDEX ACT_RU_METER_LOG.ACT_IDX_METER_LOG;


-- indexes for concurrency problems - https://app.camunda.com/jira/browse/CAM-1646 --
drop index ACT_RU_EXECUTION.ACT_IDX_EXECUTION_PROC;
drop index ACT_RU_EXECUTION.ACT_IDX_EXECUTION_PARENT;
drop index ACT_RU_EXECUTION.ACT_IDX_EXECUTION_SUPER;
drop index ACT_RU_EXECUTION.ACT_IDX_EXECUTION_PROCINST;
drop index ACT_RU_EVENT_SUBSCR.ACT_IDX_EVENT_SUBSCR_EXEC;
drop index ACT_GE_BYTEARRAY.ACT_IDX_BA_DEPLOYMENT;
drop index ACT_RU_IDENTITYLINK.ACT_IDX_IDENT_LNK_TASK;
drop index ACT_RU_INCIDENT.ACT_IDX_INCIDENT_EXEC;
drop index ACT_RU_INCIDENT.ACT_IDX_INCIDENT_PROCINST;
drop index ACT_RU_INCIDENT.ACT_IDX_INCIDENT_PROC_DEF_ID;
drop index ACT_RU_INCIDENT.ACT_IDX_INCIDENT_CAUSE;
drop index ACT_RU_INCIDENT.ACT_IDX_INCIDENT_ROOT_CAUSE;
drop index ACT_RU_INCIDENT.ACT_IDX_INCIDENT_JOB_DEF;
drop index ACT_RU_JOB.ACT_IDX_JOB_EXCEPTION_STACK;
drop index ACT_RU_VARIABLE.ACT_IDX_VARIABLE_BA;
drop index ACT_RU_VARIABLE.ACT_IDX_VARIABLE_EXEC;
drop index ACT_RU_VARIABLE.ACT_IDX_VARIABLE_PROCINST;
drop index ACT_RU_TASK.ACT_IDX_TASK_EXEC;
drop index ACT_RU_TASK.ACT_IDX_TASK_PROCINST;
drop index ACT_RU_TASK.ACT_IDX_TASK_PROC_DEF_ID;
drop index ACT_RU_AUTHORIZATION.ACT_IDX_AUTH_RESOURCE_ID;
drop index ACT_RU_EXT_TASK.ACT_IDX_EXT_TASK_TOPIC;
drop index ACT_RU_EXT_TASK.ACT_IDX_EXT_TASK_EXEC;


drop index ACT_GE_BYTEARRAY.ACT_IDX_BYTEARRAY_NAME;
drop index ACT_RE_DEPLOYMENT.ACT_IDX_DEPLOYMENT_NAME;
drop index ACT_RU_JOBDEF.ACT_IDX_JOBDEF_PROC_DEF_ID;
drop index ACT_RU_JOB.ACT_IDX_JOB_HANDLER_TYPE;
drop index ACT_RU_EVENT_SUBSCR.ACT_IDX_EVENT_SUBSCR_EVT_NAME;
drop index ACT_RE_PROCDEF.ACT_IDX_PROCDEF_DEPLOYMENT_ID;

drop index ACT_RU_EXT_TASK.ACT_IDX_EXT_TASK_TENANT_ID;
drop index ACT_RU_EXT_TASK.ACT_IDX_EXT_TASK_PRIORITY;
drop index ACT_RU_EXT_TASK.ACT_IDX_EXT_TASK_ERR_DETAILS;
drop index ACT_RU_INCIDENT.ACT_IDX_INC_TENANT_ID;
drop index ACT_RU_JOBDEF.ACT_IDX_JOBDEF_TENANT_ID;
drop index ACT_RU_JOB.ACT_IDX_JOB_TENANT_ID;
drop index ACT_RU_EVENT_SUBSCR.ACT_IDX_EVENT_SUBSCR_TENANT_ID;
drop index ACT_RU_VARIABLE.ACT_IDX_VARIABLE_TENANT_ID;
drop index ACT_RU_TASK.ACT_IDX_TASK_TENANT_ID;
drop index ACT_RU_EXECUTION.ACT_IDX_EXEC_TENANT_ID;
drop index ACT_RE_PROCDEF.ACT_IDX_PROCDEF_TENANT_ID;
drop index ACT_RE_DEPLOYMENT.ACT_IDX_DEPLOYMENT_TENANT_ID;

drop index ACT_RU_JOB.ACT_IDX_JOB_JOB_DEF_ID;
drop index ACT_RU_BATCH.ACT_IDX_BATCH_SEED_JOB_DEF;
drop index ACT_RU_BATCH.ACT_IDX_BATCH_MONITOR_JOB_DEF;
drop index ACT_RU_BATCH.ACT_IDX_BATCH_JOB_DEF;

drop index ACT_RU_JOB.ACT_IDX_JOB_EXECUTION_ID;

alter table ACT_GE_BYTEARRAY
    drop constraint ACT_FK_BYTEARR_DEPL;

alter table ACT_RU_EXECUTION
    drop constraint ACT_FK_EXE_PROCINST;

alter table ACT_RU_EXECUTION
    drop constraint ACT_FK_EXE_PROCDEF;

alter table ACT_RU_EXECUTION
    drop constraint ACT_FK_EXE_PARENT;

alter table ACT_RU_EXECUTION
    drop constraint ACT_FK_EXE_SUPER;

alter table ACT_RU_IDENTITYLINK
    drop constraint ACT_FK_TSKASS_TASK;

alter table ACT_RU_IDENTITYLINK
    drop constraint ACT_FK_ATHRZ_PROCEDEF;

alter table ACT_RU_TASK
	drop constraint ACT_FK_TASK_EXE;

alter table ACT_RU_TASK
	drop constraint ACT_FK_TASK_PROCINST;

alter table ACT_RU_TASK
	drop constraint ACT_FK_TASK_PROCDEF;

alter table ACT_RU_VARIABLE
    drop constraint ACT_FK_VAR_EXE;

alter table ACT_RU_VARIABLE
	drop constraint ACT_FK_VAR_PROCINST;

alter table ACT_RU_VARIABLE
    drop constraint ACT_FK_VAR_BYTEARRAY;

alter table ACT_RU_JOB
    drop constraint ACT_FK_JOB_EXCEPTION;

alter table ACT_RU_EVENT_SUBSCR
    drop constraint ACT_FK_EVENT_EXEC;

alter table ACT_RU_INCIDENT
    drop constraint ACT_FK_INC_EXE;

alter table ACT_RU_INCIDENT
    drop constraint ACT_FK_INC_PROCINST;

alter table ACT_RU_INCIDENT
    drop constraint ACT_FK_INC_PROCDEF;

alter table ACT_RU_INCIDENT
    drop constraint ACT_FK_INC_CAUSE;

alter table ACT_RU_INCIDENT
    drop constraint ACT_FK_INC_RCAUSE;

alter table ACT_RU_INCIDENT
    drop constraint ACT_FK_INC_JOB_DEF;

alter table ACT_RU_EXT_TASK
    drop constraint ACT_FK_EXT_TASK_EXE;

alter table ACT_RU_BATCH
    drop constraint ACT_FK_BATCH_SEED_JOB_DEF;

alter table ACT_RU_BATCH
    drop constraint ACT_FK_BATCH_MONITOR_JOB_DEF;

alter table ACT_RU_BATCH
    drop constraint ACT_FK_BATCH_JOB_DEF;

alter table ACT_RU_EXT_TASK
    drop CONSTRAINT ACT_FK_EXT_TASK_ERROR_DETAILS;

drop index ACT_RU_IDENTITYLINK.ACT_IDX_ATHRZ_PROCEDEF;

drop index ACT_RE_PROCDEF.ACT_IDX_PROCDEF_VER_TAG;

if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_GE_PROPERTY') drop table ACT_GE_PROPERTY;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_GE_BYTEARRAY') drop table ACT_GE_BYTEARRAY;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RE_PROCDEF') drop table ACT_RE_PROCDEF;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RE_DEPLOYMENT') drop table ACT_RE_DEPLOYMENT;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RU_IDENTITYLINK') drop table ACT_RU_IDENTITYLINK;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RU_TASK') drop table ACT_RU_TASK;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RU_VARIABLE') drop table ACT_RU_VARIABLE;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RU_EXECUTION') drop table ACT_RU_EXECUTION;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RU_EVENT_SUBSCR') drop table ACT_RU_EVENT_SUBSCR;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RU_JOB') drop table ACT_RU_JOB;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RU_JOBDEF') drop table ACT_RU_JOBDEF;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RU_INCIDENT') drop table ACT_RU_INCIDENT;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RU_AUTHORIZATION') drop table ACT_RU_AUTHORIZATION;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RU_FILTER') drop table ACT_RU_FILTER;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RU_METER_LOG') drop table ACT_RU_METER_LOG;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RU_EXT_TASK') drop table ACT_RU_EXT_TASK;
if exists (select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'ACT_RU_BATCH') drop table ACT_RU_BATCH;
