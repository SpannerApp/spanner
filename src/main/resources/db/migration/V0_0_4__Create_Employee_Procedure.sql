CREATE PROCEDURE SP_CREATE_EMPLOYEE
    @Name NVARCHAR(50),
    @Surname NVARCHAR(50),
    @PositionID INT,
    @SupervisorID INT,
    @Address NVARCHAR(50),
    @Phone NVARCHAR(50),
    @Mail NVARCHAR(50),
    @EmployeeID INT OUTPUT

AS
  BEGIN
    INSERT INTO ModelEmployee (Name, Surname, PositionID, SupervisorID, Address, Phone, Mail) VALUES (@Name, @Surname, @PositionID, @SupervisorID, @Address, @Phone, @Mail)
    SET @EmployeeID = @@IDENTITY;
  END