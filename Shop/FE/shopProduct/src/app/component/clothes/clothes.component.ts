import {Component, OnInit} from '@angular/core';
import {PageClothes} from '../../model/product/pageClothes';
import {Router} from '@angular/router';
import {ClothesService} from '../../service/product/clothes.service';

@Component({
  selector: 'app-clothes',
  templateUrl: './clothes.component.html',
  styleUrls: ['./clothes.component.css']
})
export class ClothesComponent implements OnInit {
  // @ts-ignore
  listClothes: PageClothes;

  constructor(private clothesService: ClothesService,
              private router: Router) {
  }

  ngOnInit(): void {
    // this.findAll(0);
    this.clothesService.findAll(0).subscribe(
      data => {
        console.log(data);
        this.listClothes = data;
      }
    );
  }

  // tslint:disable-next-line:typedef
  findAll(pageNumber: number) {
    this.clothesService.findAll(pageNumber).subscribe(
      data => {
        console.log(data);
        this.listClothes = data;
      }
    );
  }


  // tslint:disable-next-line:typedef
  gotoPage(pageNumber: number) {
    this.findAll(pageNumber);
  }



}
