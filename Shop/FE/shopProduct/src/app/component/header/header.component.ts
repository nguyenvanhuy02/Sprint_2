import {Component, OnInit} from '@angular/core';
import {TokenService} from '../../service/security/token.service';
import {Router} from '@angular/router';
import {User} from '../../model/user/user';
import {ToastrService} from 'ngx-toastr';
import {OrderService} from '../../service/order/order.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  checkLogin = false;
  nameAccount: any;
  // @ts-ignore
  currentUser: User;
  // @ts-ignore
  accountRole: string;

  quantity = 0;


  constructor(
    private tokenService: TokenService,
    private router: Router,
    private toast: ToastrService,
    private orderService: OrderService,
  ) {
  }

  ngOnInit(): void {
    if (this.tokenService.isLogged()) {
      this.checkLogin = true;

      this.currentUser = JSON.parse(this.tokenService.getUser());
      console.log(this.currentUser.id);
      this.nameAccount = this.currentUser.name;

      const roles = this.tokenService.getRole();

      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < roles.length; i++) {
        if (roles[i] === 'ROLE_ADMIN') {
          this.accountRole = 'ROLE_USER';
        }
      }
    }
    this.quantityCount();
  }

// tslint:disable-next-line:typedef
  quantityCount() {
    this.orderService.quantityCount$.subscribe(count => {
      this.quantity = count;
    });
  }

  logOut(): void {
    this.tokenService.logOut();
    this.router.navigateByUrl('').then(() => {
      location.reload();
    });
  }


}
