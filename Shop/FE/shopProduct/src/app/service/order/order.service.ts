import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';
import {OrderDetail} from '../../model/order/order-detail';
import {environment} from '../../../environments/environment';
import {OrderClothes} from '../../model/order/order-clothes';
import {Payment} from '../../model/order/payment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  public quantityCount$ = new BehaviorSubject<number>(0);

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

  payment(id: number | undefined, note: string): Observable<Payment> {
    return this.httpClient.get<Payment>(environment.orderUrl + 'payment/' + id + '?note=' + note);
  }

  getHistory(id: number | undefined): Observable<OrderDetail[]> {
    return this.httpClient.get<OrderDetail[]>(environment.orderUrl + 'history/' + id);
  }
}
