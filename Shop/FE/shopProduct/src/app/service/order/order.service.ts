import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {OrderDetail} from '../../model/order/order-detail';
import {environment} from '../../../environments/environment';
import {OrderClothes} from '../../model/order/order-clothes';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient: HttpClient) {
  }

  getCart(id: number | undefined): Observable<OrderDetail[]> {
    return this.httpClient.get<OrderDetail[]>(environment.orderUrl + 'cart/' + id);
  }

  minus(id: number): Observable<OrderDetail> {
    return this.httpClient.get<OrderDetail>(environment.orderUrl + 'minus/' + id);
  }

  plus(id: number): Observable<OrderDetail> {
    return this.httpClient.get<OrderDetail>(environment.orderUrl + 'plus/' + id);
  }

  addOrder(orderForm: any): Observable<OrderClothes> {
    return this.httpClient.post<OrderClothes>(environment.orderUrl + 'addOrder', orderForm);
  }
}
