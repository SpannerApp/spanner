IF OBJECT_ID('dbo.AuthUser', 'U') IS NOT NULL
  DROP TABLE dbo.AuthUser;
IF OBJECT_ID('dbo.ModelEmployee', 'U') IS NOT NULL
  DROP TABLE dbo.ModelEmployee;

CREATE TABLE dbo.ModelEmployee
(
  EmployeeID INT PRIMARY KEY NOT NULL IDENTITY,
  Name NVARCHAR(50) NOT NULL,
  Surname NVARCHAR(50) NOT NULL,
  PositionID INT,
  SupervisorID INT,
  Address NVARCHAR(50),
  Phone NVARCHAR(20),
  Mail NVARCHAR(50)
);
GO;

INSERT INTO dbo.ModelEmployee VALUES ('Pawel', 'Rymer', 1, NULL, NULL, NULL, NULL);
GO;

CREATE TABLE dbo.AuthUser
(
  UserID INT PRIMARY KEY NOT NULL IDENTITY,
  Login NVARCHAR(50) NOT NULL,
  Password NVARCHAR(50) NOT NULL,
  EmployeeID INT NOT NULL,
  UserTypeID INT,
  CONSTRAINT FK_AuthUser_ModelEmployee FOREIGN KEY (EmployeeID) REFERENCES ModelEmployee (EmployeeID)
);
GO;

INSERT INTO dbo.AuthUser VALUES ('Zabek', 'hehehe', 1, NULL);
INSERT INTO dbo.AuthUser VALUES ('Owca', 'cococo', 1, NULL);
INSERT INTO dbo.AuthUser VALUES ('Miszu', 'gdziegdzie', 1, NULL);
GO;