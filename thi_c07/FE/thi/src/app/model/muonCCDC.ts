import {NhanVien} from './nhanVien';
import {QuanLyCCDC} from './quanLyCCDC';

export interface MuonCCDC {
  id?: number;
  soLuongMuon?: number;
  ngayMuon?: string;
  ngayTra?: string;
  quanLy?: QuanLyCCDC;
  nhanVien?: NhanVien;
}
