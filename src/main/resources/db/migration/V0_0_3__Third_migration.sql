IF OBJECT_ID('dbo.Machine', 'U') IS NOT NULL
  DROP TABLE dbo.Machine;

CREATE TABLE dbo.Machine
(
  MachineID INT PRIMARY KEY NOT NULL IDENTITY,
  Code NVARCHAR(50) NOT NULL,
  Name NVARCHAR(50) NOT NULL,
  Model NVARCHAR(50) NOT NULL,
  Section NVARCHAR(50) NOT NULL,
  Colour NVARCHAR(50) NOT NULL,
  LastRepair DATE NOT NULL,
  LastServiceman NVARCHAR(50) NOT NULL,
);
GO

INSERT INTO dbo.Machine VALUES ('1885/EXT', 'Klopboormachine', 'BOSH_PBH2100SRE','Production','Green','2005-03-12','Owca');
INSERT INTO dbo.Machine VALUES ('1410/GRU', 'spot welder', 'ZG-15','Service','Red','1999-6-22','Zabek');
INSERT INTO dbo.Machine VALUES ('1792/MAJ', 'Bosh', 'GWS 850','Production','Blue','2016-1-12','Owca');
GO