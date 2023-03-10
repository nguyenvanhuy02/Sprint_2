import {Component, OnInit} from '@angular/core';
import {OrderDetail} from '../../model/order/order-detail';
import {User} from '../../model/user/user';
import {TokenService} from '../../service/security/token.service';
import {OrderService} from '../../service/order/order.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  // @ts-ignore
  user: User;
  // @ts-ignore
  message: string;
  // @ts-ignore
  history: OrderDetail[];

  constructor(private tokenService: TokenService,
              private orderService: OrderService,
              private toast: ToastrService) {
  }

  ngOnInit(): void {
    this.getHistory();
  }

  // tslint:disable-next-line:typedef
  getHistory() {
    this.user = JSON.parse(this.tokenService.getUser());
    console.log(this.user.id);
    this.orderService.getHistory(this.user.id).subscribe(data => {
      this.history = data;
      console.log(data);
    }, error => {
      this.toast.error('Bạn không có lịch sử thanh toán nào cả');
    });
  }

}
