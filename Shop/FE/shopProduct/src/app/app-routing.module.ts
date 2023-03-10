import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./component/home/home.component";
import {ClothesComponent} from './component/clothes/clothes.component';
import {LoginComponent} from './security/login/login.component';
import {CartComponent} from './component/cart/cart.component';
import {DetailComponent} from './component/detail/detail.component';
import {UserGuard} from './security/guard/user.guard';
import {LoginGuard} from './security/guard/login.guard';
import {PaymentComponent} from './component/payment/payment.component';
import {HistoryComponent} from './component/history/history.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'clothes', component: ClothesComponent},
  {path: 'login', component: LoginComponent, canActivate: [LoginGuard]},
  {path: 'cart', component: CartComponent, canActivate: [UserGuard]},
  {path: 'payment', component: PaymentComponent, canActivate: [UserGuard]},
  {path: 'detail/:id', component: DetailComponent},
  {path: 'history/:id', component: HistoryComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
