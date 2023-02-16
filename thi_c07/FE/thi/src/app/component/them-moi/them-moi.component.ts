import {Component, OnInit} from '@angular/core';
import {CcdcService} from '../../service/ccdc.service';
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {QuanLyCCDC} from '../../model/quanLyCCDC';

@Component({
  selector: 'app-them-moi',
  templateUrl: './them-moi.component.html',
  styleUrls: ['./them-moi.component.css']
})
export class ThemMoiComponent implements OnInit {
  rfCCDC: FormGroup | undefined;

  constructor(private ccdcService: CcdcService,
              private ccdcBuilder: FormBuilder,
              private router: Router) {
  }

  ngOnInit(): void {
    this.create();
  }

  create(): void {
    this.rfCCDC = this.ccdcBuilder.group({
      maCCDC: ['', Validators.required],
      tenCCDC: ['', Validators.required],
      hangSX: ['', Validators.required],
      donVi: ['', Validators.required],
      soLuong: ['', [Validators.required , Validators.pattern('^[1-9]\\d*$')]],
    });
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    if (this.rfCCDC?.valid) {
      this.ccdcService.create(this.rfCCDC.value).subscribe(
        data => {
          this.router.navigateByUrl('/ccdc');
        }
      );
    }
  }
}
