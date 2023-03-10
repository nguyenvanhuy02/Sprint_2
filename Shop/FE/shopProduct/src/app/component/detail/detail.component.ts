import {Component, OnInit} from '@angular/core';
import {Clothes} from '../../model/product/clothes';
import {ClothesService} from '../../service/product/clothes.service';
import {ActivatedRoute} from '@angular/router';
import {Title} from '@angular/platform-browser';
import {User} from '../../model/user/user';
import {TokenService} from '../../service/security/token.service';
import {ToastrService} from 'ngx-toastr';
import {FormBuilder, FormGroup} from '@angular/forms';
import {OrderService} from '../../service/order/order.service';
import {OrderDetail} from '../../model/order/order-detail';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  // @ts-ignore
  id: number;
  // @ts-ignore
  clothesDetail: Clothes;
  // @ts-ignore
  user: User;
  // @ts-ignore
  orderForm: FormGroup;
  // @ts-ignore
  orderDetail: OrderDetail[];
  urlShow: string | undefined;
  quality = 1;

  constructor(private clothesService: ClothesService,
              private tokenService: TokenService,
              private activatedRoute: ActivatedRoute,
              private orderService: OrderService,
              private formBuilder: FormBuilder,
              private toast: ToastrService,
              private titleService: Title) {
    // this.titleService.setTitle('Xem Chi Tiết Sản Phẩm');
    this.activatedRoute.paramMap.subscribe(data => {
      const id = data.get('id');
      if (id != null) {
        this.detailById(+id);
      }
    });
  }

  ngOnInit(): void {
    this.detailById(this.activatedRoute.snapshot.params.id);
  }

  // tslint:disable-next-line:typedef
  detailById(id: number) {
    this.clothesService.detailClothes(id).subscribe(
      data => {
        console.log(data);
        this.clothesDetail = data;
        // @ts-ignore
        this.urlShow = this.clothesDetail.images[0].url;
      }
    );
  }

  // tslint:disable-next-line:typedef
  getFormOrder(clothes: any, quantity: any, user: User) {
    this.orderForm = this.formBuilder.group({
      user: [user.id],
      quantity: [quantity],
      clothes: [clothes]
    });
  }

  // tslint:disable-next-line:typedef
  add(id: any, quantity: any) {
    this.user = JSON.parse(this.tokenService.getUser());
    if (this.user == null) {
      this.toast.error('Bạn cần phải đăng nhập để đặt hàng');
    }
    this.getFormOrder(id, quantity, this.user);
    this.orderService.addOrder(this.orderForm.value).subscribe(data => {
      this.toast.success('Đặt hàng thành công');
    });
  }

  // tslint:disable-next-line:typedef
  changeImg(url: string) {
    this.urlShow = url;
  }

  // tslint:disable-next-line:typedef
  minus(quality: number) {
    if (this.quality > 1) {
      this.quality -= 1;
    }
  }
  // tslint:disable-next-line:typedef
  plus(quality: number) {
    this.quality += 1;
  }
}
