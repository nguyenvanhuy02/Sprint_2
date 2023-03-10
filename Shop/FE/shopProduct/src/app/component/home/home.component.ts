import {Component, OnInit} from '@angular/core';
import {Clothes} from '../../model/product/clothes';
import {ClothesService} from '../../service/product/clothes.service';
import {Router} from '@angular/router';
import {Img} from '../../model/product/img';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  listClothes: Clothes[] = [];
  img: Img[] = [];
  constructor(private clothesService: ClothesService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.clothesService.findAllHome().subscribe(
      data => {
        console.log(data);
        this.listClothes = data;
        if (this.listClothes.length > 0) {
          this.listClothes.forEach(value => {
            if (!value.images) {
              value.images = [{
                id: 1,
                url: 'https://aoxuanhe.com/upload/product/axh-095/ao-so-mi-nam-cong-so-trang-dep.jpg',
                deleteStatus: false
              }];
            }
          });
        }
      }
    );
  }
}
