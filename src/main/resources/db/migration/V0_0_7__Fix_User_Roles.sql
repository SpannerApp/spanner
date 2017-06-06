IF OBJECT_ID('dbo.UserRoles', 'U') IS NOT NULL
  DROP TABLE UserRoles
IF OBJECT_ID('dbo.AuthUser', 'U') IS NOT NULL
    DROP TABLE AuthUser
GO

CREATE TABLE dbo.AuthUser
(
  UserID INT PRIMARY KEY NOT NULL IDENTITY,
  Login NVARCHAR(50) NOT NULL,
  Password NVARCHAR(50) NOT NULL,
  EmployeeID INT,
  RoleID INT,
  CONSTRAINT FK_AuthUser_ModelEmployee FOREIGN KEY (EmployeeID) REFERENCES ModelEmployee (EmployeeID),
  CONSTRAINT FK_AuthUser_Roles FOREIGN KEY (RoleID) REFERENCES Roles (RoleID)
);
GO

INSERT INTO dbo.AuthUser VALUES ('Zabek', 'hehehe', 1, 1);
INSERT INTO dbo.AuthUser VALUES ('Owca', 'cococo', 1, 2);
INSERT INTO dbo.AuthUser VALUES ('Miszu', 'gdziegdzie', 1, 3);
GO

INSERT INTO dbo.Roles VALUES ('MANAGER');
GO