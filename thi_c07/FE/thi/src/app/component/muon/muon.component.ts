import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {NhanVien} from '../../model/nhanVien';
import {CcdcService} from '../../service/ccdc.service';
import {Router} from '@angular/router';
import {QuanLyCCDC} from '../../model/quanLyCCDC';
import {PageCCDC} from '../../model/pageCCDC';

@Component({
  selector: 'app-muon',
  templateUrl: './muon.component.html',
  styleUrls: ['./muon.component.css']
})
export class MuonComponent implements OnInit {
  rfMuon: FormGroup | undefined;
  nhanVien: NhanVien[] | undefined;
  quanLy: QuanLyCCDC[] | undefined;

  constructor(private muonService: CcdcService,
              private muonBuilder: FormBuilder,
              private router: Router) {
  }

  ngOnInit(): void {
    this.create();
  }

  create(): void {
    this.rfMuon = this.muonBuilder.group({
      soLuongMuon: [''],
      ngayMuon: [''],
      ngayTra: [''],
      nhanVien: [''],
      quanLy: ['']
    });
    this.muonService.quanLy().subscribe(data => {
      this.quanLy = data;
    });
    this.muonService.nhanVien().subscribe(data => {
      this.nhanVien = data;
    });
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    if (this.rfMuon?.valid) {
      this.muonService.muon(this.rfMuon.value).subscribe(
        data => {
          this.router.navigateByUrl('/reader');
        }
      );
    }
  }
}
