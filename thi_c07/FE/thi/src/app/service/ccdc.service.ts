import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PageCCDC} from '../model/pageCCDC';
import {environment} from '../../environments/environment';
import {QuanLyCCDC} from '../model/quanLyCCDC';
import {MuonCCDC} from '../model/muonCCDC';
import {NhanVien} from '../model/nhanVien';

@Injectable({
  providedIn: 'root'
})
export class CcdcService {

  constructor(private httpClient: HttpClient) {
  }

  findAll(pageNumber: number): Observable<PageCCDC> {
    return this.httpClient.get<PageCCDC>(environment.api_url + '?page=' + pageNumber);
  }
  create(quanLyCCDC: QuanLyCCDC): Observable<QuanLyCCDC> {
    return this.httpClient.post<QuanLyCCDC>(environment.api_url_them, quanLyCCDC);
  }

  detailById(id: number | undefined): Observable<QuanLyCCDC> {
    return this.httpClient.get(environment.api_url_detail + id);
  }

  muon(muonCCDC: MuonCCDC): Observable<MuonCCDC> {
    return this.httpClient.post<MuonCCDC>(environment.api_url_muon, muonCCDC);
  }

  nhanVien(): Observable<NhanVien[]> {
    return this.httpClient.get<NhanVien[]>(environment.api_url_nhanvien);
  }

  quanLy(): Observable<QuanLyCCDC[]> {
    return this.httpClient.get<QuanLyCCDC[]>(environment.api_url_quanly);
  }
}
