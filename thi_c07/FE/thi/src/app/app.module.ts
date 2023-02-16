import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DanhSachComponent } from './component/danh-sach/danh-sach.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ThemMoiComponent } from './component/them-moi/them-moi.component';
import { MuonComponent } from './component/muon/muon.component';

@NgModule({
  declarations: [
    AppComponent,
    DanhSachComponent,
    ThemMoiComponent,
    MuonComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
