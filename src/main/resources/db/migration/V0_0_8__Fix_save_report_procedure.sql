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
    IF NOT (@IssueText = '' AND @IssueText IS NOT NULL)
      BEGIN
        INSERT INTO ReportedIssue(DefectedMachineID, ReportingEmployeeID, AssignedServicemanID, IssueStatus, IssueText) VALUES (@DefectedMachineID, @ReportingEmployeeID, NULL, @IssueStatus, @IssueText);
        SET @ReportedIssueID = @@IDENTITY;
      END
    ELSE
      BEGIN
        SET @ReportedIssueID = -1;
      END
  END
GO