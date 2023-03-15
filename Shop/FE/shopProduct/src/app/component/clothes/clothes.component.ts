import {Component, OnInit} from '@angular/core';
import {PageClothes} from '../../model/product/pageClothes';
import {Router} from '@angular/router';
import {ClothesService} from '../../service/product/clothes.service';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-clothes',
  templateUrl: './clothes.component.html',
  styleUrls: ['./clothes.component.css']
})
export class ClothesComponent implements OnInit {
  // @ts-ignore
  listClothes: PageClothes;
  // @ts-ignore
  rfSearch: FormGroup;

  constructor(private clothesService: ClothesService,
              private formBuilder: FormBuilder,
              private router: Router) {
  }

  ngOnInit(): void {
    this.createSearchForm();
    this.findAll(0);
  }

  // tslint:disable-next-line:typedef
  findAll(pageNumber: number) {
    console.log(this.rfSearch.value);
    this.clothesService.findAllSearch(this.rfSearch.value, pageNumber).subscribe(
      data => {
        this.listClothes = data;
        console.log('search nè ' + data);
      }
    );
  }

  // tslint:disable-next-line:typedef
  createSearchForm() {
    this.rfSearch = this.formBuilder.group({
      name: [''],
      gender: [''],
    });
  }

// tslint:disable-next-line:typedef
  setSearch(gender: string) {
    this.rfSearch.setValue({
      name: this.rfSearch.value.name,
      gender,
    });
    console.log('maksdoasd' + this.rfSearch.value.name);
    console.log(this.rfSearch.value);
    this.findAll(0);
  }

  // tslint:disable-next-line:typedef
  gotoPage(pageNumber: number) {
    this.findAll(pageNumber);
  }


}
