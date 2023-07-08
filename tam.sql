use charonbus
create TABLE `TaiXe` (
	`MaTaiXe` int AUTO_INCREMENT PRIMARY KEY,
    `TenTaiXe` varchar(30) NOT NULL,
    `SDTtx` varchar(10) NOT NULL CHECK (REGEXP_LIKE(SDTtx,'[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'))
);
create TABLE `Xe` (
	`MaXe` int  AUTO_INCREMENT PRIMARY KEY,
    `BienSoXe` varchar(20) NOT NULL
);
create TABLE `Chang` (
	`MaChang` varchar(4) NOT NULL PRIMARY KEY CHECK (REGEXP_LIKE(MaChang,'CH[0-9][0-9]')),
    `GaDi` varchar(10) NOT NULL,
    `GaDen` varchar(10) NOT NULL,
    `Gia` int
);
create TABLE `KhachHang` (
	`SDT` varchar(10) NOT NULL PRIMARY KEY CHECK(REGEXP_LIKE(SDT,'[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')),
    `Ten` varchar(30),
	`DiaChi` varchar(50)
);
create TABLE `Ve`(
	`MaVe` int  AUTO_INCREMENT PRIMARY KEY,
    `SDT` varchar(10) NOT NULL CHECK(REGEXP_LIKE(SDT,'[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')),
    FOREIGN KEY (SDT) REFERENCES KhachHang(SDT)
);
create TABLE `Chuyen`(
	`MaChuyen` int  AUTO_INCREMENT PRIMARY KEY,
    `NgayGio` datetime NOT NULL,
    `MaXe` int,
    `MaTaiXe` int,
    `DaXoa` int,
    FOREIGN KEY (MaTaiXe) REFERENCES TaiXe(MaTaiXe),
    FOREIGN KEY (MaXe) REFERENCES Xe(MaXe)
);
create TABLE `SoGhe` (
    `MaChuyen` int,
    `SoGhe` int,
    `MaVe` int,
    `MaChang` varchar(4) CHECK (REGEXP_LIKE(MaChang,'CH[0-9][0-9]')),
    `TrangThai` int,
    PRIMARY KEY(MaChuyen,SoGhe,MaChang),
    FOREIGN KEY (MaVe) REFERENCES Ve(MaVe),
    FOREIGN KEY (MaChuyen) REFERENCES Chuyen(MaChuyen),
    FOREIGN KEY (MaChang) REFERENCES Chang(MaChang)
);
create TABLE `NhanVien` (
	`SDT` varchar(10) NOT NULL PRIMARY KEY CHECK(REGEXP_LIKE(SDT,'[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')),
    `Ten` varchar(30),
	`DiaChi` varchar(50)
);
create TABLE `NhanSu` (
	`SDT` varchar(10) NOT NULL PRIMARY KEY CHECK(REGEXP_LIKE(SDT,'[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')),
    `Ten` varchar(30),
	`DiaChi` varchar(50),
    `Rol` int 
);
INSERT INTO NhanVien values('0177777777','PHAM THANH TRUNG','TAN PHONG Q7'),
							('0166666666','NGUYEN HONG','TAN QUY Q7');
INSERT INTO NhanSu values('0999999999','VU THE TRUONG','TAN QUY Q7',1),
						 ('0888888888','PHAM THANH NHA','TAY NINH',2);
insert into TaiXe values(null,'NGUYEN VAN TAI','0987654321'),
						(null,'TRAN VAN TAM','0981265421'),
                        (null,'TRAN VAN CAM','0987665421'),
                        (null,'LE VAN GIAO','0987665661');
insert into Xe values	(null,'AGHVBJ45'),
						(null,'GVBJKN29');
INSERT INTO Chang values('CH01','TPHCM','DaLat',300000),
						('CH02','TPHCM','BaoLoc',200000),
                        ('CH03','BaoLoc','DaLat',100000),
                        ('CH04','DaLat','TPHCM',300000),
                        ('CH05','DaLat','BaoLoc',100000),
                        ('CH06','BaoLoc','TPHCM',200000);
INSERT INTO KhachHang values('0123456789','VU THE TRUONG','TAN PHONG Q7'),
							('0222222222','TRAN QUOC NAM','TAN QUY Q7');
                            
INSERT INTO KhachHang values('0222222130','THAI',NULL);
INSERT INTO Ve values	('1','0222222222'),
						('2','0222222222'),
                        ('3','0222222222'),
                        ('4','0123456789');

select SoGhe, MaChang, TrangThai, MaChuyen, MaVe from SoGhe


delete
from Chuyen
where MaChuyen>=0

ALTER TABLE Chuyen AUTO_INCREMENT = 0

delete
from TaiXe
where MaTaiXe>=5

ALTER TABLE TaiXe AUTO_INCREMENT = 5

delete
from Xe
where MaXe>=3

ALTER TABLE Xe AUTO_INCREMENT = 3

delete    
from SoGhe
where MaChuyen>=0


SELECT SoGhe, MaChang, TrangThai, MaChuyen, MaVe FROM SoGhe
LIMIT 24 OFFSET 48;



SELECT column_name, column_type, column_default, is_nullable, column_comment, create_time
FROM information_schema.COLUMNS
WHERE table_name = 'Ve' AND table_schema = 'charonbus'
ORDER BY create_time DESC

