IF OBJECT_ID('dbo.ReportedIssue', 'U') IS NOT NULL
  DROP TABLE ReportedIssue
GO


CREATE TABLE ReportedIssue (
  ReportedIssueID INT PRIMARY KEY NOT NULL IDENTITY,
  DefectedMachineID INT NOT NULL,
  ReportingEmployeeID INT NOT NULL,
  AssignedServicemanID INT,
  IssueStatus NVARCHAR(20) NOT NULL,
  IssueText NVARCHAR(MAX)
)
GO

IF OBJECT_ID('dbo.SP_SAVE_NEW_REPORT') IS NOT NULL
DROP PROCEDURE SP_SAVE_NEW_REPORT
GO

CREATE PROCEDURE SP_SAVE_NEW_REPORT
    @DefectedMachineID INT,
    @ReportingEmployeeID INT,
    @IssueStatus NVARCHAR(20),
    @IssueText NVARCHAR(MAX),
    @ReportedIssueID INT OUTPUT
AS
  BEGIN
    INSERT INTO ReportedIssue(DefectedMachineID, ReportingEmployeeID, AssignedServicemanID, IssueStatus, IssueText) VALUES (@DefectedMachineID, @ReportingEmployeeID, NULL, @IssueStatus, @IssueText);
    SET @ReportedIssueID = @@IDENTITY;
  END
GO