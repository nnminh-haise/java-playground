package ICPC.PTIT.D;

/**
 * 3 +, 2 -
 * x - y = z
 *
 * 1 - 2 - 3 + 4 + 5 + 6 = 11
 * 1 + 2 + 3 + 4 - 5 - 6 = -1
 * 6 - 5 - 4 + 3 + 2 + 1 = 3
 * 6 + 5 + 4 + 3 - 2 - 1 = 15
 */

public class D {
}

    /**
     *  SELECt NGAY AS NGAYDAT, NHACC, DATHANG.MANV, HOTENNV = HO + ' ' + TEN, TENVT, SOLUONG, DONGIA, TRIGIA = SOLUONG * DONGIA
     *  FROM DATHANG, NHANVIEN, CTDDH, VATTU
     *  WHERE (MASODDH = 'MDDH04') AND (DATHANG.MASODDH = CTDDH.MASODDH) AND (DATHANG.MANV = NHANVIEN.MANV) AND (CTDDH.MAVT = VATTU.MAVT)
     */
