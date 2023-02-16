import { Component, OnInit } from '@angular/core';
import {PageCCDC} from '../../model/pageCCDC';
import {Router} from '@angular/router';
import {CcdcService} from '../../service/ccdc.service';
import {QuanLyCCDC} from '../../model/quanLyCCDC';

@Component({
  selector: 'app-danh-sach',
  templateUrl: './danh-sach.component.html',
  styleUrls: ['./danh-sach.component.css']
})
export class DanhSachComponent implements OnInit {

  danhSachCCDC: PageCCDC | undefined;
  idMuon: number | undefined;

  constructor(private ccdcService: CcdcService,
              private router: Router) { }

  ngOnInit(): void {
    this.findAll(0);
  }

  // tslint:disable-next-line:typedef
  findAll(pageNumber: number) {
    this.ccdcService.findAll(pageNumber).subscribe(
      data => {
        this.danhSachCCDC = data;
      }
    );
  }

  // tslint:disable-next-line:typedef
  gotoPage(pageNumber: number) {
    this.findAll(pageNumber);
  }

  // tslint:disable-next-line:typedef
  getMuonId(id: number) {
    this.idMuon = id;
    console.log(id);
  }

  // tslint:disable-next-line:typedef
  // detail() {
  //   this.ccdcService.detailById(this.idMuon).subscribe(data => {
  //     this.danhSach = data;
  //   });
  // }
}
