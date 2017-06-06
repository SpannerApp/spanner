IF OBJECT_ID('dbo.SP_CREATE_USER') IS NOT NULL
    DROP PROCEDURE SP_CREATE_USER
GO

CREATE PROCEDURE SP_CREATE_USER

    @Login NVARCHAR(50),
    @Password NVARCHAR(50),
    @EmployeeID INT,
    @RoleID INT,
    @UserID INT OUTPUT
AS
  BEGIN

    IF EXISTS(SELECT * FROM AuthUser WHERE Login = @Login)
      BEGIN
        SET @UserID = -1
        RETURN @UserID
      END

    INSERT INTO AuthUser (Login, Password, EmployeeID, RoleID)  VALUES (@Login, @Password, @EmployeeID, @RoleID)
    SET @UserID = @@IDENTITY
  END
GO
