INSERT INTO dbo.ModelEmployee VALUES ('Marcin', 'Owczarek', 1, NULL, NULL, NULL, NULL);
GO

UPDATE dbo.AuthUser SET EmployeeID=2 WHERE Login='Owca';
GO