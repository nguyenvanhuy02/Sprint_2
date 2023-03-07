import {Component, OnInit} from '@angular/core';
import {Clothes} from '../../model/product/clothes';
import {ClothesService} from '../../service/product/clothes.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  // @ts-ignore
  listClothes: Clothes[];

  constructor(private clothesService: ClothesService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.findAllHome();
  }

  // tslint:disable-next-line:typedef
  findAllHome() {
    this.clothesService.findAllHome().subscribe(
      data => {
        console.log(data);
        this.listClothes = data;
      }
    );
  }

}
