IF OBJECT_ID('dbo.Machine', 'U') IS NOT NULL
  DROP TABLE dbo.Machine;
GO

CREATE TABLE dbo.Machine
(
  MachineID INT PRIMARY KEY NOT NULL IDENTITY,
  Code NVARCHAR(50) NOT NULL,
  MachineName NVARCHAR(50) NOT NULL,
  Model NVARCHAR(50) NOT NULL,
  Section NVARCHAR(50) NOT NULL,
  Colour NVARCHAR(50),
  LastRepair DATE NOT NULL,
  LastServicemanID INT,
  Description NVARCHAR(1000),
  CONSTRAINT FK_Machine_ModelEmployee FOREIGN KEY (LastServicemanID) REFERENCES ModelEmployee (EmployeeID)
);
GO

INSERT INTO dbo.Machine VALUES ('1885/EXT', 'Klopboormachine', 'BOSH_PBH2100SRE','Production','Green','2005-03-12', NULL, 'This is plastic 1.75mm extruder with the 0.4mm nozzle from Marketing Departure. If you found it and don''t know what to do, please return it to the room number 3. If it has some issue please raport the issue or return it to the Marketing Deparutre.');
INSERT INTO dbo.Machine VALUES ('1410/GRU', 'spot welder', 'ZG-15','Service','Red','1999-6-22',NULL, 'This is plastic 1.75mm extruder with the 0.4mm nozzle from Marketing Departure. If you found it and don''t know what to do, please return it to the room number 3. If it has some issue please raport the issue or return it to the Marketing Deparutre.');
INSERT INTO dbo.Machine VALUES ('1792/MAJ', 'Bosh', 'GWS 850','Production','Blue','2016-1-12', NULL, 'This is plastic 1.75mm extruder with the 0.4mm nozzle from Marketing Departure. If you found it and don''t know what to do, please return it to the room number 3. If it has some issue please raport the issue or return it to the Marketing Deparutre.');
GO

IF OBJECT_ID('dbo.SP_CREATE_MACHINE') IS NOT NULL
  DROP PROCEDURE SP_CREATE_MACHINE;
GO

CREATE PROCEDURE SP_CREATE_MACHINE
    @Code NVARCHAR(50),
    @MachineName NVARCHAR(50),
    @Model NVARCHAR(50),
    @Section NVARCHAR(50),
    @Colour NVARCHAR(50),
    @LastRepair DATE,
    @LastServicemanID INT,
    @Description NVARCHAR(1000),
    @MachineID INT OUTPUT
AS
  BEGIN
    INSERT INTO Machine (Code, MachineName, Model, Section, Colour, LastRepair, LastServicemanID, Description) VALUES (@Code, @MachineName, @Model, @Section, @Colour, @LastRepair, @LastServicemanID, @Description)
    SET @MachineID = @@IDENTITY
  END
GO