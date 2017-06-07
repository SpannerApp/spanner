INSERT INTO dbo.ReportedIssue VALUES (2,12,7,'NEW','After turn on machine can not work in full power, this emergency probably has big priority because all production stop  and waiting for this machine');
INSERT INTO dbo.ReportedIssue VALUES (4,10,5,'ACCEPTED','Comunicate refuel empty ink box is always shown but the ink is full ');
INSERT INTO dbo.ReportedIssue VALUES (7,11,6,'READY','After connect machine it does not work');
INSERT INTO dbo.ReportedIssue VALUES (8,11,6,'READY','When machine starts works the smoke smudge is visible, probably cause is hide in invalid brush');
INSERT INTO dbo.ReportedIssue VALUES (6,3,7,'REJECTED','After turn on nothing happend, TIPS FROM SERVICE: check is your wire rope is on')
GO


UPDATE dbo.Machine SET LastServicemanID = 7 WHERE MachineID = 2;
UPDATE dbo.Machine SET LastServicemanID = 5 WHERE MachineID = 4;
UPDATE dbo.Machine SET LastServicemanID = 6 WHERE MachineID = 7;
UPDATE dbo.Machine SET LastServicemanID = 6 WHERE MachineID = 8;
UPDATE dbo.Machine SET LastServicemanID = 7 WHERE MachineID = 6;
GO