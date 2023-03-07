import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./component/home/home.component";
import {ClothesComponent} from './component/clothes/clothes.component';
import {LoginComponent} from './security/login/login.component';
import {CartComponent} from './component/cart/cart.component';
import {DetailComponent} from './component/detail/detail.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'clothes', component: ClothesComponent},
  {path: 'login', component: LoginComponent},
  {path: 'cart', component: CartComponent},
  {path: 'detail/:id', component: DetailComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
