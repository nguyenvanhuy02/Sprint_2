import {Component, OnInit} from '@angular/core';
import {TokenService} from '../../service/security/token.service';
import {Router} from '@angular/router';
import {User} from '../../model/user/user';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  checkLogin = false;


  constructor(
    private tokenService: TokenService,
    private router: Router,
    private toast: ToastrService,
  ) {
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()){
      this.checkLogin = true;
    }
  }

  logOut(): void {
    this.tokenService.logOut();
    this.router.navigateByUrl('/home').then(() => {
      location.reload();
    });
  }


}
