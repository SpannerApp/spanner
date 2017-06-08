IF OBJECT_ID('SP_CREATE_EMPLOYEE') IS NOT NULL
  DROP PROCEDURE SP_CREATE_EMPLOYEE
GO

CREATE PROCEDURE SP_CREATE_EMPLOYEE
    @Name NVARCHAR(50),
    @Surname NVARCHAR(50),
    @Address NVARCHAR(50),
    @Phone NVARCHAR(50),
    @Mail NVARCHAR(50),
    @EmployeeID INT OUTPUT

AS
  BEGIN
    INSERT INTO ModelEmployee (Name, Surname, Address, Phone, Mail) VALUES (@Name, @Surname, @Address, @Phone, @Mail)
    SET @EmployeeID = @@IDENTITY;
  END
GO

ALTER TABLE ModelEmployee DROP COLUMN PositionID, SupervisorID;
GO