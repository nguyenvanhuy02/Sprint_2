import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DanhSachComponent} from './component/danh-sach/danh-sach.component';
import {ThemMoiComponent} from './component/them-moi/them-moi.component';
import {MuonComponent} from './component/muon/muon.component';

const routes: Routes = [
  {path: 'ccdc', component: DanhSachComponent},
  {path: 'themmoi', component: ThemMoiComponent},
  {path: 'muon', component: MuonComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
