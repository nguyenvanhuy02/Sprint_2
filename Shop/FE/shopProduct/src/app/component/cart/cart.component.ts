import {Component, OnInit} from '@angular/core';
import {OrderDetail} from '../../model/order/order-detail';
import {TokenService} from '../../service/security/token.service';
import {ToastrService} from 'ngx-toastr';
import {OrderService} from '../../service/order/order.service';
import {User} from '../../model/user/user';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  // @ts-ignore
  cart: OrderDetail[];
  // @ts-ignore
  user: User;
  totalPrice = 0;
  totalQuantity = 0;
  // @ts-ignore
  money: number;


  constructor(
    private tokenService: TokenService,
    private orderService: OrderService,
    private toast: ToastrService
  ) {
  }

  ngOnInit(): void {
    this.getOrder();
  }

  // tslint:disable-next-line:typedef
  getOrder() {
    this.user = JSON.parse(this.tokenService.getUser());
    console.log(this.user.id);
    this.orderService.getCart(this.user.id).subscribe(data => {
      this.cart = data;
      console.log(data);
      for (let i = 0; i < data.length; i++) {
        // @ts-ignore
        // tslint:disable-next-line:radix
        this.totalPrice = this.totalPrice + this.cart[i].quantity * parseInt(this.cart[i].clothes.price);
      }
      for (let i = 0; i < data.length; i++) {
        // @ts-ignore
        // tslint:disable-next-line:radix
        this.totalQuantity = this.totalQuantity + this.cart[i].quantity;
      }
    }, error => {
      this.toast.error('Không có sản phẩm nào trong giỏ hàng');
      this.clear();
    });
  }

  // tslint:disable-next-line:typedef
  total() {
    if (this.cart) {
      this.totalPrice = 0;
      this.totalQuantity = 0;
      this.cart.forEach(value => {
        // @ts-ignore
        this.totalPrice += value.quantity * value.clothes.price;
        // @ts-ignore
        this.totalQuantity += value.quantity;
      });
    } else {
      this.totalPrice = 0;
    }
  }

  // tslint:disable-next-line:typedef
  minus(id: number) {
    // tslint:disable-next-line:prefer-const
    // @ts-ignore
    var quantity = +document.getElementById('quantity' + id).innerHTML;
    if (quantity !== 1) {
      this.orderService.minus(id).subscribe(data => {
        this.totalPrice = 0;
        this.cart.forEach(value => {
          if (value.id === data.id) {
            value.quantity = data.quantity;
          }
        });
        this.total();
        // @ts-ignore
      });
    }
  }

  // tslint:disable-next-line:typedef
  plus(id: number) {
    this.orderService.plus(id).subscribe(data => {
      this.totalPrice = 0;
      this.cart.forEach(value => {
        if (value.id === data.id) {
          value.quantity = data.quantity;
        }
      });
      this.total();
    });
  }

  // tslint:disable-next-line:typedef
  clear() {
    this.cart = [];
    this.totalPrice = 0;
  }
}
