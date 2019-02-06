CREATE TABLE [dbo].[Voucher](
    [Id] Bigint IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[Code] nvarchar(100) NOT NULL,
    [VoucherType] NVARCHAR (50)NOT NULL,
    [StartDate] Date ,
	[ExpirationDate] Date NOT NULL,
    [Status] nvarchar(20) NOT NULL,
    [Prefix] nvarchar(20) NOT NULL,
    [Postfix]nvarchar(20)NOT NULL,
	[Charset]nvarchar(20) NOT NULL,
    [Length] int NOT NULL,
	-- [NumuberOfCodeToGenerate] int NOT NULL,
	[Category] NVARCHAR (100),
	[AdditionalInfo] NVARCHAR (255),
	MerchantId BIGINT
)

CREATE TABLE [dbo].[Gift](
    [Id] Bigint IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[VoucherId] Bigint NOT NULL foreign key references Voucher(id),
    [Value] DECIMAL(18,2) NOT NULL,
    [Balance] DECIMAL(18,2),
	[AmountUsed] DECIMAL(18,2),
)
-- CREATE TABLE [dbo].[DiscountType](
--     [Id] Bigint IDENTITY(1,1) PRIMARY KEY NOT NULL,
-- 	[Name] [nvarchar](24) NOT NULL,

-- )
Drop table Discount
GO

CREATE TABLE [dbo].[Discount](
    [Id] Bigint IDENTITY(1,1) PRIMARY KEY NOT NULL,
    [VoucherId] Bigint Not NULL foreign key references Voucher(id),
    [DiscountType] nvarchar (50),
	-- [IsPercent] BIT NOT NULL,
	[DiscountValue] DECIMAL (18,2)
)

DROP TABLE Value
CREATE TABLE [dbo].[Value](

    [Id] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
    [VoucherId] Bigint NOT NULL FOREIGN KEY REFERENCES Voucher(Id),
    [Amount] DECIMAL(18,2) NOT NULL
)
GO

-- ==============================================================================================
-- ============================ Stored Procedures for Creating Vouchers  ========================
-- ==============================================================================================
drop PROCEDURE CreateDiscountVoucher
Go
CREATE PROCEDURE [dbo].[CreateDiscountVoucher]
@code varchar(100),
@startDate date,
@expirationDate date,
@Status varchar(20),
@prefix nvarchar(20),
@postfix nvarchar(20),
@Charset nvarchar(20),
@Length int,
@VoucherType NVARCHAR(50),
@Category NVARCHAR(100),
@AdditionalInfo NVARCHAR (255),
@MerchantId BIGINT,
@DiscountValue decimal(13,2)= Null,
@discountType varchar(10)
AS
DECLARE @id int =Null
DECLARE @VoucherId int = 0


	SELECT @VoucherId = Id FROM Voucher where Code = @code

	if(@VoucherId = 0)
			insert into voucher(code, StartDate,ExpirationDate,[status],Prefix,Postfix,Charset,[Length],VoucherType,Category,AdditionalInfo,MerchantId)
			Values(@code,@startdate,@expirationDate,@status,@prefix,@postfix,@Charset,@Length,@VoucherType,@Category,@AdditionalInfo,@MerchantId)
			select @VoucherId = SCOPE_IDENTITY()
			insert into discount (DiscountValue,voucherid,DiscountType) Values( @DiscountValue, @VoucherId, @discountType)
GO

Commit

GO

-- ======================================================================================================================================================
DROP PROCEDURE CreateGiftVoucher
go

CREATE PROCEDURE [dbo].[CreateGiftVoucher]
@code varchar(100),
@startDate date,
@expirationDate date,
@Status varchar(20),
@prefix nvarchar(20),
@postfix nvarchar(20),
@Charset nvarchar(20),
@Length int,
@VoucherType NVARCHAR(50),
@Category NVARCHAR(100),
@AdditionalInfo NVARCHAR (255),
@MerchantId BIGINT,
@Value DECIMAL(18,2)
-- @Balance DECIMAL(18,2),
-- @AmountUsed DECIMAL(18,2)
AS
DECLARE @id int =Null
DECLARE @VoucherId int = 0


	SELECT @VoucherId = Id FROM Voucher where Code = @code

	if(@VoucherId = 0)
			insert into voucher(code, StartDate,ExpirationDate,[status],Prefix,Postfix,Charset,[Length],VoucherType,Category,AdditionalInfo,MerchantId)
			Values(@code,@startdate,@expirationDate,@status,@prefix,@postfix,@Charset,@Length,@VoucherType,@Category,@AdditionalInfo,@MerchantId)
			select @VoucherId = SCOPE_IDENTITY()
			insert into Gift ([Value],voucherid) Values( @Value, @VoucherId)
GO

Commit
GO

-- ========================================================================================================================================================

CREATE PROCEDURE [dbo].[CreateValueVoucher]
@code varchar(100),
@startDate date,
@expirationDate date,
@Status varchar(20),
@prefix nvarchar(20),
@postfix nvarchar(20),
@Charset nvarchar(20),
@Length int,
@VoucherType NVARCHAR(50),
@Category NVARCHAR(100),
@AdditionalInfo NVARCHAR (255),
@MerchantId BIGINT,
@Amount DECIMAL(18,2)
AS
DECLARE @id int =Null
DECLARE @VoucherId int = 0


	SELECT @VoucherId = Id FROM Voucher where Code = @code

	if(@VoucherId = 0)
			insert into voucher(code, StartDate,ExpirationDate,[status],Prefix,Postfix,Charset,[Length],VoucherType,Category,AdditionalInfo,MerchantId)
			Values(@code,@startdate,@expirationDate,@status,@prefix,@postfix,@Charset,@Length,@VoucherType,@Category,@AdditionalInfo,@MerchantId)
			select @VoucherId = SCOPE_IDENTITY()
			insert into [Value] (Amount,voucherid) Values( @Amount, @VoucherId)
GO

Commit

GO

-- ==============================================================================================
-- ===============================        Updating Voucher        ===============================
-- ==============================================================================================

CREATE PROCEDURE [dbo].[UpdateCreateValueVoucher]

@startDate date,
@expirationDate date,
@Status varchar(20),
@prefix nvarchar(20),
@postfix nvarchar(20),
@Charset nvarchar(20),
@Category NVARCHAR(100),
@AdditionalInfo NVARCHAR (255),
@Amount DECIMAL(18,2),
@id BIGINT

AS
	SET NOCOUNT ON
	UPDATE [dbo].[Voucher]
	SET
		[StartDate] = @StartDate,
		[ExpirationDate] = @expirationDate,
		[Status] = @Status,
		[prefix] = @prefix,
		[postfix] = @postfix,
		[Charset] = @Charset,
		[Category] = @Category,
		[AdditionalInfo] = @AdditionalInfo
	UPDATE [Value]
	SET
		[Amount] = @Amount
	WHERE id = @id
	SELECT @id = SCOPE_IDENTITY()
    RETURN @@Error
GO

CREATE PROCEDURE [dbo].[UpdateDiscountVoucher]

@startDate date,
@expirationDate date,
@Status varchar(20),
@prefix nvarchar(20),
@postfix nvarchar(20),
@Category NVARCHAR(100),
@AdditionalInfo NVARCHAR (255),
@DiscountValue decimal(13,2)= Null,
@discountType varchar(10),
@id BIGINT

AS
	SET NOCOUNT ON
	UPDATE [dbo].[Voucher]
	SET
		[StartDate] = @StartDate,
		[ExpirationDate] = @expirationDate,
		[Status] = @Status,
		[prefix] = @prefix,
		[postfix] = @postfix,
		[Category] = @Category,
		[AdditionalInfo] = @AdditionalInfo
	UPDATE [Discount]
	SET
		[DiscountValue] = @DiscountValue,
		[DiscountType] = @discountType
	WHERE id = @id
	SELECT @id = SCOPE_IDENTITY()
    RETURN @@Error
GO

CREATE PROCEDURE [dbo].[UpdateGiftVoucher]

@startDate date,
@expirationDate date,
@Status varchar(20),
@prefix nvarchar(20),
@postfix nvarchar(20),
@Category NVARCHAR(100),
@AdditionalInfo NVARCHAR (255),
@Value DECIMAL(18,2) NOT NULL,
@id BIGINT

AS
	SET NOCOUNT ON
	UPDATE [dbo].[Voucher]
	SET
		[StartDate] = @StartDate,
		[ExpirationDate] = @expirationDate,
		[Status] = @Status,
		[prefix] = @prefix,
		[postfix] = @postfix,
		[Category] = @Category,
		[AdditionalInfo] = @AdditionalInfo
	UPDATE [Gift]
	SET
		[Value] = @Value
	WHERE id = @id
	SELECT @id = SCOPE_IDENTITY()
    RETURN @@Error
GO
--===================================================================================================================
-- ==============================================================================================
-- ===============================        CREATING VIEWS          ===============================
-- ==============================================================================================
Create View [dbo].[Voucher_GiftView]
AS
SELECT v.Id,code,VoucherType,StartDate,ExpirationDate,[status], prefix, postfix, Charset, [Length], Category,AdditionalInfo,
	MerchantId, g.AmountUsed, g.Value, g.Balance, g.VoucherId
	FROM Voucher as v, Gift as G
	WHERE v.Id = G.VoucherId
GO

CREATE VIEW [dbo].[Voucher_ValueView]
AS
SELECT v.Id,code,VoucherType,StartDate,ExpirationDate,[status], prefix, postfix, Charset, [Length],Category,AdditionalInfo,MerchantId,
vv.Amount, vv.VoucherId
	FROM Voucher as v, [Value] as vv
	WHERE v.Id = vv.VoucherId
GO


CREATE VIEW [dbo].[Voucher_DiscountView]
AS
SELECT v.Id,code,VoucherType,StartDate,ExpirationDate,[status], prefix, postfix, Charset, [Length],Category,AdditionalInfo,MerchantId,
d.DiscountType, d.DiscountValue, d.VoucherId
	FROM Voucher as v, Discount as D
	WHERE v.ID = D.VoucherId
GO

-- ==============================================================================================
-- ===============================  Find Voucher By Code          ===============================
-- ==============================================================================================
CREATE PROCEDURE [dbo].[findDiscountVoucherByCode]
(
	@code NVARCHAR (100)
)
AS
	SET NOCOUNT ON
	SELECT * FROM [dbo].[Voucher_DiscountView] WHERE  code = @code
GO

CREATE PROCEDURE [dbo].[findGiftVoucherByCode]
(
	@code NVARCHAR (100)
)
AS
	SET NOCOUNT ON
	SELECT * FROM [dbo].[Voucher_GiftView] WHERE  code = @code
GO

CREATE PROCEDURE [dbo].[findValueVoucherByCode]
(
	@code NVARCHAR (100)
)
AS
	SET NOCOUNT ON
	SELECT * FROM [dbo].[Voucher_DiscountView] WHERE  code = @code
GO
-- ==============================================================================================
-- ===============================     Find Voucher By Code       ===============================
-- ==============================================================================================
